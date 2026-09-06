package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nu implements NiceVideoPlayer._i {
    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer._i
    public final void onTimeout() {
    }
}
