package com.spryrocks.imgsearch.presentation.mvvm.services.alert;

import android.content.Context;
import android.widget.Toast;

import com.spryrocks.imgsearch.presentation.mvvm.ui.utils.AlertDialogHelper;

public class AlertService implements IAlertService {
    private final Context context;
    private final AlertDialogHelper alertDialogHelper;

    public AlertService(Context context, AlertDialogHelper alertDialogHelper) {
        this.context = context;
        this.alertDialogHelper = alertDialogHelper;
    }

    @Override
    public void showMessage(String title, String message) {
        alertDialogHelper.showMessage(title, message);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
