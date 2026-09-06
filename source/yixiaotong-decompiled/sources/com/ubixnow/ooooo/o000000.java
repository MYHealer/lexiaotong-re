package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o000000 {
    private static o000000 OooO00o;

    public static o000000 OooO00o() {
        if (OooO00o == null) {
            synchronized (o000000.class) {
                if (OooO00o == null) {
                    OooO00o = new o000000();
                }
            }
        }
        return OooO00o;
    }
}
