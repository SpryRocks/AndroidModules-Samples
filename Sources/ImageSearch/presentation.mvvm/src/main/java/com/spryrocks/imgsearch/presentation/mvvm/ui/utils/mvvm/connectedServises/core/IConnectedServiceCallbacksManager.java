package com.spryrocks.imgsearch.presentation.mvvm.ui.utils.mvvm.connectedServises.core;

public interface IConnectedServiceCallbacksManager {
    <TCallbacks extends IConnectedServiceCallbacks, TCallbacksImpl extends TCallbacks> void connectCallbacks(Class<TCallbacks> callbacksClass, TCallbacksImpl callbacks);
    <TCallbacks extends IConnectedServiceCallbacks> void disconnectCallbacks(Class<TCallbacks> callbacksClass);

    void clearCallbacks();
}
