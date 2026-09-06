package com.jd.ad.sdk.jad_xi;

import android.graphics.Bitmap;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_hu implements jad_ly<com.jd.ad.sdk.jad_it.jad_an, Bitmap> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an;

    public jad_hu(com.jd.ad.sdk.jad_ny.jad_er jad_erVar) {
        this.jad_an = jad_erVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public jad_xk<Bitmap> jad_an(com.jd.ad.sdk.jad_it.jad_an jad_anVar, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_te.jad_er.jad_an(jad_anVar.jad_fs(), this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(com.jd.ad.sdk.jad_it.jad_an jad_anVar, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
