package com.adprof.sdk;

import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vm implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ an f1484a;

    public vm(an anVar) {
        this.f1484a = anVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        Float f = (Float) obj;
        Float f2 = (Float) obj2;
        Float f3 = (Float) obj3;
        an anVar = this.f1484a;
        d dVar = ((x0) anVar).f821a;
        if (dVar != null && f != null && f2 != null && f3 != null) {
            n nVarM591a = dVar.m591a();
            pk.a("SplashBaseView", "--------onMotionEnd----------: x=" + f + ", y=" + f2 + ", z=" + f3);
            nVarM591a.a(f, f2, f3);
            pe peVar = anVar.f30a;
            if (peVar != null) {
                peVar.postDelayed(new wm(anVar), 300L);
            }
        }
        return Boolean.TRUE;
    }
}
