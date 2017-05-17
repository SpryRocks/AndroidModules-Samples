package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.screens.BaseFragment;

import org.androidannotations.annotations.EFragment;

@EFragment(R.layout.fragment_search)
public class SearchFragment extends BaseFragment implements ISearchView {
    private final ISearchPresenter presenter;

    public SearchFragment() {
        presenter = presenterCollection.registerPresenter(new SearchPresenter(), (ISearchView) this);
    }
}
