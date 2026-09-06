package com.adprof.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v3 implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1470a;

    public v3(Context context) {
        this.f1470a = context;
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1470a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        qg.a(this.f1470a, intent, ebVar, new u3(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1470a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
