package com.jd.ad.sdk.logger;

import com.jd.ad.sdk.jad_kt.jad_bo;
import com.jd.ad.sdk.jad_kt.jad_dq;
import com.jd.ad.sdk.jad_kt.jad_fs;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class Logger {
    public static final int ASSERT = 7;
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;
    private static jad_fs printer = new jad_dq();

    private Logger() {
    }

    public static void addLogAdapter(jad_bo jad_boVar) {
        jad_fs jad_fsVar = printer;
        jad_boVar.getClass();
        jad_fsVar.jad_an(jad_boVar);
    }

    public static void clearLogAdapters() {
        printer.jad_an();
    }

    public static void d(Object obj) {
        printer.jad_an(obj);
    }

    public static void d(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_er(str, objArr);
    }

    public static void e(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(null, str, objArr);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(th, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_bo(str, objArr);
    }

    public static void json(String str) {
        printer.jad_bo(str);
    }

    public static void log(int i, String str, String str2, Throwable th) {
        printer.jad_an(i, str, str2, th);
    }

    public static void printer(jad_fs jad_fsVar) {
        jad_fsVar.getClass();
        printer = jad_fsVar;
    }

    public static jad_fs t(String str) {
        return printer.jad_an(str);
    }

    public static void v(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_cp(str, objArr);
    }

    public static void w(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_dq(str, objArr);
    }

    public static void wtf(String str, Object... objArr) {
        if (str == null) {
            str = "";
        }
        printer.jad_an(str, objArr);
    }

    public static void xml(String str) {
        printer.jad_cp(str);
    }
}
