package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class IntegerCodec implements ObjectSerializer, ObjectDeserializer {
    public static IntegerCodec instance = new IntegerCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        Number number = (Number) obj;
        if (number == null) {
            if (writer.isEnabled(SerializerFeature.WriteNullNumberAsZero)) {
                writer.write('0');
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        writer.writeInt(number.intValue());
        if (jSONSerializer.isEnabled(SerializerFeature.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                writer.write('B');
            } else if (cls == Short.class) {
                writer.write('S');
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object obj2;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        if (lexer.token() == 2) {
            int iIntValue = lexer.intValue();
            lexer.nextToken(16);
            obj2 = (T) Integer.valueOf(iIntValue);
        } else if (lexer.token() == 3) {
            BigDecimal bigDecimalDecimalValue = lexer.decimalValue();
            lexer.nextToken(16);
            obj2 = (T) Integer.valueOf(bigDecimalDecimalValue.intValue());
        } else {
            obj2 = (T) TypeUtils.castToInt(defaultJSONParser.parse());
        }
        return type == AtomicInteger.class ? (T) new AtomicInteger(((Integer) obj2).intValue()) : (T) obj2;
    }
}
