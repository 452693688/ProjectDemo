package com.framebase.base.ui.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.framebase.base.utile.DLog;

/**
 * Created by Administrator on 2016/5/25.
 */
public class AdjustKeyboardView extends RelativeLayout {
    public AdjustKeyboardView(Context context) {
        super(context);
    }

    public AdjustKeyboardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdjustKeyboardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public AdjustKeyboardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        DLog.e("onLayout", "layout发生改变：t：" + t + "  b:" + b);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        DLog.e("onMeasure", "s测量发生改变：widthMeasureSpec：" + widthMeasureSpec
                + " heightMeasureSpec:" + heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        DLog.e("onSizeChanged", "size发生改变：oldw：" + oldw + " oldh:" + oldh);
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {

        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Display d = wm.getDefaultDisplay();
        int mScreenWidth = d.getWidth();
        int mScreenHeight = d.getHeight();
        DLog.e("onConfigurationChanged", "size发生改变：mScreenWidth：" + mScreenWidth
                + " mScreenHeight:" + mScreenHeight);

        super.onConfigurationChanged(newConfig);
    }
}
