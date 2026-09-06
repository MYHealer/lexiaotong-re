package com.meishu.sdk.core.safe;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SafeOnVideoSizeChangedListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k implements MediaPlayer.OnVideoSizeChangedListener {
    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            safeOnVideoSizeChanged(mediaPlayer, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
    }
}
