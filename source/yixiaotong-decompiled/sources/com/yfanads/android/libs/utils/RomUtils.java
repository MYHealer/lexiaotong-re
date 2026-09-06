package com.yfanads.android.libs.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.byazt.bv.BaseConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ml.camera.CountryCodeBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class RomUtils {
    private RomUtils() {
    }

    public static boolean is360OS() {
        return !TextUtils.isEmpty(sysProperty("ro.build.uiversion", ""));
    }

    public static boolean isASUS() {
        return Build.MANUFACTURER.equalsIgnoreCase("ASUS") || Build.BRAND.equalsIgnoreCase("ASUS");
    }

    public static boolean isBlackShark() {
        return Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") || Build.BRAND.equalsIgnoreCase("BLACKSHARK");
    }

    public static boolean isCoolpad(Context context) {
        try {
            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isCoosea() {
        return sysProperty("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean isEmui() {
        return !TextUtils.isEmpty(sysProperty("ro.build.version.emui", ""));
    }

    public static boolean isFreeme() {
        return !TextUtils.isEmpty(sysProperty("ro.build.freeme.label", ""));
    }

    public static boolean isHn() {
        if (!isPhone("honor")) {
            return false;
        }
        Log.d("PhoneBrandChecker", "Found brand \"HONOR\"");
        return true;
    }

    public static boolean isHonor() {
        return Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isHw() {
        if (!isPhone("huawei") && !isEmui()) {
            return false;
        }
        Log.d("PhoneBrandChecker", "Found brand \"HUAWEI\"");
        return true;
    }

    public static boolean isLenovo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("LENOVO") && !str.equalsIgnoreCase("ZUK")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.equalsIgnoreCase("MEIZU") || Build.BRAND.equalsIgnoreCase("MEIZU") || Build.DISPLAY.toUpperCase().contains("FLYME");
    }

    public static boolean isMiui() {
        return !TextUtils.isEmpty(sysProperty("ro.miui.ui.version.name", ""));
    }

    public static boolean isMotolora() {
        return Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") || Build.BRAND.equalsIgnoreCase("MOTOLORA");
    }

    public static boolean isNubia() {
        return Build.MANUFACTURER.equalsIgnoreCase("NUBIA") || Build.BRAND.equalsIgnoreCase("NUBIA");
    }

    public static boolean isOHuawei() {
        return Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") || Build.BRAND.equalsIgnoreCase("HUAWEI");
    }

    public static boolean isOnePlus() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOps() {
        if (!isPhone("oppo") && !isPhone("oneplus") && !isPhone("realme")) {
            return false;
        }
        Log.d("PhoneBrandChecker", "Found brand \"OPPO\"");
        return true;
    }

    public static boolean isPhone(String str) {
        String str2 = Build.MANUFACTURER;
        String str3 = Build.FINGERPRINT;
        String str4 = Build.BRAND;
        if (!TextUtils.isEmpty(str4) && str4.toLowerCase().contains(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2) || !str2.toLowerCase().contains(str)) {
            return !TextUtils.isEmpty(str3) && str3.toLowerCase().contains(str);
        }
        return true;
    }

    public static boolean isSSUI() {
        return !TextUtils.isEmpty(sysProperty("ro.ssui.product", ""));
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(sysProperty("ro.vivo.os.version", ""));
    }

    public static boolean isXiaomi() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isXm() {
        if (!isPhone(MediationConstant.ADN_XIAOMI)) {
            return false;
        }
        Log.w("PhoneBrandChecker", "Found brand \"XIAOMI\"");
        return true;
    }

    public static boolean isZTE() {
        return Build.MANUFACTURER.equalsIgnoreCase("ZTE") || Build.BRAND.equalsIgnoreCase("ZTE");
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }
}
