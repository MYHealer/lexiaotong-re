package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.content.Context;
import android.util.SparseArray;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.model.NativeAdExtraData;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3372a;

    private void a(final Context context, KsScene ksScene, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadConfigFeedAd(ksScene, new KsLoadManager.FeedAdListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.l.2
                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public void onError(int i, String str) {
                    ksNativeLoader.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.FeedAdListener
                public void onFeedAdLoad(List<KsFeedAd> list) {
                    if (list == null || list.isEmpty()) {
                        ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "返回广告位列表空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (KsFeedAd ksFeedAd : list) {
                        if (ksFeedAd != null) {
                            Function<SparseArray<Object>, Object> gMBridge = ksNativeLoader.getGMBridge();
                            new e(context, ksFeedAd, mediationAdSlotValueSet, gMBridge, ksNativeLoader, l.this.f3372a);
                            arrayList.add(gMBridge);
                        }
                    }
                    ksNativeLoader.notifyAdSuccess(arrayList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context, MediationAdSlotValueSet mediationAdSlotValueSet, KsNativeLoader ksNativeLoader) {
        try {
            KsScene.Builder builderAdNum = new KsScene.Builder(Long.valueOf(mediationAdSlotValueSet.getADNId()).longValue()).adNum(mediationAdSlotValueSet.getAdCount());
            f.a(builderAdNum, mediationAdSlotValueSet, "NATIVE");
            if (context != null) {
                int iA = p.a(context);
                if (mediationAdSlotValueSet.getWidth() != 0) {
                    iA = mediationAdSlotValueSet.getWidth();
                } else if (mediationAdSlotValueSet.getExpressWidth() != 0.0f) {
                    iA = (int) p.a(context, mediationAdSlotValueSet.getExpressWidth());
                }
                builderAdNum = builderAdNum.width(iA);
            }
            if (mediationAdSlotValueSet.isExpress()) {
                a(context, builderAdNum.build(), mediationAdSlotValueSet, ksNativeLoader);
                return;
            }
            Map<String, Object> extraObject = mediationAdSlotValueSet.getExtraObject();
            if (extraObject != null) {
                Object obj = extraObject.get(MediationConstant.GM_EXTRA_KEY_KS_ENABLE_ROTATE);
                if (obj instanceof Boolean) {
                    try {
                        builderAdNum.setNativeAdExtraData(new NativeAdExtraData().setEnableRotate(((Boolean) obj).booleanValue()));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            b(context, builderAdNum.build(), mediationAdSlotValueSet, ksNativeLoader);
        } catch (Exception unused) {
            ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "代码位不合法");
        }
    }

    private void b(final Context context, KsScene ksScene, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        KsLoadManager loadManager = KsAdSDK.getLoadManager();
        if (loadManager != null) {
            loadManager.loadNativeAd(ksScene, new KsLoadManager.NativeAdListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.l.3
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i, String str) {
                    ksNativeLoader.notifyAdFailed(i, str);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(List<KsNativeAd> list) {
                    if (list == null || list.isEmpty()) {
                        ksNativeLoader.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "返回广告位列表空");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (KsNativeAd ksNativeAd : list) {
                        Function<SparseArray<Object>, Object> gMBridge = ksNativeLoader.getGMBridge();
                        new d(context, ksNativeAd, mediationAdSlotValueSet, gMBridge, ksNativeLoader, l.this.f3372a);
                        arrayList.add(gMBridge);
                    }
                    ksNativeLoader.notifyAdSuccess(arrayList);
                }
            });
        }
    }

    public void a(final Context context, final MediationAdSlotValueSet mediationAdSlotValueSet, final KsNativeLoader ksNativeLoader) {
        boolean zA = p.a(ksNativeLoader, mediationAdSlotValueSet);
        this.f3372a = zA;
        if (zA) {
            o.a(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.l.1
                @Override // java.lang.Runnable
                public void run() {
                    l.this.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), mediationAdSlotValueSet, ksNativeLoader);
                    o.a(getClass().getName(), StubApp.getOrigApplicationContext(context.getApplicationContext()));
                }
            });
        } else {
            b(StubApp.getOrigApplicationContext(context.getApplicationContext()), mediationAdSlotValueSet, ksNativeLoader);
        }
    }
}
