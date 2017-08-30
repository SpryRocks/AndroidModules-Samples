package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.presentation.mvvm.app.AppModule;
import com.spryrocks.imgsearch.presentation.mvvm.ui.UiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UiModule.class})
public interface SearchUiComponent {
    static SearchUiComponent create(Context context) {
        return DaggerSearchUiComponent.builder()
                .appModule(new AppModule(context))
                .build();
    }

    void inject(SearchFragment searchFragment);
}
