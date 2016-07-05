package com.framebase.base.ui.adapters;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framebase.app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/1/12.
 */
public class PagerItemAdapter extends PagerAdapter {
    private ArrayList<View> views = new ArrayList<View>();
    private List<String> titles = new ArrayList<>();

    public PagerItemAdapter() {
    }

    public PagerItemAdapter(Context context, TabLayout mTabLayout) {
        for (int i = 0; i < 4; i++) {
            RecyclerView rv = (RecyclerView) LayoutInflater.from(context).inflate(R.layout.bar_recycler_view, null);
            RecyclerAdapter adapter = new RecyclerAdapter(context);
            rv.setAdapter(adapter);
            rv.setLayoutManager(new LinearLayoutManager(context));
            rv.setItemAnimator(new DefaultItemAnimator());
            rv.setHasFixedSize(true);
            views.add(rv);
            titles.add("" + i);
        }
        if (mTabLayout != null) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(3)));
        }
    }

    public void setData(ArrayList<View> views) {
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = views.get(position);
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = views.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
