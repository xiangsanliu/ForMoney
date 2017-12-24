package org.chengjian.java.feidian.collectdata.mvp.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.FragmentsAdapter;
import org.chengjian.java.feidian.collectdata.beans.message.ResultMessage;
import org.chengjian.java.feidian.collectdata.mvp.presenter.MainPresenter;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.base.TabPagerActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.CommercialHouseTradeFragment;
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
import butterknife.OnClick;

public class DrawerActivity extends TabPagerActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    @BindView(R.id.btn_add_item)
    FloatingActionButton btnAddItem;




    private FragmentsAdapter mAdapter;
    private MainPresenter mainPresenter;
    List<BaseFragment> fragmentList;
    private ListFragment currentFragment = null;

    @Override
    protected FragmentsAdapter createAdapter() {
        String[] titleList = {
                getString(R.string.commercial_house_sell),
                getString(R.string.house_sell),
                getString(R.string.shop_rent),
                getString(R.string.house_rent)
        };
        fragmentList = new ArrayList<>();
        currentFragment = new CommercialHouseTradeFragment();
        fragmentList.add(currentFragment);
        fragmentList.add(new HouseSellFragment());
        fragmentList.add(new ShopRentFragment());
        fragmentList.add(new HouseRentFragment());

        mAdapter = new FragmentsAdapter(this.getSupportFragmentManager());
        mAdapter.setFragmentList(fragmentList, titleList);
        return mAdapter;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.activity_drawer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter = new MainPresenter(this);
        mainPresenter.onAttachView(this);
        mainPresenter.onCreate(savedInstanceState);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        configureTabPager();


        AndPermission.with(this)
                .requestCode(100)
                .permission(
                        Permission.LOCATION,
                        Permission.STORAGE
                ).start();

//        test();
    }


    @Override
    protected void setCurrentItem(int position) {
        super.setCurrentItem(position);
        currentFragment = (ListFragment) fragmentList.get(position);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.nav_exit:
                finish();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("resultCode", "return");
        if (currentFragment != null) {
            currentFragment.refreshList();
        }
    }

    @Override
    public ListFragment getCurrentFragment() {
        return currentFragment;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onResult(ResultMessage resultMessage) {
        currentFragment.refreshList();
    }

}
