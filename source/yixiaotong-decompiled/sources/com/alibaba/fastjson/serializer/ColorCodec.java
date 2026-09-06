package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ColorCodec implements ObjectSerializer, ObjectDeserializer {
    public static final ColorCodec instance = new ColorCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        SerializeWriter writer = jSONSerializer.getWriter();
        Color color = (Color) obj;
        if (color == null) {
            writer.writeNull();
            return;
        }
        char c = '{';
        if (writer.isEnabled(SerializerFeature.WriteClassName)) {
            writer.write('{');
            writer.writeFieldName(JSON.DEFAULT_TYPE_KEY);
            writer.writeString(Color.class.getName());
            c = ',';
        }
        writer.writeFieldValue(c, t.k, color.getRed());
        writer.writeFieldValue(',', OapsKey.KEY_GRADE, color.getGreen());
        writer.writeFieldValue(',', t.l, color.getBlue());
        if (color.getAlpha() > 0) {
            writer.writeFieldValue(',', "alpha", color.getAlpha());
        }
        writer.write('}');
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() != 12 && lexer.token() != 16) {
            throw new JSONException("syntax error");
        }
        lexer.nextToken();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (lexer.token() != 13) {
            if (lexer.token() == 4) {
                String strStringVal = lexer.stringVal();
                lexer.nextTokenWithColon(2);
                if (lexer.token() == 2) {
                    int iIntValue = lexer.intValue();
                    lexer.nextToken();
                    if (strStringVal.equalsIgnoreCase(t.k)) {
                        i = iIntValue;
                    } else if (strStringVal.equalsIgnoreCase(OapsKey.KEY_GRADE)) {
                        i2 = iIntValue;
                    } else if (strStringVal.equalsIgnoreCase(t.l)) {
                        i3 = iIntValue;
                    } else {
                        if (!strStringVal.equalsIgnoreCase("alpha")) {
                            throw new JSONException("syntax error, " + strStringVal);
                        }
                        i4 = iIntValue;
                    }
                    if (lexer.token() == 16) {
                        lexer.nextToken(4);
                    }
                } else {
                    throw new JSONException("syntax error");
                }
            } else {
                throw new JSONException("syntax error");
            }
        }
        lexer.nextToken();
        return (T) new Color(i, i2, i3, i4);
    }
}
