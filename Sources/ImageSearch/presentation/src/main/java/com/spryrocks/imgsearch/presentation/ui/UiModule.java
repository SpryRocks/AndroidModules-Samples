package com.spryrocks.imgsearch.presentation.ui;

import android.content.Context;

import com.spryrocks.imgsearch.presentation.ui.utils.AlertDialogHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class UiModule {
    private final Context context;

    public UiModule(Context context) {
        this.context = context;
    }

    @Provides
    AlertDialogHelper provideAlertDialogHelper() {
        return new AlertDialogHelper(context);
    }
}
