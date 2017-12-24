package org.chengjian.java.feidian.collectdata.mvp.ui.activities.base;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.widget.DatePicker;
import android.widget.EditText;

import net.cachapa.expandablelayout.ExpandableLayout;

import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.beans.message.LocationMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.detail.DetailBasePresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.MapActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

/**
 * Created by xiang on 2017/9/22.
 *
 */

public abstract class DetailBaseActivity extends BaseActivity {

    public CitySellRent citySellRent;
    public ViewDataBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    protected abstract void initExpandableLayout();

    protected void changeELState(ExpandableLayout expandableLayout) {
        if (expandableLayout.isExpanded()) {
            expandableLayout.collapse();
        } else {
            expandableLayout.expand();
        }
    }

    public abstract void initSpinner();

    public abstract void getSpinner();

    public void setTime(final EditText editText) {
        Calendar calendar = Calendar.getInstance();
        int year, month, dayOfMonth;
        String dateString = editText.getText().toString();
        if (dateString.length()>0) {
            year = Integer.valueOf(dateString.substring(0, 4));
            dateString = dateString.substring(5);
            month = Integer.valueOf(dateString.substring(0, dateString.indexOf('-')));
            dateString = dateString.substring(dateString.indexOf('-')+1);
            dayOfMonth = Integer.valueOf(dateString);
        } else {
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        }
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month++;
                editText.setText(year+"-"+month+"-"+dayOfMonth);
            }
        }, year, month-1, dayOfMonth);
        dialog.show();
    }

    public abstract void save();

    public void delete() {
        getPresenter().deleteCity(citySellRent.getId());
//        if (aMapLocationClient != null) {
//            aMapLocationClient.stopLocation();
//        }
    }

    public abstract Boolean getIsEditable();

    @Override
    public void onBackPressed() {
        if (getIsEditable()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DetailBaseActivity.super.onBackPressed();
                        }
                    })
                    .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            save();
                        }
                    })
                    .setTitle("提示")
                    .setMessage("是否保存修改后的数据?");
            builder.create().show();
        } else {
            super.onBackPressed();
        }
    }

    public abstract DetailBasePresenter getPresenter();

    public void showDeleteConfirm() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setMessage("确定要删除吗?")
                .setTitle("提示")
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete();
                    }
                });
        builder.create().show();
    }

    public void locate() {
        LocationMessage locationMessage = new LocationMessage(citySellRent.getLongitude(), citySellRent.getLatitude(), citySellRent.getLandLoacation());
        EventBus.getDefault().postSticky(locationMessage);
        startActivityForResult(new Intent(this, MapActivity.class), RESULT_OK);
    }

    public abstract void setSpinnerIsEnable(boolean isEnable);

}
