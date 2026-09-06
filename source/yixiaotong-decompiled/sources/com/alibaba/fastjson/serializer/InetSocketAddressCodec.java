package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.hihonor.adsdk.base.g.j.e.a;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InetSocketAddressCodec implements ObjectSerializer, ObjectDeserializer {
    public static InetSocketAddressCodec instance = new InetSocketAddressCodec();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i) throws IOException {
        if (obj == null) {
            jSONSerializer.writeNull();
            return;
        }
        SerializeWriter writer = jSONSerializer.getWriter();
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        InetAddress address = inetSocketAddress.getAddress();
        writer.write('{');
        if (address != null) {
            writer.writeFieldName(a.G0);
            jSONSerializer.write(address);
            writer.write(',');
        }
        writer.writeFieldName(ClientCookie.PORT_ATTR);
        writer.writeInt(inetSocketAddress.getPort());
        writer.write('}');
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        InetAddress inetAddress = null;
        if (lexer.token() == 8) {
            lexer.nextToken();
            return null;
        }
        defaultJSONParser.accept(12);
        int iIntValue = 0;
        while (true) {
            String strStringVal = lexer.stringVal();
            lexer.nextToken(17);
            if (strStringVal.equals(a.G0)) {
                defaultJSONParser.accept(17);
                inetAddress = (InetAddress) defaultJSONParser.parseObject((Class) InetAddress.class);
            } else if (strStringVal.equals(ClientCookie.PORT_ATTR)) {
                defaultJSONParser.accept(17);
                if (lexer.token() != 2) {
                    throw new JSONException("port is not int");
                }
                iIntValue = lexer.intValue();
                lexer.nextToken();
            } else {
                defaultJSONParser.accept(17);
                defaultJSONParser.parse();
            }
            if (lexer.token() == 16) {
                lexer.nextToken();
            } else {
                defaultJSONParser.accept(13);
                return (T) new InetSocketAddress(inetAddress, iIntValue);
            }
        }
    }
}
