package com.jd.ad.sdk.jad_fo;

import android.graphics.drawable.Drawable;
import com.jd.ad.sdk.jad_en.jad_jw;
import com.jd.ad.sdk.jad_ir.jad_ly;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_an<T> implements jad_er<T> {
    public final int jad_an;
    public final int jad_bo;
    public com.jd.ad.sdk.jad_en.jad_dq jad_cp;

    public jad_an() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public jad_an(int i, int i2) {
        if (!jad_ly.jad_bo(i, i2)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i + " and height: " + i2);
        }
        this.jad_an = i;
        this.jad_bo = i2;
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_an(com.jd.ad.sdk.jad_en.jad_dq jad_dqVar) {
        this.jad_cp = jad_dqVar;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_an(jad_dq jad_dqVar) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final com.jd.ad.sdk.jad_en.jad_dq jad_bo() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_bo(Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public final void jad_bo(jad_dq jad_dqVar) throws Throwable {
        ((jad_jw) jad_dqVar).jad_an(this.jad_an, this.jad_bo);
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_cp() {
    }

    @Override // com.jd.ad.sdk.jad_fo.jad_er
    public void jad_cp(Drawable drawable) {
    }

    @Override // com.jd.ad.sdk.jad_zk.jad_mz
    public void jad_dq() {
    }
}
