package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xh extends di {
    public xh(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public /* bridge */ /* synthetic */ int a(Object obj) {
        return 1;
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        int iD = eiVar.d();
        if (iD == 0) {
            return Boolean.FALSE;
        }
        if (iD == 1) {
            return Boolean.TRUE;
        }
        throw new IOException(String.format("Invalid boolean value 0x%02x", Integer.valueOf(iD)));
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        fiVar.b(((Boolean) obj).booleanValue() ? 1 : 0);
    }
}
