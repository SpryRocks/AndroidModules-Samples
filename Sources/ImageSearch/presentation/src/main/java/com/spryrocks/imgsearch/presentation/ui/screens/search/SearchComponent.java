package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.data.api.google.ApiModule;
import com.spryrocks.imgsearch.domain.interactors.InteractorsModule;
import com.spryrocks.imgsearch.presentation.app.AppModule;

import dagger.Component;

@Component(modules = {SearchModule.class, InteractorsModule.class, ApiModule.class, AppModule.class})
public interface SearchComponent {
    void inject(SearchFragment searchFragment);

    static SearchComponent create(Context context) {
        return DaggerSearchComponent.builder()
                .searchModule(new SearchModule(context))
                .interactorsModule(new InteractorsModule())
                .apiModule(new ApiModule())
                .appModule(new AppModule(context))
                .build();
    }
}
