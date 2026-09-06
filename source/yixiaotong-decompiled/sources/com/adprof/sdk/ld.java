package com.adprof.sdk;

import android.text.TextUtils;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Pattern f1285a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f443a = new String[128];
    public static final String[] b;

    static {
        for (int i = 0; i <= 31; i++) {
            f443a[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f443a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
        f1285a = Pattern.compile("_(\\w)");
    }

    public static String a(Object obj, HashMap map, String str, boolean z, boolean z2) throws j7 {
        String string;
        String str2;
        Object obj2 = obj;
        if (obj2 == null) {
            return "null";
        }
        Class<?> cls = obj.getClass();
        if (obj2 instanceof String) {
            string = a((String) obj2);
        } else if (cls.isPrimitive() || cls == Boolean.class || cls == Short.class || cls == Integer.class || cls == Long.class || cls == Float.class || cls == Double.class || cls == Byte.class || cls == Character.class) {
            string = obj.toString();
        } else {
            if (!z2 && map.get(Integer.valueOf(obj.hashCode())) != null) {
                return "null";
            }
            string = null;
        }
        map.put(Integer.valueOf(obj.hashCode()), obj2);
        if (TextUtils.isEmpty(string)) {
            if (obj2 instanceof List) {
                List list = (List) obj2;
                string = a(list.toArray(new Object[list.size()]), map, z, z2);
            } else {
                int i = 0;
                boolean z3 = true;
                if (obj2 instanceof Map) {
                    Map map2 = (Map) obj2;
                    StringBuilder sb = new StringBuilder("{");
                    for (Map.Entry entry : map2.entrySet()) {
                        String string2 = entry.getKey().toString();
                        Object value = entry.getValue();
                        if (i != 0) {
                            sb.append(",");
                        }
                        String strA = a(string2);
                        if (z) {
                            strA = b(strA);
                        }
                        sb.append(strA);
                        sb.append(com.huawei.openalliance.ad.constant.x.bQ);
                        sb.append(a(value, map, null, z, z2));
                        i = 1;
                    }
                    sb.append(com.alipay.sdk.util.i.d);
                    string = sb.toString();
                } else if (cls.isArray()) {
                    string = a(obj2, map, z, z2);
                } else {
                    StringBuilder sb2 = new StringBuilder("{");
                    Field[] declaredFields = obj.getClass().getDeclaredFields();
                    int length = declaredFields.length;
                    boolean z4 = false;
                    while (i < length) {
                        Field field = declaredFields[i];
                        field.setAccessible(z3);
                        try {
                            Object obj3 = field.get(obj2);
                            String name = field.getName();
                            boolean zIsStatic = Modifier.isStatic(field.getModifiers());
                            boolean zIsAnnotationPresent = field.isAnnotationPresent(zn.class);
                            if (!name.startsWith("this$") && !zIsStatic && (obj3 == null || !zIsAnnotationPresent)) {
                                if (z4) {
                                    sb2.append(",");
                                }
                                String strA2 = a(name);
                                if (z) {
                                    strA2 = b(strA2);
                                }
                                sb2.append(strA2);
                                sb2.append(com.huawei.openalliance.ad.constant.x.bQ);
                                sb2.append(a(obj3, map, null, z, z2));
                                z4 = true;
                            }
                        } catch (Throwable th) {
                            pk.b("json seriallize error", th);
                        }
                        i++;
                        obj2 = obj;
                        z3 = true;
                    }
                    sb2.append(com.alipay.sdk.util.i.d);
                    string = sb2.toString();
                    str2 = null;
                }
            }
            str2 = null;
        } else {
            str2 = null;
        }
        if (TextUtils.isEmpty(str2)) {
            return string;
        }
        StringBuilder sb3 = new StringBuilder("{");
        sb3.append(a(z ? b(str2) : str2));
        sb3.append(':');
        sb3.append(string);
        sb3.append('}');
        return sb3.toString();
    }

    public static String a(Object obj, HashMap map, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder("[");
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            sb.append(a(Array.get(obj, i), map, null, z, z2));
            if (i < length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0030 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:3:0x0009, B:5:0x0014, B:7:0x001c, B:19:0x003a, B:17:0x0030, B:18:0x0035, B:21:0x003f, B:22:0x0043), top: B:28:0x0009 }] */
    public static String a(String str) {
        String str2;
        String[] strArr = b;
        StringWriter stringWriter = new StringWriter();
        try {
            stringWriter.write(34);
            int length = str.length();
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                char cCharAt = str.charAt(i2);
                if (cCharAt < 128) {
                    str2 = strArr[cCharAt];
                    if (str2 != null) {
                        if (i < i2) {
                            stringWriter.write(str, i, i2 - i);
                        }
                        stringWriter.write(str2);
                        i = i2 + 1;
                    }
                } else {
                    if (cCharAt == 8232) {
                        str2 = "\\u2028";
                    } else if (cCharAt == 8233) {
                        str2 = "\\u2029";
                    }
                    if (i < i2) {
                        stringWriter.write(str, i, i2 - i);
                    }
                    stringWriter.write(str2);
                    i = i2 + 1;
                }
            }
            if (i < length) {
                stringWriter.write(str, i, length - i);
            }
            stringWriter.write(34);
        } catch (Throwable th) {
            pk.b("SerializeString", th);
        }
        return stringWriter.toString();
    }

    public static String b(String str) {
        if (!f1285a.matcher(str).find()) {
            return str;
        }
        Matcher matcher = f1285a.matcher(str.toLowerCase());
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
