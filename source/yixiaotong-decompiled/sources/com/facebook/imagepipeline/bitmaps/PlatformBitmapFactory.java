package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class PlatformBitmapFactory {
    public abstract CloseableReference<Bitmap> createBitmap(int i, int i2, Bitmap.Config config);

    public CloseableReference<Bitmap> createBitmap(int i, int i2) {
        return createBitmap(i, i2, Bitmap.Config.ARGB_8888);
    }
}
