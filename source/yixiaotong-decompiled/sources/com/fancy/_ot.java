package com.fancy;

import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ot implements Error {
    public static final _ot _a = new _ot();

    @Override // com.fancy.adsdk.lib.interf.Error
    public final void onError(AdError adError) {
        Logger.e(adError.getMessage());
    }
}
