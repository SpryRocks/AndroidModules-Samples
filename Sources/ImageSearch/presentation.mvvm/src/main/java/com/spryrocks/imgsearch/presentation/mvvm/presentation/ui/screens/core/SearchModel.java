package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import com.spryrocks.imgsearch.data.models.Image;
import com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.utils.mvvm.ObservableField;
import com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.utils.mvvm.OnClickCommand;

import java.util.Collection;

public class SearchModel {
    public final ObservableField<String> text = new ObservableField<>();
    public final OnClickCommand searchClickCommand = new OnClickCommand();
    public final ObservableField<Collection<Image>> images = new ObservableField<>();
}
