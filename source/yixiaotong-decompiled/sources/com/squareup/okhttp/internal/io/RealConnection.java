package com.squareup.okhttp.internal.io;

import com.huawei.openalliance.ad.constant.x;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.ConnectionSpecSelector;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.http.Http1xStream;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.RouteException;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.tls.CertificateChainCleaner;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import com.squareup.okhttp.internal.tls.TrustRootIndex;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class RealConnection implements Connection {
    private static SSLSocketFactory lastSslSocketFactory;
    private static TrustRootIndex lastTrustRootIndex;
    public volatile FramedConnection framedConnection;
    private Handshake handshake;
    public boolean noNewStreams;
    private Protocol protocol;
    private Socket rawSocket;
    private final Route route;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    public int streamCount;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();
    public long idleAtNanos = Long.MAX_VALUE;

    @Override // com.squareup.okhttp.Connection
    public Handshake getHandshake() {
        return this.handshake;
    }

    @Override // com.squareup.okhttp.Connection
    public Route getRoute() {
        return this.route;
    }

    @Override // com.squareup.okhttp.Connection
    public Socket getSocket() {
        return this.socket;
    }

    boolean isConnected() {
        return this.protocol != null;
    }

    public boolean isMultiplexed() {
        return this.framedConnection != null;
    }

    public RealConnection(Route route) {
        this.route = route;
    }

    public void connect(int i, int i2, int i3, List<ConnectionSpec> list, boolean z) throws RouteException {
        if (this.protocol != null) {
            throw new IllegalStateException("already connected");
        }
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Proxy proxy = this.route.getProxy();
        Address address = this.route.getAddress();
        if (this.route.getAddress().getSslSocketFactory() == null && !list.contains(ConnectionSpec.CLEARTEXT)) {
            throw new RouteException(new UnknownServiceException("CLEARTEXT communication not supported: " + list));
        }
        RouteException routeException = null;
        while (this.protocol == null) {
            try {
                this.rawSocket = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? address.getSocketFactory().createSocket() : new Socket(proxy);
                connectSocket(i, i2, i3, connectionSpecSelector);
            } catch (IOException e) {
                Util.closeQuietly(this.socket);
                Util.closeQuietly(this.rawSocket);
                this.socket = null;
                this.rawSocket = null;
                this.source = null;
                this.sink = null;
                this.handshake = null;
                this.protocol = null;
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    routeException.addConnectException(e);
                }
                if (z) {
                    if (!connectionSpecSelector.connectionFailed(e)) {
                        throw routeException;
                    }
                } else {
                    throw routeException;
                }
            }
        }
    }

    private void connectSocket(int i, int i2, int i3, ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        this.rawSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.rawSocket, this.route.getSocketAddress(), i);
            this.source = Okio.buffer(Okio.source(this.rawSocket));
            this.sink = Okio.buffer(Okio.sink(this.rawSocket));
            if (this.route.getAddress().getSslSocketFactory() != null) {
                connectTls(i2, i3, connectionSpecSelector);
            } else {
                this.protocol = Protocol.HTTP_1_1;
                this.socket = this.rawSocket;
            }
            if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
                this.socket.setSoTimeout(0);
                FramedConnection framedConnectionBuild = new FramedConnection.Builder(true).socket(this.socket, this.route.getAddress().url().host(), this.source, this.sink).protocol(this.protocol).build();
                framedConnectionBuild.sendConnectionPreface();
                this.framedConnection = framedConnectionBuild;
            }
        } catch (ConnectException unused) {
            throw new ConnectException("Failed to connect to " + this.route.getSocketAddress());
        }
    }

    private void connectTls(int i, int i2, ConnectionSpecSelector connectionSpecSelector) throws Throwable {
        if (this.route.requiresTunnel()) {
            createTunnel(i, i2);
        }
        Address address = this.route.getAddress();
        SSLSocket sSLSocket = null;
        try {
            try {
                SSLSocket sSLSocket2 = (SSLSocket) address.getSslSocketFactory().createSocket(this.rawSocket, address.getUriHost(), address.getUriPort(), true);
                try {
                    ConnectionSpec connectionSpecConfigureSecureSocket = connectionSpecSelector.configureSecureSocket(sSLSocket2);
                    if (connectionSpecConfigureSecureSocket.supportsTlsExtensions()) {
                        Platform.get().configureTlsExtensions(sSLSocket2, address.getUriHost(), address.getProtocols());
                    }
                    sSLSocket2.startHandshake();
                    Handshake handshake = Handshake.get(sSLSocket2.getSession());
                    if (!address.getHostnameVerifier().verify(address.getUriHost(), sSLSocket2.getSession())) {
                        X509Certificate x509Certificate = (X509Certificate) handshake.peerCertificates().get(0);
                        throw new SSLPeerUnverifiedException("Hostname " + address.getUriHost() + " not verified:\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
                    }
                    if (address.getCertificatePinner() != CertificatePinner.DEFAULT) {
                        address.getCertificatePinner().check(address.getUriHost(), new CertificateChainCleaner(trustRootIndex(address.getSslSocketFactory())).clean(handshake.peerCertificates()));
                    }
                    String selectedProtocol = connectionSpecConfigureSecureSocket.supportsTlsExtensions() ? Platform.get().getSelectedProtocol(sSLSocket2) : null;
                    this.socket = sSLSocket2;
                    this.source = Okio.buffer(Okio.source(sSLSocket2));
                    this.sink = Okio.buffer(Okio.sink(this.socket));
                    this.handshake = handshake;
                    this.protocol = selectedProtocol != null ? Protocol.get(selectedProtocol) : Protocol.HTTP_1_1;
                    if (sSLSocket2 != null) {
                        Platform.get().afterHandshake(sSLSocket2);
                    }
                } catch (AssertionError e) {
                    e = e;
                    if (!Util.isAndroidGetsocknameError(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    sSLSocket = sSLSocket2;
                    if (sSLSocket != null) {
                        Platform.get().afterHandshake(sSLSocket);
                    }
                    Util.closeQuietly((Socket) sSLSocket);
                    throw th;
                }
            } catch (AssertionError e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static synchronized TrustRootIndex trustRootIndex(SSLSocketFactory sSLSocketFactory) {
        if (sSLSocketFactory != lastSslSocketFactory) {
            lastTrustRootIndex = Platform.get().trustRootIndex(Platform.get().trustManager(sSLSocketFactory));
            lastSslSocketFactory = sSLSocketFactory;
        }
        return lastTrustRootIndex;
    }

    private void createTunnel(int i, int i2) throws IOException {
        Request requestCreateTunnelRequest = createTunnelRequest();
        HttpUrl httpUrl = requestCreateTunnelRequest.httpUrl();
        String str = "CONNECT " + httpUrl.host() + x.bQ + httpUrl.port() + " HTTP/1.1";
        do {
            Http1xStream http1xStream = new Http1xStream(null, this.source, this.sink);
            this.source.getTimeout().timeout(i, TimeUnit.MILLISECONDS);
            this.sink.getTimeout().timeout(i2, TimeUnit.MILLISECONDS);
            http1xStream.writeRequest(requestCreateTunnelRequest.headers(), str);
            http1xStream.finishRequest();
            Response responseBuild = http1xStream.readResponse().request(requestCreateTunnelRequest).build();
            long jContentLength = OkHeaders.contentLength(responseBuild);
            if (jContentLength == -1) {
                jContentLength = 0;
            }
            Source sourceNewFixedLengthSource = http1xStream.newFixedLengthSource(jContentLength);
            Util.skipAll(sourceNewFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            sourceNewFixedLengthSource.close();
            int iCode = responseBuild.code();
            if (iCode == 200) {
                if (!this.source.getBufferField().exhausted() || !this.sink.getBufferField().exhausted()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else if (iCode == 407) {
                requestCreateTunnelRequest = OkHeaders.processAuthHeader(this.route.getAddress().getAuthenticator(), responseBuild, this.route.getProxy());
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + responseBuild.code());
            }
        } while (requestCreateTunnelRequest != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    private Request createTunnelRequest() throws IOException {
        return new Request.Builder().url(this.route.getAddress().url()).header("Host", Util.hostHeader(this.route.getAddress().url())).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
    }

    public void cancel() {
        Util.closeQuietly(this.rawSocket);
    }

    public int allocationLimit() {
        FramedConnection framedConnection = this.framedConnection;
        if (framedConnection != null) {
            return framedConnection.maxConcurrentStreams();
        }
        return 1;
    }

    public boolean isHealthy(boolean z) {
        if (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) {
            return false;
        }
        if (this.framedConnection == null && z) {
            try {
                int soTimeout = this.socket.getSoTimeout();
                try {
                    this.socket.setSoTimeout(1);
                    if (this.source.exhausted()) {
                        this.socket.setSoTimeout(soTimeout);
                        return false;
                    }
                    this.socket.setSoTimeout(soTimeout);
                    return true;
                } catch (Throwable th) {
                    this.socket.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.squareup.okhttp.Connection
    public Protocol getProtocol() {
        Protocol protocol = this.protocol;
        return protocol != null ? protocol : Protocol.HTTP_1_1;
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("Connection{").append(this.route.getAddress().url().host()).append(x.bQ).append(this.route.getAddress().url().port()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
        Handshake handshake = this.handshake;
        return sbAppend.append(handshake != null ? handshake.cipherSuite() : "none").append(" protocol=").append(this.protocol).append('}').toString();
    }
}
