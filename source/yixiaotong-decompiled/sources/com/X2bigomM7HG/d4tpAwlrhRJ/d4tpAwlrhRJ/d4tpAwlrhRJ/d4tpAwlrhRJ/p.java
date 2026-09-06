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
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class p extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RewardVideoAD f1011a;
    private Function<SparseArray<Object>, Object> b;

    public p(RewardVideoAD rewardVideoAD) {
        this.f1011a = rewardVideoAD;
    }

    private void a(int i) {
        RewardVideoAD rewardVideoAD = this.f1011a;
        if (rewardVideoAD != null) {
            rewardVideoAD.sendWinNotification(i);
        }
    }

    private void b(Map<String, Object> map) {
        int iA;
        if (map == null || this.f1011a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f1011a.sendLossNotification(0, iA, null);
    }

    private void e() {
        if (this.f1011a != null) {
            this.f1011a = null;
        }
    }

    private Map<String, Object> f() {
        RewardVideoAD rewardVideoAD = this.f1011a;
        if (rewardVideoAD != null) {
            return rewardVideoAD.getExtraInfo();
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60002);
            sparseArray.put(-99999985, Void.class);
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

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40003) {
            RewardVideoAD rewardVideoAD = this.f1011a;
            int ecpm = rewardVideoAD != null ? rewardVideoAD.getECPM() : -1;
            t.a("getECPM ecpm = " + ecpm);
            return (T) Integer.valueOf(ecpm);
        }
        if (i == 40007) {
            if (this.f1011a != null) {
                int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                t.a("setBidECPM ecpm = " + iIntValue);
                this.f1011a.setBidECPM(iIntValue);
            }
        } else {
            if (i == 40004) {
                RewardVideoAD rewardVideoAD2 = this.f1011a;
                Object obj = rewardVideoAD2 != null ? (T) rewardVideoAD2.getECPMLevel() : (T) "";
                t.a("getECPMLevel level = " + ((String) obj));
                return (T) obj;
            }
            if (i == 40008) {
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(50008), Activity.class, null);
                if (this.f1011a != null && activity != null) {
                    t.a("showAD  activity  = " + activity);
                    this.f1011a.showAD(activity);
                }
            } else if (i == 40009) {
                this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
            } else {
                if (i == 40010) {
                    RewardVideoAD rewardVideoAD3 = this.f1011a;
                    T t = (T) Boolean.valueOf(rewardVideoAD3 != null ? rewardVideoAD3.isValid() : false);
                    t.a("isValid  flag  = " + t);
                    return t;
                }
                if (i == 40011) {
                    t.a("onDestroy");
                    e();
                } else {
                    if (i == 40012) {
                        T t2 = (T) Boolean.valueOf(this.f1011a == null);
                        t.a("hasDestroy  flag  = " + t2);
                        return t2;
                    }
                    if (i == 40013) {
                        int iIntValue2 = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                        t.a("sendWinNotification  ecpm  = " + iIntValue2);
                        a(iIntValue2);
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
