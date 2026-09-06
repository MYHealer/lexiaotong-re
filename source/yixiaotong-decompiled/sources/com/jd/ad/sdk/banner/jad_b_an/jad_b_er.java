package com.jd.ad.sdk.banner.jad_b_an;

import android.view.View;
import com.jd.ad.sdk.banner.JADBanner;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_er implements View.OnClickListener {
    public final /* synthetic */ View jad_b_an;
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_bo jad_b_bo;

    public jad_b_er(com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar, View view) {
        this.jad_b_bo = jad_b_boVar;
        this.jad_b_an = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        JADBanner.jad_b_jw jad_b_jwVar;
        WeakReference<JADBanner> weakReference;
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_bo;
        View view2 = this.jad_b_an;
        jad_b_boVar.getClass();
        if (view2 == null) {
            return;
        }
        JADMediator.getInstance().getExposureService().setViewForceExposure(jad_b_boVar.jad_b_dq);
        int iOnViewClicked = JADMediator.getInstance().getTouchService().onViewClicked(view2.getContext(), view2, jad_b_boVar.jad_b_dq, new com.jd.ad.sdk.banner.jad_b_an(jad_b_boVar));
        com.jd.ad.sdk.banner.jad_b_bo.InterfaceC0545jad_b_bo interfaceC0545jad_b_bo = jad_b_boVar.jad_b_iv;
        if (interfaceC0545jad_b_bo == null || (weakReference = (jad_b_jwVar = (JADBanner.jad_b_jw) interfaceC0545jad_b_bo).jad_b_an) == null || weakReference.get() == null) {
            return;
        }
        JADBanner jADBanner = jad_b_jwVar.jad_b_an.get();
        jADBanner.reportClickEvent(iOnViewClicked);
        jADBanner.callbackAdClickOnUiThread();
    }
}
