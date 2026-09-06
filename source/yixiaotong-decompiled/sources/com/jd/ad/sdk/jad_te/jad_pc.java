package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_pc implements com.jd.ad.sdk.jad_ju.jad_ly<InputStream, Bitmap> {
    public final jad_dq jad_an = new jad_dq();

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(InputStream inputStream, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return this.jad_an.jad_an(ImageDecoder.createSource(com.jd.ad.sdk.jad_ir.jad_an.jad_an(inputStream)), i, i2, jad_jwVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(InputStream inputStream, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
