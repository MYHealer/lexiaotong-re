package com.jd.ad.sdk.jad_kn;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_bo {
    public static long jad_an;
    public static String[] jad_bo = {"/data/app/com.bluestacks.appmart-1.apk", "/data/app/com.bluestacks.BstCommandProcessor-1.apk", "/data/app/com.bluestacks.help-1.apk", "/data/app/com.bluestacks.home-1.apk", "/data/app/com.bluestacks.s2p-1.apk", "/data/app/com.bluestacks.searchapp-1.apk", "/data/bluestacks.prop", "/data/data/com.androVM.vmconfig", "/data/data/com.bluestacks.accelerometerui", "/data/data/com.bluestacks.appfinder", "/data/data/com.bluestacks.appmart", "/data/data/com.bluestacks.appsettings", "/data/data/com.bluestacks.BstCommandProcessor", "/data/data/com.bluestacks.bstfolder", "/data/data/com.bluestacks.help", "/data/data/com.bluestacks.home", "/data/data/com.bluestacks.s2p", "/data/data/com.bluestacks.searchapp", "/data/data/com.bluestacks.settings", "/data/data/com.bluestacks.setup", "/data/data/com.bluestacks.spotlight", "/mnt/prebundledapps/bluestacks.prop.orig"};

    public static String jad_an(String str) {
        String str2;
        int i = com.jd.ad.sdk.jad_jm.jad_cp.jad_an;
        try {
            Class<?> clsLoadClass = ClassLoader.getSystemClassLoader().loadClass(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            Method method = clsLoadClass.getMethod("get", String.class);
            method.setAccessible(true);
            str2 = (String) method.invoke(clsLoadClass, str);
        } catch (Exception unused) {
            str2 = "";
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return str2;
    }

    public static boolean jad_an() {
        String str = Build.PRODUCT;
        if (str.contains(bn.g) || str.contains("sdk_x86") || str.contains("sdk_google") || str.contains("Andy") || str.contains("Droid4X") || str.contains("nox") || str.contains("vbox86p") || str.contains("aries")) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        if (str2.equals("Genymotion") || str2.contains("Andy") || str2.contains("nox") || str2.contains("TiantianVM") || Build.BRAND.contains("Andy")) {
            return true;
        }
        String str3 = Build.DEVICE;
        if (str3.contains("Andy") || str3.contains("Droid4X") || str3.contains("nox") || str3.contains("vbox86p") || str3.contains("aries")) {
            return true;
        }
        String str4 = Build.MODEL;
        if (str4.contains("Emulator") || str4.equals("google_sdk") || str4.contains("Droid4X") || str4.contains("TiantianVM") || str4.contains("Andy") || str4.equals("Android SDK built for x86_64") || str4.equals("Android SDK built for x86")) {
            return true;
        }
        String str5 = Build.HARDWARE;
        if (str5.equals("vbox86") || str5.contains("nox") || str5.contains("ttVM_x86")) {
            return true;
        }
        String str6 = Build.FINGERPRINT;
        return str6.contains("generic/sdk/generic") || str6.contains("generic_x86/sdk_x86/generic_x86") || str6.contains("Andy") || str6.contains("ttVM_Hdragon") || str6.contains("generic/google_sdk/generic") || str6.contains("vbox86p") || str6.contains("generic/vbox86p/vbox86p");
    }

    public static String jad_bo() {
        try {
            Process processStart = new ProcessBuilder("/system/bin/cat", "/proc/cpuinfo").start();
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processStart.getInputStream(), "utf-8"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return stringBuffer.toString().toLowerCase();
                }
                stringBuffer.append(line);
            }
        } catch (IOException unused) {
            return "";
        }
    }
}
