package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.RectF;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface TransformCallback {
    void getRootBounds(RectF rectF);

    void getTransform(Matrix matrix);
}
