package com.gnete.upbc.cashier.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: LogInf.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3273a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private g h;
    private String i;
    private String j;

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.i;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.f3273a;
    }

    public g h() {
        return this.h;
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.j;
    }

    /* JADX INFO: compiled from: LogInf.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        e f3274a;

        public a(Context context) {
            e eVar = new e();
            this.f3274a = eVar;
            eVar.b = com.gnete.upbc.cashier.a.f();
            PackageInfo packageInfoB = b(context);
            this.f3274a.c = packageInfoB == null ? "unknown" : packageInfoB.packageName;
            this.f3274a.d = packageInfoB != null ? packageInfoB.versionName : "unknown";
            this.f3274a.e = Build.BRAND.concat(PPSLabelView.Code).concat(Build.MODEL);
            this.f3274a.f = c();
            this.f3274a.g = a(context).c();
        }

        private PackageInfo b(Context context) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        private String c() {
            return d() ? String.format("%s %s (%s %s)", "HarmonyOS", b(), "Android", Build.VERSION.RELEASE) : "Android ".concat(Build.VERSION.RELEASE);
        }

        private boolean d() {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return "harmony".equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]));
            } catch (Exception unused) {
                return false;
            }
        }

        public a a(GnetePayChannel gnetePayChannel) {
            f fVarA = f.a(gnetePayChannel);
            this.f3274a.f3273a = fVarA == null ? "" : fVarA.e();
            return this;
        }

        public e a() {
            return this.f3274a;
        }

        public String e() {
            com.gnete.upbc.cashier.g.a.C0391a c0391aB = com.gnete.upbc.cashier.g.a.b();
            for (Field field : this.f3274a.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    c0391aB.a(field.getName(), field.get(this.f3274a));
                } catch (IllegalAccessException unused) {
                }
            }
            return c0391aB.a().toString();
        }

        public a a(g gVar) {
            this.f3274a.h = gVar;
            return this;
        }

        public a a(String str) {
            this.f3274a.i = str;
            return this;
        }

        private String b() {
            try {
                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                String str = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, "hw_sc.build.platform.version");
                return !TextUtils.isEmpty(str) ? str : "";
            } catch (Exception unused) {
            }
        }

        public a a(Throwable th) {
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(stringWriter.toString()));
                this.f3274a.j = "";
                while (true) {
                    try {
                        String line = lineNumberReader.readLine();
                        if (line == null) {
                            break;
                        }
                        e eVar = this.f3274a;
                        eVar.j = eVar.j.concat(line);
                    } catch (IOException unused) {
                    }
                }
                e eVar2 = this.f3274a;
                eVar2.j = eVar2.j.replaceAll("\\.", "/").replaceAll("\\t", "    ");
            }
            return this;
        }

        public a(String str) {
            this.f3274a = new e();
            com.gnete.upbc.cashier.g.a.C0391a c0391aA = com.gnete.upbc.cashier.g.a.a(str);
            for (Field field : this.f3274a.getClass().getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    String strA = c0391aA.a(field.getName(), "");
                    if (field.getType().getSimpleName().equals(OapsKey.KEY_GRADE)) {
                        field.set(this.f3274a, g.a(strA));
                    } else {
                        field.set(this.f3274a, strA);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }

        private h a(Context context) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo.isConnected()) {
                return h.MOBILE;
            }
            if (networkInfo2.isConnected()) {
                return h.WIFI;
            }
            return h.UNKNOWN;
        }
    }
}
