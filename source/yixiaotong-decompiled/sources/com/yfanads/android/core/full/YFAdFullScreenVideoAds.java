package com.yfanads.android.core.full;

import android.app.Activity;
import android.content.Context;
import com.yfanads.android.core.i;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdFullScreenVideoAds extends i implements YFFullScreenVideoSetting {
    private YFFullScreenVideoListener listener;

    public YFAdFullScreenVideoAds(Context context, YFFullScreenVideoListener yFFullScreenVideoListener) {
        super(context, yFFullScreenVideoListener);
        setAdType(YFAdType.FULL);
        this.listener = yFFullScreenVideoListener;
    }

    @Override // com.yfanads.android.core.full.YFFullScreenVideoSetting
    public void adapterVideoCached(SdkSupplier sdkSupplier) {
        YFLog.traceDebug("adapterVideoCached " + sdkSupplier);
        YFFullScreenVideoListener yFFullScreenVideoListener = this.listener;
        if (yFFullScreenVideoListener != null) {
            yFFullScreenVideoListener.onVideoCached();
        }
    }

    @Override // com.yfanads.android.core.full.YFFullScreenVideoSetting
    public void adapterVideoComplete(SdkSupplier sdkSupplier) {
        YFLog.traceDebug("adapterVideoComplete " + sdkSupplier);
        YFFullScreenVideoListener yFFullScreenVideoListener = this.listener;
        if (yFFullScreenVideoListener != null) {
            yFFullScreenVideoListener.onVideoComplete();
        }
    }

    @Override // com.yfanads.android.core.full.YFFullScreenVideoSetting
    public void adapterVideoSkipped(SdkSupplier sdkSupplier) {
        YFLog.traceDebug("adapterVideoSkipped " + sdkSupplier);
        YFFullScreenVideoListener yFFullScreenVideoListener = this.listener;
        if (yFFullScreenVideoListener != null) {
            yFFullScreenVideoListener.onVideoSkipped();
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
        return 6;
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
    }
}
