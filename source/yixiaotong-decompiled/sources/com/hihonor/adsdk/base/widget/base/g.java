package com.hihonor.adsdk.base.widget.base;

import android.view.View;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class g {
    private static final String hnadsa = "ViewProxyUtils";

    public static boolean hnadsa(View view) {
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "View is null, No registration required.", new Object[0]);
            return true;
        }
        if (view instanceof HnDownloadButton) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "HnDownloadButton No registration required.", new Object[0]);
            return true;
        }
        if (!(view instanceof BaseAdView)) {
            return false;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "PictureTextAdRootView No registration required.", new Object[0]);
        return true;
    }

    public static View.OnClickListener hnadsb(View view) {
        View.OnClickListener onClickListenerHnadsa = com.hihonor.adsdk.common.f.e.hnadsa(view);
        return onClickListenerHnadsa instanceof com.hihonor.adsdk.common.f.e.b ? ((com.hihonor.adsdk.common.f.e.b) onClickListenerHnadsa).hnadsa() : onClickListenerHnadsa;
    }
}
