package com.heytap.mspsdk.util;

import android.os.Build;
import android.text.TextUtils;
import com.heytap.mspsdk.log.MspLog;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            MspLog.e("DeviceUtils", "getProperty: " + e.getMessage());
            return str2;
        }
    }

    public static boolean a() {
        String strC = c();
        return ("CN".equalsIgnoreCase(strC) || "OC".equalsIgnoreCase(strC)) ? false : true;
    }

    public static boolean b() {
        try {
            String strA = com.heytap.mspsdk.util.md5.a.a(Build.BRAND.toUpperCase());
            return TextUtils.equals("67843bc0e7e7b09cc369beabf05e9d30", strA) || TextUtils.equals("60c89617499cd5202c71062b5f22087d", strA) || TextUtils.equals("5836b6c1f251363d1ebc8e1c2e1fb9b9", strA);
        } catch (IOException e) {
            MspLog.e("Md5Util", "isOwnBrand: " + e.getMessage());
            return false;
        }
    }

    public static String c() {
        for (int i = 0; i < com.heytap.mspsdk.constants.a.f3458a.length; i++) {
            String strB = f.b(com.heytap.mspsdk.constants.a.f3458a[i]);
            if (!TextUtils.isEmpty(strB)) {
                String strA = g.a(strB, "");
                if (!TextUtils.isEmpty(strA)) {
                    MspLog.d("DeviceUtils", String.format("==== getRegion:%s from %s", strB, strA));
                    return strA;
                }
            }
        }
        return "";
    }
}
