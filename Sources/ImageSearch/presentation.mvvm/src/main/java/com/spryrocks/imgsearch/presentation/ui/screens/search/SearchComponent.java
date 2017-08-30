package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.data.api.google.ApiModule;
import com.spryrocks.imgsearch.domain.interactors.InteractorsModule;
import com.spryrocks.imgsearch.presentation.app.AppModule;

import dagger.Component;

@Component(modules = {InteractorsModule.class, ApiModule.class, AppModule.class})
public interface SearchComponent {
    void inject(SearchViewModel searchViewModel);

    static SearchComponent create(Context context) {
        return DaggerSearchComponent.builder()
                .appModule(new AppModule(context))
                .build();
    }
}
