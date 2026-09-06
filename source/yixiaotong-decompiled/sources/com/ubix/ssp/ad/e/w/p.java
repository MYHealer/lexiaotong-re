package com.ubix.ssp.ad.e.w;

import android.os.Process;
import com.ubix.ssp.BuildConfig;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class p implements Thread.UncaughtExceptionHandler {
    private static p b;
    private Thread.UncaughtExceptionHandler d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f8914a = new ArrayList<>();
    private static boolean c = false;

    private p() {
        if (!(Thread.getDefaultUncaughtExceptionHandler() instanceof p)) {
            this.d = Thread.getDefaultUncaughtExceptionHandler();
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    static void a() {
        c = true;
    }

    static synchronized void b() {
        if (b == null) {
            ArrayList<String> arrayList = f8914a;
            arrayList.add(BuildConfig.LIBRARY_PACKAGE_NAME);
            arrayList.add("com.ubixnow");
            b = new p();
        }
    }

    private void c() {
        try {
            Process.killProcess(Process.myPid());
            System.exit(10);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Iterator<String> it;
        boolean z;
        try {
            if (c) {
                try {
                    HashMap<String, Object> map = new HashMap<>();
                    JSONObject jSONObject = new JSONObject();
                    String string = null;
                    try {
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        th.printStackTrace(printWriter);
                        Throwable cause = th;
                        while (true) {
                            cause = cause.getCause();
                            if (cause == null) {
                                break;
                            } else {
                                cause.printStackTrace(printWriter);
                            }
                        }
                        printWriter.close();
                        string = stringWriter.toString();
                        map.put("EVENT_CODE_ERROR", string);
                        jSONObject.put("app_crashed_reason", string);
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            String next = it.next();
                            if (string != null && string.contains(next)) {
                                z = true;
                                break;
                            }
                        }
                    } catch (Exception e) {
                        h.a(e);
                    }
                    it = f8914a.iterator();
                    if (string != null && z) {
                        f.a(com.ubix.ssp.ad.e.a0.c.e()).l(map);
                    }
                } catch (Exception e2) {
                    h.a(e2);
                }
            }
            n.l().e();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e3) {
                h.a(e3);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
            if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this || (uncaughtExceptionHandler instanceof p)) {
                c();
            } else {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception unused) {
        }
    }
}
