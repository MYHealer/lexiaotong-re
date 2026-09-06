package com.jd.ad.sdk.banner.jad_b_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_fs implements Runnable {
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_bo jad_b_an;

    public jad_b_fs(com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar) {
        this.jad_b_an = jad_b_boVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        View view = this.jad_b_an.jad_b_jt;
        if (view == null || view.getParent() == null) {
            return;
        }
        ((ViewGroup) this.jad_b_an.jad_b_jt.getParent()).removeView(this.jad_b_an.jad_b_jt);
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_an;
        jad_b_boVar.jad_b_an(jad_b_boVar.jad_b_jt, CommonConstants.ClickFrom.CUSTOM_CLOSE.ordinal());
        this.jad_b_an.jad_b_an();
    }
}
