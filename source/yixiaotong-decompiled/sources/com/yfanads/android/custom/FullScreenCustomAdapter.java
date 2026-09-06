package com.yfanads.android.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.upload.b;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class FullScreenCustomAdapter extends BaseChanelAdapter {
    public YFFullScreenVideoSetting mFullSetting;

    public FullScreenCustomAdapter(YFFullScreenVideoSetting yFFullScreenVideoSetting) {
        super(yFFullScreenVideoSetting);
        this.mFullSetting = yFFullScreenVideoSetting;
    }

    private void handleSkipClose() {
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() - this.exposureStartTime);
            YFLog.high(this.tag + " handleSkipClose " + iCurrentTimeMillis);
            if (!this.hasClose) {
                boolean z = b.e;
                b.a.f9685a.a(this.sdkSupplier, YFAdsConst.ReportETypeValue.CLOSE.getValue(), iCurrentTimeMillis);
            }
            this.hasClose = true;
            if (this.mFullSetting != null) {
                YFUtil.switchMainThread("handleSkipClose", new BaseEnsureListener() { // from class: com.yfanads.android.custom.FullScreenCustomAdapter$$ExternalSyntheticLambda0
                    @Override // com.yfanads.android.callback.BaseEnsureListener
                    public final void ensure() {
                        this.f$0.m1222x6054382c();
                    }
                });
            }
        } catch (Throwable th) {
            YFLog.error(this.tag + th.getMessage());
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (this.mFullSetting != null) {
            this.mFullSetting = null;
        }
    }

    public void doShowAD(Activity activity) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
        handleShowApiInvoke();
        doShowAD(activity);
    }

    public void handleClose(boolean z) {
        if (z) {
            handleSkipClose();
        } else {
            handleClose();
        }
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    /* JADX INFO: renamed from: lambda$handleSkipClose$0$com-yfanads-android-custom-FullScreenCustomAdapter, reason: not valid java name */
    /* synthetic */ void m1222x6054382c() {
        this.mFullSetting.adapterVideoSkipped(this.sdkSupplier);
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFFullScreenVideoSetting) {
            this.mFullSetting = (YFFullScreenVideoSetting) baseAdapterEvent;
        }
    }

    public void handleCached() {
        try {
            YFFullScreenVideoSetting yFFullScreenVideoSetting = this.mFullSetting;
            if (yFFullScreenVideoSetting != null) {
                yFFullScreenVideoSetting.adapterVideoCached(this.sdkSupplier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void handleVideoComplete() {
        try {
            YFFullScreenVideoSetting yFFullScreenVideoSetting = this.mFullSetting;
            if (yFFullScreenVideoSetting != null) {
                yFFullScreenVideoSetting.adapterVideoComplete(this.sdkSupplier);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
