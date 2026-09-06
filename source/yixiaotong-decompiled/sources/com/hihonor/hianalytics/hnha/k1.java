package com.hihonor.hianalytics.hnha;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class k1 {
    private static k1 b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Map<String, l1> f3653a = new HashMap();

    private k1() {
    }

    public static k1 a() {
        if (b == null) {
            b();
        }
        return b;
    }

    private l1 a(String str) {
        l1 l1Var;
        synchronized (this) {
            if (!this.f3653a.containsKey(str)) {
                this.f3653a.put(str, new l1());
            }
            l1Var = this.f3653a.get(str);
        }
        return l1Var;
    }

    private static synchronized void b() {
        if (b == null) {
            b = new k1();
        }
    }

    public void a(String str, long j) {
        l1 l1VarA = a(str);
        if (l1VarA != null) {
            l1VarA.c(j);
        }
    }

    public void b(String str) {
        l1 l1VarA = a(str);
        if (l1VarA != null) {
            l1VarA.a();
        }
    }

    public void b(String str, long j) {
        l1 l1VarA = a(str);
        if (l1VarA != null) {
            l1VarA.a(j);
        }
    }

    public l1 c(String str, long j) {
        j2.a("SessionHandler", "refreshSession tag=" + str + ",timestamp=" + j);
        l1 l1VarA = a(str);
        if (l1VarA != null) {
            l1VarA.b(j);
        }
        return l1VarA;
    }
}
