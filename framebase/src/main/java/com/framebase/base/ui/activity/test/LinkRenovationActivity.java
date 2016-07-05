package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framebase.app.R;
import com.framebase.base.ui.activity.base.BaseActivity;

/**
 * Created by Administrator on 2016/2/11.
 */
public class LinkRenovationActivity extends BaseActivity implements View.OnClickListener {
    private TextView topTv;
    private LinearLayout.LayoutParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_link_renovation);
        com.framebase.base.ui.view.Coordinator coordinator= (com.framebase.base.ui.view.Coordinator)findViewById(R.id.coodinator);
        topTv = (TextView) findViewById(R.id.top_tv);
        coordinator.setView(topTv);
        //findViewById(R.id.btn).setOnClickListener(this);
        //AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        //ChangeListener listener = new ChangeListener();
        // appBarLayout.addOnOffsetChangedListener(listener);
        // appBarLayout.setOnTouchListener(listener);
    }

    private int top = -200;

    @Override
    public void onClick(View v) {
        top += 5;
        if (top >= 0) {
            top = 0;
        }
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 200);
        params.setMargins(0, top, 0, 0);
        topTv.setLayoutParams(params);
        if (top == 0) {
            top = -200;
        }
    }

    class ChangeListener implements AppBarLayout.OnOffsetChangedListener {
        private int verticalOffset = -1;

        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            this.verticalOffset = verticalOffset;
            Log.e("verticalOffset:" + verticalOffset, "Y:-------------");

        }


    }
}
