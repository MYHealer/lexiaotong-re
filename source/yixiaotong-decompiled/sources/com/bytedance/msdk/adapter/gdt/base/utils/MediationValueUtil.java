package com.bytedance.msdk.adapter.gdt.base.utils;

import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class MediationValueUtil {
    public static <T> T checkClassType(Class<T> cls) {
        if (cls == Boolean.class || cls == Boolean.TYPE) {
            return (T) false;
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return (T) 0;
        }
        if (cls == Long.class || cls == Long.TYPE) {
            return (T) 0L;
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return (T) Float.valueOf(0.0f);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return (T) Double.valueOf(0.0d);
        }
        return null;
    }

    public static <T> T objectValue(Object obj, Class<T> cls, T t) {
        if (obj instanceof ValueSet.ValueGetter) {
            obj = ((ValueSet.ValueGetter) obj).get();
        } else if ((obj instanceof Supplier) && !(obj instanceof Function) && !(obj instanceof ValueSet)) {
            obj = ((Supplier) obj).get();
        }
        return cls.isInstance(obj) ? (T) obj : t;
    }
}
