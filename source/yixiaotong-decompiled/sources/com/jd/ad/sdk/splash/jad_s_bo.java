package com.jd.ad.sdk.splash;

import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;

/* JADX INFO: compiled from: JADSplashRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_bo implements OnUserCancelJdJumpCallback {
    public final /* synthetic */ jad_s_an jad_s_an;

    public jad_s_bo(jad_s_an jad_s_anVar) {
        this.jad_s_an = jad_s_anVar;
    }

    @Override // com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback
    public void callback(int i) {
        jad_s_an jad_s_anVar = this.jad_s_an;
        jad_s_an.jad_s_cp jad_s_cpVar = jad_s_anVar.jad_s_hu;
        if (jad_s_cpVar != null) {
            JADSplash.this.reportClickEvent(i, jad_s_anVar.jad_s_tg, jad_s_anVar.jad_s_re, jad_s_anVar.jad_s_sf);
        }
    }
}
