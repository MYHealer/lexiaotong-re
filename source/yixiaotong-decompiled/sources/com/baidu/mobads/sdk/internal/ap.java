package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.IPromoteInstallAdInfo;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class ap implements IPromoteInstallAdInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final aq f1725a;
    private final Context b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppPublisher() {
        return this.h;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getAppVersion() {
        return this.i;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getBrandName() {
        return this.e;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getECPMLevel() {
        return this.f;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getFunctionUrl() {
        return this.l;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getIconUrl() {
        return this.d;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPECPM() {
        return this.g;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPermissionUrl() {
        return this.k;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getPrivacyUrl() {
        return this.j;
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public String getUnionLogoUrl() {
        return "https://union.baidu.com";
    }

    public ap(JSONObject jSONObject, Context context, aq aqVar) {
        this.f1725a = aqVar;
        this.b = context;
        try {
            this.c = jSONObject.optString(OapsKey.KEY_PAGEKEY);
            this.d = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cL);
            this.e = jSONObject.optString("appname");
            this.f = jSONObject.optString("bidlayer");
            this.g = jSONObject.optString("enc_bid_price");
            this.h = jSONObject.optString("publisher");
            this.i = jSONObject.optString("app_version");
            this.j = jSONObject.optString("privacy_link");
            this.k = jSONObject.optString("permission_link");
            this.l = jSONObject.optString("function_link");
        } catch (Throwable unused) {
        }
    }

    @Override // com.baidu.mobads.sdk.api.IPromoteInstallAdInfo
    public void handleAdInstall() {
        aq aqVar = this.f1725a;
        if (aqVar != null) {
            aqVar.a(this.b, this.c);
        }
    }
}
