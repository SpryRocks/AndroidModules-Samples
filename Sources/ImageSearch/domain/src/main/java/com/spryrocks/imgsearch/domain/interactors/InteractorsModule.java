package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.data.api.google.ICustomSearchService;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorsModule {
    @Provides
    ISearchInteractor provideSearchInteractor(ICustomSearchService customSearchApiService) {
        return new SearchInteractor(customSearchApiService);
    }
}
