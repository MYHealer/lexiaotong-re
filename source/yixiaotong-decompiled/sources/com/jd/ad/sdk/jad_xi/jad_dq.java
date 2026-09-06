package com.jd.ad.sdk.jad_xi;

import android.util.Log;
import com.jd.ad.sdk.jad_ju.jad_mz;
import com.jd.ad.sdk.jad_mx.jad_xk;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_dq implements jad_mz<jad_cp> {
    @Override // com.jd.ad.sdk.jad_ju.jad_mz
    public com.jd.ad.sdk.jad_ju.jad_cp jad_an(com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return com.jd.ad.sdk.jad_ju.jad_cp.SOURCE;
    }

    public boolean jad_an(jad_xk jad_xkVar, File file) throws Throwable {
        try {
            com.jd.ad.sdk.jad_ir.jad_an.jad_an(((jad_cp) jad_xkVar.get()).jad_an.jad_an.jad_an.jad_er().asReadOnlyBuffer(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Logger.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(Object obj, File file, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an((jad_xk) obj, file);
    }
}
