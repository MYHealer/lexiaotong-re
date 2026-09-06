package com.adprof.sdk;

import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class yb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f1536a;

    static {
        HashMap map = new HashMap();
        f1536a = map;
        map.put("FFD8", "jpg");
        map.put("8950", "png");
        map.put("4749", "gif");
        map.put("4949", "tif");
        map.put("424D", "bmp");
        map.put("5745", "webp");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String upperCase = Integer.toHexString(b & 255).toUpperCase();
            if (upperCase.length() < 2) {
                sb.append(0);
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }
}
