package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.data.models.Image;

import java.util.Collection;

import io.reactivex.Observable;

public interface ISearchInteractor {
    Observable<Collection<Image>> searchImages(String searchQuery);
}
