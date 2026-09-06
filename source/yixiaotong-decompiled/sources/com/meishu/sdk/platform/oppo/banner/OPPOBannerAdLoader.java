package com.meishu.sdk.platform.oppo.banner;

import android.app.Activity;
import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.BannerAd;
import com.heytap.msp.mobad.api.listener.IBannerAdListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.banner.BannerAdLoader;
import com.meishu.sdk.core.ad.banner.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPOBannerAdLoader extends BasePlatformLoader<BannerAdLoader, b> {
    private static final String TAG = "OPPOBannerAdLoader";
    private ArrayList<BannerAd> bannerAdList;

    public OPPOBannerAdLoader(BannerAdLoader bannerAdLoader, SdkAdInfo sdkAdInfo) {
        super(bannerAdLoader, sdkAdInfo);
        this.bannerAdList = new ArrayList<>();
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        Iterator<BannerAd> it = this.bannerAdList.iterator();
        while (it.hasNext()) {
            it.next().destroyAd();
        }
        this.bannerAdList.clear();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((BannerAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        final OPPOBannerAd oPPOBannerAd = new OPPOBannerAd(this);
        final BannerAd bannerAd = new BannerAd((Activity) getContext(), getSdkAdInfo().getPid());
        bannerAd.setAdListener(new IBannerAdListener() { // from class: com.meishu.sdk.platform.oppo.banner.OPPOBannerAdLoader.1
            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdClick() {
                if (OPPOBannerAdLoader.this.getSdkAdInfo() != null && !TextUtils.isEmpty(OPPOBannerAdLoader.this.getSdkAdInfo().getClk())) {
                    LogUtil.d(OPPOBannerAdLoader.TAG, "send onAdClick");
                    a.a(OPPOBannerAdLoader.this.getContext(), f.a(OPPOBannerAdLoader.this.getSdkAdInfo().getClk(), oPPOBannerAd));
                }
                if (oPPOBannerAd.getInteractionListener() != null) {
                    oPPOBannerAd.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBannerAdListener
            public void onAdClose() {
                if (OPPOBannerAdLoader.this.getLoaderListener() != null) {
                    OPPOBannerAdLoader.this.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdFailed(int i, String str) {
                LogUtil.e(OPPOBannerAdLoader.TAG, str + PPSLabelView.Code + i);
                z.a(OPPOBannerAdLoader.this.getSdkAdInfo().getErr(), Integer.valueOf(i), str);
                if (OPPOBannerAdLoader.this.getLoaderListener() != null) {
                    OPPOBannerAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            @Deprecated
            public void onAdFailed(String str) {
            }

            @Override // com.heytap.msp.mobad.api.listener.IBannerAdListener
            public void onAdReady() {
                oPPOBannerAd.setAdView(bannerAd.getAdView());
                if (OPPOBannerAdLoader.this.getLoaderListener() != null) {
                    OPPOBannerAdLoader.this.getLoaderListener().onAdLoaded(oPPOBannerAd);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.IBaseAdListener
            public void onAdShow() {
                if (OPPOBannerAdLoader.this.getLoaderListener() != null) {
                    OPPOBannerAdLoader.this.getLoaderListener().onAdExposure();
                }
            }
        });
        bannerAd.loadAd();
        this.bannerAdList.add(bannerAd);
    }
}
