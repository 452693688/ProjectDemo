package com.framebase.base.ui.activity.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.framebase.app.R;
import com.framebase.base.ui.view.InterpolatorView;

public class InterpolatorActivity extends Activity {

    private RadioGroup mInterpolatorGroup = null;
    private InterpolatorView mCurveView = null;
    private float[] mXValues = new float[]{0.0f, 0.1f, 0.2f, 0.3f, 0.4f,
            0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
    private float[] mYValues = new float[11];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_interposition);
        mInterpolatorGroup = (RadioGroup) findViewById(R.id.interpolatorGroup);
        mCurveView = (InterpolatorView) findViewById(R.id.curve);
        mCurveView.setxValues(mXValues);
        mInterpolatorGroup
                .setOnCheckedChangeListener(new OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        Interpolator interpolator = getInterpolator();
                        for (int i = 0; i < mXValues.length; ++i) {
                            mYValues[i] = interpolator
                                    .getInterpolation(mXValues[i]);
                        }
                        mCurveView.setyValues(mYValues);
                        mCurveView.invalidate();
                    }
                });

        mInterpolatorGroup.check(R.id.LinearInterpolator);

    }
    //    AccelerateDecelerateInterpolator============动画开始与结束的地方速率改变比较慢，在中间的时候加速。
//    AccelerateInterpolator===================动画开始的地方速率改变比较慢，然后开始加速。
//    AnticipateInterpolator==================开始的时候向后然后向前甩。
//    AnticipateOvershootInterpolator=============开始的时候向后然后向前甩一定值后返回最后的值。
//    BounceInterpolator=====================动画结束的时候弹起。
//    CycleInterpolator======================动画循环播放特定的次数，速率改变沿着正弦曲线。
//    DecelerateInterpolator===================在动画开始的地方快然后慢。
//    LinearInterpolator======================以常量速率改变。
//    OvershootInterpolator====================向前甩一定值后再回到原来位置。
//    PathInterpolator========================新增的，就是可以定义路径坐标，然后可以按照路径坐标来跑

    private Interpolator getInterpolator() {

        int checkedId = mInterpolatorGroup.getCheckedRadioButtonId();

        if (checkedId == R.id.AccelerateDecelerateInterpolator) {
            //动画从开始到结束，变化率是先加速后减速的过程。
            return new AccelerateDecelerateInterpolator();
        }
        if (checkedId == R.id.AccelerateInterpolator) {
            //AccelerateInterpolator：动画从开始到结束，变化率是一个加速的过程。
            return new AccelerateInterpolator();
        }
        if (checkedId == R.id.AnticipateInterpolator) {
            //AnticipateInterpolator：“Anticipate” means 抢先，模拟了出发前先后退一步再前冲的动画效果
            return new AnticipateInterpolator();
        }
        if (checkedId == R.id.AnticipateOvershootInterpolator) {
            //OvershootInterpolator： “Overshoot” means 冲过头了，模拟了冲过了头回滚一点的效果
            // AnticipateInterpolator：“Anticipate” means 抢先，模拟了出发前先后退一步再前冲的动画效果
            // AnticipateOvershootInterpolator：以上两种的结合
            return new AnticipateOvershootInterpolator();
        }
        if (checkedId == R.id.BounceInterpolator) {
            //BounceInterpolator：“Bounce” means 弹跳, 就是模拟了自由落地后回弹的效果
            return new BounceInterpolator();
        }
        if (checkedId == R.id.CycleInterpolator) {
            //CycleInterpolator：动画从开始到结束，变化率是循环给定次数的正弦曲线。
            return new CycleInterpolator(2);
        }
        if (checkedId == R.id.DecelerateInterpolator) {
            //DecelerateInterpolator：动画从开始到结束，变化率是一个减速的过程。
            return new DecelerateInterpolator();
        }
        if (checkedId == R.id.LinearInterpolator) {
            //动画从开始到结束，变化率是线性变化。
            return new LinearInterpolator();
        }
        if (checkedId == R.id.OvershootInterpolator) {
            // OvershootInterpolator： “Overshoot” means 冲过头了，模拟了冲过了头回滚一点的效果
            return new OvershootInterpolator();
        }


        return null;

    }

}
