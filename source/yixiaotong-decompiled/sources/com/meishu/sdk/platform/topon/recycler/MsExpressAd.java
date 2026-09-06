package com.meishu.sdk.platform.topon.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsExpressAd extends CustomNativeAd {
    private RecyclerAdData adData;

    public MsExpressAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
    }

    public View getAdMediaView(Object... objArr) {
        return this.adData.getAdView();
    }

    public boolean isNativeExpress() {
        return true;
    }

    public boolean isValid() {
        RecyclerAdData recyclerAdData = this.adData;
        return recyclerAdData != null && recyclerAdData.isAdValid();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(view);
        this.adData.bindAdToView(view.getContext(), (ViewGroup) view, arrayList, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.topon.recycler.MsExpressAd.1
            @Override // com.meishu.sdk.core.loader.InteractionListener
            public void onAdClicked() {
                MsExpressAd.this.notifyAdClicked();
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdClosed() {
                MsExpressAd.this.notifyAdDislikeClick();
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdExposure() {
                MsExpressAd.this.notifyAdImpression();
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
            public void onAdRenderFailed() {
            }
        });
    }

    public void destroy() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
        }
    }
}
