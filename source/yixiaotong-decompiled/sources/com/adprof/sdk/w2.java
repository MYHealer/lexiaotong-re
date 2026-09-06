package com.adprof.sdk;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class w2 implements uk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f1491a;

    public w2(Function1 function1) {
        this.f1491a = function1;
    }

    @Override // com.adprof.sdk.uk
    public void a(int i, long j) {
    }

    @Override // com.adprof.sdk.uk
    public void a(al alVar) {
        Function1 function1;
        Boolean bool;
        pk.a("AdUrlReportRequest result   == " + alVar);
        if (alVar.a()) {
            function1 = this.f1491a;
            if (function1 == null) {
                return;
            } else {
                bool = Boolean.TRUE;
            }
        } else {
            function1 = this.f1491a;
            if (function1 == null) {
                return;
            } else {
                bool = Boolean.FALSE;
            }
        }
        function1.invoke(bool);
    }
}
