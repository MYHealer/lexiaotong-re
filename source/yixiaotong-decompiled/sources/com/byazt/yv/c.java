package com.byazt.yv;

import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.y, 20})
public class c {
    public static com.byazt.dna.u c() {
        return (com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new");
    }

    public static String tt() {
        return c().getWifiMac(null);
    }

    public static int ve() {
        return c().getTimeZoneInt();
    }

    public static String uj() {
        return c().getRom();
    }

    public static String n() {
        return c().getDeviceModel();
    }

    public static String a() {
        return c().getVendor();
    }

    public static int sp() {
        return c().getDisplayDpi();
    }

    public static int x() {
        return c().getScreenHeight();
    }

    public static int i() {
        return c().getScreenWidth();
    }
}
