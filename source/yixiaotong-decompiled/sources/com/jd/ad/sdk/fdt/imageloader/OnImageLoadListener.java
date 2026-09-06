package com.jd.ad.sdk.fdt.imageloader;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface OnImageLoadListener {
    void onLoadFailed(int i, String str, Drawable drawable);

    void onLoadSuccess(Drawable drawable);
}
