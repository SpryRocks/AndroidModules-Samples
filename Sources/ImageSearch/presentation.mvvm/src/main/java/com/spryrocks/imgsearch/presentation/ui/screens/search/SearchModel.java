package com.spryrocks.imgsearch.presentation.ui.screens.search;

import com.spryrocks.android.modules.ui.mvvm.model.ObservableField;
import com.spryrocks.android.modules.ui.mvvm.model.OnClickCommand;
import com.spryrocks.imgsearch.data.models.Image;

import java.util.Collection;

public class SearchModel {
    public final ObservableField<String> text = new ObservableField<>();
    public final OnClickCommand searchClickCommand = new OnClickCommand();
    public final ObservableField<Collection<Image>> images = new ObservableField<>();
}
