package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.widget.EditText;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.screens.BaseFragment;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.Collection;

import javax.inject.Inject;

@OptionsMenu(R.menu.search)
@EFragment(R.layout.fragment_search)
public class SearchFragment extends BaseFragment implements ISearchView {
    @ViewById
    protected EditText search_editText;

    @Inject
    protected ISearchPresenter presenter;

    public SearchFragment() {
        DaggerSearchComponent.create().inject(this);

        presenterCollection.registerPresenter(presenter, this);
    }

    @OptionsItem(R.id.search_menuItem)
    protected void search_menuItem_click() {
        presenter.search();
    }

    @Override
    public String getSearchQuery() {
        return search_editText.getText().toString();
    }

    @Override
    public void showImages(Collection<Image> images) {
        // TODO: 18.05.2017 implement
    }
}
