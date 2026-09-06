package com.opos.mobad;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f6860a;
    private k b;

    public static final d a() {
        d dVar;
        d dVar2 = f6860a;
        if (dVar2 != null) {
            return dVar2;
        }
        synchronized (d.class) {
            dVar = f6860a;
            if (dVar == null) {
                dVar = new d();
                f6860a = dVar;
            }
        }
        return dVar;
    }

    public void a(Context context) {
        this.b = new com.opos.mobad.e.b(context);
    }

    public b b(Context context) {
        com.opos.mobad.c.f fVarK = com.opos.mobad.c.b.k();
        if (fVarK == null || !fVarK.a()) {
            com.opos.cmn.an.f.a.b("", "ad creator no init");
            return null;
        }
        if (this.b != null) {
            return new c(context, fVarK.b(), fVarK.c(), fVarK.d(), fVarK.e(), fVarK.g(), this.b);
        }
        com.opos.cmn.an.f.a.b("", "context service no init");
        return null;
    }
}
