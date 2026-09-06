package com.adprof.sdk;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class k0 implements j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f1257a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference f414a;

    public k0(po poVar) {
        this.f414a = new WeakReference(poVar);
    }

    public final po a() {
        return (po) this.f414a.get();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m666a() {
        po poVarA = a();
        if (poVarA != null) {
            poVarA.d();
        }
    }

    public void a(d dVar) {
        po poVarA = a();
        if (poVarA != null) {
            try {
                if ((dVar.f == 2 && bg.b()) || dVar.f == 1) {
                    poVarA.e();
                }
            } catch (Exception unused) {
            }
        }
    }
}
