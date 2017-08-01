package com.example.danale.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.danale.adapter.BaseAdapter;
import com.example.danale.adapter.ViewModel;
import com.example.danale.view.SwipeItemLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by danale on 2017/7/25.
 */

public class ListActivity extends BaseActivity {

    @BindView(R.id.recy_list)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);
        unbinder = ButterKnife.bind(this);

        List<ViewModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ViewModel());
        }
        BaseAdapter adapter = new BaseAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
    }
}
