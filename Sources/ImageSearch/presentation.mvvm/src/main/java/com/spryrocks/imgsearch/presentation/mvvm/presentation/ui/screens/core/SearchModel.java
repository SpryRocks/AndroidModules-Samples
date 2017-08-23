package com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.screens.core;

import com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.utils.mvvm.ObservableField;
import com.spryrocks.imgsearch.presentation.mvvm.presentation.ui.utils.mvvm.OnClickCommand;

public class SearchModel {
    public final ObservableField<String> text = new ObservableField<>();
    public final OnClickCommand searchClickCommand = new OnClickCommand();
}
