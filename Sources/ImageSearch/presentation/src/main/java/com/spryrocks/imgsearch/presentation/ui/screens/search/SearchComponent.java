package com.spryrocks.imgsearch.presentation.ui.screens.search;

import dagger.Component;

@Component(modules = {SearchModule.class})
public interface SearchComponent {
    void inject(SearchFragment fragment);
}
