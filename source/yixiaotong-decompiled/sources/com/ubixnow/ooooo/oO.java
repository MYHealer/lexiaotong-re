package com.ubixnow.ooooo;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum oO {
    LOAD_SUCC(801, "加载成功"),
    LOAD_FAIL(802, "加载失败"),
    LOAD_TIME_OUT(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT, "加载超时"),
    EXECUTE_SHOW(804, "调用了show方法");

    private int OooO0o;
    private String OooO0oO;

    oO(int i, String str) {
        this.OooO0o = i;
        this.OooO0oO = str;
    }

    public int OooO00o() {
        return this.OooO0o;
    }

    public String OooO0O0() {
        return this.OooO0oO;
    }
}
