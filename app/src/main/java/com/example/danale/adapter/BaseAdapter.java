package com.example.danale.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.danale.myapplication.R;

import java.util.List;

/**
 * Created by danale on 2017/7/25.
 */

public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> implements IRemoveItem{

    private List<ViewModel> bindData;

    public BaseAdapter(List<ViewModel> bindData){
        this.bindData = bindData;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false), this);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bindData(bindData, position);
    }

    @Override
    public int getItemCount() {
        return bindData == null ? 0:bindData.size();
    }

    @Override
    public void notifyRemove(List<ViewModel> datas, int position) {
        datas.remove(position);
        this.notifyItemRemoved(position);
    }
}
