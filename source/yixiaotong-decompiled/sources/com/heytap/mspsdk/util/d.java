package com.heytap.mspsdk.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    public static Object a(Class<?> cls) {
        if (Integer.class == cls || Integer.TYPE.isAssignableFrom(cls)) {
            return 0;
        }
        if (Character.class == cls || Character.TYPE.isAssignableFrom(cls)) {
            return '0';
        }
        if (Float.class == cls || Float.TYPE.isAssignableFrom(cls)) {
            return Float.valueOf(0.0f);
        }
        if (Double.class == cls || Double.TYPE.isAssignableFrom(cls)) {
            return Double.valueOf(0.0d);
        }
        if (Byte.class == cls || Byte.TYPE.isAssignableFrom(cls)) {
            return (byte) 0;
        }
        return (Boolean.class == cls || Boolean.TYPE.isAssignableFrom(cls)) ? false : null;
    }
}
