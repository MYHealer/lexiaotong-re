package com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.gdt.GdtRewardLoader;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class l extends MediationBaseAdBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RewardVideoADListener f3246a;
    private RewardVideoAD b;
    private boolean c;
    private final MediationAdSlotValueSet d;
    private final Function e;
    private final GdtRewardLoader f;

    public l(MediationAdSlotValueSet mediationAdSlotValueSet, Function function, GdtRewardLoader gdtRewardLoader) {
        super(mediationAdSlotValueSet, function);
        this.f3246a = new RewardVideoADListener() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.4
            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADClick() {
                if (l.this.e != null) {
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, 8115);
                    sparseArray.put(-99999985, Void.class);
                    l.this.e.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADClose() {
                if (l.this.e != null) {
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, 8116);
                    sparseArray.put(-99999985, Void.class);
                    l.this.e.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            public void onADExpose() {
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADLoad() {
                if (l.this.b == null) {
                    l.this.f.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "load成功但广告为空");
                    return;
                }
                if (l.this.f.isClientBidding()) {
                    l lVar = l.this;
                    lVar.setCpm(lVar.b.getECPM() != -1 ? l.this.b.getECPM() : 0.0d);
                } else if (l.this.f.isMultiBidding()) {
                    l lVar2 = l.this;
                    lVar2.setLevelTag(lVar2.b.getECPMLevel());
                } else {
                    l.this.f.isServerBidding();
                }
                GdtRewardLoader gdtRewardLoader2 = l.this.f;
                l lVar3 = l.this;
                gdtRewardLoader2.notifyAdSuccess(lVar3, lVar3.e);
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onADShow() {
                if (l.this.e != null) {
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, 8230);
                    sparseArray.put(-99999985, Void.class);
                    l.this.e.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onError(AdError adError) {
                if (adError != null) {
                    l.this.f.notifyAdFailed(adError.getErrorCode(), adError.getErrorMsg());
                } else {
                    l.this.f.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "error is null");
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onReward(Map<String, Object> map) {
                if (l.this.e != null) {
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, 8231);
                    sparseArray.put(-99999985, Void.class);
                    sparseArray.put(8017, true);
                    sparseArray.put(8018, Integer.valueOf(l.this.d.getRewardAmount()));
                    sparseArray.put(8019, l.this.d.getRewardName());
                    sparseArray.put(8020, map);
                    l.this.e.apply(sparseArray);
                }
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onVideoCached() {
                l.this.f.notifyAdCache(l.this.e, -1, "");
            }

            @Override // com.qq.e.ads.rewardvideo.RewardVideoADListener
            @JProtect
            public void onVideoComplete() {
                if (l.this.e != null) {
                    SparseArray sparseArray = new SparseArray();
                    sparseArray.put(-99999987, 8118);
                    sparseArray.put(-99999985, Void.class);
                    l.this.e.apply(sparseArray);
                }
            }
        };
        this.d = mediationAdSlotValueSet;
        this.e = function;
        this.f = gdtRewardLoader;
        this.c = a.a(gdtRewardLoader, mediationAdSlotValueSet);
    }

    private Integer a() {
        try {
            Integer num = (Integer) n.a(new Callable<Integer>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Integer call() {
                    return l.this.b();
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

    private void a(Object obj) {
        final int iA = a.a(obj);
        if (iA == -1) {
            return;
        }
        if (this.c) {
            n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.6
                @Override // java.lang.Runnable
                public void run() {
                    l.this.b.sendLossNotification(0, iA, null);
                }
            });
        } else {
            this.b.sendLossNotification(0, iA, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer b() {
        RewardVideoAD rewardVideoAD = this.b;
        return Integer.valueOf((rewardVideoAD == null || !rewardVideoAD.isValid()) ? 4 : 2);
    }

    private void b(final Activity activity) {
        n.b(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.3
            @Override // java.lang.Runnable
            public void run() {
                l.this.c(activity);
            }
        });
    }

    private void b(final Context context) {
        n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.1
            @Override // java.lang.Runnable
            public void run() {
                l.this.c(StubApp.getOrigApplicationContext(context.getApplicationContext()));
                n.a(getClass().getName(), context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        if (this.b != null) {
            if (this.f.isServerBidding()) {
                RewardVideoAD rewardVideoAD = this.b;
                rewardVideoAD.setBidECPM(rewardVideoAD.getECPM());
            }
            this.b.showAD(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JProtect
    public void c(Context context) {
        String strValueOf;
        boolean z = !this.d.isMuted();
        this.b = !TextUtils.isEmpty(this.f.getAdm()) ? new RewardVideoAD(context, this.f.getAdnId(), this.f3246a, z, this.f.getAdm()) : new RewardVideoAD(context, this.f.getAdnId(), this.f3246a, z);
        ServerSideVerificationOptions.Builder builder = new ServerSideVerificationOptions.Builder();
        String userId = this.d.getUserId();
        if (userId != null) {
            builder.setUserId(userId);
        }
        Map<String, Object> extraObject = this.d.getExtraObject();
        if (extraObject == null || extraObject.get(MediationConstant.ADN_GDT) == null) {
            strValueOf = null;
        } else {
            strValueOf = String.valueOf(extraObject.get(MediationConstant.ADN_GDT));
            builder.setCustomData(strValueOf);
        }
        if (userId != null || !TextUtils.isEmpty(strValueOf)) {
            this.b.setServerSideVerificationOptions(builder.build());
        }
        this.b.loadAD();
    }

    private boolean c() {
        return true;
    }

    private String d() {
        return this.c ? e() : f();
    }

    private String e() {
        try {
            return (String) n.a(new Callable<String>() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.7
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String call() {
                    return l.this.f();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        Object obj;
        try {
            RewardVideoAD rewardVideoAD = this.b;
            if (rewardVideoAD == null || (obj = rewardVideoAD.getExtraInfo().get("request_id")) == null) {
                return null;
            }
            return obj.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    @JProtect
    public void a(Activity activity) {
        if (this.c) {
            b(activity);
        } else {
            c(activity);
        }
    }

    public void a(Context context) {
        a.a((Map) this.d.getExtraObject());
        boolean z = this.c;
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (z) {
            b(origApplicationContext);
        } else {
            c(origApplicationContext);
        }
    }

    public void a(Map<String, Object> map) {
        RewardVideoAD rewardVideoAD;
        if (this.f.isClientBidding() && (rewardVideoAD = this.b) != null) {
            try {
                if (this.c) {
                    n.a(new Runnable() { // from class: com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.l.5
                        @Override // java.lang.Runnable
                        public void run() {
                            l.this.b.sendWinNotification((int) l.this.getCpm());
                        }
                    });
                } else {
                    rewardVideoAD.sendWinNotification((int) getCpm());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8113) {
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
            if (i == 8211) {
                return (T) Boolean.valueOf(c());
            }
            if (i == 8142) {
                MediationApiLog.i("GdtReward", "GdtSplashLoader bidWinNotify");
                Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map != null) {
                    a(map);
                }
            } else if (i == 8144) {
                MediationApiLog.i("GdtReward", "GdtSplashLoader bidLoseNotify");
                Map<String, Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                if (map2 != null) {
                    b(map2);
                }
            } else if (i == 8147) {
                return (T) d();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    public void b(Map<String, Object> map) {
        if (!this.f.isClientBidding() || this.b == null || map == null) {
            return;
        }
        try {
            a(map.get(MediationConstant.BIDDING_LOSE_REASON));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public boolean hasDestroyed() {
        return this.b == null;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public Integer isReadyStatus() {
        return this.c ? a() : b();
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.MediationBaseAdBridge
    public void onDestroy() {
        if (this.b != null) {
            this.b = null;
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
