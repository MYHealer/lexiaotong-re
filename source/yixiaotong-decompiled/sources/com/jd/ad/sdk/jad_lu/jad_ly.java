package com.jd.ad.sdk.jad_lu;

import java.io.InputStream;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ly implements Callable<jad_sf<jad_jt>> {
    public final /* synthetic */ InputStream jad_an;
    public final /* synthetic */ String jad_bo;

    public jad_ly(InputStream inputStream, String str) {
        this.jad_an = inputStream;
        this.jad_bo = str;
    }

    @Override // java.util.concurrent.Callable
    public jad_sf<jad_jt> call() {
        return jad_hu.jad_an(this.jad_an, this.jad_bo);
    }
}
