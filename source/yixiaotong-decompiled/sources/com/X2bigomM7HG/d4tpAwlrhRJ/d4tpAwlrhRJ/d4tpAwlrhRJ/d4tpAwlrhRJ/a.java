package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.banner2.UnifiedBannerView;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnifiedBannerView f979a;
    private Function<SparseArray<Object>, Object> b;

    public a(UnifiedBannerView unifiedBannerView) {
        this.f979a = unifiedBannerView;
    }

    private void a(int i) {
        UnifiedBannerView unifiedBannerView = this.f979a;
        if (unifiedBannerView != null) {
            unifiedBannerView.sendWinNotification(i);
        }
    }

    private void a(Map<String, Object> map) {
        int iA;
        if (map == null || this.f979a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f979a.sendLossNotification(0, iA, null);
    }

    private void e() {
        UnifiedBannerView unifiedBannerView = this.f979a;
        if (unifiedBannerView != null) {
            unifiedBannerView.destroy();
        }
    }

    private Map<String, Object> f() {
        UnifiedBannerView unifiedBannerView = this.f979a;
        if (unifiedBannerView != null) {
            return unifiedBannerView.getExtraInfo();
        }
        return null;
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40035) {
            return (T) this.f979a;
        }
        if (i == 40010) {
            UnifiedBannerView unifiedBannerView = this.f979a;
            T t = (T) Boolean.valueOf(unifiedBannerView != null ? unifiedBannerView.isValid() : false);
            t.a("isValid  flag  = " + t);
            return t;
        }
        if (i == 40011) {
            t.a("onDestroy");
            e();
        } else if (i == 40013) {
            int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
            t.a("sendWinNotification  ecpm  = " + iIntValue);
            a(iIntValue);
        } else if (i == 40014) {
            Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null);
            t.a("sendLossNotification  map  = " + map);
            a(map);
        } else if (i == 40009) {
            this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
        } else {
            if (i == 40015) {
                T t2 = (T) f();
                t.a("getExtraInfo  map  = " + t2);
                return t2;
            }
            if (i == 40003) {
                UnifiedBannerView unifiedBannerView2 = this.f979a;
                int ecpm = unifiedBannerView2 != null ? unifiedBannerView2.getECPM() : -1;
                t.a("getECPM ecpm = " + ecpm);
                return (T) Integer.valueOf(ecpm);
            }
            if (i == 40004) {
                UnifiedBannerView unifiedBannerView3 = this.f979a;
                Object obj = unifiedBannerView3 != null ? (T) unifiedBannerView3.getECPMLevel() : (T) "";
                t.a("getECPMLevel level = " + ((String) obj));
                return (T) obj;
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
            sparseArray.put(-99999987, 60006);
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
            sparseArray.put(-99999987, 60012);
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
