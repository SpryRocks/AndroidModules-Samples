package com.spryrocks.imgsearch.presentation.mvvm.ui.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.presentationmvvm.R;
import com.spryrocks.android.modules.ui.lifecycle.LifecycleListener;

public class AlertDialogHelper extends LifecycleListener {

    private final Context context;

    private AlertDialog dialog;

    public AlertDialogHelper(Context context) {
        this.context = context;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showMessage(String title, String message, DialogInterface.OnClickListener clickListener) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, clickListener)
                .create();
        return showDialog(dialog);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showMessage(String title, String message) {
        return showMessage(title, message, null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showMessage(int titleResId, int messageResId, DialogInterface.OnClickListener clickListener) {
        return showMessage(
                context.getString(titleResId),
                context.getString(messageResId),
                clickListener
        );
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showMessage(int titleResId, int messageResId) {
        return showMessage(titleResId, messageResId, null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(String message, DialogInterface.OnClickListener clickListener) {
        String title = context.getString(R.string.OopsE);
        return showMessage(title, message, clickListener);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(String message) {
        return showError(message, null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(int messageResId, DialogInterface.OnClickListener clickListener) {
        return showError(
                context.getString(messageResId),
                clickListener
        );
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(int messageResId) {
        return showError(messageResId, null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(Throwable e, DialogInterface.OnClickListener clickListener) {
        return showError(e.getMessage(), clickListener);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showError(Throwable e) {
        return showError(e, null);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public void dismissDialog() {
        if (dialog == null)
            return;

        dialog.dismiss();
        dialog = null;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public Dialog showDialog(AlertDialog dialog) {
        dismissDialog();

        this.dialog = dialog;
        dialog.show();
        return dialog;
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    public AlertDialog getCurrentDialog() {
        return dialog;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        dismissDialog();
    }
}
