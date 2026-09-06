package com.meishu.sdk.platform.sigmob.custom.interstitial;

import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.interstitial.InterstitialAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAd;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdListener;
import com.sigmob.windad.newInterstitial.WindNewInterstitialAdRequest;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomInterstitialAdapter extends MsCustomInterstitialAdapter {
    private static final String TAG = "SigmobCustomInterstitia";
    private SigmobCustomInterstitialAd sigmobCustomInterstitialAd;
    private WindNewInterstitialAd windNewInterstitialAd;

    public SigmobCustomInterstitialAdapter(InterstitialAdLoader interstitialAdLoader, SdkAdInfo sdkAdInfo) {
        super(interstitialAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        WindNewInterstitialAd windNewInterstitialAd = new WindNewInterstitialAd(new WindNewInterstitialAdRequest(str, (String) null, (Map) null));
        this.windNewInterstitialAd = windNewInterstitialAd;
        this.sigmobCustomInterstitialAd = new SigmobCustomInterstitialAd(this, windNewInterstitialAd);
        this.windNewInterstitialAd.setWindNewInterstitialAdListener(new WindNewInterstitialAdListener() { // from class: com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter.2
            public void onInterstitialAdClicked(String str2) {
                LogUtil.d(SigmobCustomInterstitialAdapter.TAG, "onInterstitialAdClicked");
                if (SigmobCustomInterstitialAdapter.this.sigmobCustomInterstitialAd != null) {
                    SigmobCustomInterstitialAdapter sigmobCustomInterstitialAdapter = SigmobCustomInterstitialAdapter.this;
                    sigmobCustomInterstitialAdapter.onAdClick(sigmobCustomInterstitialAdapter.sigmobCustomInterstitialAd);
                }
            }

            public void onInterstitialAdClosed(String str2) {
                if (SigmobCustomInterstitialAdapter.this.sigmobCustomInterstitialAd != null) {
                    SigmobCustomInterstitialAdapter sigmobCustomInterstitialAdapter = SigmobCustomInterstitialAdapter.this;
                    sigmobCustomInterstitialAdapter.onAdClosed(sigmobCustomInterstitialAdapter.sigmobCustomInterstitialAd);
                }
            }

            public void onInterstitialAdLoadError(WindAdError windAdError, String str2) {
                LogUtil.e(SigmobCustomInterstitialAdapter.TAG, a.a("onError, code: ").append(windAdError.getErrorCode()).append(", msg: ").append(windAdError.getMessage()).toString());
                SigmobCustomInterstitialAdapter.this.onError(windAdError.getErrorCode(), windAdError.getMessage());
            }

            public void onInterstitialAdLoadSuccess(String str2) {
                String ecpm = SigmobCustomInterstitialAdapter.this.windNewInterstitialAd.getEcpm();
                if (SigmobCustomInterstitialAdapter.this.getSdkAdInfo() != null) {
                    SigmobCustomInterstitialAdapter.this.getSdkAdInfo().setEcpm(ecpm);
                }
                if (SigmobCustomInterstitialAdapter.this.sigmobCustomInterstitialAd != null) {
                    SigmobCustomInterstitialAdapter sigmobCustomInterstitialAdapter = SigmobCustomInterstitialAdapter.this;
                    sigmobCustomInterstitialAdapter.onRenderSuccess(sigmobCustomInterstitialAdapter.sigmobCustomInterstitialAd);
                }
            }

            public void onInterstitialAdPreLoadFail(String str2) {
            }

            public void onInterstitialAdPreLoadSuccess(String str2) {
            }

            public void onInterstitialAdShow(String str2) {
                if (SigmobCustomInterstitialAdapter.this.sigmobCustomInterstitialAd != null) {
                    SigmobCustomInterstitialAdapter sigmobCustomInterstitialAdapter = SigmobCustomInterstitialAdapter.this;
                    sigmobCustomInterstitialAdapter.onAdExposure(sigmobCustomInterstitialAdapter.sigmobCustomInterstitialAd);
                }
            }

            public void onInterstitialAdShowError(WindAdError windAdError, String str2) {
                LogUtil.e(SigmobCustomInterstitialAdapter.TAG, a.a("onError, code: ").append(windAdError.getErrorCode()).append(", msg: ").append(windAdError.getMessage()).toString());
            }
        });
        this.windNewInterstitialAd.loadAd();
    }

    @Override // com.meishu.sdk.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        SigmobCustomInitManager.getInstance().initSdk(this.context, str, str2, new SigmobCustomInitManager.InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.interstitial.SigmobCustomInterstitialAdapter.1
            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onSuccess() {
                SigmobCustomInterstitialAdapter.this.loadAdWithCallback(str3);
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.windNewInterstitialAd != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("AUCTION_PRICE", Integer.valueOf(Integer.parseInt(this.windNewInterstitialAd.getEcpm())));
                    map.put("HIGHEST_LOSS_PRICE", Integer.valueOf(t0.a(Integer.parseInt(this.windNewInterstitialAd.getEcpm()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    map.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.windNewInterstitialAd.sendWinNotificationWithInfo(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Integer.valueOf(i));
                    map2.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    map2.put("LOSS_REASON", Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
                    this.windNewInterstitialAd.sendLossNotificationWithInfo(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
