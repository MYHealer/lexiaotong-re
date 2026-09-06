package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cp implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f1789a = "";
    private static final String b = "remote";
    private static final String c = "proxy";
    private static final String d = "third-mtj";
    private static final String e = "third-cpu";
    private static final String f = "third-cpu-cyber";
    private static final String g = "third-novel";
    private static final String h = "third-aigc";
    private static final String i = "third-aigc-virtual";
    private static final String j = "third-aigc-speech";
    private static final String k = "third-aigc-image";
    private static Thread.UncaughtExceptionHandler l = null;
    private static volatile cp m = null;
    private static final String p = "key_crash_source";
    private static final String q = "key_crash_trace";
    private static final String r = "key_crash_ad";
    private Context n;
    private a o;

    interface a {
        void a(String str);
    }

    public void a(a aVar) {
        this.o = aVar;
    }

    public void c() {
        this.o = null;
    }

    public static cp a(Context context) {
        if (m == null) {
            synchronized (cp.class) {
                if (m == null) {
                    m = new cp(context);
                }
            }
        }
        return m;
    }

    private cp(Context context) {
        this.n = StubApp.getOrigApplicationContext(context.getApplicationContext());
        l = Thread.getDefaultUncaughtExceptionHandler();
    }

    public void a() {
        be.a().a((j) new cq(this));
    }

    public void b() {
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            String strA = a(th);
            if (strA != null) {
                a(strA, Log.getStackTraceString(th));
                a aVar = this.o;
                if (aVar != null) {
                    aVar.a(strA);
                }
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = l;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            }
        } catch (Exception e2) {
            bv.a().c(e2);
        }
    }

    private String a(Throwable th) {
        Throwable cause = th.getCause();
        if (cause != null) {
            th = cause;
        }
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || stackTrace.length <= 0) {
            return null;
        }
        List<String> listD = d();
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("junit.framework")) {
                return null;
            }
            if (!className.startsWith(z.au) && !className.startsWith(z.av) && !className.startsWith(z.aw)) {
                if (className.startsWith(z.ax) || className.startsWith(z.ay) || className.startsWith(z.az)) {
                    return c;
                }
                if (className.startsWith(z.aA)) {
                    return d;
                }
                if (className.startsWith(z.aB)) {
                    return e;
                }
                if (className.startsWith(z.aC) || className.startsWith(z.aD)) {
                    return f;
                }
                if (className.startsWith(z.aL)) {
                    return j;
                }
                if (className.startsWith(z.aH) || className.startsWith(z.aI) || className.startsWith(z.aJ) || className.startsWith(z.aK)) {
                    return i;
                }
                if (className.startsWith(z.aG)) {
                    return h;
                }
                if (className.startsWith(z.aE) || className.startsWith(z.aF)) {
                    if (co.g.booleanValue()) {
                        return g;
                    }
                } else if (!a(className, listD)) {
                    if (className.startsWith(z.aM)) {
                        return k;
                    }
                }
            }
            return b;
        }
        return null;
    }

    private List<String> d() {
        IXAdContainerFactory iXAdContainerFactoryC;
        ArrayList arrayList = new ArrayList();
        try {
            aa aaVarA = aa.a();
            if (aaVarA != null && (iXAdContainerFactoryC = aaVarA.c()) != null) {
                Object remoteParam = iXAdContainerFactoryC.getRemoteParam("appCommonConfig", "getCrashPackage");
                if (remoteParam instanceof List) {
                    arrayList.addAll((List) remoteParam);
                }
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    private boolean a(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    private SharedPreferences e() throws Exception {
        return this.n.getSharedPreferences("baidu_mobads_crash", 0);
    }

    private SharedPreferences.Editor f() throws Exception {
        return e().edit();
    }

    public void a(String str, String str2) throws Exception {
        SharedPreferences.Editor editorF = f();
        String str3 = "crashtime:" + System.currentTimeMillis() + PPSLabelView.Code;
        editorF.putString(p, str);
        editorF.putString(q, str3 + str2);
        editorF.putString(r, f1789a);
        editorF.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) throws Exception {
        return e().getString(str, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() throws Exception {
        SharedPreferences.Editor editorF = f();
        editorF.clear();
        editorF.apply();
    }
}
