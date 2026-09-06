package com.ubix.ssp.ad.e.x;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f8927a = new ArrayList();

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return this.f8927a.isEmpty() || !this.f8927a.contains(str);
    }
}
