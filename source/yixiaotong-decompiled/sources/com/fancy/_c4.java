package com.fancy;

import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final /* synthetic */ class _c4 {
    public static void _a(int i, String str, Object obj, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        nativeExpressAdListener.onError(new AdErrorImpl(i, str, obj));
    }
}
