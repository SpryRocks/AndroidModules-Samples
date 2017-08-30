package com.spryrocks.imgsearch.presentation.services.alert;

import com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core.IConnectedService;

public interface IAlertService extends IConnectedService {
    void showMessage(String title, String message);

    void showToast(String message);
}
