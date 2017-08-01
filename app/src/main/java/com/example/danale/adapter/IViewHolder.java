package com.example.danale.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

/**
 * Created by danale on 2017/7/25.
 */

public interface IViewHolder{

    void bindData(List<ViewModel> data, int position);

}
