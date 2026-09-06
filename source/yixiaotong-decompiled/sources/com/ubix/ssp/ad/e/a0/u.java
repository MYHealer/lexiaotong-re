package com.ubix.ssp.ad.e.a0;

import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8731a = false;
    public static String b = "------UBiX_SSP: ";
    public static boolean c;
    public static boolean d;
    public static boolean e;

    private static synchronized String a(StackTraceElement[] stackTraceElementArr, String str) {
        return String.format("--->%s(L:%d)  %s", stackTraceElementArr[1].getMethodName(), Integer.valueOf(stackTraceElementArr[1].getLineNumber()), str);
    }

    public static void a(String str) {
        if (f8731a || e) {
            Log.d(b, a(new Throwable().getStackTrace(), str));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str));
        }
    }

    public static void a(String str, String str2) {
        if (f8731a || e) {
            Log.d(b + str, a(new Throwable().getStackTrace(), str2));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str2));
        }
    }

    public static boolean a() {
        return e || c;
    }

    public static void b() {
        try {
            StringBuilder sbAppend = new StringBuilder().append(k.d(c.e()).getPath());
            String str = File.separator;
            File file = new File(sbAppend.append(str).append("@logopen@").toString());
            File file2 = new File(k.d(c.e()).getPath() + str + "@logfullopen@");
            File file3 = new File(k.d(c.e()).getPath() + str + "@ulogopen@");
            if (file2.exists()) {
                System.out.println(b + " 强制开启log");
                c = true;
                d = true;
            } else if (file.exists()) {
                d = false;
                c = true;
            } else if (file3.exists()) {
                d = false;
                e = true;
            } else {
                c = false;
                d = false;
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        if (e) {
            Log.d(b, str);
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + str);
        }
    }

    public static void b(String str, String str2) {
        if (e) {
            Log.d(str, str2);
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + str2);
        }
    }

    public static void c(String str) {
        if (f8731a || e) {
            Log.e(b, a(new Throwable().getStackTrace(), str));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str));
        }
    }

    public static void c(String str, String str2) {
        if (f8731a || e) {
            Log.e(b + str, a(new Throwable().getStackTrace(), str2));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str2));
        }
    }

    public static void d(String str) {
        if (e) {
            Log.e(b, str);
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + str);
        }
    }

    public static void d(String str, String str2) {
        if (e) {
            Log.e(str, str2);
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + str + PPSLabelView.Code + str2);
        }
    }

    public static void e(String str) {
        if (f8731a || e) {
            Log.i(b, a(new Throwable().getStackTrace(), str));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str));
        }
    }

    public static void e(String str, String str2) {
        if (f8731a || e) {
            Log.i(b + str, a(new Throwable().getStackTrace(), str2));
        } else if (c) {
            System.out.println(b + PPSLabelView.Code + a(new Throwable().getStackTrace(), str2));
        }
    }

    public static void f(String str) {
        if (c || e) {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            while (str.length() > 2001) {
                Log.i(b + stackTrace[1].getClassName(), a(stackTrace, str.substring(0, 2001)));
                str = str.substring(2001);
            }
            if (c) {
                System.out.println(b + a(stackTrace, str));
            } else {
                Log.i(b, a(stackTrace, str));
            }
        }
    }
}
