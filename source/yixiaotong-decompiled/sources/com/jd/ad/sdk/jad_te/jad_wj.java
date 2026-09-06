package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_wj implements com.jd.ad.sdk.jad_ju.jad_ly<Bitmap, Bitmap> {

    public static final class jad_an implements com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> {
        public final Bitmap jad_an;

        public jad_an(Bitmap bitmap) {
            this.jad_an = bitmap;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public Bitmap get() {
            return this.jad_an;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public int jad_bo() {
            return com.jd.ad.sdk.jad_ir.jad_ly.jad_an(this.jad_an);
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public Class<Bitmap> jad_cp() {
            return Bitmap.class;
        }

        @Override // com.jd.ad.sdk.jad_mx.jad_xk
        public void jad_dq() {
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(Bitmap bitmap, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return new jad_an(bitmap);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(Bitmap bitmap, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
