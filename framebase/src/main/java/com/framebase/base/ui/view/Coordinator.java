package com.framebase.base.ui.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/2/12.
 */
public class Coordinator extends CoordinatorLayout {
    private AppBarLayout appBarLayout;
    private int appBarLayoutHight = -1;
    private int appBarLayoutChangeHight;

    public Coordinator(Context context) {
        super(context);
        init();
    }

    public Coordinator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public Coordinator(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child instanceof AppBarLayout) {
                this.appBarLayout = (AppBarLayout) child;
                break;
            }
        }
    }

    private TextView topTv;

    public void setView(TextView topTv) {
        this.topTv = topTv;
        init();
    }

    private float y;

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                y = ev.getY();
                if (appBarLayoutHight == -1) {
                    appBarLayoutHight = appBarLayout.getHeight();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                float temp = ev.getY();
                float moveY = temp - y;
                y = temp;
                moveHeadView((int) moveY);
                break;
            case MotionEvent.ACTION_UP:
                // move = -viewHight;
                // move();
                break;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        //super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return false;
       // return super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return false;
        // return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
    }

    private int viewHight = 200;
    private int move = -viewHight;

    private void moveHeadView(int moveY) {
        moveY = moveY / 2;
        Log.e("---move:" + move, " top:" + appBarLayout.getTop());
        if (appBarLayout.getTop() != 0) {
            return;
        }
        if (appBarLayout.getTop() == 0) {
            move += moveY;
        }
        if (appBarLayout.getTop() != 0 && move != -viewHight) {
            move += -moveY;
        }
        if (move >= 0) {
            move = 0;
        }
        if (move < -200) {
            move = -200;
        }
        move();
    }

    private void move() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, viewHight);
        params.setMargins(0, move, 0, 0);
        topTv.setLayoutParams(params);
    }
}
