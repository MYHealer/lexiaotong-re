package com.adprof.sdk;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yh extends di {
    public yh(b9 b9Var, Class cls) {
        super(b9Var, cls);
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        return Integer.valueOf(eiVar.d());
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue >= 0) {
            fiVar.b(iIntValue);
        } else {
            fiVar.b(iIntValue);
        }
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        if (iIntValue >= 0) {
            return fi.a(iIntValue);
        }
        return 10;
    }
}
