package com.jd.ad.sdk.jad_qb;

import android.util.Log;
import com.jd.ad.sdk.logger.Logger;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_cp implements com.jd.ad.sdk.jad_ju.jad_dq<ByteBuffer> {
    @Override // com.jd.ad.sdk.jad_ju.jad_dq
    public /* bridge */ /* synthetic */ boolean jad_an(ByteBuffer byteBuffer, File file, com.jd.ad.sdk.jad_ju.jad_jw jad_jwVar) {
        return jad_an(byteBuffer, file);
    }

    public boolean jad_an(ByteBuffer byteBuffer, File file) throws Throwable {
        try {
            com.jd.ad.sdk.jad_ir.jad_an.jad_an(byteBuffer, file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Logger.d("ByteBufferEncoder", "Failed to write data", e);
            }
            return false;
        }
    }
}
