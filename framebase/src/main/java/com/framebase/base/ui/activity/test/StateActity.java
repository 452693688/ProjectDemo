package com.framebase.base.ui.activity.test;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.WindowManager;

import com.framebase.app.R;

/**
 * Created by Administrator on 2016/3/16.
 */
public class StateActity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.BaseActivity_NoActionBar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        setContentView(R.layout.test_state_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.state_toobar);
        toolbar.setTitle("你好");
        setSupportActionBar(toolbar);
    }
}
