package com.fancy;

import android.view.View;
import com.fancy.mpsdk.component.video.PtgVideoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lb implements View.OnClickListener {
    public final /* synthetic */ PtgVideoView _a;

    public _lb(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PtgVideoView ptgVideoView = this._a;
        ptgVideoView.setSoundMute(!ptgVideoView._n);
    }
}
