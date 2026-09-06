package com.meishu.sdk.core.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: compiled from: FixedIpDns.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t implements Dns {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile List<InetAddress> f4947a = new ArrayList();

    public t(String str) {
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        return (!"sdk.1rtb.net".equals(str) || f4947a == null || f4947a.isEmpty()) ? Dns.SYSTEM.lookup(str) : f4947a;
    }
}
