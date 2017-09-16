package com.spryrocks.imgsearch.presentation.services.alert;

import com.spryrocks.android.modules.ui.mvvm.connectedServices.IConnectedService;

public interface IAlertService extends IConnectedService {
    void showMessage(String title, String message);

    void showToast(String message);
}
