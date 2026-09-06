package com.jd.ad.sdk.banner.jad_b_an;

import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.dl.model.JADSlot;

/* JADX INFO: compiled from: JADBannerRender.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_b_an implements JADExposureListener {
    public final /* synthetic */ com.jd.ad.sdk.banner.jad_b_bo jad_b_an;

    public jad_b_an(com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar) {
        this.jad_b_an = jad_b_boVar;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, String str, int i) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(i);
        }
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_an;
        jad_b_boVar.jad_b_an(jad_b_boVar.jad_b_jt, true, str, i);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_an;
        jad_b_boVar.jad_b_an(jad_b_boVar.jad_b_jt, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        JADSlot jADSlot = this.jad_b_an.jad_b_bo;
        if (jADSlot != null) {
            jADSlot.setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        com.jd.ad.sdk.banner.jad_b_bo jad_b_boVar = this.jad_b_an;
        jad_b_boVar.jad_b_an(jad_b_boVar.jad_b_jt, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
