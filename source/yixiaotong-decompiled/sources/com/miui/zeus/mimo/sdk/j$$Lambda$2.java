package com.miui.zeus.mimo.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final /* synthetic */ class j$$Lambda$2 implements MediaPlayer.OnCompletionListener {
    private final j arg$1;

    private j$$Lambda$2(j jVar) {
        this.arg$1 = jVar;
    }

    public static MediaPlayer.OnCompletionListener lambdaFactory$(j jVar) {
        return new j$$Lambda$2(jVar);
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.arg$1.b(mediaPlayer);
    }
}
