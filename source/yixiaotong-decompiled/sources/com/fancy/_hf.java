package com.fancy;

import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hf implements Runnable {
    public final /* synthetic */ NiceVideoPlayer _a;

    public _hf(NiceVideoPlayer niceVideoPlayer) {
        this._a = niceVideoPlayer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NiceVideoPlayer niceVideoPlayer = this._a;
        if (niceVideoPlayer._d == null) {
            return;
        }
        if (niceVideoPlayer._l == 4 || !((Boolean) NiceVideoPlayer._a(new _hc(niceVideoPlayer), Boolean.valueOf(niceVideoPlayer._k))).booleanValue()) {
            this._a._d.start();
            NiceVideoPlayer niceVideoPlayer2 = this._a;
            niceVideoPlayer2._l = 3;
            niceVideoPlayer2._a(8);
            return;
        }
        NiceVideoPlayer niceVideoPlayer3 = this._a;
        int i = niceVideoPlayer3._l;
        if (i == 6) {
            niceVideoPlayer3._d.start();
            NiceVideoPlayer niceVideoPlayer4 = this._a;
            niceVideoPlayer4._l = 5;
            niceVideoPlayer4._a(5);
            return;
        }
        if (i == 7 || i == -1) {
            niceVideoPlayer3._d.reset();
            NiceVideoPlayer niceVideoPlayer5 = this._a;
            niceVideoPlayer5.getClass();
            NiceVideoPlayer._a(new _hd(niceVideoPlayer5));
        }
    }
}
