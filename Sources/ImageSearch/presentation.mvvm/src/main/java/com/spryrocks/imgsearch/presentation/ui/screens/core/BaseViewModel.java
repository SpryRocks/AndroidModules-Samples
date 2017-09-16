package com.spryrocks.imgsearch.presentation.ui.screens.core;

import android.app.Application;

public class BaseViewModel<TModel>
        extends com.spryrocks.android.modules.ui.mvvm.BaseViewModel<TModel> {
    public BaseViewModel(Application application, TModel model) {
        super(application, model);
    }
}
