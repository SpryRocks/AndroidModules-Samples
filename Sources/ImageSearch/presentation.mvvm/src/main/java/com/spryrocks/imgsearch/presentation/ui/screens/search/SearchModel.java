package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.ObservableField;
import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.OnClickCommand;

import java.util.Collection;

public class SearchModel {
    public final ObservableField<String> text = new ObservableField<>();
    public final OnClickCommand searchClickCommand = new OnClickCommand();
    public final ObservableField<Collection<Image>> images = new ObservableField<>();
}
