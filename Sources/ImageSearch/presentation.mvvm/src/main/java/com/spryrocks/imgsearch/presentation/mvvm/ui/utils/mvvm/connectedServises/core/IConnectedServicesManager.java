package com.spryrocks.imgsearch.presentation.mvvm.ui.utils.mvvm.connectedServises.core;

public interface IConnectedServicesManager {
    @SuppressWarnings("UnusedReturnValue")
    <TService extends IConnectedService, TServiceImpl extends TService> TServiceImpl connectService(Class<TService> serviceClass, TServiceImpl serviceImpl);
    <TService extends IConnectedService> void disconnectService(Class<TService> serviceClass);

    void clearServices();
}
