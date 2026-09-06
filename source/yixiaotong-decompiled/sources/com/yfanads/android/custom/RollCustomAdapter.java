package com.yfanads.android.custom;

import android.app.Activity;
import android.view.ViewGroup;
import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.roll.YFRollAdsSetting;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class RollCustomAdapter extends BaseChanelAdapter {
    public YFRollAdsSetting setting;

    public RollCustomAdapter(YFRollAdsSetting yFRollAdsSetting) {
        super(yFRollAdsSetting);
        this.setting = yFRollAdsSetting;
    }

    public void closeAds(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        handleClose();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void doDestroy() {
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
    public boolean isSupportCache() {
        return true;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public void setAdsSpotListener(BaseAdapterEvent baseAdapterEvent) {
        super.setAdsSpotListener(baseAdapterEvent);
        if (baseAdapterEvent instanceof YFRollAdsSetting) {
            this.setting = (YFRollAdsSetting) baseAdapterEvent;
        }
    }
}
