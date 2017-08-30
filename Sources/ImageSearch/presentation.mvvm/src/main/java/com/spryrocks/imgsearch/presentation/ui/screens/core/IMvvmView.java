package com.spryrocks.imgsearch.presentation.ui.screens.core;

import android.databinding.ViewDataBinding;

import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.ConnectedServicesRegistration;

public interface IMvvmView<TBinding extends ViewDataBinding, TViewModel extends BaseViewModel> {
    void initViewModel(TViewModel viewModel);

    void initConnectedServices(ConnectedServicesRegistration services);

    void initBinding(TBinding binding);

    TBinding getBinding();

    TViewModel getViewModel();
}
