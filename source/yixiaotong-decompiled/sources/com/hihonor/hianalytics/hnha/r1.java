package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class r1 {
    private static r1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3677a;
    private String b;
    private Context c;
    private String d;
    private final com.hihonor.hianalytics.util.a e;

    private r1() throws IllegalAccessException, InvocationTargetException {
        Context context = SystemUtils.getContext();
        this.c = context;
        this.d = context.getFilesDir().getPath();
        this.e = com.hihonor.hianalytics.util.g.d();
        a();
    }

    private String a(File file, String str) {
        return !file.exists() ? "" : com.hihonor.hianalytics.util.f.c(new File(file.getPath(), "hianalytics_" + str));
    }

    private String a(String str) {
        StringBuilder sb;
        String strDecrypt = h() ? AesGcmKS.decrypt("analytics_keystore_formal", str) : "";
        if (TextUtils.isEmpty(strDecrypt)) {
            j2.c("Aes128Key", "deCrypt work key first version=" + Build.VERSION.SDK_INT);
            strDecrypt = (String) s1.a(str, e()).second;
            if (TextUtils.isEmpty(strDecrypt)) {
                strDecrypt = w1.b();
                c(b(strDecrypt));
                if (h()) {
                    sb = new StringBuilder();
                    v1.a(sb.append(SystemUtils.getContext().getFilesDir().getPath()).append("/hianalytics").toString());
                }
            } else if (h()) {
                c(b(strDecrypt));
                sb = new StringBuilder();
                v1.a(sb.append(SystemUtils.getContext().getFilesDir().getPath()).append("/hianalytics").toString());
            }
        }
        return strDecrypt;
    }

    private String a(String str, String str2) {
        File file;
        StringBuilder sbAppend = new StringBuilder().append(g());
        String str3 = File.separator;
        String strA = a(new File(sbAppend.append(str3).append(str).toString()), str);
        if (TextUtils.isEmpty(strA)) {
            strA = a(new File(g() + str3 + "hianalytics" + str3 + str2), str2);
            if (TextUtils.isEmpty(strA)) {
                strA = w1.c();
                File file2 = new File(g() + str3 + "hianalytics" + str3 + str2);
                if (!file2.exists() && file2.mkdirs()) {
                    j2.g("HianalyticsSDK", "The secret key file creates the OK!");
                }
                file = new File(g() + str3 + "hianalytics" + str3 + str2, "hianalytics_" + str2);
            }
            return strA;
        }
        File file3 = new File(g() + str3 + str);
        v1.b(file3);
        if (file3.isDirectory() && file3.delete()) {
            j2.g("HianalyticsSDK", "The secret key file is Directory del! change new file");
        }
        File file4 = new File(g() + str3 + "hianalytics" + str3 + str2);
        if (!file4.exists() && file4.mkdirs()) {
            j2.g("HianalyticsSDK", "The secret key file creates the OK!");
        }
        file = new File(g() + str3 + "hianalytics" + str3 + str2, "hianalytics_" + str2);
        com.hihonor.hianalytics.util.f.a(file, strA);
        return strA;
    }

    private void a() {
        String str;
        String str2;
        String str3;
        if (this.e.a("isNewProcessMode", false)) {
            j2.a("Aes128Key", "checkToMoveSp alreadyNewMode");
            return;
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            String strA = com.hihonor.hianalytics.util.p.a("analytics_key", "analytics_key", "");
            this.e.b("oldKey", strA);
            str = "checkToMoveSp fail=";
            str3 = "isNewProcessMode";
            try {
                long jA = com.hihonor.hianalytics.util.p.a("analytics_key", "flashKeyTime", -1L);
                this.e.b("oldKeyTime", jA);
                String strA2 = com.hihonor.hianalytics.util.p.a("Privacy_MY", "PrivacyData", "");
                this.e.b("PrivacyData", strA2);
                long jA2 = com.hihonor.hianalytics.util.p.a("Privacy_MY", "flashKeyTime", -1L);
                this.e.b("flashKeyTime", jA2);
                long jA3 = com.hihonor.hianalytics.util.p.a("Privacy_MY", "assemblyFlash", -1L);
                this.e.b("assemblyFlash", jA3);
                String str4 = "checkToMoveSp finished,componentTime=" + jA3 + ",oldTime=" + jA + ",newTime=" + jA2 + ",spendTime=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + ",oldHaKey=" + SystemUtils.a(strA) + ",newHaKey=" + SystemUtils.a(strA2);
                str2 = "Aes128Key";
                try {
                    j2.a(str2, str4);
                } catch (Throwable th) {
                    th = th;
                    try {
                        j2.g(str2, str + SystemUtils.getDesensitizedException(th));
                    } finally {
                        this.e.c(str3, true);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = "Aes128Key";
            }
        } catch (Throwable th3) {
            th = th3;
            str = "checkToMoveSp fail=";
            str2 = "Aes128Key";
            str3 = "isNewProcessMode";
        }
        com.hihonor.hianalytics.util.a aVar = this.e;
        String str5 = str3;
    }

    private String b(String str) {
        return h() ? AesGcmKS.encrypt("analytics_keystore_formal", str) : (String) s1.b(str, e()).second;
    }

    public static r1 c() {
        r1 r1Var;
        synchronized (r1.class) {
            if (f == null) {
                f = new r1();
            }
            r1Var = f;
        }
        return r1Var;
    }

    private void c(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.e.b("PrivacyData", str);
        this.e.b("flashKeyTime", jCurrentTimeMillis);
    }

    public static String d() {
        return y1.a(y1.a() + d1.a() + w1.a(), 4);
    }

    private String e() {
        if (TextUtils.isEmpty(this.f3677a)) {
            this.f3677a = f();
        }
        return this.f3677a;
    }

    private String f() {
        return y1.a(d(), a("secondAssembly", "aprpap"), a("thirdAssembly", "febdoc"), a("fourthAssembly", "marfil"), a("fiveAssembly", "maywnj"));
    }

    private String g() {
        return this.d;
    }

    private boolean h() {
        return true;
    }

    public synchronized String b() {
        String strA;
        if (TextUtils.isEmpty(this.b)) {
            String strA2 = this.e.a("oldKey", "");
            if (TextUtils.isEmpty(strA2)) {
                String strA3 = this.e.a("PrivacyData", "");
                if (TextUtils.isEmpty(strA3)) {
                    strA = w1.b();
                    c(b(strA));
                } else {
                    strA = a(strA3);
                }
            } else {
                strA = a(strA2);
            }
            this.b = strA;
        }
        return this.b;
    }
}
