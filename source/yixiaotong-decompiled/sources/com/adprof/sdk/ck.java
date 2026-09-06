package com.adprof.sdk;

import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ck implements Function3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jk f1114a;

    public ck(jk jkVar) {
        this.f1114a = jkVar;
    }

    @Override // kotlin.jvm.functions.Function3
    public Object invoke(Object obj, Object obj2, Object obj3) {
        Float f = (Float) obj;
        Float f2 = (Float) obj2;
        Float f3 = (Float) obj3;
        jk jkVar = this.f1114a;
        d dVar = ((x0) jkVar).f821a;
        if (dVar != null && f != null && f2 != null && f3 != null) {
            dVar.m591a().a(f, f2, f3);
            jkVar.f397a.postDelayed(new dk(jkVar), 300L);
        }
        return Boolean.TRUE;
    }
}
