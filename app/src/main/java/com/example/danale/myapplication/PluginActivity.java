package com.example.danale.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PluginActivity extends BaseActivity {

    @BindView(R.id.add_account)
    Button btn_add;


    @BindView(R.id.text_view)
    VideoView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        btn_add = (Button) findViewById(R.id.add_account);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(PluginActivity.this, btn_add, "share_nest");
                    startActivity(new Intent(PluginActivity.this, AddActivity.class), optionsCompat.toBundle());
                } else {
                    startActivity(new Intent(PluginActivity.this, AddActivity.class));
                }
            }
        });

        //  textView.setText("nestmobile://cameras/CjZmWFFfcDhnYzZjYUQwUDdEeTNSREQwamtqSWxaWkZUNk13UXM1UXhhdTRTUzBrcm5OZ09kREESFkctVXp4VFFCbEtPNzdBTVhCM201NWcaNkk3SzFHYk9mbElVaVRjazI0SC1lMDRLZjZOUTJXTzB6djB6S0dnWHVtTTJFSEFzREcxQVFoUQ?auth=465fs4QjfcLK8YvY3uGf88Q661NC3gDl4f-Fft74n9aRc4P2B1BZMioBbi_lOM2sEI4dqRTd8hYZqDFukbQbZRk4PIIS-xO-ONb6H8B5uvI1WlZT1IfkfltvfK3EY5iXxH2Zcn9xIRqkSdwz_LQ5IkoIz2sdtLEP3YaP-cXR1Xm3itcQRBUp2kOeTRzuYqEAf1fdX56fK0cmaU");

        //textView.setText("www.baidu.com");
        textView.setMediaController(new MediaController(this));
        textView.setVideoPath(Environment.getExternalStorageDirectory()+"/"+"test.mp4");
        textView.start();
        textView.requestFocus();


    }


    @OnClick(R.id.add_account)
    void add_account() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(PluginActivity.this, btn_add, "share_nest");
            startActivity(new Intent(PluginActivity.this, AddActivity.class), optionsCompat.toBundle());
        } else {
            startActivity(new Intent(PluginActivity.this, AddActivity.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
