package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.presentationmvvm.BR;

class MvvmViewUtil {
    static <TBinding extends ViewDataBinding, TViewModel extends BaseViewModel>
    TBinding inflateAndInitBinding(
            IMvvmView<TBinding, TViewModel> mvvmView,
            LayoutInflater inflater, ViewGroup container,
            @LayoutRes int layoutId, TViewModel viewModel) {
        TBinding binding = DataBindingUtil.inflate(inflater, layoutId, container, false);

        binding.setVariable(BR.viewModel, viewModel);
        binding.setVariable(BR.model, viewModel.model);

        mvvmView.initBinding(binding);

        return binding;
    }
}
