package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MapDeserializer implements ObjectDeserializer {
    public static final MapDeserializer instance = new MapDeserializer();

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        Map<Object, Object> mapCreateMap = createMap(type);
        ParseContext context = defaultJSONParser.getContext();
        try {
            defaultJSONParser.setContext(context, mapCreateMap, obj);
            return (T) deserialze(defaultJSONParser, type, obj, mapCreateMap);
        } finally {
            defaultJSONParser.setContext(context);
        }
    }

    protected Object deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Map map) {
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (String.class == type2) {
                return parseMap(defaultJSONParser, map, type3, obj);
            }
            return parseMap(defaultJSONParser, map, type2, type3, obj);
        }
        return defaultJSONParser.parseObject(map, obj);
    }

    public static Map parseMap(DefaultJSONParser defaultJSONParser, Map<String, Object> map, Type type, Object obj) {
        String strScanSymbolUnQuoted;
        Object object;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() != 12) {
            throw new JSONException("syntax error, expect {, actual " + lexer.token());
        }
        ParseContext context = defaultJSONParser.getContext();
        while (true) {
            try {
                lexer.skipWhitespace();
                char current = lexer.getCurrent();
                if (defaultJSONParser.isEnabled(Feature.AllowArbitraryCommas)) {
                    while (current == ',') {
                        lexer.next();
                        lexer.skipWhitespace();
                        current = lexer.getCurrent();
                    }
                }
                if (current == '\"') {
                    strScanSymbolUnQuoted = lexer.scanSymbol(defaultJSONParser.getSymbolTable(), Typography.quote);
                    lexer.skipWhitespace();
                    if (lexer.getCurrent() != ':') {
                        throw new JSONException("expect ':' at " + lexer.pos());
                    }
                } else {
                    if (current == '}') {
                        lexer.next();
                        lexer.resetStringPosition();
                        lexer.nextToken(16);
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    if (current == '\'') {
                        if (!defaultJSONParser.isEnabled(Feature.AllowSingleQuotes)) {
                            throw new JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = lexer.scanSymbol(defaultJSONParser.getSymbolTable(), '\'');
                        lexer.skipWhitespace();
                        if (lexer.getCurrent() != ':') {
                            throw new JSONException("expect ':' at " + lexer.pos());
                        }
                    } else {
                        if (!defaultJSONParser.isEnabled(Feature.AllowUnQuotedFieldNames)) {
                            throw new JSONException("syntax error");
                        }
                        strScanSymbolUnQuoted = lexer.scanSymbolUnQuoted(defaultJSONParser.getSymbolTable());
                        lexer.skipWhitespace();
                        char current2 = lexer.getCurrent();
                        if (current2 != ':') {
                            throw new JSONException("expect ':' at " + lexer.pos() + ", actual " + current2);
                        }
                    }
                }
                lexer.next();
                lexer.skipWhitespace();
                lexer.getCurrent();
                lexer.resetStringPosition();
                if (strScanSymbolUnQuoted != JSON.DEFAULT_TYPE_KEY || defaultJSONParser.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    lexer.nextToken();
                    if (lexer.token() == 8) {
                        lexer.nextToken();
                        object = null;
                    } else {
                        object = defaultJSONParser.parseObject(type);
                    }
                    map.put(strScanSymbolUnQuoted, object);
                    defaultJSONParser.checkMapResolve(map, strScanSymbolUnQuoted);
                    defaultJSONParser.setContext(context, object, strScanSymbolUnQuoted);
                    int i = lexer.token();
                    if (i == 20 || i == 15) {
                        break;
                        break;
                    }
                    if (i == 13) {
                        lexer.nextToken();
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                } else {
                    Class<?> clsLoadClass = TypeUtils.loadClass(lexer.scanSymbol(defaultJSONParser.getSymbolTable(), Typography.quote));
                    if (!Map.class.isAssignableFrom(clsLoadClass)) {
                        ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(clsLoadClass);
                        lexer.nextToken(16);
                        defaultJSONParser.setResolveStatus(2);
                        if (context != null && !(obj instanceof Integer)) {
                            defaultJSONParser.popContext();
                        }
                        Map map2 = (Map) deserializer.deserialze(defaultJSONParser, clsLoadClass, obj);
                        defaultJSONParser.setContext(context);
                        return map2;
                    }
                    lexer.nextToken(16);
                    if (lexer.token() == 13) {
                        lexer.nextToken(16);
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                }
            } catch (Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
        defaultJSONParser.setContext(context);
        return map;
    }

    public static Object parseMap(DefaultJSONParser defaultJSONParser, Map<Object, Object> map, Type type, Type type2, Object obj) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() != 12 && lexer.token() != 16) {
            throw new JSONException("syntax error, expect {, actual " + lexer.tokenName());
        }
        ObjectDeserializer deserializer = defaultJSONParser.getConfig().getDeserializer(type);
        ObjectDeserializer deserializer2 = defaultJSONParser.getConfig().getDeserializer(type2);
        lexer.nextToken(deserializer.getFastMatchToken());
        ParseContext context = defaultJSONParser.getContext();
        while (lexer.token() != 13) {
            try {
                Object object = null;
                if (lexer.token() == 4 && lexer.isRef() && !defaultJSONParser.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    lexer.nextTokenWithColon(4);
                    if (lexer.token() != 4) {
                        throw new JSONException("illegal ref, " + JSONToken.name(lexer.token()));
                    }
                    String strStringVal = lexer.stringVal();
                    if ("..".equals(strStringVal)) {
                        object = context.getParentContext().getObject();
                    } else if ("$".equals(strStringVal)) {
                        ParseContext parentContext = context;
                        while (parentContext.getParentContext() != null) {
                            parentContext = parentContext.getParentContext();
                        }
                        object = parentContext.getObject();
                    } else {
                        defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(context, strStringVal));
                        defaultJSONParser.setResolveStatus(1);
                    }
                    lexer.nextToken(13);
                    if (lexer.token() != 13) {
                        throw new JSONException("illegal ref");
                    }
                    lexer.nextToken(16);
                    defaultJSONParser.setContext(context);
                    return object;
                }
                if (map.size() == 0 && lexer.token() == 4 && JSON.DEFAULT_TYPE_KEY.equals(lexer.stringVal()) && !defaultJSONParser.isEnabled(Feature.DisableSpecialKeyDetect)) {
                    lexer.nextTokenWithColon(4);
                    lexer.nextToken(16);
                    if (lexer.token() == 13) {
                        lexer.nextToken();
                        defaultJSONParser.setContext(context);
                        return map;
                    }
                    lexer.nextToken(deserializer.getFastMatchToken());
                }
                Object objDeserialze = deserializer.deserialze(defaultJSONParser, type, null);
                if (lexer.token() != 17) {
                    throw new JSONException("syntax error, expect :, actual " + lexer.token());
                }
                lexer.nextToken(deserializer2.getFastMatchToken());
                map.put(objDeserialze, deserializer2.deserialze(defaultJSONParser, type2, objDeserialze));
                if (lexer.token() == 16) {
                    lexer.nextToken(deserializer.getFastMatchToken());
                }
            } catch (Throwable th) {
                defaultJSONParser.setContext(context);
                throw th;
            }
        }
        lexer.nextToken(16);
        defaultJSONParser.setContext(context);
        return map;
    }

    protected Map<Object, Object> createMap(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            return createMap(((ParameterizedType) type).getRawType());
        }
        Class cls = (Class) type;
        if (cls.isInterface()) {
            throw new JSONException("unsupport type " + type);
        }
        try {
            return (Map) cls.newInstance();
        } catch (Exception e) {
            throw new JSONException("unsupport type " + type, e);
        }
    }
}
