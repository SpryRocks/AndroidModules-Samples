package com.spryrocks.imgsearch.presentation.ui.utils.mvvm;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ObservableField<T> extends android.databinding.ObservableField<T> {
    private final List<Callback<T>> callbacks;

    @SuppressWarnings("WeakerAccess")
    public ObservableField(@Nullable T value, @Nullable Callback<T> callback) {
        super(value);

        callbacks = new ArrayList<>();

        if (callback != null) {
            addCallback(callback);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableField(Callback<T> valueChangedCallback) {
        this(null, valueChangedCallback);
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableField(T value) {
        this(value, null);
    }

    @SuppressWarnings("WeakerAccess")
    public ObservableField() {
        this(null, null);
    }

    @Override
    public void set(T value) {
        super.set(value);

        for (Callback<T> callback : callbacks) {
            callback.onValueChanged(value);
        }
    }

    @SuppressWarnings("WeakerAccess")
    public void addCallback(@NonNull Callback<T> callback) {
        callbacks.add(callback);
    }

    @SuppressWarnings("unused")
    public void removeCallback(@NonNull Callback<T> callback) {
        callbacks.remove(callback);
    }

    public interface Callback<T> {
        void onValueChanged(T value);
    }
}
