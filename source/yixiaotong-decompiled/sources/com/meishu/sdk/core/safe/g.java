package com.meishu.sdk.core.safe;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SafeMediaPlayerOnInfoListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g implements MediaPlayer.OnInfoListener {
    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            return safeOnInfo(mediaPlayer, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
            return false;
        }
    }

    public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
