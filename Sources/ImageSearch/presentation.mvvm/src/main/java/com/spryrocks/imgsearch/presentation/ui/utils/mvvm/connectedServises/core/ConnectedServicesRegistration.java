package com.spryrocks.imgsearch.presentation.ui.utils.mvvm.connectedServises.core;

import android.support.annotation.Nullable;

import com.spryrocks.android.modules.ui.lifecycle.ILifecycleListener;
import com.spryrocks.android.modules.ui.lifecycle.ILifecycleListenersCollection;
import com.spryrocks.android.modules.ui.lifecycle.LifecycleListener;

public class ConnectedServicesRegistration extends LifecycleListener implements IConnectedServicesRegistration {
    private final ILifecycleListenersCollection lifecycleListenersCollection;
    private final IConnectedServicesManager connectedServicesManager;
    private final IConnectedServiceReceiver connectedServiceReceiver;
    private final IConnectedServicesCallbacksReceiver connectedServicesCallbacksReceiver;

    public ConnectedServicesRegistration(IConnectedServicesOwner connectedServicesOwner, ILifecycleListenersCollection lifecycleListenersCollection) {
        this.lifecycleListenersCollection = lifecycleListenersCollection;

        IConnectedServices connectedServices = connectedServicesOwner.getConnectedServices();
        connectedServicesManager = (IConnectedServicesManager) connectedServices;
        connectedServiceReceiver = connectedServices;
        connectedServicesCallbacksReceiver = connectedServices;

        lifecycleListenersCollection.registerLifecycleListener(this);
    }

    @Override
    public <TService extends IConnectedService, TServiceImpl extends TService> TServiceImpl connectService(Class<TService> serviceClass, TServiceImpl service) {
        connectedServicesManager.connectService(serviceClass, service);

        if (service instanceof ILifecycleListener)
            lifecycleListenersCollection.registerLifecycleListener((ILifecycleListener) service);

        return service;
    }

    @Override
    public <TService extends IConnectedService> void disconnectService(Class<TService> serviceClass) {
        connectedServicesManager.disconnectService(serviceClass);
    }

    @Override
    public void clearServices() {
        connectedServicesManager.clearServices();
    }

    @Override
    public <TCallbacks extends IConnectedServiceCallbacks> TCallbacks getCallbacks(Class<TCallbacks> callbacksClass) {
        return connectedServicesCallbacksReceiver.getCallbacks(callbacksClass);
    }

    @Nullable
    @Override
    public <TService extends IConnectedService> TService getService(Class<TService> serviceClass) {
        return connectedServiceReceiver.getService(serviceClass);
    }

    @Override
    public void onDestroy() {
        clearServices();
    }
}
