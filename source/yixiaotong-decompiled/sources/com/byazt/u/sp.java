package com.byazt.u;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 67, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {
    public Object c = new Object();
    public Queue<tt> tt = new ConcurrentLinkedQueue();
    public Handler uj;
    public c ve;

    public sp(String str) {
        this.ve = new c(str);
    }

    public void c() {
        this.ve.start();
    }

    public void c(Runnable runnable) {
        c(runnable, 0L);
    }

    public void c(Runnable runnable, long j) {
        if (this.uj == null) {
            synchronized (this.c) {
                if (this.uj == null) {
                    this.tt.add(new tt(runnable, j));
                    return;
                }
            }
        }
        this.uj.postDelayed(runnable, j);
    }

    public void tt() {
        this.ve.quit();
    }

    @com.byazt.zqa.c(c = {0, 1, 67, 180})
    private class c extends HandlerThread {
        public c(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (sp.this.c) {
                sp.this.uj = new Handler(looper);
            }
            while (!sp.this.tt.isEmpty()) {
                tt ttVar = (tt) sp.this.tt.poll();
                if (ttVar != null) {
                    sp.this.uj.postDelayed(ttVar.c, ttVar.tt);
                }
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 67, 904})
    private class tt {
        public Runnable c;
        public long tt;

        public tt(Runnable runnable, long j) {
            this.c = runnable;
            this.tt = j;
        }
    }
}
