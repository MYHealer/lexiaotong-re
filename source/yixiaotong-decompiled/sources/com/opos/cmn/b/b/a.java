package com.opos.cmn.b.b;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Class<?> f5958a;

    public a(Class<?> cls) {
        this.f5958a = cls;
    }

    public Field a(String str) {
        try {
            if (this.f5958a == null || com.opos.cmn.an.d.a.a(str)) {
                return null;
            }
            return this.f5958a.getDeclaredField(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "getDeclareField", e);
            return null;
        }
    }

    public void a(Field field, Object obj, Object obj2) {
        try {
            if (this.f5958a == null || field == null || obj == null) {
                return;
            }
            field.setAccessible(true);
            field.set(obj, obj2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReflectEngine", "setFieldValue", e);
        }
    }
}
