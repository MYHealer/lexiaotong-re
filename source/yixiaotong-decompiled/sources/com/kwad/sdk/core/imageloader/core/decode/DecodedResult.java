package com.kwad.sdk.core.imageloader.core.decode;

import android.graphics.Bitmap;
import com.kwad.sdk.glide.framesequence.FrameSequence;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DecodedResult {
    public Bitmap mBitmap;
    public FrameSequence mFrameSequence;

    public boolean isDecoded() {
        Bitmap bitmap = this.mBitmap;
        return (bitmap != null && !bitmap.isRecycled()) || (this.mFrameSequence != null);
    }

    public int getByteSize() {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            return bitmap.getRowBytes() * this.mBitmap.getHeight();
        }
        return 0;
    }
}
