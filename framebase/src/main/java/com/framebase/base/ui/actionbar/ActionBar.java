package com.framebase.base.ui.actionbar;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;

import com.framebase.app.R;

/**
 * Created by Administrator on 2016/2/7.
 */
public abstract class ActionBar extends BaseLoading {
    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(getView(LayoutInflater.from(this).inflate(layoutResID, null)));
        initView();
    }

    @Override
    public void setContentView(View child) {
        super.setContentView(getView(child));
        initView();
    }

    protected abstract View getView(View child);

    private void closeDrawerLayout(DrawerLayout drawerLayout) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        //drawerLayout.isDrawerOpen(GravityCompat.END)) {
        //drawerLayout.closeDrawer(GravityCompat.END);
    }

    //设置 actionBar的类型
    protected void setTitleStyleType(Toolbar toolbar, int style) {
        if (toolbar == null) {
            return;
        }
        switch (style) {
            case 1:
                View titleView = LayoutInflater.from(this).inflate(R.layout.bar_title_type, null);
                toolbar.addView(titleView);
                setSupportActionBar(toolbar);
                titleView.findViewById(R.id.bar_left_tv).setOnClickListener(this);
                titleView.findViewById(R.id.bar_right_tv).setOnClickListener(this);
                titleView.findViewById(R.id.bar_middle_tv).setOnClickListener(this);
                break;
        }
         
    }


}
