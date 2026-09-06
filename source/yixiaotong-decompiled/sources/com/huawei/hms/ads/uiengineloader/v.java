package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.DynamicModule;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3916a = "ads_KitLoadStrategy";
    private static final String b = "content://com.huawei.hwid.pps.apiprovider/check_uiengine";
    private static final int c = 30472100;
    private static final byte[] d = new byte[0];

    /* JADX WARN: Code duplicated, block: B:27:0x0077 A[DONT_INVERT, PHI: r3
  0x0077: PHI (r3v7 boolean) = (r3v6 boolean), (r3v6 boolean), (r3v11 boolean) binds: [B:20:0x0047, B:22:0x005e, B:25:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:28:0x0079 A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:3:0x0005, B:6:0x000d, B:9:0x001e, B:11:0x0022, B:13:0x0033, B:15:0x003e, B:21:0x0049, B:23:0x0060, B:25:0x0066, B:26:0x006f, B:28:0x0079, B:30:0x00a0, B:32:0x00aa, B:33:0x00b1, B:34:0x00b2, B:35:0x00b7, B:36:0x00be), top: B:40:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x00a0 A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:3:0x0005, B:6:0x000d, B:9:0x001e, B:11:0x0022, B:13:0x0033, B:15:0x003e, B:21:0x0049, B:23:0x0060, B:25:0x0066, B:26:0x006f, B:28:0x0079, B:30:0x00a0, B:32:0x00aa, B:33:0x00b1, B:34:0x00b2, B:35:0x00b7, B:36:0x00be), top: B:40:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00aa A[Catch: Exception -> 0x00bf, TryCatch #0 {Exception -> 0x00bf, blocks: (B:3:0x0005, B:6:0x000d, B:9:0x001e, B:11:0x0022, B:13:0x0033, B:15:0x003e, B:21:0x0049, B:23:0x0060, B:25:0x0066, B:26:0x006f, B:28:0x0079, B:30:0x00a0, B:32:0x00aa, B:33:0x00b1, B:34:0x00b2, B:35:0x00b7, B:36:0x00be), top: B:40:0x0005 }] */
    private static Bundle a(Context context, String str, int i) throws com.huawei.hms.ads.dynamicloader.j {
        Cursor cursorQuery;
        try {
            Uri uri = Uri.parse(b);
            if (context != null && uri != null) {
                PackageManager packageManager = context.getPackageManager();
                ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
                if (providerInfoResolveContentProvider != null) {
                    ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
                    if (applicationInfo != null) {
                        String str2 = applicationInfo.packageName;
                        af.b("HiAdTools", "Target provider service's package name is : ".concat(String.valueOf(str2)));
                        if (str2 != null) {
                            boolean zIsTrustApp = packageManager.checkSignatures(context.getPackageName(), str2) == 0 || (applicationInfo.flags & 1) == 1;
                            if (!zIsTrustApp) {
                                String strB = aa.b(context, str2);
                                boolean zIsEmpty = TextUtils.isEmpty(strB);
                                af.b("HiAdTools", "is sign empty: ".concat(String.valueOf(zIsEmpty)));
                                if (zIsEmpty) {
                                    if (zIsTrustApp) {
                                        JSONObject jSONObject = new JSONObject();
                                        jSONObject.put(com.huawei.openalliance.ad.constant.w.aC, i);
                                        cursorQuery = context.getContentResolver().query(Uri.parse(b), null, str, new String[]{jSONObject.toString()}, "");
                                        if (cursorQuery == null) {
                                            throw new com.huawei.hms.ads.dynamicloader.j("query ret is null");
                                        }
                                        af.b(f3916a, "query success.");
                                        return cursorQuery.getExtras();
                                    }
                                } else if (DynamicModule.getCommonInter() != null) {
                                    zIsTrustApp = DynamicModule.getCommonInter().isTrustApp(str2, strB);
                                    if (zIsTrustApp) {
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put(com.huawei.openalliance.ad.constant.w.aC, i);
                                        cursorQuery = context.getContentResolver().query(Uri.parse(b), null, str, new String[]{jSONObject2.toString()}, "");
                                        if (cursorQuery == null) {
                                            throw new com.huawei.hms.ads.dynamicloader.j("query ret is null");
                                        }
                                        af.b(f3916a, "query success.");
                                        return cursorQuery.getExtras();
                                    }
                                } else {
                                    af.d("LoaderHandler", "DynamicModule.commonInter is null");
                                }
                            } else if (zIsTrustApp) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(com.huawei.openalliance.ad.constant.w.aC, i);
                                cursorQuery = context.getContentResolver().query(Uri.parse(b), null, str, new String[]{jSONObject3.toString()}, "");
                                if (cursorQuery == null) {
                                    throw new com.huawei.hms.ads.dynamicloader.j("query ret is null");
                                }
                                af.b(f3916a, "query success.");
                                return cursorQuery.getExtras();
                            }
                        }
                    }
                } else {
                    af.d("HiAdTools", "Invalid param");
                }
            }
            throw new com.huawei.hms.ads.dynamicloader.j("apiProvider uri is invalid");
        } catch (Exception e) {
            af.c(f3916a, "Failed to call checkNewModule: " + e.getMessage());
            throw new com.huawei.hms.ads.dynamicloader.j("call PPSKit checkNewModule error");
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.huawei.hms.ads.uiengineloader.v$1] */
    public static void a(final Context context, final String str, final int i, final String str2) {
        new Thread() { // from class: com.huawei.hms.ads.uiengineloader.v.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                if (e.a(context) < v.c) {
                    af.b(v.f3916a, "PPSKit is below need version");
                    t.a(context, str, i);
                    return;
                }
                String str3 = str2;
                if (DynamicModule.getSpHandler() == null) {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                } else if (DynamicModule.getSpHandler().getLoaderEngineUpdate(str3)) {
                    v.b(context, str, i, str2);
                    return;
                }
                af.b(v.f3916a, "engineUpdate is close");
                t.a(context, str, i);
            }
        }.start();
    }

    static /* synthetic */ void b(Context context, String str, int i, String str2) {
        int loaderEngin2KitUpdate;
        long kitloaderLastCheckTime;
        int loaderEngineInterval;
        try {
            af.b(f3916a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                loaderEngin2KitUpdate = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                loaderEngin2KitUpdate = 60000;
            }
            af.a(f3916a, "interval: ".concat(String.valueOf(loaderEngin2KitUpdate)));
            synchronized (d) {
                if (DynamicModule.getSpHandler() != null) {
                    kitloaderLastCheckTime = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    kitloaderLastCheckTime = 0;
                }
                af.a(f3916a, "lastCheckTime: ".concat(String.valueOf(kitloaderLastCheckTime)));
                if (kitloaderLastCheckTime <= 0 || System.currentTimeMillis() - kitloaderLastCheckTime >= loaderEngin2KitUpdate) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (DynamicModule.getSpHandler() != null) {
                        DynamicModule.getSpHandler().setKitloaderLastCheckTime(jCurrentTimeMillis);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    }
                    if (DynamicModule.getSpHandler() != null) {
                        loaderEngineInterval = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                        loaderEngineInterval = 10080000;
                    }
                    af.a(f3916a, "engineInterval: ".concat(String.valueOf(loaderEngineInterval)));
                    c.a(2, Integer.valueOf(i), null);
                    Bundle bundleA = a(context, str, loaderEngineInterval);
                    Integer numValueOf = Integer.valueOf(bundleA.getInt("module_version"));
                    if (numValueOf.intValue() == 0) {
                        af.c(f3916a, "the query module:" + str + " is not existed in PPSKit.");
                        af.c(f3916a, "start call HMSLoadStrategy");
                        t.a(context, str, i);
                    } else {
                        if (i >= numValueOf.intValue()) {
                            af.b(f3916a, "no update,localVersion: " + i + " reomoteVersion: " + numValueOf);
                            return;
                        }
                        c.a(3, Integer.valueOf(i), numValueOf);
                        af.b(f3916a, "Ready to cp module.");
                        boolean zA = x.a(context, bundleA);
                        af.b(f3916a, "cp remote version by module name:" + str + " ,result:" + zA);
                        if (!zA) {
                            throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                        }
                        c.a(4, Integer.valueOf(i), numValueOf);
                        af.a(f3916a, "bundle info: moduleName:" + str + ", moduleVersion:" + numValueOf);
                        af.b(f3916a, "end queryModule: ".concat(String.valueOf(str)));
                    }
                }
            }
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f3916a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f3916a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
    }

    private static void c(Context context, String str, int i, String str2) {
        int loaderEngin2KitUpdate;
        long kitloaderLastCheckTime;
        int loaderEngineInterval;
        try {
            af.b(f3916a, "start queryModule: ".concat(String.valueOf(str)));
            c.a(1, Integer.valueOf(i), null);
            if (DynamicModule.getSpHandler() != null) {
                loaderEngin2KitUpdate = DynamicModule.getSpHandler().getLoaderEngin2KitUpdate(str2);
            } else {
                af.d("LoaderHandler", "DynamicModule.spHandler is null");
                loaderEngin2KitUpdate = 60000;
            }
            af.a(f3916a, "interval: ".concat(String.valueOf(loaderEngin2KitUpdate)));
            synchronized (d) {
                if (DynamicModule.getSpHandler() != null) {
                    kitloaderLastCheckTime = DynamicModule.getSpHandler().getKitloaderLastCheckTime();
                } else {
                    af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    kitloaderLastCheckTime = 0;
                }
                af.a(f3916a, "lastCheckTime: ".concat(String.valueOf(kitloaderLastCheckTime)));
                if (kitloaderLastCheckTime <= 0 || System.currentTimeMillis() - kitloaderLastCheckTime >= loaderEngin2KitUpdate) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (DynamicModule.getSpHandler() != null) {
                        DynamicModule.getSpHandler().setKitloaderLastCheckTime(jCurrentTimeMillis);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                    }
                    if (DynamicModule.getSpHandler() != null) {
                        loaderEngineInterval = DynamicModule.getSpHandler().getLoaderEngineInterval(str2);
                    } else {
                        af.d("LoaderHandler", "DynamicModule.spHandler is null");
                        loaderEngineInterval = 10080000;
                    }
                    af.a(f3916a, "engineInterval: ".concat(String.valueOf(loaderEngineInterval)));
                    c.a(2, Integer.valueOf(i), null);
                    Bundle bundleA = a(context, str, loaderEngineInterval);
                    Integer numValueOf = Integer.valueOf(bundleA.getInt("module_version"));
                    if (numValueOf.intValue() == 0) {
                        af.c(f3916a, "the query module:" + str + " is not existed in PPSKit.");
                        af.c(f3916a, "start call HMSLoadStrategy");
                        t.a(context, str, i);
                    } else {
                        if (i >= numValueOf.intValue()) {
                            af.b(f3916a, "no update,localVersion: " + i + " reomoteVersion: " + numValueOf);
                            return;
                        }
                        c.a(3, Integer.valueOf(i), numValueOf);
                        af.b(f3916a, "Ready to cp module.");
                        boolean zA = x.a(context, bundleA);
                        af.b(f3916a, "cp remote version by module name:" + str + " ,result:" + zA);
                        if (!zA) {
                            throw new com.huawei.hms.ads.dynamicloader.j("KitLoadStrategy copy module error");
                        }
                        c.a(4, Integer.valueOf(i), numValueOf);
                        af.a(f3916a, "bundle info: moduleName:" + str + ", moduleVersion:" + numValueOf);
                        af.b(f3916a, "end queryModule: ".concat(String.valueOf(str)));
                    }
                }
            }
        } catch (Throwable th) {
            c.a(5, Integer.valueOf(i), null);
            af.c(f3916a, "checkRemoteVersion error: " + th.getMessage());
            af.c(f3916a, "start call HMSLoadStrategy");
            t.a(context, str, i);
        }
    }
}
