package com.adprof.sdk;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ca extends fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ea f1106a;

    public ca(ea eaVar) {
        this.f1106a = eaVar;
    }

    @Override // com.adprof.sdk.gb
    public void a(int i, long j, boolean z, float f, double d, String str) {
    }

    @Override // com.adprof.sdk.gb
    public void a(int i, Bundle bundle) {
        Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult retCode=" + i + " retInfo=" + bundle);
        if (i != 0 || bundle == null) {
            Log.e("AdvertisingIdPlatform", "OAIDCallBack handleResult error retCode=$ " + i);
        } else if (this.f1106a.f240a != null) {
            String string = bundle.getString("oa_id_flag");
            this.f1106a.f240a.f1099a = string;
            pk.a("AdvertisingIdPlatform", "OAIDCallBack handleResult success " + string);
        }
        this.f1106a.f243a.countDown();
    }
}
