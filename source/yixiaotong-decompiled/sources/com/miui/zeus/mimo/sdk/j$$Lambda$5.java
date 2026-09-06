package com.miui.zeus.mimo.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class j$$Lambda$5 implements MediaPlayer.OnInfoListener {
    private final j arg$1;

    private j$$Lambda$5(j jVar) {
        this.arg$1 = jVar;
    }

    public static MediaPlayer.OnInfoListener lambdaFactory$(j jVar) {
        return new j$$Lambda$5(jVar);
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return this.arg$1.c(mediaPlayer, i, i2);
    }
}
