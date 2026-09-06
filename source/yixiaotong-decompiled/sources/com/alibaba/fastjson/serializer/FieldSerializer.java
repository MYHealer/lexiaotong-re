package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.util.FieldInfo;
import com.huawei.openalliance.ad.constant.x;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class FieldSerializer {
    private final String double_quoted_fieldPrefix;
    protected final FieldInfo fieldInfo;
    private final String single_quoted_fieldPrefix;
    private final String un_quoted_fieldPrefix;
    private boolean writeNull;

    public boolean isWriteNull() {
        return this.writeNull;
    }

    public abstract void writeProperty(JSONSerializer jSONSerializer, Object obj) throws Exception;

    public abstract void writeValue(JSONSerializer jSONSerializer, Object obj) throws Exception;

    public FieldSerializer(FieldInfo fieldInfo) {
        this.writeNull = false;
        this.fieldInfo = fieldInfo;
        fieldInfo.setAccessible(true);
        this.double_quoted_fieldPrefix = "\"" + fieldInfo.getName() + "\":";
        this.single_quoted_fieldPrefix = "'" + fieldInfo.getName() + "':";
        this.un_quoted_fieldPrefix = fieldInfo.getName() + x.bQ;
        JSONField jSONField = (JSONField) fieldInfo.getAnnotation(JSONField.class);
        if (jSONField != null) {
            for (SerializerFeature serializerFeature : jSONField.serialzeFeatures()) {
                if (serializerFeature == SerializerFeature.WriteMapNullValue) {
                    this.writeNull = true;
                }
            }
        }
    }

    public Field getField() {
        return this.fieldInfo.getField();
    }

    public String getName() {
        return this.fieldInfo.getName();
    }

    public Method getMethod() {
        return this.fieldInfo.getMethod();
    }

    public void writePrefix(JSONSerializer jSONSerializer) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (jSONSerializer.isEnabled(SerializerFeature.QuoteFieldNames)) {
            if (jSONSerializer.isEnabled(SerializerFeature.UseSingleQuotes)) {
                writer.write(this.single_quoted_fieldPrefix);
                return;
            } else {
                writer.write(this.double_quoted_fieldPrefix);
                return;
            }
        }
        writer.write(this.un_quoted_fieldPrefix);
    }

    public Object getPropertyValue(Object obj) throws Exception {
        try {
            return this.fieldInfo.get(obj);
        } catch (Exception e) {
            throw new JSONException("get property error。 " + this.fieldInfo.gerQualifiedName(), e);
        }
    }
}
