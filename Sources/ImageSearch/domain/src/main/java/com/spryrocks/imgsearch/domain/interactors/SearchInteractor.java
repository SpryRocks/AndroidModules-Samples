package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;

import java.util.ArrayList;
import java.util.Collection;

import io.reactivex.Observable;

class SearchInteractor implements ISearchInteractor {
    @Override
    public Observable<Collection<Image>> searchImages(String searchQuery) {
        // TODO: 18.05.2017 remove test data, implement

        Collection<Image> images = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            images.add(new Image("Pink Floyd", "https://i.ytimg.com/vi/NJQnzmH6jgc/maxresdefault.jpg"));
        }

        return Observable.just(images);
    }
}
