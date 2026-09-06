package com.hihonor.hianalytics.hnha;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class x0 {
    static Map<String, c1> b = new ConcurrentHashMap();
    private static final x0 c = new x0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b1 f3695a = new b1();

    private x0() {
    }

    public static x0 c() {
        return c;
    }

    public c1 a(String str) {
        return b.get(str);
    }

    public Set<String> a() {
        return b.keySet();
    }

    public void a(String str, c1 c1Var) {
        b.put(str, c1Var);
    }

    public b1 b() {
        return this.f3695a;
    }
}
