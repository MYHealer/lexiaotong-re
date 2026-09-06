package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class cq {
    private static volatile db Code;
    private static final byte[] V = new byte[0];

    public static db Code(Context context) {
        if (Code == null) {
            synchronized (V) {
                if (Code == null) {
                    Code = cp.Z(context) ? cw.Code(context) : cy.Code(context);
                }
            }
        }
        return Code;
    }
}
