package com.jd.android.sdk.coreinfo;

import android.app.Activity;
import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.fingerprint.FingerprintManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import com.byazt.hv.TTDownloadField;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.openalliance.ad.constant.x;
import com.jd.ad.sdk.jad_an.jad_an;
import com.jd.ad.sdk.jad_an.jad_bo;
import com.jd.ad.sdk.jad_an.jad_cp;
import com.jd.ad.sdk.jad_lo.jad_dq;
import com.jd.ad.sdk.jad_lo.jad_er;
import com.jd.ad.sdk.jad_lo.jad_hu;
import com.jd.android.sdk.coreinfo.util.Logger;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Array;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CoreInfo {
    private static final String TAG = "BaseInfo.CoreInfo";
    public static jad_bo sensitiveApi;

    public static class App {
        public static String getAppName(Context context) {
            String str;
            String str2;
            if (TextUtils.isEmpty(jad_cp.jad_an)) {
                str = "";
                if (context == null) {
                    str2 = "context is null";
                } else {
                    PackageInfo packageInfoJad_an = jad_cp.jad_an(context, 16384);
                    if (packageInfoJad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        jad_cp.jad_an = context.getPackageManager().getApplicationLabel(packageInfoJad_an.applicationInfo).toString();
                        str = jad_cp.jad_an;
                    }
                }
                Logger.w("AppInfo", str2);
            } else {
                str = jad_cp.jad_an;
            }
            jad_an.jad_an(str, "getAppName() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getFirstInstallTime(Context context) {
            String str;
            long j = 0;
            if (jad_cp.jad_er > 0) {
                j = jad_cp.jad_er;
            } else {
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo packageInfoJad_an = jad_cp.jad_an(context, 16384);
                    if (packageInfoJad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_er = packageInfoJad_an.firstInstallTime;
                        j = jad_cp.jad_er;
                    }
                }
                Logger.w("AppInfo", str);
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getFirstInstallTime() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static long getLastUpdateTime(Context context) {
            String str;
            long j = 0;
            if (jad_cp.jad_fs > 0) {
                j = jad_cp.jad_fs;
            } else {
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo packageInfoJad_an = jad_cp.jad_an(context, 16384);
                    if (packageInfoJad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_fs = packageInfoJad_an.lastUpdateTime;
                        j = jad_cp.jad_fs;
                    }
                }
                Logger.w("AppInfo", str);
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getLastUpdateTime() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static String getPackageName(Context context) {
            String strJad_an = jad_cp.jad_an(context);
            jad_an.jad_an(strJad_an, "getPackageName() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static List<ActivityManager.RunningAppProcessInfo> getRunningAppProcesses(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningAppProcessInfo> listJad_dq = jad_boVar != null ? jad_boVar.jad_dq(context) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningAppProcesses() --> ".concat(String.valueOf(listJad_dq)));
            return listJad_dq;
        }

        public static List<ActivityManager.RunningServiceInfo> getRunningServices(Context context) {
            return getRunningServices(context, Integer.MAX_VALUE);
        }

        public static List<ActivityManager.RunningServiceInfo> getRunningServices(Context context, int i) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningServiceInfo> listJad_an = jad_boVar != null ? jad_boVar.jad_an(context, i) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningServices() --> ".concat(String.valueOf(listJad_an)));
            return listJad_an;
        }

        public static List<ActivityManager.RunningTaskInfo> getRunningTasks(Context context) {
            return getRunningTasks(context, Integer.MAX_VALUE);
        }

        public static List<ActivityManager.RunningTaskInfo> getRunningTasks(Context context, int i) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<ActivityManager.RunningTaskInfo> listJad_bo = jad_boVar != null ? jad_boVar.jad_bo(context, i) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRunningTasks() --> ".concat(String.valueOf(listJad_bo)));
            return listJad_bo;
        }

        public static long getSignatureHash(Context context) {
            long jJad_bo = jad_cp.jad_bo(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSignatureHash() --> ".concat(String.valueOf(jJad_bo)));
            return jJad_bo;
        }

        public static int getStatusBarHeight(Context context) {
            int dimensionPixelSize;
            if (context == null) {
                Logger.w("AppInfo", "context is null");
                dimensionPixelSize = 0;
            } else {
                Resources resources = context.getResources();
                dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getStatusBarHeight() --> ".concat(String.valueOf(dimensionPixelSize)));
            return dimensionPixelSize;
        }

        public static int getVersionCode(Context context) {
            int i;
            String str;
            if (jad_cp.jad_dq <= 0) {
                i = 0;
                if (context == null) {
                    str = "context is null";
                } else {
                    PackageInfo packageInfoJad_an = jad_cp.jad_an(context, 16384);
                    if (packageInfoJad_an == null) {
                        str = "packageInfo is null";
                    } else {
                        jad_cp.jad_dq = packageInfoJad_an.versionCode;
                        i = jad_cp.jad_dq;
                    }
                }
                Logger.w("AppInfo", str);
            } else {
                i = jad_cp.jad_dq;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getVersionCode() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static String getVersionName(Context context) {
            String str;
            String str2;
            if (TextUtils.isEmpty(jad_cp.jad_cp)) {
                str = "";
                if (context == null) {
                    str2 = "context is null";
                } else {
                    PackageInfo packageInfoJad_an = jad_cp.jad_an(context, 16384);
                    if (packageInfoJad_an == null) {
                        str2 = "packageInfo is null";
                    } else {
                        jad_cp.jad_cp = packageInfoJad_an.versionName;
                        str = jad_cp.jad_cp;
                    }
                }
                Logger.w("AppInfo", str2);
            } else {
                str = jad_cp.jad_cp;
            }
            jad_an.jad_an(str, "getVersionName() --> ", CoreInfo.TAG);
            return str;
        }

        public static boolean isNavigationBarVisible(Activity activity) {
            boolean z = false;
            if (activity == null) {
                Logger.w("AppInfo", "activity is null");
            } else {
                Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                int i2 = displayMetrics.widthPixels;
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                defaultDisplay.getMetrics(displayMetrics2);
                int i3 = displayMetrics2.heightPixels;
                int i4 = displayMetrics2.widthPixels;
                if (i - i3 > 0 || i2 - i4 > 0) {
                    z = true;
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNavigationBarVisible() --> ".concat(String.valueOf(z)));
            return z;
        }
    }

    public static class Device {
        public static jad_dq<ArrayList<NetworkInterface>> networkInterfacesSupplier;
        public static jad_dq<WifiInfo> wifiInfoSupplier;
        public static jad_dq<List<ScanResult>> wifiListSupplier;

        public static boolean checkPipes() {
            boolean zB = a.b();
            Logger.debugWithStackTrace(CoreInfo.TAG, "checkPipes() --> ".concat(String.valueOf(zB)));
            return zB;
        }

        public static String getAndroidId(Context context) {
            String str;
            if (!TextUtils.isEmpty(a.f4590a)) {
                str = a.f4590a;
            } else if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
                str = "";
            } else {
                a.f4590a = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Settings.Secure.getString(context.getContentResolver(), "android_id"));
                str = a.f4590a;
            }
            jad_an.jad_an(str, "getAndroidId() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getAndroidIdForDeviceFinger(Context context) {
            String strJad_an;
            if (TextUtils.isEmpty(a.b)) {
                String string = "";
                if (context != null) {
                    try {
                        if (Build.VERSION.SDK_INT < 28) {
                            strJad_an = com.jd.ad.sdk.jad_dq.jad_an.jad_an(context, "android_id");
                            try {
                                if (TextUtils.isEmpty(strJad_an)) {
                                    strJad_an = com.jd.ad.sdk.jad_dq.jad_an.jad_bo(context, "android_id");
                                }
                            } catch (Throwable unused) {
                            }
                        } else {
                            strJad_an = "";
                        }
                        strJad_an.equals("");
                        string = strJad_an.equals("") ? Settings.Secure.getString(context.getContentResolver(), "android_id") : strJad_an;
                    } catch (Throwable unused2) {
                    }
                }
                a.b = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(string);
            }
            String str = a.b;
            jad_an.jad_an(str, "getAndroidIdForDeviceFinger() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getAvailableInternalMemorySize(Context context) {
            long availableBlocks;
            try {
                StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
            } catch (Exception unused) {
                availableBlocks = 0;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getAvailableInternalMemorySize() --> ".concat(String.valueOf(availableBlocks)));
            return availableBlocks;
        }

        public static int getBatteryLevel(Context context) {
            int intExtra = -1;
            if (context != null) {
                try {
                    intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("level", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryLevel() --> ".concat(String.valueOf(intExtra)));
            return intExtra;
        }

        public static int getBatteryPlugged(Context context) {
            int intExtra = -1;
            if (context != null) {
                try {
                    intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("plugged", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryPlugged() --> ".concat(String.valueOf(intExtra)));
            return intExtra;
        }

        public static int getBatteryScale(Context context) {
            int intExtra = -1;
            if (context != null) {
                try {
                    intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("scale", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryScale() --> ".concat(String.valueOf(intExtra)));
            return intExtra;
        }

        public static int getBatteryStatus(Context context) {
            int intExtra = -1;
            if (context != null) {
                try {
                    intExtra = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED")).getIntExtra("status", -1);
                } catch (Throwable unused) {
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getBatteryStatus() --> ".concat(String.valueOf(intExtra)));
            return intExtra;
        }

        public static String getBluetoothMac(Context context) {
            String str = "";
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                String address = defaultAdapter != null ? defaultAdapter.getAddress() : "";
                if (TextUtils.isEmpty(address) || TextUtils.equals("02:00:00:00:00:00", address)) {
                    address = Settings.Secure.getString(context.getContentResolver(), "bluetooth_address");
                }
                if (!TextUtils.isEmpty(address)) {
                    str = address;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getBluetoothMac() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBluetoothName(Context context) {
            String str = "";
            try {
                BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                String name = defaultAdapter != null ? defaultAdapter.getName() : "";
                if (!TextUtils.isEmpty(name)) {
                    str = name;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getBluetoothName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBoard() {
            if (TextUtils.isEmpty(a.g)) {
                a.g = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BOARD);
            }
            String str = a.g;
            jad_an.jad_an(str, "getBoard() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBoardPlatform() {
            if (TextUtils.isEmpty(a.h)) {
                a.h = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(jad_hu.jad_an("ro.board.platform", ""));
            }
            String str = a.h;
            jad_an.jad_an(str, "getBoardPlatform() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBootloaderVersion() {
            if (TextUtils.isEmpty(a.l)) {
                a.l = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BOOTLOADER);
            }
            String str = a.l;
            jad_an.jad_an(str, "getBootloaderVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getBrand() {
            if (TextUtils.isEmpty(a.e)) {
                a.e = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BRAND);
            }
            String str = a.e;
            jad_an.jad_an(str, "getBrand() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUMaxFreq() {
            String str;
            if (TextUtils.isEmpty(a.r)) {
                String strJad_an = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq", false);
                if (strJad_an.length() == 0) {
                    str = "";
                } else {
                    a.r = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(strJad_an);
                    str = a.r;
                }
            } else {
                str = a.r;
            }
            jad_an.jad_an(str, "getCPUMaxFreq() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUNum() {
            String str;
            if (TextUtils.isEmpty(a.p)) {
                try {
                    a.p = String.valueOf(new File("/sys/devices/system/cpu/").listFiles(new com.jd.ad.sdk.jad_cp.jad_an()).length);
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getCPUNum()", e);
                    str = "1";
                }
            }
            str = a.p;
            jad_an.jad_an(str, "getCPUNum() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCPUSerialNo() {
            LineNumberReader lineNumberReader;
            Throwable th;
            InputStreamReader inputStreamReader;
            String strTrim;
            if (TextUtils.isEmpty(a.o)) {
                try {
                    inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("cat /proc/cpuinfo | grep Serial").getInputStream());
                    try {
                        lineNumberReader = new LineNumberReader(inputStreamReader);
                        int i = 0;
                        while (true) {
                            if (i >= 100) {
                                strTrim = "";
                                break;
                            }
                            try {
                                String line = lineNumberReader.readLine();
                                if (line != null && line.indexOf("Serial") >= 0) {
                                    strTrim = line.substring(line.indexOf(x.bQ) + 1).trim();
                                    break;
                                }
                            } catch (Throwable th2) {
                                try {
                                    th2.printStackTrace();
                                } catch (Throwable th3) {
                                    th = th3;
                                    try {
                                        th.printStackTrace();
                                        strTrim = "";
                                        a.o = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(strTrim);
                                        String str = a.o;
                                        jad_an.jad_an(str, "getCPUSerialNo() --> ", CoreInfo.TAG);
                                        return str;
                                    } catch (Throwable th4) {
                                        if (inputStreamReader != null) {
                                            try {
                                                inputStreamReader.close();
                                            } catch (Exception unused) {
                                            }
                                        }
                                        if (lineNumberReader == null) {
                                            throw th4;
                                        }
                                        try {
                                            lineNumberReader.close();
                                            throw th4;
                                        } catch (Exception unused2) {
                                            throw th4;
                                        }
                                    }
                                }
                            }
                            i += 2;
                        }
                    } catch (Throwable th5) {
                        lineNumberReader = null;
                        th = th5;
                    }
                } catch (Throwable th6) {
                    lineNumberReader = null;
                    th = th6;
                    inputStreamReader = null;
                }
                a.o = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(strTrim);
            }
            String str2 = a.o;
            jad_an.jad_an(str2, "getCPUSerialNo() --> ", CoreInfo.TAG);
            return str2;
        }

        public static int getCellId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getCellId() --> -1");
            return -1;
        }

        public static CellLocation getCellLocationForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getCellLocationForDeviceFinger() --> ".concat("null"));
            return null;
        }

        public static String getCpuCurFreq() {
            BufferedReader bufferedReader;
            String strTrim;
            FileReader fileReader = null;
            try {
                FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
                try {
                    bufferedReader = new BufferedReader(fileReader2);
                    try {
                        strTrim = bufferedReader.readLine().trim();
                        try {
                            fileReader2.close();
                        } catch (IOException unused) {
                        }
                    } catch (Exception unused2) {
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        strTrim = "";
                        if (bufferedReader != null) {
                        }
                        jad_an.jad_an(strTrim, "getCpuCurFreq() --> ", CoreInfo.TAG);
                        return strTrim;
                    } catch (Throwable th) {
                        th = th;
                        fileReader = fileReader2;
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (bufferedReader == null) {
                            throw th;
                        }
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                } catch (Exception unused6) {
                    bufferedReader = null;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    fileReader = fileReader2;
                    th = th2;
                }
            } catch (Exception unused7) {
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
            try {
                bufferedReader.close();
            } catch (IOException unused8) {
            }
            jad_an.jad_an(strTrim, "getCpuCurFreq() --> ", CoreInfo.TAG);
            return strTrim;
        }

        public static String getCpuMinFreq() throws Throwable {
            BufferedReader bufferedReader;
            if (TextUtils.isEmpty(a.s)) {
                FileReader fileReader = null;
                try {
                    FileReader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq");
                    try {
                        bufferedReader = new BufferedReader(fileReader2);
                        try {
                            a.s = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(bufferedReader.readLine().trim());
                            try {
                                fileReader2.close();
                            } catch (IOException unused) {
                            }
                        } catch (Exception unused2) {
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (bufferedReader != null) {
                            }
                            String str = a.s;
                            jad_an.jad_an(str, "getCpuMinFreq() --> ", CoreInfo.TAG);
                            return str;
                        } catch (Throwable th) {
                            th = th;
                            fileReader = fileReader2;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused4) {
                                }
                            }
                            if (bufferedReader == null) {
                                throw th;
                            }
                            try {
                                bufferedReader.close();
                                throw th;
                            } catch (IOException unused5) {
                                throw th;
                            }
                        }
                    } catch (Exception unused6) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        fileReader = fileReader2;
                        th = th2;
                    }
                } catch (Exception unused7) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                }
                try {
                    bufferedReader.close();
                } catch (IOException unused8) {
                }
            }
            String str2 = a.s;
            jad_an.jad_an(str2, "getCpuMinFreq() --> ", CoreInfo.TAG);
            return str2;
        }

        public static String getCpuName() {
            BufferedReader bufferedReader;
            if (TextUtils.isEmpty(a.q)) {
                FileReader fileReader = null;
                try {
                    try {
                        FileReader fileReader2 = new FileReader("/proc/cpuinfo");
                        try {
                            bufferedReader = new BufferedReader(fileReader2);
                            try {
                                String[] strArrSplit = bufferedReader.readLine().split(":\\s+", 2);
                                if (strArrSplit.length >= 2) {
                                    a.q = strArrSplit[1];
                                }
                                try {
                                    fileReader2.close();
                                } catch (IOException unused) {
                                }
                            } catch (Throwable th) {
                                th = th;
                                fileReader = fileReader2;
                                try {
                                    th.printStackTrace();
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException unused2) {
                                        }
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    String str = a.q;
                                    jad_an.jad_an(str, "getCpuName() --> ", CoreInfo.TAG);
                                    return str;
                                } catch (Throwable th2) {
                                    if (fileReader != null) {
                                        try {
                                            fileReader.close();
                                        } catch (IOException unused3) {
                                        }
                                    }
                                    if (bufferedReader == null) {
                                        throw th2;
                                    }
                                    try {
                                        bufferedReader.close();
                                        throw th2;
                                    } catch (IOException unused4) {
                                        throw th2;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            bufferedReader = null;
                            fileReader = fileReader2;
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bufferedReader = null;
                    }
                    bufferedReader.close();
                } catch (IOException unused5) {
                }
            }
            String str2 = a.q;
            jad_an.jad_an(str2, "getCpuName() --> ", CoreInfo.TAG);
            return str2;
        }

        public static float getDensity(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            float f = displayMetricsG == null ? 1.0f : displayMetricsG.density;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDensity() --> ".concat(String.valueOf(f)));
            return f;
        }

        public static String getDensityDpi(Context context) {
            String strValueOf = String.valueOf(getDensityDpiInt(context));
            Logger.d(CoreInfo.TAG, "getDensityDpi() --> ".concat(String.valueOf(strValueOf)));
            return strValueOf;
        }

        public static int getDensityDpiInt(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            int i = displayMetricsG == null ? 160 : displayMetricsG.densityDpi;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDensityDpiInt() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static String getDeviceId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDeviceId() --> ".concat(""));
            return "";
        }

        public static String getDeviceIdForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDeviceIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static String getDeviceName() {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String strJad_an = jad_boVar != null ? jad_boVar.jad_an() : "";
            jad_an.jad_an(strJad_an, "getDeviceName() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getDisplayMetrics(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            String str = displayMetricsG == null ? "" : displayMetricsG.widthPixels + "*" + displayMetricsG.heightPixels;
            jad_an.jad_an(str, "getDisplayMetrics() --> ", CoreInfo.TAG);
            return str;
        }

        public static DisplayMetrics getDisplayMetricsObject(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getDisplayMetricsObject() --> ".concat(String.valueOf(displayMetricsG)));
            return displayMetricsG;
        }

        public static String getDisplayMetricsWithNavigationBar(Context context) {
            String string = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context).toString();
            jad_an.jad_an(string, "getDisplayMetricsWithNavigationBar() --> ", CoreInfo.TAG);
            return string;
        }

        public static long getExternalStorageSize() {
            long j = 0;
            if (a.v <= 0) {
                try {
                    a.v = a.a(Environment.getExternalStorageDirectory().getPath());
                    j = a.v;
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getExternalStorageSize()", e);
                }
            } else {
                j = a.v;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getExternalStorageSize() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static int getGateway(Context context) {
            DhcpInfo dhcpInfo;
            int i = 0;
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i = dhcpInfo.gateway;
                }
            } catch (Throwable unused) {
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getGateway() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static String getHardwareName() {
            if (TextUtils.isEmpty(a.k)) {
                a.k = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.HARDWARE);
            }
            String str = a.k;
            jad_an.jad_an(str, "getHardwareName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getHardwareSerialNo() {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String strJad_bo = jad_boVar != null ? jad_boVar.jad_bo() : "";
            jad_an.jad_an(strJad_bo, "getHardwareSerialNo() --> ", CoreInfo.TAG);
            return strJad_bo;
        }

        public static String getHostName() {
            if (TextUtils.isEmpty(a.m)) {
                a.m = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.HOST);
            }
            String str = a.m;
            jad_an.jad_an(str, "getHostName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getIpAddressFromWifiInfo(Context context) {
            WifiInfo wifiInfoF;
            String str = "";
            if (context == null) {
                Logger.e("Baseinfo.DeviceInfo", "getIpAddressFromWifiInfo context is null");
            } else {
                NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
                if (networkInfo != null && networkInfo.isConnected() && (wifiInfoF = a.f(context)) != null) {
                    int ipAddress = wifiInfoF.getIpAddress();
                    str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                }
            }
            jad_an.jad_an(str, "getIpAddressFromWifiInfo() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getLinuxVersion() {
            String strJad_an;
            if (TextUtils.isEmpty(a.n)) {
                try {
                    strJad_an = com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/proc/version", false);
                    try {
                        if (TextUtils.isEmpty(strJad_an)) {
                            strJad_an = com.jd.ad.sdk.jad_lo.jad_an.jad_an("uname -a");
                        }
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    strJad_an = "";
                }
                a.n = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(strJad_an);
            }
            String str = a.n;
            jad_an.jad_an(str, "getLinuxVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getManufacture() {
            if (TextUtils.isEmpty(a.d)) {
                a.d = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.MANUFACTURER);
            }
            String str = a.d;
            jad_an.jad_an(str, "getManufacture() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getMemAvailSize(Context context) {
            long j = 0;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    j = memoryInfo.availMem >> 10;
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemAvailSize()", e);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemAvailSize() --> ".concat(String.valueOf(j)));
            return j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0032, code lost:
        
            if (r1 != null) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String[] getMemInfo() {
            String[] strArr = {"", "", ""};
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
                    for (int i = 0; i < 3; i++) {
                        try {
                            strArr[i] = bufferedReader2.readLine();
                        } catch (FileNotFoundException unused) {
                            bufferedReader = bufferedReader2;
                        } catch (IOException unused2) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemInfo() --> ".concat(String.valueOf(strArr)));
                            return strArr;
                        } catch (Throwable unused3) {
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemInfo() --> ".concat(String.valueOf(strArr)));
                            return strArr;
                        }
                    }
                    bufferedReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException unused4) {
            } catch (IOException unused5) {
            } catch (Throwable unused6) {
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemInfo() --> ".concat(String.valueOf(strArr)));
            return strArr;
        }

        public static long getMemState(Context context) throws Throwable {
            long j;
            BufferedReader bufferedReader = null;
            String str = null;
            BufferedReader bufferedReader2 = null;
            try {
                BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/meminfo"))), 1024);
                String str2 = null;
                while (true) {
                    try {
                        String line = bufferedReader3.readLine();
                        if (line != null) {
                            if (line.startsWith("MemTotal")) {
                                str = line;
                            } else if (line.startsWith("MemFree")) {
                                str2 = line;
                            }
                            if (str != null && str2 != null) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } catch (Exception unused) {
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        j = 0;
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th;
                    }
                }
                ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                j = new long[]{a.b(str), a.b(str2), memoryInfo.availMem}[0];
                try {
                    bufferedReader3.close();
                } catch (IOException unused4) {
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemState() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static long getMemTotalSize(Context context) {
            long j = 0;
            if (a.t > 0) {
                j = a.t;
            } else if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                try {
                    ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    activityManager.getMemoryInfo(memoryInfo);
                    a.t = memoryInfo.totalMem >> 10;
                    j = a.t;
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getMemTotalSize()", e);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getMemTotalSize() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static String getModel() {
            if (TextUtils.isEmpty(a.f)) {
                if (TextUtils.isEmpty(a.e)) {
                    a.e = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.BRAND);
                }
                if (MediationConstant.ADN_XIAOMI.equalsIgnoreCase(a.e)) {
                    a.f = jad_hu.jad_an("ro.product.marketname", "");
                }
                if (TextUtils.isEmpty(a.f)) {
                    a.f = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.MODEL);
                }
            }
            String str = a.f;
            jad_an.jad_an(str, "getModel() --> ", CoreInfo.TAG);
            return str;
        }

        @Deprecated
        public static String getNetAddressInfo() {
            String string;
            try {
                StringBuffer stringBuffer = new StringBuffer();
                ArrayList<NetworkInterface> arrayListC = a.c();
                if (arrayListC != null) {
                    Iterator<NetworkInterface> it = arrayListC.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (inetAddressNextElement instanceof Inet4Address) {
                                        hostAddress = hostAddress + "%ipv4";
                                    }
                                    if (stringBuffer.length() == 0) {
                                        stringBuffer.append(hostAddress);
                                    } else {
                                        stringBuffer.append(", ").append(hostAddress);
                                    }
                                }
                            }
                        }
                    }
                }
                string = stringBuffer.toString();
                if (TextUtils.isEmpty(string)) {
                    string = "";
                }
            } catch (Throwable unused) {
            }
            jad_an.jad_an(string, "getNetAddressInfo() --> ", CoreInfo.TAG);
            return string;
        }

        public static String[][] getNetAddresses() {
            String[][] strArr;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            try {
                ArrayList<NetworkInterface> arrayListC = a.c();
                if (arrayListC != null) {
                    Iterator<NetworkInterface> it = arrayListC.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress)) {
                                    if (inetAddressNextElement instanceof Inet4Address) {
                                        arrayList.add(hostAddress);
                                    } else if (inetAddressNextElement instanceof Inet6Address) {
                                        arrayList2.add(hostAddress);
                                    }
                                }
                            }
                        }
                    }
                }
                strArr = new String[][]{(String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()])};
            } catch (Throwable unused) {
                strArr = (String[][]) Array.newInstance((Class<?>) String.class, 0, 0);
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddresses() --> ".concat(String.valueOf(strArr)));
            return strArr;
        }

        public static List<String> getNetAddressesForIPv4() {
            ArrayList arrayList = new ArrayList();
            try {
                ArrayList<NetworkInterface> arrayListC = a.c();
                if (arrayListC != null) {
                    Iterator<NetworkInterface> it = arrayListC.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && (inetAddressNextElement instanceof Inet4Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddressesForIPv4() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static List<String> getNetAddressesForIPv6() {
            ArrayList arrayList = new ArrayList();
            try {
                ArrayList<NetworkInterface> arrayListC = a.c();
                if (arrayListC != null) {
                    Iterator<NetworkInterface> it = arrayListC.iterator();
                    while (it.hasNext()) {
                        Enumeration<InetAddress> inetAddresses = it.next().getInetAddresses();
                        while (inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if (!inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                if (!TextUtils.isEmpty(hostAddress) && (inetAddressNextElement instanceof Inet6Address)) {
                                    arrayList.add(hostAddress);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
                arrayList = new ArrayList();
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetAddressesForIPv6() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static int getNetmask(Context context) {
            DhcpInfo dhcpInfo;
            int i = 0;
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null && (dhcpInfo = wifiManager.getDhcpInfo()) != null) {
                    i = dhcpInfo.netmask;
                }
            } catch (Throwable unused) {
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetmask() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static String getNetworkISO(Context context) {
            String str = "";
            try {
                String networkCountryIso = ((TelephonyManager) context.getSystemService("phone")).getNetworkCountryIso();
                if (!TextUtils.isEmpty(networkCountryIso)) {
                    str = networkCountryIso;
                }
            } catch (Exception unused) {
            }
            jad_an.jad_an(str, "getNetworkISO() --> ", CoreInfo.TAG);
            return str;
        }

        public static ArrayList<NetworkInterface> getNetworkInterfaces() {
            ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkInterfaces() --> ".concat(String.valueOf(list)));
            return list;
        }

        public static String getNetworkOperator(Context context) {
            String strJad_an;
            try {
                strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getNetworkOperator());
            } catch (Exception unused) {
                strJad_an = "";
            }
            jad_an.jad_an(strJad_an, "getNetworkOperator() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getNetworkOperatorName(Context context) {
            String strJad_an;
            try {
                strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName());
            } catch (Exception unused) {
                strJad_an = "";
            }
            jad_an.jad_an(strJad_an, "getNetworkOperatorName() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getNetworkType(Context context) {
            String strJ = a.j(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkType() --> ".concat(strJ));
            return strJ;
        }

        public static String getNetworkTypeForDeviceFinger(Context context) {
            NetworkInfo activeNetworkInfo;
            String subtypeName = "";
            if (context != null) {
                try {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                        subtypeName = activeNetworkInfo.getSubtypeName();
                        String typeName = activeNetworkInfo.getTypeName();
                        if (activeNetworkInfo.getType() == 1) {
                            subtypeName = typeName;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(subtypeName, "getNetworkTypeForDeviceFinger() --> ", CoreInfo.TAG);
            return subtypeName;
        }

        public static int getNetworkTypeInt(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            int iJad_an = jad_boVar != null ? jad_boVar.jad_an(context) : 0;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getNetworkTypeInt() --> ".concat(String.valueOf(iJad_an)));
            return iJad_an;
        }

        public static String getProductName() {
            if (TextUtils.isEmpty(a.c)) {
                a.c = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.PRODUCT);
            }
            String str = a.c;
            jad_an.jad_an(str, "getProductName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getRadioVersion() {
            if (TextUtils.isEmpty(a.j)) {
                a.j = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.getRadioVersion());
            }
            String str = a.j;
            jad_an.jad_an(str, "getRadioVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static ScreenSize getRealScreenSize(Context context) {
            com.jd.ad.sdk.jad_dq.jad_bo.jad_an jad_anVarJad_an = com.jd.ad.sdk.jad_dq.jad_bo.jad_an(context);
            ScreenSize screenSize = new ScreenSize(jad_anVarJad_an.jad_an, jad_anVarJad_an.jad_bo);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRealScreenSize() --> ".concat(String.valueOf(screenSize)));
            return screenSize;
        }

        public static long getRomSize() {
            long j = 0;
            if (a.u <= 0) {
                try {
                    a.u = a.a(Environment.getDataDirectory().getPath());
                    j = a.u;
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happens when call getRomSize()", e);
                }
            } else {
                j = a.u;
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getRomSize() --> ".concat(String.valueOf(j)));
            return j;
        }

        public static String getSDCardId() {
            String strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_lo.jad_cp.jad_an("/sys/block/mmcblk0/device/cid", false));
            jad_an.jad_an(strJad_an, "getSDCardId() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static float getScaledDensity(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            float f = displayMetricsG == null ? 1.0f : displayMetricsG.scaledDensity;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScaledDensity() --> ".concat(String.valueOf(f)));
            return f;
        }

        public static int getScreenHeight(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            int i = displayMetricsG == null ? MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME : displayMetricsG.heightPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenHeight() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static int getScreenHeight2() {
            DisplayMetrics displayMetrics;
            try {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
            } catch (Exception e) {
                Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e);
                displayMetrics = null;
            }
            int i = displayMetrics == null ? MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME : displayMetrics.heightPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenHeight2() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static int getScreenWidth(Context context) {
            DisplayMetrics displayMetricsG = a.g(context);
            int i = displayMetricsG == null ? 240 : displayMetricsG.widthPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenWidth() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static int getScreenWidth2() {
            DisplayMetrics displayMetrics;
            try {
                displayMetrics = Resources.getSystem().getDisplayMetrics();
            } catch (Exception e) {
                Logger.e("Baseinfo.DeviceInfo", "An exception happends when call getSystemDisplayMetricsObject()", e);
                displayMetrics = null;
            }
            int i = displayMetrics == null ? 240 : displayMetrics.widthPixels;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getScreenWidth2() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static List<Sensor> getSensorList(Context context) {
            List<Sensor> sensorList = ((SensorManager) context.getSystemService("sensor")).getSensorList(-1);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSensorList() --> ".concat(String.valueOf(sensorList)));
            return sensorList;
        }

        public static String getSimCountryIso(Context context) {
            String strJad_an = "";
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimCountryIso());
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(strJad_an, "getSimCountryIso() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getSimOperator(Context context) {
            String str;
            String strJad_an = "";
            if (context != null) {
                try {
                    strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(((TelephonyManager) context.getSystemService("phone")).getSimOperator());
                } catch (Throwable th) {
                    str = "DeviceInfo.getSimOperator() exception: " + th.getMessage();
                    Logger.w("Baseinfo.DeviceInfo", str);
                }
                jad_an.jad_an(strJad_an, "getSimOperator() --> ", CoreInfo.TAG);
                return strJad_an;
            }
            str = "context is null";
            Logger.w("Baseinfo.DeviceInfo", str);
            jad_an.jad_an(strJad_an, "getSimOperator() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getSimOperatorName(Context context) {
            String strJad_an = "";
            if (context != null) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        strJad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(telephonyManager.getSimOperatorName());
                    }
                } catch (Throwable unused) {
                }
            }
            jad_an.jad_an(strJad_an, "getSimOperatorName() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        public static String getSimSerialNo(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            String strJad_cp = jad_boVar != null ? jad_boVar.jad_cp(context) : "";
            jad_an.jad_an(strJad_cp, "getSimSerialNo() --> ", CoreInfo.TAG);
            return strJad_cp;
        }

        public static String getSubscriberId(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSubscriberId() --> ".concat(""));
            return "";
        }

        public static String getSubscriberIdForDeviceFinger(Context context) {
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSubscriberIdForDeviceFinger() --> ".concat(""));
            return "";
        }

        public static String[] getSuppportedABIs() {
            String[] strArr = a.i;
            if (strArr == null || strArr.length == 0) {
                a.i = Build.SUPPORTED_ABIS;
            }
            String[] strArr2 = a.i;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getSuppportedABIs() --> ".concat(String.valueOf(strArr2)));
            return strArr2;
        }

        public static String getUserAgent(Context context) {
            String strJad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, 1000L);
            jad_an.jad_an(strJad_an, "getUserAgent() --> ", CoreInfo.TAG);
            return strJad_an;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0018  */
        public static String getWifiBSSID(Context context) {
            String bssid;
            WifiInfo wifiInfoF = a.f(context);
            if (wifiInfoF != null) {
                bssid = wifiInfoF.getBSSID();
                if (TextUtils.isEmpty(bssid) || "02:00:00:00:00:00".equals(bssid)) {
                    bssid = "";
                }
            } else {
                bssid = "";
            }
            jad_an.jad_an(bssid, "getWifiBSSID() --> ", CoreInfo.TAG);
            return bssid;
        }

        public static List<String> getWifiBSSIDList(Context context) {
            List<String> listC = a.c(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiBSSIDList() --> ".concat(String.valueOf(listC)));
            return listC;
        }

        public static Map<String, String> getWifiBssidAndSsidMap(Context context) {
            HashMap map = new HashMap();
            List<ScanResult> listI = a.i(context);
            if (listI != null && !listI.isEmpty()) {
                for (ScanResult scanResult : listI) {
                    map.put(scanResult.BSSID, scanResult.SSID);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiBssidAndSsidMap() --> ".concat(String.valueOf(map)));
            return map;
        }

        public static WifiInfo getWifiInfo(Context context) {
            WifiInfo wifiInfoA = a.a(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiInfo() --> ".concat(String.valueOf(wifiInfoA)));
            if (!Logger.printStack) {
                Logger.d(CoreInfo.TAG, Logger.getStackTrace());
            }
            return wifiInfoA;
        }

        public static int getWifiLinkSpeed(Context context) {
            WifiInfo wifiInfoF = a.f(context);
            int linkSpeed = wifiInfoF != null ? wifiInfoF.getLinkSpeed() : -1;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiLinkSpeed() --> ".concat(String.valueOf(linkSpeed)));
            return linkSpeed;
        }

        public static List<String> getWifiList(Context context) {
            List<String> listC = a.c(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiList() --> ".concat(String.valueOf(listC)));
            return listC;
        }

        @Deprecated
        public static String getWifiMacAddress(Context context) {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_bo(context) : "";
        }

        @Deprecated
        public static String getWifiMacAddressForDeviceFinger(Context context) {
            return "";
        }

        @Deprecated
        public static String getWifiMacAddressOver23() {
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            return jad_boVar != null ? jad_boVar.jad_cp() : "";
        }

        public static int getWifiRssi(Context context) {
            WifiInfo wifiInfo;
            int rssi = (!TextUtils.equals(a.j(context), "wifi") || (wifiInfo = getWifiInfo(context)) == null) ? 0 : wifiInfo.getRssi();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiRssi() --> ".concat(String.valueOf(rssi)));
            return rssi;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0018  */
        public static String getWifiSSID(Context context) {
            String ssid;
            WifiInfo wifiInfoF = a.f(context);
            if (wifiInfoF != null) {
                ssid = wifiInfoF.getSSID();
                if (TextUtils.isEmpty(ssid) || "<unknown ssid>".equals(ssid)) {
                    ssid = "";
                }
            } else {
                ssid = "";
            }
            jad_an.jad_an(ssid, "getWifiSSID() --> ", CoreInfo.TAG);
            return ssid;
        }

        public static List<String> getWifiSSIDList(Context context) {
            ArrayList arrayList = new ArrayList();
            List<ScanResult> listI = a.i(context);
            if (listI != null && !listI.isEmpty()) {
                Iterator<ScanResult> it = listI.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().SSID);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiSSIDList() --> ".concat(String.valueOf(arrayList)));
            return arrayList;
        }

        public static List<ScanResult> getWifiScanResultList(Context context) {
            List<ScanResult> listB = a.b(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "getWifiScanResultList() --> ".concat(String.valueOf(listB)));
            if (!Logger.printStack) {
                Logger.d(CoreInfo.TAG, Logger.getStackTrace());
            }
            return listB;
        }

        public static boolean isBluetoothAvailabel() {
            if (!a.D) {
                a.C = BluetoothAdapter.getDefaultAdapter() != null;
                a.D = true;
            }
            boolean z = a.C;
            Logger.debugWithStackTrace(CoreInfo.TAG, "isBluetoothAvailabel() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isBluetoothEnabled() {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            boolean z = defaultAdapter != null && defaultAdapter.isEnabled();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isBluetoothEnabled() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isFingerprintAvailable(Context context) {
            boolean z;
            if (a.z) {
                z = a.y;
            } else {
                z = false;
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                } else {
                    FingerprintManager fingerprintManager = (FingerprintManager) context.getSystemService("fingerprint");
                    if (fingerprintManager != null) {
                        try {
                            a.y = fingerprintManager.isHardwareDetected();
                            a.z = true;
                            z = a.y;
                        } catch (Throwable th) {
                            Logger.e("Baseinfo.DeviceInfo", "An error occors when call isFingerprintAvailable()", th);
                        }
                    }
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isFingerprintAvailable() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isGPSAvailable(Context context) {
            boolean z;
            if (a.x) {
                z = a.w;
            } else {
                z = false;
                if (context == null) {
                    Logger.w("Baseinfo.DeviceInfo", "context is null");
                } else {
                    LocationManager locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager != null) {
                        List<String> allProviders = locationManager.getAllProviders();
                        if (allProviders != null && allProviders.contains("gps")) {
                            z = true;
                        }
                        a.w = z;
                        a.x = true;
                        z = a.w;
                    }
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isGPSAvailable() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isNFCAvailable(Context context) {
            boolean zH = a.h(context);
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNFCAvailable() --> ".concat(String.valueOf(zH)));
            return zH;
        }

        public static boolean isNFCEnabled(Context context) {
            NfcAdapter defaultAdapter;
            boolean z = a.h(context) && (defaultAdapter = ((NfcManager) context.getSystemService("nfc")).getDefaultAdapter()) != null && defaultAdapter.isEnabled();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isNFCEnabled() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isQEmuDriverFile() {
            boolean zA = a.a();
            Logger.debugWithStackTrace(CoreInfo.TAG, "isQEmuDriverFile() --> ".concat(String.valueOf(zA)));
            return zA;
        }

        public static boolean isRoot() {
            boolean z;
            boolean z2 = false;
            try {
                String[] strArr = a.E;
                int length = strArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    if (new File(strArr[i]).exists()) {
                        z = true;
                        break;
                    }
                    i++;
                }
                String str = Build.TAGS;
                if ((str != null && str.contains("test-keys")) || z) {
                    z2 = true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isRoot() --> ".concat(String.valueOf(z2)));
            return z2;
        }

        public static boolean isSensorAvailable(Context context, int i) {
            List<Sensor> sensorList;
            boolean z = false;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                if (sensorManager != null && (sensorList = sensorManager.getSensorList(i)) != null && sensorList.size() > 0) {
                    z = true;
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isSensorAvailable() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static boolean isStorageRemovable(Context context) {
            boolean z = false;
            if (context == null) {
                Logger.w("Baseinfo.DeviceInfo", "context is null");
            } else {
                try {
                    List<StorageVolume> storageVolumes = ((StorageManager) context.getSystemService("storage")).getStorageVolumes();
                    if (storageVolumes != null) {
                        for (StorageVolume storageVolume : storageVolumes) {
                            if (storageVolume.isRemovable() && storageVolume.getState().equals("mounted")) {
                                z = true;
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    Logger.e("Baseinfo.DeviceInfo", "An exception happends when call storageIsRemovable()", e);
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isStorageRemovable() --> ".concat(String.valueOf(z)));
            return z;
        }

        public static void setUserAgent(String str) {
            if (!TextUtils.isEmpty(str)) {
                com.jd.ad.sdk.jad_dq.jad_dq.jad_an = str;
            }
            jad_an.jad_an(str, "setUserAgent() --> ", CoreInfo.TAG);
        }

        public static String getUserAgent(Context context, long j) {
            String strJad_an = com.jd.ad.sdk.jad_dq.jad_dq.jad_an(context, j);
            jad_an.jad_an(strJad_an, "getUserAgent() --> ", CoreInfo.TAG);
            return strJad_an;
        }
    }

    public static class System {
        public static int getAndroidSDKVersion() {
            if (com.jd.ad.sdk.jad_an.jad_dq.jad_jt == 0) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_jt = Build.VERSION.SDK_INT;
            }
            int i = com.jd.ad.sdk.jad_an.jad_dq.jad_jt;
            Logger.debugWithStackTrace(CoreInfo.TAG, "getAndroidSDKVersion() --> ".concat(String.valueOf(i)));
            return i;
        }

        public static String getAndroidVersion() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_fs)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_fs = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.VERSION.RELEASE);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_fs;
            jad_an.jad_an(str, "getAndroidVersion() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getCountry(Context context) {
            Resources resources;
            Configuration configuration;
            LocaleList locales;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_iv) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && (locales = configuration.getLocales()) != null && locales.size() > 0) {
                    com.jd.ad.sdk.jad_an.jad_dq.jad_iv = locales.get(0).getCountry();
                }
            } catch (Exception unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_iv;
            jad_an.jad_an(str, "getCountry() --> ", CoreInfo.TAG);
            return str;
        }

        public static long getElapsedRealtime() {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getElapsedRealtime() --> ".concat(String.valueOf(jElapsedRealtime)));
            return jElapsedRealtime;
        }

        public static List<PackageInfo> getInstalledPkgs(Context context, int i) {
            jad_er.jad_an();
            jad_bo jad_boVar = CoreInfo.sensitiveApi;
            List<PackageInfo> listJad_cp = jad_boVar != null ? jad_boVar.jad_cp(context, i) : new ArrayList<>();
            Logger.debugWithStackTrace(CoreInfo.TAG, "getInstalledPkgs() --> ".concat(String.valueOf(listJad_cp)));
            return listJad_cp;
        }

        public static String getLanguage(Context context) {
            Resources resources;
            Configuration configuration;
            LocaleList locales;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_jw) && context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && (locales = configuration.getLocales()) != null && locales.size() > 0) {
                    com.jd.ad.sdk.jad_an.jad_dq.jad_jw = locales.get(0).getLanguage();
                }
            } catch (Exception unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_jw;
            jad_an.jad_an(str, "getLanguage() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSFingerprint() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_dq)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_dq = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.FINGERPRINT);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_dq;
            jad_an.jad_an(str, "getOSFingerprint() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSName() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_an)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_an = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.DISPLAY);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_an;
            jad_an.jad_an(str, "getOSName() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSVersionTags() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_cp)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_cp = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.TAGS);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_cp;
            jad_an.jad_an(str, "getOSVersionTags() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getOSVersionType() {
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_bo)) {
                com.jd.ad.sdk.jad_an.jad_dq.jad_bo = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(Build.TYPE);
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_bo;
            jad_an.jad_an(str, "getOSVersionType() --> ", CoreInfo.TAG);
            return str;
        }

        public static String getRomName() {
            StringBuilder sbAppend;
            String str;
            String strValueOf;
            String str2;
            StringBuilder sb;
            if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_er)) {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo)) {
                    String strJad_an = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.miui.ui.version.name");
                    if (TextUtils.isEmpty(strJad_an) || "".equals(strJad_an)) {
                        String strJad_an2 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.version.emui");
                        if (TextUtils.isEmpty(strJad_an2) || "".equals(strJad_an2)) {
                            String strJad_an3 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lenovo.series");
                            if (TextUtils.isEmpty(strJad_an3) || "".equals(strJad_an3)) {
                                String strJad_an4 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.nubia.rom.name");
                                if (TextUtils.isEmpty(strJad_an4) || "".equals(strJad_an4)) {
                                    String strJad_an5 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.meizu.product.model");
                                    if (TextUtils.isEmpty(strJad_an5) || "".equals(strJad_an5)) {
                                        String strJad_an6 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.version.opporom");
                                        if (TextUtils.isEmpty(strJad_an6) || "".equals(strJad_an6)) {
                                            String strJad_an7 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.vivo.os.build.display.id");
                                            if (TextUtils.isEmpty(strJad_an7) || "".equals(strJad_an7)) {
                                                String strJad_an8 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.aa.romver");
                                                if (TextUtils.isEmpty(strJad_an8) || "".equals(strJad_an8)) {
                                                    String strJad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.lewa.version");
                                                    if (TextUtils.isEmpty(strJad_an9) || "".equals(strJad_an9)) {
                                                        strJad_an9 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.gn.gnromvernumber");
                                                        if (TextUtils.isEmpty(strJad_an9) || "".equals(strJad_an9)) {
                                                            String strJad_an10 = com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.tyd.kbstyle_version");
                                                            if (TextUtils.isEmpty(strJad_an10) || "".equals(strJad_an10)) {
                                                                sbAppend = new StringBuilder().append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an("ro.build.fingerprint")).append("/");
                                                                str = "ro.build.rom.moduleID";
                                                            } else {
                                                                strValueOf = String.valueOf(strJad_an10);
                                                                str2 = "dido/";
                                                            }
                                                        } else {
                                                            sb = new StringBuilder("amigo/");
                                                        }
                                                    } else {
                                                        sb = new StringBuilder("tcl/");
                                                    }
                                                    sbAppend = sb.append(strJad_an9).append("/");
                                                } else {
                                                    sbAppend = new StringBuilder("htc/").append(strJad_an8).append("/");
                                                    str = "ro.build.description";
                                                }
                                            } else {
                                                strValueOf = String.valueOf(strJad_an7);
                                                str2 = "vivo/FUNTOUCH/";
                                            }
                                        } else {
                                            strValueOf = String.valueOf(strJad_an6);
                                            str2 = "Oppo/COLOROS/";
                                        }
                                    } else {
                                        sbAppend = new StringBuilder("Meizu/FLYME/");
                                    }
                                    str = "ro.build.display.id";
                                } else {
                                    sbAppend = new StringBuilder("Zte/NUBIA/").append(strJad_an4).append("_");
                                    str = "ro.build.nubia.rom.code";
                                }
                            } else {
                                sbAppend = new StringBuilder("Lenovo/VIBE/");
                                str = "ro.build.version.incremental";
                            }
                            com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = sbAppend.append(com.jd.ad.sdk.jad_dq.jad_cp.jad_an(str)).toString();
                        } else {
                            strValueOf = String.valueOf(strJad_an2);
                            str2 = "HuaWei/EMOTION/";
                        }
                    } else {
                        strValueOf = String.valueOf(strJad_an);
                        str2 = "XiaoMi/MIUI/";
                    }
                    com.jd.ad.sdk.jad_dq.jad_cp.jad_bo = str2.concat(strValueOf);
                }
                com.jd.ad.sdk.jad_an.jad_dq.jad_er = com.jd.ad.sdk.jad_lo.jad_bo.jad_an(com.jd.ad.sdk.jad_dq.jad_cp.jad_bo);
            }
            String str3 = com.jd.ad.sdk.jad_an.jad_dq.jad_er;
            jad_an.jad_an(str3, "getRomName() --> ", CoreInfo.TAG);
            return str3;
        }

        public static String getTimeZoneID() {
            TimeZone timeZone;
            try {
                if (TextUtils.isEmpty(com.jd.ad.sdk.jad_an.jad_dq.jad_hu) && (timeZone = TimeZone.getDefault()) != null) {
                    com.jd.ad.sdk.jad_an.jad_dq.jad_hu = timeZone.getID();
                }
            } catch (Throwable unused) {
            }
            String str = com.jd.ad.sdk.jad_an.jad_dq.jad_hu;
            jad_an.jad_an(str, "getTimeZoneID() --> ", CoreInfo.TAG);
            return str;
        }

        public static boolean isPkgInstalled(Context context, String str) {
            PackageInfo packageInfo;
            jad_er.jad_an();
            boolean z = false;
            if (context == null || TextUtils.isEmpty(str)) {
                Logger.e("PackageInfoUtil", "isPackageInstalled parameter error!");
            } else {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                } catch (PackageManager.NameNotFoundException unused) {
                    packageInfo = null;
                } catch (Throwable th) {
                    th.printStackTrace();
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    z = true;
                }
            }
            Logger.debugWithStackTrace(CoreInfo.TAG, "isPkgInstalled() --> ".concat(String.valueOf(z)));
            return z;
        }
    }
}
