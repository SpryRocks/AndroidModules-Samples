package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import android.arch.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {
    final SearchModel model = new SearchModel();

    public SearchViewModel() {
        model.searchClickCommand.addCallback(this::search);
    }

    private void search() {
        String text = model.text.get();
    }
}
