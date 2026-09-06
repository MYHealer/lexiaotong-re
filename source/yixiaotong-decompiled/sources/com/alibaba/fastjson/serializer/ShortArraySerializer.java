package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ShortArraySerializer implements ObjectSerializer {
    public static ShortArraySerializer instance = new ShortArraySerializer();

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
        short[] sArr = (short[]) obj;
        writer.write('[');
        for (int i2 = 0; i2 < sArr.length; i2++) {
            if (i2 != 0) {
                writer.write(',');
            }
            writer.writeInt(sArr[i2]);
        }
        writer.write(']');
    }
}
