package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLongArray;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AtomicLongArrayCodec implements ObjectSerializer, ObjectDeserializer {
    public static final AtomicLongArrayCodec instance = new AtomicLongArrayCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 14;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        if (obj == null) {
            if (writer.isEnabled(SerializerFeature.WriteNullListAsEmpty)) {
                writer.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            } else {
                writer.writeNull();
                return;
            }
        }
        AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
        int length = atomicLongArray.length();
        writer.append('[');
        for (int i2 = 0; i2 < length; i2++) {
            long j = atomicLongArray.get(i2);
            if (i2 != 0) {
                writer.write(',');
            }
            writer.writeLong(j);
        }
        writer.append(']');
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.util.concurrent.atomic.AtomicLongArray] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        if (defaultJSONParser.getLexer().token() == 8) {
            defaultJSONParser.getLexer().nextToken(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        defaultJSONParser.parseArray(jSONArray);
        ?? r3 = (T) new AtomicLongArray(jSONArray.size());
        for (int i = 0; i < jSONArray.size(); i++) {
            r3.set(i, jSONArray.getLong(i).longValue());
        }
        return r3;
    }
}
