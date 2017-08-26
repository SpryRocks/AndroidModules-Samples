package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.ui.adapters.ImagesAdapter;
import com.spryrocks.imgsearch.presentation.ui.screens.BaseFragment;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

@OptionsMenu(R.menu.search)
@EFragment(R.layout.fragment_search)
public class SearchFragment extends BaseFragment implements ISearchView {
    @ViewById
    protected EditText search_editText;

    @ViewById
    protected RecyclerView recyclerView;

    @Inject
    protected ISearchPresenter presenter;

    @Inject
    protected ImagesAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        SearchComponent.create(getContext()).inject(this);

        presenterCollection.registerPresenter(presenter, this);

        super.onCreate(savedInstanceState);
    }

    @AfterViews
    protected void initViews() {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),
                3, GridLayoutManager.VERTICAL, false));

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
        List<ImagesAdapter.ImageItem> items = new ArrayList<>();

        for (Image image : images) {
            items.add(new ImagesAdapter.ImageItem(image));
        }

        adapter.setImages(items);
    }
}
