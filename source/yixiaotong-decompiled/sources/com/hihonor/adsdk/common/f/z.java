package com.hihonor.adsdk.common.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class z {
    public static String hnadsa(String str) {
        return str.replaceAll("\"", "\\\\\"");
    }

    public static String hnadsa(int i, String str) {
        return hnadsa(String.valueOf(i), str);
    }

    public static String hnadsa(String str, String str2) {
        return "code : " + str + ", Msg : " + str2;
    }
}
