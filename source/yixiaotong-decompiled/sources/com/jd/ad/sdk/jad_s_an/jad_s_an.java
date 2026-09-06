package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.splash.JADSplashSkipView;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_an implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_an(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADSplashSkipView jADSplashSkipView = this.jad_s_an.jad_s_kx;
        if (jADSplashSkipView != null) {
            jADSplashSkipView.removeCallbacks(null);
        }
        View view2 = this.jad_s_an.jad_s_iv;
        if (view2 == null || view2.getContext() == null) {
            return;
        }
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_iv.getContext(), this.jad_s_an.jad_s_iv, 1, 0, CommonConstants.AdTriggerSourceType.CLICK.ordinal());
    }
}
