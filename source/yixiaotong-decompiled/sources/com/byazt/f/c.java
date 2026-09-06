package com.byazt.f;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 953, 20})
public final class c extends com.byazt.q.c {
    public int n;

    public uj c(InetAddress inetAddress, int i) throws IOException {
        if (!tt()) {
            c();
        }
        tt ttVar = new tt();
        ttVar.c(3);
        ttVar.tt(this.n);
        DatagramPacket datagramPacketYp = ttVar.yp();
        datagramPacketYp.setAddress(inetAddress);
        datagramPacketYp.setPort(i);
        tt ttVar2 = new tt();
        DatagramPacket datagramPacketYp2 = ttVar2.yp();
        ttVar.c(n.uj());
        this.tt.send(datagramPacketYp);
        this.tt.receive(datagramPacketYp2);
        return new uj(ttVar2, System.currentTimeMillis(), false);
    }

    public uj c(InetAddress inetAddress) throws IOException {
        return c(inetAddress, AppTypeIdUtil.NewDevice4GBathOTA);
    }
}
