package com.jd.ad.sdk.jad_vg;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_mx.jad_tg;
import com.jd.ad.sdk.jad_mx.jad_xk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_cp<T extends Drawable> implements jad_xk<T>, jad_tg {
    public final T jad_an;

    public jad_cp(T t) {
        this.jad_an = (T) jad_kx.jad_an(t);
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_xk
    public Object get() {
        Drawable.ConstantState constantState = this.jad_an.getConstantState();
        return constantState == null ? this.jad_an : constantState.newDrawable();
    }

    @Override // com.jd.ad.sdk.jad_mx.jad_tg
    public void jad_an() {
        Bitmap bitmapJad_bo;
        T t = this.jad_an;
        if (t instanceof BitmapDrawable) {
            bitmapJad_bo = ((BitmapDrawable) t).getBitmap();
        } else if (!(t instanceof com.jd.ad.sdk.jad_xi.jad_cp)) {
            return;
        } else {
            bitmapJad_bo = ((com.jd.ad.sdk.jad_xi.jad_cp) t).jad_bo();
        }
        bitmapJad_bo.prepareToDraw();
    }
}
