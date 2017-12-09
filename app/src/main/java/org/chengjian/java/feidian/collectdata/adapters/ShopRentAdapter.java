package org.chengjian.java.feidian.collectdata.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.model.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.ShopRentActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 *
 */

public class ShopRentAdapter extends BaseRecyclerAdapter<CitySellRent, ShopRentAdapter.ShopRentViewHolder> {


    public ShopRentAdapter(Context context) {
        super(context);
    }

    public ShopRentAdapter(Context context, List<CitySellRent> list) {
        super(context, list);
    }

    @Override
    protected ShopRentViewHolder createViewHolder(View itemView) {
        return new ShopRentViewHolder(itemView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }

    public class ShopRentViewHolder extends BaseRecyclerAdapter.ViewHolder<CitySellRent> {

        TextView reasearchPerson;
        TextView reasearchTime;
        TextView place;
        CardView cardView;

        public ShopRentViewHolder(View itemView) {
            super(itemView);
            reasearchPerson = (TextView) itemView.findViewById(R.id.reasearch_person);
            reasearchTime = (TextView) itemView.findViewById(R.id.reasearch_time);
            place = (TextView) itemView.findViewById(R.id.place);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        @Override
        protected void bind(final CitySellRent data) {
            reasearchPerson.setText(data.getResearcher());
            reasearchTime.setText(data.getResearcherTime());
            if (data.getLandLoacation()==null || data.getLandLoacation().length()<=0) {
                place.setText("未指定宗地位置");
                place.setTextColor(Color.GRAY);
            } else {
                place.setText(data.getLandLoacation());
            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(new StickyMessage(data, false));
                    mContext.startActivity(new Intent(mContext, ShopRentActivity.class));
                }
            });
        }
    }

}
