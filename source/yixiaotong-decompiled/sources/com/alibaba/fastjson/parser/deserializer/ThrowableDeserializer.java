package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.util.TypeUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ThrowableDeserializer extends JavaBeanDeserializer {
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public ThrowableDeserializer(ParserConfig parserConfig, Class<?> cls) {
        super(parserConfig, cls);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0038  */
    @Override // com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer, com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Class<?> clsLoadClass;
        Object obj2;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() == 8) {
            lexer.nextToken();
            return null;
        }
        if (defaultJSONParser.getResolveStatus() == 2) {
            defaultJSONParser.setResolveStatus(0);
        } else if (lexer.token() != 12) {
            throw new JSONException("syntax error");
        }
        if (type == null || !(type instanceof Class)) {
            clsLoadClass = null;
        } else {
            clsLoadClass = (Class) type;
            if (!Throwable.class.isAssignableFrom(clsLoadClass)) {
                clsLoadClass = null;
            }
        }
        HashMap map = new HashMap();
        Throwable th = null;
        String strStringVal = null;
        StackTraceElement[] stackTraceElementArr = null;
        while (true) {
            String strScanSymbol = lexer.scanSymbol(defaultJSONParser.getSymbolTable());
            if (strScanSymbol == null) {
                if (lexer.token() == 13) {
                    lexer.nextToken(16);
                    break;
                }
                if (lexer.token() != 16 || !lexer.isEnabled(Feature.AllowArbitraryCommas)) {
                }
            }
            lexer.nextTokenWithColon(4);
            if (JSON.DEFAULT_TYPE_KEY.equals(strScanSymbol)) {
                if (lexer.token() == 4) {
                    clsLoadClass = TypeUtils.loadClass(lexer.stringVal());
                    lexer.nextToken(16);
                } else {
                    throw new JSONException("syntax error");
                }
            } else if (CrashHianalyticsData.MESSAGE.equals(strScanSymbol)) {
                if (lexer.token() == 8) {
                    strStringVal = null;
                } else if (lexer.token() == 4) {
                    strStringVal = lexer.stringVal();
                } else {
                    throw new JSONException("syntax error");
                }
                lexer.nextToken();
            } else if ("cause".equals(strScanSymbol)) {
                th = (Throwable) deserialze(defaultJSONParser, null, "cause");
            } else if ("stackTrace".equals(strScanSymbol)) {
                stackTraceElementArr = (StackTraceElement[]) defaultJSONParser.parseObject((Class) StackTraceElement[].class);
            } else {
                map.put(strScanSymbol, defaultJSONParser.parse());
            }
            if (lexer.token() == 13) {
                lexer.nextToken(16);
                break;
            }
        }
        if (clsLoadClass == null) {
            obj2 = (T) new Exception(strStringVal, th);
        } else {
            try {
                obj2 = (T) createException(strStringVal, th, clsLoadClass);
                if (obj2 == null) {
                    obj2 = (T) new Exception(strStringVal, th);
                }
            } catch (Exception e) {
                throw new JSONException("create instance error", e);
            }
        }
        if (stackTraceElementArr != null) {
            ((Throwable) obj2).setStackTrace(stackTraceElementArr);
        }
        return (T) obj2;
    }

    private Throwable createException(String str, Throwable th, Class<?> cls) throws Exception {
        Constructor<?> constructor = null;
        Constructor<?> constructor2 = null;
        Constructor<?> constructor3 = null;
        for (Constructor<?> constructor4 : cls.getConstructors()) {
            if (constructor4.getParameterTypes().length == 0) {
                constructor3 = constructor4;
            } else if (constructor4.getParameterTypes().length == 1 && constructor4.getParameterTypes()[0] == String.class) {
                constructor2 = constructor4;
            } else if (constructor4.getParameterTypes().length == 2 && constructor4.getParameterTypes()[0] == String.class && constructor4.getParameterTypes()[1] == Throwable.class) {
                constructor = constructor4;
            }
        }
        if (constructor != null) {
            return (Throwable) constructor.newInstance(str, th);
        }
        if (constructor2 != null) {
            return (Throwable) constructor2.newInstance(str);
        }
        if (constructor3 != null) {
            return (Throwable) constructor3.newInstance(new Object[0]);
        }
        return null;
    }
}
