package com.ubixnow.ooooo;

import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d1 implements HostnameVerifier {
    public List<String> OooO00o = new ArrayList();

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return str == null || !this.OooO00o.contains(str);
    }
}
