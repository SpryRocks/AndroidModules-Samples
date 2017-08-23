package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;

import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends AndroidViewModel {
    final SearchModel model = new SearchModel();
    private final CompositeDisposable compositeDisposable;

    @Inject
    ISearchInteractor searchInteractor;

    public SearchViewModel(Application application) {
        super(application);
        SearchComponent.create(application).inject(this);
        this.compositeDisposable = new CompositeDisposable();

        model.searchClickCommand.addCallback(this::search);
    }

    private void search() {
        String searchQuery = model.text.get();

        searchInteractor.searchImages(searchQuery)
                .doOnSubscribe(compositeDisposable::add)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(images -> {
                    //noinspection Convert2MethodRef,ResultOfMethodCallIgnored
                    images.toString();
                }, throwable -> {
                    //noinspection Convert2MethodRef
                    throwable.printStackTrace();
                });
    }
}
