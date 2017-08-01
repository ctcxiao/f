package com.example.danale.myapplication;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by danale on 2017/7/25.
 */

public class BaseActivity extends AppCompatActivity {

    private LinearLayout layout;

    @BindView(R.id.img_back)
    ImageView img_back;

    Unbinder unbinder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initLayout();
        setContentView(R.layout.base_header);
    }

    @OnClick(R.id.img_back)
    void backPress(){
        onBackPressed();
    }

    private void initLayout() {
        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.removeAllViews();

        View container = getLayoutInflater().inflate(R.layout.activity_base, null);
        layout = container.findViewById(R.id.body);
        root.addView(layout);

    }


    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LayoutInflater.from(this).inflate(layoutResID, layout, true);
    }

    @Override
    public void setContentView(View view) {
        layout.addView(view);
    }


    @Override
    protected void onDestroy() {
        unbinder.unbind();
        super.onDestroy();
    }
}
