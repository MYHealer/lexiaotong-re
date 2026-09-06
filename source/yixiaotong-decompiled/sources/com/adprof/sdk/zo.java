package com.adprof.sdk;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class zo implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediaPlayer f1562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ep f922a;

    public zo(ep epVar, MediaPlayer mediaPlayer) {
        this.f922a = epVar;
        this.f1562a = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f1562a.setSurface(null);
        this.f1562a.release();
        this.f922a.f264a = null;
    }
}
