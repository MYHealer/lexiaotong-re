package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamic.DynamicModule;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3902a = "HiAdTools";

    public static int a(Context context) {
        StringBuilder sb;
        Object obj;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(aa.b(context), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("ppskit_ver_code")) == null) {
                return 0;
            }
            String string = obj.toString();
            af.a(f3902a, "ppsKitVerCode: ".concat(String.valueOf(string)));
            return f.a(string);
        } catch (RuntimeException e) {
            e = e;
            sb = new StringBuilder("getPpsKitVerCode runtime ex: ");
            af.b(f3902a, sb.append(e.getClass().getSimpleName()).toString());
            return 0;
        } catch (Throwable th) {
            e = th;
            sb = new StringBuilder("getPpsKitVerCode ex: ");
            af.b(f3902a, sb.append(e.getClass().getSimpleName()).toString());
            return 0;
        }
    }

    private static boolean a(Context context, Uri uri) {
        if (context == null || uri == null) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(uri.getAuthority(), 0);
        if (providerInfoResolveContentProvider == null) {
            af.d(f3902a, "Invalid param");
            return false;
        }
        ApplicationInfo applicationInfo = providerInfoResolveContentProvider.applicationInfo;
        if (applicationInfo == null) {
            return false;
        }
        String str = applicationInfo.packageName;
        af.b(f3902a, "Target provider service's package name is : ".concat(String.valueOf(str)));
        if (str == null) {
            return false;
        }
        boolean z = true;
        if (packageManager.checkSignatures(context.getPackageName(), str) != 0 && (applicationInfo.flags & 1) != 1) {
            z = false;
        }
        if (!z) {
            String strB = aa.b(context, str);
            boolean zIsEmpty = TextUtils.isEmpty(strB);
            af.b(f3902a, "is sign empty: ".concat(String.valueOf(zIsEmpty)));
            if (!zIsEmpty) {
                if (DynamicModule.getCommonInter() != null) {
                    return DynamicModule.getCommonInter().isTrustApp(str, strB);
                }
                af.d("LoaderHandler", "DynamicModule.commonInter is null");
                return false;
            }
        }
        return z;
    }
}
