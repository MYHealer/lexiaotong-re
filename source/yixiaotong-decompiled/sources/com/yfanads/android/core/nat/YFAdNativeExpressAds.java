package com.yfanads.android.core.nat;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdNativeExpressAds extends i implements YFNativeExpressSetting {
    private static final int MAX_NUMBER = 5;
    private int adsNumbers;
    private int isReadyIndex;
    private YFNativeExpressListener listener;
    public int viewHeight;
    public int viewWidth;

    public YFAdNativeExpressAds(Context context, YFNativeExpressListener yFNativeExpressListener) {
        super(context, yFNativeExpressListener);
        this.viewHeight = 0;
        this.adsNumbers = 1;
        this.isReadyIndex = 0;
        setAdType(YFAdType.NATIV);
        this.listener = yFNativeExpressListener;
        this.viewWidth = ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context));
    }

    @Override // com.yfanads.android.core.nat.YFNativeExpressSetting
    public void adapterRenderSuccess(SdkSupplier sdkSupplier, List<ExpView> list) {
        YFLog.traceDebug("adapterRenderSuccess " + sdkSupplier);
        YFNativeExpressListener yFNativeExpressListener = this.listener;
        if (yFNativeExpressListener != null) {
            yFNativeExpressListener.onAdRenderSuccess(list);
        }
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        super.destroy();
        if (this.listener != null) {
            this.listener = null;
        }
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 2;
    }

    @Override // com.yfanads.android.core.nat.YFNativeExpressSetting
    public int getAdsNumbers() {
        return Math.min(this.adsNumbers, 5);
    }

    @Override // com.yfanads.android.core.nat.YFNativeExpressSetting
    public int getReadyIndex() {
        return this.isReadyIndex;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewHeight() {
        return this.viewHeight;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    public int getViewWidth() {
        return this.viewWidth;
    }

    public void setAdsNumbers(int i) {
        this.adsNumbers = i;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
    }

    public boolean isReady(int i) {
        this.isReadyIndex = i;
        return super.isReady();
    }

    public void setViewAcceptedSize(int i, int i2) {
        this.viewWidth = i;
        this.viewHeight = i2;
        YFLog.debug("setViewAcceptedSize width dp_" + this.viewWidth + " height dp_" + this.viewHeight);
    }
}
