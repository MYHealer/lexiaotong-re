package com.ubix.ssp.ad.d;

import android.os.Build;
import com.ubix.ssp.ad.e.a0.r;
import com.umeng.analytics.pro.am;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {
    public int A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public double[] H;
    public int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8611a;
    public boolean b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public float p;
    public float q;
    public String r;
    public int s;
    public int t;
    public String u;
    public int v;
    public String w;
    public String x;
    public int y;
    public int z;

    public g() {
        this.f8611a = (com.ubix.ssp.ad.e.b.a("sim_status") && (b.y & 2) == 2) ? com.ubix.ssp.ad.e.a0.c.p() : 0;
        this.b = (com.ubix.ssp.ad.e.b.a("is_debug_mode") && (b.y & 1) == 1) ? com.ubix.ssp.ad.e.a0.c.B() : false;
        this.c = com.ubix.ssp.ad.e.b.a("custom_os_name") ? com.ubix.ssp.ad.e.a0.z.a.a().n() : "";
        this.d = com.ubix.ssp.ad.e.b.a("custom_os_version") ? com.ubix.ssp.ad.e.a0.z.a.a().m() : "";
        this.e = 1;
        this.f = 1;
        this.g = Build.VERSION.RELEASE;
        this.h = Build.MANUFACTURER;
        this.i = Build.BRAND;
        this.j = com.ubix.ssp.ad.e.b.a("device_model") ? Build.MODEL : "";
        this.k = com.ubix.ssp.ad.e.b.a("hw_model") ? Build.PRODUCT : "";
        this.l = com.ubix.ssp.ad.e.b.a("hw_machine") ? Build.CPU_ABI : "";
        this.m = Build.HARDWARE;
        this.n = com.ubix.ssp.ad.e.b.a("language") ? Locale.getDefault().getLanguage() : "";
        this.o = com.ubix.ssp.ad.e.a0.c.o();
        this.p = r.b(com.ubix.ssp.ad.e.a0.c.f8631a);
        this.q = r.a().a(com.ubix.ssp.ad.e.a0.c.f8631a);
        this.r = com.ubix.ssp.ad.e.b.a(am.J) ? Build.DEVICE : "";
        this.s = com.ubix.ssp.ad.e.a0.c.k();
        this.t = com.ubix.ssp.ad.e.b.a("conn_type") ? com.ubix.ssp.ad.e.a0.c.i() : 0;
        this.u = com.ubix.ssp.ad.e.b.a("carrier_type") ? com.ubix.ssp.ad.e.a0.c.c(b.a().isCanUsePhoneState()) : "";
        this.v = com.ubix.ssp.ad.e.b.a("carrier_code") ? com.ubix.ssp.ad.e.a0.c.b(b.a().isCanUsePhoneState()) : 0;
        this.w = (!com.ubix.ssp.ad.e.b.a("device_startup_time") || b()) ? "" : com.ubix.ssp.ad.e.a0.c.c();
        this.x = com.ubix.ssp.ad.e.b.a("device_mb_time") ? com.ubix.ssp.ad.e.a0.c.s() : "";
        this.y = com.ubix.ssp.ad.e.b.a("cpu_num") ? com.ubix.ssp.ad.e.a0.c.j() : 0;
        this.z = 1;
        this.A = 0;
        this.B = com.ubix.ssp.ad.e.b.a("country_code") ? com.ubix.ssp.ad.e.a0.c.f() : "";
        this.C = "28800000";
        this.D = a();
        this.E = com.ubix.ssp.ad.e.b.a("vivo_store_ver") ? com.ubix.ssp.ad.e.a0.c.f(com.ubix.ssp.ad.e.a0.c.f8631a) : "";
        this.F = com.ubix.ssp.ad.e.b.a("huawei_ver_code_of_ag") ? com.ubix.ssp.ad.e.a0.c.c(com.ubix.ssp.ad.e.a0.c.f8631a) : "";
        this.G = com.ubix.ssp.ad.e.b.a("huawei_ver_code_of_hms") ? com.ubix.ssp.ad.e.a0.c.b(com.ubix.ssp.ad.e.a0.c.f8631a) : "";
        this.H = b.a().getLocation();
        this.I = com.ubix.ssp.ad.e.b.a("is_vpn_on") ? com.ubix.ssp.ad.e.a0.c.v() : 0;
    }

    private boolean b() {
        return com.ubix.ssp.ad.e.a0.z.a.a().g() || com.ubix.ssp.ad.e.a0.z.a.a().f() || com.ubix.ssp.ad.e.a0.z.a.a().l();
    }

    public String a() {
        return this.f == 1 ? "android" : "harmony";
    }
}
