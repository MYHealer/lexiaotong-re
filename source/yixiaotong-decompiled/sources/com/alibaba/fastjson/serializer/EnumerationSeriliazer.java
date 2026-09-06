package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EnumerationSeriliazer implements ObjectSerializer {
    public static EnumerationSeriliazer instance = new EnumerationSeriliazer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            if (writer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        int i2 = 0;
        Type type2 = (jSONSerializer.isEnabled(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        SerialContext context = jSONSerializer.getContext();
        jSONSerializer.setContext(context, obj, obj2, 0);
        try {
            writer.append('[');
            while (enumeration.hasMoreElements()) {
                Object objNextElement = enumeration.nextElement();
                int i3 = i2 + 1;
                if (i2 != 0) {
                    writer.append(',');
                }
                if (objNextElement == null) {
                    writer.writeNull();
                } else {
                    jSONSerializer.getObjectWriter(objNextElement.getClass()).write(jSONSerializer, objNextElement, Integer.valueOf(i2), type2, 0);
                }
                i2 = i3;
            }
            writer.append(']');
        } finally {
            jSONSerializer.setContext(context);
        }
    }
}
