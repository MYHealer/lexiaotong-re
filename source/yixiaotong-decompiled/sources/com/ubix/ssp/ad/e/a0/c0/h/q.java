package com.ubix.ssp.ad.e.a0.c0.h;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class q implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8665a;
    private Class<?> b;
    private Object c;

    public q(Context context) {
        this.f8665a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
        }
    }

    private String b() {
        return (String) this.b.getMethod("getOAID", Context.class).invoke(this.c, this.f8665a);
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8665a == null || cVar == null) {
            return;
        }
        if (this.b == null || this.c == null) {
            cVar.a(new com.ubix.ssp.ad.e.a0.c0.e("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.ubix.ssp.ad.e.a0.c0.e("OAID query failed");
            }
            com.ubix.ssp.ad.e.a0.c0.f.a("OAID query success: " + strB);
            cVar.a(strB);
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            cVar.a(e);
        }
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        return this.c != null;
    }
}
