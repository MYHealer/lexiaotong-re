package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CollectionSerializer implements ObjectSerializer {
    public static final CollectionSerializer instance = new CollectionSerializer();

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
        Collection collection = (Collection) obj;
        SerialContext context = jSONSerializer.getContext();
        jSONSerializer.setContext(context, obj, obj2, 0);
        if (jSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
            if (HashSet.class == collection.getClass()) {
                writer.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                writer.append("TreeSet");
            }
        }
        try {
            writer.append('[');
            for (Object obj3 : collection) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    writer.append(',');
                }
                if (obj3 == null) {
                    writer.writeNull();
                } else {
                    Class<?> cls = obj3.getClass();
                    if (cls == Integer.class) {
                        writer.writeInt(((Integer) obj3).intValue());
                    } else if (cls == Long.class) {
                        writer.writeLong(((Long) obj3).longValue());
                        if (writer.isEnabled(SerializerFeature.WriteClassName)) {
                            writer.write('L');
                        }
                    } else {
                        jSONSerializer.getObjectWriter(cls).write(jSONSerializer, obj3, Integer.valueOf(i2), type2, 0);
                    }
                }
                i2 = i3;
            }
            writer.append(']');
        } finally {
            jSONSerializer.setContext(context);
        }
    }
}
