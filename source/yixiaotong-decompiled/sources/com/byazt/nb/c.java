package com.byazt.nb;

import android.graphics.PointF;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 20})
public class c {
    public final PointF c;
    public final PointF tt;
    public final PointF ve;

    public PointF c() {
        return this.c;
    }

    public PointF tt() {
        return this.tt;
    }

    public PointF ve() {
        return this.ve;
    }

    public c() {
        this.c = new PointF();
        this.tt = new PointF();
        this.ve = new PointF();
    }

    public c(PointF pointF, PointF pointF2, PointF pointF3) {
        this.c = pointF;
        this.tt = pointF2;
        this.ve = pointF3;
    }

    public void c(float f, float f2) {
        this.c.set(f, f2);
    }

    public void tt(float f, float f2) {
        this.tt.set(f, f2);
    }

    public void ve(float f, float f2) {
        this.ve.set(f, f2);
    }

    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.ve.x), Float.valueOf(this.ve.y), Float.valueOf(this.c.x), Float.valueOf(this.c.y), Float.valueOf(this.tt.x), Float.valueOf(this.tt.y));
    }
}
