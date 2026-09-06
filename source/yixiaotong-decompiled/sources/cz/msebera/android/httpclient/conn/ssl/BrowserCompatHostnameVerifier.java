package cz.msebera.android.httpclient.conn.ssl;

import javax.net.ssl.SSLException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BrowserCompatHostnameVerifier extends AbstractVerifier {
    public final String toString() {
        return "BROWSER_COMPATIBLE";
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.AbstractVerifier
    boolean validCountryWildcard(String str) {
        return true;
    }

    @Override // cz.msebera.android.httpclient.conn.ssl.X509HostnameVerifier
    public final void verify(String str, String[] strArr, String[] strArr2) throws SSLException {
        verify(str, strArr, strArr2, false);
    }
}
