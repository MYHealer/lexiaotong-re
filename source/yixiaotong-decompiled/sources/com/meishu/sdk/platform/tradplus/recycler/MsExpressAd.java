package com.meishu.sdk.platform.tradplus.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.utils.LogUtil;
import com.tradplus.ads.base.adapter.nativead.TPNativeAdView;
import com.tradplus.ads.base.bean.TPBaseAd;
import com.tradplus.ads.base.common.TPError;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsExpressAd extends TPBaseAd {
    private static final String TAG = "TradPlus_MsExpressAd";
    private RecyclerAdData adData;

    public MsExpressAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setExpressMediaListener();
    }

    public ViewGroup getCustomAdContainer() {
        return null;
    }

    public List<View> getMediaViews() {
        return null;
    }

    public int getNativeAdType() {
        return 1;
    }

    public Object getNetworkObj() {
        return null;
    }

    public View getRenderView() {
        return this.adData.getAdView();
    }

    public TPNativeAdView getTPNativeView() {
        return null;
    }

    public void registerClickAfterRender(ViewGroup viewGroup, ArrayList<View> arrayList) {
        LogUtil.d(TAG, "registerClickAfterRender");
        this.adData.bindAdToView(viewGroup.getContext(), viewGroup, arrayList, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsExpressAd.1
            @Override // com.meishu.sdk.core.loader.InteractionListener
            public void onAdClicked() {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdClicked();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdClosed() {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdClosed();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
            public void onAdExposure() {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdShown();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
            public void onAdRenderFailed() {
            }
        });
    }

    public void registerClickView(ViewGroup viewGroup, ArrayList<View> arrayList) {
    }

    public void clean() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
            this.adData = null;
        }
    }

    private void setExpressMediaListener() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData == null) {
            return;
        }
        recyclerAdData.setExpressMediaListener(new ExpressMediaListener() { // from class: com.meishu.sdk.platform.tradplus.recycler.MsExpressAd.2
            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoCompleted() {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdVideoEnd();
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoError(int i, String str) {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdVideoError(new TPError(String.valueOf(i), str));
                }
            }

            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoLoaded() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoPause() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoResume() {
            }

            @Override // com.meishu.sdk.core.ad.recycler.ExpressMediaListener
            public void onVideoStart() {
                if (((TPBaseAd) MsExpressAd.this).mShowListener != null) {
                    ((TPBaseAd) MsExpressAd.this).mShowListener.onAdVideoStart();
                }
            }
        });
    }
}
