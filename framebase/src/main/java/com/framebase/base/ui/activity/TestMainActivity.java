package com.framebase.base.ui.activity;

import android.os.Bundle;
import android.view.View;

import com.framebase.app.R;
import com.framebase.base.ui.activity.base.BaseActivity;
import com.framebase.base.ui.activity.test.BehaviorActivity;
import com.framebase.base.ui.activity.test.FixationBarNSVActivity;
import com.framebase.base.ui.activity.test.FixationBarPvActivity;
import com.framebase.base.ui.activity.test.FixationBarRvActivity;
import com.framebase.base.ui.activity.test.InterpolatorActivity;
import com.framebase.base.ui.activity.test.KeyboardActivity;
import com.framebase.base.ui.activity.test.LinkActivity;
import com.framebase.base.ui.activity.test.LinkRenovationActivity;
import com.framebase.base.ui.activity.test.LoadingActivity;
import com.framebase.base.ui.activity.test.MyScrollViewActivity;
import com.framebase.base.ui.activity.test.NetActivity;
import com.framebase.base.ui.activity.test.ObjectAnimatorActivity;
import com.framebase.base.ui.activity.test.RecyclerRenovationActivity;
import com.framebase.base.ui.activity.test.SlideBarNSVActivity;
import com.framebase.base.ui.activity.test.SlideBarPvActivity;
import com.framebase.base.ui.activity.test.SlideBarRvActivity;
import com.framebase.base.ui.activity.test.StateActity;
import com.framebase.base.ui.activity.test.TextViewActivity;
import com.framebase.base.ui.activity.test.ValueAnimatorActivity;
import com.framebase.base.ui.activity.test.WebViewActivity;
import com.framebase.base.utile.ActivityUtile;

/**
 * Created by Administrator on 2016/2/2.
 */
public class TestMainActivity extends BaseActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_main);
        findViewById(R.id.main_fixation_recyclerView_btn).setOnClickListener(this);
        findViewById(R.id.main_fixation_pager_view_btn).setOnClickListener(this);
        findViewById(R.id.main_fixation_nested_scroll_view_btn).setOnClickListener(this);
        findViewById(R.id.main_slide_recyclerView_btn).setOnClickListener(this);
        findViewById(R.id.main_slide_pager_view_btn).setOnClickListener(this);
        findViewById(R.id.main_slide_nested_scroll_view_btn).setOnClickListener(this);
        findViewById(R.id.main_renovation_btn).setOnClickListener(this);
        findViewById(R.id.main_behavior_btn).setOnClickListener(this);
        findViewById(R.id.main_Link_btn).setOnClickListener(this);
        findViewById(R.id.main_sw_btn).setOnClickListener(this);
        findViewById(R.id.main_tv_btn).setOnClickListener(this);
        findViewById(R.id.main_web_btn).setOnClickListener(this);
        findViewById(R.id.main_value_animator_btn).setOnClickListener(this);
        findViewById(R.id.main_interpolator_btn).setOnClickListener(this);
        findViewById(R.id.main_object_animator_btn).setOnClickListener(this);
        findViewById(R.id.main_state_btn).setOnClickListener(this);
        findViewById(R.id.main_keyboard_btn).setOnClickListener(this);
//-------------------main_state_btn

        findViewById(R.id.main_slide_btn).setOnClickListener(this);
        findViewById(R.id.main_net_btn).setOnClickListener(this);
        findViewById(R.id.main_loading_btn).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.main_fixation_recyclerView_btn) {
            //固定bar的recyclerView
            ActivityUtile.startActivity(FixationBarRvActivity.class);
            return;
        }
        if (id == R.id.main_fixation_pager_view_btn) {
            //固定bar的ViewPager
            ActivityUtile.startActivity(FixationBarPvActivity.class);
            return;
        }
        if (id == R.id.main_fixation_nested_scroll_view_btn) {
            //固定bar的NestedScrollView
            ActivityUtile.startActivity(FixationBarNSVActivity.class);
            return;
        }

        if (id == R.id.main_slide_recyclerView_btn) {
            //滑动bar的recyclerView
            ActivityUtile.startActivity(SlideBarRvActivity.class);
            return;
        }
        if (id == R.id.main_slide_pager_view_btn) {
            //滑动bar的ViewPager
            ActivityUtile.startActivity(SlideBarPvActivity.class);
            return;
        }
        if (id == R.id.main_slide_nested_scroll_view_btn) {
            //滑动bar的NestedScrollView
            ActivityUtile.startActivity(SlideBarNSVActivity.class);
            return;
        }

        if (id == R.id.main_slide_btn) {
            ActivityUtile.startActivity(LinkRenovationActivity.class);
            return;
        }
        if (id == R.id.main_net_btn) {
            //网络
            ActivityUtile.startActivity(NetActivity.class);
            return;
        }
        if (id == R.id.main_loading_btn) {
            //加载
            ActivityUtile.startActivity(LoadingActivity.class);
            return;
        }
        if (id == R.id.main_renovation_btn) {
            //下拉刷新
            ActivityUtile.startActivity(RecyclerRenovationActivity.class);
            return;
        }
        if (id == R.id.main_behavior_btn) {
            //Behavior
            ActivityUtile.startActivity(BehaviorActivity.class);
            return;
        }
        if (id == R.id.main_Link_btn) {
            //Link
            ActivityUtile.startActivity(LinkActivity.class);
            return;
        }
        if (id == R.id.main_sw_btn) {
            //MyScrollViewActivity
            ActivityUtile.startActivity(MyScrollViewActivity.class);
            return;
        }
        if (id == R.id.main_tv_btn) {
            ActivityUtile.startActivity(TextViewActivity.class);
            return;
        }
        if (id == R.id.main_web_btn) {
            ActivityUtile.startActivity(WebViewActivity.class);
            return;
        }
        if (id == R.id.main_value_animator_btn) {
            ActivityUtile.startActivity(ValueAnimatorActivity.class);
            return;
        }
        if (id == R.id.main_object_animator_btn) {
            ActivityUtile.startActivity(ObjectAnimatorActivity.class);
            return;
        }
        if (id == R.id.main_interpolator_btn) {
            ActivityUtile.startActivity(InterpolatorActivity.class);
            return;
        }
        if (id == R.id.main_state_btn) {
            ActivityUtile.startActivity(StateActity.class);
            return;
        }
        if (id == R.id.main_keyboard_btn) {
            ActivityUtile.startActivity(KeyboardActivity.class);
            return;
        }
    }
}
