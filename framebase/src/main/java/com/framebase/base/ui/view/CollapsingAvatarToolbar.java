package com.framebase.base.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.framebase.app.R;

/**
 * Created by Administrator on 2016/1/28.
 */

public class CollapsingAvatarToolbar extends LinearLayout implements AppBarLayout.OnOffsetChangedListener {
    private View avatarView;
    private TextView titleView;
    //收缩内边距
    private float collapsedPaddingT;
    private float collapsedPaddingB;
    private float collapsedPaddingL;
    private float collapsedPaddingR;
    //展开内边距
    private float expandedPaddingT;
    private float expandedPaddingB;
    private float expandedPaddingL;
    private float expandedPaddingR;

    private float expandedImageSize;
    private float collapsedImageSize;

    private float collapsedTextSize;
    private float expandedTextSize;


    private android.support.v7.widget.Toolbar toolbar;
    private AppBarLayout appBarLayout;
    //滑动数据是否初始化
    private boolean isInitSlide = false;
    /**
     * Toolbar的高度
     */
    private float toolbarHight;
    /**
     * 这个自定义控件的高度
     */
    private float vatarToolbarHight;
    /**
     * 可以向上滑动的最大高度
     */
    private float maxOffset;
    //设置子view里容器的高度
    private float childViewMarginTop;

    public CollapsingAvatarToolbar(Context context) {
        this(context, null);
    }

