package com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core;

import android.support.annotation.Nullable;

public interface IConnectedServiceReceiver {
    @Nullable <TService extends IConnectedService> TService getService(Class<TService> serviceClass);
}
