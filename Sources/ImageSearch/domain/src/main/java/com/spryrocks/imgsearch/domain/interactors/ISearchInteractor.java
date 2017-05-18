package com.spryrocks.imgsearch.domain.interactors;

import com.spryrocks.imgsearch.data.models.Image;

import io.reactivex.Observable;

public interface ISearchInteractor {
    Observable<Image> searchImages(String searchQuery);
}
