package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cu extends cr {
    private static da I;
    private static final byte[] Z = new byte[0];
    private com.huawei.openalliance.ad.utils.n B;

    private cu(Context context) {
        super(context);
        this.B = new com.huawei.openalliance.ad.utils.n(context);
    }

    private static da I(Context context) {
        da daVar;
        synchronized (Z) {
            if (I == null) {
                I = new cu(context);
            }
            daVar = I;
        }
        return daVar;
    }

    public static da V(Context context) {
        return I(context);
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean Code() {
        return "CN".equalsIgnoreCase(this.B.Code());
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean I() {
        return false;
    }

    @Override // com.huawei.hms.ads.cr, com.huawei.hms.ads.da
    public boolean V() {
        return Code();
    }
}
