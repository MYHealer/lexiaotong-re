package com.byazt.z;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.byazt.t.DownloadInfo;
import com.byazt.y.JumpUnknownSourceActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import java.lang.ref.SoftReference;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f2910a;
    public final Queue<Integer> c;
    public SoftReference<JumpUnknownSourceActivity> n;
    public Runnable sp;
    public boolean tt;
    public long uj;
    public long ve;

    @com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 180})
    private static class c {
        public static final sp c = new sp();
    }

    private sp() {
        this.c = new ArrayDeque();
        this.tt = false;
        this.f2910a = new Handler(Looper.getMainLooper());
        this.sp = new Runnable() { // from class: com.byazt.z.sp.1
            @Override // java.lang.Runnable
            public void run() {
                sp.this.ve();
            }
        };
        com.byazt.g.c.c().c(new com.byazt.g.c.InterfaceC0156c() { // from class: com.byazt.z.sp.2
            @Override // com.byazt.g.c.InterfaceC0156c
            public void ve() {
            }

            @Override // com.byazt.g.c.InterfaceC0156c
            public void tt() {
                if (sp.this.c.isEmpty()) {
                    return;
                }
                long jC = com.byazt.k.c.ve().c("install_on_resume_install_interval", 120000L);
                long jCurrentTimeMillis = System.currentTimeMillis() - sp.this.uj;
                if (jCurrentTimeMillis < jC) {
                    if (sp.this.f2910a.hasCallbacks(sp.this.sp)) {
                        return;
                    }
                    sp.this.f2910a.postDelayed(sp.this.sp, jC - jCurrentTimeMillis);
                } else {
                    sp.this.uj = System.currentTimeMillis();
                    sp.this.ve();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        final Integer numPoll;
        if (Build.VERSION.SDK_INT < 29 || com.byazt.g.c.c().tt()) {
            synchronized (this.c) {
                numPoll = this.c.poll();
            }
            this.f2910a.removeCallbacks(this.sp);
            if (numPoll == null) {
                this.tt = false;
                return;
            }
            final Context contextIc = com.byazt.zz.ve.ic();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                this.f2910a.post(new Runnable() { // from class: com.byazt.z.sp.3
                    @Override // java.lang.Runnable
                    public void run() {
                        sp.this.tt(contextIc, numPoll.intValue(), false);
                    }
                });
            } else {
                tt(contextIc, numPoll.intValue(), false);
            }
            this.f2910a.postDelayed(this.sp, SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US);
        }
    }

    public void c(DownloadInfo downloadInfo, String str) {
        if (downloadInfo == null || TextUtils.isEmpty(str)) {
            return;
        }
        ve();
    }

    public static sp c() {
        return c.c;
    }

    public int c(final Context context, final int i, final boolean z) {
        if (z) {
            return tt(context, i, z);
        }
        if (uj()) {
            this.f2910a.postDelayed(new Runnable() { // from class: com.byazt.z.sp.4
                @Override // java.lang.Runnable
                public void run() {
                    sp.this.c(context, i, z);
                }
            }, 1000L);
            return 1;
        }
        if (com.byazt.g.c.c().tt()) {
            com.byazt.x.c.ve("leaves", "on Foreground");
            return tt(context, i, z);
        }
        if (tt.c()) {
            return 1;
        }
        boolean z2 = Build.VERSION.SDK_INT < 29;
        if (this.c.isEmpty() && !this.tt && z2) {
            return tt(context, i, z);
        }
        int iC = com.byazt.k.c.ve().c("install_queue_size", 3);
        synchronized (this.c) {
            while (this.c.size() > iC) {
                this.c.poll();
            }
        }
        if (z2) {
            this.f2910a.removeCallbacks(this.sp);
            this.f2910a.postDelayed(this.sp, com.byazt.k.c.c(i).c("install_queue_timeout", SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US));
        }
        synchronized (this.c) {
            if (!this.c.contains(Integer.valueOf(i))) {
                this.c.offer(Integer.valueOf(i));
            }
        }
        return 1;
    }

    private boolean uj() {
        return System.currentTimeMillis() - this.ve < 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int tt(Context context, int i, boolean z) {
        int iTt = ve.tt(context, i, z);
        if (iTt == 1) {
            this.tt = true;
        }
        this.ve = System.currentTimeMillis();
        return iTt;
    }

    public void c(JumpUnknownSourceActivity jumpUnknownSourceActivity) {
        this.n = new SoftReference<>(jumpUnknownSourceActivity);
    }

    public JumpUnknownSourceActivity tt() {
        SoftReference<JumpUnknownSourceActivity> softReference = this.n;
        JumpUnknownSourceActivity jumpUnknownSourceActivity = softReference == null ? null : softReference.get();
        this.n = null;
        return jumpUnknownSourceActivity;
    }
}
