package com.yfanads.android.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFListUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class NativeCustomAdapter extends BaseChanelAdapter {
    public List<YFNativeAd> nativeAds;
    public YFNativeSetting setting;

    public NativeCustomAdapter(YFNativeSetting yFNativeSetting) {
        super(yFNativeSetting);
        this.nativeAds = new ArrayList();
        this.setting = yFNativeSetting;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
        if (!this.nativeAds.isEmpty()) {
            Iterator<YFNativeAd> it = this.nativeAds.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
        }
        if (this.setting != null) {
            this.setting = null;
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

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public AdInfo getAdInfo() {
        return (YFListUtils.isEmpty(this.nativeAds) || !(this.nativeAds.get(0) instanceof YFAbsNativeAd)) ? super.getAdInfo() : InitUtils.getAdInfo((YFAbsNativeAd) this.nativeAds.get(0), getRequestId());
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public boolean isSupportCache() {
        return true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFNativeSetting) {
            this.setting = (YFNativeSetting) baseAdapterEvent;
        }
    }
}
