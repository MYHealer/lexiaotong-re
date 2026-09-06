package com.adprof.sdk;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class da extends fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f1125a;

    public da(ea eaVar) {
        this.f1125a = eaVar;
    }

    @Override // com.adprof.sdk.gb
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.adprof.sdk.gb
    public void a(int i, Bundle bundle) {
        Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo= " + bundle);
        if (i != 0 || bundle == null) {
            Log.e("AdvertisingIdPlatform", "OAIDLimitCallback handleResult error retCode= " + i);
        } else if (this.f1125a.f240a != null) {
            boolean z = bundle.getBoolean("oa_id_limit_state");
            this.f1125a.f240a.f168a = z;
            pk.a("AdvertisingIdPlatform", "OAIDLimitCallback handleResult success  isLimit=" + z);
        }
        this.f1125a.f243a.countDown();
    }
}
