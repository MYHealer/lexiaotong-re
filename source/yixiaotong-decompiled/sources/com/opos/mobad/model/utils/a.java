package com.opos.mobad.model.utils;

import android.os.SystemClock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, Long> f7216a = new ConcurrentHashMap();
    private Map<String, Integer> b = new ConcurrentHashMap();

    public void a(String str) {
        this.f7216a.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
    }

    public void a(String str, int i) {
        this.b.put(str, Integer.valueOf(i));
    }

    public boolean b(String str) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Long l = this.f7216a.get(str);
        Long lValueOf = Long.valueOf(l != null ? l.longValue() : 0L);
        Integer num = this.b.get(str);
        return jElapsedRealtime >= lValueOf.longValue() + ((long) Integer.valueOf(num != null ? num.intValue() : 0).intValue());
    }
}
