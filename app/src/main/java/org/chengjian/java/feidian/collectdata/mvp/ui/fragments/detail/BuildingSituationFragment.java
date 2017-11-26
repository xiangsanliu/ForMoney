package org.chengjian.java.feidian.collectdata.mvp.ui.fragments.detail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuildingSituationFragment extends BaseFragment {


    public BuildingSituationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_building_situation, container, false);
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

}
