package com.jd.android.sdk.coreinfo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.cdo.oaps.ad.y;
import com.jd.ad.sdk.jad_an.jad_bo;
import com.jd.ad.sdk.jad_lo.jad_dq;
import com.jd.ad.sdk.jad_lo.jad_fs;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.FileUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static boolean A = false;
    public static boolean B = false;
    public static boolean C = false;
    public static boolean D = false;
    public static final String[] E = {"/su", "/su/bin/su", "/sbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/data/local/su", "/system/xbin/su", "/system/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/system/bin/cufsdosck", "/system/xbin/cufsdosck", "/system/bin/cufsmgr", "/system/xbin/cufsmgr", "/system/bin/cufaevdd", "/system/xbin/cufaevdd", "/system/bin/conbb", "/system/xbin/conbb"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4590a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static String f = "";
    public static String g = "";
    public static String h = "";
    public static String[] i = null;
    public static String j = "";
    public static String k = "";
    public static String l = "";
    public static String m = "";
    public static String n = "";
    public static String o = "";
    public static String p = "";
    public static String q = "";
    public static String r = "";
    public static String s = "";
    public static long t;
    public static long u;
    public static long v;
    public static boolean w;
    public static boolean x;
    public static boolean y;
    public static boolean z;

    public static long a(String str) {
        StatFs statFs = new StatFs(str);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static WifiInfo a(Context context) {
        String str;
        if (context == null) {
            str = "getWifiConnectionInfo context is null";
        } else {
            if (jad_fs.jad_an(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                    if (wifiManager != null) {
                        return wifiManager.getConnectionInfo();
                    }
                } catch (Exception e2) {
                    Logger.e("Baseinfo.DeviceInfo", "", e2);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up get wifi info.";
        }
        Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean a() {
        File file = new File("/proc/tty/drivers");
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        byte[] bArr = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bArr);
            fileInputStream.close();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new String(bArr).indexOf("goldfish") != -1;
    }

    public static long b(String str) {
        int iIndexOf;
        String strTrim;
        int iLastIndexOf;
        long j2;
        if (str == null || (iIndexOf = str.indexOf(58)) == -1 || (iLastIndexOf = (strTrim = str.substring(iIndexOf + 1).trim()).lastIndexOf(32)) == -1) {
            return -1L;
        }
        String strSubstring = strTrim.substring(iLastIndexOf + 1);
        try {
            long j3 = Long.parseLong(strTrim.substring(0, iLastIndexOf).trim());
            if ("kb".equalsIgnoreCase(strSubstring)) {
                j2 = 1024;
            } else if ("mb".equalsIgnoreCase(strSubstring)) {
                j2 = 1048576;
            } else {
                if (!y.f.equalsIgnoreCase(strSubstring)) {
                    return j3;
                }
                j2 = FileUtils.ONE_GB;
            }
            return j3 * j2;
        } catch (Exception unused) {
            return -1L;
        }
    }

    public static List<ScanResult> b(Context context) {
        String str;
        if (context == null) {
            str = "getWifiScanResultList context is null";
        } else {
            if (jad_fs.jad_an(context, "android.permission.ACCESS_FINE_LOCATION")) {
                try {
                    WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                    if (wifiManager != null) {
                        return wifiManager.getScanResults();
                    }
                } catch (Exception e2) {
                    Logger.e("Baseinfo.DeviceInfo", "", e2);
                }
                return null;
            }
            str = "ACCESS_FINE_LOCATION permission is not granted, give up scan wifi list.";
        }
        Logger.e("Baseinfo.DeviceInfo", str);
        return null;
    }

    public static boolean b() {
        try {
            String[] strArr = {"/dev/socket/qemud", "/dev/qemu_pipe"};
            boolean z2 = false;
            for (int i2 = 0; i2 < 2; i2++) {
                if (new File(strArr[i2]).exists()) {
                    z2 = true;
                }
            }
            return z2;
        } catch (Exception unused) {
            return false;
        }
    }

    public static ArrayList<NetworkInterface> c() {
        jad_dq<ArrayList<NetworkInterface>> jad_dqVar = CoreInfo.Device.networkInterfacesSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : Collections.list(NetworkInterface.getNetworkInterfaces());
    }

    public static List<String> c(Context context) {
        ArrayList arrayList = new ArrayList();
        List<ScanResult> listI = i(context);
        if (listI != null && !listI.isEmpty()) {
            Iterator<ScanResult> it = listI.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().BSSID);
            }
        }
        return arrayList;
    }

    public static boolean d(Context context) {
        StorageManager storageManager = (StorageManager) context.getSystemService("storage");
        try {
            Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
            method.setAccessible(true);
            Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
            if (objArr == null) {
                return false;
            }
            for (Object obj : objArr) {
                if (((Boolean) obj.getClass().getMethod("isRemovable", new Class[0]).invoke(obj, new Object[0])).booleanValue() && ((String) obj.getClass().getMethod("getState", new Class[0]).invoke(obj, new Object[0])).equals("mounted")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e2);
            return false;
        }
    }

    @Deprecated
    public static String e(Context context) {
        try {
            if (((TelephonyManager) context.getSystemService("phone")) == null) {
                return "";
            }
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            int iJad_an = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            if (iJad_an == 20) {
                return "5g";
            }
            switch (iJad_an) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3g";
                case 13:
                    return "4g";
                default:
                    return "mobile";
            }
        } catch (Throwable th) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getMobileDataType()", th);
            return "mobile";
        }
    }

    public static WifiInfo f(Context context) {
        jad_dq<WifiInfo> jad_dqVar = CoreInfo.Device.wifiInfoSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : a(context);
    }

    public static DisplayMetrics g(Context context) {
        if (context == null) {
            Logger.w("Baseinfo.DeviceInfo", "context is null");
            return null;
        }
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Exception e2) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getDisplayMetricsObject()", e2);
            return null;
        }
    }

    public static boolean h(Context context) {
        if (!B) {
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
                return false;
            }
            A = context.getPackageManager().hasSystemFeature("android.hardware.nfc");
            B = true;
        }
        return A;
    }

    public static List<ScanResult> i(Context context) {
        jad_dq<List<ScanResult>> jad_dqVar = CoreInfo.Device.wifiListSupplier;
        return jad_dqVar != null ? jad_dqVar.jad_an() : b(context);
    }

    public static String j(Context context) {
        NetworkInfo.State state;
        NetworkInfo.State state2;
        if (context == null) {
            Logger.w("Baseinfo.DeviceInfo", "context is null");
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (activeNetworkInfo.getType() == 0) {
                    return CoreInfo.sensitiveApi != null ? e(context) : "mobile";
                }
                try {
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                    if (networkInfo != null && networkInfo.getState() != null && ((state2 = networkInfo.getState()) == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING)) {
                        return "wifi";
                    }
                } catch (Throwable th) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th);
                }
                try {
                    NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(9);
                    return (networkInfo2 == null || networkInfo2.getState() == null || !((state = networkInfo2.getState()) == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) ? "" : "enterNet";
                } catch (Throwable th2) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th2);
                }
            }
            return "none";
        } catch (Throwable th3) {
            Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getNetworkType()", th3);
            return "";
        }
    }
}
