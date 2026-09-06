package com.meishu.sdk.core.loader.concurrent;

import com.meishu.sdk.core.loader.AdPlatformError;

/* JADX INFO: compiled from: IConCurrentLoadListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface f {
    void a(AdPlatformError adPlatformError, int i);

    void a(Object obj, int i);

    void a(String str, int i, int i2);

    void b(Object obj, int i);

    void onAdExposure();
}
