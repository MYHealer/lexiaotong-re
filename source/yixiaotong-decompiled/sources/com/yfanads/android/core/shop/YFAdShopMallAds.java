package com.yfanads.android.core.shop;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.model.YFAdType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdShopMallAds extends i implements YFShopMallSetting {
    private YFShopMallListener listener;

    public YFAdShopMallAds(Context context, YFShopMallListener yFShopMallListener) {
        super(context, yFShopMallListener);
        setAdType(YFAdType.SHOPMALL);
        this.listener = yFShopMallListener;
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
        return 11;
    }

    @Override // com.yfanads.android.core.i
    public boolean isReady() {
        return super.isReady();
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
    }
}
