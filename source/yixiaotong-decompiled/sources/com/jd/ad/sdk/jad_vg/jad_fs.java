package com.jd.ad.sdk.jad_vg;

import android.graphics.drawable.Drawable;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_ly;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements jad_ly<Drawable, Drawable> {
    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public jad_xk<Drawable> jad_an(Drawable drawable, int i, int i2, jad_jw jad_jwVar) {
        Drawable drawable2 = drawable;
        if (drawable2 != null) {
            return new jad_dq(drawable2);
        }
        return null;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(Drawable drawable, jad_jw jad_jwVar) {
        return true;
    }
}
