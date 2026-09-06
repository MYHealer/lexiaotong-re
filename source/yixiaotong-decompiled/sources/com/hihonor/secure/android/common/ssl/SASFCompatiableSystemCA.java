package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.StrUtil;
import com.hihonor.secure.android.common.ssl.util.g;
import com.stub.StubApp;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SASFCompatiableSystemCA extends SSLSocketFactory {
    private static final String TAG = "SASFCompatiableSystemCA";
    private static volatile SASFCompatiableSystemCA i;
    private SSLContext b;
    private SSLSocket j;
    private Context k;
    private String[] l;
    private X509TrustManager m;
    private String[] n;
    private String[] o;
    private String[] p;

    public String[] getBlackCiphers() {
        return this.n;
    }

    public Context getContext() {
        return this.k;
    }

    public String[] getProtocols() {
        return this.p;
    }

    public SSLContext getSslContext() {
        return this.b;
    }

    public SSLSocket getSslSocket() {
        return this.j;
    }

    public String[] getSupportedCipherSuites() {
        String[] strArr = this.l;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.o;
    }

    public X509TrustManager getX509TrustManager() {
        return this.m;
    }

    public void setBlackCiphers(String[] strArr) {
        this.n = strArr;
    }

    public void setProtocols(String[] strArr) {
        this.p = strArr;
    }

    public void setSslContext(SSLContext sSLContext) {
        this.b = sSLContext;
    }

    public void setSslSocket(SSLSocket sSLSocket) {
        this.j = sSLSocket;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.o = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.m = x509TrustManager;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.j = null;
    }

    private SASFCompatiableSystemCA(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        super(keyStore);
        this.j = null;
        if (context == null) {
            g.e(TAG, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager sSFSecureX509SingleInstance = SSFSecureX509SingleInstance.getInstance(context);
        this.m = sSFSecureX509SingleInstance;
        this.b.init(null, new X509TrustManager[]{sSFSecureX509SingleInstance}, null);
    }

    public static SASFCompatiableSystemCA getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (i == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (i == null) {
                    i = new SASFCompatiableSystemCA(keyStore, context);
                }
            }
        }
        return i;
    }

    public SASFCompatiableSystemCA(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException, IllegalArgumentException {
        super(keyStore);
        this.j = null;
        this.b = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.b.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "sasfc update socket factory trust manager");
        try {
            i = new SASFCompatiableSystemCA((KeyStore) null, x509TrustManager);
        } catch (KeyManagementException unused) {
            g.e(TAG, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            g.e(TAG, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            g.e(TAG, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            g.e(TAG, "UnrecoverableKeyException");
        }
    }

    public void setContext(Context context) {
        this.k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        g.c(TAG, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(socket, str, i2, z);
        if (socketCreateSocket instanceof SSLSocket) {
            b(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.j = sSLSocket;
            this.l = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        g.c(TAG, "createSocket: ");
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket();
        if (socketCreateSocket instanceof SSLSocket) {
            b(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.j = sSLSocket;
            this.l = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.m;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    private void b(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (StrUtil.emptyArray(this.p)) {
            z = false;
        } else {
            g.c(TAG, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.p);
            z = true;
        }
        if (StrUtil.emptyArray(this.o) && StrUtil.emptyArray(this.n)) {
            z2 = false;
        } else {
            g.c(TAG, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!StrUtil.emptyArray(this.o)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.o);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.n);
            }
        }
        if (!z) {
            g.c(TAG, "set default protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        g.c(TAG, "set default cipher suites");
        SSLUtil.setEnableSafeCipherSuites((SSLSocket) socket);
    }
}
