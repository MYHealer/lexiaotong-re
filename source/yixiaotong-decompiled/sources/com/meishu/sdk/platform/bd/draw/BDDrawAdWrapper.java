package com.meishu.sdk.platform.bd.draw;

import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.meishu.sdk.core.ad.draw.DrawAdLoader;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.bd.BDPlatformError;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDDrawAdWrapper extends BasePlatformLoader<DrawAdLoader, a> {
    private static final String TAG = "BDDrawAdWrapper";
    private BDDrawAd bdDrawAd;

    public BDDrawAdWrapper(DrawAdLoader drawAdLoader, SdkAdInfo sdkAdInfo) {
        super(drawAdLoader, sdkAdInfo);
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(((DrawAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        new BaiduNativeManager(getContext(), getSdkAdInfo().getPid()).loadPortraitVideoAd(new RequestParameters.Builder().setWidth(displayMetrics.widthPixels).setHeight(displayMetrics.heightPixels).downloadAppConfirmPolicy(1).build(), new BaiduNativeManager.PortraitVideoAdListener() { // from class: com.meishu.sdk.platform.bd.draw.BDDrawAdWrapper.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.PortraitVideoAdListener
            public void onAdClick() {
                if (!TextUtils.isEmpty(BDDrawAdWrapper.this.getSdkAdInfo().getClk())) {
                    LogUtil.d(BDDrawAdWrapper.TAG, "send onAdClicked");
                    com.meishu.sdk.core.loader.a.a(BDDrawAdWrapper.this.getContext(), f.a(BDDrawAdWrapper.this.getSdkAdInfo().getClk(), BDDrawAdWrapper.this.bdDrawAd));
                }
                if (BDDrawAdWrapper.this.bdDrawAd.getInteractionListener() != null) {
                    BDDrawAdWrapper.this.bdDrawAd.getInteractionListener().onAdClicked();
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i2, String str, NativeResponse nativeResponse) {
                LogUtil.d(BDDrawAdWrapper.TAG, str);
                new BDPlatformError(str, BDDrawAdWrapper.this.getSdkAdInfo()).post(BDDrawAdWrapper.this.getLoaderListener());
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                final NativeResponse nativeResponse = list.get(0);
                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.bd.draw.BDDrawAdWrapper.1.1
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        BDDrawAdWrapper bDDrawAdWrapper = BDDrawAdWrapper.this;
                        bDDrawAdWrapper.bdDrawAd = new BDDrawAd(bDDrawAdWrapper, nativeResponse, bDDrawAdWrapper.getLoaderListener());
                        if (BDDrawAdWrapper.this.getLoaderListener() != null) {
                            BDDrawAdWrapper.this.getLoaderListener().onAdLoaded(BDDrawAdWrapper.this.bdDrawAd);
                            BDDrawAdWrapper.this.getLoaderListener().onAdReady(BDDrawAdWrapper.this.bdDrawAd);
                        }
                    }
                });
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i2, String str, NativeResponse nativeResponse) {
                LogUtil.d(BDDrawAdWrapper.TAG, str);
                new BDPlatformError(str, BDDrawAdWrapper.this.getSdkAdInfo()).post(BDDrawAdWrapper.this.getLoaderListener());
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }

            public void onNativeFail(int i2, String str) {
                LogUtil.d(BDDrawAdWrapper.TAG, str);
                new BDPlatformError(str, BDDrawAdWrapper.this.getSdkAdInfo()).post(BDDrawAdWrapper.this.getLoaderListener());
            }

            public void onNoAd(int i2, String str) {
                LogUtil.d(BDDrawAdWrapper.TAG, str);
                new BDPlatformError(str, BDDrawAdWrapper.this.getSdkAdInfo()).post(BDDrawAdWrapper.this.getLoaderListener());
            }
        });
    }
}