    public CollapsingAvatarToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CollapsingAvatarToolbar, 0, 0);
        try {
            //收缩内边距
            collapsedPaddingT = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedPaddingTop, -1);
            collapsedPaddingB = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedPaddingBottom, -1);
            collapsedPaddingL = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedPaddingLeft, -1);
            collapsedPaddingR = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedPaddingRight, -1);
            //展开内边距
            expandedPaddingT = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedPaddingTop, -1);
            expandedPaddingB = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedPaddingBttom, -1);
            expandedPaddingL = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedPaddingLeft, -1);
            expandedPaddingR = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedPaddingRight, -1);


            collapsedImageSize = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedImageSize, -1);
            expandedImageSize = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedImageSize, -1);
            collapsedTextSize = a.getDimension(R.styleable.CollapsingAvatarToolbar_collapsedTextSize, -1);
            expandedTextSize = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedTextSize, -1);
            childViewMarginTop = a.getDimension(R.styleable.CollapsingAvatarToolbar_expandedChildViewMarginTop, -1);
        } finally {
            a.recycle();
        }
        final Resources resources = getResources();
        //获取收缩内边距
        if (collapsedPaddingT < 0) {
            collapsedPaddingT = resources.getDimension(R.dimen.default_collapsed_padding_top);
        }
        if (collapsedPaddingB < 0) {
            collapsedPaddingB = resources.getDimension(R.dimen.default_collapsed_padding_bottom);
        }
        if (collapsedPaddingL < 0) {
            collapsedPaddingL = resources.getDimension(R.dimen.default_collapsed_padding_left);
        }
        if (collapsedPaddingR < 0) {
            collapsedPaddingR = resources.getDimension(R.dimen.default_collapsed_padding_right);
        }
        //获取展开内边距
        if (expandedPaddingT < 0) {
            expandedPaddingT = resources.getDimension(R.dimen.default_expanded_padding_top);
        }
        if (expandedPaddingB < 0) {
            expandedPaddingB = resources.getDimension(R.dimen.default_expanded_padding_bottom);
        }
        if (expandedPaddingL < 0) {
            expandedPaddingL = resources.getDimension(R.dimen.default_expanded_padding_left);
        }
        if (expandedPaddingR < 0) {
            expandedPaddingR = resources.getDimension(R.dimen.default_expanded_padding_right);
        }
        if (collapsedImageSize < 0) {
            collapsedImageSize = resources.getDimension(R.dimen.default_collapsed_image_size);
        }
        if (expandedImageSize < 0) {
            expandedImageSize = resources.getDimension(R.dimen.default_expanded_image_size);
        }
        if (collapsedTextSize < 0) {
            collapsedTextSize = resources.getDimension(R.dimen.default_collapsed_text_size);
        }
        if (expandedTextSize < 0) {
            expandedTextSize = resources.getDimension(R.dimen.default_expanded_text_size);
        }
    }

    private void init() {
        setOrientation(HORIZONTAL);
        //设置滑动持续褪色
        // setScrollBarFadeDuration(1);
        //setScrollBarDefaultDelayBeforeFade(1000);

    }

    // 是在第一次onDraw前调用的。也就是我们写的View在没有绘制出来时调用的，但只会调用一次
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        findViews();
        if (!isInEditMode()) {
            appBarLayout.addOnOffsetChangedListener(this);
        } else {
            initSlide();
            updateViews(1f, 0);
            Log.e("什么情况下调用", "不会被调用的");
        }
    }


    private void findViews() {
        appBarLayout = findParentAppBarLayout();
        toolbar = findSiblingToolbar();
        avatarView = findAvatar();
        //titleView = findTitle();
    }

    @NonNull
    private AppBarLayout findParentAppBarLayout() {
        ViewParent parent = this.getParent();
        if (parent instanceof AppBarLayout) {
            return ((AppBarLayout) parent);
        } else if (parent.getParent() instanceof AppBarLayout) {
            return ((AppBarLayout) parent.getParent());
        } else {
            throw new IllegalStateException("Must be inside an AppBarLayout");
            //TODO actually, a collapsingtoolbar
        }
    }

    @NonNull
    private android.support.v7.widget.Toolbar findSiblingToolbar() {
        ViewGroup parent = ((ViewGroup) this.getParent());
        for (int i = 0, c = parent.getChildCount(); i < c; i++) {
            View child = parent.getChildAt(i);
            if (child instanceof android.support.v7.widget.Toolbar) {
                return (android.support.v7.widget.Toolbar) child;
            }
        }
        throw new IllegalStateException("No toolbar found as sibling");
    }

    @NonNull
    private View findAvatar() {
        View avatar = this.findViewById(R.id.cat_avatar);
        if (avatar == null) {
            throw new IllegalStateException("View with id ta_avatar not found");
        }
        return avatar;
    }

    /*@NonNull
    private TextView findTitle() {
        TextView title = (TextView) this.findViewById(R.id.cat_title);
        if (title == null) {
            throw new IllegalStateException("TextView with id ta_title not found");
        }
        return title;
    }*/


    /**
     * 滑动数据初始化
     */
    private void initSlide() {
        toolbarHight = toolbar.getHeight();
        float appBarLayoutHeight = appBarLayout.getHeight();
        vatarToolbarHight = appBarLayoutHeight - toolbarHight;
        maxOffset = vatarToolbarHight;
        if (childViewMarginTop < 0) {
            int height = avatarView.getHeight();
            childViewMarginTop = (vatarToolbarHight - height) - height / 2;
        }
    }

    /**
     * @param expandedPercentage 百分比（剩余高度/原高度） 完全显示：1,完全隐藏 0；
     * @param currentOffset      隐藏的高度
     */
    private void updateViews(float expandedPercentage, int currentOffset) {
        //计算view的位置（上下）
        float translation = -currentOffset + ((toolbarHight + childViewMarginTop) * expandedPercentage);


        float currHeight = toolbarHight + (vatarToolbarHight - toolbarHight) * expandedPercentage;
        float currentImageSize = collapsedImageSize + (expandedImageSize - collapsedImageSize) * expandedPercentage;
        float currentTextSize = collapsedTextSize + (expandedTextSize - collapsedTextSize) * expandedPercentage;
        setViewPadding(expandedPercentage);
        //y轴向下滑动
        this.setTranslationY(translation);
        //设置高度
        if(currentOffset==0) {
            this.getLayoutParams().height = (int) currHeight;
        }
        //设置子view的显示
        //setAvatarSize((int) currentImageSize);
        //  setTextSize(currentTextSize);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        //offset:假设appBarLayout可以缩进的高度=600
        //  完全显示为offset=0，完全不显示为offset=-600;
        if (!isInitSlide) {
            initSlide();
            isInitSlide = true;
        }
        Log.e("onOffsetChanged", "offset:" + offset + " maxOffset" + maxOffset);
        float expandedPercentage = 1 - (-offset / maxOffset);
        updateViews(expandedPercentage, offset);
    }

    //计算内边距
    private void setViewPadding(float expandedPercentage) {
        float inversePercentage = 1 - expandedPercentage;
        int currentPaddingT = (int) (expandedPaddingT + (collapsedPaddingT - expandedPaddingT) * inversePercentage);
        int currentPaddingB = (int) (expandedPaddingB + (collapsedPaddingB - expandedPaddingB) * inversePercentage);
        int currentPaddingL = (int) (expandedPaddingL + (collapsedPaddingL - expandedPaddingL) * inversePercentage);
        int currentPaddingR = (int) (expandedPaddingR + (collapsedPaddingR - expandedPaddingR) * inversePercentage);
        //设置内边距
        this.setPadding(currentPaddingL, currentPaddingT, currentPaddingR, currentPaddingB);
    }

    //---------------设置子view的显示
    private void setTextSize(float currentTextSize) {
        if (titleView == null) {
            return;
        }
        titleView.setTextSize(TypedValue.COMPLEX_UNIT_PX, currentTextSize);
    }

    private void setAvatarSize(int currentImageSize) {
        if (avatarView == null) {
            return;
        }
        avatarView.getLayoutParams().height = currentImageSize;
        avatarView.getLayoutParams().width = currentImageSize;
    }
}
