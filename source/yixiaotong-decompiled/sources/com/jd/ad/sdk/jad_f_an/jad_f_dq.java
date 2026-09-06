package com.jd.ad.sdk.jad_f_an;

import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;

/* JADX INFO: compiled from: JADFeedRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_f_dq implements JADExposureListener {
    public final /* synthetic */ com.jd.ad.sdk.feed.jad_f_bo jad_f_an;

    public jad_f_dq(com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar) {
        this.jad_f_an = jad_f_boVar;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, String str, int i) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i);
        }
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        jad_f_boVar.jad_f_an(jad_f_boVar.jad_f_iv, true, str, i);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        jad_f_boVar.jad_f_an(jad_f_boVar.jad_f_iv, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        JADSlot jADSlot = this.jad_f_an.jad_f_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.feed.jad_f_bo jad_f_boVar = this.jad_f_an;
        jad_f_boVar.jad_f_an(jad_f_boVar.jad_f_iv, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
