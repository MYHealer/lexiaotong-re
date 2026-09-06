package com.jd.ad.sdk.jad_s_an;

import android.view.View;
import com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_fs implements IDynamicInteractionListener {
    public final /* synthetic */ com.jd.ad.sdk.splash.jad_s_an jad_s_an;

    public jad_s_fs(com.jd.ad.sdk.splash.jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdSkip(View view) {
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(this.jad_s_an, view);
    }

    @Override // com.jd.ad.sdk.bl.dynamicrender.listener.IDynamicInteractionListener
    public void onAdClicked(int i, int i2) {
        com.jd.ad.sdk.splash.jad_s_an jad_s_anVar = this.jad_s_an;
        com.jd.ad.sdk.splash.jad_s_an.jad_s_an(jad_s_anVar, jad_s_anVar.jad_s_an(), this.jad_s_an.jad_s_jt, 3, i, i2);
    }
}
