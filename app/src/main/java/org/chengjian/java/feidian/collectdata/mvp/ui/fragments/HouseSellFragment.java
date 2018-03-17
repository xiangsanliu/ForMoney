package org.chengjian.java.feidian.collectdata.mvp.ui.fragments;

import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.adapters.HouseSalePriceAdapter;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.mvp.presenter.HouseSellPresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListWithPresenterFragment;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public class HouseSellFragment extends ListWithPresenterFragment<CityCommonAttributes> {
    ListItemPresenter listItemPresenter;
    @Override
    public ListItemPresenter getListItemPresenter() {
        if (listItemPresenter == null) {
            listItemPresenter = new HouseSellPresenter(getActivity());
        }
        return listItemPresenter;
    }

    @Override
    public BaseRecyclerAdapter<CityCommonAttributes, BaseRecyclerAdapter.ViewHolder<CityCommonAttributes>> getAdapter() {
        mAdapter = new HouseSalePriceAdapter(getActivity());
        return mAdapter;
    }
}
