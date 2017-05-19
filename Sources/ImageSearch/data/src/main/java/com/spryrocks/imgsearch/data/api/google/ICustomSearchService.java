package com.spryrocks.imgsearch.data.api.google;

import com.spryrocks.imgsearch.data.models.Image;

import java.util.Collection;

import io.reactivex.Observable;

public interface ICustomSearchService {
    Observable<Collection<Image>> searchImages(String query);
}
