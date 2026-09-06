package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3922a = "z";
    private static final String b = "lib";
    private static final String c = "!";
    private static final String d = "armeabi-v7a";
    private static final String e = "armeabi";
    private static final Pattern f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    public static String a(Context context, String str) {
        for (String str2 : b(context)) {
            String str3 = str.substring(0, str.lastIndexOf(File.separator)) + File.separator + str2;
            if (new File(str3).exists()) {
                af.b(f3922a, "The so has been unzipped, abi:".concat(String.valueOf(str2)));
                return str3;
            }
        }
        return b(context, str);
    }

    private static boolean a(Context context) {
        if (context == null) {
            af.d(f3922a, "Null context, please check it.");
            return false;
        }
        if (StubApp.getOrigApplicationContext(context.getApplicationContext()) != null) {
            context.getApplicationContext();
        }
        return Process.is64Bit();
    }

    private static boolean a(File file, String str) throws Throwable {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                    while (enumerationEntries.hasMoreElements()) {
                        String name = enumerationEntries.nextElement().getName();
                        if (name.contains("../")) {
                            af.c(f3922a, "Unsafe zip name!");
                            aj.a(zipFile2);
                            return false;
                        }
                        Matcher matcher = f.matcher(name);
                        if (matcher.matches()) {
                            String strGroup = matcher.group(1);
                            if (TextUtils.equals(str, strGroup)) {
                                af.b(f3922a, "abiName:" + strGroup + " matched.");
                                aj.a(zipFile2);
                                return true;
                            }
                        }
                    }
                    aj.a(zipFile2);
                } catch (Exception e2) {
                    e = e2;
                    zipFile = zipFile2;
                    af.c(f3922a, "isApkContainPrefAbi exception:" + e.getClass().getSimpleName());
                    aj.a(zipFile);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    aj.a(zipFile);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String b(Context context, String str) {
        for (String str2 : b(context)) {
            if (a(new File(str), str2)) {
                af.b(f3922a, "use the preferred abi:".concat(String.valueOf(str2)));
                return str + c + File.separator + b + File.separator + str2;
            }
        }
        af.c(f3922a, "cannot get a valid native path, return null.");
        return null;
    }

    private static ArrayList<String> b(Context context) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, a(context) ? Build.SUPPORTED_64_BIT_ABIS : Build.SUPPORTED_32_BIT_ABIS);
        return arrayList;
    }
}
