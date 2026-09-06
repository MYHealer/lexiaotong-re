package com.adprof.sdk;

import android.text.TextUtils;
import com.adprof.sdk.api.NativeAdLoadListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bf extends fn.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ df f1091a;

    public bf(df dfVar) {
        this.f1091a = dfVar;
    }

    @Override // com.adprof.sdk.fn.a
    public void callback(Exception exc) {
        ArrayList arrayList = this.f1091a.f217a;
        if (arrayList != null && !arrayList.isEmpty()) {
            df dfVar = this.f1091a;
            dfVar.f218a.addAll(dfVar.f217a);
        }
        df dfVar2 = this.f1091a;
        NativeAdLoadListener nativeAdLoadListener = dfVar2.f214a;
        if (nativeAdLoadListener != null) {
            nativeAdLoadListener.onAdLoad(dfVar2.f217a);
        }
        df dfVar3 = this.f1091a;
        d dVar = ((p5) dfVar3).f546a;
        if (dVar == null || TextUtils.isEmpty(dVar.h())) {
            return;
        }
        l0 l0Var = new l0(dfVar3.f215a, dVar.k());
        dfVar3.f216a = l0Var;
        l0Var.m715a();
    }
}
