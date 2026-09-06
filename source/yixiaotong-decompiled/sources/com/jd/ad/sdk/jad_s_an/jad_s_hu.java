package com.jd.ad.sdk.jad_s_an;

import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_hu implements View.OnTouchListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_hu(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADMediator.getInstance().getTouchService().onViewTouch(view, motionEvent, this.jad_s_an.jad_s_dq);
        return false;
    }
}
