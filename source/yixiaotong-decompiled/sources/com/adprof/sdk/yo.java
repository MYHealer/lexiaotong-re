package com.adprof.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class yo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f1544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f886a;

    public yo(ep epVar, long j) {
        this.f886a = epVar;
        this.f1544a = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            MediaPlayer mediaPlayer = this.f886a.f263a;
            if (mediaPlayer == null) {
                return;
            }
            mediaPlayer.seekTo((int) this.f1544a);
        } catch (IllegalStateException e) {
            pk.b("VideoPlayerMediaSystem seekTo error", e);
        }
    }
}
