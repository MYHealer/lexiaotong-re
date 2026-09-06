package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class vh extends di {
    public vh(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        long jM611a = eiVar.m611a();
        ((l6) eiVar.f258a).a(jM611a);
        l6 l6Var = (l6) eiVar.f258a;
        l6Var.getClass();
        return new q6(l6Var.m672a(jM611a));
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        fiVar.a((q6) obj);
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        return ((q6) obj).a();
    }
}
