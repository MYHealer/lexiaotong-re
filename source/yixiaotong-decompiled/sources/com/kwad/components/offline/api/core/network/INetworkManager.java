package com.kwad.components.offline.api.core.network;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface INetworkManager {
    void addNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);

    int getNetworkType(Context context);

    void removeNetworkChangeListener(Context context, INetworkChangeListener iNetworkChangeListener);
}
