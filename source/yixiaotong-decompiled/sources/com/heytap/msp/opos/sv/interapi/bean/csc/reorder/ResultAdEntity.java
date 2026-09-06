package com.heytap.msp.opos.sv.interapi.bean.csc.reorder;

import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ResultAdEntity implements Serializable {
    private static final long serialVersionUID = -9219233540224962647L;
    private Map<String, String> bizMacroMap;
    private float boostedScore;
    private String contentId;

    public Map<String, String> getBizMacroMap() {
        return this.bizMacroMap;
    }

    public float getBoostedScore() {
        return this.boostedScore;
    }

    public String getContentId() {
        return this.contentId;
    }

    public void setBizMacroMap(Map<String, String> map) {
        this.bizMacroMap = map;
    }

    public void setBoostedScore(float f) {
        this.boostedScore = f;
    }

    public void setContentId(String str) {
        this.contentId = str;
    }

    public String toString() {
        return "ResultAdEntity{contentId='" + this.contentId + "', boostedScore=" + this.boostedScore + ", bizMacroMap=" + this.bizMacroMap + '}';
    }
}
