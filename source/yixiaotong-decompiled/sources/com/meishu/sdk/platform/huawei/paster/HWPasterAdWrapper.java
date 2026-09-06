package com.meishu.sdk.platform.huawei.paster;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.MediaMuteListener;
import com.huawei.hms.ads.instreamad.InstreamAd;
import com.huawei.hms.ads.instreamad.InstreamAdLoadListener;
import com.huawei.hms.ads.instreamad.InstreamAdLoader;
import com.huawei.hms.ads.instreamad.InstreamMediaStateListener;
import com.huawei.hms.ads.instreamad.InstreamView;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.paster.PasterAdLoader;
import com.meishu.sdk.core.ad.paster.b;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.huawei.HWPlatformError;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWPasterAdWrapper extends BasePlatformLoader<PasterAdLoader, b> {
    private static final String TAG = "HWPasterAdWrapper";
    private HWPasterAd hwPasterAd;

    public HWPasterAdWrapper(PasterAdLoader pasterAdLoader, SdkAdInfo sdkAdInfo) {
        super(pasterAdLoader, sdkAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAd(List<InstreamAd> list) {
        ViewGroup containerView = getAdLoader().getContainerView();
        View viewInflate = View.inflate(getContext(), R.layout.ms_layout_hw_paster, null);
        containerView.addView(viewInflate);
        InstreamView instreamView = (InstreamView) viewInflate.findViewById(R.id.ms_instream_view);
        instreamView.setInstreamAds(list);
        instreamView.setOnInstreamAdClickListener(new InstreamView.OnInstreamAdClickListener() { // from class: com.meishu.sdk.platform.huawei.paster.HWPasterAdWrapper.2
            @Override // com.huawei.hms.ads.instreamad.InstreamView.OnInstreamAdClickListener
            public void onClick() {
                if (HWPasterAdWrapper.this.getSdkAdInfo() == null || TextUtils.isEmpty(HWPasterAdWrapper.this.getSdkAdInfo().getClk()) || HWPasterAdWrapper.this.hwPasterAd == null) {
                    return;
                }
                LogUtil.d(HWPasterAdWrapper.TAG, "send onADClicked");
                a.a(HWPasterAdWrapper.this.getContext(), f.a(HWPasterAdWrapper.this.getSdkAdInfo().getClk(), HWPasterAdWrapper.this.hwPasterAd));
                if (HWPasterAdWrapper.this.hwPasterAd.getInteractionListener() != null) {
                    HWPasterAdWrapper.this.hwPasterAd.getInteractionListener().onAdClicked();
                }
            }
        });
        instreamView.setInstreamMediaStateListener(new InstreamMediaStateListener() { // from class: com.meishu.sdk.platform.huawei.paster.HWPasterAdWrapper.3
            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaCompletion(int i) {
                if (HWPasterAdWrapper.this.getLoaderListener() != null) {
                    HWPasterAdWrapper.this.getLoaderListener().onVideoComplete();
                }
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaError(int i, int i2, int i3) {
                if (HWPasterAdWrapper.this.getLoaderListener() != null) {
                    HWPasterAdWrapper.this.getLoaderListener().onVideoError();
                }
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaPause(int i) {
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaProgress(int i, int i2) {
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaStart(int i) {
                if (HWPasterAdWrapper.this.getLoaderListener() != null) {
                    HWPasterAdWrapper.this.getLoaderListener().onAdExposure();
                }
                if (HWPasterAdWrapper.this.hwPasterAd.getInteractionListener() != null) {
                    HWPasterAdWrapper.this.hwPasterAd.getInteractionListener().onAdExposure();
                }
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamMediaStateListener
            public void onMediaStop(int i) {
            }
        });
        instreamView.setMediaMuteListener(new MediaMuteListener() { // from class: com.meishu.sdk.platform.huawei.paster.HWPasterAdWrapper.4
            @Override // com.huawei.hms.ads.MediaMuteListener
            public void onMute() {
            }

            @Override // com.huawei.hms.ads.MediaMuteListener
            public void onUnmute() {
            }
        });
        this.hwPasterAd = new HWPasterAd(this, instreamView);
        if (getLoaderListener() != null) {
            getLoaderListener().onAdLoaded(this.hwPasterAd);
            getLoaderListener().onAdReady(this.hwPasterAd);
        }
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        z.a(StubApp.getOrigApplicationContext(((PasterAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
        new InstreamAdLoader.Builder(this.context, getSdkAdInfo().getPid()).setTotalDuration(30).setMaxCount(1).setInstreamAdLoadListener(new InstreamAdLoadListener() { // from class: com.meishu.sdk.platform.huawei.paster.HWPasterAdWrapper.1
            @Override // com.huawei.hms.ads.instreamad.InstreamAdLoadListener
            public void onAdFailed(int i) {
                new HWPlatformError("加载出错", i, HWPasterAdWrapper.this.getSdkAdInfo()).post(HWPasterAdWrapper.this.loadListener);
            }

            @Override // com.huawei.hms.ads.instreamad.InstreamAdLoadListener
            public void onAdLoaded(List<InstreamAd> list) {
                HWPasterAdWrapper.this.initAd(list);
            }
        }).build().loadAd(new AdParam.Builder().build());
    }
}
