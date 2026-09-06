package com.adprof.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class km implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ lm f1270a;

    public km(lm lmVar) {
        this.f1270a = lmVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        x2 x2Var = this.f1270a.f1292a;
        MediaPlayer mediaPlayer = x2Var.f824a;
        if (mediaPlayer != null) {
            if (mediaPlayer.getCurrentPosition() == 0) {
                x2Var.f824a.seekTo(x2Var.f1513a);
            }
            x2Var.f824a.start();
        }
    }
}
