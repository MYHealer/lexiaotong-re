package com.byazt.gqp;

import com.byazt.eg.md;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL, 158})
public class sl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2264a;
    public long c;
    public long n;
    public long sp;
    public long tt;
    public long uj;
    public long ve;

    public void c(long j) {
        this.f2264a = j;
    }

    public void tt(long j) {
        this.sp = j;
    }

    public sl() {
        this.c = System.currentTimeMillis();
    }

    public sl(Object obj) {
        this.c = System.currentTimeMillis();
        try {
            if (obj instanceof md) {
                md mdVar = (md) obj;
                this.c = mdVar.uj();
                this.tt = mdVar.da();
                this.ve = mdVar.n();
                this.uj = mdVar.a();
                this.n = mdVar.sp();
                this.f2264a = mdVar.x();
                this.sp = mdVar.i();
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public void c() {
        this.ve = System.currentTimeMillis();
    }

    public void tt() {
        this.uj = System.currentTimeMillis();
    }

    public void ve() {
        this.n = System.currentTimeMillis();
    }

    public void uj() {
        this.tt = System.currentTimeMillis();
    }
}
