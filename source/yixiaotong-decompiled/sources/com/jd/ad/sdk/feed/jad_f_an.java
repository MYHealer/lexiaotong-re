package com.jd.ad.sdk.feed;

import com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_an implements OnUserCancelJdJumpCallback {
    public final /* synthetic */ jad_f_bo jad_f_an;

    public jad_f_an(jad_f_bo jad_f_boVar) {
        this.jad_f_an = jad_f_boVar;
    }

    @Override // com.jd.ad.sdk.bl.adinteraction.deeplink.OnUserCancelJdJumpCallback
    public void callback(int i) {
        jad_f_bo.jad_f_an jad_f_anVar = this.jad_f_an.jad_f_kx;
        if (jad_f_anVar != null) {
            JADFeed.this.reportClickEvent(i);
        }
    }
}
