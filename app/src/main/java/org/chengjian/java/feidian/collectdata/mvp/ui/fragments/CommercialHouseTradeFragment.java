package org.chengjian.java.feidian.collectdata.mvp.ui.fragments;

import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.adapters.CommercialHouseTradeAdapter;
import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.presenter.CommercialHouseTradePresenter;
import org.chengjian.java.feidian.collectdata.mvp.presenter.base.ListItemPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListWithPresenterFragment;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public class CommercialHouseTradeFragment extends ListWithPresenterFragment<CitySellRent> {
    ListItemPresenter listItemPresenter;

    @Override
    public ListItemPresenter getListItemPresenter() {
        if (listItemPresenter == null) {
            listItemPresenter = new CommercialHouseTradePresenter(getActivity());
        }
        return listItemPresenter;
    }

    @Override
    public BaseRecyclerAdapter<CitySellRent, BaseRecyclerAdapter.ViewHolder<CitySellRent>> getAdapter() {
        mAdapter = new CommercialHouseTradeAdapter(getActivity());
        // 监听事件也是在这里写的
//        mAdapter.addOnViewClickListener(view 的 id, 监听器);
//        mAdapter.addOnViewClickListener(R.id.);
        return mAdapter;
    }
}
