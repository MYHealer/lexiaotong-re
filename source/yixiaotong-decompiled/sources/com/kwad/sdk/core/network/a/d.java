package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String strGM = com.kwad.sdk.ip.direct.a.gM(str);
        if (!TextUtils.isEmpty(strGM)) {
            List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName(strGM));
            if (listAsList == null || listAsList.isEmpty()) {
                return SYSTEM.lookup(str);
            }
            com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "inetAddresses:" + listAsList);
            return listAsList;
        }
        com.kwad.sdk.core.d.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}
