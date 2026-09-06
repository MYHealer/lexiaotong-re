package com.fancy;

import android.media.MediaPlayer;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ix implements Runnable {
    public final /* synthetic */ PtgCoreVideo _a;

    public _ix(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgCoreVideo ptgCoreVideo = this._a;
        MediaPlayer mediaPlayer = ptgCoreVideo._f;
        if (mediaPlayer == null) {
            return;
        }
        int i = ptgCoreVideo._a;
        if (i == 3 || i == 2) {
            mediaPlayer.pause();
            PtgCoreVideo ptgCoreVideo2 = this._a;
            ptgCoreVideo2._a = 4;
            ptgCoreVideo2._a(4);
        }
        PtgCoreVideo ptgCoreVideo3 = this._a;
        if (ptgCoreVideo3._a == 5) {
            ptgCoreVideo3._f.pause();
            PtgCoreVideo ptgCoreVideo4 = this._a;
            ptgCoreVideo4._a = 6;
            ptgCoreVideo4._a(6);
        }
        PtgCoreVideo ptgCoreVideo5 = this._a;
        if (ptgCoreVideo5._o || ptgCoreVideo5._a != 1) {
            return;
        }
        ptgCoreVideo5._p = true;
        ptgCoreVideo5._a = 4;
        ptgCoreVideo5._a(4);
    }
}
