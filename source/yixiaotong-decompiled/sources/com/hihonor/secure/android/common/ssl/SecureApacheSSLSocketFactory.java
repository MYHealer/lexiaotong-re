package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.StrUtil;
import com.hihonor.secure.android.common.ssl.util.g;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SecureApacheSSLSocketFactory extends SSLSocketFactory {
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    private static final String TAG = "SecureApacheSSLSocketFactory";
    private static volatile SecureApacheSSLSocketFactory y = null;
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

    private SecureApacheSSLSocketFactory(KeyStore keyStore) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyManagementException, KeyStoreException {
        super(keyStore);
        this.j = null;
    }

    private SecureApacheSSLSocketFactory(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        super(keyStore);
        this.j = null;
        if (context == null) {
            g.e(TAG, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.m = secureX509SingleInstance;
        this.b.init(null, new X509TrustManager[]{secureX509SingleInstance}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.j = null;
        this.b = SSLUtil.setSSLContext();
        HiHonorX509TrustManager hiHonorX509TrustManager = new HiHonorX509TrustManager(inputStream, str);
        setX509TrustManager(hiHonorX509TrustManager);
        this.b.init(null, new X509TrustManager[]{hiHonorX509TrustManager}, null);
    }

    public SecureApacheSSLSocketFactory(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        super(keyStore);
        this.j = null;
        this.b = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.b.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public static SecureApacheSSLSocketFactory getInstance(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyManagementException, KeyStoreException, CertificateException, IllegalArgumentException {
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (y == null) {
            synchronized (SecureApacheSSLSocketFactory.class) {
                if (y == null) {
                    y = new SecureApacheSSLSocketFactory(keyStore, context);
                }
            }
        }
        return y;
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "sasf update socket factory trust manager");
        try {
            y = new SecureApacheSSLSocketFactory((KeyStore) null, x509TrustManager);
        } catch (IOException unused) {
            g.e(TAG, "IOException");
        } catch (KeyManagementException unused2) {
            g.e(TAG, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            g.e(TAG, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            g.e(TAG, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            g.e(TAG, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            g.e(TAG, "CertificateException");
        }
    }

    public void setContext(Context context) {
        this.k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        g.c(TAG, "createSocket: socket host port autoClose");
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(socket, str, i, z);
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
