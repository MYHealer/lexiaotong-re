package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import com.facebook.common.references.ResourceReleaser;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class SimpleBitmapReleaser implements ResourceReleaser<Bitmap> {
    private static SimpleBitmapReleaser sInstance;

    public static SimpleBitmapReleaser getInstance() {
        if (sInstance == null) {
            sInstance = new SimpleBitmapReleaser();
        }
        return sInstance;
    }

    private SimpleBitmapReleaser() {
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }
}
