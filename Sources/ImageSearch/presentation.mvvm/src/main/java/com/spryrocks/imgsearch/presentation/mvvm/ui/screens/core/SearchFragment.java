package com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.example.presentationmvvm.R;
import com.example.presentationmvvm.databinding.FragmentSearchBinding;
import com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core.services.alert.AlertService;
import com.spryrocks.imgsearch.presentation.mvvm.ui.screens.core.services.alert.IAlertService;
import com.spryrocks.imgsearch.presentation.mvvm.ui.utils.AlertDialogHelper;
import com.spryrocks.imgsearch.presentation.mvvm.ui.utils.mvvm.connectedServises.core.ConnectedServicesRegistration;

import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

@EFragment
public class SearchFragment extends MvvmFragment<FragmentSearchBinding, SearchViewModel> {
    private SearchViewModel viewModel;

    @Inject
    AlertDialogHelper alertDialogHelper;

    public SearchFragment() {
        super(R.layout.fragment_search, SearchViewModel.class);
    }

    @Override
    public void initConnectedServices(ConnectedServicesRegistration services) {
        Context context = getContext();

        services.connectService(IAlertService.class, new AlertService(context, alertDialogHelper));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
    }

    @Override
    public void initBinding(FragmentSearchBinding binding) {
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
    }
}