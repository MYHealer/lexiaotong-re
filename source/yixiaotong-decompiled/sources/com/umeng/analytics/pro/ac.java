package com.umeng.analytics.pro;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: DeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9091a = "ro.build.version.emui";
    private static final String b = "hw_sc.build.platform.version";

    public static z a(Context context) {
        String str = Build.BRAND;
        al.a("Device", "Brand", str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equalsIgnoreCase("huawei") || str.equalsIgnoreCase("honor") || str.equalsIgnoreCase("华为")) {
            return new ad();
        }
        if (str.equalsIgnoreCase(MediationConstant.ADN_XIAOMI) || str.equalsIgnoreCase("redmi") || str.equalsIgnoreCase("meitu") || str.equalsIgnoreCase("小米") || str.equalsIgnoreCase("blackshark")) {
            return new ak();
        }
        if (str.equalsIgnoreCase("vivo")) {
            return new aj();
        }
        if (str.equalsIgnoreCase("oppo") || str.equalsIgnoreCase("oneplus") || str.equalsIgnoreCase("realme")) {
            return new ah();
        }
        if (str.equalsIgnoreCase("lenovo") || str.equalsIgnoreCase("zuk")) {
            return new ae();
        }
        if (str.equalsIgnoreCase("nubia")) {
            return new ag();
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG")) {
            return new ai();
        }
        if (UMUtils.isAppInstalled(context, "com.coolpad.deviceidsupport")) {
            return new ab();
        }
        if (a()) {
            return new ad();
        }
        if (str.equalsIgnoreCase("meizu") || str.equalsIgnoreCase("mblu")) {
            return new af();
        }
        return null;
    }

    private static boolean a() {
        return (TextUtils.isEmpty(a(f9091a)) && TextUtils.isEmpty(a(b))) ? false : true;
    }

    private static String a(String str) {
        try {
            return (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return "";
        }
    }
}
