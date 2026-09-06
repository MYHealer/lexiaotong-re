package com.byazt.rc;

import com.byazt.yj.sp;
import com.byazt.yj.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME, 15})
public class uj<T> implements sp {
    public Map<String, String> c;
    public x n;
    public int tt;
    public String uj;
    public T ve;

    @Override // com.byazt.yj.sp
    public x c() {
        return this.n;
    }

    public void c(x xVar) {
        this.n = xVar;
    }

    @Override // com.byazt.yj.sp
    public Map<String, String> n() {
        return this.c;
    }

    @Override // com.byazt.yj.sp
    public int tt() {
        return this.tt;
    }

    @Override // com.byazt.yj.sp
    public String uj() {
        return this.uj;
    }

    @Override // com.byazt.yj.sp
    public T ve() {
        return this.ve;
    }

    public uj(int i, T t, String str) {
        this.tt = i;
        this.ve = t;
        this.uj = str;
    }

    public uj(int i, T t, String str, Map<String, String> map) {
        this(i, t, str);
        this.c = map;
    }
}
