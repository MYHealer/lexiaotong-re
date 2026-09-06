package com.ubixnow.ooooo;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class oOo000o0 {
    private static final String OooO00o = "  ";
    private static final int OooO0O0 = 200;

    private oOo000o0() {
    }

    public static <T extends oOo0000O> String OooO00o(T t) {
        StringBuilder sb;
        String message;
        if (t == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            OooO00o(null, t, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            sb = new StringBuilder("Error printing proto: ");
            message = e.getMessage();
            return sb.append(message).toString();
        } catch (InvocationTargetException e2) {
            sb = new StringBuilder("Error printing proto: ");
            message = e2.getMessage();
            return sb.append(message).toString();
        }
    }

    private static String OooO00o(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (i == 0) {
                cCharAt = Character.toLowerCase(cCharAt);
            } else {
                if (Character.isUpperCase(cCharAt)) {
                    stringBuffer.append('_').append(Character.toLowerCase(cCharAt));
                }
            }
            stringBuffer.append(cCharAt);
        }
        return stringBuffer.toString();
    }

    private static void OooO00o(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        if (obj == null) {
            return;
        }
        if (!(obj instanceof oOo0000O)) {
            if (!(obj instanceof Map)) {
                stringBuffer2.append(stringBuffer).append(OooO00o(str)).append(": ");
                if (obj instanceof String) {
                    stringBuffer2.append("\"").append(OooO0OO((String) obj)).append("\"");
                } else if (obj instanceof byte[]) {
                    OooO00o((byte[]) obj, stringBuffer2);
                } else {
                    stringBuffer2.append(obj);
                }
                stringBuffer2.append(IOUtils.LINE_SEPARATOR_UNIX);
                return;
            }
            String strOooO00o = OooO00o(str);
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                stringBuffer2.append(stringBuffer).append(strOooO00o).append(" <\n");
                int length = stringBuffer.length();
                stringBuffer.append(OooO00o);
                OooO00o("key", entry.getKey(), stringBuffer, stringBuffer2);
                OooO00o(oOOOoo00.OooOo0o, entry.getValue(), stringBuffer, stringBuffer2);
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer).append(">\n");
            }
            return;
        }
        int length2 = stringBuffer.length();
        if (str != null) {
            stringBuffer2.append(stringBuffer).append(OooO00o(str)).append(" <\n");
            stringBuffer.append(OooO00o);
        }
        Class<?> cls = obj.getClass();
        for (Field field : cls.getFields()) {
            int modifiers = field.getModifiers();
            String name = field.getName();
            if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                Class<?> type = field.getType();
                Object obj2 = field.get(obj);
                if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                    OooO00o(name, obj2, stringBuffer, stringBuffer2);
                } else {
                    int length3 = obj2 == null ? 0 : Array.getLength(obj2);
                    for (int i = 0; i < length3; i++) {
                        OooO00o(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                    }
                }
            }
        }
        for (Method method : cls.getMethods()) {
            String name2 = method.getName();
            if (name2.startsWith("set")) {
                String strSubstring = name2.substring(3);
                try {
                    if (((Boolean) cls.getMethod("has" + strSubstring, new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                        OooO00o(strSubstring, cls.getMethod("get" + strSubstring, new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                    }
                } catch (NoSuchMethodException unused) {
                }
            }
        }
        if (str != null) {
            stringBuffer.setLength(length2);
            stringBuffer2.append(stringBuffer).append(">\n");
        }
    }

    private static void OooO00o(byte[] bArr, StringBuffer stringBuffer) {
        if (bArr == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append(Typography.quote);
        for (byte b : bArr) {
            int i = b & 255;
            if (i == 92 || i == 34) {
                stringBuffer.append(IOUtils.DIR_SEPARATOR_WINDOWS).append((char) i);
            } else if (i < 32 || i >= 127) {
                stringBuffer.append(String.format("\\%03o", Integer.valueOf(i)));
            } else {
                stringBuffer.append((char) i);
            }
        }
        stringBuffer.append(Typography.quote);
    }

    private static String OooO0O0(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '~' || cCharAt == '\"' || cCharAt == '\'') {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    private static String OooO0OO(String str) {
        if (!str.startsWith("http") && str.length() > 200) {
            str = str.substring(0, 200) + "[...]";
        }
        return OooO0O0(str);
    }
}
