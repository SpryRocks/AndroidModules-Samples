package com.spryrocks.imgsearch.presentation.ui.screens.core;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.ConnectedServices;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.IConnectedService;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.IConnectedServices;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.IConnectedServicesOwner;
import com.spryrocks.imgsearch.presentation.ui.utils.Monads;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import static com.spryrocks.imgsearch.presentation.ui.utils.Monads.maybeNull;

public class BaseViewModel<TModel> extends AndroidViewModel implements IConnectedServicesOwner {
    public final TModel model;
    private final IConnectedServices connectedServices;
    private final CompositeDisposable compositeDisposable;

    public BaseViewModel(Application application, TModel model) {
        super(application);

        this.model = model;

        ConnectedServices connectedServices = new ConnectedServices();
        initConnectedServices(connectedServices);
        this.connectedServices = connectedServices;

        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public IConnectedServices getConnectedServices() {
        return connectedServices;
    }

    protected void initConnectedServices(ConnectedServices connectedServices) {
    }

    @SuppressWarnings("WeakerAccess")
    @Nullable
    protected <TService extends IConnectedService> TService getService(Class<TService> serviceClass) {
        return connectedServices.getService(serviceClass);
    }

    protected <TService extends IConnectedService> void useService(Class<TService> serviceClass, Monads.Action1<TService> action) {
        maybeNull(getService(serviceClass), action);
    }

    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    @Override
    protected void onCleared() {
        compositeDisposable.clear();
        // TODO: 02.08.2017 clear callbacks
        // TODO: 02.08.2017 clear connected services?
    }

    protected Resources getResources() {
        return getApplication().getResources();
    }

    protected String getString(@StringRes int id) {
        return getResources().getString(id);
    }
}
