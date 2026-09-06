package com.huawei.openalliance.ad.inter;

import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b {
    private static final String Code = "AdATManager";
    private static b I;
    private static final byte[] V = new byte[0];
    private String B;
    private s Z;

    private b() {
    }

    public static b Code() {
        b bVar;
        synchronized (V) {
            if (I == null) {
                I = new b();
            }
            bVar = I;
        }
        return bVar;
    }

    public void Code(s sVar) {
        this.Z = sVar;
    }

    public void Code(String str) {
        this.B = str;
    }

    public String I() {
        return this.B;
    }

    public String V() {
        s sVar = this.Z;
        if (sVar != null) {
            return sVar.Code();
        }
        fh.V(Code, "accessTokenProvider is null, return");
        return null;
    }
}
