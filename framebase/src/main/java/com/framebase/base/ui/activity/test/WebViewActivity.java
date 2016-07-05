package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;

/**
 * Created by Administrator on 2016/2/17.
 */
public class WebViewActivity extends ActionBarFixation {
    private ProgressBar mLoadingProgress;
    private WebView webView;
    private String mstrLoginUrl = "http://baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_web_view);
        webView = (WebView) findViewById(R.id.web_view);
        mLoadingProgress = (ProgressBar) findViewById(R.id.progressBarLoading);
        mLoadingProgress.setMax(100);
        setSettings();
        webView.loadUrl(mstrLoginUrl);
        // 覆盖WebView默认使用第三方或系统默认浏览器打开网页的行为，使网页用WebView打开
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });
        //设置加载进度条
        webView.setWebChromeClient(new WebChromeClientProgress());
    }

    private void setSettings() {
        WebSettings setting = webView.getSettings();
        //支持javascript
        setting.setJavaScriptEnabled(true);
        // 设置可以支持缩放
        setting.setSupportZoom(true);
        // 设置出现缩放工具
        setting.setBuiltInZoomControls(true);
        //扩大比例的缩放
        setting.setUseWideViewPort(true);
        //自适应屏幕
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        setting.setLoadWithOverviewMode(true);
        setting.setDefaultTextEncodingName("UTF-8");
        // webView.getSettings().setDefaultZoom(ZoomDensity.FAR);
        //显示时设置图片适应屏幕
       // webView.loadDataWithBaseURL(null,"<style>img{border:0;width:100%;}</style>"+str, "text/html", "utf-8", null);
       // webView.loadUrl("file:///android_asset/example.html");
    }

    private class WebChromeClientProgress extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int progress) {
                 mLoadingProgress.setProgress(progress);
                if (progress == 100) {
                    mLoadingProgress.setVisibility(View.GONE);
                }else {
                    mLoadingProgress.setVisibility(View.VISIBLE);
                }
            //super.onProgressChanged(view, progress);
        }
    }

    /**
     * 按键响应，在WebView中查看网页时，检查是否有可以前进的历史记录。
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            // 返回键退回
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
