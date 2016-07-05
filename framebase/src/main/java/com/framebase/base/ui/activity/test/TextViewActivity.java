package com.framebase.base.ui.activity.test;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.widget.TextView;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;

/**
 * Created by Administrator on 2016/2/17.
 */
public class TextViewActivity extends ActionBarFixation {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_text_view);
        TextView oneTv = (TextView) findViewById(R.id.one_tv);
        setTvHtml(oneTv);
        TextView twoTv = (TextView) findViewById(R.id.two_tv);
        setTvSizeBig(twoTv);
        TextView threeTv = (TextView) findViewById(R.id.three_tv);
        setTvSpannable(threeTv);
        TextView fourTv = (TextView) findViewById(R.id.four_tv);
        setHyperlink(fourTv);
    }

    private void setTvHtml(TextView tv) {
        String html = "<html><head><title>TextView使用HTML</title></head><body><p><strong>强调</strong></p><p><em>斜体</em></p>"
                + "<p><a href=\"http://www.dreamdu.com/xhtml/\">超链接HTML入门</a>学习HTML!</p><p><font color=\"#aabb00\">颜色1"
                + "</p><p><font color=\"#00bbaa\">颜色2</p><h1>标题1</h1><h3>标题2</h3><h6>标题3</h6><p>大于>小于<</p><p>" +
                "下面是网络图片</p><img src=\"http://avatar.csdn.net/0/3/8/2_zhang957411207.jpg\"/></body></html>";
        tv.setMovementMethod(ScrollingMovementMethod.getInstance());//滚动
        tv.setText(Html.fromHtml(html));
    }

    private void setTvSizeBig(TextView tv) {
        // 一次放大
        String html1 = "<big><font>编号</font></big>";
        // 嵌套可以两次放大
        String html2 = "<html>" +
                "<head><title>" +
                "TextView使用HTML" +
                "</title></head>" +
                "<body><big><big><font>" +
                "编号" +
                "</font></big></big></body>" +
                "</html>";
        Spanned s = Html.fromHtml(html1);
        tv.setText(Html.fromHtml(html1));
    }

    private void setTvSpannable(TextView tv) {
        //根据路径得到Typeface
        //Typeface tf=Typeface.createFromAsset(getAssets(), "fonts/mini.TTF");
        // tv.setTypeface(tf);
        String textStr1 = "<font color=\"#ffff00\">如果有一天，</font><br>";
        String textStr2 = "<font color=\"#00ff00\">我厌倦了这里，</font><br>";
        String textStr3 = "<font color=\"#ff00ff\">我会乘着梦，</font><br>";
        String textStr4 = "<font color=\"#00ffff\">飞向那个属于自己的<br>世界……</font><br>";
        tv.setText(Html.fromHtml(textStr1 + textStr2 + textStr3 + textStr4));
    }

    private void setHyperlink(TextView tv) {
        SpannableString spans = new SpannableString("超链接背景色设置字体字体类型下标上标X轴大小删除线下划线设置颜色");
        //UrlSpan 设置超链接
        spans.setSpan(new URLSpan(""), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //BackgroundColorSpan 设置文字背景色
        spans.setSpan(new BackgroundColorSpan(Color.YELLOW), 3, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体  Typeface中有四个Style常量，分别是BOLD粗体、ITALIC斜体、BOLD_ITALIC粗斜体、NORMAL正常
        spans.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 6, 10, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //字体类型 TypefaceSpan (default,default-bold,monospace,serif,sans-serif)
        spans.setSpan(new TypefaceSpan("sans-serif"), 10, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置上下标
        //下标
        spans.setSpan(new SubscriptSpan(), 14, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //上标
        spans.setSpan(new SuperscriptSpan(), 16, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体宽度的多少倍
        // 2.0f表示默认字体宽度的两倍，即X轴方向放大为默认字体的两倍，而高度不变
        spans.setSpan(new ScaleXSpan(2.0f), 18, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //
        //设置字体大小（相对值,单位：像素） 参数表示为默认字体大小的多少倍
        //0.5f表示默认字体大小的一半
        spans.setSpan(new RelativeSizeSpan(0.5f), 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置图片
        //spans.setSpan(new ImageSpan(drawable, ImageSpan.ALIGN_BOTTOM), 0, 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        // 设置删除线
        spans.setSpan(new StrikethroughSpan(), 22, 25, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置下划线
        spans.setSpan(new UnderlineSpan(), 25, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //设置颜色
        spans.setSpan(new ForegroundColorSpan(Color.parseColor("#ff0000")), 28, 32, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        //不添加这一句，拨号，http，发短信的超链接不能执行.
        tv.setMovementMethod(LinkMovementMethod.getInstance());
        Parcel p = Parcel.obtain();
        p.writeString("ALIGN_CENTER");
        p.setDataPosition(0);
        AlignmentSpan.Standard standard = new AlignmentSpan.Standard(p);
        spans.setSpan(standard,20,22,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(spans);
    }
    /*
    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE --- 不包含两端start和end所在的端点
    Spanned.SPAN_EXCLUSIVE_INCLUSIVE --- 不包含start，但包含end
    Spanned.SPAN_INCLUSIVE_EXCLUSIVE --- 包含start，但不包含end
    Spanned.SPAN_INCLUSIVE_INCLUSIVE--- 包含start和end所在的端点
    msp.setSpan(new URLSpan("tel:4155551212"), 37, 39, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //电话
    msp.setSpan(new URLSpan("mailto:webmaster@google.com"), 39, 41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //邮件
    msp.setSpan(new URLSpan("http://www.baidu.com"), 41, 43, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //网络
    msp.setSpan(new URLSpan("sms:4155551212"), 43, 45, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //短信   使用sms:或者smsto:
    msp.setSpan(new URLSpan("mms:4155551212"), 45, 47, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);     //彩信   使用mms:或者mmsto:
    msp.setSpan(new URLSpan("geo:38.899533,-77.036476"),*/
}
