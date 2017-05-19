package com.spryrocks.imgsearch.data.api.google;

import com.spryrocks.imgsearch.data.api.ApiBase;
import com.spryrocks.imgsearch.data.models.Image;

import java.util.ArrayList;
import java.util.Collection;

import io.reactivex.Observable;
import okhttp3.logging.HttpLoggingInterceptor;

class CustomSearchService extends ApiBase implements ICustomSearchService {
    private final CustomSearchServiceConfiguration configuration;

    private final RestApi restApi;

    CustomSearchService(CustomSearchServiceConfiguration configuration) {
        this.configuration = configuration;

        this.addLoggingInterceptor(HttpLoggingInterceptor.Level.BODY);
        this.restApi = createRetrofitApi("https://www.googleapis.com/", RestApi.class);
    }

    @Override
    public Observable<Collection<Image>> searchImages(String query) {
        return restApi.search(configuration.key, configuration.cx, "image", query)
                .map(customSearchResponse -> {
                    Collection<Image> images = new ArrayList<>();

                    for (CustomSearchResponse.Item item : customSearchResponse.items) {
                        if (item.mime == null || !isMimeTypeSupported(item.mime) || item.image == null)
                            continue;

                        images.add(new Image(item.title, item.image.thumbnailLink));
                    }

                    return images;
                });
    }

    private boolean isMimeTypeSupported(String mime) {
        return mime.equals("image/jpeg") || mime.equals("image/gif");
    }
}
