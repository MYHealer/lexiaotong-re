package com.hihonor.adsdk.common.f;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class v {
    private static final String hnadsa = "SecUtil";

    public static String hnadsa(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(Base64.decode(str, 2), StandardCharsets.UTF_8);
        } catch (Exception unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Base64Decode Exception", new Object[0]);
            return "";
        }
    }

    public static String hnadsb(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            if (bytes != null && bytes.length > 0) {
                return Base64.encodeToString(bytes, 2);
            }
        } catch (Exception unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Base64Encode Exception", new Object[0]);
        }
        return "";
    }
}
