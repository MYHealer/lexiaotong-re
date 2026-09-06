package com.adprof.sdk;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.hv.TTDownloadField;
import java.net.Inet6Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class g8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1187a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ConnectivityManager.NetworkCallback f308a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Network f309a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Display f310a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f312a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f314a;
    public static String b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static f8 f311a = f8.UNKNOWN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ArrayList f313a = new ArrayList();

    static {
        new HashMap();
        f314a = false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static ConnectivityManager m634a(Context context) {
        if (context != null) {
            return (ConnectivityManager) context.getSystemService("connectivity");
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static DisplayMetrics m635a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display displayM636a = m636a(context);
        if (displayM636a == null && context != null) {
            return context.getResources().getDisplayMetrics();
        }
        if (displayM636a != null) {
            displayM636a.getRealMetrics(displayMetrics);
        } else {
            try {
                Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(displayM636a, displayMetrics);
            } catch (Throwable unused) {
            }
        }
        return displayMetrics;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Display m636a(Context context) {
        if (f310a == null && context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            f310a = windowManager.getDefaultDisplay();
        }
        return f310a;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0011  */
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static f8 m637a(Context context) {
        TelephonyManager telephonyManager;
        NetworkInfo activeNetworkInfo;
        pk.a("getDataNetworkType ");
        if (context == null) {
            telephonyManager = null;
        } else {
            try {
                if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    telephonyManager = (TelephonyManager) context.getSystemService("phone");
                } else {
                    telephonyManager = null;
                }
            } catch (Throwable th) {
                pk.b("getTelephonyManager error: ", th);
            }
        }
        int dataNetworkType = telephonyManager != null ? telephonyManager.getDataNetworkType() : 0;
        ConnectivityManager connectivityManagerM634a = m634a(context);
        if (dataNetworkType == 0 && connectivityManagerM634a != null && (activeNetworkInfo = connectivityManagerM634a.getActiveNetworkInfo()) != null) {
            dataNetworkType = activeNetworkInfo.getSubtype();
        }
        pk.a("getDataNetworkType " + dataNetworkType);
        if (dataNetworkType == 20) {
            return f8.MOBILE_5G;
        }
        switch (dataNetworkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return f8.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return f8.MOBILE_3G;
            case 13:
                return f8.MOBILE_4G;
            default:
                return f8.MOBILE;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m638a(Context context) {
        try {
            if (!AdprofSdk.getInstance().isInit()) {
                return "";
            }
            pk.a("private :getIMEI");
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String imei = telephonyManager.getImei();
            if (TextUtils.isEmpty(imei)) {
                try {
                    return telephonyManager.getDeviceId();
                } catch (Throwable th) {
                    pk.b("getIMEI error1: ", th);
                    return telephonyManager.getMeid();
                }
            }
            if (imei != null) {
                return imei;
            }
        } catch (Throwable th2) {
            pk.c("getIMEI error: ", th2);
        }
        return null;
    }

    public static String a(Context context, int i) {
        try {
            if (!AdprofSdk.getInstance().isInit()) {
                return "";
            }
            pk.a("private :getIMEI " + i);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            String imei = telephonyManager.getImei(i);
            if (TextUtils.isEmpty(imei)) {
                try {
                    return telephonyManager.getDeviceId(i);
                } catch (Throwable th) {
                    pk.b("getIMEI idx: " + i + " error1: ", th);
                    return telephonyManager.getMeid(i);
                }
            }
            if (imei != null) {
                return imei;
            }
        } catch (Throwable th2) {
            pk.c("getIMEI idx: " + i + " error: ", th2);
        }
        return null;
    }

    public static String a(Inet6Address inet6Address) {
        byte[] address;
        if (inet6Address == null || (address = inet6Address.getAddress()) == null || address.length != 16) {
            return "";
        }
        StringBuilder sb = new StringBuilder(39);
        for (int i = 0; i < 16; i += 2) {
            int i2 = ((address[i] & 255) << 8) | (address[i + 1] & 255);
            if (i > 0) {
                sb.append(':');
            }
            sb.append(String.format(Locale.US, "%04x", Integer.valueOf(i2)));
        }
        return sb.toString();
    }

    public static boolean a() {
        if (!AdprofSdk.getInstance().isInit()) {
            return false;
        }
        boolean z = System.currentTimeMillis() - f1187a > 36000;
        if (z) {
            f1187a = System.currentTimeMillis();
        }
        pk.d("isCanRetryLocation status " + z);
        return z;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m640a(Context context) {
        boolean z = (context != null && context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.h) == 0) || (context != null && context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
        pk.a("isCanUseLocation status " + z);
        return z;
    }

    public static int a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        long memoryClass = activityManager.getMemoryClass();
        try {
            if ((context.getApplicationInfo().flags & ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null)) != 0) {
                String str = "getLargeMemoryClass";
                qh.a("getLargeMemoryClass");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                Class<?>[] clsArr = (Class[]) arrayList.toArray(new Class[arrayList.size()]);
                qh.a("getLargeMemoryClass");
                qh.a(clsArr);
                for (Class<?> superclass = activityManager.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    try {
                        memoryClass = ((Integer) superclass.getDeclaredMethod(str, clsArr).invoke(activityManager, arrayList2.toArray())).intValue();
                    } catch (Throwable unused) {
                    }
                }
                throw new NoSuchMethodException();
            }
        } catch (Throwable th) {
            pk.a("Unable to reflectively determine large heap size.");
            pk.b("memoryCacheSizeBytes error: ", th);
        }
        return (int) Math.min(31457280L, (memoryClass / 8) * 1048576);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m639a(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f4712a) == 0) {
                Network activeNetwork = m634a(context).getActiveNetwork();
                if (activeNetwork == null || activeNetwork == f309a) {
                    NetworkCapabilities networkCapabilities2 = null;
                    for (int size = f313a.size() - 1; size >= 0; size--) {
                        networkCapabilities2 = m634a(context).getNetworkCapabilities((Network) f313a.get(size));
                        if (networkCapabilities2 != null) {
                            break;
                        }
                    }
                    networkCapabilities = networkCapabilities2;
                } else {
                    networkCapabilities = m634a(context).getNetworkCapabilities(activeNetwork);
                }
                if (networkCapabilities != null) {
                    networkCapabilities.hasCapability(16);
                    if (!networkCapabilities.hasTransport(1) && !networkCapabilities.hasTransport(0) && !networkCapabilities.hasTransport(3)) {
                        networkCapabilities.hasTransport(4);
                    }
                    f311a = (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(1)) ? f8.WIFI : (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(0)) ? m637a(context) : f8.UNKNOWN;
                }
            }
        } catch (Exception unused) {
        }
    }
}
