package com.jd.ad.sdk.jad_ju;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.jd.ad.sdk.jad_te.jad_sf;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_jt {
    public static int jad_an(List<jad_fs> list, InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int iJad_an = list.get(i).jad_an(inputStream, jad_boVar);
                inputStream.reset();
                if (iJad_an != -1) {
                    return iJad_an;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return -1;
    }

    public static jad_fs.jad_bo jad_bo(List<jad_fs> list, InputStream inputStream, com.jd.ad.sdk.jad_ny.jad_bo jad_boVar) throws IOException {
        if (inputStream == null) {
            return jad_fs.jad_bo.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new jad_sf(inputStream, jad_boVar, 65536);
        }
        inputStream.mark(AVMDLDataLoaderConfigure.DEFAULT_MAX_FACTORY_MEMORY_SIZE);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                jad_fs.jad_bo jad_boVarJad_an = list.get(i).jad_an(inputStream);
                inputStream.reset();
                if (jad_boVarJad_an != jad_fs.jad_bo.UNKNOWN) {
                    return jad_boVarJad_an;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return jad_fs.jad_bo.UNKNOWN;
    }

    public static jad_fs.jad_bo jad_an(List<jad_fs> list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return jad_fs.jad_bo.UNKNOWN;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            jad_fs.jad_bo jad_boVarJad_an = list.get(i).jad_an(byteBuffer);
            if (jad_boVarJad_an != jad_fs.jad_bo.UNKNOWN) {
                return jad_boVarJad_an;
            }
        }
        return jad_fs.jad_bo.UNKNOWN;
    }
}
