package com.jd.ad.sdk.jad_lo;

import com.huawei.hms.ml.camera.CountryCodeBean;
import com.jd.android.sdk.coreinfo.util.Logger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_hu {
    public static String jad_an(String str, String str2) {
        try {
            return (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Throwable th) {
            Logger.w("CoreInfo.SystemPropertyUtil", "An exception happends when call get(), key='" + str + "':\n" + th.toString());
            return str2;
        }
    }
}
