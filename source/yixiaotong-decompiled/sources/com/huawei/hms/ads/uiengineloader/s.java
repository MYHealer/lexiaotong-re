package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.IDynamicLoader;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class s implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3913a = "DecompressedLdStrategy";
    private static final String b = "loader";
    private static final String c = "com.huawei.hms.kit.type";
    private static final String d = "armeabi_type";

    public static y a(Context context, String str) {
        File file = new File(ad.a(context) + File.separator + "dynamic_modules" + File.separator + str);
        return file.exists() ? a(file, str) : new y();
    }

    private static y a(File file, String str) {
        String[] list = file.list();
        y yVar = new y();
        if (list == null || list.length == 0) {
            af.c(f3913a, "No version in module path.");
            return yVar;
        }
        int i = 0;
        for (String str2 : list) {
            if (Integer.parseInt(str2) > i) {
                i = Integer.parseInt(str2);
            }
        }
        if (i == 0) {
            af.c(f3913a, "Cannot get module version path.");
            return yVar;
        }
        w.a(i, ad.a(file), list, f3913a);
        File file2 = new File(ad.a(file) + File.separator + i + File.separator + str + ".apk");
        if (!file2.exists()) {
            af.c(f3913a, "Cannot find module apk int local path.");
            return yVar;
        }
        String strA = ad.a(file2);
        yVar.f3921a = str;
        yVar.b = strA;
        yVar.d = i;
        af.b(f3913a, "Get module info from decompressed asset path success: ModuleName:" + str + ", ModuleVersion:" + i);
        return yVar;
    }

    private static String a(Context context, String str, Bundle bundle) {
        String str2;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 128);
        String string = null;
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            str2 = "The packageInfo is null.";
        } else {
            Bundle bundle2 = packageArchiveInfo.applicationInfo.metaData;
            if (bundle2 == null) {
                str2 = "Get meta-data failed.";
            } else {
                try {
                    for (String str3 : bundle2.keySet()) {
                        if (str3.startsWith(c)) {
                            string = bundle2.getString(str3);
                        }
                        if (str3.startsWith(d)) {
                            int i = bundle2.getInt(str3);
                            af.b(f3913a, "The module defined the armeabiType:".concat(String.valueOf(i)));
                            bundle.putInt("armeabiType", i);
                        }
                    }
                    af.c(f3913a, "The moduleType is:".concat(String.valueOf(string)));
                    return string;
                } catch (Throwable th) {
                    str2 = "getModuleMetaInfo err: " + th.getClass().getSimpleName();
                }
            }
        }
        af.c(f3913a, str2);
        return string;
    }

    private static Context b(Context context, y yVar) throws com.huawei.hms.ads.dynamicloader.j {
        IDynamicLoader iDynamicLoaderAsInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
        if (iDynamicLoaderAsInterface == null) {
            af.c(f3913a, "Get iDynamicLoader failed: null.");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("module_name", yVar.f3921a);
        bundle.putString("loader_path", yVar.e);
        bundle.putInt("module_version", yVar.d);
        bundle.putString("loader_version_type", yVar.f);
        return w.a(context, yVar.f3921a, bundle, iDynamicLoaderAsInterface);
    }

    private static y b(Context context, String str, String str2) {
        y yVar = new y();
        if (context == null || TextUtils.isEmpty(str)) {
            af.c(f3913a, "The context or moduleName is null.");
            return yVar;
        }
        try {
            yVar = a(context, str);
            if (yVar.d > 0) {
                af.b(f3913a, "Successfully get module info from decompressed asset path.");
                v.a(context, str, yVar.d, str2);
                return yVar;
            }
        } catch (Exception e) {
            af.b(f3913a, "getDataModuleInfo failed." + e.getClass().getSimpleName());
        }
        return yVar;
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final Context a(Context context, y yVar) {
        String str;
        if (yVar == null) {
            str = "moduleInfo is null.";
        } else {
            String str2 = yVar.b;
            if (TextUtils.isEmpty(str2)) {
                str = "modulePath is invalid.";
            } else {
                Bundle bundle = new Bundle();
                bundle.putString("module_path", str2);
                bundle.putString("loader_version_type", yVar.f);
                bundle.putString("module_name", yVar.f3921a);
                af.b(f3913a, "loaderVersionType is : " + yVar.f);
                try {
                    if (!TextUtils.equals(a(context, str2, bundle), b)) {
                        com.huawei.hms.ads.dynamicloader.h.a(context);
                        return com.huawei.hms.ads.dynamicloader.h.a(context, bundle);
                    }
                    af.b(f3913a, "The module is a loader, use it to load first.");
                    yVar.e = str2;
                    IDynamicLoader iDynamicLoaderAsInterface = IDynamicLoader.Stub.asInterface(w.a(context, yVar.e));
                    if (iDynamicLoaderAsInterface == null) {
                        af.c(f3913a, "Get iDynamicLoader failed: null.");
                        return null;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("module_name", yVar.f3921a);
                    bundle2.putString("loader_path", yVar.e);
                    bundle2.putInt("module_version", yVar.d);
                    bundle2.putString("loader_version_type", yVar.f);
                    return w.a(context, yVar.f3921a, bundle2, iDynamicLoaderAsInterface);
                } catch (Exception e) {
                    str = "Get local assets module context failed, " + e.getClass().getSimpleName();
                }
            }
        }
        af.c(f3913a, str);
        return null;
    }

    @Override // com.huawei.hms.ads.uiengineloader.u
    public final y a(Context context, String str, String str2) {
        return b(context, str, str2);
    }
}
