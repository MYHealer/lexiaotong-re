package com.meishu.sdk.platform.csj.image;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.meishu.sdk.core.ad.image.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJImageAdDataAdapter {
    private CSJNativeAdListener adListener;
    private TTNativeAd ttNativeAd;

    public CSJImageAdDataAdapter(TTNativeAd tTNativeAd, CSJNativeAdListener cSJNativeAdListener) {
        this.ttNativeAd = tTNativeAd;
        this.adListener = cSJNativeAdListener;
    }

    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, a aVar) {
        this.ttNativeAd.registerViewForInteraction(viewGroup, list, null, new CSJAdInteractionListener(this, aVar));
    }

    public void destroy() {
    }

    public CSJNativeAdListener getAdListener() {
        return this.adListener;
    }

    public int getAdPatternType() {
        return this.ttNativeAd.getInteractionType();
    }

    public String getDesc() {
        return this.ttNativeAd.getDescription();
    }

    public String getIconUrl() {
        return this.ttNativeAd.getIcon().getImageUrl();
    }

    public String[] getImgList() {
        List<TTImage> imageList = this.ttNativeAd.getImageList();
        if (imageList == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTImage> it = imageList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getImageUrl());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public int getInteractionType() {
        int interactionType = this.ttNativeAd.getInteractionType();
        return (interactionType == 2 || interactionType == 3 || interactionType != 4) ? 0 : 1;
    }

    public String getTitle() {
        return this.ttNativeAd.getTitle();
    }
}
