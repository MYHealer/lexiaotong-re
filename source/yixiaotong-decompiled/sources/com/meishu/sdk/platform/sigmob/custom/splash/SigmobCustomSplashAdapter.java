package com.meishu.sdk.platform.sigmob.custom.splash;

import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter;
import com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager;
import com.sigmob.windad.Splash.WindSplashAD;
import com.sigmob.windad.Splash.WindSplashADListener;
import com.sigmob.windad.Splash.WindSplashAdRequest;
import com.sigmob.windad.WindAdBiddingLossReason;
import com.sigmob.windad.WindAdError;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "SigmobCustomSplashAdapt";
    private WindSplashAD mWindSplashAD;
    private SigmobCustomSplashAd sigmobSplashAd;

    public SigmobCustomSplashAdapter(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdWithCallback(String str) {
        WindSplashAdRequest windSplashAdRequest = new WindSplashAdRequest(getSdkAdInfo().getPid(), (String) null, (Map) null);
        windSplashAdRequest.setFetchDelay(5);
        this.sigmobSplashAd = new SigmobCustomSplashAd(this);
        WindSplashAD windSplashAD = new WindSplashAD(windSplashAdRequest, new WindSplashADListener() { // from class: com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter.2
            public void onSplashAdClick(String str2) {
                if (SigmobCustomSplashAdapter.this.sigmobSplashAd != null) {
                    SigmobCustomSplashAdapter sigmobCustomSplashAdapter = SigmobCustomSplashAdapter.this;
                    sigmobCustomSplashAdapter.onAdClick(sigmobCustomSplashAdapter.sigmobSplashAd);
                }
            }

            public void onSplashAdClose(String str2) {
                if (SigmobCustomSplashAdapter.this.sigmobSplashAd != null) {
                    SigmobCustomSplashAdapter sigmobCustomSplashAdapter = SigmobCustomSplashAdapter.this;
                    sigmobCustomSplashAdapter.onAdSkip(sigmobCustomSplashAdapter.sigmobSplashAd);
                }
            }

            public void onSplashAdLoadFail(WindAdError windAdError, String str2) {
                LogUtil.e(SigmobCustomSplashAdapter.TAG, a.a("onError, code: ").append(windAdError.getErrorCode()).append(", msg: ").append(windAdError.getMessage()).toString());
                SigmobCustomSplashAdapter.this.onError(windAdError.getErrorCode(), windAdError.getMessage());
            }

            public void onSplashAdLoadSuccess(String str2) {
                if (SigmobCustomSplashAdapter.this.mWindSplashAD != null) {
                    String ecpm = SigmobCustomSplashAdapter.this.mWindSplashAD.getEcpm();
                    if (SigmobCustomSplashAdapter.this.getSdkAdInfo() != null) {
                        SigmobCustomSplashAdapter.this.getSdkAdInfo().setEcpm(ecpm);
                    }
                }
                if (SigmobCustomSplashAdapter.this.sigmobSplashAd != null) {
                    SigmobCustomSplashAdapter sigmobCustomSplashAdapter = SigmobCustomSplashAdapter.this;
                    sigmobCustomSplashAdapter.onRenderSuccess(null, sigmobCustomSplashAdapter.sigmobSplashAd);
                }
            }

            public void onSplashAdShow(String str2) {
                LogUtil.d(SigmobCustomSplashAdapter.TAG, "send onADExposure");
                if (SigmobCustomSplashAdapter.this.sigmobSplashAd != null) {
                    SigmobCustomSplashAdapter sigmobCustomSplashAdapter = SigmobCustomSplashAdapter.this;
                    sigmobCustomSplashAdapter.onAdExposure(sigmobCustomSplashAdapter.sigmobSplashAd);
                }
            }

            public void onSplashAdShowError(WindAdError windAdError, String str2) {
                SigmobCustomSplashAdapter.this.onError(windAdError.getErrorCode(), windAdError.getMessage());
            }

            public void onSplashAdSkip(String str2) {
                if (SigmobCustomSplashAdapter.this.sigmobSplashAd != null) {
                    SigmobCustomSplashAdapter sigmobCustomSplashAdapter = SigmobCustomSplashAdapter.this;
                    sigmobCustomSplashAdapter.onAdSkip(sigmobCustomSplashAdapter.sigmobSplashAd);
                }
            }
        });
        this.mWindSplashAD = windSplashAD;
        this.sigmobSplashAd.setSplashAD(windSplashAD);
        this.mWindSplashAD.loadAd();
    }

    @Override // com.meishu.sdk.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(String str, String str2, final String str3, String str4) {
        SigmobCustomInitManager.getInstance().initSdk(this.context, str, str2, new SigmobCustomInitManager.InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.splash.SigmobCustomSplashAdapter.1
            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onError(int i, String str5) {
            }

            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
            public void onSuccess() {
                SigmobCustomSplashAdapter.this.loadAdWithCallback(str3);
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.mWindSplashAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("AUCTION_PRICE", Integer.valueOf(Integer.parseInt(this.mWindSplashAD.getEcpm())));
                    map.put("HIGHEST_LOSS_PRICE", Integer.valueOf(t0.a(Integer.parseInt(this.mWindSplashAD.getEcpm()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    map.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    this.mWindSplashAD.sendWinNotificationWithInfo(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Integer.valueOf(i));
                    map2.put("CURRENCY", Constant.KEY_CURRENCYTYPE_CNY);
                    map2.put("LOSS_REASON", Integer.valueOf(WindAdBiddingLossReason.LOSS_REASON_LOW_PRICE.getCode()));
                    this.mWindSplashAD.sendLossNotificationWithInfo(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
