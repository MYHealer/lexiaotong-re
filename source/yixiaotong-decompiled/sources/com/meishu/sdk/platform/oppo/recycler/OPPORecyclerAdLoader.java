package com.meishu.sdk.platform.oppo.recycler;

import android.text.TextUtils;
import com.heytap.msp.mobad.api.ad.NativeAdvanceAd;
import com.heytap.msp.mobad.api.ad.NativeTempletAd;
import com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener;
import com.heytap.msp.mobad.api.listener.INativeTempletAdListener;
import com.heytap.msp.mobad.api.params.INativeAdvanceData;
import com.heytap.msp.mobad.api.params.INativeTempletAdView;
import com.heytap.msp.mobad.api.params.NativeAdError;
import com.heytap.msp.mobad.api.params.NativeAdSize;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.a;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.platform.BasePlatformLoader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class OPPORecyclerAdLoader extends BasePlatformLoader<RecyclerMixAdLoader, a> {
    private static final String TAG = "OPPORecyclerAdLoader";
    private ArrayList<NativeAdvanceAd> nativeAdvanceAdList;
    private ArrayList<NativeTempletAd> nativeTemplateAdList;
    private ArrayList<OPPORecyclerAd> oppoRecyclerAdList;
    private ArrayList<OPPOTemplateRecyclerAd> oppoTemplateRecyclerAdList;

    public OPPORecyclerAdLoader(RecyclerMixAdLoader recyclerMixAdLoader, SdkAdInfo sdkAdInfo) {
        super(recyclerMixAdLoader, sdkAdInfo);
        this.oppoTemplateRecyclerAdList = new ArrayList<>();
        this.nativeTemplateAdList = new ArrayList<>();
        this.oppoRecyclerAdList = new ArrayList<>();
        this.nativeAdvanceAdList = new ArrayList<>();
    }

    private void loadRecycler() {
        NativeAdvanceAd nativeAdvanceAd = new NativeAdvanceAd(getContext(), getSdkAdInfo().getPid(), new INativeAdvanceLoadListener() { // from class: com.meishu.sdk.platform.oppo.recycler.OPPORecyclerAdLoader.2
            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdFailed(int i, String str) {
                LogUtil.e(OPPORecyclerAdLoader.TAG, "onAdFailed " + str + PPSLabelView.Code + i);
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeAdvanceLoadListener
            public void onAdSuccess(List<INativeAdvanceData> list) {
                ArrayList arrayList = new ArrayList();
                Iterator<INativeAdvanceData> it = list.iterator();
                while (it.hasNext()) {
                    OPPORecyclerAd oPPORecyclerAd = new OPPORecyclerAd(it.next(), OPPORecyclerAdLoader.this);
                    OPPORecyclerAdLoader.this.oppoRecyclerAdList.add(oPPORecyclerAd);
                    arrayList.add(oPPORecyclerAd);
                }
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdLoaded(arrayList);
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdReady(arrayList);
                }
            }
        });
        nativeAdvanceAd.loadAd();
        this.nativeAdvanceAdList.add(nativeAdvanceAd);
    }

    private void loadTemplate() {
        final ArrayList arrayList = new ArrayList();
        NativeTempletAd nativeTempletAd = new NativeTempletAd(getContext(), getSdkAdInfo().getPid(), new NativeAdSize.Builder().setWidthInDp(getAdLoader().getAccept_ad_width().intValue()).setHeightInDp(getAdLoader().getAccept_ad_height().intValue()).build(), new INativeTempletAdListener() { // from class: com.meishu.sdk.platform.oppo.recycler.OPPORecyclerAdLoader.1
            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdClick(INativeTempletAdView iNativeTempletAdView) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    OPPOTemplateRecyclerAd oPPOTemplateRecyclerAd = (OPPOTemplateRecyclerAd) ((RecyclerAdData) it.next());
                    if (oPPOTemplateRecyclerAd.getNativeTemplateAdView() == iNativeTempletAdView) {
                        if (OPPORecyclerAdLoader.this.getSdkAdInfo() != null && !TextUtils.isEmpty(OPPORecyclerAdLoader.this.getSdkAdInfo().getClk())) {
                            LogUtil.d(OPPORecyclerAdLoader.TAG, "send onAdClick");
                            com.meishu.sdk.core.loader.a.a(OPPORecyclerAdLoader.this.getContext(), f.a(OPPORecyclerAdLoader.this.getSdkAdInfo().getClk(), oPPOTemplateRecyclerAd));
                        }
                        if (oPPOTemplateRecyclerAd.getInteractionListener() != null) {
                            oPPOTemplateRecyclerAd.getInteractionListener().onAdClicked();
                        }
                        if (oPPOTemplateRecyclerAd.getRecylcerAdInteractionListener() != null) {
                            oPPOTemplateRecyclerAd.getRecylcerAdInteractionListener().onAdClicked();
                        }
                    }
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdClose(INativeTempletAdView iNativeTempletAdView) {
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdClosed();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdFailed(NativeAdError nativeAdError) {
                LogUtil.e(OPPORecyclerAdLoader.TAG, com.meishu.sdk.activity.a.a("onRenderFailed ").append(nativeAdError.msg).append(PPSLabelView.Code).append(nativeAdError.code).toString());
                z.a(OPPORecyclerAdLoader.this.getSdkAdInfo().getErr(), Integer.valueOf(nativeAdError.code), nativeAdError.msg);
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdShow(INativeTempletAdView iNativeTempletAdView) {
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdExposure();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onAdSuccess(List<INativeTempletAdView> list) {
                Iterator<INativeTempletAdView> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new OPPOTemplateRecyclerAd(it.next()));
                }
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdLoaded(arrayList);
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    OPPOTemplateRecyclerAd oPPOTemplateRecyclerAd = (OPPOTemplateRecyclerAd) ((RecyclerAdData) it2.next());
                    oPPOTemplateRecyclerAd.getNativeTemplateAdView().render();
                    OPPORecyclerAdLoader.this.oppoTemplateRecyclerAdList.add(oPPOTemplateRecyclerAd);
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onRenderFailed(NativeAdError nativeAdError, INativeTempletAdView iNativeTempletAdView) {
                LogUtil.e(OPPORecyclerAdLoader.TAG, com.meishu.sdk.activity.a.a("onRenderFailed ").append(nativeAdError.msg).append(PPSLabelView.Code).append(nativeAdError.code).toString());
                if (OPPORecyclerAdLoader.this.getLoaderListener() != null) {
                    OPPORecyclerAdLoader.this.getLoaderListener().onAdError();
                }
            }

            @Override // com.heytap.msp.mobad.api.listener.INativeTempletAdListener
            public void onRenderSuccess(INativeTempletAdView iNativeTempletAdView) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    OPPOTemplateRecyclerAd oPPOTemplateRecyclerAd = (OPPOTemplateRecyclerAd) ((RecyclerAdData) it.next());
                    if (oPPOTemplateRecyclerAd.getNativeTemplateAdView() == iNativeTempletAdView) {
                        oPPOTemplateRecyclerAd.setAdView(iNativeTempletAdView.getAdView());
                    }
                }
                OPPORecyclerAdLoader.this.getLoaderListener().onAdReady(arrayList);
            }
        });
        nativeTempletAd.loadAd();
        this.nativeTemplateAdList.add(nativeTempletAd);
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        super.destroy();
        Iterator<OPPOTemplateRecyclerAd> it = this.oppoTemplateRecyclerAdList.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.oppoTemplateRecyclerAdList.clear();
        Iterator<NativeTempletAd> it2 = this.nativeTemplateAdList.iterator();
        while (it2.hasNext()) {
            it2.next().destroyAd();
        }
        this.nativeTemplateAdList.clear();
        Iterator<OPPORecyclerAd> it3 = this.oppoRecyclerAdList.iterator();
        while (it3.hasNext()) {
            it3.next().destroy();
        }
        this.oppoRecyclerAdList.clear();
        Iterator<NativeAdvanceAd> it4 = this.nativeAdvanceAdList.iterator();
        while (it4.hasNext()) {
            it4.next().destroyAd();
        }
        this.nativeAdvanceAdList.clear();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        com.meishu.sdk.core.loader.a.a(((RecyclerMixAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()));
        if (((RecyclerMixAdLoader) this.adLoader).getAdPatternType() == 100000) {
            loadTemplate();
        } else {
            loadRecycler();
        }
    }
}
