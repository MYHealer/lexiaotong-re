package com.adprof.sdk;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class oi extends t5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public t5 f1346a;

    public oi(SSLSocketFactory sSLSocketFactory) {
        if (this.f1346a == null) {
            this.f1346a = new na(null, sSLSocketFactory);
        }
    }

    @Override // com.adprof.sdk.t5
    public ia a(li liVar, Map map) throws w3, IOException {
        if (map == null || map.isEmpty()) {
            map = new TreeMap();
        }
        map.put("User-Agent", ig.a());
        pk.d(" httpStack = " + this.f1346a + "    url = " + liVar.m674a());
        return this.f1346a.a(liVar, map);
    }
}
