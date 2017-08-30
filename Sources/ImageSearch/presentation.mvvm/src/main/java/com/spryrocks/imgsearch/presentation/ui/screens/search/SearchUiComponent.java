package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.presentation.ui.UiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UiModule.class})
public interface SearchUiComponent {
    static SearchUiComponent create(Context context) {
        return DaggerSearchUiComponent.builder()
                .uiModule(new UiModule(context))
                .build();
    }

    void inject(SearchFragment searchFragment);
}
