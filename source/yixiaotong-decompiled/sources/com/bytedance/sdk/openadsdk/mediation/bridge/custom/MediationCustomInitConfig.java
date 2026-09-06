package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import com.byazt.zqa.c;
import com.bykv.vk.openvk.api.proto.ValueSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, 266, 267})
public class MediationCustomInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3104a;
    private String c;
    private String da;
    private String i;
    private String n;
    private String sl;
    private String sp;
    private String tt;
    private String uj;
    private String ve;
    private String x;

    public String getADNName() {
        return this.ve;
    }

    public String getAdnInitClassName() {
        return this.uj;
    }

    public String getAppId() {
        return this.c;
    }

    public String getAppKey() {
        return this.tt;
    }

    public String getBannerClassName() {
        return this.n;
    }

    public String getDrawClassName() {
        return this.sl;
    }

    public String getFeedClassName() {
        return this.da;
    }

    public String getFullVideoClassName() {
        return this.x;
    }

    public String getInterstitialClassName() {
        return this.f3104a;
    }

    public String getRewardClassName() {
        return this.sp;
    }

    public String getSplashClassName() {
        return this.i;
    }

    public MediationCustomInitConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.ve = str;
        this.c = str2;
        this.tt = str3;
        this.uj = str4;
        this.n = str5;
        this.f3104a = str6;
        this.sp = str7;
        this.x = str8;
        this.i = str9;
        this.da = str10;
        this.sl = str11;
    }

    public MediationCustomInitConfig(ValueSet valueSet) {
        if (valueSet != null) {
            this.ve = valueSet.stringValue(8003);
            this.c = valueSet.stringValue(8534);
            this.tt = valueSet.stringValue(8535);
            this.uj = valueSet.stringValue(8536);
            this.n = valueSet.stringValue(8537);
            this.f3104a = valueSet.stringValue(8538);
            this.sp = valueSet.stringValue(8539);
            this.x = valueSet.stringValue(8540);
            this.i = valueSet.stringValue(8541);
            this.da = valueSet.stringValue(8542);
            this.sl = valueSet.stringValue(8543);
        }
    }

    public String toString() {
        return "MediationCustomInitConfig{mAppId='" + this.c + "', mAppKey='" + this.tt + "', mADNName='" + this.ve + "', mAdnInitClassName='" + this.uj + "', mBannerClassName='" + this.n + "', mInterstitialClassName='" + this.f3104a + "', mRewardClassName='" + this.sp + "', mFullVideoClassName='" + this.x + "', mSplashClassName='" + this.i + "', mFeedClassName='" + this.da + "', mDrawClassName='" + this.sl + "'}";
    }
}
