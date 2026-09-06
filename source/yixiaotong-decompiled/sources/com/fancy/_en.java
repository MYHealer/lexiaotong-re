package com.fancy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.interf.PtgNativeExpressAd;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface _en {
    void _a();

    void _a(Context context, _f _fVar, AtomicBoolean atomicBoolean);

    void _a(ViewGroup viewGroup);

    void _a(_dj _djVar);

    void _a(PtgNativeExpressAd.AdInteractionListener adInteractionListener);

    void _b();

    View _c();

    PtgNativeExpressAd.CustomizeVideo getCustomizeVideo();

    void pauseVideo();

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void startVideo();
}
