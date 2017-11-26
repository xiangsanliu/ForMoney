package org.chengjian.java.feidian.collectdata.mvp.ui.fragments;

import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.adapters.base.HouseRentAdapter;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.CommercialHouseSellPresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.HouseRentPresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListWithPresenterFragment;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public class HouseRentFragment extends ListWithPresenterFragment<SellRentModel> {
    ListItemPresenter listItemPresenter;
    @Override
    public ListItemPresenter getListItemPresenter() {
        if (listItemPresenter == null) {
            listItemPresenter = new HouseRentPresenter(getActivity());
        }
        return listItemPresenter;
    }

    @Override
    public BaseRecyclerAdapter<SellRentModel, BaseRecyclerAdapter.ViewHolder<SellRentModel>> getAdapter() {
        mAdapter = new HouseRentAdapter(getActivity());
        return mAdapter;
    }
}
