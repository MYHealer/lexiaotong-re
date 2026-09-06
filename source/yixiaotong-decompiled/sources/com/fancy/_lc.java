package com.fancy;

import android.widget.FrameLayout;
import android.widget.ImageView;
import com.fancy.mpsdk.component.video.PtgVideoView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lc implements Runnable {
    public final /* synthetic */ FrameLayout.LayoutParams _a;
    public final /* synthetic */ PtgVideoView _b;

    public _lc(PtgVideoView ptgVideoView, FrameLayout.LayoutParams layoutParams) {
        this._b = ptgVideoView;
        this._a = layoutParams;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FrameLayout.LayoutParams layoutParams;
        ImageView imageView = this._b._g;
        if (imageView == null || (layoutParams = this._a) == null) {
            return;
        }
        imageView.setLayoutParams(layoutParams);
        this._b._g.setVisibility(0);
    }
}
