package com.meishu.sdk.platform.gdt.image;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.image.a;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTImageAdDataAdapter {
    private GDTNativeAdListenerImpl adListener;
    private NativeUnifiedADData gdtNativeADData;

    public GDTImageAdDataAdapter(NativeUnifiedADData nativeUnifiedADData, GDTNativeAdListenerImpl gDTNativeAdListenerImpl) {
        this.gdtNativeADData = nativeUnifiedADData;
        this.adListener = gDTNativeAdListenerImpl;
    }

    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, a aVar) {
        NativeAdContainer nativeAdContainer = new NativeAdContainer(viewGroup.getContext());
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
        viewGroup2.removeView(viewGroup);
        nativeAdContainer.addView(viewGroup);
        viewGroup2.addView(nativeAdContainer);
        this.gdtNativeADData.bindAdToView(context, nativeAdContainer, null, list);
        this.gdtNativeADData.setNativeAdEventListener(new GDTNativeAdEventListenerImpl(this, aVar));
    }

    public GDTNativeAdListenerImpl getAdListener() {
        return this.adListener;
    }

    public int getAdPatternType() {
        return this.gdtNativeADData.getAdPatternType();
    }

    public String getDesc() {
        return this.gdtNativeADData.getDesc();
    }

    public String getIconUrl() {
        return this.gdtNativeADData.getIconUrl();
    }

    public String[] getImgList() {
        if (this.gdtNativeADData.getImgList() != null) {
            return (String[]) this.gdtNativeADData.getImgList().toArray(new String[0]);
        }
        return null;
    }

    public int getInteractionType() {
        return this.gdtNativeADData.isAppAd() ? 1 : 0;
    }

    public String getTitle() {
        return this.gdtNativeADData.getTitle();
    }

    public void destroy() {
        NativeUnifiedADData nativeUnifiedADData = this.gdtNativeADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.destroy();
        }
    }
}
