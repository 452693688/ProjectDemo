package com.framebase.base.ui.actionbar;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.framebase.app.R;

/**
 * Created by Administrator on 2016/2/7.
 */
public class ActionBarFixation extends ActionBar {
    @Override
    protected void initView() {
        setToolsbar();
    }

    //设置toolsbar
    protected void setToolsbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.action_bar_toobar);
        setTitleStyleType(toolbar, 1);
    }

    @Override
    protected View getView(View child) {
        View rootView = LayoutInflater.from(this).inflate(R.layout.base_action_bar_fixation, null);
        RelativeLayout count = (RelativeLayout) rootView.findViewById(R.id.action_bar_count_rl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        count.addView(child, layoutParams);
        return rootView;
    }

    @Override
    protected void onItemClick(int id) {

    }

    //------------以下是设置加载-----------//
    private RelativeLayout loadingLayout;
    private boolean haveLoading;

    protected void setLoadingShow() {
        if (haveLoading) {
            return;
        }
        haveLoading = true;
        loadingLayout = (RelativeLayout) findViewById(R.id.base_lodding_rl);
        View lodingView = getLoading();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        loadingLayout.addView(lodingView, layoutParams);
        loadingLayout.setVisibility(View.VISIBLE);
    }

    /*隐藏加载的视图**/
    @Override
    protected void loadingCancelLayout() {
        super.loadingCancelLayout();
        if (loadingLayout == null) {
            return;
        }
        if (loadingLayout.getVisibility() == View.GONE) {
            return;
        }
        loadingLayout.setVisibility(View.GONE);
    }

}
