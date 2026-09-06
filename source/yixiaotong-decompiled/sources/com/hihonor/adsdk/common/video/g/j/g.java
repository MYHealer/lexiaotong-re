package com.hihonor.adsdk.common.video.g.j;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class g extends ProxySelector {
    private static final List<Proxy> hnadsd = Arrays.asList(Proxy.NO_PROXY);
    private final ProxySelector hnadsa;
    private final String hnadsb;
    private final int hnadsc;

    g(ProxySelector proxySelector, String str, int i) {
        this.hnadsa = proxySelector;
        this.hnadsb = str;
        this.hnadsc = i;
    }

    static void hnadsa(String str, int i) {
        ProxySelector.setDefault(new g(ProxySelector.getDefault(), str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.hnadsa.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        return (this.hnadsb.equals(uri.getHost()) && this.hnadsc == uri.getPort()) ? hnadsd : this.hnadsa.select(uri);
    }
}
