package com.jd.ad.sdk.jad_f_an;

import android.view.View;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_fs implements View.OnClickListener {
    public final /* synthetic */ View jad_f_an;
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_bo jad_f_bo;

    public jad_f_fs(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar, View view) {
        this.jad_f_bo = jad_f_boVar;
        this.jad_f_an = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_bo;
        View view2 = this.jad_f_an;
        jad_f_boVar.getClass();
        if (view2 == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_f_boVar.jad_f_dq);
        int iOnViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view2.getContext(), view2, jad_f_boVar.jad_f_dq, new com.jd.ad.sdk.feed.jad_f_an(jad_f_boVar));
        com.jd.ad.sdk.feed.jad_f_bo.jad_f_an jad_f_anVar = jad_f_boVar.jad_f_kx;
        if (jad_f_anVar != null) {
            JADFeed.jad_f_dq jad_f_dqVar = (JADFeed.jad_f_dq) jad_f_anVar;
            JADFeed.this.reportClickEvent(iOnViewClicked);
            JADFeed.this.callbackAdClickOnUiThread();
        }
    }
}
