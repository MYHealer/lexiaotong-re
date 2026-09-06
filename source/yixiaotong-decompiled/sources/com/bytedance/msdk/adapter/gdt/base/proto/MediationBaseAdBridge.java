package com.bytedance.msdk.adapter.gdt.base.proto;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.adapter.gdt.base.config.MediationAdSlotValueSet;
import com.umeng.analytics.pro.o;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class MediationBaseAdBridge extends AdnAdapterBaseFunction implements Bridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdSlotValueSet f3075a;
    public Function<SparseArray<Object>, Object> mGMAd;

    public MediationBaseAdBridge(MediationAdSlotValueSet mediationAdSlotValueSet, Function<SparseArray<Object>, Object> function) {
        this.mGMAd = function;
        this.f3075a = mediationAdSlotValueSet;
    }

    @Override // com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBaseFunction
    public SparseArray<Object> get() {
        ValueSet valueSetValues = values();
        if (valueSetValues != null) {
            return valueSetValues.sparseArray();
        }
        return null;
    }

    public double getCpm() {
        Double d;
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8143);
            sparseArray.put(-99999985, Double.class);
            d = (Double) this.mGMAd.apply(sparseArray);
        } else {
            d = null;
        }
        if (d == null) {
            return 0.0d;
        }
        return d.doubleValue();
    }

    public Map<String, Object> getCustomData() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getExtraObject();
        }
        return null;
    }

    public Object getGdtVideoOption() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getGdtVideoOption();
        }
        return null;
    }

    public int getOrientation() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getOrientation();
        }
        return 2;
    }

    public int getRewardAmount() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardAmount();
        }
        return 0;
    }

    public String getRewardName() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getRewardName();
        }
        return null;
    }

    public MediationAdSlotValueSet getSlotValueSet() {
        return this.f3075a;
    }

    public String getUserID() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getUserId();
        }
        return null;
    }

    public float getVolume() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.getVolume();
        }
        return 0.0f;
    }

    public abstract boolean hasDestroyed();

    public boolean isMuted() {
        MediationAdSlotValueSet mediationAdSlotValueSet = this.f3075a;
        if (mediationAdSlotValueSet != null) {
            return mediationAdSlotValueSet.isMuted();
        }
        return false;
    }

    public Integer isReadyStatus() {
        return 1;
    }

    public abstract void onDestroy();

    public void setCpm(double d) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8111);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8016, Double.valueOf(d));
            this.mGMAd.apply(sparseArray);
        }
    }

    public void setCpmLevel(String str) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8207);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8058, str);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void setExpress() {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8129);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8033, true);
            this.mGMAd.apply(sparseArray);
        }
    }

    public void setImageMode(int i) {
        if (this.mGMAd != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(o.a.y));
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(8060, Integer.valueOf(i));
            this.mGMAd.apply(sparseArray);
        }
    }

    public void setLevelTag(String str) {
        if (TextUtils.isEmpty(str) || this.mGMAd == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, Integer.valueOf(o.a.x));
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(8058, str);
        this.mGMAd.apply(sparseArray);
    }

    public void setSlotValueSet(MediationAdSlotValueSet mediationAdSlotValueSet) {
        this.f3075a = mediationAdSlotValueSet;
    }
}
