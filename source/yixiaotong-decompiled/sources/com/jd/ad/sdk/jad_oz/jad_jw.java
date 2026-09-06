package com.jd.ad.sdk.jad_oz;

import androidx.core.util.Pools;
import com.jd.ad.sdk.jad_ir.jad_kx;
import com.jd.ad.sdk.jad_ir.jad_ly;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jw {
    public final com.jd.ad.sdk.jad_ir.jad_hu<com.jd.ad.sdk.jad_ju.jad_hu, String> jad_an = new com.jd.ad.sdk.jad_ir.jad_hu<>(1000);
    public final Pools.Pool<jad_bo> jad_bo = com.jd.ad.sdk.jad_js.jad_an.jad_an(10, new jad_an(this));

    public class jad_an implements com.jd.ad.sdk.jad_js.jad_an.jad_bo<jad_bo> {
        public jad_an(jad_jw jad_jwVar) {
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_bo
        public jad_bo jad_an() {
            try {
                return new jad_bo(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static final class jad_bo implements com.jd.ad.sdk.jad_js.jad_an.jad_dq {
        public final MessageDigest jad_an;
        public final com.jd.ad.sdk.jad_js.jad_dq jad_bo = com.jd.ad.sdk.jad_js.jad_dq.jad_an();

        public jad_bo(MessageDigest messageDigest) {
            this.jad_an = messageDigest;
        }

        @Override // com.jd.ad.sdk.jad_js.jad_an.jad_dq
        public com.jd.ad.sdk.jad_js.jad_dq jad_an() {
            return this.jad_bo;
        }
    }

    public String jad_an(com.jd.ad.sdk.jad_ju.jad_hu jad_huVar) {
        String strJad_an;
        synchronized (this.jad_an) {
            strJad_an = this.jad_an.jad_an(jad_huVar);
        }
        if (strJad_an == null) {
            jad_bo jad_boVar = (jad_bo) jad_kx.jad_an(this.jad_bo.acquire());
            try {
                jad_huVar.jad_an(jad_boVar.jad_an);
                byte[] bArrDigest = jad_boVar.jad_an.digest();
                char[] cArr = jad_ly.jad_bo;
                synchronized (cArr) {
                    for (int i = 0; i < bArrDigest.length; i++) {
                        byte b = bArrDigest[i];
                        int i2 = i * 2;
                        char[] cArr2 = jad_ly.jad_an;
                        cArr[i2] = cArr2[(b & 255) >>> 4];
                        cArr[i2 + 1] = cArr2[b & 15];
                    }
                    strJad_an = new String(cArr);
                }
                this.jad_bo.release(jad_boVar);
            } catch (Throwable th) {
                this.jad_bo.release(jad_boVar);
                throw th;
            }
        }
        synchronized (this.jad_an) {
            this.jad_an.jad_bo(jad_huVar, strJad_an);
        }
        return strJad_an;
    }
}
