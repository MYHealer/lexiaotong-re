package com.fancy;

import android.media.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h2 implements Runnable {
    public final /* synthetic */ MediaPlayer _a;

    public _h2(MediaPlayer mediaPlayer) {
        this._a = mediaPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this._a.release();
        } catch (Throwable unused) {
        }
    }
}
