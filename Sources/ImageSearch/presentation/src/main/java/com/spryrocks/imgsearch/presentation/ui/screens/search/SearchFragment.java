package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.screens.BaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import javax.inject.Inject;

@OptionsMenu(R.menu.search)
@EFragment(R.layout.fragment_search)
public class SearchFragment extends BaseFragment implements ISearchView {
    @Inject
    protected ISearchPresenter presenter;

    public SearchFragment() {
        DaggerSearchComponent.create().inject(this);

        presenterCollection.registerPresenter(presenter, (ISearchView) this);
    }

    @OptionsItem(R.id.search_menuItem)
    protected void search_menuItem_click() {
        presenter.search();
    }
}
