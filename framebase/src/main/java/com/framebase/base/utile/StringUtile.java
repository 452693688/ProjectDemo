package com.framebase.base.utile;

import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

/**
 * Created by Administrator on 2016/2/9.
 */
public class StringUtile {
    public static int TO_LEFT = 0;
    public static int TO_RIGHT = TO_LEFT + 1;

    /**
     * 图片替换字符
     * 如果给TabLayout使用：
     * TabLayout创建的tab默认设置textAllCaps属性为true，这阻止了ImageSpan被渲染出来
     * 需要设置<item name="textAllCaps">false</item>
     */
    public CharSequence imageReplaceChars(String source, Drawable drawable, int type) {
        SpannableString sb = new SpannableString(source);
        if (type != TO_LEFT || type != TO_RIGHT) {
            return sb;
        }
        ImageSpan imageSpan = new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (type == TO_LEFT) {
            source = "h" + source;
            sb = new SpannableString(source);
            sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (type == TO_RIGHT) {
            source += "h";
            sb = new SpannableString(source);
            int length = source.length();
            sb.setSpan(imageSpan, (length - 1), length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        return sb;
    }
}
