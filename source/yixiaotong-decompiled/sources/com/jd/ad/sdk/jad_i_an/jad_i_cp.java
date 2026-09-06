package com.jd.ad.sdk.jad_i_an;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: compiled from: JADInterstitialRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_i_cp implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.interstitial.jad_i_an jad_i_an;

    public jad_i_cp(com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar) {
        this.jad_i_an = jad_i_anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            this.jad_i_an.jad_i_jw = false;
            com.jd.ad.sdk.interstitial.jad_i_an jad_i_anVar = this.jad_i_an;
            jad_i_anVar.jad_i_an(jad_i_anVar.jad_i_mz);
            Dialog dialog = this.jad_i_an.jad_i_iv;
            if (dialog != null) {
                dialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }
}
