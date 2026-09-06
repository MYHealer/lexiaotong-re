package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class ListSerializer implements ObjectSerializer {
    public static final ListSerializer instance = new ListSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public final void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        char c;
        boolean zIsEnabled = jSONSerializer.isEnabled(SerializerFeature.WriteClassName);
        SerializeWriter writer = jSONSerializer.getWriter();
        Type type2 = (zIsEnabled && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        if (obj == null) {
            if (writer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        List list = (List) obj;
        if (list.size() == 0) {
            writer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        SerialContext context = jSONSerializer.getContext();
        jSONSerializer.setContext(context, obj, obj2, 0);
        try {
            char c2 = ',';
            char c3 = ']';
            if (writer.isEnabled(SerializerFeature.PrettyFormat)) {
                writer.append('[');
                jSONSerializer.incrementIndent();
                int i2 = 0;
                for (Object obj3 : list) {
                    if (i2 != 0) {
                        writer.append(c2);
                    }
                    jSONSerializer.println();
                    if (obj3 != null) {
                        if (jSONSerializer.containsReference(obj3)) {
                            jSONSerializer.writeReference(obj3);
                        } else {
                            ObjectSerializer objectWriter = jSONSerializer.getObjectWriter(obj3.getClass());
                            jSONSerializer.setContext(new SerialContext(context, obj, obj2, 0, 0));
                            objectWriter.write(jSONSerializer, obj3, Integer.valueOf(i2), type2, 0);
                        }
                    } else {
                        jSONSerializer.getWriter().writeNull();
                    }
                    i2++;
                    c2 = ',';
                }
                jSONSerializer.decrementIdent();
                jSONSerializer.println();
                writer.append(']');
                return;
            }
            writer.append('[');
            int i3 = 0;
            for (Object obj4 : list) {
                if (i3 != 0) {
                    c = ',';
                    writer.append(',');
                } else {
                    c = ',';
                }
                if (obj4 == null) {
                    writer.append("null");
                } else {
                    Class<?> cls = obj4.getClass();
                    if (cls == Integer.class) {
                        writer.writeInt(((Integer) obj4).intValue());
                    } else {
                        if (cls == Long.class) {
                            long jLongValue = ((Long) obj4).longValue();
                            if (zIsEnabled) {
                                writer.writeLongAndChar(jLongValue, 'L');
                            } else {
                                writer.writeLong(jLongValue);
                            }
                        } else {
                            jSONSerializer.setContext(new SerialContext(context, obj, obj2, 0, 0));
                            if (jSONSerializer.containsReference(obj4)) {
                                jSONSerializer.writeReference(obj4);
                            } else {
                                jSONSerializer.getObjectWriter(obj4.getClass()).write(jSONSerializer, obj4, Integer.valueOf(i3), type2, 0);
                            }
                        }
                        i3++;
                        c3 = ']';
                    }
                }
                i3++;
                c3 = ']';
            }
            writer.append(c3);
        } finally {
            jSONSerializer.setContext(context);
        }
    }
}
