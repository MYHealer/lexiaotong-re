package com.jd.ad.sdk.splash;

import android.view.View;

/* JADX INFO: compiled from: JADSplashSkipView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_er implements View.OnClickListener {
    public final /* synthetic */ JADSplashSkipView jad_s_an;

    public jad_s_er(JADSplashSkipView jADSplashSkipView) {
        this.jad_s_an = jADSplashSkipView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADSplashSkipView.jad_s_bo jad_s_boVar = this.jad_s_an.jad_s_bo;
        if (jad_s_boVar != null) {
            jad_s_cp jad_s_cpVar = (jad_s_cp) jad_s_boVar;
            jad_s_an.jad_s_an(jad_s_cpVar.jad_s_an, view);
            JADSplashSkipView jADSplashSkipView = jad_s_cpVar.jad_s_an.jad_s_kx;
            if (jADSplashSkipView != null) {
                jADSplashSkipView.removeCallbacks(null);
            }
        }
    }
}
