package com.meishu.sdk.core.safe;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SafeMediaPlayerOnErrorListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class f implements MediaPlayer.OnErrorListener {
    public boolean a(MediaPlayer mediaPlayer, int i, int i2) {
        throw null;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        try {
            return a(mediaPlayer, i, i2);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
            return false;
        }
    }
}
