package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _iv implements Callable<int[]> {
    public final /* synthetic */ PtgCoreVideo _a;

    public _iv(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }

    @Override // java.util.concurrent.Callable
    public final int[] call() {
        MediaPlayer mediaPlayer = this._a._f;
        if (mediaPlayer == null) {
            return null;
        }
        return new int[]{mediaPlayer.getVideoWidth(), this._a._f.getVideoHeight()};
    }
}
