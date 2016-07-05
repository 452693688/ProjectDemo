package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarSlide;
import com.framebase.base.ui.adapters.PagerItemAdapter;

/**
 * Created by Administrator on 2016/2/7.
 */
public class SlideBarPvActivity extends ActionBarSlide {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar_pager_view);
        ViewPager vp = (ViewPager) findViewById(R.id.pager_view);
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.action_bar_tab_slide);
        setTaView(mTabLayout);
        PagerItemAdapter adapter = new PagerItemAdapter(this, mTabLayout);
        mTabLayout.setVisibility(View.VISIBLE);

        vp.setAdapter(adapter);
        mTabLayout.setupWithViewPager(vp);
        mTabLayout.setTabsFromPagerAdapter(adapter);
        //vp.setOffscreenPageLimit(fragments.size());
    }

    private void setTaView(TabLayout mTabLayout) {
        mTabLayout.setBackgroundColor(0xffffffff);
        mTabLayout.setSelectedTabIndicatorColor(0xff3496E1);
        mTabLayout.setTabTextColors(0xff999999, 0xff33b5e5);
        // mTabLayout.setSelectedTabIndicatorHeight(0);

    }
}
