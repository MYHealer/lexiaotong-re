package com.ubixnow.adtype.nativead.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeInfo {
    private int mEcpm;
    private String mAdNetworkName = "";
    private String mPlacementId = "";

    public String getAdNetworkName() {
        return this.mAdNetworkName;
    }

    public int getEcpm() {
        return this.mEcpm;
    }

    public String getPlacementId() {
        return this.mPlacementId;
    }

    public void setAdNetworkName(String str) {
        this.mAdNetworkName = str;
    }

    public void setEcpm(int i) {
        this.mEcpm = i;
    }

    public void setPlacementId(String str) {
        this.mPlacementId = str;
    }
}
