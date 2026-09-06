package com.jd.ad.sdk.jad_ud;

import com.jd.ad.sdk.jad_lu.jad_zm;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er {
    public final jad_dq jad_an;

    public jad_er(jad_dq jad_dqVar) {
        this.jad_an = jad_dqVar;
    }

    public static String jad_an(String str, jad_cp jad_cpVar, boolean z) {
        String string;
        StringBuilder sbAppend = jad_zm.jad_an("lottie_cache_").append(str.replaceAll("\\W+", ""));
        if (z) {
            jad_cpVar.getClass();
            string = jad_zm.jad_an(".temp").append(jad_cpVar.jad_an).toString();
        } else {
            string = jad_cpVar.jad_an;
        }
        return sbAppend.append(string).toString();
    }

    public File jad_an(String str, InputStream inputStream, jad_cp jad_cpVar) throws IOException {
        File file = new File(jad_an(), jad_an(str, jad_cpVar, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i == -1) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        inputStream.close();
                        return file;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (Throwable th2) {
            inputStream.close();
            throw th2;
        }
    }

    public final File jad_an() {
        com.jd.ad.sdk.jad_lu.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_lu.jad_cp) this.jad_an;
        jad_cpVar.getClass();
        File file = new File(jad_cpVar.jad_an.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
