package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.FieldInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
final class NumberFieldSerializer extends FieldSerializer {
    public NumberFieldSerializer(FieldInfo fieldInfo) {
        super(fieldInfo);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeProperty(JSONSerializer jSONSerializer, Object obj) throws Exception {
        writePrefix(jSONSerializer);
        writeValue(jSONSerializer, obj);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            if (writer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                writer.write('0');
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        writer.append((CharSequence) obj.toString());
    }
}
