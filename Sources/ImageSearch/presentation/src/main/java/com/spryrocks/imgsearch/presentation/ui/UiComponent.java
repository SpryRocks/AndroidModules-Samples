package com.spryrocks.imgsearch.presentation.ui;

import android.content.Context;

import com.spryrocks.imgsearch.presentation.ui.screens.BaseActivity;

import dagger.Component;

@Component(modules = {UiModule.class})
public interface UiComponent {
    void inject(BaseActivity activity);

    static UiComponent create(Context context) {
        return DaggerUiComponent.builder()
                .uiModule(new UiModule(context))
                .build();
    }
}
