package org.chengjian.java.feidian.collectdata.mvp.presenter.detail;

import android.app.Activity;

import org.chengjian.java.feidian.collectdata.FMApplication;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.HouseSalePrice;
import org.chengjian.java.feidian.collectdata.db.DbManager;
import org.chengjian.java.feidian.collectdata.network.HttpResult;
import org.chengjian.java.feidian.collectdata.shared.AppTool;
import org.chengjian.java.feidian.collectdata.shared.JsonParser;
import org.chengjian.java.feidian.collectdata.shared.rx.RxJavaCustomTransformer;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Subscriber;

/**
 * Created by xiang on 2017/12/8.
 */

public class DetailHSPresenter extends DetailBasePresenter<HouseSalePrice> {

    public DetailHSPresenter(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void realLoadModel(Long id) {
        HouseSalePrice model = DbManager.getInstance().queryHouseSalePriceByForeignKey(id);
        view.initModel(model);
    }

    @Override
    public void save(CityCommonAttributes commonAttrs, HouseSalePrice entity) {
        DbManager.getInstance().saveCityCommonAttributes(commonAttrs);
        entity.setCommonAttributes(commonAttrs);
        DbManager.getInstance().saveHouseSalePrice(entity);
    }

    @Override
    public void upload(HouseSalePrice model) {
        progressDialog = createProgress("上传中...");
        progressDialog.show();
        CityCommonAttributes cityAttrs = DbManager.getInstance().queryCityCommonAttributesByKey(model.getForeignKey());

//        String con = JsonParser.getInstance().toJson(cityAttrs);
//        String con2 = JsonParser.getInstance().toJson(model);

        RequestBody cityBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonParser.getInstance().toJson(cityAttrs));
        RequestBody modelBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonParser.getInstance().toJson(model));
        uploadApi.uploadModel("house_sale_price",
                AppTool.getIMEI(FMApplication.getInstance()),
                cityBody,
                modelBody)
                .compose(RxJavaCustomTransformer.<HttpResult<Void>>defaultSchedulers())
                .subscribe(new Subscriber<HttpResult<Void>>() {
                    @Override
                    public void onCompleted() {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }

                    @Override
                    public void onError(Throwable e) {
                        progressDialog.dismiss();
                        progressDialog = null;
                        showToast("出了一个错误，提交失败");
                    }

                    @Override
                    public void onNext(HttpResult<Void> result) {
                        switch (result.getResultCode()) {
                            case 200:
                                // upload success
                                showToast("upload success, local data will all be deleted ... ");
                                DbManager.getInstance().deleteAllHouseSalePrice();
                                break;
                            case 201:
                                // upload failed
                                showToast("It occurred some problems, reply it to us ... ");
                                break;
                            default:
                                break;
                        }
                    }
                });
    }
}
