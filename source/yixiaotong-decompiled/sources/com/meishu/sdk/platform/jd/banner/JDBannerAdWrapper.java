package com.meishu.sdk.platform.jd.banner;

import android.util.DisplayMetrics;
import com.jd.ad.sdk.banner.JADBanner;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDBannerAdWrapper extends BasePlatformLoader<BannerAdLoader, b> {
    private JADBanner bannerAd;
    private MeishuAdInfo meishuAdInfo;

    public JDBannerAdWrapper(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        if (this.bannerAd != null) {
            this.bannerAd = null;
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        int iIntValue;
        int iIntValue2;
        try {
            z.a(StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
            if (((BannerAdLoader) this.adLoader).getAcceptWidth() == null || ((BannerAdLoader) this.adLoader).getAcceptHeight() == null) {
                iIntValue = 180;
                try {
                    DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()).getResources().getDisplayMetrics();
                    int i = displayMetrics.widthPixels;
                    if (i <= 0 || displayMetrics.heightPixels <= 0) {
                        iIntValue2 = 1080;
                    } else {
                        try {
                            iIntValue = i / 6;
                        } catch (Exception unused) {
                        }
                        iIntValue2 = i;
                    }
                } catch (Exception unused2) {
                }
            } else {
                iIntValue2 = ((BannerAdLoader) this.adLoader).getAcceptWidth().intValue();
                iIntValue = ((BannerAdLoader) this.adLoader).getAcceptHeight().intValue();
            }
            JADSlot jADSlotBuild = new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(m.b(((BannerAdLoader) this.adLoader).getContext(), iIntValue2), m.b(((BannerAdLoader) this.adLoader).getContext(), iIntValue)).build();
            JDBannerAd jDBannerAd = new JDBannerAd(this);
            JADBanner jADBanner = new JADBanner(StubApp.getOrigApplicationContext(((BannerAdLoader) this.adLoader).getContext().getApplicationContext()), jADSlotBuild);
            this.bannerAd = jADBanner;
            jDBannerAd.setJDBanner(jADBanner);
            this.bannerAd.loadAd(new JDBannerAdListenerImpl(this, (b) this.loadListener, jDBannerAd));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
