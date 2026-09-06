package com.huawei.hms.ads.consent.bean;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class ConsentSyncRsp {
    private List<String> adProviderIds;
    private int consentStatus;
    private int retcode;
    private Long timestamp;

    public List<String> getAdProviderIds() {
        return this.adProviderIds;
    }

    public int getConsentStatus() {
        return this.consentStatus;
    }

    public int getRetcode() {
        return this.retcode;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setAdProviderIds(List<String> list) {
        this.adProviderIds = list;
    }

    public void setConsentStatus(int i) {
        this.consentStatus = i;
    }

    public void setRetcode(int i) {
        this.retcode = i;
    }

    public void setTimestamp(Long l) {
        this.timestamp = l;
    }
}
