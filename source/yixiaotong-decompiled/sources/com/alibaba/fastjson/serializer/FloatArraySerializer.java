package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FloatArraySerializer implements ObjectSerializer {
    public static final FloatArraySerializer instance = new FloatArraySerializer();

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
        float[] fArr = (float[]) obj;
        int length = fArr.length - 1;
        if (length == -1) {
            writer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            return;
        }
        writer.append('[');
        for (int i2 = 0; i2 < length; i2++) {
            float f = fArr[i2];
            if (Float.isNaN(f)) {
                writer.writeNull();
            } else {
                writer.append((CharSequence) Float.toString(f));
            }
            writer.append(',');
        }
        float f2 = fArr[length];
        if (Float.isNaN(f2)) {
            writer.writeNull();
        } else {
            writer.append((CharSequence) Float.toString(f2));
        }
        writer.append(']');
    }
}
