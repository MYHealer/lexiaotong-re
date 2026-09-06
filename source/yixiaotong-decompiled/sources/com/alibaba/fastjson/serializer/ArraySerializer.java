package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ArraySerializer implements ObjectSerializer {
    private final ObjectSerializer compObjectSerializer;
    private final Class<?> componentType;

    public ArraySerializer(Class<?> cls, ObjectSerializer objectSerializer) {
        this.componentType = cls;
        this.compObjectSerializer = objectSerializer;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
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
        Object[] objArr = (Object[]) obj;
        int length = objArr.length;
        SerialContext context = jSONSerializer.getContext();
        jSONSerializer.setContext(context, obj, obj2, 0);
        try {
            writer.append('[');
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != 0) {
                    writer.append(',');
                }
                Object obj3 = objArr[i2];
                if (obj3 == null) {
                    writer.append("null");
                } else if (obj3.getClass() == this.componentType) {
                    this.compObjectSerializer.write(jSONSerializer, obj3, Integer.valueOf(i2), null, 0);
                } else {
                    jSONSerializer.getObjectWriter(obj3.getClass()).write(jSONSerializer, obj3, Integer.valueOf(i2), null, 0);
                }
            }
            writer.append(']');
        } finally {
            jSONSerializer.setContext(context);
        }
    }
}
