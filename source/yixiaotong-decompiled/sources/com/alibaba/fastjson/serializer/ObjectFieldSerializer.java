package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.huawei.hms.ads.ez;
import java.util.Collection;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ObjectFieldSerializer extends FieldSerializer {
    private String format;
    private RuntimeSerializerInfo runtimeInfo;
    boolean writeEnumUsingName;
    boolean writeEnumUsingToString;
    boolean writeNullBooleanAsFalse;
    boolean writeNullListAsEmpty;
    boolean writeNullStringAsEmpty;
    boolean writeNumberAsZero;

    public ObjectFieldSerializer(FieldInfo fieldInfo) {
        super(fieldInfo);
        this.writeNumberAsZero = false;
        this.writeNullStringAsEmpty = false;
        this.writeNullBooleanAsFalse = false;
        this.writeNullListAsEmpty = false;
        this.writeEnumUsingToString = false;
        this.writeEnumUsingName = false;
        JSONField jSONField = (JSONField) fieldInfo.getAnnotation(JSONField.class);
        if (jSONField != null) {
            String str = jSONField.format();
            this.format = str;
            if (str.trim().length() == 0) {
                this.format = null;
            }
            for (SerializerFeature serializerFeature : jSONField.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteNullNumberAsZero) {
                    this.writeNumberAsZero = true;
                } else if (serializerFeature == SerializerFeature.WriteNullStringAsEmpty) {
                    this.writeNullStringAsEmpty = true;
                } else if (serializerFeature == SerializerFeature.WriteNullBooleanAsFalse) {
                    this.writeNullBooleanAsFalse = true;
                } else if (serializerFeature == SerializerFeature.WriteNullListAsEmpty) {
                    this.writeNullListAsEmpty = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingToString) {
                    this.writeEnumUsingToString = true;
                } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                    this.writeEnumUsingName = true;
                }
            }
        }
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeProperty(JSONSerializer jSONSerializer, Object obj) throws Exception {
        writePrefix(jSONSerializer);
        writeValue(jSONSerializer, obj);
    }

    @Override // com.alibaba.fastjson.serializer.FieldSerializer
    public void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception {
        Class<?> fieldClass;
        String str = this.format;
        if (str != null) {
            jSONSerializer.writeWithFormat(obj, str);
            return;
        }
        if (this.runtimeInfo == null) {
            if (obj == null) {
                fieldClass = this.fieldInfo.getFieldClass();
            } else {
                fieldClass = obj.getClass();
            }
            this.runtimeInfo = new RuntimeSerializerInfo(jSONSerializer.getObjectWriter(fieldClass), fieldClass);
        }
        RuntimeSerializerInfo runtimeSerializerInfo = this.runtimeInfo;
        int serialzeFeatures = this.fieldInfo.getSerialzeFeatures();
        if (obj == null) {
            if (this.writeNumberAsZero && Number.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
                jSONSerializer.getWriter().write('0');
                return;
            }
            if (this.writeNullStringAsEmpty && String.class == runtimeSerializerInfo.runtimeFieldClass) {
                jSONSerializer.getWriter().write("\"\"");
                return;
            }
            if (this.writeNullBooleanAsFalse && Boolean.class == runtimeSerializerInfo.runtimeFieldClass) {
                jSONSerializer.getWriter().write(ez.V);
                return;
            } else if (this.writeNullListAsEmpty && Collection.class.isAssignableFrom(runtimeSerializerInfo.runtimeFieldClass)) {
                jSONSerializer.getWriter().write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, null, this.fieldInfo.getName(), null, serialzeFeatures);
                return;
            }
        }
        if (runtimeSerializerInfo.runtimeFieldClass.isEnum()) {
            if (this.writeEnumUsingName) {
                jSONSerializer.getWriter().writeString(((Enum) obj).name());
                return;
            } else if (this.writeEnumUsingToString) {
                jSONSerializer.getWriter().writeString(((Enum) obj).toString());
                return;
            }
        }
        Class<?> cls = obj.getClass();
        if (cls == runtimeSerializerInfo.runtimeFieldClass) {
            runtimeSerializerInfo.fieldSerializer.write(jSONSerializer, obj, this.fieldInfo.getName(), this.fieldInfo.getFieldType(), serialzeFeatures);
        } else {
            jSONSerializer.getObjectWriter(cls).write(jSONSerializer, obj, this.fieldInfo.getName(), this.fieldInfo.getFieldType(), serialzeFeatures);
        }
    }

    static class RuntimeSerializerInfo {
        ObjectSerializer fieldSerializer;
        Class<?> runtimeFieldClass;

        public RuntimeSerializerInfo(ObjectSerializer objectSerializer, Class<?> cls) {
            this.fieldSerializer = objectSerializer;
            this.runtimeFieldClass = cls;
        }
    }
}
