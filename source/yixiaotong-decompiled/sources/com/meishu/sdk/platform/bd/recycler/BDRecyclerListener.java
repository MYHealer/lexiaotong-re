package com.meishu.sdk.platform.bd.recycler;

import android.util.Log;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.platform.bd.BDPlatformError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRecyclerListener implements BaiduNativeManager.FeedAdListener {
    private static final String TAG = "BDRecyclerListener";
    private BDRecyclerAd bdRecyclerAd;
    private BDRecyclerLoader bdRecyclerLoader;
    private int count;
    private List<NativeResponse> list;
    private a meishuAdListener;

    public BDRecyclerListener(a aVar, BDRecyclerLoader bDRecyclerLoader, int i) {
        this.meishuAdListener = aVar;
        this.bdRecyclerLoader = bDRecyclerLoader;
    }

    public List<NativeResponse> getList() {
        return this.list;
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onLpClosed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
        try {
            LogUtil.e(TAG, "onNativeFail: code=" + i + ", msg=" + str);
            if (str == null || str.startsWith("exception")) {
                return;
            }
            new BDPlatformError(str, this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNoAd(int i, String str, NativeResponse nativeResponse) {
        try {
            LogUtil.e(TAG, "onNativeFail: code=" + i + ", msg=" + str);
            if (str == null || str.startsWith("exception")) {
                return;
            }
            new BDPlatformError(str, this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadFailed() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onVideoDownloadSuccess() {
    }

    @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
    public void onNativeLoad(List<NativeResponse> list) {
        try {
            this.list = list;
            int adPatternType = this.bdRecyclerLoader.getAdLoader().getAdPatternType();
            boolean z = true;
            if (adPatternType == 200000) {
                int drawing = this.bdRecyclerLoader.getSdkAdInfo().getDrawing();
                if (drawing == 1) {
                    z = false;
                } else if (drawing != 2) {
                    new BDPlatformError("信息流模式不支持", this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
                    return;
                }
            } else if (adPatternType != 100000) {
                z = false;
            }
            Log.e("TimeFirstStrategy", "onNativeLoad: isPreRender=" + z);
            if (z) {
                if (list == null || list.isEmpty() || this.meishuAdListener == null) {
                    return;
                }
                try {
                    this.bdRecyclerLoader.getSdkAdInfo().setEcpm(list.get(0).getECPMLevel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ArrayList arrayList = new ArrayList();
                for (NativeResponse nativeResponse : list) {
                    if (nativeResponse != null && nativeResponse.getStyleType() != 0) {
                        try {
                            final FeedNativeView feedNativeView = new FeedNativeView(StubApp.getOrigApplicationContext(this.bdRecyclerLoader.getContext().getApplicationContext()));
                            if (feedNativeView.getParent() != null) {
                                ((ViewGroup) feedNativeView.getParent()).removeView(feedNativeView);
                            }
                            XAdNativeResponse xAdNativeResponse = (XAdNativeResponse) nativeResponse;
                            xAdNativeResponse.setAdDislikeListener(new NativeResponse.AdDislikeListener() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerListener.1
                                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                                public void onDislikeItemClick(String str) {
                                    try {
                                        if (BDRecyclerListener.this.meishuAdListener != null) {
                                            BDRecyclerListener.this.meishuAdListener.onAdClosed();
                                        }
                                        if (BDRecyclerListener.this.bdRecyclerAd != null && BDRecyclerListener.this.bdRecyclerAd.getRecylcerAdInteractionListener() != null) {
                                            BDRecyclerListener.this.bdRecyclerAd.getRecylcerAdInteractionListener().onAdClosed();
                                        }
                                        FeedNativeView feedNativeView2 = feedNativeView;
                                        if (feedNativeView2 == null || feedNativeView2.getParent() == null) {
                                            return;
                                        }
                                        ((ViewGroup) feedNativeView.getParent()).removeView(feedNativeView);
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                }

                                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                                public void onDislikeWindowClose() {
                                }

                                @Override // com.baidu.mobads.sdk.api.NativeResponse.AdDislikeListener
                                public void onDislikeWindowShow() {
                                }
                            });
                            feedNativeView.setAdData(xAdNativeResponse);
                            BDRecyclerAd bDRecyclerAd = new BDRecyclerAd(nativeResponse, feedNativeView, this.bdRecyclerLoader);
                            this.bdRecyclerAd = bDRecyclerAd;
                            arrayList.add(bDRecyclerAd);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    this.meishuAdListener.onAdLoaded(arrayList);
                    this.meishuAdListener.onAdReady(arrayList);
                    return;
                }
                return;
            }
            if (list == null || list.isEmpty() || this.meishuAdListener == null) {
                return;
            }
            try {
                this.bdRecyclerLoader.getSdkAdInfo().setEcpm(list.get(0).getECPMLevel());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            try {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    arrayList2.add(new BDRecyclerAd(list.get(i), null, this.bdRecyclerLoader));
                }
                this.meishuAdListener.onAdLoaded(arrayList2);
                this.meishuAdListener.onAdReady(arrayList2);
                return;
            } catch (Exception e3) {
                e3.printStackTrace();
                new BDPlatformError("load error", this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        th2.printStackTrace();
    }

    public void onNativeFail(int i, String str) {
        try {
            LogUtil.e(TAG, "onNativeFail: code=" + i + ", msg=" + str);
            if (str == null || str.startsWith("exception")) {
                return;
            }
            new BDPlatformError(str, this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onNoAd(int i, String str) {
        try {
            LogUtil.e(TAG, "onNativeFail: code=" + i + ", msg=" + str);
            if (str == null || str.startsWith("exception")) {
                return;
            }
            new BDPlatformError(str, this.bdRecyclerLoader.getSdkAdInfo()).post(this.meishuAdListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
