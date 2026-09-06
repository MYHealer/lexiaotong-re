package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.cdo.oaps.ad.OapsKey;
import java.awt.Font;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FontCodec implements ObjectSerializer, ObjectDeserializer {
    public static final FontCodec instance = new FontCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        Font font = (Font) obj;
        if (font == null) {
            writer.writeNull();
            return;
        }
        char c = '{';
        if (writer.isEnabled(SerializerFeature.WriteClassName)) {
            writer.write('{');
            writer.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            writer.writeString(Font.class.getName());
            c = ',';
        }
        writer.writeFieldValue(c, "name", font.getName());
        writer.writeFieldValue(',', "style", font.getStyle());
        writer.writeFieldValue(',', OapsKey.KEY_SIZE, font.getSize());
        writer.write('}');
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        String strStringVal = null;
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        if (lexer.token() != 12 && lexer.token() != 16) {
            throw new JSONException("syntax error");
        }
        lexer.nextToken();
        int iIntValue = 0;
        int iIntValue2 = 0;
        while (lexer.token() != 13) {
            if (lexer.token() == 4) {
                String strStringVal2 = lexer.stringVal();
                lexer.nextTokenWithColon(2);
                if (strStringVal2.equalsIgnoreCase("name")) {
                    if (lexer.token() == 4) {
                        strStringVal = lexer.stringVal();
                        lexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (strStringVal2.equalsIgnoreCase("style")) {
                    if (lexer.token() == 2) {
                        iIntValue = lexer.intValue();
                        lexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (strStringVal2.equalsIgnoreCase(OapsKey.KEY_SIZE)) {
                    if (lexer.token() == 2) {
                        iIntValue2 = lexer.intValue();
                        lexer.nextToken();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else {
                    throw new JSONException("syntax error, " + strStringVal2);
                }
                if (lexer.token() == 16) {
                    lexer.nextToken(4);
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        lexer.nextToken();
        return (T) new Font(strStringVal, iIntValue, iIntValue2);
    }
}
