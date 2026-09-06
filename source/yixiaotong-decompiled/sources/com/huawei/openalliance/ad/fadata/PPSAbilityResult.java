package com.huawei.openalliance.ad.fadata;

import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSAbilityResult {
    private ArrayList<PPSAbilityData> abilityDatas;
    private String intentSn;

    public String Code() {
        return this.intentSn;
    }

    public void Code(String str) {
        this.intentSn = str;
    }

    public void Code(ArrayList<PPSAbilityData> arrayList) {
        this.abilityDatas = arrayList;
    }

    public ArrayList<PPSAbilityData> V() {
        return this.abilityDatas;
    }
}
