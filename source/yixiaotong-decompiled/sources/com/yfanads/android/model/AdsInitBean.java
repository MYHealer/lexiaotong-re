package com.yfanads.android.model;

import com.yfanads.android.utils.YFAdsConst;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdsInitBean extends InitBean {
    public int adnId;
    public String clasName;
    public boolean isGM;
    public String methodName;
    public String tag;

    public AdsInitBean(int i, String str, String str2, String str3, String str4, String str5) {
        super(str, str2, str3, str4, str5);
        this.isGM = 11 == i;
        this.adnId = i;
    }

    @Override // com.yfanads.android.model.InitBean
    public String toString() {
        return YFAdsConst.getSource(this.adnId) + "|" + this.appId + "|k_" + this.addKey + "|w_" + this.wxAppId;
    }

    public void updData(YFAdsConst.AdSource adSource) {
        this.clasName = adSource.adapterName;
        this.methodName = adSource.initMethodName;
    }

    public AdsInitBean(int i, String str, String str2, String str3, String str4, String str5, YFAdsConst.AdSource adSource) {
        super(str, str2, str3, str4, str5);
        this.clasName = adSource.adapterName;
        this.methodName = adSource.initMethodName;
        this.isGM = 11 == i;
        this.adnId = i;
    }
}
