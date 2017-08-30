package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;

import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;
import com.spryrocks.imgsearch.presentation.adapters.ImagesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
class SearchModule {
    private final Context context;

    SearchModule(Context context) {
        this.context = context;
    }

    @Provides
    ISearchPresenter provideSearchPresenter(ISearchInteractor searchInteractor) {
        return new SearchPresenter(searchInteractor);
    }

    @Provides
    ImagesAdapter provideImagesAdapter() {
        return new ImagesAdapter(context);
    }
}
