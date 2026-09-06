package com.adprof.sdk;

import com.adprof.sdk.base.fb.FBActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x8 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FBActivity f1518a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ boolean f830a;

    public x8(FBActivity fBActivity, boolean z) {
        this.f1518a = fBActivity;
        this.f830a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f830a) {
            return;
        }
        this.f1518a.f1073a.setVisibility(8);
    }
}
