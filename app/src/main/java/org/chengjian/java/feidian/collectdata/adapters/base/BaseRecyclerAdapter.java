package org.chengjian.java.feidian.collectdata.adapters.base;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import org.chengjian.java.feidian.collectdata.shared.ViewUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by StormPhoenix on 17-9-11.
 * StormPhoenix is a intelligent Android developer.
 */

public abstract class BaseRecyclerAdapter<T, VH extends BaseRecyclerAdapter.ViewHolder<T>> extends RecyclerView.Adapter<VH> {
    public Context mContext;
    protected List<T> data = null;

    private int mDuration = 300;
    private Interpolator mInterpolator = new LinearInterpolator();

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(getItemLayoutId(), parent, false);
        return createViewHolder(itemView);
    }

    protected abstract VH createViewHolder(View itemView);

    protected abstract int getItemLayoutId();

    private HashMap<Integer, OnInternalViewClickListener<T>> clickedItem;
    private int mLastPosition = -1;

    public BaseRecyclerAdapter(Context context) {
        this(context, new ArrayList<T>());
    }

    public BaseRecyclerAdapter(Context context, List<T> list) {
        mContext = context;
        data = list;
    }

    public void addAll(List<T> models) {
        this.data.addAll(models);
        notifyDataSetChanged();
//        notifyItemRangeChanged();
    }

    public void add(T model) {
        this.data.add(0, model);
        notifyItemInserted(0);
    }

    public void swap(int srcIndex, int targetIndex) {
        Collections.swap(data, srcIndex, targetIndex);
        notifyItemMoved(srcIndex, targetIndex);
    }

    public void update(T model, int removedIndex, int insertIndex) {
        data.remove(removedIndex);
        data.add(insertIndex, model);
        if (removedIndex == insertIndex) {
            notifyItemChanged(removedIndex);
        } else {
            notifyItemRemoved(removedIndex);
            notifyItemInserted(insertIndex);
        }
    }

    public void update(T model, int removedIndex) {
        update(model, removedIndex, 0);
    }

    public void update(T model) {
        int removedIndex = data.indexOf(model);
        update(model, removedIndex);
    }

    public void remove(T model) {
        int position = data.indexOf(model);
        remove(position);
    }

    public void remove(int index) {
        data.remove(index);
        notifyItemRemoved(index);
    }

    public void setData(List<T> data) {
        this.data.clear();
        this.data.addAll(data);
    }

    public List<T> getData() {
        return data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        if (holder != null) {
            addInternalViewClickListener(holder.itemView, position, data.get(position));
        }
        holder.bind(data.get(position));
    }

    private void addInternalViewClickListener(final View itemView, final Integer position, final T valuesMap) {
        if (clickedItem != null) {
            for (final Integer idKey : clickedItem.keySet()) {
                final View foundView = itemView.findViewById(idKey);
                if (foundView != null && clickedItem.get(idKey) != null) {
                    foundView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clickedItem.get(idKey).onClick(itemView, foundView, position, valuesMap);
                        }
                    });
                    foundView.setOnLongClickListener(new View.OnLongClickListener() {
                        @Override
                        public boolean onLongClick(View v) {
                            return clickedItem.get(idKey).onLongClick(itemView, foundView, position, valuesMap);
                        }
                    });
                }
            }
        }
    }

    public void addOnViewClickListener(Integer key, OnInternalViewClickListener<T> listener) {
        if (clickedItem == null)
            clickedItem = new HashMap<>();
        clickedItem.put(key, listener);
    }

    public void setStartPosition(int start) {
        mLastPosition = start;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public void setInterpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
    }

    protected void animate(VH holder, int position) {
        if (position > mLastPosition) {
            for (Animator anim : getAnimators(holder.itemView)) {
                if (anim == null) {
                    continue;
                }
                anim.setDuration(mDuration);
                anim.setInterpolator(mInterpolator);
                anim.start();
            }
            mLastPosition = position;
        } else {
            ViewUtils.clear(holder.itemView);
        }
    }

    protected Animator[] getAnimators(View itemView) {
        return new Animator[0];
    }

    public interface OnInternalViewClickListener<T> {
        void onClick(View parentV, View v, Integer position,
                     T values);

        boolean onLongClick(View parentV, View v, Integer position,
                            T values);
    }

    public abstract static class ViewHolder<T> extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        protected abstract void bind(T data);
    }
}