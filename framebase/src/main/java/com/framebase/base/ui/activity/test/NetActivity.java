package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;
import com.framebase.base.ui.net.TestManage;

public class NetActivity extends ActionBarFixation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_net);
        findViewById(R.id.net_tv).setOnClickListener(this);
    }

    private TestManage testManage;

    @Override
    protected void onItemClick(int id) {
        super.onItemClick(id);
        if (id ==R.id.net_tv) {
            if (testManage == null) {
                testManage = new TestManage(this);
                testManage.setData("33010047");
            }
            testManage.doRequest();
            return;
        }

    }

    @Override
    protected void callBack(int what, Object obj, String msg) {
        if (TextUtils.isEmpty(msg)) {
            msg = "哈哈：" + what;
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
