package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _io {
    public static final ConcurrentHashMap<String, Long> _a = new ConcurrentHashMap<>();

    public static long _a(_f _fVar, AdSlot adSlot) {
        long j;
        long countdownTime = adSlot != null ? adSlot.getCountdownTime() : 0L;
        if (_fVar != null) {
            _ba _baVar = _fVar._G;
            j = _baVar != null ? _baVar._c : 5L;
        } else {
            j = 0;
        }
        if (countdownTime <= 0) {
            countdownTime = j > 0 ? j : 5L;
        }
        return (countdownTime > 3 ? Math.min(countdownTime, 15L) : 3L) * 1000;
    }

    public static boolean _a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return _a.containsKey(str);
    }

    public static void _b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        _a.remove(str);
    }
}
