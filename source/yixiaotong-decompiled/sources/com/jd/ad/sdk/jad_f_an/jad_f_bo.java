package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_bo implements Runnable {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_bo jad_f_an;

    public jad_f_bo(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar) {
        this.jad_f_an = jad_f_boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.jad_f_an.jad_f_iv;
        if (view == null || view.getParent() == null || !(this.jad_f_an.jad_f_iv.getParent() instanceof ViewGroup)) {
            return;
        }
        ((ViewGroup) this.jad_f_an.jad_f_iv.getParent()).removeView(this.jad_f_an.jad_f_iv);
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        jad_f_boVar.jad_f_an(jad_f_boVar.jad_f_iv, CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
    }
}
