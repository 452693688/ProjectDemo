package com.framebase.base.ui.activity.test;

import android.os.Bundle;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarSlide;

/**
 * Created by Administrator on 2016/2/7.
 */
public class SlideBarNSVActivity extends ActionBarSlide {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_nested_scroll_view);

    }
}
