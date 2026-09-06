package com.meishu.sdk.core.loader;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IAdLoader {
    void destroy();

    Context getContext();

    IAdLoadListener getLoaderListener();

    void loadAd();
}
