package com.hihonor.adsdk.base.download;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.android.app.PackageManagerEx;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q {
    private static final String hnadsa = "SysAPPHelper";
    private static final String hnadsb = "preload/app";
    private static final String hnadsc = "com." + com.hihonor.adsdk.base.j.m.hnadsa() + ".android.app.PackageManagerEx";

    private static boolean hnadsa(String str) {
        if (!com.hihonor.adsdk.base.j.j.hnadsr()) {
            return PackageManagerEx.scanInstallApk(str);
        }
        try {
            Class<?> cls = Class.forName(hnadsc);
            Boolean bool = (Boolean) cls.getDeclaredMethod("scanInstallApk", String.class).invoke(cls.newInstance(), str);
            if (bool != null) {
                return bool.booleanValue();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "error= " + e.getMessage(), new Object[0]);
        }
        return false;
    }

    public static boolean hnadsb(String str) {
        boolean z;
        String next;
        boolean zHnadsa;
        PackageInfo packageInfoHnadsb;
        try {
            Iterator<String> it = com.hihonor.adsdk.base.j.j.hnadsb().iterator();
            do {
                if (!it.hasNext()) {
                    next = "";
                    break;
                }
                next = it.next();
                packageInfoHnadsb = com.hihonor.adsdk.base.j.j.hnadsb(next);
                if (packageInfoHnadsb == null) {
                    com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "recoverSysApp but packageInfo is null by getPackageArchiveInfo", new Object[0]);
                    return false;
                }
            } while (!str.equals(packageInfoHnadsb.packageName));
            if (TextUtils.isEmpty(next)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "recoverSysApp appPath is empty!!!", new Object[0]);
                zHnadsa = false;
            } else {
                zHnadsa = hnadsa(next);
            }
            try {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "recoverSysApp, recoverSuccess: " + zHnadsa, new Object[0]);
                return zHnadsa;
            } catch (Throwable th) {
                z = zHnadsa;
                th = th;
                new x("", com.hihonor.adsdk.base.g.j.g.b.hnadsb(), ErrorCode.AD_RECOVER_SYS_APP_ERR, "recoverSysApp,fail.,Exception msg : " + th.getMessage() + "magicOs is " + com.hihonor.adsdk.base.j.j.hnadsg()).hnadse();
                com.hihonor.adsdk.common.b.b.hnadse(hnadsa, "recoverSysApp, fail : " + th.getMessage(), new Object[0]);
                return z;
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public static boolean hnadsa(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "checkInstalled: Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public static boolean hnadsa(Context context) {
        if (Objects.isNull(context)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkInstallType but context is null.", new Object[0]);
            return false;
        }
        try {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "checkInstallType but pkgName isEmpty.", new Object[0]);
                return false;
            }
            String str = context.getPackageManager().getApplicationInfo(packageName, 0).sourceDir;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "isRecoverableApp " + str.contains(hnadsb), new Object[0]);
            return str.contains(hnadsb);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "checkInstallType: Exception: " + e.getMessage(), new Object[0]);
            return false;
        }
    }
}
