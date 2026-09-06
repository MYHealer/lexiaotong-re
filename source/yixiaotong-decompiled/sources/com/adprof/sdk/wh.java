package com.adprof.sdk;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wh extends di {
    public final /* synthetic */ di k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wh(di diVar, b9 b9Var, Class cls) {
        super(b9Var, cls);
        this.k = diVar;
    }

    @Override // com.adprof.sdk.di
    public Object a(ei eiVar) throws IOException {
        return Collections.singletonList(this.k.a(eiVar));
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, Object obj) throws IOException {
        throw new UnsupportedOperationException("Repeated values can only be encoded with a tag.");
    }

    @Override // com.adprof.sdk.di
    public void a(fi fiVar, int i, Object obj) throws IOException {
        List list = (List) obj;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.k.a(fiVar, i, list.get(i2));
        }
    }

    @Override // com.adprof.sdk.di
    public int a(Object obj) {
        throw new UnsupportedOperationException("Repeated values can only be sized with a tag.");
    }

    @Override // com.adprof.sdk.di
    public int a(int i, Object obj) {
        List list = (List) obj;
        int size = list.size();
        int iA = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iA += this.k.a(i, list.get(i2));
        }
        return iA;
    }
}
