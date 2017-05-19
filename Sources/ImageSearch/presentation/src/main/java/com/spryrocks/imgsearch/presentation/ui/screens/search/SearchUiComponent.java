package com.spryrocks.imgsearch.presentation.ui.screens.search;

import dagger.Component;

@Component(modules = {SearchUiModule.class})
public interface SearchUiComponent {
    void inject(SearchFragment searchFragment);
}
