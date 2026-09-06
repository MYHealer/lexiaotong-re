package com.byazt.rl;

import android.util.SparseArray;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 54})
public class ve {
    public static final ValueSet c = c(0).tt();
    public static final Bridge tt;
    public static final Function<SparseArray<Object>, Object> ve;
    public ValueSet n;
    public final SparseArray<Object> uj;

    /* JADX INFO: renamed from: com.byazt.rl.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    static {
        AnonymousClass1 anonymousClass1 = null;
        tt = new c(anonymousClass1);
        ve = new tt(anonymousClass1);
    }

    private ve(SparseArray<Object> sparseArray) {
        this.uj = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final ve c() {
        return new ve(new SparseArray());
    }

    public static final ve c(int i) {
        return new ve(new SparseArray(i));
    }

    public static final ve c(SparseArray<Object> sparseArray) {
        return new ve(sparseArray);
    }

    public ve c(int i, Object obj) {
        this.uj.put(i, obj);
        return this;
    }

    public ve c(int i, String str) {
        this.uj.put(i, str);
        return this;
    }

    public ve c(int i, int i2) {
        this.uj.put(i, Integer.valueOf(i2));
        return this;
    }

    public ve c(int i, double d) {
        this.uj.put(i, Double.valueOf(d));
        return this;
    }

    public ve c(int i, boolean z) {
        this.uj.put(i, Boolean.valueOf(z));
        return this;
    }

    public ve c(int i, long j) {
        this.uj.put(i, Long.valueOf(j));
        return this;
    }

    public ve c(int i, float f) {
        this.uj.put(i, Float.valueOf(f));
        return this;
    }

    public ValueSet tt() {
        return new C0262ve(this.uj, this.n, null);
    }

    /* JADX INFO: renamed from: com.byazt.rl.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 917})
    private static final class C0262ve implements ValueSet {
        public final SparseArray<Object> c;
        public ValueSet tt;
        public int ve;

        public /* synthetic */ C0262ve(SparseArray sparseArray, ValueSet valueSet, AnonymousClass1 anonymousClass1) {
            this(sparseArray, valueSet);
        }

        private C0262ve(SparseArray<Object> sparseArray, ValueSet valueSet) {
            this.ve = -1;
            this.c = sparseArray;
            this.tt = valueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.c.get(i);
            if (obj == null) {
                ValueSet valueSet = this.tt;
                if (valueSet != null) {
                    return (T[]) valueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.c.get(i);
            if (supplier == null) {
                ValueSet valueSet = this.tt;
                if (valueSet != null) {
                    return (T) valueSet.objectValue(i, cls);
                }
                return null;
            }
            if (supplier instanceof Supplier) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            ValueSet valueSet;
            Object obj = this.c.get(i);
            if (obj == null && (valueSet = this.tt) != null) {
                return valueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            ValueSet valueSet;
            int iIndexOfKey = this.c.indexOfKey(i);
            if (iIndexOfKey >= 0 || (valueSet = this.tt) == null) {
                return iIndexOfKey >= 0;
            }
            return valueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.c.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.c.keyAt(i)));
            }
            ValueSet valueSet = this.tt;
            if (valueSet != null) {
                hashSet.addAll(valueSet.keys());
            }
            this.ve = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.ve < 0) {
                keys();
            }
            return this.ve;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            ValueSet valueSet = this.tt;
            if (valueSet != null && (sparseArray = valueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.c;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    sparseArray2.put(this.c.keyAt(i2), this.c.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.c.remove(i);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 24})
    private static final class c implements Bridge {
        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return ve.c;
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) Float.valueOf(0.0f);
            }
            return null;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    private static final class tt<T, R> implements Function<T, R> {
        private tt() {
        }

        public /* synthetic */ tt(AnonymousClass1 anonymousClass1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (R) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (R) 0;
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (R) 0L;
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (R) Double.valueOf(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (R) Float.valueOf(0.0f);
            }
            return null;
        }
    }
}
