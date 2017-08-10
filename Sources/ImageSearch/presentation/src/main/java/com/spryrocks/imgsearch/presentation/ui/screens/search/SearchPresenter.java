package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.android.modules.ui.mvp.v1.ui.PresenterBase;
import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

class SearchPresenter extends PresenterBase<ISearchView> implements ISearchPresenter {
    private final ISearchInteractor searchInteractor; // TODO: 18.05.2017 use manager, handle lifecycle, cancel preview requests
    private final CompositeDisposable compositeDisposable;

    SearchPresenter(ISearchInteractor searchInteractor) {
        this.searchInteractor = searchInteractor;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void search() {
        String searchQuery = getView().getSearchQuery();

        searchInteractor.searchImages(searchQuery)
                .doOnSubscribe(compositeDisposable::add)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getView()::showImages,
                        getView()::handleError);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        compositeDisposable.clear();
    }
}
