package com.spryrocks.imgsearch.presentation.ui.screens.search;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.spryrocks.imgsearch.presentation.R;
import com.spryrocks.imgsearch.presentation.databinding.FragmentSearchBinding;
import com.spryrocks.imgsearch.presentation.services.alert.AlertService;
import com.spryrocks.imgsearch.presentation.services.alert.IAlertService;
import com.spryrocks.imgsearch.presentation.ui.screens.core.MvvmFragment;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.ConnectedServicesRegistration;
import com.spryrocks.imgsearch.presentation.ui.utils.AlertDialogHelper;

import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;

import javax.inject.Inject;

@EFragment
@OptionsMenu(R.menu.search)
public class SearchFragment extends MvvmFragment<FragmentSearchBinding, SearchViewModel> {
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
        SearchUiComponent.create(getContext()).inject(this);

        super.onCreate(savedInstanceState);
    }

    @Override
    public void initBinding(FragmentSearchBinding binding) {
        binding.recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false));
    }

    @OptionsItem(R.id.search_menuItem)
    protected void search_menuItem_click() {
        getViewModel().model.searchClickCommand.onClick();
    }
}