package com.adprof.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class r8 implements hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o8 f1398a;

    public r8() {
        if (this.f1398a == null) {
            this.f1398a = new o8();
        }
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a */
    public boolean mo652a() {
        Context context = AdprofSdk.getInstance().getContext();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE");
        o8 o8Var = this.f1398a;
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(o8Var, intentFilter);
            return false;
        }
        context.registerReceiver(o8Var, intentFilter, 2);
        return false;
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a */
    public void mo737a() {
        AdprofSdk.getInstance().getContext().unregisterReceiver(this.f1398a);
    }
}
