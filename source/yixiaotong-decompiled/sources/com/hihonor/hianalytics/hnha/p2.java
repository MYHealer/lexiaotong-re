package com.hihonor.hianalytics.hnha;

import com.hihonor.hianalytics.receiver.UserUnLockedBroadcastReceiver;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class p2 {
    private static final p2 j = new p2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.hihonor.hianalytics.mid.policy.a f3670a;
    private t2 b;
    private g3 c;
    private f3 d;
    private q2 e;
    private r2 f;
    private UserUnLockedBroadcastReceiver h;
    private HashSet<String> g = new HashSet<>();
    private boolean i = false;

    private p2() {
    }

    public static p2 a() {
        return j;
    }

    public static q2 b() {
        p2 p2Var = j;
        q2 q2Var = p2Var.e;
        if (q2Var != null) {
            return q2Var;
        }
        synchronized (p2Var) {
            q2 q2Var2 = p2Var.e;
            if (q2Var2 != null) {
                return q2Var2;
            }
            q2 q2Var3 = new q2();
            p2Var.e = q2Var3;
            return q2Var3;
        }
    }

    public static t2 c() {
        String str;
        String str2;
        p2 p2Var = j;
        t2 t2Var = p2Var.b;
        if (t2Var != null) {
            if (!(t2Var instanceof s2) || !SystemUtils.a()) {
                return p2Var.b;
            }
            p2Var.h();
        }
        synchronized (p2Var) {
            t2 t2Var2 = p2Var.b;
            if (t2Var2 != null) {
                return t2Var2;
            }
            if (SystemUtils.a()) {
                p2Var.b = new t2();
                str = "HaMidManager";
                str2 = "use EventManager";
            } else {
                p2Var.b = new s2();
                str = "HaMidManager";
                str2 = "use EventDirectBootManager";
            }
            j2.c(str, str2);
            return p2Var.b;
        }
    }

    public static r2 d() {
        p2 p2Var = j;
        r2 r2Var = p2Var.f;
        if (r2Var != null) {
            return r2Var;
        }
        synchronized (p2Var) {
            r2 r2Var2 = p2Var.f;
            if (r2Var2 != null) {
                return r2Var2;
            }
            r2 r2Var3 = new r2();
            p2Var.f = r2Var3;
            return r2Var3;
        }
    }

    public static com.hihonor.hianalytics.mid.policy.a e() {
        p2 p2Var = j;
        com.hihonor.hianalytics.mid.policy.a aVar = p2Var.f3670a;
        if (aVar != null) {
            return aVar;
        }
        synchronized (p2Var) {
            com.hihonor.hianalytics.mid.policy.a aVar2 = p2Var.f3670a;
            if (aVar2 != null) {
                return aVar2;
            }
            com.hihonor.hianalytics.mid.policy.a aVar3 = new com.hihonor.hianalytics.mid.policy.a();
            p2Var.f3670a = aVar3;
            return aVar3;
        }
    }

    public static f3 f() {
        p2 p2Var = j;
        f3 f3Var = p2Var.d;
        if (f3Var != null) {
            return f3Var;
        }
        synchronized (p2Var) {
            f3 f3Var2 = p2Var.d;
            if (f3Var2 != null) {
                return f3Var2;
            }
            f3 f3Var3 = new f3();
            p2Var.d = f3Var3;
            return f3Var3;
        }
    }

    public static g3 g() {
        p2 p2Var = j;
        g3 g3Var = p2Var.c;
        if (g3Var != null) {
            return g3Var;
        }
        synchronized (p2Var) {
            g3 g3Var2 = p2Var.c;
            if (g3Var2 != null) {
                return g3Var2;
            }
            g3 g3Var3 = new g3();
            p2Var.c = g3Var3;
            return g3Var3;
        }
    }

    private void i() {
        if (this.h != null) {
            return;
        }
        UserUnLockedBroadcastReceiver userUnLockedBroadcastReceiver = new UserUnLockedBroadcastReceiver();
        this.h = userUnLockedBroadcastReceiver;
        userUnLockedBroadcastReceiver.a();
    }

    public void a(String str) {
        long jA = com.hihonor.hianalytics.util.r.a();
        synchronized (this) {
            if (!SystemUtils.a()) {
                this.g.add(str);
                i();
                j2.c("HaMidManager", "not unlock refuse init");
                return;
            }
            boolean z = this.i;
            if (!z) {
                this.i = true;
            }
            if (!z) {
                t3.f(new d3(str));
            }
            t3.f(new x2(str, !z));
            t3.f(new w2(str));
            j2.c("HaMidManager", "init initSpendTime=" + (com.hihonor.hianalytics.util.r.a() - jA) + ",tag=" + str + ",hasInit=" + z);
        }
    }

    public void h() {
        j2.c("HaMidManager", "initByUserUnLock");
        p2 p2Var = j;
        synchronized (p2Var) {
            t2 t2Var = p2Var.b;
            if (t2Var == null || (t2Var instanceof s2)) {
                p2Var.b = new t2();
            }
        }
        HashSet<String> hashSet = this.g;
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator<String> it = this.g.iterator();
        while (it.hasNext()) {
            a(it.next());
            it.remove();
        }
    }
}
