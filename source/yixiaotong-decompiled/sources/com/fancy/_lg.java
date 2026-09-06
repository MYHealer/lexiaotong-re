package com.fancy;

import android.widget.ImageView;
import com.fancy.mpsdk.component.video.PtgVideoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lg implements Runnable {
    public final /* synthetic */ PtgVideoView _a;

    public _lg(PtgVideoView ptgVideoView) {
        this._a = ptgVideoView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PtgVideoView ptgVideoView = this._a;
        int i = PtgVideoView._v;
        ptgVideoView.getClass();
        ImageView imageView = this._a._g;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
