package com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core;

import android.support.annotation.Nullable;

public interface IConnectedServicesCallbacksReceiver {
    @Nullable <TCallbacks extends IConnectedServiceCallbacks> TCallbacks getCallbacks(Class<TCallbacks> callbacksClass);
}