package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hc implements Callable<Boolean> {
    public final /* synthetic */ NiceVideoPlayer _a;

    public _hc(NiceVideoPlayer niceVideoPlayer) {
        this._a = niceVideoPlayer;
    }

    @Override // java.util.concurrent.Callable
    public final Boolean call() {
        MediaPlayer mediaPlayer = this._a._d;
        boolean z = mediaPlayer != null && mediaPlayer.isPlaying();
        this._a._k = z;
        return Boolean.valueOf(z);
    }
}
