package com.meishu.sdk.core.utils;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l1 {
    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() == 1) {
                sb.append("0").append(upperCase);
            } else {
                sb.append(upperCase);
            }
        }
        return sb.toString();
    }
}
