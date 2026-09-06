package com.kwad.sdk.core.video.videoview;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b extends RelativeLayout {
    protected final c aZI;
    private Runnable amB;

    protected abstract void onPlayStateChanged(int i);

    public void q(int i, int i2) {
    }

    protected abstract void reset();

    protected abstract void xk();

    public b(Context context, c cVar) {
        super(context);
        this.aZI = cVar;
    }

    protected final void xq() {
        xr();
        if (this.amB == null) {
            this.amB = new Runnable() { // from class: com.kwad.sdk.core.video.videoview.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.xk();
                    if (b.this.amB != null) {
                        b bVar = b.this;
                        bVar.postDelayed(bVar.amB, 1000L);
                    }
                }
            };
        }
        post(this.amB);
    }

    protected final void xr() {
        Runnable runnable = this.amB;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.amB = null;
        }
    }
}
