package com.yfanads.android.adx.core.impl;

import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.api.LoadManager;

/* JADX INFO: compiled from: LoadDefMgrImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d implements LoadManager {
    @Override // com.yfanads.android.adx.api.LoadManager
    public final void loadNativeAd(AdxScene adxScene, LoadManager.NativeAdListener nativeAdListener) {
        nativeAdListener.onError(0, "SDK not init success");
    }

    @Override // com.yfanads.android.adx.api.LoadManager
    public final void reportAdInfo(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, String[] strArr5) {
    }
}
