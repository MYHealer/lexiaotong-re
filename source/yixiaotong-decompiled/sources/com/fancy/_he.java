package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _he implements Runnable {
    public final /* synthetic */ NiceVideoPlayer _a;

    public _he(NiceVideoPlayer niceVideoPlayer) {
        this._a = niceVideoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        MediaPlayer mediaPlayer = niceVideoPlayer._d;
        if (mediaPlayer == null) {
            return;
        }
        if (niceVideoPlayer._l == 3) {
            mediaPlayer.pause();
            NiceVideoPlayer niceVideoPlayer2 = this._a;
            niceVideoPlayer2._l = 4;
            niceVideoPlayer2._a(4);
        }
        NiceVideoPlayer niceVideoPlayer3 = this._a;
        if (niceVideoPlayer3._l == 5) {
            niceVideoPlayer3._d.pause();
            NiceVideoPlayer niceVideoPlayer4 = this._a;
            niceVideoPlayer4._l = 6;
            niceVideoPlayer4._a(6);
        }
        NiceVideoPlayer niceVideoPlayer5 = this._a;
        if (niceVideoPlayer5._v || niceVideoPlayer5._l != 1) {
            return;
        }
        niceVideoPlayer5._w = true;
        niceVideoPlayer5._l = 4;
        niceVideoPlayer5._a(4);
    }
}
