package com.hihonor.hianalytics.module.exposure;

import com.hihonor.hianalytics.HaEventConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ExposureInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExposureConfig f3707a;
    private JSONObject b;
    private String c;
    private String d;

    public ExposureInfo(ExposureConfig exposureConfig) {
        this(exposureConfig, null);
    }

    public ExposureInfo(ExposureConfig exposureConfig, JSONObject jSONObject) {
        this.c = HaEventConstants.EVENT_ID_WIDGET_EXPOSE;
        this.f3707a = exposureConfig;
        this.b = jSONObject;
    }

    public ExposureInfo(ExposureConfig exposureConfig, JSONObject jSONObject, String str, String str2) {
        this.f3707a = exposureConfig;
        this.b = jSONObject;
        this.c = str;
        this.d = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExposureInfo exposureInfo = (ExposureInfo) obj;
        return this.f3707a.equals(exposureInfo.f3707a) && this.b.toString().equals(exposureInfo.b.toString()) && this.c.equals(exposureInfo.c) && this.d.equals(exposureInfo.d);
    }

    public ExposureConfig getConfig() {
        return this.f3707a;
    }

    public String getEvent() {
        return this.c;
    }

    public String getExposureIdentifier() {
        return this.d;
    }

    public JSONObject getPropertyJson() {
        return this.b;
    }

    public void setConfig(ExposureConfig exposureConfig) {
        this.f3707a = exposureConfig;
    }

    public void setEvent(String str) {
        this.c = str;
    }

    public void setExposureIdentifier(String str) {
        this.d = str;
    }

    public void setPropertyJson(JSONObject jSONObject) {
        this.b = jSONObject;
    }
}
