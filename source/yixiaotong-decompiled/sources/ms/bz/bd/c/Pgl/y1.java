package ms.bz.bd.c.Pgl;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
final class y1 extends SSLSocketFactory {
    private static final String[] tt = {(String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0, "42ab17", new byte[]{17, Ascii.FS, 33, 0, 95, 110, 101})};
    final SSLSocketFactory c;

    public y1(SSLSocketFactory sSLSocketFactory) {
        this.c = sSLSocketFactory;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        Socket socketCreateSocket = this.c.createSocket(str, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(tt);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.c.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.c.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        Socket socketCreateSocket = this.c.createSocket(str, i, inetAddress, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(tt);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        Socket socketCreateSocket = this.c.createSocket(inetAddress, i);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(tt);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        Socket socketCreateSocket = this.c.createSocket(inetAddress, i, inetAddress2, i2);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(tt);
        }
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        Socket socketCreateSocket = this.c.createSocket(socket, str, i, z);
        if (socketCreateSocket instanceof SSLSocket) {
            ((SSLSocket) socketCreateSocket).setEnabledProtocols(tt);
        }
        return socketCreateSocket;
    }
}
