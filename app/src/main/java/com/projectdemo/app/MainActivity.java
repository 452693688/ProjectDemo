package com.projectdemo.app;

import android.os.Bundle;
import android.view.View;

import com.framebase.base.ui.activity.TestMainActivity;
import com.framebase.base.ui.activity.base.BaseActivity;
import com.framebase.base.utile.ActivityUtile;
//90
public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.main_tv).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ActivityUtile.startActivity(TestMainActivity.class);
    }
}
