package com.jd.ad.sdk.jad_hu;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.jd.ad.sdk.jad_lu.jad_na;

/* JADX INFO: compiled from: DynamicRenderUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs extends com.jd.ad.sdk.jad_fo.jad_an<Bitmap> {
    public final /* synthetic */ jad_na jad_dq;
    public final /* synthetic */ Bitmap[] jad_er;

    public jad_fs(jad_jt jad_jtVar, jad_na jad_naVar, Bitmap[] bitmapArr) {
        this.jad_dq = jad_naVar;
        this.jad_er = bitmapArr;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_an(Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public /* bridge */ /* synthetic */ void jad_an(Object obj, com.jd.ad.sdk.jad_gp.jad_bo jad_boVar) {
        jad_an((Bitmap) obj, (com.jd.ad.sdk.jad_gp.jad_bo<? super Bitmap>) jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_an, com.jd.ad.sdk.jad_fo.jad_er
    public void jad_cp(Drawable drawable) {
    }

    public void jad_an(Bitmap bitmap, com.jd.ad.sdk.jad_gp.jad_bo<? super Bitmap> jad_boVar) {
        jad_na jad_naVar = this.jad_dq;
        this.jad_er[0] = jad_hu.jad_an(bitmap, jad_naVar.jad_an, jad_naVar.jad_bo);
    }
}
