package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LongCodec implements ObjectSerializer, ObjectDeserializer {
    public static LongCodec instance = new LongCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
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
        long jLongValue = ((Long) obj).longValue();
        writer.writeLong(jLongValue);
        if (!jSONSerializer.isEnabled(SerializerFeature.WriteClassName) || jLongValue > 2147483647L || jLongValue < -2147483648L || type == Long.class) {
            return;
        }
        writer.write('L');
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 2) {
            long jLongValue = lexer.longValue();
            lexer.nextToken(16);
            obj2 = (T) Long.valueOf(jLongValue);
        } else {
            Object obj3 = defaultJSONParser.parse();
            if (obj3 == null) {
                return null;
            }
            obj2 = (T) TypeUtils.castToLong(obj3);
        }
        return type == AtomicLong.class ? (T) new AtomicLong(((Long) obj2).longValue()) : (T) obj2;
    }
}
