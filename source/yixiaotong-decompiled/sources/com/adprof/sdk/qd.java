package com.adprof.sdk;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class qd implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ td f1384a;

    public qd(td tdVar) {
        this.f1384a = tdVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ((q5) this.f1384a).f662a.onBackPressed();
    }
}
