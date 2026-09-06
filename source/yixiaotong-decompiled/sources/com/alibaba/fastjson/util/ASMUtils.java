package com.alibaba.fastjson.util;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.huawei.hms.ads.ContentClassification;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ASMUtils {
    public static boolean isAndroid(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("dalvik") || lowerCase.contains("lemur");
    }

    public static boolean isAndroid() {
        return isAndroid(System.getProperty("java.vm.name"));
    }

    public static String getDesc(Method method) {
        StringBuffer stringBuffer = new StringBuffer("(");
        for (Class<?> cls : method.getParameterTypes()) {
            stringBuffer.append(getDesc(cls));
        }
        stringBuffer.append(")");
        stringBuffer.append(getDesc(method.getReturnType()));
        return stringBuffer.toString();
    }

    public static String getDesc(Class<?> cls) {
        if (cls.isPrimitive()) {
            return getPrimitiveLetter(cls);
        }
        if (cls.isArray()) {
            return "[" + getDesc(cls.getComponentType());
        }
        return "L" + getType(cls) + ";";
    }

    public static String getType(Class<?> cls) {
        if (cls.isArray()) {
            return "[" + getDesc(cls.getComponentType());
        }
        if (!cls.isPrimitive()) {
            return cls.getName().replaceAll("\\.", "/");
        }
        return getPrimitiveLetter(cls);
    }

    public static String getPrimitiveLetter(Class<?> cls) {
        if (Integer.TYPE.equals(cls)) {
            return "I";
        }
        if (Void.TYPE.equals(cls)) {
            return ExifInterface.GPS_MEASUREMENT_INTERRUPTED;
        }
        if (Boolean.TYPE.equals(cls)) {
            return "Z";
        }
        if (Character.TYPE.equals(cls)) {
            return "C";
        }
        if (Byte.TYPE.equals(cls)) {
            return "B";
        }
        if (Short.TYPE.equals(cls)) {
            return ExifInterface.LATITUDE_SOUTH;
        }
        if (Float.TYPE.equals(cls)) {
            return "F";
        }
        if (Long.TYPE.equals(cls)) {
            return ContentClassification.AD_CONTENT_CLASSIFICATION_J;
        }
        if (Double.TYPE.equals(cls)) {
            return "D";
        }
        throw new IllegalStateException("Type: " + cls.getCanonicalName() + " is not a primitive type");
    }

    public static Type getMethodType(Class<?> cls, String str) {
        try {
            return cls.getMethod(str, new Class[0]).getGenericReturnType();
        } catch (Exception unused) {
            return null;
        }
    }

    public static Type getFieldType(Class<?> cls, String str) {
        try {
            return cls.getField(str).getGenericType();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void parseArray(Collection collection, ObjectDeserializer objectDeserializer, DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
        }
        defaultJSONParser.accept(14, 14);
        int i = 0;
        while (true) {
            collection.add(objectDeserializer.deserialze(defaultJSONParser, type, Integer.valueOf(i)));
            i++;
            if (lexer.token() == 16) {
                lexer.nextToken(14);
            } else {
                defaultJSONParser.accept(15, 16);
                return;
            }
        }
    }

    public static boolean checkName(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 1 || cCharAt > 127) {
                return false;
            }
        }
        return true;
    }
}
