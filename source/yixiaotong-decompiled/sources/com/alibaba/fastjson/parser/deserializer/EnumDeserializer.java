package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    private final Map<Integer, Enum> ordinalMap = new HashMap();
    private final Map<String, Enum> nameMap = new HashMap();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 2;
    }

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        try {
            for (Object obj : (Object[]) cls.getMethod("values", new Class[0]).invoke(null, new Object[0])) {
                Enum r3 = (Enum) obj;
                this.ordinalMap.put(Integer.valueOf(r3.ordinal()), r3);
                this.nameMap.put(r3.name(), r3);
            }
        } catch (Exception unused) {
            throw new JSONException("init enum values error, " + cls.getName());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer lexer = defaultJSONParser.getLexer();
            if (lexer.token() == 2) {
                Integer numValueOf = Integer.valueOf(lexer.intValue());
                lexer.nextToken(16);
                T t = (T) this.ordinalMap.get(numValueOf);
                if (t != null) {
                    return t;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + numValueOf);
            }
            if (lexer.token() == 4) {
                String strStringVal = lexer.stringVal();
                lexer.nextToken(16);
                if (strStringVal.length() == 0) {
                    return null;
                }
                this.nameMap.get(strStringVal);
                return (T) Enum.valueOf(this.enumClass, strStringVal);
            }
            if (lexer.token() == 8) {
                lexer.nextToken(16);
                return null;
            }
            throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
        } catch (JSONException e) {
            throw e;
        } catch (Throwable th) {
            throw new JSONException(th.getMessage(), th);
        }
    }
}
