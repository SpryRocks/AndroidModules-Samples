package com.spryrocks.imgsearch.presentation.ui.screens;

import android.annotation.SuppressLint;

import com.spryrocks.imgsearch.presentation.ui.utils.AlertDialogHelper;
import com.spryrocks.imgsearch.presentation.ui.utils.AlertDialogHelper_;

@SuppressLint("Registered")
public class BaseActivity extends com.spryrocks.android.modules.ui.BaseActivity {
    protected final AlertDialogHelper alertDialogHelper;

    public BaseActivity() {
        alertDialogHelper = AlertDialogHelper_.getInstance_(this); // TODO: 17.05.2017 use DI
        registerLifecycleListener(alertDialogHelper);
    }

    public void handleError(Throwable error) {
        showError(error);
    }

    public void showError(Throwable error) {
        alertDialogHelper.showError(error);
    }
}
