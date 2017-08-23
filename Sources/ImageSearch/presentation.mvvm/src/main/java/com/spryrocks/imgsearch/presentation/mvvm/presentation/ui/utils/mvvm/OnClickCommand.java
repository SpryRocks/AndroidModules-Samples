package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.utils.mvvm;

import android.databinding.ObservableBoolean;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class OnClickCommand implements View.OnClickListener {
    private final List<Callback> callbacks;
    private final ObservableBoolean isEnabled;

    @SuppressWarnings("WeakerAccess")
    public OnClickCommand(@Nullable Callback callback) {
        callbacks = new ArrayList<>();
        isEnabled = new ObservableBoolean(true);

        if (callback != null) {
            addCallback(callback);
        }
    }

    public OnClickCommand() {
        this(null);
    }

    @Override
    public void onClick(View v) {
        for (Callback callback : callbacks) {
            callback.onClick();
        }
    }

    public ObservableBoolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled.set(enabled);
    }

    public void addCallback(@NonNull Callback callback) {
        callbacks.add(callback);
    }

    @SuppressWarnings("unused")
    public void removeCallback(@NonNull Callback callback) {
        callbacks.remove(callback);
    }

    public interface Callback {
        void onClick();
    }
}
