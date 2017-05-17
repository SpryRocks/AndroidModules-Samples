package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.screens.BaseFragment;

import org.androidannotations.annotations.EFragment;

import javax.inject.Inject;

@EFragment(R.layout.fragment_search)
public class SearchFragment extends BaseFragment implements ISearchView {
    @Inject
    protected ISearchPresenter presenter;

    public SearchFragment() {
        DaggerSearchComponent.create().inject(this);

        presenterCollection.registerPresenter(presenter, (ISearchView) this);
    }
}
