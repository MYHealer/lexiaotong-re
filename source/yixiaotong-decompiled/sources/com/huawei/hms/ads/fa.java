package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class fa {
    private static final String Code = "InterstitialGlobalDataShare";
    private static final byte[] I = new byte[0];
    private static ez V;

    public static ez Code() {
        ez ezVar;
        synchronized (I) {
            ezVar = V;
        }
        return ezVar;
    }

    public static void Code(ez ezVar) {
        synchronized (I) {
            try {
                if (ezVar == null) {
                    fh.Code(Code, "set interstitial ad null");
                    V = null;
                } else {
                    V = ezVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
