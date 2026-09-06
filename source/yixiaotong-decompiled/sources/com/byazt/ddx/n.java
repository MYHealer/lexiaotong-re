package com.byazt.ddx;

import android.os.SystemClock;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 483, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2072a;
    public int c;
    public String i;
    public long n;
    public long sp;
    public long uj;
    public long ve;
    public ic x;
    public AtomicBoolean tt = new AtomicBoolean(false);
    public AtomicLong da = new AtomicLong(0);
    public AtomicInteger sl = new AtomicInteger(0);
    public AtomicLong t = new AtomicLong(0);
    public volatile boolean u = false;

    private void c(long j) {
        if (this.ve <= 0) {
            this.ve = j;
        }
    }

    private void n(long j) {
        if (this.sp <= 0) {
            this.sp = j;
        }
    }

    private void tt(long j) {
        if (this.uj <= 0) {
            this.uj = j;
        }
    }

    private void uj(long j) {
        if (this.f2072a <= 0) {
            this.f2072a = j;
        }
    }

    private void ve(long j) {
        if (this.n <= 0) {
            this.n = j;
        }
    }

    private boolean ve(int i) {
        return i == 56 || i == 51 || i == 52 || i == 57 || i == 55 || i == 53 || i == 54;
    }

    public void c(boolean z) {
        this.u = z;
    }

    public boolean c() {
        return this.u;
    }

    public n(ic icVar, String str) {
        this.x = icVar;
        this.i = str;
    }

    public void c(int i) {
        if (uj(i)) {
            return;
        }
        int i2 = this.sl.get();
        StringBuilder sb = new StringBuilder("index:");
        int i3 = this.c + 1;
        this.c = i3;
        m.c("xgc_ad", sb.append(i3).append(" lifeScene:").append(i2).append(" scene:").append(i).append(" showTs:").append(this.t).toString());
        if (i2 != 13 && i2 != 15 && this.t.get() != 0) {
            c(SystemClock.elapsedRealtime(), i);
        } else if (i2 == 14) {
            yp.c().c(this.x, "attach");
        } else {
            m.c("ast", "no need report");
        }
    }

    private void tt(int i) {
        this.sl.set(i);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime == 0) {
            yp.c().c(this.x, "currentElapsedRealTime");
        }
        switch (i) {
            case 11:
                this.da.set(jElapsedRealtime);
                this.t.set(jElapsedRealtime);
                break;
            case 12:
                if (this.t.get() != 0) {
                    this.da.set(jElapsedRealtime);
                }
                break;
            case 13:
                if (this.t.get() != 0) {
                    c(jElapsedRealtime, i);
                }
                break;
            case 15:
                if (this.da.get() != 0 && this.sl.get() != 14) {
                    c(jElapsedRealtime, i);
                    break;
                }
                break;
        }
    }

    private void c(long j, int i) {
        uj.c(String.valueOf(j - (this.da.get() == 0 ? this.t : this.da).get()), this.x, this.i, i, tt());
        this.da.set(0L);
    }

    private boolean uj(int i) {
        return !this.u && ve(i);
    }

    public void c(float f, int i) {
        if (uj(i)) {
            return;
        }
        c(f);
        tt(i);
    }

    public void c(float f) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f >= 1.0f) {
            c(jCurrentTimeMillis);
            tt(jCurrentTimeMillis);
            ve(jCurrentTimeMillis);
            uj(jCurrentTimeMillis);
            n(jCurrentTimeMillis);
            return;
        }
        double d = f;
        if (d >= 0.75d) {
            c(jCurrentTimeMillis);
            tt(jCurrentTimeMillis);
            ve(jCurrentTimeMillis);
            uj(jCurrentTimeMillis);
            return;
        }
        if (d >= 0.5d) {
            c(jCurrentTimeMillis);
            tt(jCurrentTimeMillis);
            ve(jCurrentTimeMillis);
        } else if (d >= 0.25d) {
            c(jCurrentTimeMillis);
            tt(jCurrentTimeMillis);
        } else if (f > 0.0f) {
            c(jCurrentTimeMillis);
        }
    }

    public Map<String, Long> tt() {
        HashMap map = new HashMap();
        try {
            long j = this.ve;
            if (j > 0) {
                map.put("show_start", Long.valueOf(j));
                long j2 = this.uj;
                if (j2 > 0) {
                    map.put("show_firstQuartile", Long.valueOf(j2));
                    long j3 = this.n;
                    if (j3 > 0) {
                        map.put("show_mid", Long.valueOf(j3));
                        long j4 = this.f2072a;
                        if (j4 > 0) {
                            map.put("show_thirdQuartile", Long.valueOf(j4));
                            long j5 = this.sp;
                            if (j5 > 0) {
                                map.put("show_full", Long.valueOf(j5));
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }
}
