package org.chengjian.java.feidian.collectdata.mvp.view.base;

import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.BaseFragment;
import org.chengjian.java.feidian.collectdata.mvp.ui.fragments.base.ListFragment;

/**
 * Created by StormPhoenix on 17-2-25.
 * StormPhoenix is a intelligent Android developer.
 */

public interface MainView extends MessageView {
    ListFragment getCurrentFragment();
}
