package com.adprof.sdk;

import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bd implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hd f1090a;

    public bd(hd hdVar) {
        this.f1090a = hdVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        Float f = (Float) obj;
        Float f2 = (Float) obj2;
        Float f3 = (Float) obj3;
        hd hdVar = this.f1090a;
        d dVar = ((x0) hdVar).f821a;
        if (dVar != null && f != null && f2 != null && f3 != null) {
            dVar.m591a().a(f, f2, f3);
            hdVar.f342a.postDelayed(new ad(hdVar), 300L);
        }
        return Boolean.TRUE;
    }
}
