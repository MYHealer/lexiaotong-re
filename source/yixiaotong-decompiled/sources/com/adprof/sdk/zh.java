package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zh extends di {
    public zh(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public /* bridge */ /* synthetic */ int a(Object obj) {
        return 4;
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        return Integer.valueOf(eiVar.c());
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        fiVar.m623a(((Integer) obj).intValue());
    }
}
