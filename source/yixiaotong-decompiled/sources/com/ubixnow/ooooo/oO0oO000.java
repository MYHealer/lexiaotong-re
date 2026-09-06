package com.ubixnow.ooooo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.IdentityHashMap;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0oO000 {
    private static final int OooO00o = 5;
    private static final String OooO0O0 = "  ";

    private static String OooO00o(int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(OooO0O0);
        }
        return sb.toString();
    }

    public static String OooO00o(Object obj) {
        return OooO00o(obj, 0, new IdentityHashMap());
    }

    private static String OooO00o(Object obj, int i, IdentityHashMap<Object, Boolean> identityHashMap) {
        if (obj == null) {
            return "null";
        }
        if (i > 5) {
            return "[Max Depth Reached]";
        }
        StringBuilder sb = new StringBuilder();
        Class<?> superclass = obj.getClass();
        if (identityHashMap.containsKey(obj)) {
            return "[Circular Reference@" + System.identityHashCode(obj) + "]";
        }
        identityHashMap.put(obj, Boolean.TRUE);
        if (superclass.isArray()) {
            sb.append(superclass.getSimpleName()).append("[\n");
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i + 1;
                sb.append(OooO00o(i3)).append(OooO0O0(Array.get(obj, i2), i3, identityHashMap));
                if (i2 < length - 1) {
                    sb.append(", ");
                }
                sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            }
            sb.append(OooO00o(i)).append("]");
            return sb.toString();
        }
        sb.append(superclass.getSimpleName()).append(" {\n");
        while (superclass != null) {
            for (Field field : superclass.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    try {
                        int i4 = i + 1;
                        sb.append(OooO00o(i4)).append(field.getName()).append(" = ").append(OooO0O0(field.get(obj), i4, identityHashMap)).append(IOUtils.LINE_SEPARATOR_UNIX);
                    } catch (IllegalAccessException unused) {
                        sb.append(OooO00o(i + 1)).append(field.getName()).append(" = [Access Error]\n");
                    }
                }
            }
            superclass = superclass.getSuperclass();
        }
        sb.append(OooO00o(i)).append(com.alipay.sdk.util.i.d);
        return sb.toString();
    }

    private static boolean OooO00o(Class<?> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Boolean.class || cls == Character.class || cls == Byte.class || cls == Short.class;
    }

    private static String OooO0O0(Object obj, int i, IdentityHashMap<Object, Boolean> identityHashMap) {
        if (obj == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (cls.isPrimitive() || OooO00o(cls)) {
            return obj.toString();
        }
        return obj instanceof CharSequence ? "\"" + obj + "\"" : OooO00o(obj, i, new IdentityHashMap(identityHashMap));
    }
}
