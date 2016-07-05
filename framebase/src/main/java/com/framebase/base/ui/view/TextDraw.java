package com.framebase.base.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/2.
 */
public class TextDraw extends TextView {

    public TextDraw(Context context) {
        super(context);
    }

    public TextDraw(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextDraw(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
       // super.onDraw(canvas);
        test(canvas);
    }

    private void test(Canvas canvas) {
        canvas.drawRoundRect(getRectF(getWidth()
                , getHeight()), 0, 0, getRectPaint());
    }
    private RectF outerRect;

    private RectF getRectF(int x, int y) {
        // 新建一个矩形
        if (outerRect == null) {
            outerRect = new RectF(0, 0, x, y );
        }
        return outerRect;
    }

    private Paint paint;

    private Paint getRectPaint() {
        if (paint == null) {
            paint = new Paint();
        }
        paint.setColor(0xffff0000);
        return paint;
    }
}
