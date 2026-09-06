package com.adprof.sdk;

import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1331a;

    public o(q qVar) {
        this.f1331a = qVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        Float f = (Float) obj;
        Float f2 = (Float) obj2;
        Float f3 = (Float) obj3;
        q qVar = this.f1331a;
        d dVar = qVar.f628a;
        if (dVar != null && f != null && f2 != null && f3 != null) {
            dVar.m591a().a(f, f2, f3);
            pe peVar = qVar.f630a;
            if (peVar != null) {
                peVar.postDelayed(new p(qVar), 400L);
            } else {
                c2 c2Var = qVar.f627a;
                if (c2Var != null) {
                    c2Var.b();
                }
            }
        }
        return Boolean.TRUE;
    }
}
