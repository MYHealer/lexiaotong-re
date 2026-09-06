package com.meishu.sdk.platform.jd.recycler;

import android.util.DisplayMetrics;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.JADSlot;
import com.jd.ad.sdk.feed.JADFeed;
import com.jd.ad.sdk.nativead.JADNative;
import com.jd.ad.sdk.nativead.JADNativeLoadListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.meishu.sdk.platform.jd.JDPlatformError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class JDFeedAdWrapper extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "JDFeedAdWrapper";
    private JADFeed jadFeed;
    private MeishuAdInfo meishuAdInfo;

    public JDFeedAdWrapper(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    private void loadExpressAd() {
        float fIntValue;
        float f;
        DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
        if (getAdLoader().getAccept_ad_width() == null || getAdLoader().getAccept_ad_width().intValue() <= 0) {
            fIntValue = displayMetrics.widthPixels;
            f = displayMetrics.density;
        } else {
            fIntValue = getAdLoader().getAccept_ad_width().intValue();
            f = displayMetrics.density;
        }
        JADSlot jADSlotBuild = new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setSize(fIntValue / f, (getAdLoader().getAccept_ad_height() == null || getAdLoader().getAccept_ad_height().intValue() <= 0) ? 0.0f : getAdLoader().getAccept_ad_height().intValue() / displayMetrics.density).build();
        JDExpressFeedAd jDExpressFeedAd = new JDExpressFeedAd(this);
        JADFeed jADFeed = new JADFeed(((RecyclerMixAdLoader) this.adLoader).getContext(), jADSlotBuild);
        this.jadFeed = jADFeed;
        jDExpressFeedAd.setFeedAd(jADFeed);
        this.jadFeed.loadAd(new JDFeedAdListenerImpl(this, (a) this.loadListener, jDExpressFeedAd));
    }

    private void loadNativeAd() {
        float width;
        float f;
        DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(this.context.getApplicationContext()).getResources().getDisplayMetrics();
        if (this.meishuAdInfo.getWidth() > 0) {
            width = this.meishuAdInfo.getWidth();
            f = displayMetrics.density;
        } else {
            width = displayMetrics.widthPixels;
            f = displayMetrics.density;
        }
        float f2 = width / f;
        final JADNative jADNative = new JADNative(new JADSlot.Builder().setSlotID(getSdkAdInfo().getPid()).setImageSize(f2, this.meishuAdInfo.getHeight() > 0 ? this.meishuAdInfo.getHeight() / displayMetrics.density : (9.0f * f2) / 16.0f).setAdType(2).build());
        jADNative.loadAd(new JADNativeLoadListener() { // from class: com.meishu.sdk.platform.jd.recycler.JDFeedAdWrapper.1
            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadFailure(int i, String str) {
                LogUtil.e(JDFeedAdWrapper.TAG, "onNoAD, code: " + i + ", msg: " + str);
                new JDPlatformError(str, Integer.valueOf(i), JDFeedAdWrapper.this.getSdkAdInfo()).post(JDFeedAdWrapper.this.getLoaderListener());
            }

            @Override // com.jd.ad.sdk.nativead.JADNativeLoadListener
            public void onLoadSuccess() {
                List<JADMaterialData> dataList = jADNative.getDataList();
                if (dataList.size() <= 0) {
                    new JDPlatformError(com.meishu.sdk.activity.a.a("list size is ").append(dataList.size()).toString(), 0, JDFeedAdWrapper.this.getSdkAdInfo()).post(JDFeedAdWrapper.this.getLoaderListener());
                    return;
                }
                JDFeedAdWrapper.this.getSdkAdInfo().setEcpm(String.valueOf(jADNative.getJADExtra().getPrice()));
                ArrayList arrayList = new ArrayList();
                Iterator<JADMaterialData> it = dataList.iterator();
                if (it.hasNext()) {
                    JADMaterialData next = it.next();
                    JDNativeFeedAd jDNativeFeedAd = new JDNativeFeedAd(JDFeedAdWrapper.this);
                    jDNativeFeedAd.setFeedAd(next, jADNative);
                    arrayList.add(jDNativeFeedAd);
                }
                ((a) JDFeedAdWrapper.this.loadListener).onAdLoaded(arrayList);
                ((a) JDFeedAdWrapper.this.loadListener).onAdReady(arrayList);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005c, code lost:
    
        if (r0 == 100000) goto L14;
     */
    @Override // com.meishu.sdk.core.loader.IAdLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void loadAd() {
        z.a(StubApp.getOrigApplicationContext(((RecyclerMixAdLoader) this.adLoader).getContext().getApplicationContext()), h0.a(getSdkAdInfo().getReq()), new i());
        int adPatternType = getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            int drawing = getSdkAdInfo().getDrawing();
            if (drawing != 1) {
                if (drawing != 2) {
                    new CSJPlatformError("信息流模式不支持", -1, getSdkAdInfo()).post(this.loadListener);
                    return;
                }
                loadExpressAd();
                return;
            }
            loadNativeAd();
        }
    }
}
