package com.yfanads.android.custom;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.f;
import com.yfanads.android.core.h;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class MixBannerCustomAdapter extends NativeExpressCustomAdapter {
    public MixBannerCustomAdapter(YFNativeExpressSetting yFNativeExpressSetting) {
        super(yFNativeExpressSetting);
    }

    @Override // com.yfanads.android.custom.NativeExpressCustomAdapter
    public void doShowAD(Activity activity) {
        super.doShowAD(activity);
        try {
            if (isTemplate()) {
                YFLog.debug("doShowAD isTemplate|" + this.sdkSupplier);
                doShowTemplateAd(activity);
            } else if (isBanner()) {
                YFLog.debug("doShowAD isBanner|" + this.sdkSupplier);
                doShowBannerAd(activity);
            } else if (isNative() || isDevelop()) {
                YFLog.debug("doShowAD isNative or develop|" + this.sdkSupplier);
                doShowNativeAd(activity);
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("doShowAD error_"));
            YFNativeExpressSetting yFNativeExpressSetting = this.setting;
            if (yFNativeExpressSetting != null) {
                yFNativeExpressSetting.adapterRenderFailed(this.sdkSupplier);
            }
        }
    }

    public abstract void doShowBannerAd(Activity activity);

    public abstract void doShowTemplateAd(Activity activity);

    public abstract void loadBannerAd(Context context);

    public abstract void loadNativeAd(Context context);

    public abstract void loadTemplateAd(Context context);

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void startLoadAD(Context context) {
        super.startLoadAD(context);
        if (this.isDestroy || this.setting == null) {
            h.a(new StringBuilder(), this.tag, " isDestroy or setting null");
            return;
        }
        if (isTemplate()) {
            loadTemplateAd(context);
            return;
        }
        if (isNative() || isDevelop()) {
            loadNativeAd(context);
        } else if (isBanner()) {
            loadBannerAd(context);
        } else {
            handleFailed(YFAdError.parseErr(YFAdError.ERROR_DATA_NULL));
        }
    }
}
