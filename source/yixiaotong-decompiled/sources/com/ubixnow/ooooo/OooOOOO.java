package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OooOOOO {
    private static OooOOOO OooO00o;

    public static OooOOOO OooO00o() {
        if (OooO00o == null) {
            synchronized (OooOOOO.class) {
                if (OooO00o == null) {
                    OooO00o = new OooOOOO();
                }
            }
        }
        return OooO00o;
    }
}
