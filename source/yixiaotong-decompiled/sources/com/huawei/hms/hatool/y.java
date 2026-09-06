package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class y {
    private static y b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, p0> f4115a = new HashMap();

    private y() {
    }

    private p0 a(String str) {
        if (!this.f4115a.containsKey(str)) {
            this.f4115a.put(str, new p0());
        }
        return this.f4115a.get(str);
    }

    public static y a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new y();
        }
    }

    public p0 a(String str, long j) {
        p0 p0VarA = a(str);
        p0VarA.a(j);
        return p0VarA;
    }
}
