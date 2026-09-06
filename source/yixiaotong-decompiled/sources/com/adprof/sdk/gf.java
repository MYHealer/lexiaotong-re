package com.adprof.sdk;

import android.view.View;
import com.adprof.sdk.api.NativeAdAllEventListener;
import com.adprof.sdk.api.NativeAdEventListener;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class gf implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ pf f1191a;

    public gf(pf pfVar) {
        this.f1191a = pfVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        pf pfVar = this.f1191a;
        d dVar = pfVar.f582a;
        if (dVar != null && dVar.g > pfVar.c && me.m683a()) {
            me.a();
            le.a(pfVar, pfVar.f582a, new mf(pfVar), "NativeBaseTemp");
            return;
        }
        try {
            ((a2) ((kl) Objects.requireNonNull(pfVar.getSessionManager()))).b(pfVar.f582a);
        } catch (Throwable unused) {
        }
        hp.m656a((View) pfVar);
        NativeAdEventListener nativeAdEventListener = pfVar.f579a;
        if (nativeAdEventListener == null || !(nativeAdEventListener instanceof NativeAdAllEventListener)) {
            return;
        }
        ((NativeAdAllEventListener) nativeAdEventListener).onAdClose(pfVar);
    }
}
