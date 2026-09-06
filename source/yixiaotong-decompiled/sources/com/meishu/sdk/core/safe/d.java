package com.meishu.sdk.core.safe;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SafeMediaPlayerOnBufferingUpdateListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d implements MediaPlayer.OnBufferingUpdateListener {
    public void a(MediaPlayer mediaPlayer, int i) {
        throw null;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        try {
            a(mediaPlayer, i);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }
}
