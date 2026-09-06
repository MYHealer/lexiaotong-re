package com.fancy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _es extends ProxySelector {
    public static final List<Proxy> _d = Arrays.asList(Proxy.NO_PROXY);
    public final ProxySelector _a;
    public final String _b = (String) _hy._a("127.0.0.1");
    public final int _c;

    public _es(ProxySelector proxySelector, int i) {
        this._a = (ProxySelector) _hy._a(proxySelector);
        this._c = i;
    }

    public static void _a(int i) {
        ProxySelector.setDefault(new _es(ProxySelector.getDefault(), i));
    }

    @Override // java.net.ProxySelector
    public final void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this._a.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public final List<Proxy> select(URI uri) {
        return (this._b.equals(uri.getHost()) && this._c == uri.getPort()) ? _d : this._a.select(uri);
    }
}
