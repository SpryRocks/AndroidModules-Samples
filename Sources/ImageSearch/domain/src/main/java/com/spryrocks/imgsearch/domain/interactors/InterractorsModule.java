package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.domain.interactors.concrete.SearchInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InterractorsModule {
    @Provides
    public ISearchInteractor provideSearchInteractor() {
        return new SearchInteractor();
    }
}
