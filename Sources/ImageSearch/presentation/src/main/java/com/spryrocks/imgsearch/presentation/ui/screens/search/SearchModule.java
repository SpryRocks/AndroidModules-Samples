package com.spryrocks.imgsearch.presentation.ui.screens.search;

import dagger.Module;
import dagger.Provides;

@Module
class SearchModule {
    @Provides
    ISearchPresenter provide() {
        return new SearchPresenter();
    }
}
