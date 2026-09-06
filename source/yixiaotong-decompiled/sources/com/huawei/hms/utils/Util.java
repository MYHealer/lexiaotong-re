package com.huawei.hms.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AndroidException;
import com.huawei.hms.android.SystemUtils;
import com.huawei.hms.common.PackageConstants;
import com.huawei.hms.common.util.AGCUtils;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Util {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f4429a;
    private static boolean b;
    private static final Object c = new Object();
    private static String d;

    public static int compareHmsVersion(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (TextUtils.isEmpty(str2)) {
            return 1;
        }
        if (StringUtil.checkVersion(str) && StringUtil.checkVersion(str2)) {
            String[] strArrSplit = str.split("\\.");
            String[] strArrSplit2 = str2.split("\\.");
            if (2 < strArrSplit.length && 2 < strArrSplit2.length) {
                if (Integer.parseInt(strArrSplit[0]) > Integer.parseInt(strArrSplit2[0])) {
                    return 1;
                }
                if (Integer.parseInt(strArrSplit[0]) < Integer.parseInt(strArrSplit2[0])) {
                    return -1;
                }
                if (Integer.parseInt(strArrSplit[1]) > Integer.parseInt(strArrSplit2[1])) {
                    return 1;
                }
                if (Integer.parseInt(strArrSplit[1]) < Integer.parseInt(strArrSplit2[1])) {
                    return -1;
                }
                if (Integer.parseInt(strArrSplit[2]) > Integer.parseInt(strArrSplit2[2])) {
                    return 1;
                }
                if (Integer.parseInt(strArrSplit[2]) < Integer.parseInt(strArrSplit2[2])) {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static Activity getActiveActivity(Activity activity, Context context) {
        return UIUtil.getActiveActivity(activity, context);
    }

    public static String getAppId(Context context) {
        return AGCUtils.getAppId(context);
    }

    public static String getAppName(Context context, String str) {
        if (context == null) {
            HMSLog.e("Util", "In getAppName, context is null.");
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getAppName, Failed to get 'PackageManager' instance.");
            return "";
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = context.getPackageName();
            }
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 128));
            return applicationLabel == null ? "" : applicationLabel.toString();
        } catch (Resources.NotFoundException | AndroidException unused) {
            HMSLog.e("Util", "In getAppName, Failed to get app name.");
            return "";
        }
    }

    public static String getCpId(Context context) {
        return AGCUtils.getCpId(context);
    }

    public static int getHmsVersion(Context context) {
        Object obj;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            HMSLog.e("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
            return 0;
        }
        try {
            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
            if (applicationInfo != null && applicationInfo.metaData != null && (obj = applicationInfo.metaData.get("com.huawei.hms.version")) != null) {
                String strValueOf = String.valueOf(obj);
                if (!TextUtils.isEmpty(strValueOf)) {
                    return StringUtil.convertVersion2Integer(strValueOf);
                }
            }
            HMSLog.i("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (AndroidException unused) {
            HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
            return 0;
        } catch (RuntimeException e) {
            HMSLog.e("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.", e);
            return 0;
        }
    }

    public static String getNetType(Context context) {
        return SystemUtils.getNetType(context);
    }

    public static String getProcessName(Context context, int i) {
        return UIUtil.getProcessName(context, i);
    }

    @Deprecated
    public static String getProductCountry() {
        int iLastIndexOf;
        String systemProperties = getSystemProperties(CountryCodeBean.LOCALE_COUNTRYSYSTEMPROP, "");
        if (!TextUtils.isEmpty(systemProperties)) {
            return systemProperties;
        }
        String systemProperties2 = getSystemProperties("ro.product.locale", "");
        if (!TextUtils.isEmpty(systemProperties2) && (iLastIndexOf = systemProperties2.lastIndexOf(x.A)) != -1) {
            return systemProperties2.substring(iLastIndexOf + 1);
        }
        String localCountry = SystemUtils.getLocalCountry();
        return !TextUtils.isEmpty(localCountry) ? localCountry : "";
    }

    public static String getSystemProperties(String str, String str2) {
        return SystemUtils.getSystemProperties(str, str2);
    }

    public static Activity getValidActivity(Activity activity, Activity activity2) {
        if (activity != null && !activity.isFinishing()) {
            return activity;
        }
        if (activity2 == null || activity2.isFinishing()) {
            return null;
        }
        return activity2;
    }

    public static boolean isAvailableLibExist(Context context) {
        Object obj;
        boolean z;
        synchronized (c) {
            if (!f4429a) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("Util", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.adapter.AvailableAdapter");
                        z = true;
                    } catch (ClassNotFoundException unused) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to find class AvailableAdapter.");
                        z = false;
                    }
                } else {
                    try {
                        try {
                            ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                            if (applicationInfo == null || applicationInfo.metaData == null || (obj = applicationInfo.metaData.get("availableLoaded")) == null || !String.valueOf(obj).equalsIgnoreCase("yes")) {
                                z = false;
                            } else {
                                HMSLog.i("Util", "available exist: true");
                                z = true;
                            }
                        } catch (RuntimeException e) {
                            HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.", e);
                        }
                    } catch (AndroidException unused2) {
                        HMSLog.e("Util", "In isAvailableLibExist, Failed to read meta data for the availableLoaded.");
                    }
                }
                b = z;
                f4429a = true;
            }
        }
        HMSLog.i("Util", "available exist: " + b);
        return b;
    }

    public static boolean isChinaROM() {
        return SystemUtils.isChinaROM();
    }

    public static boolean isEMUI() {
        return SystemUtils.isEMUI();
    }

    public static void unBindServiceCatchException(Context context, ServiceConnection serviceConnection) {
        try {
            HMSLog.i("Util", "Trying to unbind service from " + serviceConnection);
            context.unbindService(serviceConnection);
        } catch (Exception e) {
            HMSLog.e("Util", "On unBindServiceException:" + e.getMessage());
        }
    }

    public static String getServiceActionMetadata(Context context) {
        String str = d;
        if (str != null) {
            return str;
        }
        Intent intent = new Intent(PackageConstants.INTERNAL_SERVICES_ACTION);
        intent.setPackage(context.getPackageName());
        if (context.getPackageManager().resolveService(intent, 128) != null) {
            d = PackageConstants.INTERNAL_SERVICES_ACTION;
            return PackageConstants.INTERNAL_SERVICES_ACTION;
        }
        d = "";
        return "";
    }
}
