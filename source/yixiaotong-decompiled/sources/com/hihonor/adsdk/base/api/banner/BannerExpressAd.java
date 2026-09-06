package com.hihonor.adsdk.base.api.banner;

import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface BannerExpressAd extends BaseExpressAd {
    void refresh();

    void setBaseAdInfo(BaseAdInfo baseAdInfo);

    void setHeight(int i);

    void setIntervalTime(long j);

    void setWidth(int i);
}
