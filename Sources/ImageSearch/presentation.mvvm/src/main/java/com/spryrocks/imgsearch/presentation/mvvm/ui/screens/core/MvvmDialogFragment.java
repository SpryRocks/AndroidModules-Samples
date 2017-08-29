package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.spryrocks.android.modules.ui.BaseDialogFragment;
import com.spryrocks.imgsearch.presentation.mvvm.ui.utils.mvvm.connectedServises.core.ConnectedServicesRegistration;

public abstract class MvvmDialogFragment<TBinding extends ViewDataBinding, TViewModel extends BaseViewModel>
        extends BaseDialogFragment implements IMvvmView<TBinding, TViewModel> {
    @LayoutRes
    private final int layoutId;
    private final Class<TViewModel> viewModelClass;
    private TBinding binding;
    private TViewModel viewModel;

    protected MvvmDialogFragment(@LayoutRes int layoutId, Class<TViewModel> viewModelClass) {
        this.layoutId = layoutId;
        this.viewModelClass = viewModelClass;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        viewModel = ViewModelProviders.of(this).get(viewModelClass);
        initViewModel(viewModel);

        ConnectedServicesRegistration connectedServicesRegistration = new ConnectedServicesRegistration(viewModel, this);
        initConnectedServices(connectedServicesRegistration);
        // TODO: 02.08.2017 clear connected services?

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = MvvmViewUtil.inflateAndInitBinding(this, inflater, container, layoutId, viewModel);
        return binding.getRoot();
    }

    @SuppressWarnings("unused")
    @Override
    public void initViewModel(TViewModel viewModel) {
    }

    @Override
    public void initConnectedServices(ConnectedServicesRegistration services) {
    }

    @Override
    public void initBinding(@SuppressWarnings("unused") TBinding binding) {
    }

    @Override
    public TBinding getBinding() {
        return binding;
    }

    @Override
    public TViewModel getViewModel() {
        return viewModel;
    }
}
