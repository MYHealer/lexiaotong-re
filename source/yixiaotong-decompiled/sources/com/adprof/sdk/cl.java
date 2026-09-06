package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class cl implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1115a;

    public cl(Context context) {
        this.f1115a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1115a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        qg.a(this.f1115a, intent, ebVar, new bl(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1115a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
