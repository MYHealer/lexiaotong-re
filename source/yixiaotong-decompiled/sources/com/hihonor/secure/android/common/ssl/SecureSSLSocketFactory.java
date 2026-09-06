package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.StrUtil;
import com.hihonor.secure.android.common.ssl.util.g;
import com.stub.StubApp;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SecureSSLSocketFactory extends SSLSocketFactory {

    @Deprecated
    public static final X509HostnameVerifier BROWSER_COMPATIBLE_HOSTNAME_VERIFIER = new BrowserCompatHostnameVerifier();

    @Deprecated
    public static final X509HostnameVerifier STRICT_HOSTNAME_VERIFIER = new StrictHostnameVerifier();
    private static final String TAG = "SecureSSLSocketFactory";
    private static volatile SecureSSLSocketFactory singleton = null;
    private String[] blackCiphers;
    private String[] cipherSuites;
    private Context context;
    private String[] protocols;
    private SSLContext sslContext = null;
    private SSLSocket sslSocket = null;
    private X509TrustManager trustManager;
    private String[] whiteCiphers;

    public String[] getBlackCiphers() {
        return this.blackCiphers;
    }

    public Context getContext() {
        return this.context;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getProtocols() {
        return this.protocols;
    }

    public SSLContext getSslContext() {
        return this.sslContext;
    }

    public SSLSocket getSslSocket() {
        return this.sslSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.cipherSuites;
        return strArr != null ? strArr : new String[0];
    }

    public String[] getWhiteCiphers() {
        return this.whiteCiphers;
    }

    public X509TrustManager getX509TrustManager() {
        return this.trustManager;
    }

    public void setBlackCiphers(String[] strArr) {
        this.blackCiphers = strArr;
    }

    public void setProtocols(String[] strArr) {
        this.protocols = strArr;
    }

    public void setWhiteCiphers(String[] strArr) {
        this.whiteCiphers = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.trustManager = x509TrustManager;
    }

    public SecureSSLSocketFactory(InputStream inputStream, String str) throws NoSuchAlgorithmException, IOException, KeyManagementException, CertificateException, KeyStoreException, IllegalArgumentException {
        g.c(TAG, "SecureSSLSocketFactory: inputStream, pd");
        setSslContext(SSLUtil.setSSLContext());
        HiHonorX509TrustManager hiHonorX509TrustManager = new HiHonorX509TrustManager(inputStream, str);
        setX509TrustManager(hiHonorX509TrustManager);
        this.sslContext.init(null, new X509TrustManager[]{hiHonorX509TrustManager}, null);
    }

    private SecureSSLSocketFactory(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        String str = TAG;
        g.c(str, "SecureSSLSocketFactory: context");
        if (context == null) {
            g.e(str, "SecureSSLSocketFactory: context is null");
            return;
        }
        setContext(context);
        setSslContext(SSLUtil.setSSLContext());
        SecureX509TrustManager secureX509SingleInstance = SecureX509SingleInstance.getInstance(context);
        this.trustManager = secureX509SingleInstance;
        this.sslContext.init(null, new X509TrustManager[]{secureX509SingleInstance}, null);
    }

    public SecureSSLSocketFactory(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        g.c(TAG, "SecureSSLSocketFactory: x509TrustManager");
        setSslContext(SSLUtil.setSSLContext());
        setX509TrustManager(x509TrustManager);
        this.sslContext.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    public static SecureSSLSocketFactory getInstance(Context context) throws IllegalAccessException, NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        String str = TAG;
        g.c(str, "getInstance: context");
        if (context == null) {
            g.e(str, "getInstance: context is null");
        }
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (singleton == null) {
            synchronized (SecureSSLSocketFactory.class) {
                if (singleton == null) {
                    singleton = new SecureSSLSocketFactory(context);
                }
            }
        }
        if (singleton.context == null && context != null) {
            singleton.setContext(context);
        }
        return singleton;
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "ssf update socket factory trust manager");
        try {
            singleton = new SecureSSLSocketFactory(x509TrustManager);
        } catch (KeyManagementException unused) {
            g.e(TAG, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            g.e(TAG, "NoSuchAlgorithmException");
        }
    }

    public void setSslContext(SSLContext sSLContext) {
        String str = TAG;
        g.c(str, "setSslContext: sslContext");
        if (sSLContext != null) {
            this.sslContext = sSLContext;
        } else {
            g.e(str, "setSslContext: sslContext is null");
            throw new NullPointerException("sslContext is null");
        }
    }

    public void setContext(Context context) {
        g.c(TAG, "setContext: context");
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        String str2 = TAG;
        g.c(str2, "createSocket(host, port)");
        SSLContext sSLContext = this.sslContext;
        if (sSLContext == null) {
            g.e(str2, "createSocket(host, port): sslContext is null");
            return null;
        }
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        if (socketFactory == null) {
            g.e(str2, "createSocket(host, port): socketFactory is null");
            return null;
        }
        Socket socketCreateSocket = socketFactory.createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            configureSocket(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.sslSocket = sSLSocket;
            this.cipherSuites = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return createSocket(str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        String str2 = TAG;
        g.c(str2, "createSocket(socket,host,port,autoClose)");
        SSLContext sSLContext = this.sslContext;
        if (sSLContext == null) {
            g.e(str2, "createSocket(socket,host,port,autoClose): sslContext is null");
            return null;
        }
        SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
        if (socketFactory == null) {
            g.e(str2, "createSocket(socket,host,port,autoClose): socketFactory is null");
            return null;
        }
        Socket socketCreateSocket = socketFactory.createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            configureSocket(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.sslSocket = sSLSocket;
            this.cipherSuites = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return socketCreateSocket;
    }

    public X509Certificate[] getChain() {
        X509TrustManager x509TrustManager = this.trustManager;
        return x509TrustManager instanceof SecureX509TrustManager ? ((SecureX509TrustManager) x509TrustManager).getChain() : new X509Certificate[0];
    }

    private void configureSocket(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (StrUtil.emptyArray(this.protocols)) {
            z = false;
        } else {
            g.c(TAG, "set protocols");
            SSLUtil.setEnabledProtocols((SSLSocket) socket, this.protocols);
            z = true;
        }
        if (StrUtil.emptyArray(this.whiteCiphers) && StrUtil.emptyArray(this.blackCiphers)) {
            z2 = false;
        } else {
            g.c(TAG, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            SSLUtil.setEnabledProtocols(sSLSocket);
            if (!StrUtil.emptyArray(this.whiteCiphers)) {
                SSLUtil.setWhiteListCipherSuites(sSLSocket, this.whiteCiphers);
            } else {
                SSLUtil.setBlackListCipherSuites(sSLSocket, this.blackCiphers);
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
