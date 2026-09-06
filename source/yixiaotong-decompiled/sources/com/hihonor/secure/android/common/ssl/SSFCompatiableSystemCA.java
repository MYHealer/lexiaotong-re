package com.hihonor.secure.android.common.ssl;

import android.content.Context;
import com.hihonor.secure.android.common.ssl.util.StrUtil;
import com.hihonor.secure.android.common.ssl.util.g;
import com.stub.StubApp;
import java.io.IOException;
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

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class SSFCompatiableSystemCA extends SSLSocketFactory {
    private static final String TAG = "SSFCompatiableSystemCA";
    private static volatile SSFCompatiableSystemCA q;
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

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
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

    @Override // javax.net.ssl.SSLSocketFactory
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

    public void setWhiteCiphers(String[] strArr) {
        this.o = strArr;
    }

    public void setX509TrustManager(X509TrustManager x509TrustManager) {
        this.m = x509TrustManager;
    }

    private SSFCompatiableSystemCA(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException {
        this.b = null;
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

    public static SSFCompatiableSystemCA getInstance(Context context) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        com.hihonor.secure.android.common.ssl.util.c.setContext(context);
        if (q == null) {
            synchronized (SSFCompatiableSystemCA.class) {
                if (q == null) {
                    q = new SSFCompatiableSystemCA(context);
                }
            }
        }
        if (q.k == null && context != null) {
            q.setContext(context);
        }
        return q;
    }

    public SSFCompatiableSystemCA(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.b = null;
        this.j = null;
        this.b = SSLUtil.setSSLContext();
        setX509TrustManager(x509TrustManager);
        this.b.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    static void a(X509TrustManager x509TrustManager) {
        g.c(TAG, "ssfc update socket factory trust manager");
        try {
            q = new SSFCompatiableSystemCA(x509TrustManager);
        } catch (KeyManagementException unused) {
            g.e(TAG, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            g.e(TAG, "NoSuchAlgorithmException");
        }
    }

    public void setContext(Context context) {
        this.k = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        g.c(TAG, "createSocket: host , port");
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            b(socketCreateSocket);
            SSLSocket sSLSocket = (SSLSocket) socketCreateSocket;
            this.j = sSLSocket;
            this.l = (String[]) sSLSocket.getEnabledCipherSuites().clone();
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
        g.c(TAG, "createSocket: s , host , port , autoClose");
        Socket socketCreateSocket = this.b.getSocketFactory().createSocket(socket, str, i, z);
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
