package com.byazt.hs;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1404, 13})
public class tt {
    public static volatile boolean c = false;
    public static long sp = -1;
    public static final String tt = "tt";
    public static volatile tt x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2313a;
    public final sl ve = sl.c();
    public final AtomicInteger uj = new AtomicInteger();
    public final c n = new c(com.byazt.u.n.c());

    public static tt c() {
        if (x == null) {
            synchronized (tt.class) {
                if (x == null) {
                    x = new tt();
                }
            }
        }
        return x;
    }

    private tt() {
    }

    public void tt() {
        try {
            com.byazt.x.c.ve(tt, "startSampling: mSamplingCounter = " + this.uj);
            if (this.uj.getAndIncrement() == 0) {
                this.n.c();
                this.f2313a = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void ve() {
        try {
            com.byazt.x.c.ve(tt, "stopSampling: mSamplingCounter = " + this.uj);
            if (this.uj.decrementAndGet() == 0) {
                this.n.tt();
                sp();
            }
        } catch (Throwable unused) {
        }
    }

    public static long uj() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void n() {
        c = com.byazt.w.a.tt(com.byazt.zz.ve.ic());
    }

    public void a() {
        long mobileRxBytes;
        try {
            n();
            if (c) {
                mobileRxBytes = uj();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j = sp;
            long j2 = mobileRxBytes - j;
            if (j >= 0) {
                synchronized (this) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.ve.c(j2, jUptimeMillis - this.f2313a);
                    this.f2313a = jUptimeMillis;
                }
            }
            sp = mobileRxBytes;
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void sp() {
        a();
        sp = -1L;
    }

    @com.byazt.zqa.c(c = {0, 1, 1404, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    private class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            tt.this.a();
            sendEmptyMessageDelayed(1, 1000L);
        }

        public void c() {
            sendEmptyMessage(1);
        }

        public void tt() {
            removeMessages(1);
        }
    }
}
