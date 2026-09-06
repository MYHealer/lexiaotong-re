package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.FieldInfo;
import java.lang.reflect.Type;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ASMJavaBeanDeserializer implements ObjectDeserializer {
    protected InnerJavaBeanDeserializer serializer;

    /* JADX INFO: renamed from: com.alibaba.fastjson.parser.deserializer.ASMJavaBeanDeserializer$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public abstract Object createInstance(DefaultJSONParser defaultJSONParser, Type type);

    public InnerJavaBeanDeserializer getInnterSerializer() {
        return this.serializer;
    }

    public ASMJavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        InnerJavaBeanDeserializer innerJavaBeanDeserializer = new InnerJavaBeanDeserializer(this, parserConfig, cls, null);
        this.serializer = innerJavaBeanDeserializer;
        innerJavaBeanDeserializer.getFieldDeserializerMap();
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) this.serializer.deserialze(defaultJSONParser, type, obj);
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return this.serializer.getFastMatchToken();
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser) {
        InnerJavaBeanDeserializer innerJavaBeanDeserializer = this.serializer;
        return innerJavaBeanDeserializer.createInstance(defaultJSONParser, innerJavaBeanDeserializer.getClazz());
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        return parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        return this.serializer.getFieldDeserializerMap().get(str);
    }

    public Type getFieldType(String str) {
        return this.serializer.getFieldDeserializerMap().get(str).getFieldType();
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        Map<String, FieldDeserializer> fieldDeserializerMap = this.serializer.getFieldDeserializerMap();
        FieldDeserializer value = fieldDeserializerMap.get(str);
        if (value == null) {
            for (Map.Entry<String, FieldDeserializer> entry : fieldDeserializerMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(str)) {
                    value = entry.getValue();
                    break;
                }
            }
        }
        if (value == null) {
            this.serializer.parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        lexer.nextTokenWithColon(value.getFastMatchToken());
        value.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    public final class InnerJavaBeanDeserializer extends JavaBeanDeserializer {
        /* synthetic */ InnerJavaBeanDeserializer(ASMJavaBeanDeserializer aSMJavaBeanDeserializer, ParserConfig parserConfig, Class cls, AnonymousClass1 anonymousClass1) {
            this(parserConfig, cls);
        }

        private InnerJavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
            super(parserConfig, cls);
        }

        @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
        public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
            return ASMJavaBeanDeserializer.this.parseField(defaultJSONParser, str, obj, type, map);
        }

        @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer
        public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
            return ASMJavaBeanDeserializer.this.createFieldDeserializer(parserConfig, cls, fieldInfo);
        }
    }

    public boolean isSupportArrayToBean(JSONLexer jSONLexer) {
        return this.serializer.isSupportArrayToBean(jSONLexer);
    }

    public Object parseRest(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        return this.serializer.deserialze(defaultJSONParser, type, obj, obj2);
    }
}
