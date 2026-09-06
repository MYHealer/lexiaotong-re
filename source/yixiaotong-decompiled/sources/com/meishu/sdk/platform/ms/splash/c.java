package com.meishu.sdk.platform.ms.splash;

import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.q;
import com.meishu.sdk.core.utils.u0;

/* JADX INFO: compiled from: ShakeBean.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5241a;
    public ShakeUtil.c b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String i;
    public long j;
    public MeishuAdInfo.DClickData k;
    public int l;
    public int o;
    public double p;
    public double q;
    public boolean r;
    public boolean s;
    public boolean t;
    public long u;
    public int h = 1;
    public int m = 1;
    public int n = 1;

    public void b() {
        MeishuAdInfo.DClickData dClickData;
        try {
            u0.a aVar = u0.f4949a.get(this.i + this.j);
            if ((aVar == null || !aVar.b) && (dClickData = this.k) != null) {
                int power = dClickData.getPower();
                int ptime = this.k.getPtime();
                if (ptime <= 0 || power >= this.d) {
                    return;
                }
                this.l = ptime;
                this.r = true;
                if (power < 1 || power > 100) {
                    return;
                }
                this.o = power;
                double d = (((double) power) * 45.0d) / 100.0d;
                this.p = d;
                if (d < 2.0d) {
                    this.p = 2.0d;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c() {
        this.n++;
    }

    public boolean a() {
        if (this.r) {
            return System.currentTimeMillis() - q.a().a("last_dynamic_time", 0L) > ((long) (this.l * 1000));
        }
        return false;
    }
}
