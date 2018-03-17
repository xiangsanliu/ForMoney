package org.chengjian.java.feidian.collectdata.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import org.chengjian.java.feidian.collectdata.R;
import org.chengjian.java.feidian.collectdata.adapters.base.BaseRecyclerAdapter;
import org.chengjian.java.feidian.collectdata.beans.CommercialHousingForSale;
import org.chengjian.java.feidian.collectdata.beans.message.StickyMessage;
import org.chengjian.java.feidian.collectdata.mvp.ui.activities.CommercialHouseSellActivity;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * Created by StormPhoenix on 17-9-12.
 * StormPhoenix is a intelligent Android developer.
 */

public class CommercialHousingForSaleAdapter extends BaseRecyclerAdapter<CommercialHousingForSale, CommercialHousingForSaleAdapter.CommercialHouseSellViewHolder> {

    @Override
    protected CommercialHouseSellViewHolder createViewHolder(View itemView) {
        return new CommercialHouseSellViewHolder(itemView);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_list;
    }

    public CommercialHousingForSaleAdapter(Context context) {
        super(context);
    }

    public CommercialHousingForSaleAdapter(Context context, List<CommercialHousingForSale> list) {
        super(context, list);
    }

    public class CommercialHouseSellViewHolder extends BaseRecyclerAdapter.ViewHolder<CommercialHousingForSale> {
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
        protected void bind(final CommercialHousingForSale data) {
            reasearchPerson.setText(data.getCommonAttributes().getResearcher());
            reasearchTime.setText(data.getCommonAttributes().getResearcherTime());

            if (data.getCommonAttributes().getLandLoacation() == null ||
                    data.getCommonAttributes().getLandLoacation().length() <= 0) {
                place.setText("未指定宗地位置");
                place.setTextColor(Color.GRAY);
            } else {
                place.setText(data.getCommonAttributes().getLandLoacation());
            }
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(new StickyMessage(data.getCommonAttributes(), false));
                    mContext.startActivity(new Intent(mContext, CommercialHouseSellActivity.class));
                }
            });
        }
    }
}
