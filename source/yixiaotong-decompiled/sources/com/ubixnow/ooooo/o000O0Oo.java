package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000O0Oo {
    private static o000O0Oo OooO00o;

    public static o000O0Oo OooO00o() {
        if (OooO00o == null) {
            synchronized (o000O0Oo.class) {
                if (OooO00o == null) {
                    OooO00o = new o000O0Oo();
                }
            }
        }
        return OooO00o;
    }
}
