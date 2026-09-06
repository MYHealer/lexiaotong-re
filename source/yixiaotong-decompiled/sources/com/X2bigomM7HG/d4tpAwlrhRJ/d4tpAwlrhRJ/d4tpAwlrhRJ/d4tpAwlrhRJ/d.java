package com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.ads.nativ.NativeExpressMediaListener;
import com.qq.e.comm.pi.AdData;
import com.qq.e.comm.util.AdError;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressADView f987a;
    private Function<SparseArray<Object>, Object> b;
    private volatile boolean c = false;

    public d(NativeExpressADView nativeExpressADView) {
        this.f987a = nativeExpressADView;
    }

    private void a(int i) {
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView != null) {
            nativeExpressADView.sendWinNotification(i);
        }
    }

    private void a(Map<String, Object> map) {
        int iA;
        if (map == null || this.f987a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f987a.sendLossNotification(0, iA, null);
    }

    private int e() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) {
            return 4;
        }
        return boundData.getAdPatternType();
    }

    private String f() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f987a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getTitle();
    }

    private String g() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f987a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getDesc();
    }

    private int h() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) {
            return 0;
        }
        return boundData.getECPM();
    }

    private String i() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f987a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getECPMLevel();
    }

    private void j() {
        this.c = true;
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    private Map<String, Object> k() {
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView != null) {
            return nativeExpressADView.getExtraInfo();
        }
        return null;
    }

    private void l() {
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    private void m() {
        NativeExpressADView nativeExpressADView = this.f987a;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d.1
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoInit(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoLoading(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageClose(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPageOpen(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoPause(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoReady(NativeExpressADView nativeExpressADView2, long j) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoStart(NativeExpressADView nativeExpressADView2) {
                }
            });
        }
    }

    public void a() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60012);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v27, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v28, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v32, types: [T, java.lang.String] */
    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 40003) {
            int iH = h();
            t.a("getECPM ecpm = " + iH);
            return (T) Integer.valueOf(iH);
        }
        if (i == 40004) {
            ?? r4 = (T) i();
            t.a("getECPMLevel level = " + ((String) r4));
            return r4;
        }
        if (i == 40021) {
            int iE = e();
            t.a("getAdPatternType adPatternType = " + iE);
            return (T) Integer.valueOf(iE);
        }
        if (i == 40022) {
            t.a("setMediaListener");
            m();
        } else {
            if (i == 40032) {
                ?? r5 = (T) f();
                t.a("getTitle title = " + ((String) r5));
                return r5;
            }
            if (i == 40033) {
                ?? r6 = (T) g();
                t.a("desc title = " + ((String) r6));
                return r6;
            }
            if (i == 40034) {
                t.a("render");
                l();
            } else if (i == 40007) {
                if (this.f987a != null) {
                    int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("setBidECPM ecpm = " + iIntValue);
                    this.f987a.setBidECPM(iIntValue);
                }
            } else {
                if (i == 40035) {
                    t.a("ad view = " + this.f987a);
                    return (T) this.f987a;
                }
                if (i == 40011) {
                    t.a("onDestroy");
                    j();
                } else {
                    if (i == 40012) {
                        T t = (T) Boolean.valueOf(this.c);
                        t.a("hasDestroy  flag  = " + t);
                        return t;
                    }
                    if (i == 40013) {
                        int iIntValue2 = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                        t.a("sendWinNotification  ecpm  = " + iIntValue2);
                        a(iIntValue2);
                    } else if (i == 40014) {
                        Map<String, Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(50010), Map.class, null);
                        t.a("sendLossNotification  map  = " + map);
                        a(map);
                    } else if (i == 40009) {
                        this.b = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(50009), Object.class, null));
                    } else if (i == 40015) {
                        T t2 = (T) k();
                        t.a("getExtraInfo  map  = " + t2);
                        return t2;
                    }
                }
            }
        }
        return null;
    }

    public void b() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void c() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60004);
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
