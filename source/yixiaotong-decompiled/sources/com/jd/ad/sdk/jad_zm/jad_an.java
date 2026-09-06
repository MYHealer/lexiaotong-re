package com.jd.ad.sdk.jad_zm;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_an {
    public URLConnection jad_an;

    public final jad_fs jad_an(Map<String, List<String>> map) {
        jad_fs jad_fsVar = new jad_fs();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> value = entry.getValue();
            if (!TextUtils.isEmpty(key) && !value.isEmpty()) {
                Iterator<String> it = value.iterator();
                while (it.hasNext()) {
                    jad_fsVar.jad_an(key, it.next());
                }
            }
        }
        return jad_fsVar;
    }

    public abstract URLConnection jad_an(jad_ly jad_lyVar);

    public abstract void jad_an();

    public abstract int jad_bo();

    public jad_mz jad_bo(jad_ly jad_lyVar) throws com.jd.ad.sdk.jad_do.jad_cp, com.jd.ad.sdk.jad_do.jad_bo {
        if (com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_lyVar.jad_an, 2)) {
            jad_fs jad_fsVar = jad_lyVar.jad_bo;
            jad_er jad_erVar = jad_lyVar.jad_fs;
            if (jad_erVar != null && jad_fsVar != null) {
                byte[] bArr = jad_erVar.jad_an;
                jad_fsVar.jad_bo("Content-Length", Long.toString(bArr == null ? 0L : bArr.length));
                jad_fsVar.jad_bo("Content-Type", "application/stream");
            }
            URLConnection uRLConnectionJad_an = jad_an(jad_lyVar);
            this.jad_an = uRLConnectionJad_an;
            if (jad_erVar != null) {
                try {
                    OutputStream outputStream = uRLConnectionJad_an.getOutputStream();
                    BufferedOutputStream bufferedOutputStream = outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream);
                    byte[] bArr2 = jad_erVar.jad_an;
                    if (bArr2 != null) {
                        bufferedOutputStream.write(bArr2);
                        bufferedOutputStream.flush();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Exception e) {
                    throw new com.jd.ad.sdk.jad_do.jad_cp(e);
                }
            }
        } else {
            this.jad_an = jad_an(jad_lyVar);
        }
        try {
            int iJad_bo = jad_bo();
            if (iJad_bo >= 400) {
                int i = jad_mz.jad_er;
                jad_mz.jad_an jad_anVar = new jad_mz.jad_an();
                jad_anVar.jad_an = iJad_bo;
                jad_anVar.jad_bo = null;
                jad_anVar.jad_cp = null;
                jad_anVar.jad_dq = this;
                return new jad_mz(jad_anVar);
            }
            InputStream inputStream = this.jad_an.getInputStream();
            BufferedInputStream bufferedInputStream = inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream);
            if (jad_lyVar.jad_hu == null) {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                bufferedInputStream.close();
                jad_an();
                return null;
            }
            jad_fs jad_fsVarJad_an = jad_an(this.jad_an.getHeaderFields());
            jad_ob jad_obVar = new jad_ob(jad_fsVarJad_an.jad_an("Content-Type"), bufferedInputStream);
            int i2 = jad_mz.jad_er;
            jad_mz.jad_an jad_anVar2 = new jad_mz.jad_an();
            jad_anVar2.jad_an = iJad_bo;
            jad_anVar2.jad_bo = jad_fsVarJad_an;
            jad_anVar2.jad_cp = jad_obVar;
            jad_anVar2.jad_dq = this;
            return new jad_mz(jad_anVar2);
        } catch (SocketTimeoutException e2) {
            throw new com.jd.ad.sdk.jad_do.jad_bo(String.format("Read data time out: %1$s.", this.jad_an.getURL().toString()), e2);
        } catch (Exception e3) {
            if (e3 instanceof com.jd.ad.sdk.jad_do.jad_bo) {
                throw new com.jd.ad.sdk.jad_do.jad_bo(e3);
            }
            throw new com.jd.ad.sdk.jad_do.jad_bo(new Exception(jad_lyVar.jad_er, e3));
        }
    }
}
