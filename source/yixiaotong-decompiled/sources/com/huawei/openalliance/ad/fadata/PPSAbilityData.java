package com.huawei.openalliance.ad.fadata;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSAbilityData {
    private List<PPSAbilityDataContent> abilityDataContent;
    private String displayForm;

    public String Code() {
        return this.displayForm;
    }

    public void Code(String str) {
        this.displayForm = str;
    }

    public void Code(List<PPSAbilityDataContent> list) {
        this.abilityDataContent = list;
    }

    public List<PPSAbilityDataContent> V() {
        return this.abilityDataContent;
    }
}
