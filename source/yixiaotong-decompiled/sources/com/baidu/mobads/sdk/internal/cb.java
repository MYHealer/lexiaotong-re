package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.stub.StubApp;
import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1765a = "ApkLoader";
    protected static Thread.UncaughtExceptionHandler b = null;
    public static final String c = "__badApkVersion__9.450";
    public static final String d = "previousProxyVersion";
    protected static final String e = "__xadsdk__remote__final__";
    protected static final String f = "bdxadsdk.jar";
    protected static final String g = "__xadsdk__remote__final__builtin__.jar";
    protected static final String h = "__xadsdk__remote__final__builtinversion__.jar";
    protected static final String i = "__xadsdk__remote__final__downloaded__.jar";
    protected static final String j = "__xadsdk__remote__final__running__.jar";
    public static final String k = "OK";
    public static final String l = "ERROR";
    public static final String m = "APK_INFO";
    public static final String n = "CODE";
    public static final String o = "success";
    protected static volatile bp p = null;
    protected static volatile bp q = null;
    protected static volatile Class r = null;
    protected static String s = null;
    protected static final Handler t = new cc(Looper.getMainLooper());
    private static final String x = "baidu_sdk_remote";
    private boolean A;
    private CopyOnWriteArrayList<c> B;
    private c C;
    protected Handler u;
    protected final Handler v;
    private bz w;
    private final Context y;
    private bv z;

    public interface c {
        void a(boolean z);
    }

    public final String a() {
        return "9.450";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            File[] fileArrListFiles = this.y.getFilesDir().listFiles();
            for (int i2 = 0; fileArrListFiles != null && i2 < fileArrListFiles.length; i2++) {
                if (fileArrListFiles[i2].getAbsolutePath().contains(e) && fileArrListFiles[i2].getAbsolutePath().endsWith("dex")) {
                    fileArrListFiles[i2].delete();
                }
            }
        } catch (Exception e2) {
            bv.a().c(e2);
        }
    }

    public cb(Activity activity) {
        this(StubApp.getOrigApplicationContext(activity.getApplicationContext()));
    }

    public cb(Context context) {
        this.z = bv.a();
        this.A = false;
        this.u = t;
        this.B = new CopyOnWriteArrayList<>();
        this.v = new cd(this, Looper.getMainLooper());
        this.y = context;
        c(context);
        if (b == null) {
            b = cp.a(context);
            cp.a(context).a(new ce(this));
        }
        if (Thread.getDefaultUncaughtExceptionHandler() instanceof cp) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(b);
    }

    private static void c(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences m() {
        return this.y.getSharedPreferences(z.aN, 0);
    }

    protected void b() {
        new File(f()).delete();
    }

    protected void a(String str) {
        if (p != null) {
            SharedPreferences.Editor editorEdit = m().edit();
            editorEdit.putFloat(c, (float) p.b);
            editorEdit.apply();
        }
    }

    private boolean n() {
        String string = m().getString(d, null);
        return string == null || !string.equals(a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        Message messageObtainMessage = this.u.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", z);
        messageObtainMessage.setData(bundle);
        messageObtainMessage.what = 0;
        this.u.sendMessage(messageObtainMessage);
    }

    protected static String c() {
        return TextUtils.isEmpty(s) ? "" : s + g;
    }

    protected static String d() {
        return TextUtils.isEmpty(s) ? "" : s + h;
    }

    protected void e() throws a, b {
        this.z.a(f1765a, "start load assets file");
        d(this.y);
        String strC = c();
        bu buVar = new bu(strC, this.y);
        if (bt.a(buVar)) {
            this.z.a(f1765a, "assets file can read ,will use it ");
            if (c(buVar)) {
                b(true);
                return;
            }
            return;
        }
        throw new b("loadBuiltInApk failed: " + strC);
    }

    private static synchronized void d(Context context) throws b {
        try {
            String strC = c();
            double dB = b(strC);
            bv.a().a(f1765a, "copy assets,compare version=" + Double.valueOf("9.450") + "remote=" + dB);
            if (Double.valueOf("9.450").doubleValue() != dB) {
                bu buVar = new bu(strC, context);
                if (buVar.exists()) {
                    buVar.delete();
                }
                bt.a(context, f, strC);
            }
        } catch (Exception e2) {
            throw new b("loadBuiltInApk failed: " + e2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bu buVar) throws a {
        Class<?> clsB = buVar.b();
        synchronized (this) {
            q = new bp(clsB, this.y);
        }
    }

    private void b(bu buVar) throws Throwable {
        this.z.a(f1765a, "len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
        if (p == null) {
            String strA = a(this.y);
            bu buVar2 = new bu(strA, this.y);
            if (buVar2.exists()) {
                buVar2.delete();
            }
            try {
                bt.a(new FileInputStream(buVar), strA);
            } catch (Exception e2) {
                this.z.c(e2);
            }
            p = new bp(buVar2.b(), this.y);
            try {
                this.z.a(f1765a, "preloaded apk.version=" + p.a().getRemoteVersion());
                return;
            } catch (a e3) {
                this.z.a(f1765a, "preload local apk " + buVar.getAbsolutePath() + " failed, msg:" + e3.getMessage() + ", v=" + p.b);
                a(e3.getMessage());
                throw e3;
            }
        }
        this.z.a(f1765a, "mApkBuilder already initialized, version: " + p.b);
    }

    private boolean c(bu buVar) throws a {
        synchronized (this) {
            b(buVar);
            this.z.a(f1765a, "loaded: " + buVar.getPath());
        }
        return true;
    }

    private boolean o() {
        try {
            return bt.a(c()) || bt.a(f());
        } catch (Exception e2) {
            this.z.a(e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z || o()) {
            a(z, z ? "apk Successfully Loaded" : "apk Load Failed");
        } else {
            this.A = true;
        }
        if (this.A) {
            be.a().a((j) new cf(this, z));
        } else {
            be.a().a(new cg(this, z), 5L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        double d2;
        if (z) {
            try {
                d2 = p.b;
            } catch (Exception unused) {
                return;
            }
        } else {
            d2 = 0.0d;
        }
        ao.a(d2, new ch(this, d2), new ci(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z, String str) {
        try {
            cp.a(this.y).c();
            CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                for (int i2 = 0; i2 < this.B.size(); i2++) {
                    c cVar = this.B.get(i2);
                    if (cVar != null) {
                        cVar.a(z);
                    }
                }
            }
            CopyOnWriteArrayList<c> copyOnWriteArrayList2 = this.B;
            if (copyOnWriteArrayList2 != null) {
                copyOnWriteArrayList2.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(Context context) {
        if (TextUtils.isEmpty(s)) {
            s = context.getDir(x, 0).getAbsolutePath() + "/";
        }
        return TextUtils.isEmpty(s) ? "" : s + j;
    }

    protected static String f() {
        return TextUtils.isEmpty(s) ? "" : s + i;
    }

    protected void g() throws a {
        if (h() != 2 && p()) {
            this.z.a(f1765a, "load downloaded file success,use it");
            b(true);
            return;
        }
        this.z.a(f1765a, "no downloaded file yet, use built-in apk file");
        try {
            e();
        } catch (b e2) {
            this.z.a(f1765a, "loadBuiltInApk failed: " + e2.toString());
            throw new a("load built-in apk failed" + e2.toString());
        }
    }

    public int h() {
        return StubApp.getOrigApplicationContext(this.y.getApplicationContext()).getSharedPreferences("baidu_cloudControlConfig", 0).getInt("baidu_cloudConfig_pktype", 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        bu buVar = new bu(f(), this.y);
        if (!bt.a(buVar)) {
            return false;
        }
        try {
            if (n()) {
                throw new a("XAdApkLoader upgraded, drop stale downloaded file, use built-in instead");
            }
            synchronized (this) {
                this.z.a(f1765a, "loadDownloadedOrBuiltInApk len=" + buVar.length() + ", path=" + buVar.getAbsolutePath());
                b(buVar);
                double d2 = m().getFloat(c, -1.0f);
                this.z.a(f1765a, "downloadedApkFile.getApkVersion(): " + buVar.c() + ", badApkVersion: " + d2);
                if (buVar.c() == d2) {
                    throw new a("downloaded file marked bad, drop it and use built-in");
                }
                this.z.a(f1765a, "loaded: " + buVar.getPath());
            }
            return true;
        } catch (a e2) {
            this.z.a(f1765a, "load downloaded apk failed: " + e2.toString() + ", fallback to built-in");
            if (buVar.exists()) {
                buVar.delete();
            }
            k();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(bz bzVar) {
        if (bzVar.a().booleanValue()) {
            bx bxVarA = bx.a(this.y, bzVar, s, this.v);
            if (!bxVarA.isAlive()) {
                this.z.a(f1765a, "XApkDownloadThread starting ...");
                bxVarA.start();
            } else {
                this.z.a(f1765a, "XApkDownloadThread already started");
                bxVarA.a(bzVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(c cVar, Handler handler) throws a, b {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.B;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(cVar)) {
            this.B.add(cVar);
        }
        this.u = handler;
        if (p == null) {
            g();
        } else {
            b(true);
        }
    }

    public void a(c cVar, Handler handler) {
        be.a().a((j) new cj(this, cVar, handler));
    }

    public void a(c cVar) {
        a(cVar, t);
    }

    public IXAdContainerFactory i() {
        return a(p);
    }

    public IXAdContainerFactory j() {
        return a(q);
    }

    private IXAdContainerFactory a(bp bpVar) {
        if (bpVar == null) {
            return null;
        }
        try {
            return bpVar.a();
        } catch (Exception unused) {
            return null;
        }
    }

    protected void k() {
        if (p != null) {
            p.b();
            p = null;
        }
    }

    public static final class a extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f1766a = 2978543166232984104L;

        public a(String str) {
            bv.a().c(str);
        }
    }

    protected static final class b extends Exception {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final long f1767a = -7838296421993681751L;

        public b(String str) {
            bv.a().c(str);
        }
    }

    public static double b(Context context) throws Throwable {
        try {
            c(context);
            double dB = b(f());
            String strD = d();
            if (Double.valueOf("9.450").doubleValue() > b(strD)) {
                bu buVar = new bu(strD, context);
                if (buVar.exists()) {
                    buVar.delete();
                }
                bt.a(context, f, strD);
            }
            return Math.max(dB, b(d()));
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static double b(String str) throws Throwable {
        JarFile jarFile = null;
        try {
            try {
                if (!co.d.booleanValue()) {
                    return Double.valueOf("9.450").doubleValue();
                }
                File file = new File(str);
                if (bt.a(file)) {
                    JarFile jarFile2 = new JarFile(file);
                    try {
                        double d2 = Double.parseDouble(jarFile2.getManifest().getMainAttributes().getValue("Implementation-Version"));
                        if (d2 > 0.0d) {
                            try {
                                jarFile2.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            return d2;
                        }
                        jarFile = jarFile2;
                    } catch (Exception unused) {
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            jarFile.close();
                        }
                        return 0.0d;
                    } catch (Throwable th) {
                        th = th;
                        jarFile = jarFile2;
                        if (jarFile != null) {
                            try {
                                jarFile.close();
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
                if (jarFile != null) {
                    jarFile.close();
                }
                return 0.0d;
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
