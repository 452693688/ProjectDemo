package com.framebase.base.ui.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by qibin on 2015/12/13.
 */
public class MoveViewBehavior extends CoordinatorLayout.Behavior<View> {
    private String Tag = "MoveViewBehavior";

    public MoveViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //生成Behavior后第一件事就是确定依赖关系。重写Behavior的这个方法来确定你依赖哪些View。
    //child 是指应用behavior的View ，dependency 担任触发behavior的角色
    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        boolean isSlide = dependency instanceof TextView;
        Log.e(Tag,"layoutDependsOn:isSlide"+isSlide);
        return isSlide;
    }

    //当所依赖的View变动时会回调这个方法。
    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        int offset = dependency.getTop() - child.getTop();
        ViewCompat.offsetTopAndBottom(child, offset);
        return true;
    }
}
