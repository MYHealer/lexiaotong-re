package com.hihonor.hianalytics.hnha;

import android.content.Context;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class q0 implements Thread.UncaughtExceptionHandler {
    private static q0 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private r0 f3673a;
    private Thread.UncaughtExceptionHandler b;
    private volatile boolean c;
    private String d = "";
    private String e = "";

    private synchronized void a() {
        if (this.b == null) {
            this.b = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    private void a(Throwable th) {
        c(th);
    }

    private boolean a(String str) {
        String[] strArr = {"java.io.FileNotFoundException", "java.sql.SQLException", "java.net.BindException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.util.MissingResourceException", "java.util.jar.JarException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.security.acl.NotOwnerException"};
        for (int i = 0; i < 10; i++) {
            if (str.equals(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static q0 b() {
        q0 q0Var;
        synchronized (q0.class) {
            if (f == null) {
                f = new q0();
            }
            q0Var = f;
        }
        return q0Var;
    }

    private String b(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        Throwable cause = th.getCause();
        for (StackTraceElement stackTraceElement : cause != null ? cause.getStackTrace() : th.getStackTrace()) {
            stringBuffer.append(stackTraceElement.toString().trim()).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return stringBuffer.toString();
    }

    private void c(Throwable th) {
        String strB;
        String name = th.getClass().getName();
        j2.c(com.hihonor.adsdk.base.j.a.hnadsc, "crash error is Grey list");
        if (a(name)) {
            this.d = name;
            strB = b(th);
        } else {
            strB = "An exception occurred";
        }
        this.e = strB;
    }

    public void a(Context context, r0 r0Var) {
        this.f3673a = r0Var;
        this.c = true;
        a();
    }

    public void c() {
        this.c = false;
    }

    public boolean d(Throwable th) {
        if (th == null) {
            return false;
        }
        a(th);
        if (!this.c) {
            return true;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_crash_class", this.d);
            jSONObject.put("_crash_stack", this.e);
        } catch (JSONException unused) {
            j2.g(com.hihonor.adsdk.base.j.a.hnadsc, "eventManager handlerEx json put error!");
        }
        this.f3673a.a(jSONObject);
        this.d = "";
        this.e = "";
        return true;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        j2.b(com.hihonor.adsdk.base.j.a.hnadsc, "uncaughtException occur");
        if (this.b != null) {
            if (d(th)) {
                j2.b(com.hihonor.adsdk.base.j.a.hnadsc, "Throwable is doing.");
            }
            this.b.uncaughtException(thread, th);
        }
    }
}
