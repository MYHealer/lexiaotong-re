package com.huawei.hms.ads.uiengineloader;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class t implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3914a = "ads_HMSLoadStrategy";
    private static final String b = "content://com.huawei.hms";
    private static final String c = "huawei_module_dynamicloader";
    private static final String d = "errcode";
    private static final String e = "loader_version";
    private static final int f = 0;
    private static final int g = 1;
    private static final int h = 6;
    private static HashMap<String, Bundle> i = new HashMap<>();

    /* JADX INFO: renamed from: com.huawei.hms.ads.uiengineloader.t$1, reason: invalid class name */
    static class AnonymousClass1 extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f3915a;
        final /* synthetic */ String b;
        final /* synthetic */ int c = 0;

        AnonymousClass1(Context context, String str) {
            this.f3915a = context;
            this.b = str;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            t.a(this.f3915a, this.b, this.c);
        }
    }

    public static int a(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        Bundle bundle;
        if (i.containsKey(str) && (bundle = i.get(str)) != null) {
            af.b(f3914a, "cachedModuleInfo containsKey, version: " + bundle.getInt("module_version"));
            return bundle.getInt("module_version");
        }
        Bundle bundleC = c(context, str);
        if (bundleC == null) {
            af.c(f3914a, "Query module bundle info failed: null.");
            return 0;
        }
        if (bundleC.getInt("errcode") != 0) {
            return 0;
        }
        return bundleC.getInt("module_version");
    }

    private static void a(Context context, y yVar, Bundle bundle) {
        try {
            if (Build.VERSION.SDK_INT < 31) {
                new AnonymousClass1(context, yVar.f3921a).start();
                return;
            }
            boolean zA = x.a(context, bundle);
            af.b(f3914a, "android s,  result:".concat(String.valueOf(zA)));
            if (zA) {
                yVar.b = bundle.getString("module_path");
            }
        } catch (Throwable th) {
            af.c(f3914a, "copyRemoteModule err:" + th.getClass().getSimpleName());
        }
    }

    public static void a(Context context, String str, int i2) {
        try {
            int iA = a(context, str);
            af.b(f3914a, "remoteVersion:" + iA + " localModuleVersion:" + i2);
            if (iA > i2) {
                try {
                    Bundle bundleC = c(context, str);
                    if (bundleC == null) {
                        af.c(f3914a, "query failed to get bundle info: null.");
                        return;
                    }
                    int i3 = bundleC.getInt("errcode");
                    if (i3 == 1) {
                        af.c(f3914a, "the query module:" + str + " is not existed in HMS.");
                        return;
                    }
                    if (i3 != 0) {
                        af.c(f3914a, "failed to get bundle info for " + str + ", errcode:" + i3);
                        return;
                    }
                    af.b(f3914a, "Ready to cp module.");
                    boolean zA = x.a(context, bundleC);
                    af.a(f3914a, "bundle info: errorCode:" + i3 + ", moduleName:" + str + ", moduleVersion:" + bundleC.getInt("module_version"));
                    af.b(f3914a, "cp remote version by module name:" + str + " ,result:" + zA);
                } catch (Throwable th) {
                    af.c(f3914a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
                }
            }
        } catch (Throwable th2) {
            af.c(f3914a, "cp error: " + th2.getLocalizedMessage());
        }
    }

    private static Context b(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader iDynamicLoaderAsInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
        if (iDynamicLoaderAsInterface == null) {
            af.c(f3914a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", yVar.f3921a);
        bundle.putString("loader_path", yVar.e);
        bundle.putInt("module_version", yVar.d);
        bundle.putString("loader_version_type", yVar.f);
        return w.a(context, yVar.f3921a, bundle, iDynamicLoaderAsInterface);
    }

    private static y b(Context context, String str) throws com.huawei.hms.ads.dynamicloader.j {
        y yVar = new y();
        try {
            Bundle bundleC = c(context, str);
            if (bundleC == null) {
                af.c(f3914a, "Failed to get bundle info: null.");
                return yVar;
            }
            int i2 = bundleC.getInt("errcode");
            if (i2 == 1) {
                af.c(f3914a, "The query module:" + str + " is not existed in HMS.");
                return yVar;
            }
            if (i2 != 0) {
                af.c(f3914a, "Failed to get bundle info for " + str + ", errcode:" + i2);
                throw new com.huawei.hms.ads.dynamicloader.j("Query module unavailable, maybe you need to download it.", bundleC);
            }
            yVar.f3921a = str;
            yVar.b = bundleC.getString("module_path");
            yVar.c = bundleC.getString("module_uri_path");
            yVar.d = bundleC.getInt("module_version");
            yVar.e = bundleC.getString("loader_path");
            yVar.g = bundleC.getInt("loader_version");
            yVar.h = bundleC.getInt("armeabiType");
            af.b(f3914a, "bundle info: errorCode:" + i2 + ", moduleName:" + str + ", moduleVersion:" + yVar.d);
            try {
                if (Build.VERSION.SDK_INT >= 31) {
                    boolean zA = x.a(context, bundleC);
                    af.b(f3914a, "android s,  result:".concat(String.valueOf(zA)));
                    if (zA) {
                        yVar.b = bundleC.getString("module_path");
                    }
                } else {
                    new AnonymousClass1(context, yVar.f3921a).start();
                }
            } catch (Throwable th) {
                af.c(f3914a, "copyRemoteModule err:" + th.getClass().getSimpleName());
            }
            af.b(f3914a, "Query remote version by module name:" + str + " success.");
            return yVar;
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception e3) {
            af.c(f3914a, "Failed to Query remote module version." + e3.getClass().getSimpleName());
        }
    }

    private static Bundle c(Context context, String str) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver == null) {
                af.c(f3914a, "Query remote version failed: null contentResolver.");
                return null;
            }
            Bundle bundleCall = contentResolver.call(Uri.parse("content://com.huawei.hms"), str, (String) null, (Bundle) null);
            if (bundleCall == null) {
                af.c(f3914a, "query module:" + str + " failed: null.");
                return null;
            }
            int i2 = bundleCall.getInt("errcode");
            if (i2 == 0) {
                i.put(str, bundleCall);
            }
            af.b(f3914a, "Query module info result code:".concat(String.valueOf(i2)));
            return bundleCall;
        } catch (Exception e2) {
            af.c(f3914a, "Query module:" + str + " info failed:" + e2.getMessage());
            return null;
        }
    }

    private static void d(Context context, String str) {
        new AnonymousClass1(context, str).start();
    }

    private static void e(Context context, String str) {
        try {
            Bundle bundleC = c(context, str);
            if (bundleC == null) {
                af.c(f3914a, "query failed to get bundle info: null.");
                return;
            }
            int i2 = bundleC.getInt("errcode");
            if (i2 == 1) {
                af.c(f3914a, "the query module:" + str + " is not existed in HMS.");
                return;
            }
            if (i2 != 0) {
                af.c(f3914a, "failed to get bundle info for " + str + ", errcode:" + i2);
                return;
            }
            af.b(f3914a, "Ready to cp module.");
            boolean zA = x.a(context, bundleC);
            af.a(f3914a, "bundle info: errorCode:" + i2 + ", moduleName:" + str + ", moduleVersion:" + bundleC.getInt("module_version"));
            af.b(f3914a, "cp remote version by module name:" + str + " ,result:" + zA);
        } catch (Throwable th) {
            af.c(f3914a, "Failed to cp remote hms module version." + th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final Context a(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        try {
            if (yVar.e.contains("huawei_module_dynamicloader")) {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", yVar.b);
                bundle.putString("module_name", yVar.f3921a);
                bundle.putInt("armeabiType", yVar.h);
                bundle.putString("loader_version_type", yVar.f);
                com.huawei.hms.ads.dynamicloader.h.a(context);
                return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
            }
            af.b(f3914a, "The loader is not dynamicLoader，use it to load.");
            IDynamicLoader iDynamicLoaderAsInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
            if (iDynamicLoaderAsInterface == null) {
                af.c(f3914a, "Get iDynamicLoader failed: null.");
                return null;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("module_name", yVar.f3921a);
            bundle2.putString("loader_path", yVar.e);
            bundle2.putInt("module_version", yVar.d);
            bundle2.putString("loader_version_type", yVar.f);
            return w.a(context, yVar.f3921a, bundle2, iDynamicLoaderAsInterface);
        } catch (com.huawei.hms.ads.dynamicloader.j e2) {
            throw e2;
        } catch (Exception unused) {
            af.d(f3914a, "Load DynamicModule failed.");
            Bundle bundle3 = new Bundle();
            bundle3.putInt("errcode", 6);
            throw new com.huawei.hms.ads.dynamicloader.j("load HMS dynamic module failed.", bundle3);
        }
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final y a(Context context, String str, String str2) throws com.huawei.hms.ads.dynamicloader.j {
        return b(context, str);
    }
}
