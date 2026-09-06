package com.hihonor.hianalytics.hnha;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class o3 {
    private static o3 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, n3> f3667a = new ConcurrentHashMap();

    private o3() {
    }

    public static o3 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new o3();
        }
    }

    public m3 a(byte[] bArr, Map<String, String> map, String str) {
        n3 n3Var = this.f3667a.get(str);
        if (n3Var != null) {
            return n3Var.a(bArr, map);
        }
        j2.c("ReportManager", "report instance is null");
        return new m3(-100, "");
    }

    public synchronized void a(String str, String[] strArr) {
        j2.c("HianalyticsSDK", "ReportManager:init instance with url");
        n3 n3Var = new n3(str);
        n3Var.a(strArr);
        this.f3667a.put(str, n3Var);
    }
}
