package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements com.jd.ad.sdk.jad_ju.jad_ly<ByteBuffer, Bitmap> {
    public final jad_jw jad_an;

    public jad_fs(jad_jw jad_jwVar) {
        this.jad_an = jad_jwVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(ByteBuffer byteBuffer, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        jad_jw jad_jwVar2 = this.jad_an;
        return jad_jwVar2.jad_an(new jad_ob.jad_an(byteBuffer, jad_jwVar2.jad_dq, jad_jwVar2.jad_cp), i, i2, jad_jwVar, jad_jw.jad_kx);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public boolean jad_an(ByteBuffer byteBuffer, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        this.jad_an.getClass();
        return true;
    }
}
