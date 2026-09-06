package com.fancy;

import com.fancy.adsdk.lib.PtgAdSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _iq {
    public static boolean _a(int i) {
        if (PtgAdSdk.getContext() == null) {
            return false;
        }
        if (i != 1) {
            return i == 2 && _gx._b(PtgAdSdk.getContext()) == 1;
        }
        return -1 != _gx._b(PtgAdSdk.getContext());
    }
}
