package com.spryrocks.imgsearch.domain.interactors;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {
    @Provides
    ISearchInteractor provideSearchInteractor() {
        return new SearchInteractor();
    }
}
