package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core;

import android.app.Application;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.domain.interactors.ISearchInteractor;
import com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core.services.alert.IAlertService;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class SearchViewModel extends BaseViewModel {
    final SearchModel model = new SearchModel();
    private final CompositeDisposable compositeDisposable;

    @Inject
    ISearchInteractor searchInteractor;

    public SearchViewModel(Application application) {
        super(application, new SearchViewModel(application));
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
                .subscribe(this::setImages, this::handleError);
    }

    private void setImages(Collection<Image> images) {
        model.images.set(new ArrayList<>(images));
    }

    private void handleError(Throwable throwable) {
        throwable.printStackTrace();
        useService(IAlertService.class, service -> service.showMessage("Error", throwable.getMessage()));
    }
}
