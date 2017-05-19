package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.data.api.google.ICustomSearchService;
import com.spryrocks.imgsearch.data.models.Image;

import java.util.Collection;

import io.reactivex.Observable;

class SearchInteractor implements ISearchInteractor {
    private final ICustomSearchService customSearchApiService;

    SearchInteractor(ICustomSearchService customSearchApiService) {
        this.customSearchApiService = customSearchApiService;
    }

    @Override
    public Observable<Collection<Image>> searchImages(String query) {
        return customSearchApiService.searchImages(query);
    }
}
