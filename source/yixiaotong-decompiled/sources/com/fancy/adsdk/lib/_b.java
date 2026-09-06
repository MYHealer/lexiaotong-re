package com.fancy.adsdk.lib;

import android.content.Context;
import com.fancy.adsdk.lib.provider.PtgAdNative;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _b implements Runnable {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ PtgSDKConfig _b;
    public final /* synthetic */ PtgAdNative[] _c;
    public final /* synthetic */ PtgAdSdk.Callback _d;

    public _b(Context context, PtgSDKConfig ptgSDKConfig, PtgAdSdk.Callback callback, PtgAdNative[] ptgAdNativeArr) {
        this._a = context;
        this._b = ptgSDKConfig;
        this._c = ptgAdNativeArr;
        this._d = callback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _a._a(this._a, this._b, this._d, this._c);
    }
}
