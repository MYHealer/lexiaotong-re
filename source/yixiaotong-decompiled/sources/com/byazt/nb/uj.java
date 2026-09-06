package com.byazt.nb;

import com.byazt.jx.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2494a;
    public final List<m> c;
    public final String n;
    public final char tt;
    public final double uj;
    public final double ve;

    public List<m> c() {
        return this.c;
    }

    public double tt() {
        return this.uj;
    }

    public static int c(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public uj(List<m> list, char c, double d, double d2, String str, String str2) {
        this.c = list;
        this.tt = c;
        this.ve = d;
        this.uj = d2;
        this.n = str;
        this.f2494a = str2;
    }

    public int hashCode() {
        return c(this.tt, this.f2494a, this.n);
    }
}
