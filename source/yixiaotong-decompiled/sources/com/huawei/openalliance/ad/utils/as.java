package com.huawei.openalliance.ad.utils;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Process;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class as {
    public static final int Code = -2;
    private static final String V = "PermissionUtil";

    private static int Code(Context context, String str, String str2, int i, int i2) {
        String strPermissionToOp;
        try {
            if (-1 == context.checkPermission(str, i, i2)) {
                return -1;
            }
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((applicationInfo != null && applicationInfo.targetSdkVersion > 23) || (strPermissionToOp = AppOpsManager.permissionToOp(str)) == null) {
                return 0;
            }
            if (TextUtils.isEmpty(str2)) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
                if (ag.Code(packagesForUid)) {
                    return -1;
                }
                str2 = packagesForUid[0];
            }
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(strPermissionToOp, str2) != 0 ? -2 : 0;
        } catch (Throwable th) {
            fh.I(V, "validatePermission " + th.getClass().getSimpleName());
            return -1;
        }
    }

    public static boolean Code(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            return Code(context, str, context.getPackageName(), Process.myPid(), Process.myUid()) == 0;
        }
        fh.V(V, "hasPermission Invalid Input Param");
        return false;
    }
}
