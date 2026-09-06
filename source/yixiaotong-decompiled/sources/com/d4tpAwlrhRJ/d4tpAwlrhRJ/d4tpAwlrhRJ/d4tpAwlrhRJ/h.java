package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtFullVideoLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class h extends MediationBaseAdBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    UnifiedInterstitialADListener f3214a;
    UnifiedInterstitialMediaListener b;
    ADRewardListener c;
    private final String d;
    private UnifiedInterstitialAD e;
    private final GdtFullVideoLoader f;
    private final MediationAdSlotValueSet g;
    private boolean h;

    public h(MediationAdSlotValueSet mediationAdSlotValueSet, Function function, GdtFullVideoLoader gdtFullVideoLoader) {
        super(mediationAdSlotValueSet, function);
        this.d = "TMe";
        this.f3214a = new UnifiedInterstitialADListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.6
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClicked() {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onADClicked");
                if (h.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1009);
                    sparseArray.put(-99999985, Void.class);
                    h.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADClosed() {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onADClosed");
                if (h.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1014);
                    sparseArray.put(-99999985, Void.class);
                    h.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADExposure() {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onADExposure");
                if (h.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1008);
                    sparseArray.put(-99999985, Void.class);
                    h.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADLeftApplication() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onADOpened() {
            }

            /* JADX WARN: Code duplicated, block: B:15:0x0089  */
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onADReceive() {
                StringBuilder sbAppend;
                MediationApiLog.i("TMe", "GdtFullVideoLoader onADReceive");
                if (!h.this.f.isClientBidding()) {
                    if (h.this.f.isMultiBidding()) {
                        h hVar = h.this;
                        hVar.setLevelTag(hVar.e.getECPMLevel());
                        sbAppend = new StringBuilder("GdtFullVideoLoader GDT_多阶底价 FullVideo 返回的价格标签：").append(h.this.e.getECPMLevel());
                    }
                    if (h.this.e.getAdPatternType() == 2) {
                        h.this.setImageMode(5);
                        h.this.e.setMediaListener(h.this.b);
                        h.this.e.setRewardListener(h.this.c);
                    }
                    GdtFullVideoLoader gdtFullVideoLoader2 = h.this.f;
                    h hVar2 = h.this;
                    gdtFullVideoLoader2.notifyAdSuccess(hVar2, hVar2.mGMAd);
                }
                h hVar3 = h.this;
                hVar3.setCpm(hVar3.e.getECPM() != -1 ? h.this.e.getECPM() : 0.0d);
                sbAppend = new StringBuilder("GdtFullVideoLoader GDT_clientBidding FullVideo 返回的 cpm价格：").append(h.this.e.getECPM());
                MediationApiLog.i("TMe", sbAppend.toString());
                if (h.this.e.getAdPatternType() == 2) {
                    h.this.setImageMode(5);
                    h.this.e.setMediaListener(h.this.b);
                    h.this.e.setRewardListener(h.this.c);
                }
                GdtFullVideoLoader gdtFullVideoLoader3 = h.this.f;
                h hVar4 = h.this;
                gdtFullVideoLoader3.notifyAdSuccess(hVar4, hVar4.mGMAd);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onNoAD(AdError adError) {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onNoAD");
                if (adError != null) {
                    h.this.f.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    h.this.f.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "暂无广告");
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderFail() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            public void onRenderSuccess() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialADListener
            @JProtect
            public void onVideoCached() {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoCached");
                h.this.f.notifyAdCache(h.this.mGMAd, -1, "");
            }
        };
        this.b = new UnifiedInterstitialMediaListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.7
            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            @JProtect
            public void onVideoComplete() {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoComplete");
                if (h.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, Integer.valueOf(AnalyticsListener.EVENT_DRM_KEYS_REMOVED));
                    sparseArray.put(-99999985, Void.class);
                    h.this.mGMAd.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            @JProtect
            public void onVideoError(AdError adError) {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onVideoError");
                if (h.this.mGMAd == null || adError == null) {
                    return;
                }
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 1021);
                sparseArray.put(-99999985, Void.class);
                sparseArray.put(8015, adError.getErrorMsg());
                sparseArray.put(8014, Integer.valueOf(adError.getErrorCode()));
                h.this.mGMAd.apply(sparseArray);
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageClose() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPageOpen() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoReady(long j) {
            }

            @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
            public void onVideoStart() {
            }
        };
        this.c = new ADRewardListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.8
            @Override // com.qq.e.comm.listeners.ADRewardListener
            public void onReward(Map<String, Object> map) {
                MediationApiLog.i("TMe", "GdtFullVideoLoader onRewardVerify");
                if (h.this.mGMAd != null) {
                    SparseArray<Object> sparseArray = new SparseArray<>();
                    sparseArray.put(-99999987, 1018);
                    sparseArray.put(-99999985, Void.class);
                    sparseArray.put(8017, true);
                    sparseArray.put(8018, Integer.valueOf(h.this.getRewardAmount()));
                    sparseArray.put(8019, h.this.getRewardName());
                    h.this.mGMAd.apply(sparseArray);
                }
            }
        };
        this.f = gdtFullVideoLoader;
        this.g = mediationAdSlotValueSet;
        this.h = a.a(gdtFullVideoLoader, mediationAdSlotValueSet);
    }

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.h) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.10
                @Override // java.lang.Runnable
                public void run() {
                    h.this.e.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.e.sendLossNotification(0, iA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void b(Activity activity) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.e;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.showFullScreenAD(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void b(Context context) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        VideoOption videoOptionBuild;
        String str;
        if (context instanceof Activity) {
            this.e = new UnifiedInterstitialAD((Activity) context, this.f.getAdnId(), this.f3214a);
            if (getGdtVideoOption() instanceof VideoOption) {
                unifiedInterstitialAD = this.e;
                videoOptionBuild = (VideoOption) getGdtVideoOption();
            } else {
                unifiedInterstitialAD = this.e;
                videoOptionBuild = new VideoOption.Builder().build();
            }
            unifiedInterstitialAD.setVideoOption(videoOptionBuild);
            if (this.g.getGdtMaxVideoDuration() > 0) {
                this.e.setMaxVideoDuration(this.g.getGdtMaxVideoDuration());
            }
            if (this.g.getGdtMinVideoDuration() > 0) {
                this.e.setMinVideoDuration(this.g.getGdtMinVideoDuration());
            }
            ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
            String userID = getUserID();
            if (userID != null) {
                builder.setUserId(userID);
            }
            Map<String, Object> customData = getCustomData();
            if (customData != null && (customData.get(MediationConstant.ADN_GDT) instanceof String) && (str = (String) customData.get(MediationConstant.ADN_GDT)) != null) {
                builder.setCustomData(str);
            }
            if (userID != null || customData != null) {
                this.e.setServerSideVerificationOptions(builder.build());
            }
            this.e.loadFullScreenAD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer c() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.e;
        return Integer.valueOf((unifiedInterstitialAD == null || !unifiedInterstitialAD.isValid()) ? 4 : 2);
    }

    private void c(final Activity activity) {
        n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.3
            @Override // java.lang.Runnable
            public void run() {
                h.this.b(activity);
            }
        });
    }

    private void c(final Context context) {
        n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.1
            @Override // java.lang.Runnable
            public void run() {
                h.this.b(context);
                n.a(getClass().getName(), context);
            }
        });
    }

    private Integer d() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.4
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return h.this.c();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e) {
            e.printStackTrace();
            return 4;
        }
    }

    private String e() {
        return this.h ? f() : g();
    }

    private String f() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return h.this.g();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g() {
        Object obj;
        try {
            UnifiedInterstitialAD unifiedInterstitialAD = this.e;
            if (unifiedInterstitialAD == null || (obj = unifiedInterstitialAD.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void a() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.e;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.e = null;
        }
    }

    public void a(Activity activity) {
        if (this.h) {
            c(activity);
        } else {
            b(activity);
        }
    }

    public void a(Context context) {
        a.a((Map) this.g.getExtraObject());
        if (this.h) {
            c(context);
        } else {
            b(context);
        }
    }

    public void a(Map<String, Object> map) {
        UnifiedInterstitialAD unifiedInterstitialAD;
        if (this.f.isClientBidding() && (unifiedInterstitialAD = this.e) != null) {
            try {
                if (this.h) {
                    n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.9
                        @Override // java.lang.Runnable
                        public void run() {
                            h.this.e.sendWinNotification((int) h.this.getCpm());
                        }
                    });
                } else {
                    unifiedInterstitialAD.sendWinNotification((int) getCpm());
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8211) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader METHOD_ADN_HAS_AD_VIDEO_CACHED_API");
            return (T) true;
        }
        if (i == 8142) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader bidWinNotify");
            Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
            if (map != null) {
                a(map);
            }
        } else if (i == 8144) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader bidLoseNotify");
            Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
            if (map2 != null) {
                b(map2);
            }
        } else if (i == 8113) {
            MediationApiLog.i("TMe", "GdtFullVideoLoader showAd");
            Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
            if (activity != null) {
                a(activity);
            }
        } else if (i == 8109) {
            onDestroy();
        } else {
            if (i == 8120) {
                return (T) Boolean.valueOf(hasDestroyed());
            }
            if (i == 8121) {
                return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
            }
            if (i == 8147) {
                return (T) e();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public void b() {
        n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.h.5
            @Override // java.lang.Runnable
            public void run() {
                h.this.a();
            }
        });
    }

    public void b(Map<String, Object> map) {
        if (!this.f.isClientBidding() || this.e == null || map == null) {
            return;
        }
        try {
            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
        } catch (Throwable unused) {
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public boolean hasDestroyed() {
        return this.e == null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public Integer isReadyStatus() {
        return this.h ? d() : c();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public void onDestroy() {
        if (this.h) {
            b();
        } else {
            a();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
