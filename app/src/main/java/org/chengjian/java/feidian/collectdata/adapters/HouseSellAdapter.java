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
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.HouseSellActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by xiang on 2017/9/12.
 * 
 */

public class HouseSellAdapter extends BaseRecyclerAdapter<CityCommonAttributes, HouseSellAdapter.HouseSellViewHolder> {

    public HouseSellAdapter(Context context) {
        super(context);
    }

    public HouseSellAdapter(Context context, List<CityCommonAttributes> list) {
        super(context, list);
    }

    @Override
    protected HouseSellViewHolder createViewHolder(View itemView) {
        return new HouseSellViewHolder(itemView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }

    public class HouseSellViewHolder extends BaseRecyclerAdapter.ViewHolder<CityCommonAttributes> {

        TextView reasearchPerson;
        TextView reasearchTime;
        TextView place;
        CardView cardView;

        public HouseSellViewHolder(View itemView) {
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
                    mContext.startActivity(new Intent(mContext, HouseSellActivity.class));
                }
            });
        }
    }


}
