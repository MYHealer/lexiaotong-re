package com.byazt.mc;

import androidx.core.app.NotificationCompat;
import com.byazt.bwm.i;
import com.byazt.dna.z;
import com.byazt.nr.m;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 54})
public class ve implements Comparable<ve>, Runnable {
    public static final AtomicInteger c = new AtomicInteger(0);
    public static boolean tt = false;
    public a uj;
    public final Runnable ve;
    public long x;
    public boolean n = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2470a = true;
    public final long sp = System.currentTimeMillis();
    public int i = 0;
    public int da = 0;

    public Runnable c() {
        return this.ve;
    }

    public void c(int i) {
        int i2 = this.i;
        if (i2 == 0) {
            this.da = i;
        } else {
            this.da = i2;
        }
        this.i = i;
    }

    public void c(a aVar) {
        this.uj = aVar;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public void tt(boolean z) {
        this.f2470a = z;
    }

    public int uj() {
        return this.i;
    }

    public boolean ve() {
        return this.f2470a;
    }

    public ve(Runnable runnable) {
        this.ve = runnable;
    }

    public ve(Runnable runnable, a aVar) {
        this.ve = runnable;
        this.uj = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        long j;
        int i;
        int i2;
        long j2;
        boolean zGt = i.tt.gt();
        if (zGt) {
            int activeCount = i.tt.i().getActiveCount();
            int activeCount2 = i.tt.da().getActiveCount();
            long jCurrentTimeMillis = System.currentTimeMillis();
            i2 = activeCount2;
            i = activeCount;
            j2 = jCurrentTimeMillis;
            j = (jCurrentTimeMillis - this.x) - this.sp;
        } else {
            j = 0;
            i = 0;
            i2 = 0;
            j2 = 0;
        }
        this.ve.run();
        long jCurrentTimeMillis2 = System.currentTimeMillis() - j2;
        if (!this.n && this.i == 2) {
            c.decrementAndGet();
        }
        ve(false);
        if (zGt) {
            if (c(j) || jCurrentTimeMillis2 > i.tt.my()) {
                z zVar = (z) com.byazt.ut.uj.getService(NotificationCompat.CATEGORY_EVENT);
                if (zVar == null) {
                    m.tt("BizRunnable", "IEvent service is null");
                } else {
                    c(j, jCurrentTimeMillis2, "", 0, i, i2, zVar);
                }
            }
        }
    }

    public void tt() {
        this.x = System.currentTimeMillis() - this.sp;
    }

    private boolean c(long j) {
        if (this.da == 1) {
            return j > i.tt.nu();
        }
        return j > i.tt.rh();
    }

    private void c(long j, long j2, String str, int i, int i2, int i3, z zVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("create_time", this.sp);
            jSONObject.put("is_wrap", this.ve instanceof ve);
            jSONObject.put("is_oom", tt);
            jSONObject.put("pool_wait_time", j);
            jSONObject.put("priority", i);
            jSONObject.put("wait_in_queue", this.x);
            jSONObject.put("pool_type", this.i);
            jSONObject.put("origin_pool_type", this.da);
            jSONObject.put("run_cost", j2);
            jSONObject.put("task_name", str);
            jSONObject.put(CrashHianalyticsData.THREAD_NAME, Thread.currentThread().getName());
            i iVar = i.tt;
            jSONObject.put("little_active_count", i2);
            jSONObject.put("big_active_count", i3);
            jSONObject.put("is_crash", iVar.yp());
            jSONObject.put("auto_size", i.uj);
            jSONObject.put("pri_task_in_little", c.get());
            jSONObject.put("core_count", iVar.x());
            jSONObject.put("max_pool_size", iVar.sl());
            jSONObject.put("use_little_pool", iVar.m());
        } catch (Exception unused) {
        }
        zVar.onStatsEvent("task_run_cost", jSONObject);
    }

    private void ve(boolean z) {
        a aVar = this.uj;
        if (aVar != null) {
            aVar.c(this, z);
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(ve veVar) {
        Class<?> cls = this.ve.getClass();
        Class<?> cls2 = veVar.ve.getClass();
        if (!cls.isAssignableFrom(cls2) && !cls2.isAssignableFrom(cls)) {
            return 0;
        }
        Runnable runnable = this.ve;
        if (!(runnable instanceof Comparable)) {
            return 0;
        }
        Runnable runnable2 = veVar.ve;
        if (runnable2 instanceof Comparable) {
            return ((Comparable) runnable).compareTo(runnable2);
        }
        return 0;
    }
}
