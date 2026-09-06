package com.huawei.hms.common.util;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f3992a = false;
    public static final String b = "Logger";
    public static final String c = "|";
    public static final int d = 8;
    public static final int e = 20;
    public static final String f = "dynamic-api_";

    public static /* synthetic */ class a {
    }

    public static class b extends Throwable {
        public static final long d = 7129050843360571879L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f3993a;
        public Throwable b;
        public Throwable c;

        public b(Throwable th) {
            this.c = th;
        }

        public /* synthetic */ b(Throwable th, a aVar) {
            this(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Throwable th) {
            this.b = th;
        }

        public void a(String str) {
            this.f3993a = str;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            Throwable th = this.b;
            if (th == this) {
                return null;
            }
            return th;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f3993a;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable th = this.c;
            if (th == null) {
                return "";
            }
            String name = th.getClass().getName();
            if (this.f3993a == null) {
                return name;
            }
            String str = name + ": ";
            return this.f3993a.startsWith(str) ? this.f3993a : str + this.f3993a;
        }
    }

    public static int a(int i, String str, String str2) {
        return Log.println(i, a(str), a(str2, 7));
    }

    public static String a(int i) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        StringBuilder sb = new StringBuilder();
        sb.append(Process.myPid()).append(x.A).append(Process.myTid()).append("|").append(stackTraceElement.getFileName()).append("|").append(stackTraceElement.getClassName()).append("|").append(stackTraceElement.getMethodName()).append("|").append(stackTraceElement.getLineNumber());
        return sb.toString();
    }

    public static String a(String str) {
        return f + str;
    }

    public static String a(String str, int i) {
        return !TextUtils.isEmpty(str) ? a(i) + "|" + str : a(i);
    }

    public static Throwable a(Throwable th) {
        if (isLoggable(3)) {
            return th;
        }
        a aVar = null;
        if (th == null) {
            return null;
        }
        int i = ((th instanceof IOException) || (th instanceof JSONException)) ? 8 : 20;
        b bVar = new b(th, aVar);
        StackTraceElement[] stackTrace = bVar.getStackTrace();
        if (stackTrace.length > i) {
            bVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i));
        } else {
            bVar.setStackTrace(stackTrace);
        }
        bVar.a(anonymizeMessage(th.getMessage()));
        Throwable cause = th.getCause();
        b bVar2 = bVar;
        while (cause != null) {
            b bVar3 = new b(cause, aVar);
            bVar3.a(anonymizeMessage(cause.getMessage()));
            bVar2.a(bVar3);
            cause = cause.getCause();
            bVar2 = bVar3;
        }
        return bVar;
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (i % 2 == 1) {
                charArray[i] = '*';
            }
        }
        return new String(charArray);
    }

    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(a(str), a(str2, 5), a(th));
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i) {
        return Log.isLoggable(f, i);
    }

    public static void println(int i, String str, Object obj) {
        if (i >= 3 && isLoggable(i)) {
            a(i, str, obj == null ? "null" : obj.toString());
        }
    }

    public static void println(int i, String str, String str2, Object... objArr) {
        if (i < 3) {
            return;
        }
        if (str2 == null) {
            Log.w(b, "format is null, not log");
            return;
        }
        try {
            if (isLoggable(i)) {
                a(i, str, format(str2, objArr));
            }
        } catch (IllegalFormatException e2) {
            w(b, "log format error" + str2, e2);
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Throwable th) {
        Log.w(a(str), a(str2, 5), a(th));
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
