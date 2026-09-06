package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j7 implements Runnable {
    public final /* synthetic */ int _a;
    public final /* synthetic */ PtgCoreVideo _b;

    public _j7(PtgCoreVideo ptgCoreVideo, int i) {
        this._b = ptgCoreVideo;
        this._a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaPlayer mediaPlayer = this._b._f;
        if (mediaPlayer == null) {
            return;
        }
        mediaPlayer.seekTo(this._a, 3);
    }
}
