package com.hihonor.adsdk.base.mediation.comm;

import android.content.Context;
import android.widget.FrameLayout;
import com.hihonor.adsdk.base.mediation.comm.c.c;
import com.hihonor.adsdk.base.mediation.comm.pi.LADI;
import com.hihonor.adsdk.base.mediation.comm.pi.NFBI;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class NativeExpressADView extends FrameLayout implements c, LADI, NFBI {
    public NativeExpressADView(Context context) {
        super(context);
    }

    public abstract void destroy();

    public abstract AdData getBoundData();

    public abstract void negativeFeedback();

    public abstract void preloadVideo();

    public abstract void render();

    public abstract void setMediaListener(NativeExpressMediaListener nativeExpressMediaListener);
}
