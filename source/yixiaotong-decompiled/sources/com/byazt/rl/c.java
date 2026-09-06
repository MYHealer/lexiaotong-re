package com.byazt.rl;

import android.util.SparseArray;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 20})
public class c {
    public static final PluginValueSet c = c(0).tt();
    public static final Function<SparseArray<Object>, Object> tt = new C0261c(null);
    public PluginValueSet uj;
    public final SparseArray<Object> ve;

    /* JADX INFO: renamed from: com.byazt.rl.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    private c(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.ve = sparseArray;
        this.uj = pluginValueSet;
    }

    private c(SparseArray<Object> sparseArray) {
        this.ve = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final c c() {
        return new c(new SparseArray());
    }

    public static final c c(int i) {
        return new c(new SparseArray(i));
    }

    public static final c c(SparseArray<Object> sparseArray) {
        return new c(sparseArray);
    }

    public static final c c(PluginValueSet pluginValueSet) {
        return new c(new SparseArray(), pluginValueSet);
    }

    public c c(int i, Object obj) {
        this.ve.put(i, obj);
        return this;
    }

    public c c(int i, String str) {
        this.ve.put(i, str);
        return this;
    }

    public c c(int i, int i2) {
        this.ve.put(i, Integer.valueOf(i2));
        return this;
    }

    public c c(int i, double d) {
        this.ve.put(i, Double.valueOf(d));
        return this;
    }

    public c c(int i, boolean z) {
        this.ve.put(i, Boolean.valueOf(z));
        return this;
    }

    public c c(int i, float f) {
        this.ve.put(i, Float.valueOf(f));
        return this;
    }

    public PluginValueSet tt() {
        return new tt(this.ve, this.uj, null);
    }

    /* JADX INFO: renamed from: com.byazt.rl.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, 44})
    private static final class C0261c<T, R> implements Function<T, R> {
        public /* synthetic */ C0261c(AnonymousClass1 anonymousClass1) {
            this();
        }

        private C0261c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls == Float.TYPE || cls == Float.class) {
                                return (R) Float.valueOf(0.0f);
                            }
                            return null;
                        }
                        return (R) Double.valueOf(0.0d);
                    }
                    return (R) 0L;
                }
                return (R) 0;
            }
            return (R) Boolean.FALSE;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.Drink4GCostControl_1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    private static final class tt implements PluginValueSet {
        public final SparseArray<Object> c;
        public PluginValueSet tt;
        public int ve;

        public /* synthetic */ tt(SparseArray sparseArray, PluginValueSet pluginValueSet, AnonymousClass1 anonymousClass1) {
            this(sparseArray, pluginValueSet);
        }

        private tt(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.ve = -1;
            this.c = sparseArray;
            this.tt = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.c.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.tt;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        private boolean c() {
            return com.byazt.mta.c.c().tt() >= 6803 && com.byazt.mta.c.c().tt() < 7000;
        }

        private boolean c(Object obj) {
            if (c()) {
                return (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true;
            }
            return (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.c.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.tt;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (c(supplier)) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i, int i2) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i, boolean z) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i, long j) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i, float f) {
            PluginValueSet pluginValueSet;
            Object obj = this.c.get(i);
            if (obj == null && (pluginValueSet = this.tt) != null) {
                return pluginValueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i) {
            PluginValueSet pluginValueSet;
            int iIndexOfKey = this.c.indexOfKey(i);
            if (iIndexOfKey >= 0 || (pluginValueSet = this.tt) == null) {
                return iIndexOfKey >= 0;
            }
            return pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.c.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.c.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.tt;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.ve = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.ve < 0) {
                keys();
            }
            return this.ve;
        }

        private boolean tt() {
            if (this.c instanceof com.byazt.mm.c) {
                return true;
            }
            PluginValueSet pluginValueSet = this.tt;
            return pluginValueSet != null && (pluginValueSet.sparseArray() instanceof com.byazt.mm.c);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            if (com.byazt.mta.c.c().tt() < 6803 && tt()) {
                return new com.byazt.mm.c(this);
            }
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.tt;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
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

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.c.remove(i);
        }
    }
}
