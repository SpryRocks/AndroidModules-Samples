package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.domain.interactors.InterractorsModule;

import dagger.Component;

@Component(modules = {InterractorsModule.class})
public interface SearchComponent {
    void inject(SearchPresenter searchPresenter);
}
