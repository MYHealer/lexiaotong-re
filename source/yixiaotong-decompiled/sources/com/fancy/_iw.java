package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _iw implements Runnable {
    public final /* synthetic */ PtgCoreVideo _a;

    public _iw(PtgCoreVideo ptgCoreVideo) {
        this._a = ptgCoreVideo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgCoreVideo ptgCoreVideo;
        int i;
        if (this._a._f == null) {
            return;
        }
        Logger.d("PtgCoreVideo", _ie._a("mMediaPlayer restart: setVolume(").append(this._a._m).append(", ").append(this._a._n).append(")").toString());
        PtgCoreVideo ptgCoreVideo2 = this._a;
        ptgCoreVideo2._f.setVolume(ptgCoreVideo2._m, ptgCoreVideo2._n);
        PtgCoreVideo ptgCoreVideo3 = this._a;
        int i2 = ptgCoreVideo3._a;
        if (i2 == 4) {
            ptgCoreVideo3._f.start();
            this._a._f.setLooping(false);
            ptgCoreVideo = this._a;
            i = 3;
        } else if (i2 == 6) {
            ptgCoreVideo3._f.start();
            this._a._f.setLooping(false);
            ptgCoreVideo = this._a;
            i = 5;
        } else {
            if (i2 != 7 && i2 != -1) {
                return;
            }
            ptgCoreVideo3._f.reset();
            PtgCoreVideo ptgCoreVideo4 = this._a;
            PtgCoreVideo._a(new _j6(ptgCoreVideo4, ptgCoreVideo4._h));
            ptgCoreVideo = this._a;
            i = 10;
        }
        ptgCoreVideo._a = i;
        ptgCoreVideo._a(i);
    }
}
