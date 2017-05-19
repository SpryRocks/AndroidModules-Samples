package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.domain.interactors.InteractorsModule;

import dagger.Component;

@Component(modules = {SearchModule.class, InteractorsModule.class})
public interface SearchComponent {
    void inject(SearchFragment searchFragment);

    static SearchComponent create(Context context) {
        return DaggerSearchComponent.builder()
                .searchModule(new SearchModule(context))
                .interactorsModule(new InteractorsModule())
                .build();
    }
}
