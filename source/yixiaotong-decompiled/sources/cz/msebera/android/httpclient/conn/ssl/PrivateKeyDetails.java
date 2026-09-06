package cz.msebera.android.httpclient.conn.ssl;

import cz.msebera.android.httpclient.util.Args;
import java.security.cert.X509Certificate;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class PrivateKeyDetails {
    private final X509Certificate[] certChain;
    private final String type;

    public X509Certificate[] getCertChain() {
        return this.certChain;
    }

    public String getType() {
        return this.type;
    }

    public PrivateKeyDetails(String str, X509Certificate[] x509CertificateArr) {
        this.type = (String) Args.notNull(str, "Private key type");
        this.certChain = x509CertificateArr;
    }

    public String toString() {
        return this.type + ':' + Arrays.toString(this.certChain);
    }
}
