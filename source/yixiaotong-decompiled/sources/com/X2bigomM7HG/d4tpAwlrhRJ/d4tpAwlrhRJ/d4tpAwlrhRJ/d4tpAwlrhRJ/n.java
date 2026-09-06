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
public class n extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeExpressADView f1006a;
    private Function<SparseArray<Object>, Object> b;
    private volatile boolean c = false;
    private o d;

    public n(o oVar, NativeExpressADView nativeExpressADView) {
        this.d = oVar;
        this.f1006a = nativeExpressADView;
    }

    private void a(int i) {
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView != null) {
            nativeExpressADView.sendWinNotification(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdError adError) {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60010);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50006, new h(adError));
            this.b.apply(sparseArray);
        }
    }

    private void a(Map<String, Object> map) {
        int iA;
        if (map == null || this.f1006a == null || (iA = com.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.a.a(map.get(MediationConstant.BIDDING_LOSE_REASON))) <= 0) {
            return;
        }
        this.f1006a.sendLossNotification(0, iA, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60005);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    private int g() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) {
            return 4;
        }
        return boundData.getAdPatternType();
    }

    private String h() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1006a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getTitle();
    }

    private String i() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1006a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getDesc();
    }

    private int j() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) {
            return 0;
        }
        return boundData.getECPM();
    }

    private String k() {
        AdData boundData;
        NativeExpressADView nativeExpressADView = this.f1006a;
        return (nativeExpressADView == null || (boundData = nativeExpressADView.getBoundData()) == null) ? "" : boundData.getECPMLevel();
    }

    private void l() {
        this.c = true;
        o oVar = this.d;
        if (oVar != null) {
            oVar.a(this.f1006a);
        }
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView != null) {
            nativeExpressADView.destroy();
        }
    }

    private Map<String, Object> m() {
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView != null) {
            return nativeExpressADView.getExtraInfo();
        }
        return null;
    }

    private void n() {
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView != null) {
            nativeExpressADView.render();
        }
    }

    private void o() {
        NativeExpressADView nativeExpressADView = this.f1006a;
        if (nativeExpressADView != null) {
            nativeExpressADView.setMediaListener(new NativeExpressMediaListener() { // from class: com.X2bigomM7HG.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.d4tpAwlrhRJ.n.1
                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoCached(NativeExpressADView nativeExpressADView2) {
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoComplete(NativeExpressADView nativeExpressADView2) {
                    t.a("onVideoComplete nativeExpressADView = " + nativeExpressADView2);
                    n.this.f();
                }

                @Override // com.qq.e.ads.nativ.NativeExpressMediaListener
                public void onVideoError(NativeExpressADView nativeExpressADView2, AdError adError) {
                    t.a("onVideoError nativeExpressADView = " + nativeExpressADView2 + " adError = " + adError);
                    n.this.a(adError);
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
            sparseArray.put(-99999987, 60016);
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
            int iJ = j();
            t.a("getECPM ecpm = " + iJ);
            return (T) Integer.valueOf(iJ);
        }
        if (i == 40004) {
            ?? r4 = (T) k();
            t.a("getECPMLevel level = " + ((String) r4));
            return r4;
        }
        if (i == 40021) {
            int iG = g();
            t.a("getAdPatternType adPatternType = " + iG);
            return (T) Integer.valueOf(iG);
        }
        if (i == 40022) {
            t.a("setMediaListener");
            o();
        } else {
            if (i == 40032) {
                ?? r5 = (T) h();
                t.a("getTitle title = " + ((String) r5));
                return r5;
            }
            if (i == 40033) {
                ?? r6 = (T) i();
                t.a("desc title = " + ((String) r6));
                return r6;
            }
            if (i == 40034) {
                t.a("render");
                n();
            } else if (i == 40007) {
                if (this.f1006a != null) {
                    int iIntValue = ((Integer) MediationValueUtil.objectValue(sparseArray.get(50007), Integer.class, 0)).intValue();
                    t.a("setBidECPM ecpm = " + iIntValue);
                    this.f1006a.setBidECPM(iIntValue);
                }
            } else {
                if (i == 40035) {
                    t.a("ad view = " + this.f1006a);
                    return (T) this.f1006a;
                }
                if (i == 40011) {
                    t.a("onDestroy");
                    l();
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
                        T t2 = (T) m();
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
            sparseArray.put(-99999987, 60017);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50014, -1);
            sparseArray.put(50016, -2);
            this.b.apply(sparseArray);
        }
    }

    public void c() {
        if (this.b != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 60009);
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
            sparseArray.put(-99999987, 60004);
            sparseArray.put(-99999985, Void.class);
            this.b.apply(sparseArray);
        }
    }

    public void e() {
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
