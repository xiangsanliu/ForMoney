package org.chengjian.java.feidian.collectdata.mvp.ui.fragments;

import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.adapters.CommercialHousingForSaleAdapter;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.mvp.presenter.CommercialHousingForSalePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListWithPresenterFragment;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public class CommercialHouseTradeFragment extends ListWithPresenterFragment<CityCommonAttributes> {
    ListItemPresenter listItemPresenter;

    @Override
    public ListItemPresenter getListItemPresenter() {
        if (listItemPresenter == null) {
            listItemPresenter = new CommercialHousingForSalePresenter(getActivity());
        }
        return listItemPresenter;
    }

    @Override
    public BaseRecyclerAdapter<CityCommonAttributes, BaseRecyclerAdapter.ViewHolder<CityCommonAttributes>> getAdapter() {
        mAdapter = new CommercialHousingForSaleAdapter(getActivity());
        // 监听事件也是在这里写的
//        mAdapter.addOnViewClickListener(view 的 id, 监听器);
//        mAdapter.addOnViewClickListener(R.id.);
        return mAdapter;
    }
}
