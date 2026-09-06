package com.hihonor.adsdk.base.mediation.core.imp;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class AdapterConstructorBean {
    private String appId;
    private Context context;
    private String ext;
    private String posId;
    private double rewardAmount;
    private String rewardName;

    public String getAppId() {
        return this.appId;
    }

    public Context getContext() {
        return this.context;
    }

    public String getExt() {
        return this.ext;
    }

    public String getPosId() {
        return this.posId;
    }

    public double getRewardAmount() {
        return this.rewardAmount;
    }

    public String getRewardName() {
        return this.rewardName;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setPosId(String str) {
        this.posId = str;
    }

    public void setRewardAmount(double d) {
        this.rewardAmount = d;
    }

    public void setRewardName(String str) {
        this.rewardName = str;
    }
}
