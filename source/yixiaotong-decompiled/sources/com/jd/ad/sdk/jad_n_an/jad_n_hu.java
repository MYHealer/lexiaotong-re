package com.jd.ad.sdk.jad_n_an;

import android.view.View;
import android.view.ViewGroup;
import com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener;
import com.jd.ad.sdk.dl.common.CommonConstants;
import com.jd.ad.sdk.nativead.JADNative;

/* JADX INFO: compiled from: JADNativeViewController.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_n_hu implements JADExposureListener {
    public final /* synthetic */ ViewGroup jad_n_an;
    public final /* synthetic */ jad_n_er jad_n_bo;

    public jad_n_hu(jad_n_er jad_n_erVar, ViewGroup viewGroup) {
        this.jad_n_bo = jad_n_erVar;
        this.jad_n_an = viewGroup;
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onFinishExposure() {
        jad_n_er.jad_n_an(this.jad_n_bo, (View) this.jad_n_an, false);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onDelayExposure(long j, String str, int i) {
        JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(i);
        }
        jad_n_er.jad_n_an(this.jad_n_bo, true, str, i);
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onExposure(String str) {
        JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
        }
        jad_n_er.jad_n_an(this.jad_n_bo, false, str, CommonConstants.ExposureType.EXPOSURE_INSTANCE.getIndex());
    }

    @Override // com.jd.ad.sdk.bl.exposuremonitor.JADExposureListener
    public void onPreExposure(String str) {
        JADNative jADNative = this.jad_n_bo.jad_n_an;
        if (jADNative != null && jADNative.getSlot() != null) {
            this.jad_n_bo.jad_n_an.getSlot().setImm(CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
        }
        this.jad_n_bo.jad_n_cp = false;
        jad_n_er.jad_n_an(this.jad_n_bo, false, str, CommonConstants.ExposureType.EXPOSURE_ATTACHE_TO_WINDOW.getIndex());
    }
}
