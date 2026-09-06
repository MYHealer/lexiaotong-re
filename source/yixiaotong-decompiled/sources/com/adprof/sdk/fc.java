package com.adprof.sdk;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class fc {
    public static void a() {
        String str = "native ad file list is null";
        String str2 = "splash ad file list is null";
        h2 h2Var = h2.f1202a;
        try {
            String str3 = k1.f415a + File.separator + "native";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] fileArrM659a = j9.m659a(str3);
            z1.a().getClass();
            File[] fileArrA = j9.a(fileArrM659a, 20);
            pk.c(fileArrA == null ? "native ad file list is null" : "native ad file remain num: " + fileArrA.length);
        } catch (Throwable th) {
            pk.b("clean native ad file error", th);
        }
        try {
            File[] fileArrM659a2 = j9.m659a(k1.b());
            long jCurrentTimeMillis = System.currentTimeMillis();
            z1.a().getClass();
            File[] fileArrA2 = h2.a(fileArrM659a2, jCurrentTimeMillis, ((long) 259200) * 1000);
            z1.a().getClass();
            File[] fileArrA3 = j9.a(fileArrA2, 20);
            pk.c(fileArrA3 == null ? "splash ad file list is null" : "splash ad file remain num: " + fileArrA3.length);
        } catch (Throwable th2) {
            pk.b("clean splash ad file error", th2);
        }
        try {
            String str4 = k1.f415a + File.separator + MediationConstant.RIT_TYPE_SPLASH;
            File file2 = new File(str4);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File[] fileArrM659a3 = j9.m659a(str4);
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            z1.a().getClass();
            File[] fileArrA4 = h2.a(fileArrM659a3, jCurrentTimeMillis2, ((long) 259200) * 1000);
            z1.a().getClass();
            File[] fileArrA5 = j9.a(fileArrA4, 15);
            if (fileArrA5 != null) {
                str2 = "splash ad file remain num: " + fileArrA5.length;
            }
            pk.c(str2);
        } catch (Throwable th3) {
            pk.b("clean splash ad file error", th3);
        }
        try {
            File[] fileArrM659a4 = j9.m659a(k1.a().getAbsolutePath());
            if (fileArrM659a4 != null && fileArrM659a4.length > 0) {
                for (File file3 : fileArrM659a4) {
                    if (System.currentTimeMillis() - file3.lastModified() > 604800000) {
                        pk.c(String.format("Download APK files timeOut seven day and delete: %s: %b", file3.getName(), Boolean.valueOf(file3.delete())));
                    }
                }
            }
        } catch (Throwable th4) {
            pk.b("clean Download APK file error", th4);
        }
        xb xbVarA = xb.a(AdprofSdk.getInstance().getContext());
        xbVarA.getClass();
        try {
            File[] fileArrA6 = j9.a(j9.m659a(xbVarA.a().getAbsolutePath()), 100);
            if (fileArrA6 != null) {
                str = "native ad file remain num: " + fileArrA6.length;
            }
            pk.c(str);
        } catch (Throwable th5) {
            pk.b("clean native ad file error", th5);
        }
    }

    public static void b() {
        z1.a().getClass();
        e7 e7VarA = e7.a();
        synchronized (e7VarA) {
            if (!e7VarA.f236a) {
                pk.d("crash handler");
                e7VarA.f234a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(e7VarA);
                e7VarA.f236a = true;
                if (pk.f594a) {
                    StringBuilder sb = new StringBuilder("CrashHandler initialized, previous handler: ");
                    Thread.UncaughtExceptionHandler uncaughtExceptionHandler = e7VarA.f234a;
                    pk.a(sb.append(uncaughtExceptionHandler != null ? uncaughtExceptionHandler.getClass().getName() : "null").toString());
                }
            }
        }
        e7 e7VarA2 = e7.a();
        d7 d7Var = new d7() { // from class: com.adprof.sdk.fc$$ExternalSyntheticLambda0
            @Override // com.adprof.sdk.d7
            public final void a(Throwable th) {
                oh.a(th);
            }
        };
        e7VarA2.getClass();
        synchronized (e7VarA2.f235a) {
            e7VarA2.f235a.add(d7Var);
        }
    }
}
