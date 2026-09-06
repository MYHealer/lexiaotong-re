package com.bytedance.msdk.adapter.gdt.base.config;

import android.util.SparseArray;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class MApiIMediationViewBinderReversal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function<SparseArray<Object>, Object> f3067a;

    public MApiIMediationViewBinderReversal(Function<SparseArray<Object>, Object> function) {
        this.f3067a = function;
    }

    public int getCallToActionId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271024);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getDecriptionTextId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271023);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public Map<String, Integer> getExtras() {
        if (this.f3067a == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 271034);
        sparseArray.put(-99999985, Map.class);
        return (Map) this.f3067a.apply(sparseArray);
    }

    public int getGroupImage1Id() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271029);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getGroupImage2Id() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271030);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getGroupImage3Id() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271031);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getIconImageId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271025);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getLayoutId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271021);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getLogoLayoutId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271032);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getMainImageId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271026);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getMediaViewId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271027);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getShakeViewContainerId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271033);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getSourceId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271028);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int getTitleId() {
        Integer num;
        if (this.f3067a != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 271022);
            sparseArray.put(-99999985, Integer.TYPE);
            num = (Integer) this.f3067a.apply(sparseArray);
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }
}
