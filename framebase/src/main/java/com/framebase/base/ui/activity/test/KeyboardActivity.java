package com.framebase.base.ui.activity.test;

import android.os.Bundle;
import android.view.WindowManager;

import com.azimolabs.keyboardwatcher.KeyboardWatcher;
import com.framebase.app.R;
import com.framebase.base.ui.activity.base.BaseActivity;
import com.framebase.base.utile.DLog;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

public class KeyboardActivity extends BaseActivity  implements KeyboardWatcher.OnKeyboardToggleListener {

    private KeyboardWatcher keyboardWatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        setContentView(R.layout.activity_keyboard);
       // keyboardWatcher = new KeyboardWatcher(this);
       // keyboardWatcher.setListener(this);
        test();

    }
    private void test(){
        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        DLog.e("isOpen","润键盘:"+isOpen);
                    }
                });
    }
    @Override
    protected void onDestroy() {
       // keyboardWatcher.destroy();
        super.onDestroy();
    }

    @Override
    public void onKeyboardShown(int keyboardSize) {
        DLog.e("onKeyboardShown","润键盘大小:"+keyboardSize);
    }

    @Override
    public void onKeyboardClosed() {
        DLog.e("onKeyboardClosed","关闭");
    }
}
