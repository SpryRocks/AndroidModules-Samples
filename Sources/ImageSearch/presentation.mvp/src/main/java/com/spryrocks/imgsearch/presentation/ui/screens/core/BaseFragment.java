package com.spryrocks.imgsearch.presentation.ui.screens.core;

import com.spryrocks.android.modules.ui.mvp.v1.PresenterCollection;

public class BaseFragment extends com.spryrocks.android.modules.ui.BaseFragment {
    protected final PresenterCollection presenterCollection;

    public BaseFragment() {
        registerLifecycleListener(presenterCollection = new PresenterCollection());
    }

    public void showError(Exception error) {
        handleError(error);
    }

    public void handleError(Throwable error) {
        BaseActivity activity = (BaseActivity) getActivity();
        activity.handleError(error);
    }
}
