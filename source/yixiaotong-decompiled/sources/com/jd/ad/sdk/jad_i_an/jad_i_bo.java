package com.jd.ad.sdk.jad_i_an;

import android.view.MotionEvent;
import android.view.View;
import com.jd.ad.sdk.mdt.service.JADTouchService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* JADX INFO: compiled from: JADInterstitialRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_i_bo implements View.OnTouchListener {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_bo(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        JADTouchService touchService = JADMediator.getInstance().getTouchService();
        com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.jad_i_an;
        touchService.onViewTouch(jad_i_anVar.jad_i_mz, motionEvent, jad_i_anVar.jad_i_dq);
        return false;
    }
}
