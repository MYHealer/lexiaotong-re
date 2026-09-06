package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fq {
    public static _bx _a;

    public static void _a(String str, Throwable th) {
        if (_a == null || !Logger.isDebug()) {
            return;
        }
        Logger.e(str, th);
    }

    public static boolean _a() {
        _bx _bxVar = _a;
        if (_bxVar != null) {
            ((_cm) _bxVar).getClass();
            if (Logger.isDebug()) {
                return true;
            }
        }
        return false;
    }
}
