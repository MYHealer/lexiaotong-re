package com.byazt.ete;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START})
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2208a;
    public int c;
    public String n;
    public double sp;
    public String tt;
    public double uj;
    public int ve;

    public double a() {
        return this.f2208a;
    }

    public int c() {
        return this.c;
    }

    public void c(double d) {
        this.uj = d;
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.tt = str;
    }

    public String n() {
        return this.n;
    }

    public double sp() {
        return this.sp;
    }

    public String tt() {
        return this.tt;
    }

    public void tt(double d) {
        this.f2208a = d;
    }

    public void tt(int i) {
        this.ve = i;
    }

    public void tt(String str) {
        this.n = str;
    }

    public double uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }

    public void ve(double d) {
        this.sp = d;
    }

    public boolean x() {
        return !TextUtils.isEmpty(this.n);
    }
}
