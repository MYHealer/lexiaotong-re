package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3906a = "ClassLoaderPathManager";
    private static final String b = "com.huawei.hff";
    private static HashMap<String, ArrayList<String>> c = new HashMap<>();

    public static String a(Context context, String str, PackageInfo packageInfo) {
        String str2;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f3906a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        if (c.containsKey(str)) {
            ArrayList<String> arrayList = c.get(str);
            if (arrayList != null && !arrayList.isEmpty()) {
                StringBuilder sb = new StringBuilder(str);
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    sb.append(File.pathSeparator).append(it.next());
                }
                return sb.toString();
            }
            str2 = "No split apk path has set.";
        } else {
            str2 = "No split apk required, continue.";
        }
        af.b(f3906a, str2);
        return str;
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f3906a, "No split apk path has set.");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            if (sb.length() == 0) {
                sb.append(z.b(context, str));
            } else {
                sb.append(File.pathSeparator).append(z.b(context, str));
            }
        }
        return sb.toString();
    }

    public static String b(Context context, String str, PackageInfo packageInfo) {
        String string = null;
        if (context == null || TextUtils.isEmpty(str) || packageInfo == null) {
            af.c(f3906a, "clientContext or dynamicApkPath or dynamicPackageInfo is null.");
            return null;
        }
        c(context, str, packageInfo);
        String strA = ag.a(context, str, z.a(context, str), packageInfo);
        packageInfo.applicationInfo.nativeLibraryDir = strA;
        if (!c.containsKey(str)) {
            af.b(f3906a, "No split apk required, continue.");
            return strA;
        }
        ArrayList<String> arrayList = c.get(str);
        if (arrayList == null || arrayList.isEmpty()) {
            af.b(f3906a, "No split apk path has set.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (String str2 : arrayList) {
                if (sb.length() == 0) {
                    sb.append(z.b(context, str2));
                } else {
                    sb.append(File.pathSeparator).append(z.b(context, str2));
                }
            }
            string = sb.toString();
        }
        if (TextUtils.isEmpty(strA)) {
            return string;
        }
        return TextUtils.isEmpty(string) ? strA : strA + File.pathSeparator + string;
    }

    private static void c(Context context, String str, PackageInfo packageInfo) {
        if (c.containsKey(str)) {
            af.b(f3906a, "HFF split info for dynamicApkPath has set.");
            return;
        }
        new r();
        Set<q> setA = r.a(context, packageInfo.applicationInfo, "com.huawei.hff");
        if (setA.isEmpty()) {
            af.b(f3906a, "No HFF split path need to add to classloader.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<q> it = setA.iterator();
        while (it.hasNext()) {
            arrayList.add(ad.a(it.next().f3911a));
        }
        c.put(str, arrayList);
    }
}
