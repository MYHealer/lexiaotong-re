package com.miui.zeus.mimo.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class j$$Lambda$4 implements MediaPlayer.OnVideoSizeChangedListener {
    private final j arg$1;

    private j$$Lambda$4(j jVar) {
        this.arg$1 = jVar;
    }

    public static MediaPlayer.OnVideoSizeChangedListener lambdaFactory$(j jVar) {
        return new j$$Lambda$4(jVar);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.arg$1.b(mediaPlayer, i, i2);
    }
}
