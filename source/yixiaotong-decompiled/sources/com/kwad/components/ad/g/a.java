package com.kwad.components.ad.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.aa;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.i;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static AppPackageInfo a(PackageInfo packageInfo, PackageManager packageManager) {
        AppPackageInfo appPackageInfo = new AppPackageInfo();
        appPackageInfo.packageName = packageInfo.packageName;
        if (packageInfo.applicationInfo != null) {
            appPackageInfo.isSystemApp = a(packageInfo.applicationInfo) || b(packageInfo.applicationInfo);
        }
        appPackageInfo.versionName = packageInfo.versionName;
        appPackageInfo.firstInstallTime = packageInfo.firstInstallTime;
        appPackageInfo.lastUpdateTime = packageInfo.lastUpdateTime;
        if (packageManager != null && packageInfo.applicationInfo != null && au.aw(ServiceProvider.getContext(), packageInfo.packageName)) {
            try {
                appPackageInfo.appName = packageInfo.applicationInfo.loadLabel(packageManager).toString();
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
        return appPackageInfo;
    }

    public static void a(final Context context, final com.kwad.sdk.g.a<JSONArray> aVar) {
        i.execute(new bi() { // from class: com.kwad.components.ad.g.a.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                aVar.accept(a.c(a.P(context)));
            }
        });
    }

    public static JSONArray[] b(Context context, List<String> list) {
        JSONArray[] jSONArrayArr = new JSONArray[2];
        h hVar = (h) ServiceProvider.get(h.class);
        if (context == null || list == null || list.isEmpty() || hVar == null || !t.UK()) {
            return jSONArrayArr;
        }
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (String str : list) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = aa.getPackageInfo(context, str, 0);
                if (packageInfo != null) {
                    AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                    map.put(appPackageInfoA.packageName, appPackageInfoA);
                } else {
                    AppPackageInfo appPackageInfo = new AppPackageInfo();
                    appPackageInfo.packageName = str;
                    map2.put(appPackageInfo.packageName, appPackageInfo);
                }
            } catch (Exception unused) {
                AppPackageInfo appPackageInfo2 = new AppPackageInfo();
                appPackageInfo2.packageName = str;
                map2.put(appPackageInfo2.packageName, appPackageInfo2);
            }
        }
        jSONArrayArr[0] = c(map);
        jSONArrayArr[1] = c(map2);
        return jSONArrayArr;
    }

    private static Map<String, AppPackageInfo> c(Context context, List<String> list) {
        HashMap map = new HashMap();
        if (context != null && list != null) {
            for (String str : list) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    PackageInfo packageInfo = aa.getPackageInfo(context, str, 0);
                    if (packageInfo != null) {
                        AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                        map.put(appPackageInfoA.packageName, appPackageInfoA);
                    }
                } catch (Exception unused) {
                }
            }
        }
        return map;
    }

    public static Map<String, AppPackageInfo> P(Context context) {
        HashMap map = new HashMap();
        if (context == null) {
            return map;
        }
        PackageManager packageManager = context.getPackageManager();
        if (be.readInstalledPackagesDisable()) {
            try {
                List<String> devInstalledPackages = be.getDevInstalledPackages();
                if (devInstalledPackages != null && !devInstalledPackages.isEmpty()) {
                    Iterator it = new ArrayList(devInstalledPackages).iterator();
                    while (it.hasNext()) {
                        try {
                            PackageInfo packageInfo = aa.getPackageInfo(context, (String) it.next(), 0);
                            if (packageInfo != null) {
                                AppPackageInfo appPackageInfoA = a(packageInfo, packageManager);
                                appPackageInfoA.reportMethod = 3;
                                map.put(appPackageInfoA.packageName, appPackageInfoA);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Exception unused2) {
            }
            return map;
        }
        h hVar = (h) ServiceProvider.get(h.class);
        if (hVar != null && t.UK()) {
            try {
                List<String> listED = bt.eD(context);
                Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
                intent.addCategory("android.intent.category.LAUNCHER");
                for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 32)) {
                    if (resolveInfo != null && resolveInfo.activityInfo != null && !TextUtils.isEmpty(resolveInfo.activityInfo.packageName)) {
                        String str = resolveInfo.activityInfo.packageName;
                        if (listED != null && !listED.isEmpty()) {
                            listED.remove(str);
                        }
                        PackageInfo packageInfo2 = aa.getPackageInfo(context, str, 0);
                        if (packageInfo2 != null) {
                            AppPackageInfo appPackageInfoA2 = a(packageInfo2, packageManager);
                            appPackageInfoA2.reportMethod = 1;
                            map.put(appPackageInfoA2.packageName, appPackageInfoA2);
                        }
                    }
                }
                if (listED != null && !listED.isEmpty()) {
                    Iterator<String> it2 = listED.iterator();
                    while (it2.hasNext()) {
                        try {
                            PackageInfo packageInfo3 = aa.getPackageInfo(context, it2.next(), 0);
                            if (packageInfo3 != null) {
                                AppPackageInfo appPackageInfoA3 = a(packageInfo3, packageManager);
                                appPackageInfoA3.reportMethod = 2;
                                map.put(appPackageInfoA3.packageName, appPackageInfoA3);
                            }
                        } catch (Throwable unused3) {
                        }
                    }
                }
            } catch (Exception unused4) {
            }
            map.putAll(c(context, hVar.FL()));
        }
        return map;
    }

    public static JSONArray c(Map<String, AppPackageInfo> map) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                AppPackageInfo appPackageInfo = map.get(it.next());
                if (appPackageInfo != null && !TextUtils.isEmpty(appPackageInfo.packageName)) {
                    ac.a(jSONArray, a(appPackageInfo));
                }
            }
        } catch (Exception e) {
            c.printStackTraceOnly(e);
        }
        return jSONArray;
    }

    public static JSONObject a(AppPackageInfo appPackageInfo) {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, com.hihonor.adsdk.base.c.r1.hnadse, appPackageInfo.packageName);
        ac.putValue(jSONObject, "system_app", appPackageInfo.isSystemApp ? 1 : 0);
        ac.putValue(jSONObject, "appVersion", appPackageInfo.versionName);
        ac.putValue(jSONObject, "firstInstallTime", appPackageInfo.firstInstallTime);
        ac.putValue(jSONObject, "lastUpdateTime", appPackageInfo.lastUpdateTime);
        ac.putValue(jSONObject, "reportMethod", appPackageInfo.reportMethod);
        ac.putValue(jSONObject, "appName", appPackageInfo.appName);
        return jSONObject;
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }

    private static boolean b(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 128) != 0;
    }
}
