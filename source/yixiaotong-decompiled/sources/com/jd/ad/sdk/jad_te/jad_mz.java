package com.jd.ad.sdk.jad_te;

import androidx.exifinterface.media.ExifInterface;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_mz implements com.jd.ad.sdk.jad_ju.jad_fs {
    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(ByteBuffer byteBuffer, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) {
        AtomicReference<byte[]> atomicReference = com.jd.ad.sdk.jad_ir.jad_an.jad_an;
        return jad_an(new com.jd.ad.sdk.jad_ir.jad_an.C0554jad_an(byteBuffer), jad_boVar);
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(InputStream inputStream) {
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public com.jd.ad.sdk.jad_ju.jad_fs.jad_bo jad_an(ByteBuffer byteBuffer) {
        return com.jd.ad.sdk.jad_ju.jad_fs.jad_bo.UNKNOWN;
    }

    @Override // com.jd.ad.sdk.jad_ju.jad_fs
    public int jad_an(InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) throws Throwable {
        int iJad_bo;
        com.jd.ad.sdk.jad_bo.jad_an jad_anVar = new com.jd.ad.sdk.jad_bo.jad_an(inputStream, false);
        com.jd.ad.sdk.jad_bo.jad_an.jad_cp jad_cpVarJad_bo = jad_anVar.jad_bo(ExifInterface.TAG_ORIENTATION);
        if (jad_cpVarJad_bo == null) {
            iJad_bo = 1;
        } else {
            try {
                iJad_bo = jad_cpVarJad_bo.jad_bo(jad_anVar.jad_jt);
            } catch (NumberFormatException unused) {
                iJad_bo = 1;
            }
        }
        if (iJad_bo == 0) {
            return -1;
        }
        return iJad_bo;
    }
}
