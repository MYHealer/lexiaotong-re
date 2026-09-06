package com.meishu.sdk.platform.gdt.media;

import com.meishu.sdk.core.ad.media.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeAdListenerImpl implements NativeADUnifiedListener {
    private static final String TAG = "GDTNativeAdListenerImpl";
    private a nativeMediaAdListener;

    public GDTNativeAdListenerImpl(a aVar) {
        this.nativeMediaAdListener = aVar;
    }

    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
    public void onADLoaded(List<NativeUnifiedADData> list) {
        if (this.nativeMediaAdListener == null || list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<NativeUnifiedADData> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GDTNativeMediaAdDataAdapter(it.next()));
        }
        this.nativeMediaAdListener.onAdLoaded(arrayList);
    }

    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
    public void onNoAD(AdError adError) {
        LogUtil.d(TAG, "onNoAD: ");
        new GDTPlatformError(adError, null).post(this.nativeMediaAdListener);
    }
}
