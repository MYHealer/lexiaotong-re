package com.yfanads.android.adx.core.impl;

import com.yfanads.android.adx.api.AdxScene;
import java.io.Serializable;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdxSceneImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c implements AdxScene, Serializable, Cloneable {
    private static final long serialVersionUID = 93865491903408452L;
    public int action;
    public int adStyle;
    public long ecpm;
    public String entryScene;
    public int height;
    public String posId;
    public String reqId;
    public Map<String, String> rewardCallbackExtraData;
    public int width;
    public int adNum = 1;
    public int screenOrientation = 0;

    public final Object clone() throws CloneNotSupportedException {
        c cVar = new c();
        JSONObject json = toJson();
        try {
            cVar.posId = json.getString("posId");
            cVar.entryScene = json.getString("entryScene");
            cVar.width = json.getInt("width");
            cVar.height = json.getInt("height");
            cVar.action = json.getInt("action");
            cVar.adNum = json.getInt("adNum");
            cVar.adStyle = json.getInt("adStyle");
            cVar.screenOrientation = json.getInt("screenOrientation");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return cVar;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getAction() {
        return this.action;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getAdNum() {
        return this.adNum;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getAdStyle() {
        return this.adStyle;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final long getEcpm() {
        return this.ecpm;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getHeight() {
        return this.height;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final String getPosId() {
        return this.posId;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final String getReqId() {
        return this.reqId;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final Map<String, String> getRewardCallbackExtraData() {
        return this.rewardCallbackExtraData;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getScreenOrientation() {
        return this.screenOrientation;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final int getWidth() {
        return this.width;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setAction(int i) {
        this.action = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setAdNum(int i) {
        this.adNum = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setAdStyle(int i) {
        this.adStyle = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setEcpm(long j) {
        this.ecpm = j;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setHeight(int i) {
        this.height = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setPosId(String str) {
        this.posId = str;
        this.entryScene = str;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setReqId(String str) {
        this.reqId = str;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setRewardCallbackExtraData(Map<String, String> map) {
        this.rewardCallbackExtraData = map;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setScreenOrientation(int i) {
        this.screenOrientation = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final void setWidth(int i) {
        this.width = i;
    }

    @Override // com.yfanads.android.adx.api.AdxScene
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("posId", this.posId);
            jSONObject.put("entryScene", this.entryScene);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            jSONObject.put("action", this.action);
            jSONObject.put("adNum", this.adNum);
            jSONObject.put("adStyle", this.adStyle);
            jSONObject.put("screenOrientation", this.screenOrientation);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
