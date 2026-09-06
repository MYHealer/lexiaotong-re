package com.ubix.ssp.ad.d;

import android.text.TextUtils;
import com.ubix.ssp.ad.e.a0.v;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8608a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    /* JADX WARN: Code duplicated, block: B:21:0x0081  */
    public e() {
        String androidId;
        String imei = TextUtils.isEmpty(b.a().getImei()) ? "" : b.a().getImei();
        this.f8608a = imei;
        this.b = com.ubix.ssp.ad.e.a0.h.a(imei);
        this.c = "";
        String strC = a() ? c() : !TextUtils.isEmpty(b.a().getOaid()) ? b.a().getOaid() : b.e;
        this.d = strC;
        this.e = com.ubix.ssp.ad.e.a0.h.a(strC);
        if (!com.ubix.ssp.ad.e.b.a("device_android_id")) {
            androidId = b.f;
        } else if (b.a().isCanUseAndroidId()) {
            androidId = b();
        } else if (TextUtils.isEmpty(b.a().getAndroidId())) {
            androidId = b.f;
        } else {
            androidId = b.a().getAndroidId();
        }
        this.f = androidId;
        this.g = com.ubix.ssp.ad.e.a0.h.a(androidId);
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
    }

    private boolean a() {
        return b.a().isCanUseOaid() && com.ubix.ssp.ad.e.b.a("device_oaid");
    }

    private String b() {
        if (TextUtils.isEmpty(b.f)) {
            String strA = com.ubix.ssp.ad.e.a0.c.a(b.f8605a.getPrivacyManager().isCanUseAndroidId());
            if (!TextUtils.isEmpty(strA)) {
                b.f = strA;
                return strA;
            }
        } else if (b.f8605a.getPrivacyManager().isCanUseAndroidId()) {
            if (System.currentTimeMillis() > v.c(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_seed", "android_id_expired")) {
                String strA2 = com.ubix.ssp.ad.e.a0.c.a(true);
                if (!TextUtils.isEmpty(strA2)) {
                    b.f = strA2;
                    return strA2;
                }
            }
        }
        return b.f;
    }

    private String c() {
        if (TextUtils.isEmpty(b.e)) {
            String strA = com.ubix.ssp.ad.e.a0.c0.b.a(com.ubix.ssp.ad.e.a0.c.e(), b.w);
            b.e = strA;
            return strA;
        }
        if (!b.f8605a.getPrivacyManager().isTrustOaid()) {
            com.ubix.ssp.ad.e.a0.c0.b.a(com.ubix.ssp.ad.e.a0.c.e(), b.w);
            return b.e;
        }
        if (System.currentTimeMillis() > v.c(com.ubix.ssp.ad.e.a0.c.e(), "ubix_sp_seed", "seed_expired")) {
            com.ubix.ssp.ad.e.a0.c0.b.a(com.ubix.ssp.ad.e.a0.c.e(), b.w);
        }
        return b.e;
    }

    public String toString() {
        return "DeviceIdBean{imei='" + this.f8608a + "', imei_md5=" + this.b + "', android_id=" + this.f + "', android_id_md5=" + this.g + "', oaid=" + this.d + "', mac=" + this.h + "', mac_md5=" + this.i + "', wifi_mac=" + this.j + "', wifi_mac_md5=" + this.k + "', ssid=" + this.l + "', imsi=" + this.c + "'}";
    }
}
