package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;
import com.framebase.base.ui.adapters.RecyclerAdapter;

/**
 * Created by Administrator on 2016/2/7.
 */
public class FixationBarRvActivity extends ActionBarFixation {
    private ActionBarDrawerToggle toggle;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_recycler_view);
        RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_view);
        new RecyclerAdapter(rv);


    }
    @Override
    protected void setToolsbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.action_bar_toobar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawer!=null&&drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
