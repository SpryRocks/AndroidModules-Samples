package com.spryrocks.imgsearch.presentation.ui.screens;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.spryrocks.imgsearch.presentation.ui.UiComponent;
import com.spryrocks.imgsearch.presentation.ui.utils.AlertDialogHelper;

import javax.inject.Inject;

@SuppressLint("Registered")
public class BaseActivity extends com.spryrocks.android.modules.ui.BaseActivity {
    @Inject
    AlertDialogHelper alertDialogHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UiComponent.create(this).inject(this);

        registerLifecycleListener(alertDialogHelper);

        super.onCreate(savedInstanceState);
    }

    public void handleError(Throwable error) {
        showError(error);
    }

    public void showError(Throwable error) {
        alertDialogHelper.showError(error);
    }
}
