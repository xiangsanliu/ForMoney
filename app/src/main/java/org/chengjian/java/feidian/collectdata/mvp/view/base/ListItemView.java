package org.chengjian.java.feidian.collectdata.mvp.view.base;

import org.chengjian.java.feidian.collectdata.mvp.contract.BaseContract;

import java.util.List;

/**
 * Created by StormPhoenix on 17-2-28.
 * StormPhoenix is a intelligent Android developer.
 */
public interface ListItemView<T> extends BaseContract.View {

    void loadNewlyListItem(List<T> listItems);

    int getListItemCounts();

    void loadMoreListItem(List<T> listItems);

    void clearAllItems();
}
