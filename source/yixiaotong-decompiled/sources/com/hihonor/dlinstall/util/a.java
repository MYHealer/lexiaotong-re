package com.hihonor.dlinstall.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.hihonor.dlinstall.ability.syncapp.AdAppReport;
import com.hihonor.dlinstall.data.PackageInfoResult;
import com.stub.StubApp;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f3611a;

    public static PackageInfoResult a(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            PackageInfo packageInfo = origApplicationContext.getPackageManager().getPackageInfo(origApplicationContext.getPackageName(), 0);
            String string = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            PackageInfoResult packageInfoResult = new PackageInfoResult();
            packageInfoResult.setCallerAppName(string);
            packageInfoResult.setCallerAppVer(packageInfo.versionCode);
            return packageInfoResult;
        } catch (Exception e) {
            com.hihonor.dlinstall.page.a.b("AppUtil", "getAppName: e is " + e.getMessage());
            return null;
        }
    }

    public static String a(Context context, String str, int i) {
        String string = f3611a;
        if (TextUtils.isEmpty(string)) {
            if (com.hihonor.dlinstall.page.a.f3610a == null) {
                com.hihonor.dlinstall.page.a.f3610a = context.getSharedPreferences("download_install_cache", 0);
            }
            SharedPreferences sharedPreferences = com.hihonor.dlinstall.page.a.f3610a;
            string = sharedPreferences == null ? "" : sharedPreferences.getString("KYE_UUID", "");
            if (!TextUtils.isEmpty(string)) {
                string = UUID.randomUUID().toString();
                if (com.hihonor.dlinstall.page.a.f3610a == null) {
                    com.hihonor.dlinstall.page.a.f3610a = context.getSharedPreferences("download_install_cache", 0);
                }
                SharedPreferences sharedPreferences2 = com.hihonor.dlinstall.page.a.f3610a;
                if (sharedPreferences2 != null) {
                    SharedPreferences.Editor editorEdit = sharedPreferences2.edit();
                    editorEdit.putString("KYE_UUID", string);
                    editorEdit.apply();
                }
                f3611a = string;
            }
        }
        return string + "_" + str + "_" + i + "_" + System.currentTimeMillis();
    }

    public static boolean a(AdAppReport adAppReport) {
        if (adAppReport == null) {
            return false;
        }
        com.hihonor.dlinstall.page.a.c("VersionUtil", "isAdApp: adAppReport data: " + adAppReport.toString());
        String adId = adAppReport.getAdId();
        return adId != null && adId.length() > 0;
    }

    public static boolean b(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo("com.hihonor.appmarket", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
