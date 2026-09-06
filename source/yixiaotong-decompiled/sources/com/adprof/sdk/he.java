package com.adprof.sdk;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.adprof.sdk.api.CustomController;
import com.stub.StubApp;
import com.yfanads.android.adx.thirdpart.filedownload.model.FileDownloadStatus;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class he {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static CustomController f344a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile he f345a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static boolean f348b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Location f351a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f353a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f354a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f355b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f356c;
    public String d;
    public String e;
    public String f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final AtomicInteger f346a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static long f347b = 0;
    public static String g = "";
    public static long c = 0;
    public static String h = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f1211a = -1;
    public static int b = -1;

    public static int a() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            atomicInteger = f346a;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    public static PackageInfo a(Context context, String str) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, 0);
        } catch (Throwable th) {
            pk.b("getPackageInfoWithUri error: ", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static he m644a() {
        if (f345a == null) {
            synchronized (he.class) {
                if (f345a == null) {
                    f345a = new he();
                }
            }
        }
        if (AdprofSdk.getInstance() != null && AdprofSdk.getInstance().getSdkConfig() != null) {
            f344a = AdprofSdk.getInstance().getSdkConfig().customController;
        }
        return f345a;
    }

    public static int b() {
        int i;
        int i2 = b;
        if (i2 != -1) {
            return i2;
        }
        CustomController customControllerA = z6.a();
        if (customControllerA != null && !customControllerA.canUseCarrier()) {
            return b;
        }
        try {
            pk.d("MetadataInfo  getCarrier");
            String simOperator = ((TelephonyManager) AdprofSdk.getInstance().getContext().getSystemService("phone")).getSimOperator();
            if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator) || "46008".equals(simOperator)) {
                i = 1;
            } else if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                i = 2;
            } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                i = 3;
            } else {
                i = "46020".equals(simOperator) ? 4 : 0;
            }
            b = i;
            return i;
        } catch (Throwable th) {
            pk.b("getCarrier error: ", th);
            return 0;
        }
    }

    public static String d() {
        String hostAddress;
        if (System.currentTimeMillis() - f347b < 300000) {
            return g;
        }
        f347b = System.currentTimeMillis();
        String str = g8.f312a;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        hostAddress = inetAddressNextElement.getHostAddress();
                        g = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable th) {
            pk.b("getCell_ip error: ", th);
        }
        hostAddress = "0.0.0.0";
        g = hostAddress;
        return hostAddress;
    }

    /* JADX WARN: Code duplicated, block: B:79:0x00fc A[PHI: r0
  0x00fc: PHI (r0v6 java.util.ArrayList) = (r0v5 java.util.ArrayList), (r0v10 java.util.ArrayList) binds: [B:52:0x00a2, B:77:0x00f7] A[DONT_GENERATE, DONT_INLINE]] */
    public static String e() {
        String str;
        Inet6Address inet6Address;
        byte[] address;
        if (System.currentTimeMillis() - c < 300000) {
            return h;
        }
        c = System.currentTimeMillis();
        String str2 = g8.f312a;
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && networkInterfaceNextElement.isUp() && !networkInterfaceNextElement.isLoopback()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if ((inetAddressNextElement instanceof Inet6Address) && (inet6Address = (Inet6Address) inetAddressNextElement) != null && !inet6Address.isAnyLocalAddress() && !inet6Address.isLoopbackAddress() && !inet6Address.isLinkLocalAddress() && !inet6Address.isSiteLocalAddress() && !inet6Address.isMulticastAddress() && (address = inet6Address.getAddress()) != null && address.length != 0 && (address[0] & FileDownloadStatus.paused) != 252) {
                            String strA = g8.a(inet6Address);
                            if (TextUtils.isEmpty(strA)) {
                                continue;
                            } else {
                                arrayList.add(strA);
                            }
                        }
                    }
                }
            }
        } catch (SocketException e) {
            pk.b("getPublicIPv6Addresses error: ", e);
        }
        if (arrayList.isEmpty()) {
            arrayList = new ArrayList();
            try {
                Enumeration<NetworkInterface> networkInterfaces2 = NetworkInterface.getNetworkInterfaces();
                while (networkInterfaces2.hasMoreElements()) {
                    NetworkInterface networkInterfaceNextElement2 = networkInterfaces2.nextElement();
                    if (networkInterfaceNextElement2 != null && networkInterfaceNextElement2.isUp() && !networkInterfaceNextElement2.isLoopback()) {
                        Enumeration<InetAddress> inetAddresses2 = networkInterfaceNextElement2.getInetAddresses();
                        while (inetAddresses2.hasMoreElements()) {
                            InetAddress inetAddressNextElement2 = inetAddresses2.nextElement();
                            if (inetAddressNextElement2 instanceof Inet6Address) {
                                String strA2 = g8.a((Inet6Address) inetAddressNextElement2);
                                if (TextUtils.isEmpty(strA2)) {
                                    continue;
                                } else {
                                    arrayList.add(strA2);
                                }
                            }
                        }
                    }
                }
            } catch (SocketException e2) {
                pk.b("getCell_ipv6 error: ", e2);
            }
            if (arrayList.isEmpty()) {
                str = "";
            } else {
                str = (String) arrayList.get(0);
            }
        } else {
            str = (String) arrayList.get(0);
        }
        h = str;
        return str;
    }

    public static String h() {
        String str = g8.f312a;
        try {
            if (!TextUtils.isEmpty(g8.f312a)) {
                return g8.f312a;
            }
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    g8.f312a = sb.toString();
                }
            }
            return "";
        } catch (Throwable th) {
            pk.b("getMacAddress error: ", th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public Location m645a() {
        LocationManager locationManagerM646a;
        try {
            Location location = this.f351a;
            if (location != null) {
                return location;
            }
            CustomController customController = f344a;
            if (customController != null && customController.getLocation() != null) {
                Location location2 = f344a.getLocation();
                this.f351a = location2;
                return location2;
            }
            CustomController customController2 = f344a;
            if (customController2 != null && !customController2.canReadLocation()) {
                return null;
            }
            if (g8.a() && (locationManagerM646a = m646a()) != null) {
                pk.a("private :use_location ");
                Location lastKnownLocation = locationManagerM646a.getLastKnownLocation("passive");
                if (lastKnownLocation != null) {
                    this.f351a = lastKnownLocation;
                }
            }
            return this.f351a;
        } catch (Throwable th) {
            pk.b("getLocation error: ", th);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public LocationManager m646a() {
        try {
            if (g8.m640a(this.f350a)) {
                return (LocationManager) this.f350a.getSystemService("location");
            }
            return null;
        } catch (Throwable th) {
            pk.b("getLocationManager error: ", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m647a() {
        CustomController customController = f344a;
        if (customController != null && !TextUtils.isEmpty(customController.getAndroidId())) {
            return f344a.getAndroidId();
        }
        CustomController customController2 = f344a;
        if (customController2 == null || !customController2.canUseAndroidId()) {
            return "";
        }
        Context context = this.f350a;
        String str = g8.f312a;
        if (!AdprofSdk.getInstance().isInit()) {
            return "";
        }
        if (g8.b == null && context != null) {
            try {
                g8.b = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                g8.b = "";
                pk.b("getAndroidId error: ", th);
            }
        }
        return g8.b;
    }

    public synchronized String a(int i) {
        try {
            if (!TextUtils.isEmpty(this.f352a)) {
                return this.f352a;
            }
            CustomController customController = f344a;
            if (customController != null && !TextUtils.isEmpty(customController.getImei())) {
                String imei = f344a.getImei();
                this.f352a = imei;
                return imei;
            }
            if (TextUtils.isEmpty(this.f352a) && Build.VERSION.SDK_INT < 29) {
                CustomController customController2 = f344a;
                if (customController2 != null && !customController2.canUsePhoneState()) {
                    return "";
                }
                this.f352a = g8.m638a(this.f350a);
                this.f355b = g8.a(this.f350a, 0);
                this.f356c = g8.a(this.f350a, 1);
            }
            if (i == -1) {
                return this.f352a;
            }
            if (i == 0) {
                return this.f355b;
            }
            return this.f356c;
        } catch (Throwable th) {
            pk.b("getDeviceId:" + th.getMessage());
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public final void m649a() {
        try {
            pk.d("sp cache put = " + this.f353a);
            sl.a("metadata_list", g1.a(TextUtils.join("-----", this.f353a), AdprofSdk.getInstance().getAppSecret()));
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m650b() {
        try {
            return r3.m713a(this.f350a);
        } catch (Throwable th) {
            pk.b("getAppPackageName error: ", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m651c() {
        PackageInfo packageInfoA;
        Context context = this.f350a;
        try {
            if (TextUtils.isEmpty(r3.b) && (packageInfoA = r3.a(context)) != null) {
                r3.b = packageInfoA.versionName;
            }
            return r3.b;
        } catch (Throwable th) {
            pk.a("Failed to retrieve PackageInfo#versionName.");
            pk.b("getAppVersionFromContext error: ", th);
            return null;
        }
    }

    public String f() {
        try {
            CustomController customControllerA = z6.a();
            if (customControllerA != null && !customControllerA.canUseImei()) {
                return "";
            }
            return a(-1);
        } catch (Throwable th) {
            pk.b("getDeviceId:" + th.getMessage());
            return null;
        }
    }

    public String g() {
        try {
            if (!TextUtils.isEmpty(this.f)) {
                return this.f;
            }
            PackageInfo packageInfo = AdprofSdk.getInstance().getContext().getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            this.f = packageInfo.versionName;
            int i = packageInfo.versionCode;
            Log.d("----AppGalleryVersion", "getHMSVersion Name: " + this.f);
            Log.d("----AppGalleryVersion", "getHMS Version Code: " + i);
            return this.f;
        } catch (Throwable unused) {
            return "";
        }
    }

    public String i() {
        String strJ;
        y6.a().getClass();
        y6.a().getClass();
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        if (!f348b) {
            return "";
        }
        String str = null;
        try {
            y6.a().getClass();
            strJ = Build.VERSION.SDK_INT > 28 ? j() : null;
        } catch (Throwable th) {
            pk.b("getOAID_SDK error: ", th);
        }
        if (TextUtils.isEmpty(strJ) && this.f354a) {
            try {
                if (Build.VERSION.SDK_INT > 28) {
                    y6.a().getClass();
                    TextUtils.isEmpty(null);
                }
            } catch (Throwable th2) {
                pk.b("getOAID_API error: ", th2);
            }
        } else {
            str = strJ;
        }
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase(this.d)) {
            return this.d;
        }
        this.d = str;
        return str;
    }

    public final String j() {
        if (!TextUtils.isEmpty(this.e)) {
            return this.e;
        }
        try {
            a8.a(StubApp.getOrigApplicationContext(this.f350a.getApplicationContext()), new fe(this));
        } catch (Throwable th) {
            pk.b("getOAIDSDK error:", th);
        }
        return this.e;
    }

    public static int c() {
        int i = f1211a;
        if (i != -1) {
            return i;
        }
        try {
            UiModeManager uiModeManager = (UiModeManager) AdprofSdk.getInstance().getContext().getSystemService("uimode");
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                f1211a = 3;
                return 3;
            }
        } catch (Throwable unused) {
        }
        Context context = AdprofSdk.getInstance().getContext();
        String str = g8.f312a;
        f1211a = (context == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? 2 : 1;
        return f1211a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public List m648a() {
        int i;
        PackageInfo packageInfo;
        try {
            if (!this.f353a.isEmpty()) {
                return this.f353a;
            }
            ArrayList arrayList = d1.f1121a.a().f209a;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f353a.clear();
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    v0 v0Var = (v0) it.next();
                    String str = v0Var.b;
                    int i2 = q3.f1376a;
                    try {
                        packageInfo = AdprofSdk.getInstance().getContext().getPackageManager().getPackageInfo(str, 0);
                    } catch (Exception unused) {
                        packageInfo = null;
                    }
                    if (packageInfo != null) {
                        this.f353a.add(v0Var.b);
                    }
                }
                if (this.f353a.isEmpty()) {
                    String strA = g1.a(sl.a("metadata_list"), AdprofSdk.getInstance().getAppSecret(), false);
                    if (!TextUtils.isEmpty(strA)) {
                        String[] strArrSplit = strA.split("-----");
                        ArrayList arrayList2 = new ArrayList();
                        for (String str2 : strArrSplit) {
                            if (!TextUtils.isEmpty(str2)) {
                                pk.d("sp cache pkg = " + str2);
                                arrayList2.add(str2.trim());
                            }
                        }
                        return arrayList2;
                    }
                } else {
                    m649a();
                }
            }
            return this.f353a;
        } catch (Throwable th) {
            pk.a(th);
        }
    }

    public synchronized void a(Context context) {
        w1 w1Var;
        if (this.f350a == null) {
            this.f350a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.d = a8.a();
            pk.a("===OAID===  " + this.d);
            Context context2 = this.f350a;
            if (sk.f1425a == null) {
                synchronized (sk.class) {
                    if (sk.f1425a == null) {
                        sk.f1425a = new sk(context2);
                    }
                }
            }
            Context context3 = this.f350a;
            if (tk.f1443a == null) {
                synchronized (tk.class) {
                    if (tk.f1443a == null) {
                        tk.f1443a = new tk(context3);
                    }
                }
            }
            synchronized (w1.class) {
                if (w1.f1490a == null) {
                    w1.f1490a = new w1();
                }
                w1Var = w1.f1490a;
            }
            if (w1Var.f787a == null || w1Var.f788a == null) {
                SQLiteDatabase sQLiteDatabaseA = sk.f1425a.a();
                w1Var.f787a = sQLiteDatabaseA;
                if (sQLiteDatabaseA == null) {
                    pk.b("AdPointManager: Failed to get writable database");
                } else {
                    in.a().a(new t1(w1Var));
                    HandlerThread handlerThread = new HandlerThread("sendLog");
                    handlerThread.start();
                    s1 s1Var = new s1(w1Var, new Handler(handlerThread.getLooper()));
                    w1Var.f788a = s1Var;
                    y6.a().getClass();
                    s1Var.a(((long) 3) * 1000);
                }
            }
            Context context4 = this.f350a;
            if (g8.f314a) {
                pk.a("Network callback already registered, skipping...");
            } else {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).addTransportType(0).addTransportType(1).build();
                ConnectivityManager connectivityManagerM634a = g8.m634a(context4);
                if (connectivityManagerM634a != null) {
                    d8 d8Var = new d8(context4);
                    g8.f308a = d8Var;
                    try {
                        connectivityManagerM634a.registerNetworkCallback(networkRequestBuild, d8Var);
                        pk.a("Network callback registered successfully");
                    } catch (Throwable th) {
                        pk.b("Failed to register network callback: ", th);
                        g8.f308a = null;
                    }
                    g8.f314a = true;
                }
            }
            xn.f1525a.b();
            in.a().a(new ge(this));
            int iB = h8.b();
            int iM641a = h8.m641a();
            if (iB > iM641a) {
                pk.d("=====  width height value switch ======");
                h8.f332a = iM641a;
                h8.b = iB;
            }
        }
    }
}
