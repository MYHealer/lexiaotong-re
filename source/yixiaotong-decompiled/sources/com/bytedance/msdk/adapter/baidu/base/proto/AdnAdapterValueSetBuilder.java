package com.bytedance.msdk.adapter.baidu.base.proto;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class AdnAdapterValueSetBuilder {
    public static final ValueSet EMPTY = a(0).build();
    public static final Bridge EMPTY_BRIDGE = new EmptyBridge(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SparseArray<Object> f3052a;

    /* JADX INFO: renamed from: com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class EmptyBridge implements Bridge {
        private EmptyBridge() {
        }

        /* synthetic */ EmptyBridge(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                return (T) Boolean.FALSE;
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return (T) new Integer(0);
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return (T) new Long(0L);
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return (T) new Double(0.0d);
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return (T) new Float(0.0f);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return AdnAdapterValueSetBuilder.EMPTY;
        }
    }

    private static final class ValueSetImpl implements ValueSet {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SparseArray<Object> f3053a;
        private int b;

        private ValueSetImpl(SparseArray<Object> sparseArray) {
            this.b = -1;
            this.f3053a = sparseArray;
        }

        /* synthetic */ ValueSetImpl(SparseArray sparseArray, AnonymousClass1 anonymousClass1) {
            this(sparseArray);
        }

        private boolean a(Object obj) {
            return (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.f3053a.get(i);
            if (obj == null) {
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean booleanValue(int i, boolean z) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean containsKey(int i) {
            return this.f3053a.indexOfKey(i) >= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public double doubleValue(int i) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public float floatValue(int i, float f) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int intValue(int i, int i2) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public Set<Integer> keys() {
            int size = this.f3053a.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.f3053a.keyAt(i)));
            }
            this.b = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public long longValue(int i, long j) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Object obj = this.f3053a.get(i);
            if (obj == null) {
                return null;
            }
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            if (cls.isInstance(obj)) {
                return (T) obj;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public void remove(int i) {
            this.f3053a.remove(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public int size() {
            if (this.b < 0) {
                keys();
            }
            return this.b;
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray = this.f3053a;
            return sparseArray != null ? sparseArray : new SparseArray<>();
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.ValueSet
        public String stringValue(int i, String str) {
            Object obj = this.f3053a.get(i);
            if (a(obj)) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }
    }

    private AdnAdapterValueSetBuilder(SparseArray<Object> sparseArray) {
        this.f3052a = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    private static AdnAdapterValueSetBuilder a(int i) {
        return new AdnAdapterValueSetBuilder(new SparseArray(i));
    }

    public static SparseArray<Object> converToSparseArray(Object obj) {
        if (obj instanceof SparseArray) {
            return (SparseArray) obj;
        }
        return obj instanceof ValueSet ? ((ValueSet) obj).sparseArray() : new SparseArray<>();
    }

    public static final AdnAdapterValueSetBuilder create() {
        return new AdnAdapterValueSetBuilder(new SparseArray());
    }

    public static AdnAdapterValueSetBuilder create(SparseArray<Object> sparseArray) {
        return new AdnAdapterValueSetBuilder(sparseArray);
    }

    public AdnAdapterValueSetBuilder add(int i, double d) {
        this.f3052a.put(i, Double.valueOf(d));
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, float f) {
        this.f3052a.put(i, Float.valueOf(f));
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, int i2) {
        this.f3052a.put(i, Integer.valueOf(i2));
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, long j) {
        this.f3052a.put(i, Long.valueOf(j));
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, Object obj) {
        this.f3052a.put(i, obj);
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, String str) {
        this.f3052a.put(i, str);
        return this;
    }

    public AdnAdapterValueSetBuilder add(int i, boolean z) {
        this.f3052a.put(i, Boolean.valueOf(z));
        return this;
    }

    public <T> AdnAdapterValueSetBuilder addArray(int i, T[] tArr) {
        this.f3052a.put(i, tArr);
        return this;
    }

    public ValueSet build() {
        return new ValueSetImpl(this.f3052a, null);
    }
}
