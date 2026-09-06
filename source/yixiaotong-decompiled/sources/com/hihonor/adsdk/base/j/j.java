package com.hihonor.adsdk.base.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.common.f.q;
import com.hihonor.android.app.PackageManagerEx;
import com.hihonor.android.content.ContextEx;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {
    private static final String hnadsa = "PhoneUtil";
    private static final int hnadsb = 2;
    private static final double hnadsc = 7.0d;
    private static final String hnadsd = "ro.build.version.magic";
    private static final String hnadse = "UnKnow";
    private static Class<?> hnadsf = null;
    private static Method hnadsg = null;
    private static final String hnadsh = "http.agent";
    private static String hnadsj;
    private static final String hnadsi = "com." + m.hnadsa() + ".android.app.PackageManagerEx";
    private static final Map<String, String> hnadsk = new com.hihonor.adsdk.common.safe.a();

    private j() {
    }

    public static String hnadsa() {
        return Build.VERSION.RELEASE;
    }

    public static String hnadsb(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static String hnadsd() {
        return Build.MODEL;
    }

    public static String hnadse() {
        String languageTag = Locale.getDefault().toLanguageTag();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getLanguageTag = " + languageTag, new Object[0]);
        return languageTag;
    }

    public static boolean hnadsf(Context context) {
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isPad#context is null", new Object[0]);
            return false;
        }
        try {
            if (context.getSystemService("window") instanceof WindowManager) {
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics);
                return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= hnadsc;
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isPad#error=" + e.getMessage(), new Object[0]);
        }
        return false;
    }

    public static String hnadsg() {
        String strHnadsf = hnadsf();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("getMagicVersionCompat,by magicVersion :" + strHnadsf));
        if (strHnadsf == null || !strHnadsf.contains("_")) {
            return strHnadsf;
        }
        String[] strArrSplit = strHnadsf.split("_");
        return strArrSplit.length > 1 ? strArrSplit[1] : strHnadsf;
    }

    public static String hnadsh() {
        return Build.MANUFACTURER;
    }

    public static String hnadsi() {
        return Build.DISPLAY;
    }

    public static boolean hnadsj() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.fsm.HwFoldScreenManagerEx");
            return ((Boolean) cls.getDeclaredMethod("isVerticalInwardFoldDevice", new Class[0]).invoke(cls.newInstance(), new Object[0])).booleanValue();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFoldable: HwFoldScreenManagerEx to Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsk() {
        try {
            Class<?> cls = Class.forName("com.hihonor.android.fsm.HwFoldScreenManagerEx");
            return ((Boolean) cls.getDeclaredMethod("isFoldable", new Class[0]).invoke(cls.newInstance(), new Object[0])).booleanValue();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFoldable: HwFoldScreenManagerEx to Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsl() {
        if (!hnadsk()) {
            return false;
        }
        try {
            Class<?> cls = Class.forName("com.hihonor.android.fsm.HwFoldScreenManagerEx");
            return ((Integer) cls.getDeclaredMethod("getDisplayMode", new Class[0]).invoke(cls.newInstance(), new Object[0])).intValue() == 1;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isFoldingScreenFull, HwFoldScreenManagerEx to Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    private static boolean hnadsm() {
        return "HONOR".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean hnadsn() {
        return hnadsm() && 1 == hnadsc();
    }

    public static boolean hnadso() {
        boolean zHnadsl = hnadsl();
        boolean z = !hnadsj();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isLargeFoldingScreenFull,isFoldingScreenFull: " + zHnadsl + ",nonFlipFoldable:" + z, new Object[0]);
        return zHnadsl && z;
    }

    public static boolean hnadsp() {
        String strHnadsg = hnadsg();
        if (TextUtils.isEmpty(strHnadsg)) {
            return false;
        }
        try {
            return q.hnadsd(strHnadsg.substring(0, 1), true) >= 7;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "isMagicVersion7 error: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsq() {
        String strHnadsg = hnadsg();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("magicVersion :" + strHnadsg));
        return !TextUtils.isEmpty(strHnadsg) && strHnadsg.startsWith("4");
    }

    public static boolean hnadsr() {
        String strHnadsg = hnadsg();
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("magicVersion :" + strHnadsg));
        if (TextUtils.isEmpty(strHnadsg)) {
            return false;
        }
        return hnadsq() || strHnadsg.startsWith("5");
    }

    public static File hnadsa(String str, String str2) {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) ("filterFileBySuffix() dir is not exists dirFilePath=" + str));
            return null;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null || fileArrListFiles.length <= 0) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "filterFileBySuffix() dir array is null dirFilePath=" + str, new Object[0]);
            return null;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null && file2.exists() && file2.isFile()) {
                String name = file2.getName();
                if (name.endsWith(str2)) {
                    com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "filterFileBySuffix() fileName=" + name, new Object[0]);
                    return file2;
                }
            }
        }
        return null;
    }

    private static String hnadsc(Context context) {
        if (hnadsj == null) {
            Locale locale = Locale.ROOT;
            String str = Build.VERSION.RELEASE;
            String str2 = Build.MODEL;
            hnadsj = String.format(locale, "(Linux; Android %s; %s Build/%s%s)  %s/%s", str, str2, Build.BRAND, str2, b.hnadsb(context), b.hnadsg(context));
        }
        return hnadsj;
    }

    public static String hnadsd(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static PackageInfo hnadsb(String str) {
        try {
            if (hnadsq()) {
                str = hnadsb(str, ".apk");
            }
            return HnAds.get().getContext().getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Throwable th) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getPackageArchiveInfo :" + th.getMessage(), new Object[0]);
            return null;
        }
    }

    public static String hnadse(Context context) {
        try {
            String str = System.getProperty(hnadsh) + "  " + b.hnadsb(context) + "/" + b.hnadsg(context);
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt > 31 && cCharAt < 127) {
                    stringBuffer.append(cCharAt);
                } else {
                    stringBuffer.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                }
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getUserAgent, get system ua error,msg is " + e.getMessage(), new Object[0]);
            return hnadsc(context);
        }
    }

    public static String hnadsb(String str, String str2) {
        File fileHnadsa = hnadsa(str, str2);
        if (fileHnadsa == null) {
            return str;
        }
        String str3 = File.separator;
        if (!str.endsWith(str3)) {
            str = str + str3;
        }
        return str + fileHnadsa.getName();
    }

    public static List<String> hnadsb() {
        if (hnadsr()) {
            com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "getAppPathList by ww ");
            try {
                Class<?> cls = Class.forName(hnadsi);
                List<String> list = (List) cls.getDeclaredMethod("getScanInstallList", new Class[0]).invoke(cls.newInstance(), new Object[0]);
                if (list != null) {
                    return list;
                }
            } catch (Throwable th) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "error= " + th.getMessage(), new Object[0]);
            }
            return new ArrayList();
        }
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) "getAppPathList by Hn ");
        return PackageManagerEx.getScanInstallList();
    }

    public static int hnadsc() {
        String str;
        Exception e;
        String str2 = "ro.build.version." + m.hnadsb();
        int i = -1;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str2);
            try {
                if (!TextUtils.isEmpty(str) && (str.contains("MagicUI") || str.contains("MagicOS"))) {
                    i = 2;
                } else if (TextUtils.isEmpty(str) || !str.contains("EmotionUI")) {
                    i = 1;
                }
            } catch (Exception e2) {
                e = e2;
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDeviceMode Exception" + e.getMessage(), new Object[0]);
            }
        } catch (Exception e3) {
            str = "";
            e = e3;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getDeviceMode: " + str, new Object[0]);
        return i;
    }

    public static String hnadsf() {
        return hnadsa(hnadsd);
    }

    private static String hnadsa(String str) {
        Map<String, String> map = hnadsk;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str2 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            map.put(str, str2);
            return str2;
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | LinkageError | NoSuchMethodException | InvocationTargetException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get, reflexion error, Exception: " + e.getMessage(), new Object[0]);
            return hnadse;
        }
    }

    public static Context hnadsa(Context context) {
        try {
            return (Context) Context.class.getDeclaredMethod("createCredentialProtectedStorageContext", new Class[0]).invoke(context, new Object[0]);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getCeContext, createCredentialProtectedStorageContext Exception " + e.getMessage(), new Object[0]);
            try {
                return ContextEx.createCredentialProtectedStorageContext(context);
            } catch (Exception e2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getCeContext, ContextEx getCeContext() Exception " + e2.getMessage(), new Object[0]);
                return context;
            }
        }
    }
}
