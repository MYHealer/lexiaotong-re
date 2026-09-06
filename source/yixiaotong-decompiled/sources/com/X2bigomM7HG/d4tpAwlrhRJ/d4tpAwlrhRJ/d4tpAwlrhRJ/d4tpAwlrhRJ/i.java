package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class i extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnifiedInterstitialAD f995a;
    private Function<SparseArray<Object>, Object> b;

    public i(UnifiedInterstitialAD unifiedInterstitialAD) {
        this.f995a = unifiedInterstitialAD;
    }

    private void a(int i) {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.sendWinNotification(i);
        }
    }

    private void b(Map<String, Object> map) {
        int iA;
        if (map == null || this.f995a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f995a.sendLossNotification(0, iA, null);
    }

    private void e() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.destroy();
            this.f995a = null;
        }
    }

    private Map<String, Object> f() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
        if (unifiedInterstitialAD != null) {
            return unifiedInterstitialAD.getExtraInfo();
        }
        return null;
    }

    private void g() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setMediaListener(new UnifiedInterstitialMediaListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.1
                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoComplete() {
                    t.a("onVideoComplete");
                    i.this.c();
                }

                @Override // com.qq.e.ads.interstitial2.UnifiedInterstitialMediaListener
                public void onVideoError(AdError adError) {
                    t.a("onVideoError adError = " + adError);
                    i.this.a(adError);
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
            });
        }
    }

    private void h() {
        UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
        if (unifiedInterstitialAD != null) {
            unifiedInterstitialAD.setRewardListener(new ADRewardListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.i.2
                @Override // com.qq.e.comm.listeners.ADRewardListener
                public void onReward(Map<String, Object> map) {
                    t.a("onReward map = " + map);
                    i.this.a(map);
                }
            });
        }
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void a(AdError adError) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60010);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50006, new h(adError));
            this.b.apply(sparseArray);
        }
    }

    public void a(Map<String, Object> map) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60007);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.b.apply(sparseArray);
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40003) {
            UnifiedInterstitialAD unifiedInterstitialAD = this.f995a;
            int ecpm = unifiedInterstitialAD != null ? unifiedInterstitialAD.getECPM() : -1;
            t.a("getECPM ecpm = " + ecpm);
            return (T) Integer.valueOf(ecpm);
        }
        if (i == 40004) {
            UnifiedInterstitialAD unifiedInterstitialAD2 = this.f995a;
            ?? r3 = unifiedInterstitialAD2 != null ? (T) unifiedInterstitialAD2.getECPMLevel() : (T) "";
            t.a("getECPMLevel level = " + ((String) r3));
            return (T) r3;
        }
        if (i == 40021) {
            UnifiedInterstitialAD unifiedInterstitialAD3 = this.f995a;
            int adPatternType = unifiedInterstitialAD3 != null ? unifiedInterstitialAD3.getAdPatternType() : 0;
            t.a("getAdPatternType adPatternType = " + adPatternType);
            return (T) Integer.valueOf(adPatternType);
        }
        if (i == 40022) {
            t.a("setMediaListener");
            g();
        } else if (i == 40023) {
            t.a("setRewardListener");
            h();
        } else if (i == 40008) {
            Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(50008), Activity.class, null);
            if (this.f995a != null && activity != null) {
                t.a("showFullScreenAD  activity  = " + activity);
                this.f995a.showFullScreenAD(activity);
            }
        } else if (i == 40009) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
        } else {
            if (i == 40010) {
                UnifiedInterstitialAD unifiedInterstitialAD4 = this.f995a;
                T t = (T) Boolean.valueOf(unifiedInterstitialAD4 != null ? unifiedInterstitialAD4.isValid() : false);
                t.a("isValid  flag  = " + t);
                return t;
            }
            if (i == 40011) {
                t.a("onDestroy");
                e();
            } else {
                if (i == 40012) {
                    T t2 = (T) Boolean.valueOf(this.f995a == null);
                    t.a("hasDestroy  flag  = " + t2);
                    return t2;
                }
                if (i == 40013) {
                    int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("sendWinNotification  ecpm  = " + iIntValue);
                    a(iIntValue);
                } else if (i == 40014) {
                    Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null);
                    t.a("sendLossNotification  map  = " + map);
                    b(map);
                } else if (i == 40015) {
                    T t3 = (T) f();
                    t.a("getExtraInfo  map  = " + t3);
                    return t3;
                }
            }
        }
        return null;
    }

    public void b() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60004);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void c() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60005);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
    }

    public void d() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60006);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
