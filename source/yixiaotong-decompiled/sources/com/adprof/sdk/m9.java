package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m9 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1303a;

    public m9(Context context) {
        this.f1303a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1303a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        qg.a(this.f1303a, intent, ebVar, new l9(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1303a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
