package com.spryrocks.imgsearch.presentation.ui.screens.core;

import android.databinding.ViewDataBinding;

import com.spryrocks.imgsearch.presentation.BR;

public abstract class MvvmFragment<TBinding extends ViewDataBinding, TViewModel extends com.spryrocks.android.modules.ui.mvvm.BaseViewModel>
        extends com.spryrocks.android.modules.ui.mvvm.MvvmFragment<TBinding, TViewModel> {
    protected MvvmFragment(int layoutId, Class<TViewModel> tViewModelClass) {
        super(layoutId, tViewModelClass, BR.model);
    }
}
