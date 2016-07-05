package com.framebase.base.ui.activity.test;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.framebase.app.R;
import com.framebase.base.ui.activity.base.BaseActivity;
import com.framebase.base.ui.view.MyScrollView;

public class MyScrollViewActivity extends BaseActivity implements MyScrollView.OnScrollListener {

    private View mEditText;
    private int mEditTextTop;
    private RelativeLayout mHoveredLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_scroll_view);

        MyScrollView myScrollView = (MyScrollView) findViewById(R.id.scrollView);
        myScrollView.setOnScrollListener(this);
        if (Build.VERSION.SDK_INT >= 9) {
            myScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        }
        mEditText = findViewById(R.id.hovered_edit_text);
        mEditText.post(new Runnable() {
            @Override
            public void run() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mEditText.getLayoutParams();
                mEditTextTop = mEditText.getTop() - layoutParams.topMargin;
            }
        });
        mHoveredLayout = (RelativeLayout) findViewById(R.id.hovered_layout);
    }


    @Override
    public void onScroll(int scrollY) {
        int scrollLayout2HoverLayout = Math.max(scrollY, mEditTextTop) - mEditTextTop;
        int bottom = scrollLayout2HoverLayout + mHoveredLayout.getHeight();
        mHoveredLayout.layout(0, scrollLayout2HoverLayout,
                mHoveredLayout.getWidth(), bottom);
    }

}
