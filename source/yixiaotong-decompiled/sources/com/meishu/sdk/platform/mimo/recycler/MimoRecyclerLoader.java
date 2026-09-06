package com.meishu.sdk.platform.mimo.recycler;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.meishu.sdk.platform.mimo.MimoPlatformError;
import com.miui.zeus.mimo.sdk.NativeAd;
import com.miui.zeus.mimo.sdk.NativeAdData;
import com.miui.zeus.mimo.sdk.TemplateAd;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoRecyclerLoader extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "MimoRecyclerLoader";

    public MimoRecyclerLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
    }

    private void loadFeed() {
        final NativeAd nativeAd = new NativeAd();
        Log.e(TAG, "loadFeed");
        nativeAd.load(this.sdkAdInfo.getPid(), new NativeAd.NativeAdLoadListener() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerLoader.2
            @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdLoadListener
            public void onAdLoadFailed(int i, String str) {
                LogUtil.i(MimoRecyclerLoader.TAG, "onAdLoadFailed" + i + ": " + str);
                new MimoPlatformError(str, Integer.valueOf(i), MimoRecyclerLoader.this.getSdkAdInfo()).post(MimoRecyclerLoader.this.loadListener);
            }

            @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdLoadListener
            public void onAdLoadSuccess(final NativeAdData nativeAdData) {
                LogUtil.i(MimoRecyclerLoader.TAG, "NativeAd.onAdLoadSuccess");
                new Handler(Looper.getMainLooper()).post(new l() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerLoader.2.1
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        if (MimoRecyclerLoader.this.getLoaderListener() != null) {
                            ArrayList arrayList = new ArrayList();
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            arrayList.add(new MimoRecyclerAd(nativeAd, nativeAdData, MimoRecyclerLoader.this));
                            if (MimoRecyclerLoader.this.getLoaderListener() != null) {
                                MimoRecyclerLoader.this.getLoaderListener().onAdLoaded(arrayList);
                                MimoRecyclerLoader.this.getLoaderListener().onAdReady(arrayList);
                            }
                        }
                    }
                });
            }
        });
    }

    private void loadPreRender() {
        final TemplateAd templateAd = new TemplateAd();
        templateAd.load(this.sdkAdInfo.getPid(), new TemplateAd.TemplateAdLoadListener() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerLoader.1
            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoadFailed(int i, String str) {
                LogUtil.i(MimoRecyclerLoader.TAG, "TemplateAd.onAdLoadFailed" + i + ": " + str);
                new MimoPlatformError(str, Integer.valueOf(i), MimoRecyclerLoader.this.getSdkAdInfo()).post(MimoRecyclerLoader.this.loadListener);
            }

            @Override // com.miui.zeus.mimo.sdk.TemplateAd.TemplateAdLoadListener
            public void onAdLoaded() {
                LogUtil.i(MimoRecyclerLoader.TAG, "TemplateAd.onAdLoaded");
                new Handler(Looper.getMainLooper()).post(new l() { // from class: com.meishu.sdk.platform.mimo.recycler.MimoRecyclerLoader.1.1
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        Log.e(MimoRecyclerLoader.TAG, com.meishu.sdk.activity.a.a("loadFeedAd success,主线程： ").append(Thread.currentThread()).toString());
                        if (MimoRecyclerLoader.this.getLoaderListener() != null) {
                            ArrayList arrayList = new ArrayList();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            arrayList.add(new MimoRecyclerAd(templateAd, MimoRecyclerLoader.this));
                            if (MimoRecyclerLoader.this.getLoaderListener() != null) {
                                MimoRecyclerLoader.this.getLoaderListener().onAdLoaded(arrayList);
                                MimoRecyclerLoader.this.getLoaderListener().onAdReady(arrayList);
                            }
                        }
                    }
                });
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r0 == 100000) goto L14;
     */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadAd() {
        z.a(((RecyclerMixAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
        int adPatternType = getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            int drawing = getSdkAdInfo().getDrawing();
            if (drawing != 1) {
                if (drawing != 2) {
                    new CSJPlatformError("信息流模式不支持", -1, getSdkAdInfo()).post(this.loadListener);
                    return;
                }
                loadPreRender();
                return;
            }
            loadFeed();
        }
    }
}
