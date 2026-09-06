package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _h4 implements Runnable {
    public final /* synthetic */ long _a;
    public final /* synthetic */ NiceVideoPlayer _b;

    public _h4(NiceVideoPlayer niceVideoPlayer, long j) {
        this._b = niceVideoPlayer;
        this._a = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaPlayer mediaPlayer = this._b._d;
        if (mediaPlayer != null) {
            mediaPlayer.seekTo((int) this._a);
        }
    }
}
