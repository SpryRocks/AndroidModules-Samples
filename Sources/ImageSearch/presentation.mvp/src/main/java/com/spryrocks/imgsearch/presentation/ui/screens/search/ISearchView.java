package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.android.modules.ui.mvp.v1.ui.IBaseView;
import com.spryrocks.imgsearch.data.models.Image;

import java.util.Collection;

interface ISearchView extends IBaseView {
    String getSearchQuery();

    void showImages(Collection<Image> images);

    void handleError(Throwable throwable);
}
