package com.framebase.base.ui.layoutmanager;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Administrator on 2016/1/28.
 */
public class AppBarLayoutView extends android.support.design.widget.AppBarLayout {
    public AppBarLayoutView(Context context) {
        super(context);
    }

    public AppBarLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init() {
        //this.setScrollBarFadeDuration();
        //this.setVerticalScrollBarEnabled();
        //this.setScrollBarDefaultDelayBeforeFade();

    }

    @Override
    public void scrollBy(int x, int y) {
        super.scrollBy(x, y);
        Log.e("scrollBy", "x:" + x + " y" + y);
    }

    @Override
    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        Log.e("scrollTo", "x:" + x + " y" + y);
    }

    class OnOffsetChanged implements AppBarLayout.OnOffsetChangedListener {

        @Override
        public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {

        }
    }
}
