package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vd implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1479a;

    public vd(Context context) {
        this.f1479a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1479a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        qg.a(this.f1479a, intent, ebVar, new ud(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1479a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
