package com.adprof.sdk;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qp implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class f694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object f695a;

    public qp(Context context) {
        this.f1392a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f694a = cls;
            this.f695a = cls.newInstance();
        } catch (Exception unused) {
        }
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1392a == null || ebVar == null) {
            return;
        }
        Class cls = this.f694a;
        if (cls == null || this.f695a == null) {
            ebVar.a(new mg("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String str = (String) cls.getMethod("getOAID", Context.class).invoke(this.f695a, this.f1392a);
            if (str == null || str.length() == 0) {
                throw new mg("OAID query failed");
            }
            ebVar.a(str);
        } catch (Exception e) {
            ebVar.a(e);
        }
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        return this.f695a != null;
    }
}
