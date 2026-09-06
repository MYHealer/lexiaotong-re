package com.adprof.sdk;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class j1 implements uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f1240a;

    public j1(Function1 function1) {
        this.f1240a = function1;
    }

    @Override // com.adprof.sdk.uk
    public void a(int i, long j) {
    }

    @Override // com.adprof.sdk.uk
    public void a(al alVar) {
        Function1 function1 = this.f1240a;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(alVar.a()));
        }
    }
}
