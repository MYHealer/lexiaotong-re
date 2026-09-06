package com.ubix.ssp.ad.e.a0.z;

import android.os.Build;
import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.a0.z.c.c;
import com.ubix.ssp.ad.e.a0.z.c.d;
import com.ubix.ssp.ad.e.a0.z.c.e;
import com.ubix.ssp.ad.e.a0.z.c.f;
import com.ubix.ssp.ad.e.a0.z.c.g;
import com.ubix.ssp.ad.e.a0.z.c.h;
import com.ubix.ssp.ad.e.a0.z.c.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8752a;
    private b b;

    private a() {
        o();
    }

    public static a a() {
        a aVar = f8752a;
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        f8752a = aVar2;
        return aVar2;
    }

    private String a(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            str3 = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e) {
            u.e("System property invoke error: " + e);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    private b b() {
        try {
            if (d()) {
                return new f();
            }
            if (!e() && !c()) {
                if (l()) {
                    return f() ? new d() : new e();
                }
                if (j()) {
                    return new g();
                }
                if (!i() && !h()) {
                    if (k()) {
                        h hVar = new h();
                        if (hVar.a().contains("OriginOS")) {
                            return hVar;
                        }
                        if (hVar.a().contains("Funtouch")) {
                            return new com.ubix.ssp.ad.e.a0.z.c.b();
                        }
                    }
                    return new i();
                }
                return new com.ubix.ssp.ad.e.a0.z.c.a();
            }
            return new c();
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean c() {
        return !TextUtils.isEmpty(a("ro.build.version.emui", ""));
    }

    public boolean d() {
        return Build.BRAND.equalsIgnoreCase("HONOR");
    }

    public boolean e() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return !TextUtils.isEmpty(a("ro.mi.os.version.incremental", ""));
    }

    public boolean g() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    public boolean h() {
        return Build.MANUFACTURER.equalsIgnoreCase("ONEPLUS") || Build.BRAND.equalsIgnoreCase("ONEPLUS");
    }

    public boolean i() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(a("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public boolean j() {
        return Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") || Build.BRAND.equalsIgnoreCase("SAMSUNG");
    }

    public boolean k() {
        return Build.MANUFACTURER.equalsIgnoreCase("VIVO") || Build.BRAND.equalsIgnoreCase("VIVO") || !TextUtils.isEmpty(a("ro.vivo.os.version", ""));
    }

    public boolean l() {
        String str = Build.MANUFACTURER;
        if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("BLACKSHARK")) {
            String str2 = Build.BRAND;
            if (!str2.equalsIgnoreCase("XIAOMI") && !str2.equalsIgnoreCase("REDMI") && !str2.equalsIgnoreCase("BLACKSHARK")) {
                return false;
            }
        }
        return true;
    }

    public String m() {
        b bVar = this.b;
        return bVar == null ? "" : bVar.b();
    }

    public String n() {
        b bVar = this.b;
        return bVar == null ? "" : bVar.a();
    }

    public void o() {
        this.b = b();
    }
}
