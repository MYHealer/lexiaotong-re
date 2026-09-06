package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AppendableSerializer implements ObjectSerializer {
    public static final AppendableSerializer instance = new AppendableSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            SerializeWriter writer = jSONSerializer.getWriter();
            if (writer.isEnabled(SerializerFeature.WriteNullStringAsEmpty)) {
                writer.writeString("");
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        jSONSerializer.write(obj.toString());
    }
}
