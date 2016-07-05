package com.framebase.base.ui.activity.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.framebase.app.R;
import com.framebase.base.net.able.RequestBack;
import com.framebase.base.net.source.AbstractSourceHandler;

public class BaseActivity extends AppCompatActivity implements RequestBack {
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        context.setTheme(R.style.BaseActivity_NoActionBar);

    }

    @Override
    public void OnBack(int what, Object obj, String msg) {
        switch (what) {
            case AbstractSourceHandler.WHAT_LOCALITY_NET_WORK_ERROR:
                break;
            case AbstractSourceHandler.WHAT_DATA_TOKEN_ERROR:
                break;
            case AbstractSourceHandler.WHAT_DATA_ERROR:
                break;

        }
        callBack(what, obj, msg);
    }

    protected void callBack(int what, Object obj, String msg) {
    }

    protected void initView() {
    }

    ;
}
