package com.jd.ad.sdk.jad_te;

import android.graphics.Bitmap;
import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ju.jad_mz<Bitmap> {
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Integer> jad_bo = com.jd.ad.sdk.jad_ju.jad_iv.jad_an("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final com.jd.ad.sdk.jad_ju.jad_iv<Bitmap.CompressFormat> jad_cp = new com.jd.ad.sdk.jad_ju.jad_iv<>("com.jd.ad.sdk.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat", null, com.jd.ad.sdk.jad_ju.jad_iv.jad_er);
    public final com.jd.ad.sdk.jad_ny.jad_bo jad_an;

    public jad_cp(com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        this.jad_an = jad_boVar;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_ju.jad_cp.TRANSFORMED;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public boolean jad_an(com.jd.ad.sdk.jad_mx.jad_xk<Bitmap> jad_xkVar, File file, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) throws Throwable {
        FileOutputStream fileOutputStream;
        boolean z;
        Bitmap bitmap = jad_xkVar.get();
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) jad_jwVar.jad_an(jad_cp);
        if (compressFormat == null) {
            compressFormat = bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
        }
        bitmap.getWidth();
        bitmap.getHeight();
        long jJad_an = com.jd.ad.sdk.jad_ir.jad_jt.jad_an();
        int iIntValue = ((Integer) jad_jwVar.jad_an(jad_bo)).intValue();
        OutputStream jad_cpVar = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        jad_cpVar = this.jad_an != null ? new com.jd.ad.sdk.jad_kv.jad_cp(fileOutputStream, this.jad_an, 65536) : fileOutputStream;
                        bitmap.compress(compressFormat, iIntValue, jad_cpVar);
                        jad_cpVar.close();
                        try {
                            jad_cpVar.close();
                        } catch (IOException unused) {
                        }
                        z = true;
                    } catch (IOException e) {
                        e = e;
                        jad_cpVar = fileOutputStream;
                        if (Log.isLoggable("BitmapEncoder", 3)) {
                            Logger.d("BitmapEncoder", "Failed to encode Bitmap", e);
                        }
                        if (jad_cpVar != null) {
                            try {
                                jad_cpVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        z = false;
                    } catch (Throwable th) {
                        th = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Logger.v("BitmapEncoder", "Compressed with type: " + compressFormat + " of size " + com.jd.ad.sdk.jad_ir.jad_ly.jad_an(bitmap) + " in " + com.jd.ad.sdk.jad_ir.jad_jt.jad_an(jJad_an) + ", options format: " + jad_jwVar.jad_an(jad_cp) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z;
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
