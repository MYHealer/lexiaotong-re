package com.adprof.sdk;

import com.adprof.sdk.base.fb.FBView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f0 f1062a;

    public b0(f0 f0Var) {
        this.f1062a = f0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        FBView fBView = this.f1062a.f276a;
        if (fBView == null || fBView.getParent() == null) {
            return;
        }
        this.f1062a.f276a.bringToFront();
        this.f1062a.f276a.setVisibility(0);
        this.f1062a.f276a.invalidate();
    }
}
