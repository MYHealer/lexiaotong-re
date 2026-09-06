package com.yfanads.android.adx.service;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.hv.TTDownloadField;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.g;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.BuildConfig;
import com.yfanads.android.adx.CustomController;
import com.yfanads.android.adx.components.base.e;
import com.yfanads.android.libs.thirdpart.gson.GsonBuilder;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.oaid.utils.RomUtils;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: PhoneService.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c {
    public static String H = "";
    public String A;
    public boolean B;
    public String C;
    public long D;
    public long E;
    public long F;
    public long G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f9617a;
    public String b;
    public int c;
    public int d;
    public String e;
    public float f;
    public int g;
    public String h;
    public String i;
    public int j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public volatile String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public int[] y = {0, 0};
    public String z;

    /* JADX INFO: compiled from: PhoneService.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9618a = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.yfanads.android.adx.utils.a.a("startIPV6Service start");
        HashMap map = new HashMap();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces != null && networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                try {
                    if (networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isVirtual()) {
                        Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                        ArrayList arrayList = new ArrayList();
                        while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                            InetAddress inetAddressNextElement = inetAddresses.nextElement();
                            if ((inetAddressNextElement instanceof Inet6Address) && !inetAddressNextElement.isAnyLocalAddress() && !inetAddressNextElement.isLinkLocalAddress() && !inetAddressNextElement.isLoopbackAddress()) {
                                String hostAddress = inetAddressNextElement.getHostAddress();
                                int iIndexOf = hostAddress.indexOf(37);
                                if (iIndexOf > 0) {
                                    hostAddress = hostAddress.substring(0, iIndexOf);
                                }
                                arrayList.add(hostAddress);
                            }
                        }
                        String name = networkInterfaceNextElement.getName();
                        if (!TextUtils.isEmpty(name) && !arrayList.isEmpty()) {
                            map.put(name, arrayList);
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }
            }
        } catch (SocketException unused) {
        }
        if (map.isEmpty()) {
            com.yfanads.android.adx.utils.a.a("startIPV6Service empty end");
            return;
        }
        String json = new GsonBuilder().create().toJson(map);
        if (!TextUtils.isEmpty(json)) {
            this.q = com.yfanads.android.adx.utils.b.a(Base64.encodeToString(json.getBytes(), 0));
        }
        com.yfanads.android.adx.utils.a.a("startIPV6Service end " + this.q);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x0157 A[Catch: all -> 0x018b, TryCatch #4 {all -> 0x018b, blocks: (B:57:0x014b, B:59:0x0157, B:60:0x0175), top: B:110:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0175 A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #4 {all -> 0x018b, blocks: (B:57:0x014b, B:59:0x0157, B:60:0x0175), top: B:110:0x014b }] */
    /* JADX WARN: Code duplicated, block: B:80:0x024e  */
    /* JADX WARN: Code duplicated, block: B:81:0x0252  */
    /* JADX WARN: Code duplicated, block: B:83:0x0256  */
    /* JADX WARN: Code duplicated, block: B:86:0x0260  */
    /* JADX WARN: Code duplicated, block: B:89:0x026d  */
    /* JADX WARN: Code duplicated, block: B:92:0x027d A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:93:0x0281  */
    public final void a(Context context, AdxSdkConfig adxSdkConfig) {
        String strTrim;
        CustomController customController;
        Object obj;
        int i;
        StructStat structStatStat;
        CustomController customController2;
        com.yfanads.android.adx.utils.a.a("init start");
        Locale locale = context.getResources().getConfiguration().locale;
        this.f9617a = locale != null ? locale.getCountry() : "CN";
        this.b = locale != null ? locale.getLanguage() : "zh";
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        this.c = point.x;
        this.d = point.y;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.f = displayMetrics.density;
        this.g = displayMetrics.densityDpi;
        this.y = new int[]{ScreenUtil.getScreenWidth(context) / 2, ScreenUtil.getScreenHeight(context) / 2};
        try {
            this.C = String.format("%.1f", Double.valueOf(Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d))));
        } catch (Exception e) {
            e.a(e, new StringBuilder("initSize deviceScreenSize error "));
        }
        this.h = Build.BRAND.trim();
        this.i = Build.MODEL.trim();
        this.j = Build.VERSION.SDK_INT;
        this.k = String.valueOf(Build.VERSION.RELEASE);
        String strValueOf = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        this.m = strValueOf;
        this.l = strValueOf;
        String str = "";
        try {
            try {
                try {
                    try {
                        if (adxSdkConfig == null || (customController2 = adxSdkConfig.customController) == null || customController2.canBootMark()) {
                            try {
                                File file = new File("/proc/sys/kernel/random/boot_id");
                                if (file.exists()) {
                                    FileInputStream fileInputStream = null;
                                    try {
                                        FileInputStream fileInputStream2 = new FileInputStream(file);
                                        try {
                                            strTrim = new BufferedReader(new InputStreamReader(fileInputStream2)).readLine().trim();
                                            try {
                                                strTrim = strTrim.substring(0, 36);
                                            } catch (Throwable unused) {
                                            }
                                            try {
                                                try {
                                                    fileInputStream2.close();
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    e.printStackTrace();
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                com.yfanads.android.adx.utils.a.b("getBootMark exception " + th.getMessage());
                                            }
                                        } catch (IOException unused2) {
                                            fileInputStream = fileInputStream2;
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException e3) {
                                                    e = e3;
                                                    strTrim = "";
                                                    e.printStackTrace();
                                                }
                                            }
                                            strTrim = "";
                                            this.n = strTrim;
                                            i = Build.VERSION.SDK_INT;
                                            structStatStat = Os.stat("/data/data");
                                            if (i >= 27) {
                                                StructTimespec structTimespec = structStatStat.st_atim;
                                                str = structTimespec.tv_sec + "." + structTimespec.tv_nsec;
                                            } else {
                                                str = structStatStat.st_atime + ".0";
                                            }
                                            this.o = str;
                                            this.p = BuildConfig.VERSION_NAME;
                                            this.e = adxSdkConfig.appID;
                                            this.x = DeviceUtils.getClientId();
                                            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                                            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                                            activityManager.getMemoryInfo(memoryInfo);
                                            this.F = memoryInfo.totalMem;
                                            this.G = memoryInfo.availMem;
                                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                                            long blockSizeLong = statFs.getBlockSizeLong();
                                            long blockCountLong = statFs.getBlockCountLong();
                                            long availableBlocksLong = statFs.getAvailableBlocksLong();
                                            this.D = blockCountLong * blockSizeLong;
                                            this.E = blockSizeLong * availableBlocksLong;
                                            H = "Mozilla/5.0 (Linux; Android " + this.k + "; " + this.i + " Build/" + Build.ID + "; wv) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 Mobile Safari/537.36";
                                            if (adxSdkConfig.isAutoListPackage) {
                                                c();
                                            } else {
                                                customController = adxSdkConfig.customController;
                                                if (customController == null) {
                                                    com.yfanads.android.adx.utils.a.c("initBusInfo has no hw permission");
                                                } else {
                                                    com.yfanads.android.adx.utils.a.c("initBusInfo has no hw permission");
                                                }
                                            }
                                            if (!TextUtils.isEmpty(adxSdkConfig.wxAppId)) {
                                                this.B = ReflectionUtils.hasMethod("com.tencent.mm.opensdk.openapi.IWXAPI");
                                            }
                                            if (YFListUtils.isMapEmpty(adxSdkConfig.extDefine)) {
                                                d();
                                            } else {
                                                d();
                                            }
                                            com.yfanads.android.adx.utils.a.a("init end");
                                        } catch (Throwable th2) {
                                            th = th2;
                                            fileInputStream = fileInputStream2;
                                            if (fileInputStream != null) {
                                                try {
                                                    fileInputStream.close();
                                                } catch (IOException e4) {
                                                    e4.printStackTrace();
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (IOException unused3) {
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                strTrim = "";
                            }
                            this.n = strTrim;
                            i = Build.VERSION.SDK_INT;
                            structStatStat = Os.stat("/data/data");
                            if (i >= 27) {
                                StructTimespec structTimespec2 = structStatStat.st_atim;
                                str = structTimespec2.tv_sec + "." + structTimespec2.tv_nsec;
                            } else {
                                str = structStatStat.st_atime + ".0";
                            }
                            this.o = str;
                            this.p = BuildConfig.VERSION_NAME;
                            this.e = adxSdkConfig.appID;
                            this.x = DeviceUtils.getClientId();
                            ActivityManager activityManager2 = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
                            ActivityManager.MemoryInfo memoryInfo2 = new ActivityManager.MemoryInfo();
                            activityManager2.getMemoryInfo(memoryInfo2);
                            this.F = memoryInfo2.totalMem;
                            this.G = memoryInfo2.availMem;
                            StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
                            long blockSizeLong2 = statFs2.getBlockSizeLong();
                            long blockCountLong2 = statFs2.getBlockCountLong();
                            long availableBlocksLong2 = statFs2.getAvailableBlocksLong();
                            this.D = blockCountLong2 * blockSizeLong2;
                            this.E = blockSizeLong2 * availableBlocksLong2;
                            H = "Mozilla/5.0 (Linux; Android " + this.k + "; " + this.i + " Build/" + Build.ID + "; wv) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 Mobile Safari/537.36";
                            if (adxSdkConfig.isAutoListPackage) {
                                c();
                            } else {
                                customController = adxSdkConfig.customController;
                                if (customController == null && customController.canUseAppList()) {
                                    c();
                                } else {
                                    com.yfanads.android.adx.utils.a.c("initBusInfo has no hw permission");
                                }
                            }
                            if (!TextUtils.isEmpty(adxSdkConfig.wxAppId)) {
                                this.B = ReflectionUtils.hasMethod("com.tencent.mm.opensdk.openapi.IWXAPI");
                            }
                            if (YFListUtils.isMapEmpty(adxSdkConfig.extDefine) || (obj = adxSdkConfig.extDefine.get("ipv6")) == null || ((Boolean) obj).booleanValue()) {
                                d();
                            }
                            com.yfanads.android.adx.utils.a.a("init end");
                        }
                        com.yfanads.android.adx.utils.a.d("getBootMark not, return.");
                        H = "Mozilla/5.0 (Linux; Android " + this.k + "; " + this.i + " Build/" + Build.ID + "; wv) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Chrome/118.0.0.0 Mobile Safari/537.36";
                    } catch (Exception e5) {
                        YFLog.error("initUA fail " + e5.getMessage());
                    }
                    i = Build.VERSION.SDK_INT;
                    structStatStat = Os.stat("/data/data");
                    if (i >= 27) {
                        StructTimespec structTimespec3 = structStatStat.st_atim;
                        str = structTimespec3.tv_sec + "." + structTimespec3.tv_nsec;
                    } else {
                        str = structStatStat.st_atime + ".0";
                    }
                } catch (Throwable th5) {
                    YFLog.error("getUpdateMark fail " + th5.getMessage());
                }
                StatFs statFs3 = new StatFs(Environment.getDataDirectory().getPath());
                long blockSizeLong3 = statFs3.getBlockSizeLong();
                long blockCountLong3 = statFs3.getBlockCountLong();
                long availableBlocksLong3 = statFs3.getAvailableBlocksLong();
                this.D = blockCountLong3 * blockSizeLong3;
                this.E = blockSizeLong3 * availableBlocksLong3;
            } catch (Exception e6) {
                e.a(e6, new StringBuilder("initSysDiskSize error "));
            }
            ActivityManager activityManager3 = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo3 = new ActivityManager.MemoryInfo();
            activityManager3.getMemoryInfo(memoryInfo3);
            this.F = memoryInfo3.totalMem;
            this.G = memoryInfo3.availMem;
        } catch (Exception e7) {
            e.a(e7, new StringBuilder("initSysMemSize error "));
        }
        strTrim = "";
        this.n = strTrim;
        this.o = str;
        this.p = BuildConfig.VERSION_NAME;
        this.e = adxSdkConfig.appID;
        this.x = DeviceUtils.getClientId();
        if (adxSdkConfig.isAutoListPackage) {
            c();
        } else {
            customController = adxSdkConfig.customController;
            if (customController == null) {
                com.yfanads.android.adx.utils.a.c("initBusInfo has no hw permission");
            } else {
                com.yfanads.android.adx.utils.a.c("initBusInfo has no hw permission");
            }
        }
        if (!TextUtils.isEmpty(adxSdkConfig.wxAppId)) {
            this.B = ReflectionUtils.hasMethod("com.tencent.mm.opensdk.openapi.IWXAPI");
        }
        if (YFListUtils.isMapEmpty(adxSdkConfig.extDefine)) {
            d();
        } else {
            d();
        }
        com.yfanads.android.adx.utils.a.a("init end");
    }

    public final void c() {
        try {
            if (!RomUtils.isOHuawei() && !RomUtils.isEmui()) {
                if (RomUtils.isVivo()) {
                    this.A = a(d.b, "com.bbk.appstore", 0);
                    return;
                }
                if (!RomUtils.isOppo() && !RomUtils.isOnePlus()) {
                    if (!RomUtils.isXiaomi() && !RomUtils.isMiui() && !RomUtils.isBlackShark()) {
                        if (RomUtils.isHonor()) {
                            this.A = a(d.b, "com.hihonor.appmarket", 0);
                            return;
                        }
                        return;
                    }
                    this.A = a(d.b, "com.xiaomi.market", 0);
                    return;
                }
                this.A = a(d.b, "com.oppo.market", 0);
                return;
            }
            this.z = a(d.b, "com.huawei.hwid", 128);
            this.A = a(d.b, x.af, 128);
        } catch (Exception e) {
            e.a(e, new StringBuilder("redAppStoreInfo error "));
        }
    }

    public final void d() {
        com.yfanads.android.adx.utils.b.f9622a.submit(new Runnable() { // from class: com.yfanads.android.adx.service.c$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    public final String b(Context context) {
        if (com.yfanads.android.adx.utils.b.a(context, "android.permission.READ_PHONE_STATE")) {
            if (TextUtils.isEmpty(this.t) && Build.VERSION.SDK_INT < 29) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    this.t = (String) telephonyManager.getClass().getMethod("getSubscriberId", new Class[0]).invoke(telephonyManager, null);
                } catch (Exception e) {
                    YFLog.error("invoke getImsi fail " + e.getMessage());
                }
            }
            String str = this.t;
            return str == null ? "" : str;
        }
        com.yfanads.android.adx.utils.a.d("imsi has no READ_PHONE_STATE");
        return "";
    }

    public static int c(Context context) {
        ServiceState serviceState;
        if (com.yfanads.android.adx.utils.b.a(context, g.b)) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            int type = activeNetworkInfo.getType();
            if (type == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 20) {
                    return 5;
                }
                switch (subtype) {
                    case 1:
                    case 2:
                        return 2;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        return 3;
                    default:
                        switch (subtype) {
                            case 12:
                                return 3;
                            case 13:
                            case 14:
                            case 15:
                                return 4;
                        }
                }
            }
            if (type == 1 || type == 6 || type == 9) {
                return 1;
            }
            if (type != 13 || Build.VERSION.SDK_INT < 29) {
                return -1;
            }
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
                ServiceState serviceState2 = null;
                if (defaultDataSubscriptionId == -1) {
                    if (com.yfanads.android.adx.utils.b.a(context, g.h)) {
                        serviceState = telephonyManager.getServiceState();
                        serviceState2 = serviceState;
                    }
                } else {
                    Object objA = com.yfanads.android.adx.utils.c.a(telephonyManager, new Class[]{Integer.TYPE}, Integer.valueOf(defaultDataSubscriptionId));
                    serviceState2 = objA instanceof ServiceState ? (ServiceState) objA : null;
                    if (serviceState2 == null && com.yfanads.android.adx.utils.b.a(context, g.h)) {
                        serviceState = telephonyManager.getServiceState();
                        serviceState2 = serviceState;
                    }
                }
                return (serviceState2 == null || !a(serviceState2.toString())) ? -1 : 5;
            } catch (Exception e) {
                e.a(e, new StringBuilder("adjustNetworkType "));
                return -1;
            }
        }
        com.yfanads.android.adx.utils.a.d("networkType has no ACCESS_NETWORK_STATE");
        return -1;
    }

    public static String a(Context context, String str, int i) {
        try {
            PackageInfo packageInfo = null;
            if (!TextUtils.isEmpty(str) && context != null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (packageManager != null) {
                        packageInfo = packageManager.getPackageInfo(str, i);
                    }
                } catch (Exception e) {
                    com.yfanads.android.adx.utils.a.b("ha no hms core " + e.getMessage());
                }
            }
            return packageInfo == null ? "" : String.valueOf(packageInfo.versionCode);
        } catch (Exception e2) {
            YFLog.error("getVersionCode fail " + e2.getMessage());
            return "";
        }
    }

    public final String a(Context context) {
        if (com.yfanads.android.adx.utils.b.a(context, "android.permission.READ_PHONE_STATE")) {
            if (TextUtils.isEmpty(this.s) && Build.VERSION.SDK_INT < 29) {
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    this.s = (String) telephonyManager.getClass().getMethod("getImei", new Class[0]).invoke(telephonyManager, null);
                } catch (Exception e) {
                    YFLog.error("invoke imei fail " + e.getMessage());
                }
            }
            String str = this.s;
            return str == null ? "" : str;
        }
        com.yfanads.android.adx.utils.a.d("imei has no READ_PHONE_STATE");
        return "";
    }

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    public static c a() {
        return a.f9618a;
    }
}
