package com.adprof.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import com.ubix.ssp.open.comm.AdActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p3 implements hl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public jl f1355a = jl.STOP;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public o3 f544a;

    public p3() {
        if (this.f544a == null) {
            this.f544a = new o3();
        }
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a */
    public boolean mo652a() {
        jl jlVar = this.f1355a;
        jl jlVar2 = jl.RUNNING;
        if (jlVar == jlVar2) {
            return false;
        }
        Context context = AdprofSdk.getInstance().getContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(i5.a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLklOU1RBTExfUEFDS0FHRQ=="));
        if (Build.VERSION.SDK_INT >= 27) {
            intentFilter.addAction(i5.a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLklOU1RBTExfRkFJTFVSRQ=="));
        }
        intentFilter.addAction(i5.a(AdActivity.INSTALL_ACTION));
        intentFilter.addAction(i5.a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVNT1ZFRA=="));
        intentFilter.addAction(i5.a("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ="));
        intentFilter.addDataScheme("package");
        hc.a(context, this.f544a, intentFilter);
        this.f1355a = jlVar2;
        return true;
    }

    @Override // com.adprof.sdk.hl
    /* JADX INFO: renamed from: a */
    public void mo737a() {
        if (this.f1355a == jl.RUNNING) {
            AdprofSdk.getInstance().getContext().unregisterReceiver(this.f544a);
            this.f1355a = jl.STOP;
        }
    }
}
