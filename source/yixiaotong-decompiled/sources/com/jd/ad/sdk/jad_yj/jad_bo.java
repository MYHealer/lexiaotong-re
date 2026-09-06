package com.jd.ad.sdk.jad_yj;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.jd.ad.sdk.jad_te.jad_qd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo implements jad_er<Bitmap, BitmapDrawable> {
    public final Resources jad_an;

    public jad_bo(Resources resources) {
        this.jad_an = (Resources) jad_kx.jad_an(resources);
    }

    @Override // com.jd.ad.sdk.jad_yj.jad_er
    public jad_xk<BitmapDrawable> jad_an(jad_xk<Bitmap> jad_xkVar, jad_jw jad_jwVar) {
        return jad_qd.jad_an(this.jad_an, jad_xkVar);
    }
}
