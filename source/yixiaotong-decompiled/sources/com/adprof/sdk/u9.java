package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u9 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1457a;

    public u9(Context context) {
        this.f1457a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1457a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        qg.a(this.f1457a, intent, ebVar, new t9(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1457a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
