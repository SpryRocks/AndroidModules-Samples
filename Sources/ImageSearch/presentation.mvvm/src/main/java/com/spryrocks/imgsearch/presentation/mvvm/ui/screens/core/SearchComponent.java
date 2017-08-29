package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core;

import android.content.Context;

import com.spryrocks.imgsearch.data.api.google.ApiModule;
import com.spryrocks.imgsearch.domain.interactors.InteractorsModule;

import dagger.Component;

@Component(modules = {InteractorsModule.class, ApiModule.class, AppModule.class})
public interface SearchComponent {
    void inject(SearchViewModel searchViewModel);

    static SearchComponent create(Context context) {
        return DaggerSearchComponent.builder()
//                .searchModule(new SearchModule(context))
                .appModule(new AppModule(context))
                .build();
    }
}
