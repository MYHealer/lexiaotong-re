package com.hihonor.adsdk.common.f;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class m {
    private static final String hnadsa = "m";

    public static void hnadsa(Closeable... closeableArr) {
        if (closeableArr == null) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "closeSecure, closeableArr is null", new Object[0]);
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "closeSecure, close error Exception: " + e.getMessage(), new Object[0]);
                }
            }
        }
    }
}
