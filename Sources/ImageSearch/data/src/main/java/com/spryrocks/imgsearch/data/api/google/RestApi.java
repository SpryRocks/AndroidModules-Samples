package com.spryrocks.imgsearch.data.api.google;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("https://www.googleapis.com/customsearch/v1")
    void search(@Query("key") String key, @Query("cx") String cx, @Query("q") String q);
}
