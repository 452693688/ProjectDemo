package com.framebase.base.ui.layoutmanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created by Administrator on 2016/1/27.
 */
public class StaggeredGridManager extends StaggeredGridLayoutManager {
    public StaggeredGridManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public StaggeredGridManager(int spanCount, int orientation) {
        super(spanCount, orientation);
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrollRange = super.scrollVerticallyBy(dy, recycler, state);
        Log.e("滑动", "dy：" + dy + " scrollRange:" + scrollRange);
        //mListener.overScrollBy(dy - scrollRange);
        return scrollRange;
    }
}
