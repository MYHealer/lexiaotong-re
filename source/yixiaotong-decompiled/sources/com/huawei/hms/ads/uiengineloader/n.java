package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class n implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3909a = "PathClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.j
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        af.b(f3909a, "begin to new classloader, armeabiType:".concat(String.valueOf(i)));
        return new com.huawei.hms.ads.dynamicloader.d(i.a(context, str, packageInfo), i.b(context, str, packageInfo), context.getClassLoader());
    }
}
