package com.jd.ad.sdk.jad_sd;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.jd.ad.sdk.jad_gr.jad_ly;
import com.jd.ad.sdk.jad_ju.jad_jw;
import com.jd.ad.sdk.jad_ju.jad_kx;
import com.jd.ad.sdk.jad_te.jad_iv;
import com.jd.ad.sdk.jad_te.jad_na;
import com.jd.ad.sdk.logger.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an implements ImageDecoder.OnHeaderDecodedListener {
    public final jad_na jad_an = jad_na.jad_an();
    public final int jad_bo;
    public final int jad_cp;
    public final com.jd.ad.sdk.jad_ju.jad_bo jad_dq;
    public final jad_iv jad_er;
    public final boolean jad_fs;
    public final jad_kx jad_jt;

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_sd.jad_an$jad_an, reason: collision with other inner class name */
    public class C0582jad_an implements ImageDecoder.OnPartialImageListener {
        public C0582jad_an(jad_an jad_anVar) {
        }

        @Override // android.graphics.ImageDecoder.OnPartialImageListener
        public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
            return false;
        }
    }

    public jad_an(int i, int i2, jad_jw jad_jwVar) {
        this.jad_bo = i;
        this.jad_cp = i2;
        this.jad_dq = (com.jd.ad.sdk.jad_ju.jad_bo) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_jw.jad_fs);
        this.jad_er = (jad_iv) jad_jwVar.jad_an(jad_iv.jad_dq);
        com.jd.ad.sdk.jad_ju.jad_iv<Boolean> jad_ivVar = com.jd.ad.sdk.jad_te.jad_jw.jad_iv;
        this.jad_fs = jad_jwVar.jad_an(jad_ivVar) != null && ((Boolean) jad_jwVar.jad_an(jad_ivVar)).booleanValue();
        this.jad_jt = (jad_kx) jad_jwVar.jad_an(com.jd.ad.sdk.jad_te.jad_jw.jad_jt);
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setAllocator(this.jad_an.jad_an(this.jad_bo, this.jad_cp, this.jad_fs, false) ? 3 : 1);
        if (this.jad_dq == com.jd.ad.sdk.jad_ju.jad_bo.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new C0582jad_an(this));
        Size size = imageInfo.getSize();
        int width = this.jad_bo;
        if (width == Integer.MIN_VALUE) {
            width = size.getWidth();
        }
        int height = this.jad_cp;
        if (height == Integer.MIN_VALUE) {
            height = size.getHeight();
        }
        float fJad_bo = this.jad_er.jad_bo(size.getWidth(), size.getHeight(), width, height);
        int iRound = Math.round(size.getWidth() * fJad_bo);
        int iRound2 = Math.round(size.getHeight() * fJad_bo);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Logger.v("ImageDecoder", jad_ly.jad_an("Resizing from [").append(size.getWidth()).append("x").append(size.getHeight()).append("] to [").append(iRound).append("x").append(iRound2).append("] scaleFactor: ").append(fJad_bo).toString());
        }
        imageDecoder.setTargetSize(iRound, iRound2);
        jad_kx jad_kxVar = this.jad_jt;
        if (jad_kxVar != null) {
            imageDecoder.setTargetColorSpace(ColorSpace.get((Build.VERSION.SDK_INT < 28 || jad_kxVar != jad_kx.DISPLAY_P3 || imageInfo.getColorSpace() == null || !imageInfo.getColorSpace().isWideGamut()) ? ColorSpace.Named.SRGB : ColorSpace.Named.DISPLAY_P3));
        }
    }
}
