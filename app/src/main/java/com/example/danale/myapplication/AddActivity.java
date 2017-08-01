package com.example.danale.myapplication;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.method.ScrollingMovementMethod;
import android.transition.TransitionSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.danale.adapter.BaseAdapter;
import com.example.danale.utils.TextUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.R.attr.theme;
import static android.R.attr.width;

/**
 * Created by danale on 2017/7/25.
 */

public class AddActivity extends BaseActivity {

    @BindView(R.id.nest)
    Button btn_add_nest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        unbinder = ButterKnife.bind(this);

        btn_add_nest = (Button) findViewById(R.id.nest);

        btn_add_nest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new AlertDialog.Builder(AddActivity.this).create();

        dialog.show();
        dialog.setContentView(R.layout.introduction);
        Window window = dialog.getWindow();
        Button button;
        TextView tvx;

        if (window != null){
            button = window.findViewById(R.id.intro_sure);
            tvx = window.findViewById(R.id.intro_body);
        } else {
            button = dialog.getWindow().findViewById(R.id.intro_sure);
            tvx = dialog.getWindow().findViewById(R.id.intro_body);
        }
        tvx.setMovementMethod(ScrollingMovementMethod.getInstance());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddActivity.this, ListActivity.class));
                dialog.dismiss();
            }
        });
            }
        });
    }

//    @OnClick(R.id.nest)
//    void add_nest(){
//        final Dialog dialog = new AlertDialog.Builder(AddActivity.this).create();
//
//        dialog.show();
//        dialog.setContentView(R.layout.introduction);
//        Window window = dialog.getWindow();
//        Button button;
//        TextView tvx;
//        if (window != null){
//            button = window.findViewById(R.id.intro_sure);
//            tvx = window.findViewById(R.id.intro_body);
//        } else {
//            button = dialog.getWindow().findViewById(R.id.intro_sure);
//            tvx = dialog.getWindow().findViewById(R.id.intro_body);
//        }
//        tvx.setMovementMethod(ScrollingMovementMethod.getInstance());
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(AddActivity.this, ListActivity.class));
//                dialog.dismiss();
//            }
//        });;
//    }

}
