package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.InvocationTargetException;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile int f5428a;
    public static volatile int b;
    public static volatile int c;
    public static volatile int d;
    public static volatile d9 e;
    public static volatile String f;
    public static volatile String g;
    public static String h = ijiami_1011.s.s.s.d(new byte[0], "a496e6");

    static {
        new SimpleDateFormat(ijiami_1011.s.s.s.d(new byte[]{74, Ascii.GS, 77, Ascii.US, 117, 117, 5, 0}, "3d4f88"));
    }

    public static int a() {
        try {
            return ((Integer) Class.forName(ijiami_1011.s.s.s.d(new byte[]{83, 95, 84, 65, 88, 15, 5, 74, 9, 17, Ascii.US, 54, 75, 66, 68, 86, 90, 54, 19, 11, Ascii.SYN, 7, 67, 17, 91, 84, 67}, "21037f")).getMethod(ijiami_1011.s.s.s.d(new byte[]{84, 1, Ascii.NAK, 45, 95, 66}, "3dad16"), String.class, Integer.TYPE).invoke(null, ijiami_1011.s.s.s.d(new byte[]{70, 85, 17, 74, 95, 65, Ascii.NAK, 74, Ascii.NAK, Ascii.ESC, 66, 75, 91, 69, 10, 85, 66, 86, 8, Ascii.ETB, Ascii.SYN, 14, 80, Ascii.FS, 105, 68, 26, 73, 83}, "60c962"), 0)).intValue();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchMethodException e4) {
            e4.printStackTrace();
            return 0;
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public static int a(Context context, float f2) {
        return Math.round(f2 * context.getResources().getDisplayMetrics().density);
    }

    public static int a(Context context, String str) {
        PackageInfo packageInfoA = a(context, str, 0);
        if (packageInfoA == null) {
            return -1;
        }
        if (packageInfoA.applicationInfo.enabled) {
            return packageInfoA.versionCode;
        }
        return -2;
    }

    public static PackageInfo a(Context context, String str, int i) {
        try {
            return context.getPackageManager().getPackageInfo(str, i);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(Context context) {
        if (b.h(null)) {
            return "";
        }
        if (TextUtils.isEmpty(g)) {
            d9 d9VarE = e();
            g = d9VarE.f5408a.getString(ijiami_1011.s.s.s.d(new byte[]{86, 86, 2, Ascii.SYN, 12, 89, 5, 13, 2}, "78fdc0"), null);
            if (TextUtils.isEmpty(g)) {
                try {
                    g = Settings.Secure.getString(context.getContentResolver(), ijiami_1011.s.s.s.d(new byte[]{5, 15, 81, Ascii.ETB, 91, 94, 5, 59, 15, 6}, "da5e47"));
                    if (!TextUtils.isEmpty(g)) {
                        String strD = ijiami_1011.s.s.s.d(new byte[]{87, 13, 83, 16, 14, 91, 5, 13, 2}, "6c7ba2");
                        String str = g;
                        SharedPreferences.Editor editorEdit = d9VarE.f5408a.edit();
                        editorEdit.putString(strD, str);
                        editorEdit.apply();
                    }
                } catch (Exception unused) {
                }
            }
        }
        return g;
    }

    public static void a(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || activity.isFinishing() || activity.isDestroyed() || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility() | 5638;
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            activity.getWindow().setAttributes(attributes);
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        window.setFlags(1024, 1024);
    }

    public static float b(Context context, float f2) {
        return f2 / context.getResources().getDisplayMetrics().density;
    }

    public static int b(Context context) {
        synchronized (f9.class) {
            int identifier = context.getResources().getIdentifier(ijiami_1011.s.s.s.d(new byte[]{10, 89, 66, 91, 83, 85, Ascii.NAK, 13, 9, 12, 110, 7, 5, 74, 107, 90, 81, 93, 6, 12, Ascii.DC2}, "d84244"), ijiami_1011.s.s.s.d(new byte[]{85, 95, 15, 82, 8}, "16b7fd"), ijiami_1011.s.s.s.d(new byte[]{86, 93, 82, 17, 94, 11, 5}, "736c1b"));
            if (identifier > 0) {
                d = context.getResources().getDimensionPixelSize(identifier);
            }
        }
        return d;
    }

    public static String b() {
        byte[] hardwareAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                return null;
            }
            String strD = ijiami_1011.s.s.s.d(new byte[]{79, 85, 81, 88, 86}, "8906ff");
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && TextUtils.equals(strD, networkInterfaceNextElement.getName()) && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 2, 0, 57, 13}, "222a7b"), Byte.valueOf(b2)));
                    }
                    int length = sb.length();
                    if (length > 0) {
                        sb.deleteCharAt(length - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        PackageInfo packageInfoA = a(context, str, 0);
        return (packageInfoA == null || packageInfoA.applicationInfo == null) ? false : true;
    }

    public static int c(Context context) {
        if (b == 0 || a() == 2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 12, 10, 85, 14, 65}, "bed1a6"))).getDefaultDisplay().getRealMetrics(displayMetrics);
            b = Math.max(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        return b;
    }

    public static String c() {
        m.a(ijiami_1011.s.s.s.d(new byte[]{117, 10, 6, SignedBytes.MAX_POWER_OF_TWO, 94, 90, 5, 49, Ascii.DC2, 11, 93, Ascii.SYN}, "4db213"), ijiami_1011.s.s.s.d(new byte[]{19, 87, Ascii.FS, 85, 92, Ascii.DC4, 8, 74, 19, 11, Ascii.US, 19, 4, 74, 65, 81, 90, 15, 79, 10, 7, 15, 84, 69, 92, Ascii.CAN}, "a8285a") + b.b(ijiami_1011.s.s.s.d(new byte[]{66, 95, Ascii.ETB, 92, 93, 65, 8, 74, 19, 11, Ascii.US, 19, 85, 66, 74, 88, 91, 90, 79, 10, 7, 15, 84}, "009144"), ""));
        m.a(ijiami_1011.s.s.s.d(new byte[]{36, 95, 0, 68, 90, 10, 5, 49, Ascii.DC2, 11, 93, Ascii.SYN}, "e1d65c"), ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, 93, Ascii.CAN, 95, 10, 65, 8, 74, 19, 11, Ascii.US, 19, 87, SignedBytes.MAX_POWER_OF_TWO, 69, 91, 12, 90, 79, 7, 9, 6, 84, 69, 15, Ascii.DC2}, "2262c4") + b.b(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 88, 75, 94, 8, 67, 8, 74, 19, 11, Ascii.US, 19, 0, 69, Ascii.SYN, 90, 14, 88, 79, 7, 9, 6, 84}, "e7e3a6"), ""));
        return (b.b(ijiami_1011.s.s.s.d(new byte[]{17, 86, 72, 14, 80, 70, 8, 74, 19, 11, Ascii.US, 19, 6, 75, Ascii.NAK, 10, 86, 93, 79, 10, 7, 15, 84}, "c9fc93"), "") == null && b.b(ijiami_1011.s.s.s.d(new byte[]{75, 86, 79, 8, 89, 71, 8, 74, 19, 11, Ascii.US, 19, 92, 75, Ascii.DC2, 12, 95, 92, 79, 7, 9, 6, 84}, "99ae02"), "") == null) ? ijiami_1011.s.s.s.d(new byte[]{80, 8, 0, Ascii.SYN, 92, 93, 5}, "1fdd34") : ijiami_1011.s.s.s.d(new byte[]{77, 10, 7, 87, 85, 81}, "5cf888");
    }

    public static boolean c(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            if (launchIntentForPackage == null) {
                return false;
            }
            context.startActivity(launchIntentForPackage);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int d(Context context) {
        if (f5428a == 0 || a() == 2) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{19, 90, 13, 87, 11, Ascii.NAK}, "d3c3db"))).getDefaultDisplay().getRealMetrics(displayMetrics);
            f5428a = Math.min(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        return f5428a;
    }

    public static String d() {
        String strB = b.b(ijiami_1011.s.s.s.d(new byte[]{Ascii.DC4, 90, Ascii.EM, 95, 11, 66, 8, 74, Ascii.DC4, 7, 86, 12, 9, 91}, "f572b7"), "");
        try {
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
            Object objInvoke = Class.forName(ijiami_1011.s.s.s.d(new byte[]{89, 8, 82, Ascii.SYN, 14, 15, 5, 74, 9, 17, Ascii.US, 41, 87, 5, 87, 8, 4, 42, 8, Ascii.ETB, Ascii.DC2}, "8f6daf")).getMethod(ijiami_1011.s.s.s.d(new byte[]{86, 6, Ascii.NAK, 33, 86, 94, 0, 17, 10, Ascii.SYN}, "1cae38"), new Class[0]).invoke(null, new Object[0]);
            Object objInvoke2 = objInvoke.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{Ascii.NAK, 92, 67, 80}, "f5952c"), new Class[0]).invoke(objInvoke, new Object[0]);
            if ((objInvoke2 instanceof Integer) && ((Integer) objInvoke2).intValue() > 0) {
                Object objInvoke3 = objInvoke.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{1, 92, SignedBytes.MAX_POWER_OF_TWO}, "f94348"), Integer.TYPE).invoke(objInvoke, 0);
                Object objInvoke4 = objInvoke3.getClass().getMethod(ijiami_1011.s.s.s.d(new byte[]{1, 85, SignedBytes.MAX_POWER_OF_TWO, 37, 13, 17, 15, 16, Ascii.DC4, Ascii.ESC}, "f04fbd"), new Class[0]).invoke(objInvoke3, new Object[0]);
                if (objInvoke4 instanceof String) {
                    strB = (String) objInvoke4;
                }
            }
            return TextUtils.isEmpty(strB) ? Locale.getDefault().getCountry() : strB;
        } catch (Exception unused) {
            return strB;
        }
    }

    public static d9 e() {
        if (e == null) {
            synchronized (f9.class) {
                if (e == null) {
                    e = new d9(ijiami_1011.s.s.s.d(new byte[]{109, 92, 102, 71, 85, 81}, "219502"));
                }
            }
        }
        return e;
    }

    public static String f() {
        if (b.h(h)) {
            return h;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        try {
            h = WebSettings.getDefaultUserAgent(y8.f5752a);
        } catch (Exception unused) {
        }
        return h;
    }
}
