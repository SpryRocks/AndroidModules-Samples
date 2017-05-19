package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.presentation.ui.adapters.ImagesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
class SearchUiModule {
    private final Context context;

    SearchUiModule(Context context) {
        this.context = context;
    }

    @Provides
    ISearchPresenter provideSearchPresenter() {
        return new SearchPresenter();
    }

    @Provides
    ImagesAdapter provideImagesAdapter() {
        return new ImagesAdapter(context);
    }
}
