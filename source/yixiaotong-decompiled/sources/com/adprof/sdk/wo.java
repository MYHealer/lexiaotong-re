package com.adprof.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ep f1508a;

    public wo(ep epVar) {
        this.f1508a = epVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        MediaPlayer mediaPlayer = this.f1508a.f263a;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.start();
    }
}
