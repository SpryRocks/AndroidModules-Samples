package com.spryrocks.imgsearch.domain.interactors.concrete;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;

import io.reactivex.Observable;

public class SearchInteractor implements ISearchInteractor {
    @Override
    public Observable<Image> searchImages(String searchQuery) {
        throw new RuntimeException(); // TODO: 18.05.2017 implement
    }
}
