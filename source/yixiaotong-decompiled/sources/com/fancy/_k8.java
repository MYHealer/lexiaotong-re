package com.fancy;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _k8 {
    public static final ConcurrentHashMap _a = new ConcurrentHashMap();
    public static final AtomicLong _b = new AtomicLong();

    public static String _a(_k6 _k6Var) {
        String string = _ie._a("cache_").append(_b.incrementAndGet()).append("_").append(System.currentTimeMillis()).toString();
        _a.put(string, _k6Var);
        return string;
    }
}
