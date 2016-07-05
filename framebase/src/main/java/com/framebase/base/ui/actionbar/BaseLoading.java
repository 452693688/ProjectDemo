package com.framebase.base.ui.actionbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.framebase.app.R;
import com.framebase.base.ui.activity.base.BaseActivity;

/**
 * Created by Administrator on 2016/1/13.
 * 1.设置title视图
 * 2.设置loading和loading失败的视图
 */
public abstract class BaseLoading extends BaseActivity implements View.OnClickListener {


    private int num;
    private Bitmap bitmap;
    private boolean loadingCanceShow;
    private ImageView progressIv;
    private LoadingBitmap loadingBitmap;

    /**
     * 涨
     */
    protected View getLoading() {
        View baseLoading = LayoutInflater.from(this).inflate(R.layout.base_rise_loadding, null);
        ((ImageView) baseLoading.findViewById(R.id.base_iv)).setImageResource(R.mipmap.base_loading_up_false);
        progressIv = (ImageView) baseLoading.findViewById(R.id.progress_iv);
        bitmap = BitmapFactory.decodeResource(this.getResources(),
                R.mipmap.base_loading_up_true);
        loadingBitmap = new LoadingBitmap();
        progressIv.postDelayed(loadingBitmap, 5);
        return baseLoading;
    }

    /**
     * 取消显示loading视图
     */
    protected void loadingCancelShow() {
        loadingCanceShow = true;
        progressIv.removeCallbacks(loadingBitmap);
        loadingCancelLayout();
    }

    private View defeatedView;

    /**
     * 显示失败视图
     */
    protected void ShowDefeated() {
        if (defeatedView == null) {
            defeatedView = findViewById(R.id.base_defeated_rl);
            findViewById(R.id.base_defeated_tv).setOnClickListener(this);
        }
        if (defeatedView.getVisibility() == View.VISIBLE) {
            return;
        }
        num = 0;
        progressIv.removeCallbacks(loadingBitmap);
        defeatedView.setVisibility(View.VISIBLE);
    }

    /**
     * 重新开始显示加载视图
     */
    private void loadingAgainShow() {
        defeatedView.setVisibility(View.GONE);
        progressIv.postDelayed(loadingBitmap, 5);
    }

    // 这里把bitmap图片截取出来pr是指截取比例
    public static Bitmap getRoundedCornerBitmap(Bitmap bit, float pr) {
        Bitmap bitmap = Bitmap.createBitmap(bit.getWidth(), bit.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.clipRect(0, bit.getHeight(), bit.getWidth(), bit.getHeight()
                - (pr * bit.getHeight() / 100));
        canvas.drawBitmap(bit, 0, 0, paint);
        return bitmap;

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.base_defeated_tv) {
            loadingAgainShow();
            return;
        }
        onItemClick(id);
    }

    class LoadingBitmap implements Runnable {

        @Override
        public void run() {
            if (loadingCanceShow) {
                return;
            }
            num++;
            if (num > 100) {
                num = 0;
            }
            progressIv.setImageBitmap(getRoundedCornerBitmap(
                    bitmap, num));
            progressIv.postDelayed(this, 5);
        }
    }

    protected abstract void onItemClick(int id);
    protected void loadingCancelLayout(){};
}
