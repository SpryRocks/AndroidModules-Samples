package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.domain.interactors.InteractorsModule;

import dagger.Component;

@Component(modules = {SearchUiModule.class, InteractorsModule.class})
public interface SearchUiComponent {
    void inject(SearchFragment searchFragment);
}
