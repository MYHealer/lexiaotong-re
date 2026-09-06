package com.adprof.sdk;

import android.widget.RelativeLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class oe implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f1344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pe f537a;

    public oe(pe peVar, TextView textView) {
        this.f537a = peVar;
        this.f1344a = textView;
    }

    @Override // java.lang.Runnable
    public void run() {
        pk.a("-----getMeasuredHeight: " + this.f537a.getMeasuredHeight());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, this.f537a.getMeasuredHeight() - h8.a(20.0f), 0, 0);
        this.f537a.addView(this.f1344a, layoutParams);
        this.f1344a.setGravity(17);
    }
}
