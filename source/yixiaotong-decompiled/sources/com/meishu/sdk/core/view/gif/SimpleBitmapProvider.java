package com.meishu.sdk.core.view.gif;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class SimpleBitmapProvider implements GifDecoder.BitmapProvider {
    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public Bitmap obtain(int i, int i2, Bitmap.Config config) {
        try {
            return Bitmap.createBitmap(i, i2, config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public byte[] obtainByteArray(int i) {
        return new byte[i];
    }

    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public int[] obtainIntArray(int i) {
        return new int[i];
    }

    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public void release(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public void release(byte[] bArr) {
    }

    @Override // com.meishu.sdk.core.view.gif.GifDecoder.BitmapProvider
    public void release(int[] iArr) {
    }
}
