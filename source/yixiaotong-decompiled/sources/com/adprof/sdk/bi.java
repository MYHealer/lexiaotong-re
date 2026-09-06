package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class bi extends di {
    public bi(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        return Long.valueOf(eiVar.m614d());
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        fiVar.b(((Long) obj).longValue());
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        return fi.a(((Long) obj).longValue());
    }
}
