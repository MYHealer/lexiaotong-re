package com.ubixnow.ooooo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0O0O0o {
    private static final List<?> OooO00o = Arrays.asList(Boolean.class, Character.class, Byte.class, Short.class, Integer.TYPE, Integer.class, Long.class, Long.TYPE, Float.class, Double.class, Void.class, String.class, Date.class, HashMap.class, Map.class);

    public static Object OooO00o(Object obj) throws Exception {
        return OooO00o(OooO0O0(obj));
    }

    public static Object OooO00o(byte[] bArr) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        return new ObjectInputStream(new ByteArrayInputStream(bArr)).readObject();
    }

    public static byte[] OooO0O0(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static String OooO0OO(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            if (OooO00o.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            int i = 0;
            if (obj.getClass().isArray() && !(obj instanceof int[])) {
                Object[] objArr = (Object[]) obj;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                while (i < objArr.length) {
                    stringBuffer.append(OooO0OO(objArr[i]));
                    i++;
                }
                stringBuffer.append("]");
                return stringBuffer.toString();
            }
            if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("[");
                while (it.hasNext()) {
                    if (i > 0) {
                        stringBuffer2.append(",");
                    }
                    stringBuffer2.append(OooO0OO(it.next()));
                    i++;
                }
                stringBuffer2.append("]");
                return stringBuffer2.toString();
            }
            if (obj instanceof Class) {
                return obj.getClass().getName();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(":{");
            Field[] declaredFields = obj.getClass().getDeclaredFields();
            int length = declaredFields.length;
            while (i < length) {
                Field field = declaredFields[i];
                if (!Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    sb.append("\"" + field.getName() + "\"").append(com.huawei.openalliance.ad.constant.x.bQ);
                    try {
                        sb.append(field.get(obj) instanceof String ? "\"" + OooO0OO(field.get(obj)) + "\"" : OooO0OO(field.get(obj))).append(",");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e2) {
                        e2.printStackTrace();
                    }
                }
                i++;
            }
            sb.append(com.alipay.sdk.util.i.d);
            return sb.toString().replaceFirst(":\\{", "{").replaceAll(",\\}", com.alipay.sdk.util.i.d).replaceAll(",:", ",").replaceAll("::", com.huawei.openalliance.ad.constant.x.bQ).replaceAll("\\[:\\{", "[{");
        } catch (SecurityException e3) {
            e3.printStackTrace();
            return "";
        }
    }
}
