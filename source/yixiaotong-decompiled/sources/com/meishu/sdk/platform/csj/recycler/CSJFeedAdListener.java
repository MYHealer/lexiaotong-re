package com.meishu.sdk.platform.csj.recycler;

import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJFeedAdListener implements TTAdNative.FeedAdListener, TTAdNative.NativeExpressAdListener {
    private static final String TAG = "CSJFeedAdListener";
    private CSJTTAdNativeWrapper adNativeWrapper;
    private a recyclerAdListener;

    public CSJFeedAdListener(CSJTTAdNativeWrapper cSJTTAdNativeWrapper, a aVar) {
        this.adNativeWrapper = cSJTTAdNativeWrapper;
        this.recyclerAdListener = aVar;
    }

    public void destroy() {
        this.adNativeWrapper = null;
        this.recyclerAdListener = null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onError(int i, String str) {
        LogUtil.e(TAG, "onError, code: " + i + ", msg: " + str);
        try {
            if (this.adNativeWrapper == null || this.recyclerAdListener == null) {
                return;
            }
            new CSJPlatformError(str, Integer.valueOf(i), this.adNativeWrapper.getSdkAdInfo()).post(this.recyclerAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
    public void onFeedAdLoad(List<TTFeedAd> list) {
        if (list != null) {
            try {
                if (this.recyclerAdListener != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<TTFeedAd> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new CSJRecyclerAdDataAdapter(this.adNativeWrapper, it.next()));
                    }
                    this.recyclerAdListener.onAdLoaded(arrayList);
                    this.recyclerAdListener.onAdReady(arrayList);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
    public void onNativeExpressAdLoad(List<TTNativeExpressAd> list) {
        if (list != null) {
            try {
                if (this.recyclerAdListener != null) {
                    ArrayList arrayList = new ArrayList();
                    for (TTNativeExpressAd tTNativeExpressAd : list) {
                        CSJNativeExpressAdDataAdapter cSJNativeExpressAdDataAdapter = new CSJNativeExpressAdDataAdapter(this.adNativeWrapper, tTNativeExpressAd);
                        tTNativeExpressAd.setExpressInteractionListener(new CSJNativeExpressAdInteractionListenerAdapter(cSJNativeExpressAdDataAdapter, tTNativeExpressAd));
                        tTNativeExpressAd.render();
                        arrayList.add(cSJNativeExpressAdDataAdapter);
                    }
                    this.recyclerAdListener.onAdLoaded(arrayList);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
