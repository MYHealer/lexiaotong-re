package com.adprof.sdk;

import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class of implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ RelativeLayout.LayoutParams f538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pf f539a;

    public of(pf pfVar, View view, RelativeLayout.LayoutParams layoutParams) {
        this.f539a = pfVar;
        this.f1345a = view;
        this.f538a = layoutParams;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.f1345a;
        if (view == null || view.getParent() != null) {
            return;
        }
        this.f539a.addView(this.f1345a, this.f538a);
    }
}
