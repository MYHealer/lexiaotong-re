package com.h7brb.h7brb.h7brb.h7brb.h7brb;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.KsNativeLoader;
import com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd;
import com.bytedance.msdk.adapter.ks.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends MediationNativeAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private KsFeedAd f3322a;
    private MediationAdSlotValueSet b;
    private boolean c;
    private KsNativeLoader d;
    private WeakReference<Context> e;
    private View f;

    public e(Context context, KsFeedAd ksFeedAd, MediationAdSlotValueSet mediationAdSlotValueSet, Function function, KsNativeLoader ksNativeLoader, boolean z) {
        super(ksNativeLoader, function);
        this.e = new WeakReference<>(context);
        this.f3322a = ksFeedAd;
        this.b = mediationAdSlotValueSet;
        this.d = ksNativeLoader;
        this.c = z;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        notifyRenderFail(null, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context) {
        KsFeedAd ksFeedAd = this.f3322a;
        if (ksFeedAd != null && context != null) {
            this.f = ksFeedAd.getFeedView(context);
        }
        notifyRenderSuccess(-1.0f, -2.0f);
    }

    private void c() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        if (isClientBidding()) {
            sparseArray.put(8016, Double.valueOf(Math.max(this.f3322a.getECPM(), 0.0d)));
        }
        sparseArray.put(8059, Integer.valueOf(p.a(this.f3322a.getInteractionType())));
        sparseArray.put(8033, true);
        notifyNativeValue(sparseArray);
        this.f3322a.setAdInteractionListener(new KsFeedAd.AdInteractionListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.e.1
            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdClicked() {
                e.this.notifyOnClickAd();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onAdShow() {
                e.this.notifyOnShowAd();
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDislikeClicked() {
                e.this.notifyDislikeClick("ks信息流模板dislike接口无关闭原因", new HashMap());
                e.this.notifyDislikeSelect(-1, "ks信息流模板dislike接口无关闭原因");
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsFeedAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        if (this.b != null) {
            KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = new KSAdVideoPlayConfigImpl();
            kSAdVideoPlayConfigImpl.setVideoSoundEnable(!this.b.isMuted());
            this.f3322a.setVideoPlayConfig(kSAdVideoPlayConfigImpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            KsFeedAd ksFeedAd = this.f3322a;
            if (ksFeedAd != null) {
                ksFeedAd.render(new KsFeedAd.AdRenderListener() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.e.2
                    @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                    public void onAdRenderFailed(int i, String str) {
                        e.this.a(i, str);
                    }

                    @Override // com.kwad.sdk.api.KsFeedAd.AdRenderListener
                    public void onAdRenderSuccess(View view) {
                        Context context = (Context) e.this.e.get();
                        if (context == null && view != null) {
                            context = view.getContext();
                        }
                        e.this.a(context);
                    }
                });
            } else {
                a(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "渲染失败");
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (this.f3322a != null) {
                Context context = this.e.get();
                if ((context != null ? this.f3322a.getFeedView(context) : null) != null) {
                    a(context);
                    return;
                }
            }
            a(MediationConstant.ErrorCode.ADN_AD_RENDER_FAIL, "渲染失败");
        }
    }

    private void e() {
        o.b(new Runnable() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.e.3
            @Override // java.lang.Runnable
            public void run() {
                e.this.d();
            }
        });
    }

    private String f() {
        return this.c ? g() : h();
    }

    private String g() {
        try {
            return (String) o.a(new Callable<String>() { // from class: com.h7brb.h7brb.h7brb.h7brb.h7brb.e.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return e.this.h();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h() {
        Object obj;
        try {
            KsFeedAd ksFeedAd = this.f3322a;
            if (ksFeedAd == null || (obj = ksFeedAd.getMediaExtraInfo().get(KSUtil.REQUEST_ID)) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        if (this.c) {
            e();
        } else {
            d();
        }
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 6083) {
            a();
        } else {
            if (i == 6081) {
                return (T) b();
            }
            if (i == 8135) {
                return (T) true;
            }
            if (i == 8147) {
                return (T) f();
            }
            if (i == 8142) {
                if (p.a(this.f3322a)) {
                    Map map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                    MediationApiLog.i("-------ks_bid_win --------- map = " + map);
                    if (map != null) {
                        long jA = p.a((Map<String, Object>) map);
                        long jB = p.b((Map<String, Object>) map);
                        MediationApiLog.i("-------ks_bid_win --------- bidEcpm = " + jA + " loseBidEcpm = " + jB);
                        KsFeedAd ksFeedAd = this.f3322a;
                        if (ksFeedAd != null) {
                            ksFeedAd.setBidEcpm(jA, jB);
                        }
                    }
                }
            } else if (i == 8144 && p.b(this.f3322a)) {
                Map map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                MediationApiLog.i("-------ks_bid_lose --------- map = " + map2);
                if (map2 != null) {
                    int iC = p.c(map2);
                    int iD = p.d(map2);
                    int iE = p.e(map2);
                    String strF = p.f(map2);
                    MediationApiLog.i("-------ks_bid_lose --------- bidEcpm = " + iD + " failureCode = " + iC);
                    if (this.f3322a != null) {
                        AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                        adExposureFailedReason.setWinEcpm(iD);
                        adExposureFailedReason.setAdnType(iE);
                        adExposureFailedReason.setAdnName(strF);
                        this.f3322a.reportAdExposureFailed(iC, adExposureFailedReason);
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public View b() {
        return this.f;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.ks.base.ad.MediationNativeAd, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
