package com.adprof.sdk;

import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class h9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1207a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a3 f334a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LinkedList f335a = new LinkedList();

    public h9(a3 a3Var, int i) {
        this.f1207a = i;
        this.f334a = a3Var;
    }

    public g9 a(q8 q8Var, d9 d9Var) {
        g9 g9Var;
        String str = q8Var.f674b;
        String str2 = q8Var.f672a;
        synchronized (this.f335a) {
            Iterator it = this.f335a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    g9Var = null;
                    break;
                }
                g9Var = (g9) it.next();
                if (g9Var.f317a.f674b.equals(str) && g9Var.f317a.f672a.equals(str2)) {
                    break;
                }
            }
        }
        if (g9Var == null) {
            g9Var = new g9(this, q8Var, d9Var);
            synchronized (this.f335a) {
                this.f335a.add(g9Var);
            }
            a();
        }
        return g9Var;
    }

    public void a() {
        synchronized (this.f335a) {
            Iterator it = this.f335a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (((g9) it.next()).f1188a == 1) {
                    i++;
                }
            }
            if (i >= this.f1207a) {
                return;
            }
            for (g9 g9Var : this.f335a) {
                if (g9Var.f1188a == 0) {
                    f9 f9Var = new f9(g9Var);
                    h9 h9Var = g9Var.f316a;
                    q8 q8Var = g9Var.f317a;
                    h9Var.getClass();
                    e9 e9Var = new e9(q8Var, f9Var);
                    g9Var.f1188a = 1;
                    a3 a3Var = g9Var.f316a.f334a;
                    if (a3Var != null) {
                        a3Var.a(e9Var);
                        i++;
                        if (i == this.f1207a) {
                            return;
                        }
                    }
                }
            }
        }
    }
}
