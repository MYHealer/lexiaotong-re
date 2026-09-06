package com.hihonor.hianalytics.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.hihonor.hianalytics.hnha.j2;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j {

    private static class a extends Exception {
        a(String str) {
            super(str);
        }
    }

    private static Object a(Class cls, String str, Class[] clsArr, Object[] objArr) throws a {
        String str2;
        if (cls == null) {
            throw new a("class is null in invokeStaticFun");
        }
        if (clsArr == null) {
            if (objArr != null) {
                throw new a("paramsType is null, but params is not null");
            }
        } else {
            if (objArr == null) {
                throw new a("paramsType or params should be same");
            }
            if (clsArr.length != objArr.length) {
                throw new a("paramsType len:" + clsArr.length + " should equal params.len:" + objArr.length);
            }
        }
        try {
            try {
                return cls.getMethod(str, clsArr).invoke(null, objArr);
            } catch (IllegalAccessException unused) {
                str2 = "invokeStaticFun2 method invoke Exception!";
                j2.g("HiAnalyticsStreamUtil", str2);
                return null;
            } catch (IllegalArgumentException unused2) {
                str2 = "invokeStaticFun2 Illegal Argument!";
                j2.g("HiAnalyticsStreamUtil", str2);
                return null;
            } catch (InvocationTargetException unused3) {
                str2 = "invokeStaticFun2 Invocation Target Exception!";
                j2.g("HiAnalyticsStreamUtil", str2);
                return null;
            }
        } catch (NoSuchMethodException unused4) {
            j2.g("HiAnalyticsStreamUtil", "invokeStaticFun2 cls.getMethod(),No Such Method !");
        }
    }

    private static Object a(String str, String str2, Class[] clsArr, Object[] objArr) {
        String str3;
        try {
            return a(Class.forName(str), str2, clsArr, objArr);
        } catch (a unused) {
            str3 = "invokeStaticFun Static function call Exception ";
            j2.g("HiAnalyticsStreamUtil", str3);
            return null;
        } catch (ClassNotFoundException unused2) {
            str3 = "invokeStaticFun Not found class!";
            j2.g("HiAnalyticsStreamUtil", str3);
            return null;
        }
    }

    public static String a() throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        String strA = "";
        if (context == null) {
            j2.c("HiAnalyticsStreamUtil", "getNetworkType context null");
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    j2.c("HiAnalyticsStreamUtil", "getNetworkType illegalNetworkInfo=" + activeNetworkInfo);
                } else {
                    j2.a("HiAnalyticsStreamUtil", "getNetworkType netType=" + activeNetworkInfo.getType());
                    if (activeNetworkInfo.getType() == 1) {
                        strA = "WIFI";
                    } else if (activeNetworkInfo.getType() == 0) {
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        int subtype = activeNetworkInfo.getSubtype();
                        j2.c("HiAnalyticsStreamUtil", "getNetworkType strSubTypeName=" + subtypeName + ",networkType=" + subtype);
                        strA = a(subtype, subtypeName);
                    } else if (activeNetworkInfo.getType() == 16) {
                        strA = "COMPANION_PROXY";
                    } else {
                        strA = activeNetworkInfo.getType() == 9 ? "ETHERNET" : "OTHER_NETWORK_TYPE";
                    }
                }
            }
        } catch (Throwable th) {
            j2.c("HiAnalyticsStreamUtil", "getNetworkType failE=" + SystemUtils.getDesensitizedException(th));
        }
        return strA;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0025 A[ORIG_RETURN, RETURN] */
    private static String a(int i, String str) {
        switch (i) {
            case 0:
                return "UNKNOWN";
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3G";
            case 13:
                return "4G";
            default:
                if (str.equalsIgnoreCase("TD-SCDMA") || str.equalsIgnoreCase("WCDMA") || str.equalsIgnoreCase("CDMA2000")) {
                    return "3G";
                }
                return str;
        }
    }

    public static String a(InputStream inputStream, int i) throws IOException {
        c cVar = new c(i);
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                break;
            }
            cVar.a(bArr, i2);
        }
        return cVar.b() == 0 ? "" : new String(cVar.a(), "UTF-8");
    }

    public static String a(String str, String str2) {
        return b(str, str2);
    }

    private static String a(String str, String str2, String str3) {
        Object objA = a(str, "get", new Class[]{String.class, String.class}, new Object[]{str2, str3});
        return objA != null ? (String) objA : str3;
    }

    public static String b() {
        StringBuilder sb;
        String strA = a("com.hihonor.android.os.SystemPropertiesEx", "ro.build.display.id", "");
        if (TextUtils.isEmpty(strA)) {
            strA = Build.DISPLAY;
            sb = new StringBuilder("getSystemRomVer emptyWithDisplayRomVer=");
        } else {
            sb = new StringBuilder("getSystemRomVer romVer= ");
        }
        j2.a("HiAnalyticsStreamUtil", sb.append(SystemUtils.a(strA)).toString());
        return strA;
    }

    public static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            j2.g("HiAnalyticsStreamUtil", "getSystemProperty illegalProperty=" + str);
            return str2;
        }
        String strA = a(CountryCodeBean.ANDRIOD_SYSTEMPROP, str, str2);
        return TextUtils.isEmpty(strA) ? a("com.hihonor.android.os.SystemPropertiesEx", str, str2) : strA;
    }
}
