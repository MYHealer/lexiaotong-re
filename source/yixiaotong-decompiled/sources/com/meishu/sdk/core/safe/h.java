package com.meishu.sdk.core.safe;

import android.media.MediaPlayer;

/* JADX INFO: compiled from: SafeMediaPlayerOnPreparedListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h implements MediaPlayer.OnPreparedListener {
    public void a(MediaPlayer mediaPlayer) {
        throw null;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        try {
            a(mediaPlayer);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }
}
