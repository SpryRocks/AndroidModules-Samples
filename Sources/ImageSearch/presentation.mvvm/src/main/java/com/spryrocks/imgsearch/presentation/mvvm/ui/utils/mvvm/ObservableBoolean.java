package com.spryrocks.imgsearch.presentation.mvvm.ui.utils.mvvm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ObservableBoolean extends android.databinding.ObservableBoolean {
    private final List<Callback> callbacks;

    @SuppressWarnings("WeakerAccess")
    public ObservableBoolean(boolean value, @Nullable Callback callback) {
        super(value);

        this.callbacks = new ArrayList<>();

        if (callback != null) {
            addCallback(callback);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableBoolean(boolean value) {
        this(value, null);
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableBoolean(Callback valueChangedCallback) {
        this(false, valueChangedCallback);
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableBoolean() {
        this(false, null);
    }

    @Override
    public void set(boolean value) {
        super.set(value);

        for (Callback callback : callbacks) {
            callback.onValueChanged(value);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public void addCallback(@NonNull Callback callback) {
        callbacks.add(callback);
    }

    @SuppressWarnings("unused")
    public void removeCallback(@NonNull Callback callback) {
        callbacks.remove(callback);
    }

    public interface Callback {
        void onValueChanged(boolean value);
    }
}
