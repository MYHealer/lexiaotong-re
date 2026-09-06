package com.heytap.msp.mobad.api.params;

import android.view.View;
import com.heytap.msp.mobad.api.ad.IBidding;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface INativeTempletAdView extends IBidding {
    public static final String TAG = "INativeTempletAdView";

    void destroy();

    View getAdView();

    String getBidId();

    void render();
}
