package com.kwad.sdk.components;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class g {
    public static boolean encryptDisable() {
        return dP("KEY_HOST_ENCRYPT_DISABLE");
    }

    public static boolean dP(String str) {
        DevelopMangerComponents.DevelopValue developValueDO = d.dO(str);
        return developValueDO != null && ((Boolean) developValueDO.getValue()).booleanValue();
    }
}
