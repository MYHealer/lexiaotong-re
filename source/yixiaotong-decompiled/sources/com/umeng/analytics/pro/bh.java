package com.umeng.analytics.pro;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldMetaData.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class bh implements Serializable {
    private static Map<Class<? extends av>, Map<? extends bc, bh>> d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9117a;
    public final byte b;
    public final bi c;

    public bh(String str, byte b, bi biVar) {
        this.f9117a = str;
        this.b = b;
        this.c = biVar;
    }

    public static void a(Class<? extends av> cls, Map<? extends bc, bh> map) {
        d.put(cls, map);
    }

    public static Map<? extends bc, bh> a(Class<? extends av> cls) {
        if (!d.containsKey(cls)) {
            try {
                cls.newInstance();
            } catch (IllegalAccessException e) {
                throw new RuntimeException("IllegalAccessException for TBase class: " + cls.getName() + ", message: " + e.getMessage());
            } catch (InstantiationException e2) {
                throw new RuntimeException("InstantiationException for TBase class: " + cls.getName() + ", message: " + e2.getMessage());
            }
        }
        return d.get(cls);
    }
}
