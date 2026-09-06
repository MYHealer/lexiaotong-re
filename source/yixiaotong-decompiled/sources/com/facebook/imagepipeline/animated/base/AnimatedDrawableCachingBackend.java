package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface AnimatedDrawableCachingBackend extends AnimatedDrawableBackend {
    void appendDebugOptionString(StringBuilder sb);

    @Override // com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend
    AnimatedDrawableCachingBackend forNewBounds(Rect rect);

    CloseableReference<Bitmap> getBitmapForFrame(int i);

    CloseableReference<Bitmap> getPreviewBitmap();
}
