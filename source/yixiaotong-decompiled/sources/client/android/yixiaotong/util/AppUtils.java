package client.android.yixiaotong.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.XOrUtils;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import client.android.yixiaotong.v3.comman.V3DeviceComman;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppUtils {
    private static final String TAG = "AppUtils";

    public static void getMemory(Context context) {
        System.out.println("memory: " + ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryClass());
        float fMaxMemory = (float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d);
        float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
        float fFreeMemory = (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
        System.out.println("maxMemory: " + fMaxMemory);
        System.out.println("totalMemory: " + f);
        System.out.println("freeMemory: " + fFreeMemory);
    }

    public static String getVersion(Context context) {
        String appVersion = LocalDataUtil.getAppVersion(context);
        if (StringUtils.isNotEmpty(appVersion)) {
            return appVersion;
        }
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 64).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "获取版本App失败";
        }
    }

    public static String getSystemModel() {
        return Build.MODEL;
    }

    public static String getSystemVersion() {
        return Build.VERSION.RELEASE;
    }

    public static boolean isInstallAppAvilible(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkAliPayInstalled(Context context) {
        return new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startApp")).resolveActivity(context.getPackageManager()) != null;
    }

    public static boolean isWeixinAvilible(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isChinaBankAvilible(Context context) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        if (installedPackages != null) {
            for (int i = 0; i < installedPackages.size(); i++) {
                if (installedPackages.get(i).packageName.equals("com.chinamworld.bocmbci")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String getAndroidId(Context context) {
        String androidId = LocalDataUtil.getAndroidId(context);
        if (StringUtils.isNotEmpty(androidId)) {
            return androidId;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        LogUtil.e(TAG, "getAndroidId:" + string);
        if (!StringUtils.isNotEmpty(string)) {
            return "unknow";
        }
        LocalDataUtil.saveAndroidId(context, string);
        return string;
    }

    public static String getUUid(Context context) {
        String uuid = LocalDataUtil.getUuid(context);
        LogUtil.e(TAG, "uuid:" + uuid);
        if (StringUtils.isNotEmpty(uuid)) {
            return uuid;
        }
        String strReplace = UUID.randomUUID().toString().replace(x.A, "");
        LogUtil.e(TAG, "uuid2:" + strReplace);
        if (!StringUtils.isNotEmpty(strReplace)) {
            return "unknow";
        }
        LocalDataUtil.saveUuid(context, strReplace);
        return strReplace;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    public static boolean isUserHuaWeiScan() {
        String systemModel = getSystemModel();
        Log.e("test", "型号:" + systemModel);
        if (!StringUtils.isNotEmpty(systemModel)) {
            return true;
        }
        String strReplace = systemModel.toLowerCase().replace(PPSLabelView.Code, "");
        return ((strReplace.contains("vivo") && strReplace.contains("y93")) || strReplace.contains("v1818") || strReplace.replace(PPSLabelView.Code, "").contains("oppoa72") || strReplace.replace(PPSLabelView.Code, "").contains("mi11ultra")) ? false : true;
    }

    public static String getUuid(long j) {
        return UUID.nameUUIDFromBytes(String.valueOf(j).getBytes()).toString().replace(x.A, "");
    }

    public static String getTraceId() {
        String lowerCase = RandomUtil.getRandNumMaxString(8).toLowerCase();
        String lowerCase2 = RandomUtil.getRandNumMaxString(8).toLowerCase();
        LocalDataUtil.saveTraceID(BaseApplication.app, lowerCase + lowerCase2);
        return lowerCase + lowerCase2;
    }

    public static String getSpanId() {
        String uuid = getUuid(0L);
        if (StringUtils.isNotEmpty(uuid) && uuid.length() >= 32) {
            return uuid.substring(16, 32).toLowerCase();
        }
        return RandomUtil.getRandNumMaxString(8).toLowerCase() + RandomUtil.getRandNumMaxString(8).toLowerCase();
    }

    public static String getGhost() {
        String lenString = StringUtils.getLenString(Long.toHexString(System.currentTimeMillis()), 12);
        return (V3DeviceComman.sumCheckCode(lenString) + lenString + new XOrUtils().xOr(lenString)).toLowerCase();
    }

    public static float getAppScreenDensity(Activity activity) {
        WindowManager windowManager = (WindowManager) activity.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static String getPhoneIPAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress().toString();
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            Log.e("BaseScanTvDeviceClient", "获取本机IP false =" + e.toString());
            return null;
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static void getNetTime() {
        AsyncExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.AppUtils.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    URLConnection uRLConnectionOpenConnection = new URL("http://www.baidu.com").openConnection();
                    uRLConnectionOpenConnection.connect();
                    LogUtil.e(AppUtils.TAG, "getNetTime ld:" + uRLConnectionOpenConnection.getDate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void killAdProcess(Activity activity) {
        ActivityManager activityManager;
        if (activity == null || (activityManager = (ActivityManager) activity.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            LogUtil.e(TAG, "killAdProcess:" + runningAppProcessInfo.processName);
            if (runningAppProcessInfo.processName.contains("com.google.android.gms.ads")) {
                Process.killProcess(runningAppProcessInfo.pid);
                return;
            }
        }
    }

    public static int px2dip(Context context, float f) {
        return px2dipC(context, f);
    }

    public static int px2dipC(Context context, float f) {
        try {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static int getScreenHeight(Context context) {
        return getScreenHeightC(context);
    }

    public static int getScreenHeightC(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String getDeviceManufacturer() {
        try {
            String str = Build.MANUFACTURER;
            String str2 = Build.BRAND;
            return str.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }
}
