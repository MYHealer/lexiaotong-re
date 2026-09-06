package com.fancy;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a6 {
    public static volatile String _a;
    public static volatile String _b;
    public static volatile String _c;
    public static volatile String _d;

    public static String _a() {
        if (!TextUtils.isEmpty(_a)) {
            return _a;
        }
        try {
            Context context = PtgAdSdk.getContext();
            if (context != null) {
                CharSequence charSequence = context.getApplicationInfo().nonLocalizedLabel;
                if (charSequence != null) {
                    _a = charSequence.toString();
                }
                if (TextUtils.isEmpty(_a)) {
                    PackageManager packageManager = context.getPackageManager();
                    _a = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
                }
            }
        } catch (Exception unused) {
        }
        return _a;
    }
}
