package com.kwad.components.offline.api.core.soloader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface SoLoadListener {
    void onFailed(int i, Throwable th);

    void onLoaded();

    void onPreUpdate();
}
