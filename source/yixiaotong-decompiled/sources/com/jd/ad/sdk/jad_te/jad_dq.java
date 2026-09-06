package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_dq implements com.jd.ad.sdk.jad_ju.jad_ly<ImageDecoder.Source, Bitmap> {
    public final com.jd.ad.sdk.jad_ny.jad_er jad_an = new com.jd.ad.sdk.jad_ny.jad_fs();

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_an(ImageDecoder.Source source, int i, int i2, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) throws IOException {
        Bitmap bitmapDecodeBitmap = ImageDecoder.decodeBitmap(source, new com.jd.ad.sdk.jad_sd.jad_an(i, i2, jad_jwVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Logger.v("BitmapImageDecoder", com.jd.ad.sdk.jad_gr.jad_ly.jad_an("Decoded [").append(bitmapDecodeBitmap.getWidth()).append("x").append(bitmapDecodeBitmap.getHeight()).append("] for [").append(i).append("x").append(i2).append("]").toString());
        }
        return new jad_er(bitmapDecodeBitmap, this.jad_an);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_ly
    public /* bridge */ /* synthetic */ boolean jad_an(ImageDecoder.Source source, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return true;
    }
}
