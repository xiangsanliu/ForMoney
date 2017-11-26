package org.chengjian.java.feidian.collectdata.mvp.ui.fragments;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.adapters.base.CommercialHouseSellAdapter;
import org.chengjian.java.feidian.collectdata.beans.SellRentModel;
import org.chengjian.java.feidian.collectdata.mvp.presenter.CommercialHouseSellPresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListWithPresenterFragment;

import java.util.ArrayList;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public class CommercialHouseSellFragment extends ListWithPresenterFragment<SellRentModel> {
    ListItemPresenter listItemPresenter;

    @Override
    public ListItemPresenter getListItemPresenter() {
        if (listItemPresenter == null) {
            listItemPresenter = new CommercialHouseSellPresenter(getActivity());
        }
        return listItemPresenter;
    }

    @Override
    public BaseRecyclerAdapter<SellRentModel, BaseRecyclerAdapter.ViewHolder<SellRentModel>> getAdapter() {
        mAdapter = new CommercialHouseSellAdapter(getActivity());
        // 监听事件也是在这里写的
//        mAdapter.addOnViewClickListener(view 的 id, 监听器);
//        mAdapter.addOnViewClickListener(R.id.);
        return mAdapter;
    }
}
