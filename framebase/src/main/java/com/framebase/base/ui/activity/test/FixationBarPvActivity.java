package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;
import com.framebase.base.ui.adapters.PagerItemAdapter;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/2/7.
 */
public class FixationBarPvActivity extends ActionBarFixation {
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_pager_view);
        ViewPager vp = (ViewPager) findViewById(R.id.pager_view);
         setAdapter(vp);
     }
    private void setAdapter(ViewPager vp) {
        PagerItemAdapter pagerAdapter = new PagerItemAdapter();
        ArrayList<View> views = new ArrayList<View>();
        for (int i = 0; i < 4; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.test_pager_iamge_item, null);
            views.add(view);
        }
        pagerAdapter.setData(views);
        vp.setAdapter(pagerAdapter);
    }
}
