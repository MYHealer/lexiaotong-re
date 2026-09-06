package com.yfanads.android.core.toppush;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.model.YFAdType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdTopPushAds extends i implements YFTopPushSetting {
    private YFTopPushListener listener;

    public YFAdTopPushAds(Context context, YFTopPushListener yFTopPushListener) {
        super(context, yFTopPushListener);
        setAdType(YFAdType.TOPPUSH);
        this.listener = yFTopPushListener;
    }

    @Override // com.yfanads.android.core.i
    public void closeAds() {
        super.closeAds();
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
        return 10;
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
