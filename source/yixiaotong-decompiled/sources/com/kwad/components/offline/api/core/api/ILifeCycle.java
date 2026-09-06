package com.kwad.components.offline.api.core.api;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ILifeCycle {
    Activity getCurrentActivity();

    boolean isAppOnForeground();

    int registerLifeCycleListener(ILifeCycleListener iLifeCycleListener);

    void unregisterLifeCycleListener(int i);
}
