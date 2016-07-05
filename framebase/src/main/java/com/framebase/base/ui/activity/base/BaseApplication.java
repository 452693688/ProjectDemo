package com.framebase.base.ui.activity.base;

import android.app.Application;

import java.io.File;

/**
 * Created by Administrator on 2016/1/15.
 */
public class BaseApplication extends Application{
    public static BaseApplication baseApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication=this;
    }
    /**
     * 删除网页缓存
     */
    public void clearCache() {
        File file = getApplicationContext().getCacheDir();
        if (file != null && file.exists() && file.isDirectory()) {
            deleteAll(file);
        }
        this.deleteDatabase("webview.db");
        this.deleteDatabase("webviewCache.db");
    }
    // 递归删除指定路径下的所有文件
    public static void deleteAll(File file) {
        if (file.isFile() || file.list().length == 0) {
            file.delete();
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                deleteAll(f);// 递归删除每一个文件
                f.delete();// 删除该文件夹
            }
        }
    }
}
