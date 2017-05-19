package com.spryrocks.imgsearch.data.api.google;

import dagger.Module;
import dagger.Provides;

@Module
public class ApiModule {
    @Provides
    ICustomSearchService provideCustomSearchApiService(CustomSearchServiceConfiguration configuration) {
        return new CustomSearchService(configuration);
    }
}
