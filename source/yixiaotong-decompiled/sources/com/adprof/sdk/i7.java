package com.adprof.sdk;

import android.net.SSLCertificateSocketFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class i7 extends SSLSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SSLSocketFactory f1225a;

    public static i7 a(int i) {
        i7 i7Var = new i7();
        i7Var.f1225a = SSLCertificateSocketFactory.getDefault(i, null);
        return i7Var;
    }

    public static void a(SSLCertificateSocketFactory sSLCertificateSocketFactory, SSLSocket sSLSocket, String str) {
        qh.a(sSLCertificateSocketFactory);
        qh.a(sSLSocket);
        sSLCertificateSocketFactory.setHostname(sSLSocket, str);
    }

    public final void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket();
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(str, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(str, i, inetAddress, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(inetAddress, i);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2);
        a(socketCreateSocket);
        return socketCreateSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        return sSLSocketFactory == null ? new String[0] : sSLSocketFactory.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        return sSLSocketFactory == null ? new String[0] : sSLSocketFactory.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        SSLSocketFactory sSLSocketFactory = this.f1225a;
        if (sSLSocketFactory == null) {
            throw new SocketException("SSLSocketFactory was null. Unable to create socket.");
        }
        Socket socketCreateSocket = sSLSocketFactory.createSocket(socket, str, i, z);
        a(socketCreateSocket);
        return socketCreateSocket;
    }
}
