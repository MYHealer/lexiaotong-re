package com.ubix.ssp.ad.e.b0.h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class i extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f8790a = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector b;
    private final String c;
    private final int d;

    i(ProxySelector proxySelector, String str, int i) {
        this.b = (ProxySelector) l.a(proxySelector);
        this.c = (String) l.a(str);
        this.d = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new i(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.c.equals(uri.getHost()) && this.d == uri.getPort()) ? f8790a : this.b.select(uri);
    }
}
