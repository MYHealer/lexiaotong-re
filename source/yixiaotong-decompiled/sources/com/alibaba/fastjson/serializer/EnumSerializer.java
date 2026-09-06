package com.alibaba.fastjson.serializer;

import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EnumSerializer implements ObjectSerializer {
    public static final EnumSerializer instance = new EnumSerializer();

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            jSONSerializer.getWriter().writeNull();
            return;
        }
        Enum r2 = (Enum) obj;
        if (jSONSerializer.isEnabled(SerializerFeature.WriteEnumUsingName)) {
            jSONSerializer.write(r2.name());
        } else if (jSONSerializer.isEnabled(SerializerFeature.WriteEnumUsingToString)) {
            jSONSerializer.write(r2.toString());
        } else {
            writer.writeInt(r2.ordinal());
        }
    }
}
