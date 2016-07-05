package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarSlide;
import com.framebase.base.ui.adapters.RecyclerAdapter;

/**
 * Created by Administrator on 2016/2/7.
 */
public class SlideBarRvActivity extends ActionBarSlide {
    @Override
    protected void onCreate(Bundle savedInstanceState) {//
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_recycler_view);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        new RecyclerAdapter(rv);
    }
}
