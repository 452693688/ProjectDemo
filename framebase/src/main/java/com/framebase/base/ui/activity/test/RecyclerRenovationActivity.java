package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;
import com.framebase.base.ui.adapters.RecyclerAdapter;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * 下拉刷新
 * Created by Administrator on 2016/2/2.
 */
public class RecyclerRenovationActivity extends ActionBarFixation implements XRecyclerView.LoadingListener {
    private ArrayList<String> listData;
    private int refreshTime = 0;
    private int times = 0;
    private RecyclerAdapter mAdapter;
    private XRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_xrecycler_view);
        ViewGroup vg = (ViewGroup) getWindow().getDecorView();
        View header = LayoutInflater.from(this).inflate(R.layout.recyclerview_header, vg, false);
        mRecyclerView = (XRecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLaodingMoreProgressStyle(ProgressStyle.SemiCircleSpin);
        mRecyclerView.setArrowImageView(R.mipmap.iconfont_downgrey);
        mRecyclerView.addHeaderView(header);
        mRecyclerView.setLoadingListener(this);
        listData = new ArrayList<String>();
        for (int i = 0; i < 15; i++) {
            listData.add("item" + (i + listData.size()));
        }
        mAdapter = new RecyclerAdapter(this);

        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onRefresh() {
        refreshTime++;
        times = 0;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                listData.clear();
                for (int i = 0; i < 15; i++) {
                    listData.add("item" + i + " after " + refreshTime + " times of refresh");
                }
                mAdapter.notifyDataSetChanged();
                mRecyclerView.refreshComplete();
            }

        }, 1000);
    }

    @Override
    public void onLoadMore() {
        if (times < 2) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    mRecyclerView.loadMoreComplete();
                    for (int i = 0; i < 15; i++) {
                        listData.add("item" + (i + listData.size()));
                    }
                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.refreshComplete();
                }
            }, 1000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {

                    mAdapter.notifyDataSetChanged();
                    mRecyclerView.loadMoreComplete();
                }
            }, 1000);
        }
        times++;
    }
}



