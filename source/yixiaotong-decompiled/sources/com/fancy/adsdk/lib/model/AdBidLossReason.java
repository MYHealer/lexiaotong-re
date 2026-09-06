package com.fancy.adsdk.lib.model;

import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class AdBidLossReason implements Serializable {
    private Map<String, String> extraParams;
    private String lossCode;
    private String lossOtherReason;
    private String winAdnId;
    private double winPrice;

    public Map<String, String> getExtraParams() {
        return this.extraParams;
    }

    public String getLossCode() {
        return this.lossCode;
    }

    public String getLossOtherReason() {
        return this.lossOtherReason;
    }

    public String getReason() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("lossCode", this.lossCode);
            jSONObject.putOpt("lossOtherReason", this.lossOtherReason);
            jSONObject.putOpt("winAdnId", this.winAdnId);
            jSONObject.putOpt("winPrice", Double.valueOf(this.winPrice));
            jSONObject.putOpt("extraParams", this.extraParams);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String getWinAdnId() {
        return this.winAdnId;
    }

    public double getWinPrice() {
        return this.winPrice;
    }

    public void setExtraParams(Map<String, String> map) {
        this.extraParams = map;
    }

    public void setLossCode(String str) {
        this.lossCode = str;
    }

    public void setLossOtherReason(String str) {
        this.lossOtherReason = str;
    }

    public void setWinAdnId(String str) {
        this.winAdnId = str;
    }

    public void setWinPrice(double d) {
        this.winPrice = d;
    }
}
