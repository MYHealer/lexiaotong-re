package com.miui.zeus.mimo.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class j$$Lambda$1 implements MediaPlayer.OnPreparedListener {
    private final j arg$1;

    private j$$Lambda$1(j jVar) {
        this.arg$1 = jVar;
    }

    public static MediaPlayer.OnPreparedListener lambdaFactory$(j jVar) {
        return new j$$Lambda$1(jVar);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        this.arg$1.a(mediaPlayer);
    }
}
