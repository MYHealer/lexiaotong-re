package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FilterUtils {
    public static Type getExtratype(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        List<ExtraTypeProvider> extraTypeProvidersDirect = defaultJSONParser.getExtraTypeProvidersDirect();
        Type extraType = null;
        if (extraTypeProvidersDirect == null) {
            return null;
        }
        Iterator<ExtraTypeProvider> it = extraTypeProvidersDirect.iterator();
        while (it.hasNext()) {
            extraType = it.next().getExtraType(obj, str);
        }
        return extraType;
    }

    public static void processExtra(DefaultJSONParser defaultJSONParser, Object obj, String str, Object obj2) {
        List<ExtraProcessor> extraProcessorsDirect = defaultJSONParser.getExtraProcessorsDirect();
        if (extraProcessorsDirect == null) {
            return;
        }
        Iterator<ExtraProcessor> it = extraProcessorsDirect.iterator();
        while (it.hasNext()) {
            it.next().processExtra(obj, str, obj2);
        }
    }

    public static char writeBefore(JSONSerializer jSONSerializer, Object obj, char c) {
        List<BeforeFilter> beforeFiltersDirect = jSONSerializer.getBeforeFiltersDirect();
        if (beforeFiltersDirect != null) {
            Iterator<BeforeFilter> it = beforeFiltersDirect.iterator();
            while (it.hasNext()) {
                c = it.next().writeBefore(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public static char writeAfter(JSONSerializer jSONSerializer, Object obj, char c) {
        List<AfterFilter> afterFiltersDirect = jSONSerializer.getAfterFiltersDirect();
        if (afterFiltersDirect != null) {
            Iterator<AfterFilter> it = afterFiltersDirect.iterator();
            while (it.hasNext()) {
                c = it.next().writeAfter(jSONSerializer, obj, c);
            }
        }
        return c;
    }

    public static Object processValue(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<ValueFilter> valueFiltersDirect = jSONSerializer.getValueFiltersDirect();
        if (valueFiltersDirect != null) {
            Iterator<ValueFilter> it = valueFiltersDirect.iterator();
            while (it.hasNext()) {
                obj2 = it.next().process(obj, str, obj2);
            }
        }
        return obj2;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, obj2);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, byte b) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Byte bValueOf = Byte.valueOf(b);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, bValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, short s) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Short shValueOf = Short.valueOf(s);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, shValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, int i) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Integer numValueOf = Integer.valueOf(i);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, numValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, long j) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Long lValueOf = Long.valueOf(j);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, lValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, float f) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Float fValueOf = Float.valueOf(f);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, fValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, double d) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Double dValueOf = Double.valueOf(d);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, dValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, boolean z) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Boolean boolValueOf = Boolean.valueOf(z);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, boolValueOf);
            }
        }
        return str;
    }

    public static String processKey(JSONSerializer jSONSerializer, Object obj, String str, char c) {
        List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
        if (nameFiltersDirect != null) {
            Character chValueOf = Character.valueOf(c);
            Iterator<NameFilter> it = nameFiltersDirect.iterator();
            while (it.hasNext()) {
                str = it.next().process(obj, str, chValueOf);
            }
        }
        return str;
    }

    public static boolean applyName(JSONSerializer jSONSerializer, Object obj, String str) {
        List<PropertyPreFilter> propertyPreFiltersDirect = jSONSerializer.getPropertyPreFiltersDirect();
        if (propertyPreFiltersDirect == null) {
            return true;
        }
        Iterator<PropertyPreFilter> it = propertyPreFiltersDirect.iterator();
        while (it.hasNext()) {
            if (!it.next().apply(jSONSerializer, obj, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, Object obj2) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect == null) {
            return true;
        }
        Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
        while (it.hasNext()) {
            if (!it.next().apply(obj, str, obj2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, byte b) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Byte bValueOf = Byte.valueOf(b);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, bValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, short s) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Short shValueOf = Short.valueOf(s);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, shValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, int i) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Integer numValueOf = Integer.valueOf(i);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, numValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, char c) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Character chValueOf = Character.valueOf(c);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, chValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, long j) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Long lValueOf = Long.valueOf(j);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, lValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, float f) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Float fValueOf = Float.valueOf(f);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, fValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean apply(JSONSerializer jSONSerializer, Object obj, String str, double d) {
        List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
        if (propertyFiltersDirect != null) {
            Double dValueOf = Double.valueOf(d);
            Iterator<PropertyFilter> it = propertyFiltersDirect.iterator();
            while (it.hasNext()) {
                if (!it.next().apply(obj, str, dValueOf)) {
                    return false;
                }
            }
        }
        return true;
    }
}
