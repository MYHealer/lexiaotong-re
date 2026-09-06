package com.jd.ad.sdk.jad_qd;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import com.byazt.hs.sl;
import com.jd.android.sdk.coreinfo.CoreInfo;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.yfanads.android.utils.YFAdsConst;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.List;

/* JADX INFO: compiled from: JADAntiInfoUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static String jad_an(Context context) {
        long blockSizeLong;
        try {
            if (!jad_an("freeDiskSpace", true) || context == null) {
                return "";
            }
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                blockSizeLong = statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
            } catch (Exception e) {
                e.printStackTrace();
                blockSizeLong = 0;
            }
            return String.valueOf(blockSizeLong);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String jad_dq() {
        String cpuName = "";
        try {
            if (!jad_an("cpuType", true)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("cpuType", true)) {
                return jad_anVar.jad_dq("cpuType");
            }
            cpuName = CoreInfo.Device.getCpuName();
            jad_anVar.jad_bo("cpuType", cpuName);
            return cpuName;
        } catch (Exception unused) {
        }
    }

    public static String jad_er() {
        try {
            if (!jad_an("cpuFrequency", true)) {
                return "";
            }
            String cpuCurFreq = CoreInfo.Device.getCpuCurFreq();
            if (!TextUtils.isEmpty(cpuCurFreq)) {
                return Double.parseDouble(new DecimalFormat("0.0").format(Double.parseDouble(cpuCurFreq) / 1000000.0d)) + "GHz";
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static String jad_hu() {
        String oSName = "";
        try {
            if (!jad_an("display", true)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("display", true)) {
                return (String) jad_anVar.jad_bo("display");
            }
            oSName = CoreInfo.System.getOSName();
            jad_anVar.jad_bo("display", oSName);
            return oSName;
        } catch (Exception unused) {
        }
    }

    public static String jad_iv() {
        String hardwareName = "";
        try {
            if (!jad_an("hardware", true)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("hardware", true)) {
                return jad_anVar.jad_dq("hardware");
            }
            hardwareName = CoreInfo.Device.getHardwareName();
            jad_anVar.jad_bo("hardware", hardwareName);
            return hardwareName;
        } catch (Exception unused) {
        }
    }

    public static String jad_jw() {
        String str = "0";
        String str2 = "NA";
        try {
            if (!jad_an("ifp", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("ifp", true)) {
                return jad_anVar.jad_dq("ifp");
            }
            try {
                com.jd.ad.sdk.jad_kn.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_kn.jad_dq(com.jd.ad.sdk.jad_il.jad_an.jad_an);
                if (jad_dqVar.jad_cp() || jad_dqVar.jad_bo() || jad_dqVar.jad_an()) {
                    str = "1";
                }
            } catch (Exception unused) {
            }
            try {
                try {
                    com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("ifp", str);
                    return str;
                } catch (Exception unused2) {
                    return str;
                }
            } catch (Exception unused3) {
                str2 = str;
            }
        } catch (Exception unused4) {
        }
        return str2;
    }

    public static String jad_ly() {
        String str = "NA";
        try {
            if (!jad_an(YFAdsConst.LP, false)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an(YFAdsConst.LP, true)) {
                return (String) jad_anVar.jad_bo(YFAdsConst.LP);
            }
            List<String> list = jad_cp.jad_an;
            String displayName = null;
            try {
                Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
                if (networkInterfaces != null) {
                    while (networkInterfaces.hasMoreElements()) {
                        NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                        if (networkInterfaceNextElement.isUp()) {
                            displayName = networkInterfaceNextElement.getDisplayName();
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            str = displayName == null ? "" : displayName;
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo(YFAdsConst.LP, str);
        } catch (Exception unused) {
        }
        return str;
    }

    public static String jad_mz() {
        String manufacture = "";
        try {
            if (!jad_an("make", true)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("make", true)) {
                return jad_anVar.jad_dq("make");
            }
            manufacture = CoreInfo.Device.getManufacture();
            jad_anVar.jad_bo("make", manufacture);
            return manufacture;
        } catch (Exception unused) {
        }
    }

    public static String jad_na() {
        String model = "";
        try {
            if (!jad_an("model", true)) {
                return "";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("model", true)) {
                return jad_anVar.jad_dq("model");
            }
            model = CoreInfo.Device.getModel();
            jad_anVar.jad_bo("model", model);
            return model;
        } catch (Exception unused) {
        }
    }

    public static int jad_ob() {
        int i = -1;
        try {
            if (!jad_an("physicalCpu", true)) {
                return -1;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("physicalCpu", true)) {
                return jad_anVar.jad_cp("physicalCpu");
            }
            i = Integer.parseInt(CoreInfo.Device.getCPUNum());
            jad_anVar.jad_bo("physicalCpu", Integer.valueOf(i));
            return i;
        } catch (NumberFormatException unused) {
        }
    }

    public static int jad_zm() {
        try {
            if (jad_an("sof", true)) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_jt() ^ true ? 1 : 0;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String jad_cn() {
        NetworkCapabilities networkCapabilities;
        String str = "NA";
        try {
            if (!jad_an("vpnConnect", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("vpnConnect", true)) {
                return jad_anVar.jad_dq("vpnConnect");
            }
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) com.jd.ad.sdk.jad_il.jad_an.jad_an.getSystemService("connectivity");
                str = (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null || !networkCapabilities.hasTransport(4)) ? "0" : "1";
            } catch (Exception e) {
                e.printStackTrace();
            }
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("vpnConnect", str);
        } catch (Exception unused) {
        }
        return str;
    }

    public static String jad_fs() {
        String brand = "NA";
        try {
            if (!jad_an("brand", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("brand", true)) {
                return jad_anVar.jad_dq("brand");
            }
            brand = CoreInfo.Device.getBrand();
            jad_anVar.jad_bo("brand", brand);
            return brand;
        } catch (Exception unused) {
        }
    }

    public static String jad_jt() {
        String deviceName = "NA";
        try {
            if (!jad_an("devicename", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("devicename", true)) {
                return jad_anVar.jad_dq("devicename");
            }
            deviceName = CoreInfo.Device.getDeviceName();
            jad_anVar.jad_bo("devicename", deviceName);
            return deviceName;
        } catch (Exception unused) {
        }
    }

    public static String jad_kx() {
        String str = "NA";
        try {
            if (!jad_an("launcher", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("launcher", true)) {
                return jad_anVar.jad_dq("launcher");
            }
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveInfoResolveActivity = com.jd.ad.sdk.jad_il.jad_an.jad_an.getPackageManager().resolveActivity(intent, 0);
            String str2 = "";
            if (resolveInfoResolveActivity != null) {
                String str3 = resolveInfoResolveActivity.activityInfo.packageName;
                int i = com.jd.ad.sdk.jad_jm.jad_cp.jad_an;
                if (str3 != null) {
                    str2 = str3;
                }
            }
            str = str2;
            jad_anVar.jad_bo("launcher", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static String jad_pc() {
        String strValueOf = "NA";
        try {
            if (!jad_an("processcount", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("processcount", true)) {
                return jad_anVar.jad_dq("processcount");
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = CoreInfo.App.getRunningAppProcesses(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            strValueOf = String.valueOf(runningAppProcesses != null ? runningAppProcesses.size() : 0);
            jad_anVar.jad_bo("processcount", strValueOf);
            return strValueOf;
        } catch (Exception unused) {
        }
    }

    public static String jad_qd() {
        try {
            return !jad_an("soaid", false) ? "NA" : com.jd.ad.sdk.jad_jw.jad_an.jad_an;
        } catch (Exception unused) {
            return "NA";
        }
    }

    public static String jad_re() {
        int i;
        String strValueOf = "NA";
        try {
            if (!jad_an("brightness", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("brightness", true)) {
                return jad_anVar.jad_dq("brightness");
            }
            try {
                i = Settings.System.getInt(com.jd.ad.sdk.jad_il.jad_an.jad_an.getContentResolver(), "screen_brightness");
            } catch (Exception e) {
                Logger.e("AntiSDK", e.getMessage());
                i = 0;
            }
            strValueOf = String.valueOf(i);
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("brightness", strValueOf);
        } catch (Exception unused) {
        }
        return strValueOf;
    }

    public static String jad_sf() {
        String strJad_bo = "NA";
        try {
            if (!jad_an("isDebug", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("isDebug", true)) {
                return jad_anVar.jad_dq("isDebug");
            }
            strJad_bo = com.jd.ad.sdk.jad_il.jad_an.jad_bo();
            jad_anVar.jad_bo("isDebug", strJad_bo);
            return strJad_bo;
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    public static int jad_tg() {
        ?? IsRoot = -1;
        try {
            if (!jad_an("jailbreak", true)) {
                return -1;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("jailbreak", true)) {
                return jad_anVar.jad_cp("jailbreak");
            }
            IsRoot = CoreInfo.Device.isRoot();
            jad_anVar.jad_bo("jailbreak", Integer.valueOf((int) IsRoot));
            return IsRoot == true ? 1 : 0;
        } catch (Exception unused) {
        }
    }

    public static String jad_vi() {
        String strJad_dq = "NA";
        try {
            if (!jad_an("isHooked", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("isHooked", true)) {
                return jad_anVar.jad_dq("isHooked");
            }
            strJad_dq = com.jd.ad.sdk.jad_il.jad_an.jad_dq();
            jad_anVar.jad_bo("isHooked", strJad_dq);
            return strJad_dq;
        } catch (Exception unused) {
        }
    }

    public static String jad_wj() {
        String strJad_er = "NA";
        try {
            if (!jad_an("isMoreOpen", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("isMoreOpen", true)) {
                return jad_anVar.jad_dq("isMoreOpen");
            }
            strJad_er = com.jd.ad.sdk.jad_il.jad_an.jad_er();
            jad_anVar.jad_bo("isMoreOpen", strJad_er);
            return strJad_er;
        } catch (Exception unused) {
        }
    }

    public static String jad_xk() {
        String str = "NA";
        try {
            if (!jad_an("isQEmuDriverExist", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("isQEmuDriverExist", true)) {
                return jad_anVar.jad_dq("isQEmuDriverExist");
            }
            str = CoreInfo.Device.isQEmuDriverFile() ? "1" : "0";
            jad_anVar.jad_bo("isQEmuDriverExist", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static String jad_yl() {
        String str = "NA";
        try {
            if (!jad_an("isPipeExist", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("isPipeExist", true)) {
                return jad_anVar.jad_dq("isPipeExist");
            }
            str = CoreInfo.Device.checkPipes() ? "1" : "0";
            jad_anVar.jad_bo("isPipeExist", str);
            return str;
        } catch (Exception unused) {
        }
    }

    public static int jad_uh() {
        int iJad_cp = -1;
        try {
            if (!jad_an("em", true)) {
                return -1;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("em", true)) {
                return jad_anVar.jad_cp("em");
            }
            iJad_cp = com.jd.ad.sdk.jad_il.jad_an.jad_cp();
            jad_anVar.jad_bo("em", Integer.valueOf(iJad_cp));
            return iJad_cp;
        } catch (Exception unused) {
        }
    }

    public static int jad_bo(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (jad_an("remainingBatteryLevel", true)) {
                return CoreInfo.Device.getBatteryLevel(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int jad_cp(Context context) {
        if (context == null) {
            return -1;
        }
        try {
            if (jad_an(sl.c, true)) {
                return com.jd.ad.sdk.jad_il.jad_an.jad_fs() ? 1 : 0;
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String jad_an() {
        String packageName = "NA";
        try {
            if (!jad_an("packagename", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("packagename", true)) {
                return jad_anVar.jad_dq("packagename");
            }
            packageName = CoreInfo.App.getPackageName(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            jad_anVar.jad_bo("packagename", packageName);
            return packageName;
        } catch (Exception unused) {
        }
    }

    public static String jad_bo() {
        String strJoin = "NA";
        try {
            if (!jad_an("lock_awake_receiver", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("lock_awake_receiver", true)) {
                return jad_anVar.jad_dq("lock_awake_receiver");
            }
            List<String> listJad_an = com.jd.ad.sdk.jad_jm.jad_an.jad_an(com.jd.ad.sdk.jad_il.jad_an.jad_an);
            strJoin = listJad_an == null ? "" : TextUtils.join(", ", listJad_an);
            jad_anVar.jad_bo("lock_awake_receiver", strJoin);
            return strJoin;
        } catch (Exception unused) {
        }
    }

    public static String jad_cp() {
        String strValueOf = "NA";
        try {
            if (!jad_an("batteryVoltage", true)) {
                return "NA";
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an;
            if (jad_anVar.jad_an("batteryVoltage", true)) {
                return jad_anVar.jad_dq("batteryVoltage");
            }
            int intExtra = -1;
            try {
                if (com.jd.ad.sdk.jad_il.jad_an.jad_an != null) {
                    intExtra = com.jd.ad.sdk.jad_il.jad_an.jad_an.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("voltage", -1);
                }
            } catch (Throwable unused) {
            }
            strValueOf = String.valueOf(intExtra);
            com.jd.ad.sdk.jad_uh.jad_an.jad_bo.jad_an.jad_bo("batteryVoltage", strValueOf);
            return strValueOf;
        } catch (Exception unused2) {
        }
    }

    public static boolean jad_an(String str, boolean z) {
        if (z && com.jd.ad.sdk.jad_ob.jad_dq.jad_an.jad_an.jad_an(11, (String) null)) {
            return false;
        }
        return jad_fs.jad_an.jad_an.jad_an(str);
    }
}
