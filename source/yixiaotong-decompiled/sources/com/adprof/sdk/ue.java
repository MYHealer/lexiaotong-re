package com.adprof.sdk;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ue implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1458a;

    public ue(Context context) {
        this.f1458a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1458a == null || ebVar == null) {
            return;
        }
        try {
            Intent intent = new Intent("com.bun.msa.action.start.service");
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra("com.bun.msa.param.pkgname", this.f1458a.getPackageName());
            this.f1458a.startForegroundService(intent);
        } catch (Exception unused) {
        }
        Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.putExtra("com.bun.msa.param.pkgname", this.f1458a.getPackageName());
        qg.a(this.f1458a, intent2, ebVar, new te(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1458a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
