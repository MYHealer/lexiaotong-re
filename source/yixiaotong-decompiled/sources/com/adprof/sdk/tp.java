package com.adprof.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class tp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f1447a = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid_scp/get").build();

    static {
        new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path("/oaid/query").build();
    }

    public static b3 a(Context context) {
        String string;
        String strC;
        if (!a(context, f1447a)) {
            return null;
        }
        String string2 = Settings.Global.getString(context.getContentResolver(), "pps_oaid_c");
        if (TextUtils.isEmpty(string2)) {
            return null;
        }
        wp wpVarA = wp.a(context);
        synchronized (wpVarA.f815b) {
            SharedPreferences sharedPreferences = wpVarA.c;
            if (sharedPreferences == null) {
                string = "";
            } else {
                string = sharedPreferences.getString("read_first_chapter", "");
                if (!TextUtils.isEmpty(string)) {
                    string = xp.c(string, xp.b(wpVarA.f812a));
                }
            }
        }
        if (TextUtils.isEmpty(string)) {
            Log.d("InfoProviderUtil", "scp is empty");
            yp.f1545a.execute(new rp(wpVarA, context));
            if (wpVarA.b()) {
                return new b3("00000000-0000-0000-0000-000000000000", true);
            }
            synchronized (wpVarA.f816c) {
                SharedPreferences sharedPreferences2 = wpVarA.f813a;
                if (sharedPreferences2 != null) {
                    sharedPreferences2.edit().putBoolean("has_read_first_chapter", true).apply();
                }
            }
            return null;
        }
        if (TextUtils.isEmpty(string2) || TextUtils.isEmpty(string)) {
            strC = null;
        } else {
            synchronized (xp.f847a) {
                try {
                    strC = xp.c(string2, xp.b(string));
                } catch (Throwable th) {
                    Log.w("Aes128", "decrypt oaid ex: " + th.getClass().getSimpleName());
                    strC = null;
                }
            }
        }
        if (!TextUtils.isEmpty(strC)) {
            return new b3(strC, "00000000-0000-0000-0000-000000000000".equalsIgnoreCase(strC));
        }
        Log.d("InfoProviderUtil", "decrypt oaid failed.");
        yp.f1545a.execute(new sp(context, wpVarA));
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0065  */
    public static boolean a(Context context, Uri uri) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        Object obj;
        Integer numValueOf;
        String str = "com.huawei.hwid.tv";
        if (context == null || uri == null) {
            return false;
        }
        ThreadPoolExecutor threadPoolExecutor = yp.f1545a;
        if (context == null) {
            numValueOf = null;
        } else {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (!up.a(context, "com.huawei.hwid")) {
                    if (up.a(context, "com.huawei.hms")) {
                        str = "com.huawei.hms";
                    } else if (up.a(context, "com.huawei.hwid.tv")) {
                    }
                    applicationInfo = packageManager.getApplicationInfo(str, 128);
                    if (applicationInfo != null || (bundle = applicationInfo.metaData) == null || (obj = bundle.get("ppskit_ver_code")) == null) {
                        numValueOf = null;
                    } else {
                        numValueOf = Integer.valueOf(obj.toString());
                    }
                }
                str = "com.huawei.hwid";
                applicationInfo = packageManager.getApplicationInfo(str, 128);
                if (applicationInfo != null) {
                    numValueOf = null;
                } else {
                    numValueOf = null;
                }
            } catch (Throwable th) {
                pk.a("StmUt", "getPpsKitVerCode ex: " + th.getClass().getSimpleName());
            }
        }
        if (numValueOf == null || 30462100 > numValueOf.intValue() || context == null || uri == null) {
            return false;
        }
        PackageManager packageManager2 = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager2.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            Log.e("StmUt", "verify provider invalid param");
            return false;
        }
        ApplicationInfo applicationInfo2 = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo2 == null) {
            return false;
        }
        String str2 = applicationInfo2.packageName;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return packageManager2.checkSignatures(context.getPackageName(), str2) == 0 || (applicationInfo2.flags & 1) == 1;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m718a(Context context) {
        if (context == null) {
            return "";
        }
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(f1447a, null, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("op_wk"));
                pk.a("InfoProviderUtil", " op_wk=" + string);
                yp.a(cursorQuery);
                return string;
            }
        } catch (Throwable th) {
            try {
                Log.w("InfoProviderUtil", "get remote key ex: " + th.getClass().getSimpleName());
            } finally {
                yp.a(cursorQuery);
            }
        }
        return "";
    }
}
