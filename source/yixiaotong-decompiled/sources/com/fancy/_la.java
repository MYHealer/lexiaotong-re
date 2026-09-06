package com.fancy;

import android.view.View;
import com.fancy.mpsdk.component.video.PtgVideoView;
import com.fancy.mpsdk.component.videoplayer2.PtgCoreVideo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _la implements View.OnClickListener {
    public final /* synthetic */ PtgVideoView _a;

    public _la(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgCoreVideo ptgCoreVideo = this._a._j;
        if (ptgCoreVideo == null) {
            return;
        }
        if (ptgCoreVideo.getCurrStatus() != 4) {
            this._a._j._c();
            return;
        }
        PtgCoreVideo ptgCoreVideo2 = this._a._j;
        ptgCoreVideo2.getClass();
        PtgCoreVideo._a(new _iw(ptgCoreVideo2));
    }
}
