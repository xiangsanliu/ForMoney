package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.base.FragmentsAdapter;
import org.chengjian.java.feidian.collectdata.beans.CommercialHouseTradeModel;
import org.chengjian.java.feidian.collectdata.mvp.model.LocalDbModel;
import org.chengjian.java.feidian.collectdata.mvp.model.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.MainPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.TabPagerActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.CommercialHouseSellFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.HouseRentFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.HouseSellFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.ShopRentFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.BaseFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListFragment;
import org.chengjian.java.feidian.collectdata.mvp.view.base.MainView;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends TabPagerActivity implements MainView {

    @BindView(R.id.btn_add_item)
    FloatingActionButton btnAddItem;

    private FragmentsAdapter mAdapter;
    private MainPresenter mainPresenter;
    List<BaseFragment> fragmentList;
    private ListFragment currentFragment = null;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenter(this);
        mainPresenter.onAttachView(this);
        mainPresenter.onCreate(savedInstanceState);
        configureTabPager();
    }


    @Override
    protected void setCurrentItem(int position) {
        super.setCurrentItem(position);
        currentFragment = (ListFragment) fragmentList.get(position);
    }

    @Override
    protected FragmentsAdapter createAdapter() {
        String[] titleList = {
                getString(R.string.commercial_house_sell),
                getString(R.string.house_sell),
                getString(R.string.shop_rent),
                getString(R.string.house_rent)
        };
        fragmentList = new ArrayList<>();
        currentFragment = new CommercialHouseSellFragment();
        fragmentList.add(currentFragment);
        fragmentList.add(new HouseSellFragment());
        fragmentList.add(new ShopRentFragment());
        fragmentList.add(new HouseRentFragment());

        mAdapter = new FragmentsAdapter(this.getSupportFragmentManager());
        mAdapter.setFragmentList(fragmentList, titleList);
        return mAdapter;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showMessage(String message) {

    }

    @OnClick(R.id.btn_add_item)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_item:
                mainPresenter.createTable();
                break;
            default:
                break;
        }
    }

    @Override
    public ListFragment getCurrentFragment() {
        return currentFragment;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("resultCode", "return");
        if (currentFragment != null) {
            currentFragment.refreshList();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(ResultMessage resultMessage) {
        currentFragment.refreshList();
    }

}
