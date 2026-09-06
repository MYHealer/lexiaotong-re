package com.jd.ad.sdk.jad_s_an;

import com.jd.ad.sdk.dl.event.JADVideoReporter;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.fdt.utils.ConversionUtils;
import com.jd.ad.sdk.fdt.utils.JsonUtils;
import com.jd.ad.sdk.mdt.service.JADEventService;
import com.jd.ad.sdk.mdt.servicemediator.JADMediator;
import org.json.JSONObject;

/* JADX INFO: compiled from: JADSplashVideoReporter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_s_jw implements JADVideoReporter {
    public final JADSlot jad_s_an;
    public final JADEventService jad_s_bo = JADMediator.getInstance().getEventService();

    public jad_s_jw(JADSlot jADSlot) {
        this.jad_s_an = jADSlot;
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoCompleted(float f) {
        jad_s_an(5, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPause(float f) {
        jad_s_an(4, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoPreloadCompleted() {
        jad_s_an(2, 0.0f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoResume(float f) {
        jad_s_an(6, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoStart(float f) {
        jad_s_an(3, f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoWillStart() {
        jad_s_an(1, 0.0f);
    }

    @Override // com.jd.ad.sdk.dl.event.JADVideoReporter
    public void reportVideoError(float f, int i, int i2) {
        JADSlot jADSlot = this.jad_s_an;
        String requestId = jADSlot != null ? jADSlot.getRequestId() : "";
        JSONObject jSONObject = new JSONObject();
        JsonUtils.put(jSONObject, "duration", Float.valueOf(f));
        JsonUtils.put(jSONObject, "errorCode", Integer.valueOf(i));
        JsonUtils.put(jSONObject, "extraCode", Integer.valueOf(i2));
        JADEventService jADEventService = this.jad_s_bo;
        if (jADEventService != null) {
            jADEventService.reportVideoExceptionEvent(requestId, 11, jSONObject.toString());
        }
    }

    public final void jad_s_an(int i, float f) {
        JADEventService jADEventService;
        JADSlot jADSlot = this.jad_s_an;
        if (jADSlot == null || (jADEventService = this.jad_s_bo) == null) {
            return;
        }
        jADEventService.reportVideoEvent(jADSlot.getRequestId(), this.jad_s_an.getSlotID(), this.jad_s_an.getAdType(), this.jad_s_an.getTemplateId(), this.jad_s_an.getSen(), this.jad_s_an.getRem(), this.jad_s_an.getScdu(), this.jad_s_an.getDcdu(), this.jad_s_an.getEcdu(), this.jad_s_an.getSspt(), this.jad_s_an.getScav(), this.jad_s_an.getEventInteractionType(), this.jad_s_an.getAtst(), this.jad_s_an.getModelClickAreaType(), this.jad_s_an.getDstp(), this.jad_s_an.getSrtp(), i, ConversionUtils.floatToDouble(f));
    }
}
