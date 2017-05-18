package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.android.modules.ui.mvp.v1.ui.PresenterBase;
import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

class SearchPresenter extends PresenterBase<ISearchView> implements ISearchPresenter {
    @Inject
    ISearchInteractor searchInteractor; // TODO: 18.05.2017 use manager, handle lifecycle, cancel preview requests

    SearchPresenter() {
        DaggerSearchComponent.create().inject(this);
    }

    @Override
    public void search() {
        String searchQuery = getView().getSearchQuery();

        searchInteractor.searchImages(searchQuery)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Image>() {
                    @Override
                    public void accept(Image image) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
