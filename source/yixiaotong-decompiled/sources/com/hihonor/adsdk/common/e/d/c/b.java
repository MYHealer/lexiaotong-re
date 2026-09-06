package com.hihonor.adsdk.common.e.d.c;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsa = "HwReflectUtil";
    public static final String hnadsb = "com.hihonor.adsdk.common.uikit.hncompatibletools.utils.NameConstants";

    private b() {
    }

    public static void hnadsa(String str, Object obj, Object obj2, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set object, IllegalAccessException in reflect " + str, new Object[0]);
        } catch (IllegalArgumentException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set object, IllegalArgumentException in reflect " + str, new Object[0]);
        } catch (NoSuchFieldException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set object, No field in reflect " + str, new Object[0]);
        } catch (SecurityException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set object, SecurityException in reflect " + str, new Object[0]);
        }
    }

    public static Method hnadsb(String str, Class[] clsArr, String str2) {
        try {
            return hnadsa(str, clsArr, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "ClassNotFoundException in reflect call " + str, new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Object obj, String str, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In get object, IllegalAccessException in reflect " + str, new Object[0]);
            return null;
        } catch (NoSuchFieldException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In get object, No field in reflect " + str, new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Object obj, String str, String str2) {
        try {
            return hnadsa(obj, str, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "ClassNotFoundException in reflect call " + str + "in class " + str2, new Object[0]);
            return null;
        }
    }

    public static int hnadsa(Object obj, String str, Class<?> cls, int i) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.getInt(obj);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In get int, IllegalAccessException in reflect " + str, new Object[0]);
            return i;
        } catch (NoSuchFieldException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In get int, No field in reflect " + str, new Object[0]);
            return i;
        }
    }

    public static void hnadsa(String str, Object obj, int i, Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.setInt(obj, i);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set int, IllegalAccessException in reflect " + str, new Object[0]);
        } catch (IllegalArgumentException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set int, IllegalArgumentException in reflect " + str, new Object[0]);
        } catch (NoSuchFieldException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set int, No field in reflect " + str, new Object[0]);
        } catch (SecurityException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "In set int, SecurityException in reflect " + str, new Object[0]);
        }
    }

    public static Object hnadsa(Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalAccessException in reflect call " + str, new Object[0]);
            return null;
        } catch (IllegalArgumentException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalArgumentException in reflect call " + str, new Object[0]);
            return null;
        } catch (NoSuchMethodException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "there is no " + str + " method", new Object[0]);
            return null;
        } catch (InvocationTargetException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "InvocationTargetException in reflect call " + str, new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Object obj, String str, Class[] clsArr, Object[] objArr, String str2) {
        try {
            return hnadsa(obj, str, clsArr, objArr, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "callMethod: class not fount " + str2, new Object[0]);
            return null;
        }
    }

    public static int hnadsa(String str, String str2) {
        try {
            Field field = Class.forName("com.android.internal.R$" + str).getField(str2);
            field.setAccessible(true);
            return field.getInt(null);
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getInternalId: com.android.internal.R." + str + " not found", new Object[0]);
            return 0;
        } catch (IllegalAccessException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getInternalId: IllegalAccessException of com.android.internal.R." + str + "." + str2, new Object[0]);
            return 0;
        } catch (NoSuchFieldException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getInternalId: com.android.internal.R." + str + "." + str2 + " not found", new Object[0]);
            return 0;
        }
    }

    public static Method hnadsa(String str, Class[] clsArr, Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "there is no " + str + " method", new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Object obj, Method method, Object[] objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalAccessException in reflect call " + method.getName(), new Object[0]);
            return null;
        } catch (InvocationTargetException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "InvocationTargetException in reflect call " + method.getName(), new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Object obj, Method method) {
        return hnadsa(obj, method, (Object[]) null);
    }

    public static Object hnadsa(Method method) {
        return hnadsa((Object) null, method, (Object[]) null);
    }

    public static Object hnadsa(String str, Class[] clsArr, Object[] objArr) {
        try {
            return hnadsa(Class.forName(str), clsArr, objArr);
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "ClassNotFoundException in reflect call " + str, new Object[0]);
            return null;
        }
    }

    public static Object hnadsa(Class<?> cls, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(objArr);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalAccessException in reflect call " + cls, new Object[0]);
            return null;
        } catch (InstantiationException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalAccessException in reflect call " + cls, new Object[0]);
            return null;
        } catch (NoSuchMethodException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "there is no " + cls + " construct method", new Object[0]);
            return null;
        } catch (InvocationTargetException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "InvocationTargetException in reflect call " + cls, new Object[0]);
            return null;
        }
    }

    public static boolean hnadsa(String str, Class[] clsArr, String str2) {
        try {
            return hnadsa(str, clsArr, Class.forName(str2)) != null;
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "ClassNotFoundException in reflect call " + str, new Object[0]);
            return false;
        }
    }
}
