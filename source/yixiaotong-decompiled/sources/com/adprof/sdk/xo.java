package com.adprof.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class xo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ep f1526a;

    public xo(ep epVar) {
        this.f1526a = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer = this.f1526a.f263a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.pause();
    }
}
