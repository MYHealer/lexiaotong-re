package com.byazt.f;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.net.DatagramPacket;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 953, 13})
public class tt implements ve {
    public final byte[] c = new byte[48];
    public volatile DatagramPacket tt;

    public static final int c(byte b) {
        return b & 255;
    }

    public static final long tt(byte b) {
        return b & 255;
    }

    @Override // com.byazt.f.ve
    public String getType() {
        return "NTP";
    }

    public int c() {
        return c(this.c[0]) & 7;
    }

    @Override // com.byazt.f.ve
    public void c(int i) {
        byte[] bArr = this.c;
        bArr[0] = (byte) ((i & 7) | (bArr[0] & 248));
    }

    public int tt() {
        return this.c[2];
    }

    public int ve() {
        return this.c[3];
    }

    public int uj() {
        return (c(this.c[0]) >> 3) & 7;
    }

    @Override // com.byazt.f.ve
    public void tt(int i) {
        byte[] bArr = this.c;
        bArr[0] = (byte) (((i & 7) << 3) | (bArr[0] & 199));
    }

    public int n() {
        return c(this.c[1]);
    }

    public int a() {
        return ve(4);
    }

    public int sp() {
        return ve(8);
    }

    public double x() {
        return ((double) sp()) / 65.536d;
    }

    public int i() {
        return ve(12);
    }

    public String da() {
        int iUj = uj();
        int iN = n();
        if (iUj == 3 || iUj == 4) {
            if (iN == 0 || iN == 1) {
                return m();
            }
            if (iUj == 4) {
                return nu();
            }
        }
        if (iN >= 2) {
            return z();
        }
        return nu();
    }

    private String z() {
        return c(this.c[12]) + "." + c(this.c[13]) + "." + c(this.c[14]) + "." + c(this.c[15]);
    }

    private String m() {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 3 && (c = (char) this.c[i + 12]) != 0; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    private String nu() {
        return Integer.toHexString(i());
    }

    @Override // com.byazt.f.ve
    public n sl() {
        return uj(40);
    }

    @Override // com.byazt.f.ve
    public void c(n nVar) {
        c(40, nVar);
    }

    @Override // com.byazt.f.ve
    public n t() {
        return uj(24);
    }

    @Override // com.byazt.f.ve
    public n u() {
        return uj(32);
    }

    private int ve(int i) {
        return c(this.c[i + 3]) | (c(this.c[i]) << 24) | (c(this.c[i + 1]) << 16) | (c(this.c[i + 2]) << 8);
    }

    private n uj(int i) {
        return new n(n(i));
    }

    private long n(int i) {
        return (tt(this.c[i]) << 56) | (tt(this.c[i + 1]) << 48) | (tt(this.c[i + 2]) << 40) | (tt(this.c[i + 3]) << 32) | (tt(this.c[i + 4]) << 24) | (tt(this.c[i + 5]) << 16) | (tt(this.c[i + 6]) << 8) | tt(this.c[i + 7]);
    }

    private void c(int i, n nVar) {
        long jC = nVar == null ? 0L : nVar.c();
        for (int i2 = 7; i2 >= 0; i2--) {
            this.c[i + i2] = (byte) (255 & jC);
            jC >>>= 8;
        }
    }

    @Override // com.byazt.f.ve
    public synchronized DatagramPacket yp() {
        if (this.tt == null) {
            byte[] bArr = this.c;
            this.tt = new DatagramPacket(bArr, bArr.length);
            this.tt.setPort(AppTypeIdUtil.NewDevice4GBathOTA);
        }
        return this.tt;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.c, ((tt) obj).c);
    }

    public int hashCode() {
        return Arrays.hashCode(this.c);
    }

    public String toString() {
        return "[version:" + uj() + ", mode:" + c() + ", poll:" + tt() + ", precision:" + ve() + ", delay:" + a() + ", dispersion(ms):" + x() + ", id:" + da() + ", xmitTime:" + sl().n() + " ]";
    }
}
