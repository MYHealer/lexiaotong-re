package com.yfanads.android.core;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;

/* JADX INFO: compiled from: NoChannelAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class j extends BaseChanelAdapter {
    public j(SdkSupplier sdkSupplier) {
        this();
        this.sdkSupplier = sdkSupplier;
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public final void doDestroy() {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doLoadAD */
    public final void m1208x201b9c1d(Context context) {
        handleFailed(YFAdError.ERROR_NONE_SDK, "");
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    /* JADX INFO: renamed from: doShowAD */
    public final void m1207lambda$showAds$1$comyfanadsandroidcoreBaseChanelAdapter(Activity activity, ViewGroup viewGroup) {
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public final int getAType() {
        return YFAdType.NONE.getValue();
    }

    @Override // com.yfanads.android.core.BaseChanelAdapter
    public final int getAdnId() {
        return 0;
    }

    public j() {
        super(null);
    }
}
