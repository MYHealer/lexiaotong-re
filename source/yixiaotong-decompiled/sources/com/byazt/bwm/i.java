package com.byazt.bwm;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.kuaishou.weapon.p0.t;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 33, 42})
public final class i {
    public static final int c = Runtime.getRuntime().availableProcessors();
    public static final i tt = new i();
    public static boolean uj = true;
    public volatile boolean da;
    public volatile ThreadPoolExecutor gt;
    public int gu;
    public volatile boolean md;
    public volatile ThreadPoolExecutor my;
    public volatile boolean p;
    public com.byazt.mc.n rh;
    public volatile ScheduledExecutorService rl;
    public boolean yv;
    public volatile boolean ve = true;
    public long sp = 5000;
    public long x = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    public volatile boolean i = true;
    public boolean sl = true;
    public long t = 100;
    public long u = 50;
    public long yp = 1000;
    public long z = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    public boolean m = false;
    public volatile boolean nu = true;
    public boolean qy = true;
    public boolean gr = true;
    public com.byazt.mc.tt zm = new com.byazt.mc.tt() { // from class: com.byazt.bwm.i.1
        @Override // com.byazt.mc.tt
        public String c(String str) {
            if (str != null) {
                return str.startsWith(AdnConfig.a.hnadsb) ? str : "csj_".concat(String.valueOf(str));
            }
            return "csj_uk";
        }
    };
    public volatile boolean h = true;
    public volatile boolean d = true;
    public int n = Math.min(c, 4);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2018a = 50;

    public void a(boolean z) {
        this.i = z;
    }

    public boolean a() {
        return this.yv;
    }

    public void c(int i) {
        this.gu = i;
    }

    public void c(boolean z) {
        this.sl = z;
    }

    public boolean c() {
        return this.sl;
    }

    public boolean gt() {
        return this.m;
    }

    public void i(boolean z) {
        this.m = z;
    }

    public boolean m() {
        return this.h && uj;
    }

    public long my() {
        return this.z;
    }

    public void n(boolean z) {
        this.da = z;
    }

    public boolean n() {
        return this.ve;
    }

    public long nu() {
        return this.u;
    }

    public long rh() {
        return this.yp;
    }

    public int sl() {
        return this.f2018a;
    }

    public void tt(long j) {
        this.u = j;
    }

    public void tt(boolean z) {
        this.qy = z;
    }

    public boolean tt() {
        return this.qy;
    }

    public boolean tt(int i) {
        return (this.gu & i) == i;
    }

    public long uj() {
        return this.t;
    }

    public void uj(long j) {
        this.z = j;
    }

    public void uj(boolean z) {
        this.yv = z;
    }

    public com.byazt.mc.tt ve() {
        return this.zm;
    }

    public void ve(long j) {
        this.yp = j;
    }

    public void ve(boolean z) {
        this.ve = z;
    }

    public int x() {
        return this.n;
    }

    public boolean yp() {
        return this.p;
    }

    public boolean z() {
        return this.md;
    }

    private i() {
    }

    public com.byazt.mc.n sp() {
        if (this.rh == null) {
            this.rh = new com.byazt.mc.n();
        }
        return this.rh;
    }

    public void ve(int i) {
        this.n = i;
        i().setCorePoolSize(i);
        da().setCorePoolSize(i);
    }

    public ThreadPoolExecutor i() {
        if (this.my == null) {
            synchronized (this) {
                if (this.my == null) {
                    this.my = new com.byazt.msj.uj(this.n, this.f2018a, this.x, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new x(10, "a") { // from class: com.byazt.bwm.i.2
                        @Override // com.byazt.bwm.x
                        public Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                }
            }
        }
        return this.my;
    }

    public ThreadPoolExecutor da() {
        if (this.gt == null) {
            synchronized (this) {
                if (this.gt == null) {
                    this.gt = new com.byazt.msj.tt(this.n, this.f2018a, this.sp, TimeUnit.MILLISECONDS, new x(10, t.l) { // from class: com.byazt.bwm.i.3
                        @Override // com.byazt.bwm.x
                        public Thread c(ThreadGroup threadGroup, Runnable runnable, String str) {
                            return new Thread(threadGroup, runnable, str);
                        }
                    });
                    if (this.d) {
                        try {
                            this.gt.allowCoreThreadTimeOut(true);
                        } catch (Throwable unused) {
                        }
                    }
                }
            }
        }
        return this.gt;
    }

    public void uj(int i) {
        this.f2018a = i;
        i().setMaximumPoolSize(i);
        da().setMaximumPoolSize(i);
    }

    public ScheduledExecutorService t() {
        if (this.rl == null) {
            synchronized (this) {
                if (this.rl == null) {
                    this.rl = new ScheduledThreadPoolExecutor(1, new ThreadFactory() { // from class: com.byazt.bwm.i.4
                        @Override // java.util.concurrent.ThreadFactory
                        public Thread newThread(Runnable runnable) {
                            return new Thread(runnable, i.this.yv ? "csj-p-wp" : "csj-wp");
                        }
                    }, com.byazt.jtc.c.c);
                }
            }
        }
        return this.rl;
    }

    public ThreadPoolExecutor u() {
        if (this.da) {
            return da();
        }
        return i();
    }

    public void c(long j) {
        this.sp = j;
        da().setKeepAliveTime(j, TimeUnit.MILLISECONDS);
    }

    public void sp(boolean z) {
        if (z) {
            x(false);
            uj = false;
        }
        this.p = z;
    }

    public void x(boolean z) {
        if (this.p) {
            return;
        }
        if (this.gt != null) {
            this.gt.allowCoreThreadTimeOut(z);
        }
        this.d = z;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        i iVar = tt;
        int iOptInt = jSONObject.optInt("big_max_mum", 50);
        if (iOptInt > 0) {
            iVar.uj(iOptInt);
        }
        int iOptInt2 = jSONObject.optInt("core_count", 0);
        if (iOptInt2 > 0) {
            iVar.ve(iOptInt2);
        }
        int iOptInt3 = jSONObject.optInt("big_keep_alive", 0);
        if (iOptInt3 > 0) {
            iVar.c(iOptInt3);
        }
        iVar.n(jSONObject.optBoolean("big_priority", false));
        iVar.ve(jSONObject.optBoolean("catch_oom", true));
        iVar.tt(jSONObject.optBoolean("forbid_autosize_oom", true));
        iVar.a(jSONObject.optBoolean("enable_proxy", true));
        uj = jSONObject.optBoolean("autosize", true);
        iVar.i(jSONObject.optBoolean("report_task", false));
        iVar.tt(jSONObject.optInt("wait_in_big", 50));
        iVar.ve(jSONObject.optInt("wait_in_little", 2000));
        iVar.uj(jSONObject.optInt("run_cost", 6000));
    }
}
