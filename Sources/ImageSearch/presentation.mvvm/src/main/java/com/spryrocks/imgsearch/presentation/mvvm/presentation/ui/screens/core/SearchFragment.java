package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.presentationmvvm.databinding.FragmentSearchBinding;

import org.androidannotations.annotations.EFragment;

@EFragment
public class SearchFragment extends Fragment {
    private SearchViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater);
        binding.setModel(viewModel.model);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));

        return binding.getRoot();
    }
}
