package com.huawei.hms.mlplugin.card.bcr;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.hms.ml.common.utils.SmartLog;

/* JADX INFO: renamed from: com.huawei.hms.mlplugin.card.bcr.r, reason: case insensitive filesystem */
/* JADX INFO: compiled from: NotchUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class C1209r {
    public static boolean a() {
        try {
            return ((Integer) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("getInt", String.class, Integer.TYPE).invoke(null, "ro.miui.notch", 0)).intValue() == 1;
        } catch (RuntimeException e) {
            SmartLog.e("NotchUtils", "isNotchSupportedInXiaomiPhone e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            SmartLog.e("NotchUtils", "isNotchSupportedInXiaomiPhone e = " + e2.getMessage());
            return false;
        }
    }

    public static int[] b(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class<?> clsLoadClass = Build.BRAND.equals("HONOR") ? classLoader.loadClass("com.hihonor.android.util.HwNotchSizeUtil") : classLoader.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) clsLoadClass.getMethod("getNotchSize", new Class[0]).invoke(clsLoadClass, new Object[0]);
        } catch (RuntimeException e) {
            SmartLog.e("NotchUtils", "getNotchSizeInHuaweiPhone e = " + e.getMessage());
            return new int[]{0, 0};
        } catch (Exception e2) {
            SmartLog.e("NotchUtils", "getNotchSizeInHuaweiPhone e = " + e2.getMessage());
            return new int[]{0, 0};
        }
    }

    public static boolean c(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            Class<?> clsLoadClass = Build.BRAND.equals("HONOR") ? classLoader.loadClass("com.hihonor.android.util.HwNotchSizeUtil") : classLoader.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) clsLoadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(clsLoadClass, new Object[0])).booleanValue();
        } catch (RuntimeException e) {
            SmartLog.e("NotchUtils", "isNotchSupportedInHuaweiPhone e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            SmartLog.e("NotchUtils", "isNotchSupportedInHuaweiPhone e = " + e2.getMessage());
            return false;
        }
    }

    public static boolean d(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean e(Context context) {
        try {
            Class<?> clsLoadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            return ((Boolean) clsLoadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(clsLoadClass, 32)).booleanValue();
        } catch (RuntimeException e) {
            SmartLog.e("NotchUtils", "isNotchSupportedInVivoPhone e = " + e.getMessage());
            return false;
        } catch (Exception e2) {
            SmartLog.e("NotchUtils", "isNotchSupportedInVivoPhone e = " + e2.getMessage());
            return false;
        }
    }

    public static int a(Context context) {
        int identifier = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }
}
