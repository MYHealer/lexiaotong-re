package com.fancy;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lz implements Runnable {
    public final /* synthetic */ Collection _a;

    public _lz(Collection collection) {
        this._a = collection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Pattern patternCompile;
        try {
            for (String str : this._a) {
                try {
                    String str_c = com.fancy.adsdk.lib.utils._a._c(str);
                    ConcurrentHashMap concurrentHashMap = _ly._a;
                    if (!concurrentHashMap.containsKey(str_c) && (patternCompile = Pattern.compile(str)) != null) {
                        concurrentHashMap.put(str_c, patternCompile);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
