package com.meishu.sdk.platform.topon.recycler;

import android.view.View;
import android.view.ViewGroup;
import com.anythink.nativead.api.ATNativePrepareInfo;
import com.anythink.nativead.unitgroup.api.CustomNativeAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsNativeAd extends CustomNativeAd {
    private RecyclerAdData adData;

    public MsNativeAd(RecyclerAdData recyclerAdData) {
        this.adData = recyclerAdData;
        setAdData();
    }

    private void setAdData() {
        setTitle(this.adData.getTitle());
        setDescriptionText(this.adData.getDesc());
        setIconImageUrl(this.adData.getIconUrl());
        setAdChoiceIconUrl(this.adData.getFromLogo());
        String[] imgUrls = this.adData.getImgUrls();
        if (imgUrls != null && imgUrls.length > 0) {
            setMainImageUrl(imgUrls[0]);
            setImageUrlList(Arrays.asList(imgUrls));
        }
        setCallToActionText(this.adData.getActionText());
        setMainImageWidth(this.adData.getWidth());
        setMainImageHeight(this.adData.getHeight());
    }

    public View getAdMediaView(Object... objArr) {
        return null;
    }

    public ViewGroup getCustomAdContainer() {
        return super.getCustomAdContainer();
    }

    public boolean isNativeExpress() {
        return false;
    }

    public boolean isValid() {
        RecyclerAdData recyclerAdData = this.adData;
        return recyclerAdData != null && recyclerAdData.isAdValid();
    }

    public void prepare(View view, ATNativePrepareInfo aTNativePrepareInfo) {
        if (view instanceof ViewGroup) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(view);
            this.adData.bindAdToView(view.getContext(), (ViewGroup) view, arrayList, new RecylcerAdInteractionListener() { // from class: com.meishu.sdk.platform.topon.recycler.MsNativeAd.1
                @Override // com.meishu.sdk.core.loader.InteractionListener
                public void onAdClicked() {
                    MsNativeAd.this.notifyAdClicked();
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdClosed() {
                    MsNativeAd.this.notifyAdDislikeClick();
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
                public void onAdExposure() {
                    MsNativeAd.this.notifyAdImpression();
                }

                @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
                public void onAdRenderFailed() {
                }
            });
        }
    }

    public void destroy() {
        RecyclerAdData recyclerAdData = this.adData;
        if (recyclerAdData != null) {
            recyclerAdData.destroy();
        }
    }
}
