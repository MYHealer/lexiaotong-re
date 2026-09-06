package com.byazt.gf;

import com.huawei.hms.ads.nativead.DetailedCreativeType;
import com.umeng.analytics.pro.am;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, DetailedCreativeType.LONG_TEXT, 46})
public class n {
    public static n c;
    public boolean tt = false;
    public long ve = 180000;
    public long uj = 43200000;
    public long n = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2249a = 30;
    public long sp = 15;

    public long a() {
        return this.f2249a;
    }

    public long n() {
        return this.n;
    }

    public long sp() {
        return this.sp;
    }

    public boolean tt() {
        return this.tt;
    }

    public long uj() {
        return this.ve;
    }

    public long ve() {
        return this.uj;
    }

    private n() {
    }

    public static n c() {
        if (c == null) {
            synchronized (n.class) {
                if (c == null) {
                    c = new n();
                }
            }
        }
        return c;
    }

    public synchronized void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!jSONObject.toString().isEmpty()) {
                this.tt = jSONObject.optBoolean("sensorenable", false);
                this.ve = jSONObject.optLong(am.aT, 180000L);
                this.uj = jSONObject.optLong("expireduation", 43200000L);
                this.n = jSONObject.optLong("showinterval", 3L);
                this.f2249a = jSONObject.optLong("azimuth_unit", 30L);
                this.sp = jSONObject.optLong("angle_unit", 15L);
            }
        }
    }
}
