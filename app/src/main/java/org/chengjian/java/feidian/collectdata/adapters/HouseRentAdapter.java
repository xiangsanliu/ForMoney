package org.chengjian.java.feidian.collectdata.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.CityCommonAttributes;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseRentActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 */

public class HouseRentAdapter extends BaseRecyclerAdapter<CityCommonAttributes, HouseRentAdapter.HouseRentViewHolder> {


    public HouseRentAdapter(Context context) {
        super(context);
    }

    public HouseRentAdapter(Context context, List<CityCommonAttributes> list) {
        super(context, list);
    }

    @Override
    protected HouseRentViewHolder createViewHolder(View itemView) {
        return new HouseRentViewHolder(itemView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }

    public class HouseRentViewHolder extends BaseRecyclerAdapter.ViewHolder<CityCommonAttributes> {

        TextView reasearchPerson;
        TextView reasearchTime;
        TextView place;
        CardView cardView;


        public HouseRentViewHolder(View itemView) {
            super(itemView);

            reasearchPerson = (TextView) itemView.findViewById(R.id.reasearch_person);
            reasearchTime = (TextView) itemView.findViewById(R.id.reasearch_time);
            place = (TextView) itemView.findViewById(R.id.place);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }

        @Override
        protected void bind(final CityCommonAttributes data) {
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
                    mContext.startActivity(new Intent(mContext, HouseRentActivity.class));
                }
            });
        }
    }

}
