package org.chengjian.java.feidian.collectdata.adapters.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.beans.CitySellRent;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CommercialHouseSellActivity;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.dataAdder.CommercialHouseTradeActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by StormPhoenix on 17-9-12.
 * StormPhoenix is a intelligent Android developer.
 */

public class CommercialHouseTradeAdapter extends BaseRecyclerAdapter<CitySellRent, CommercialHouseTradeAdapter.CommercialHouseSellViewHolder> {

    @Override
    protected CommercialHouseSellViewHolder createViewHolder(View itemView) {
        return new CommercialHouseSellViewHolder(itemView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }

    public CommercialHouseTradeAdapter(Context context) {
        super(context);
    }

    public CommercialHouseTradeAdapter(Context context, List<CitySellRent> list) {
        super(context, list);
    }

    public class CommercialHouseSellViewHolder extends BaseRecyclerAdapter.ViewHolder<CitySellRent> {
        TextView reasearchPerson;
        TextView reasearchTime;
        TextView place;
        CardView cardView;

        public CommercialHouseSellViewHolder(View itemView) {
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
                    EventBus.getDefault().postSticky(data);
                    mContext.startActivity(new Intent(mContext, CommercialHouseTradeActivity.class));
                }
            });
        }
    }
}
