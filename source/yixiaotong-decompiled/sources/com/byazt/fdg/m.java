package com.byazt.fdg;

import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, AVMDLDataLoader.KeyIsPreloadWaitListType, 130})
public class m extends rh {
    public final byte[] c;
    public int tt;

    @Override // com.byazt.fdg.rh, java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        return this.c;
    }

    public m(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.tt = -1;
        this.c = bArr;
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        try {
            return Arrays.equals(getEncoded(), ((m) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // java.security.cert.Certificate
    public int hashCode() {
        if (this.tt == -1) {
            try {
                this.tt = Arrays.hashCode(getEncoded());
            } catch (CertificateEncodingException unused) {
                this.tt = 0;
            }
        }
        return this.tt;
    }
}
