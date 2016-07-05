package com.framebase.base.utile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

import com.framebase.base.ui.activity.base.BaseApplication;

/**
 * Created by Administrator on 2016/1/19.
 */
public class ActivityUtile {
    private static int[] mflags;

    public final static void startActivity(Class<?> cls) {
        startActivity(cls, "", "", null);
    }

    public final static void startActivity(Class<?> cls, String str1) {
        startActivity(cls, str1, "", null);
    }

    public final static void startActivity(Class<?> cls, String str1, String str2) {
        startActivity(cls, str1, str2, null);
    }

    public final static void startActivity(Class<?> cls, Bundle bundle) {
        startActivity(cls, "", "", bundle);
    }

    public final static void startActivity(Class<?> cls, String str1, Bundle bundle) {
        startActivity(cls, str1, "", bundle);
    }

    public final static void startActivity(Class<?> cls, String str1, String str2, Bundle bundle) {
        Intent it = new Intent();
        if (!TextUtils.isEmpty(str1)) {
            it.putExtra("str1", str1);
        }
        if (!TextUtils.isEmpty(str2)) {
            it.putExtra("str1", str2);
        }
        if (bundle != null) {
            it.putExtras(bundle);
        }
        it.setClass(BaseApplication.baseApplication, cls);
        startActivity(it);
    }

    /**
     * 启动页面
     */
    private   static void startActivity(Intent it) {
        if (mflags == null) {
            it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        } else {
            for (int i = 0; i < mflags.length; i++) {
                it.addFlags(mflags[i]);
            }
            mflags = null;
        }
        BaseApplication.baseApplication.startActivity(it);
    }

    public final static void setIntentFlags(int[] flags) {
        mflags = flags;
    }

    // 跳转到无线网络设置界面
    public final static void startActivityNet() {
        startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
    }

    // 跳转到无限wifi网络设置界面
    public final static void startActivityWiFi() {
        startActivity(new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS));
    }

    /**
     * 拨号界面
     */
    public final static void callPhone(String tile) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + tile));
        startActivity(intent);
    }

    /**
     * 分享
     *
     * @param subject
     * @param text
     * @param tag
     */
    public final static void startShare(String subject, String text, String tag) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        intent = Intent.createChooser(intent, tag);
        startActivity(intent);
    }
}
