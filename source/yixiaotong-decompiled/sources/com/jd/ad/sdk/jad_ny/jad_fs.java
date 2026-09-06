package com.jd.ad.sdk.jad_ny;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_fs implements jad_er {
    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public Bitmap jad_an(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an() {
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an(int i) {
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public void jad_an(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.jd.ad.sdk.jad_ny.jad_er
    public Bitmap jad_bo(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }
}
