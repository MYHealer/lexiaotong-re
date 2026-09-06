package com.bytedance.msdk.adapter.ks.base.ad;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.ks.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction;
import com.umeng.analytics.pro.o;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class MediationNativeAd extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdLoaderBaseFunction f3078a;
    public Function<SparseArray<Object>, Object> mGMAd;

    public MediationNativeAd(MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction, Function<SparseArray<Object>, Object> function) {
        this.f3078a = mediationAdLoaderBaseFunction;
        this.mGMAd = function;
        a();
    }

    private void a() {
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8128);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(8035, this);
        this.mGMAd.apply(sparseArray);
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        return null;
    }

    @Override // com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    public String getAdm() {
        MediationAdLoaderBaseFunction mediationAdLoaderBaseFunction = this.f3078a;
        return mediationAdLoaderBaseFunction != null ? mediationAdLoaderBaseFunction.getAdm() : "";
    }

    public double getCpm() {
        if (this.mGMAd == null) {
            return 0.0d;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8143);
        sparseArray.put(-99999985, Double.class);
        Double d = (Double) this.mGMAd.apply(sparseArray);
        if (d != null) {
            return d.doubleValue();
        }
        return 0.0d;
    }

    public int getImageMode() {
        if (this.mGMAd == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 6069);
        sparseArray.put(-99999985, Integer.class);
        Integer num = (Integer) this.mGMAd.apply(sparseArray);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public boolean isClientBidding() {
        return this.f3078a.isClientBidding();
    }

    public boolean isExpress() {
        if (this.mGMAd == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(o.a.s));
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGMAd.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isMultiBidding() {
        return this.f3078a.isMultiBidding();
    }

    public boolean isServerBidding() {
        return this.f3078a.isServerBidding();
    }

    public boolean isUseCustomVideo() {
        if (this.mGMAd == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8160);
        sparseArray.put(-99999985, Boolean.class);
        Boolean bool = (Boolean) this.mGMAd.apply(sparseArray);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public void notifyDislikeClick(String str, Map map) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8131);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8036, str);
            sparseArray.put(8037, map);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyDislikeOnCancel() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8184);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyDislikeOnShow() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8185);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyDislikeSelect(int i, String str) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8132);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8038, Integer.valueOf(i));
            sparseArray.put(8039, str);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyNativeValue(SparseArray<Object> sparseArray) {
        if (this.mGMAd != null) {
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
            }
            sparseArray.put(-99999987, 8140);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnClickAd() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8130);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8157);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnDownloadFinished(long j, String str, String str2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8155);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnDownloadPause(long j, long j2, String str, String str2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8158);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnDownloadStarted() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8153);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnIdel() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8152);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnInstalled(String str, String str2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8156);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8066, str);
            sparseArray.put(8056, str2);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnProgressUpdate(long j, long j2, int i, int i2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8187);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8062, Long.valueOf(j));
            sparseArray.put(8063, Long.valueOf(j2));
            sparseArray.put(8064, Integer.valueOf(i));
            sparseArray.put(8065, Integer.valueOf(i2));
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnShowAd() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8113);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnVideoComplete() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8118);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnVideoError(int i, String str) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8117);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnVideoPause() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8146);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnVideoResume() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8150);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyOnVideoStart() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8145);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyRenderFail(View view, int i, String str) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8134);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8042, view);
            sparseArray.put(8014, Integer.valueOf(i));
            sparseArray.put(8015, str);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void notifyRenderSuccess(float f, float f2) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8133);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8040, Float.valueOf(f));
            sparseArray.put(8041, Float.valueOf(f2));
            this.mGMAd.apply(sparseArray);
        }
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void shakeViewDismissed() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8197);
            sparseArray.put(-99999985, Void.class);
            this.mGMAd.apply(sparseArray);
        }
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
