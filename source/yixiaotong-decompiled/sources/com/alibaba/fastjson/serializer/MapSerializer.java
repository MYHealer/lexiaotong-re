package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MapSerializer implements ObjectSerializer {
    public static MapSerializer instance = new MapSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        boolean z;
        Object objProcessValue;
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            writer.writeNull();
            return;
        }
        Map map = (Map) obj;
        if (jSONSerializer.containsReference(obj)) {
            jSONSerializer.writeReference(obj);
            return;
        }
        SerialContext context = jSONSerializer.getContext();
        jSONSerializer.setContext(context, obj, obj2, 0);
        try {
            writer.write('{');
            jSONSerializer.incrementIndent();
            if (writer.isEnabled(SerializerFeature.WriteClassName)) {
                writer.writeFieldName(JSON.DEFAULT_TYPE_KEY);
                writer.writeString(obj.getClass().getName());
                z = false;
            } else {
                z = true;
            }
            Class<?> cls = null;
            ObjectSerializer objectSerializer = null;
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                Object key = entry.getKey();
                List<PropertyPreFilter> propertyPreFiltersDirect = jSONSerializer.getPropertyPreFiltersDirect();
                if (propertyPreFiltersDirect != null && propertyPreFiltersDirect.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        if (!FilterUtils.applyName(jSONSerializer, obj, (String) key)) {
                        }
                    } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !FilterUtils.applyName(jSONSerializer, obj, JSON.toJSONString(key))) {
                    }
                }
                List<PropertyFilter> propertyFiltersDirect = jSONSerializer.getPropertyFiltersDirect();
                if (propertyFiltersDirect != null && propertyFiltersDirect.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        if (!FilterUtils.apply(jSONSerializer, obj, (String) key, value)) {
                        }
                    } else if ((key.getClass().isPrimitive() || (key instanceof Number)) && !FilterUtils.apply(jSONSerializer, obj, JSON.toJSONString(key), value)) {
                    }
                }
                List<NameFilter> nameFiltersDirect = jSONSerializer.getNameFiltersDirect();
                if (nameFiltersDirect != null && nameFiltersDirect.size() > 0) {
                    if (key == null || (key instanceof String)) {
                        key = FilterUtils.processKey(jSONSerializer, obj, (String) key, value);
                    } else if (key.getClass().isPrimitive() || (key instanceof Number)) {
                        key = FilterUtils.processKey(jSONSerializer, obj, JSON.toJSONString(key), value);
                    }
                }
                Object obj3 = key;
                List<ValueFilter> valueFiltersDirect = jSONSerializer.getValueFiltersDirect();
                if (valueFiltersDirect != null && valueFiltersDirect.size() > 0) {
                    if (obj3 == null || (obj3 instanceof String)) {
                        objProcessValue = FilterUtils.processValue(jSONSerializer, obj, (String) obj3, value);
                    } else if (obj3.getClass().isPrimitive() || (obj3 instanceof Number)) {
                        objProcessValue = FilterUtils.processValue(jSONSerializer, obj, JSON.toJSONString(obj3), value);
                    }
                    value = objProcessValue;
                }
                if (value != null || jSONSerializer.isEnabled(SerializerFeature.WriteMapNullValue)) {
                    if (obj3 instanceof String) {
                        String str = (String) obj3;
                        if (!z) {
                            writer.write(',');
                        }
                        if (writer.isEnabled(SerializerFeature.PrettyFormat)) {
                            jSONSerializer.println();
                        }
                        writer.writeFieldName(str, true);
                    } else {
                        if (!z) {
                            writer.write(',');
                        }
                        if (writer.isEnabled(SerializerFeature.BrowserCompatible) || writer.isEnabled(SerializerFeature.WriteNonStringKeyAsString) || writer.isEnabled(SerializerFeature.BrowserSecure)) {
                            jSONSerializer.write(JSON.toJSONString(obj3));
                        } else {
                            jSONSerializer.write(obj3);
                        }
                        writer.write(':');
                    }
                    if (value == null) {
                        writer.writeNull();
                    } else {
                        Class<?> cls2 = value.getClass();
                        if (cls2 == cls) {
                            objectSerializer.write(jSONSerializer, value, obj3, null, 0);
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(cls2);
                            objectWriter.write(jSONSerializer, value, obj3, null, 0);
                            objectSerializer = objectWriter;
                            cls = cls2;
                        }
                    }
                    z = false;
                }
            }
            jSONSerializer.setContext(context);
            jSONSerializer.decrementIdent();
            if (writer.isEnabled(SerializerFeature.PrettyFormat) && map.size() > 0) {
                jSONSerializer.println();
            }
            writer.write('}');
        } catch (Throwable th) {
            jSONSerializer.setContext(context);
            throw th;
        }
    }
}
