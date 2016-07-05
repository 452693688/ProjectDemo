package com.framebase.base.ui.activity.test;

import android.os.Bundle;

import com.framebase.app.R;
import com.framebase.base.ui.actionbar.ActionBarFixation;

public class LoadingActivity extends ActionBarFixation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity_loading);
        setLoadingShow();
    }

    @Override
    protected void onItemClick(int id) {

        if (id == R.id.bar_left_tv) {
            return;
        }
        if (id == R.id.bar_middle_tv) {
            ShowDefeated();
            return;
        }
        if (id == R.id.bar_right_tv) {
            loadingCancelShow();
            return;
        }
    }
}
