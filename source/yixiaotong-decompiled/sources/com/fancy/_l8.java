package com.fancy;

import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l8 implements Runnable {
    public final /* synthetic */ PtgVideoView _a;

    public _l8(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgCoreVideo ptgCoreVideo;
        PtgVideoView ptgVideoView = this._a;
        if (!_iq._a(ptgVideoView._b) || (ptgCoreVideo = ptgVideoView._j) == null || ptgCoreVideo.getCurrStatus() == 7 || ptgVideoView._j.getCurrStatus() == 3) {
            return;
        }
        PtgVideoView ptgVideoView2 = this._a;
        if (ptgVideoView2._j == null || ptgVideoView2.getWindowVisibility() != 0) {
            return;
        }
        if (this._a._j.getCurrStatus() != 4) {
            this._a.getClass();
            this._a._j._c();
        } else {
            PtgCoreVideo ptgCoreVideo2 = this._a._j;
            ptgCoreVideo2.getClass();
            PtgCoreVideo._a(new _iw(ptgCoreVideo2));
        }
    }
}
