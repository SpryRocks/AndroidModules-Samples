package com.spryrocks.imgsearch.data.api.google;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RestApi {
    @GET("customsearch/v1")
    Observable<CustomSearchResponse> search(@Query("key") String key, @Query("cx") String cx,
                                            @Query("searchType") String searchType,
                                            @Query("q") String q);
}
