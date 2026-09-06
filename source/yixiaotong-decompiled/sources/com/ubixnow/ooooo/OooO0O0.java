package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class OooO0O0 {
    private static OooO0O0 OooO00o;

    public static OooO0O0 OooO00o() {
        if (OooO00o == null) {
            synchronized (OooO0O0.class) {
                if (OooO00o == null) {
                    OooO00o = new OooO0O0();
                }
            }
        }
        return OooO00o;
    }
}
