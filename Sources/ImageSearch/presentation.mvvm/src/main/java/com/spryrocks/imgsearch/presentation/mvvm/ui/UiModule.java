package com.spryrocks.imgsearch.presentation.mvvm.ui;

import android.content.Context;
import com.spryrocks.imgsearch.presentation.mvvm.app.AppModule;

import com.spryrocks.imgsearch.presentation.mvvm.ui.utils.AlertDialogHelper;

import dagger.Module;
import dagger.Provides;

@Module(includes = {AppModule.class})
public class UiModule {
    @Provides
    AlertDialogHelper provideAlertDialogHelper(Context context) {
        return new AlertDialogHelper(context);
    }
}
