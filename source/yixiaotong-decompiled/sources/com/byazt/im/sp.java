package com.byazt.im;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1352, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2340a;
    public long da;
    public com.byazt.nc.tt i;
    public String n;
    public int sl;
    public int sp;
    public int uj;
    public boolean x;

    public boolean a() {
        return this.f2340a;
    }

    @Override // com.byazt.im.c
    public void c(long j) {
        this.da = j;
    }

    public void c(com.byazt.nc.tt ttVar) {
        this.i = ttVar;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(boolean z) {
        this.f2340a = z;
    }

    public com.byazt.nc.tt i() {
        return this.i;
    }

    public int sp() {
        return this.sp;
    }

    public void tt(int i) {
        this.uj = i;
    }

    public void tt(boolean z) {
        this.x = z;
    }

    public int uj() {
        return this.uj;
    }

    public void uj(int i) {
        this.sp = i;
    }

    @Override // com.byazt.im.c
    public long ve() {
        return this.da;
    }

    public void ve(int i) {
        this.sl = i;
    }

    public boolean x() {
        return this.x;
    }

    public sp() {
        this.uj = -1;
        this.n = "unknown";
        this.f2340a = false;
        this.x = false;
        this.sl = -1;
    }

    public sp(int i, String str, boolean z) {
        this.f2340a = false;
        this.sl = -1;
        this.uj = i;
        this.n = str;
        this.x = z;
    }

    public String n() {
        return TextUtils.isEmpty(this.n) ? "unknown" : this.n;
    }
}
