package com.jd.ad.sdk.jad_yj;

import android.graphics.Bitmap;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an implements jad_er<Bitmap, byte[]> {
    public final Bitmap.CompressFormat jad_an;

    public jad_an() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public jad_an(Bitmap.CompressFormat compressFormat, int i) {
        this.jad_an = compressFormat;
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    public jad_xk<byte[]> jad_an(jad_xk<Bitmap> jad_xkVar, jad_jw jad_jwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        jad_xkVar.get().compress(this.jad_an, 100, byteArrayOutputStream);
        jad_xkVar.jad_dq();
        return new com.jd.ad.sdk.jad_uf.jad_bo(byteArrayOutputStream.toByteArray());
    }
}
