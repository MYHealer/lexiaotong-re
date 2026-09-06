package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LocaleCodec implements ObjectSerializer, ObjectDeserializer {
    public static final LocaleCodec instance = new LocaleCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 4;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
        } else {
            jSONSerializer.write(((Locale) obj).toString());
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        String str = (String) defaultJSONParser.parse();
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("_");
        if (strArrSplit.length == 1) {
            return (T) new Locale(strArrSplit[0]);
        }
        if (strArrSplit.length == 2) {
            return (T) new Locale(strArrSplit[0], strArrSplit[1]);
        }
        return (T) new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }
}
