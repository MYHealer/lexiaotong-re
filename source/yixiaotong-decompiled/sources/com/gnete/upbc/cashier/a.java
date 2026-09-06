package com.gnete.upbc.cashier;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import java.util.Set;

/* JADX INFO: compiled from: GnetePayConfigHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a {

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GnetePayConfigHelper.java */
    static /* synthetic */ class C0380a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3265a;

        static {
            int[] iArr = new int[GneteEnv.values().length];
            f3265a = iArr;
            try {
                iArr[GneteEnv.DEV.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3265a[GneteEnv.TEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static String a() {
        return GnetePayConfig.builder().getConfigData().a();
    }

    public static GneteEnv b() {
        return GnetePayConfig.builder().getConfigData().b();
    }

    public static IWXAPI c() {
        return GnetePayConfig.builder().getConfigData().c();
    }

    public static String d() {
        int i = C0380a.f3265a[b().ordinal()];
        if (i != 1) {
            return i != 2 ? "https://api.gnete.com/routejson" : "https://testapi.gnete.com/routejson";
        }
        return "https://testapi.gnete.com/routejsonkf";
    }

    public static Set<GnetePayChannel> e() {
        return GnetePayConfig.builder().getConfigData().d();
    }

    public static String f() {
        return GnetePayConfig.builder().getConfigData().e();
    }

    public static String g() {
        return GnetePayConfig.builder().getConfigData().f();
    }

    public static boolean h() {
        return GnetePayConfig.builder().getConfigData().g();
    }

    public static boolean i() {
        return GnetePayConfig.builder().getConfigData().h();
    }

    public static boolean j() {
        return GnetePayConfig.builder().getConfigData().i();
    }
}
