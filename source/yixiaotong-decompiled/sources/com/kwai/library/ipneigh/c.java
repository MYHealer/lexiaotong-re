package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static d eV(Context context) {
        return F(context, false);
    }

    private static d F(Context context, boolean z) {
        return b(context, false, false);
    }

    private static d b(Context context, boolean z, boolean z2) {
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String strGs = b.gs(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getDhcpInfo().gateway);
            String strIO = !z ? a.iO("timeout 5 ip neigh show " + strGs) : "";
            if (z || TextUtils.isEmpty(strIO)) {
                strIO = KwaiIpNeigh.j(strGs, false);
            }
            String strIQ = b.iQ(strIO);
            return new d(strIQ, !TextUtils.isEmpty(strIQ), strIO);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }
}
