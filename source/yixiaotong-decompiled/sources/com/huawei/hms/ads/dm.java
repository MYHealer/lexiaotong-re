package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class dm {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.l V;

    public static com.huawei.openalliance.ad.inter.data.l Code() {
        com.huawei.openalliance.ad.inter.data.l lVar;
        synchronized (I) {
            lVar = V;
        }
        return lVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        synchronized (I) {
            try {
                if (lVar == null) {
                    fh.Code("GlobalDataShare", "set native ad null");
                    V = null;
                } else {
                    V = lVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
