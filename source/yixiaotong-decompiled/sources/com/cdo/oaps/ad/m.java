package com.cdo.oaps.ad;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class m {
    public static l a(String str) {
        if (Launcher.Host.MK.equals(str)) {
            return new n();
        }
        if (Launcher.Host.GC.equals(str)) {
            return new k();
        }
        return Launcher.Host.MK_OP.equals(str) ? new o() : new j();
    }
}
