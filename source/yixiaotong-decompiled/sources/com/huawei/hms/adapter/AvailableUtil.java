package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AvailableUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f3797a = new Object();
    public static boolean b;
    public static boolean c;

    public static boolean isInstallerLibExist(Context context) {
        Object obj;
        boolean z;
        if (b) {
            HMSLog.i("AvailableUtil", "installerInit exist: " + c);
            return c;
        }
        synchronized (f3797a) {
            if (!b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                        z = false;
                    }
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("availableHMSCoreInstaller")) == null || !String.valueOf(obj).equalsIgnoreCase("yes")) {
                            z = false;
                        } else {
                            HMSLog.i("AvailableUtil", "available exist: true");
                            z = true;
                        }
                    } catch (PackageManager.NameNotFoundException unused2) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                    } catch (RuntimeException e) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e);
                    }
                }
                c = z;
                b = true;
            }
        }
        HMSLog.i("AvailableUtil", "available exist: " + c);
        return c;
    }
}
