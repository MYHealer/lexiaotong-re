package com.meishu.sdk.platform.csj.image;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.meishu.sdk.core.ad.image.b;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJNativeAdListener implements TTAdNative.NativeAdListener {
    private static final String TAG = "CSJNativeAdListener";
    private CSJTTAdNativeWrapper adWrapper;
    private b meishuAdListener;

    public CSJNativeAdListener(CSJTTAdNativeWrapper cSJTTAdNativeWrapper, b bVar) {
        this.adWrapper = cSJTTAdNativeWrapper;
        this.meishuAdListener = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
    public void onError(int i, String str) {
        LogUtil.e(TAG, "onError, code: " + i + ", msg: " + str);
        new CSJPlatformError(str, Integer.valueOf(i), null).post(this.meishuAdListener);
    }

    public void onAdExposure() {
        b bVar = this.meishuAdListener;
        if (bVar != null) {
            bVar.onAdExposure();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeAdListener
    public void onNativeAdLoad(List<TTNativeAd> list) {
        if (list == null || this.meishuAdListener == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<TTNativeAd> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new CSJImageAdDataAdapter(it.next(), this));
        }
        this.meishuAdListener.onAdLoaded(arrayList);
    }
}
