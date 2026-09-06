package com.jd.ad.sdk.banner.jad_b_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.dl.common.CommonConstants;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_cp implements View.OnClickListener {
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_bo jad_b_an;

    public jad_b_cp(com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar) {
        this.jad_b_an = jad_b_boVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_an;
        jad_b_boVar.jad_b_an(jad_b_boVar.jad_b_jt, CommonConstants.ClickFrom.CLOSE.ordinal());
        View view2 = this.jad_b_an.jad_b_jt;
        if (view2 == null || view2.getParent() == null) {
            return;
        }
        ((ViewGroup) this.jad_b_an.jad_b_jt.getParent()).removeView(this.jad_b_an.jad_b_jt);
    }
}
