package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParseContext;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.FilterUtils;
import com.alibaba.fastjson.util.DeserializeBeanInfo;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private DeserializeBeanInfo beanInfo;
    private final Class<?> clazz;
    private final Map<String, FieldDeserializer> feildDeserializerMap;
    private final List<FieldDeserializer> fieldDeserializers;
    private final List<FieldDeserializer> sortedFieldDeserializers;

    public Class<?> getClazz() {
        return this.clazz;
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public int getFastMatchToken() {
        return 12;
    }

    public Map<String, FieldDeserializer> getFieldDeserializerMap() {
        return this.feildDeserializerMap;
    }

    public List<FieldDeserializer> getSortedFieldDeserializers() {
        return this.sortedFieldDeserializers;
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls) {
        this(parserConfig, cls, cls);
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this.feildDeserializerMap = new IdentityHashMap();
        this.fieldDeserializers = new ArrayList();
        this.sortedFieldDeserializers = new ArrayList();
        this.clazz = cls;
        DeserializeBeanInfo deserializeBeanInfoComputeSetters = DeserializeBeanInfo.computeSetters(cls, type);
        this.beanInfo = deserializeBeanInfoComputeSetters;
        Iterator<FieldInfo> it = deserializeBeanInfoComputeSetters.getFieldList().iterator();
        while (it.hasNext()) {
            addFieldDeserializer(parserConfig, cls, it.next());
        }
        Iterator<FieldInfo> it2 = this.beanInfo.getSortedFieldList().iterator();
        while (it2.hasNext()) {
            this.sortedFieldDeserializers.add(this.feildDeserializerMap.get(it2.next().getName().intern()));
        }
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        FieldDeserializer fieldDeserializer = this.feildDeserializerMap.get(str);
        if (fieldDeserializer != null) {
            return fieldDeserializer;
        }
        for (Map.Entry<String, FieldDeserializer> entry : this.feildDeserializerMap.entrySet()) {
            if (str.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private void addFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        String strIntern = fieldInfo.getName().intern();
        FieldDeserializer fieldDeserializerCreateFieldDeserializer = createFieldDeserializer(parserConfig, cls, fieldInfo);
        this.feildDeserializerMap.put(strIntern, fieldDeserializerCreateFieldDeserializer);
        this.fieldDeserializers.add(fieldDeserializerCreateFieldDeserializer);
    }

    public FieldDeserializer createFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        return parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject());
        }
        if (this.beanInfo.getDefaultConstructor() == null) {
            return null;
        }
        try {
            Constructor<?> defaultConstructor = this.beanInfo.getDefaultConstructor();
            Object objNewInstance = defaultConstructor.getParameterTypes().length == 0 ? defaultConstructor.newInstance(new Object[0]) : defaultConstructor.newInstance(defaultJSONParser.getContext().getObject());
            if (defaultJSONParser.isEnabled(Feature.InitStringFieldAsEmpty)) {
                for (FieldInfo fieldInfo : this.beanInfo.getFieldList()) {
                    if (fieldInfo.getFieldClass() == String.class) {
                        try {
                            fieldInfo.set(objNewInstance, "");
                        } catch (Exception e) {
                            throw new JSONException("create instance error, class " + this.clazz.getName(), e);
                        }
                    }
                }
            }
            return objNewInstance;
        } catch (Exception e2) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e2);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (lexer.token() != 14) {
            throw new JSONException("error");
        }
        T t = (T) createInstance(defaultJSONParser, type);
        int size = this.sortedFieldDeserializers.size();
        int i = 0;
        while (i < size) {
            char c = i == size + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers.get(i);
            Class<?> fieldClass = fieldDeserializer.getFieldClass();
            if (fieldClass == Integer.TYPE) {
                fieldDeserializer.setValue((Object) t, lexer.scanInt(c));
            } else if (fieldClass == String.class) {
                fieldDeserializer.setValue((Object) t, lexer.scanString(c));
            } else if (fieldClass == Long.TYPE) {
                fieldDeserializer.setValue(t, lexer.scanLong(c));
            } else if (fieldClass.isEnum()) {
                fieldDeserializer.setValue(t, lexer.scanEnum(fieldClass, defaultJSONParser.getSymbolTable(), c));
            } else {
                lexer.nextToken(14);
                fieldDeserializer.setValue(t, defaultJSONParser.parseObject(fieldDeserializer.getFieldType()));
                if (c == ']') {
                    if (lexer.token() != 15) {
                        throw new JSONException("syntax error");
                    }
                    lexer.nextToken(16);
                } else if (c == ',' && lexer.token() != 16) {
                    throw new JSONException("syntax error");
                }
            }
            i++;
        }
        lexer.nextToken(16);
        return t;
    }

    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) throws Throwable {
        Object obj3;
        if (type == JSON.class || type == JSONObject.class) {
            return (T) defaultJSONParser.parse();
        }
        JSONLexer lexer = defaultJSONParser.getLexer();
        ParseContext parseContext = null;
        if (lexer.token() == 8) {
            lexer.nextToken(16);
            return null;
        }
        ParseContext context = defaultJSONParser.getContext();
        if (obj2 != null && context != null) {
            context = context.getParentContext();
        }
        ParseContext parseContext2 = context;
        try {
            if (lexer.token() == 13) {
                lexer.nextToken(16);
                T t = obj2 == null ? (T) createInstance(defaultJSONParser, type) : (T) obj2;
                defaultJSONParser.setContext(parseContext2);
                return t;
            }
            if (lexer.token() == 14 && isSupportArrayToBean(lexer)) {
                T t2 = (T) deserialzeArrayMapping(defaultJSONParser, type, obj, obj2);
                defaultJSONParser.setContext(parseContext2);
                return t2;
            }
            if (lexer.token() != 12 && lexer.token() != 16) {
                StringBuffer stringBufferAppend = new StringBuffer("syntax error, expect {, actual ").append(lexer.tokenName()).append(", pos ").append(lexer.pos());
                if (obj instanceof String) {
                    stringBufferAppend.append(", fieldName ").append(obj);
                }
                throw new JSONException(stringBufferAppend.toString());
            }
            if (defaultJSONParser.getResolveStatus() == 2) {
                defaultJSONParser.setResolveStatus(0);
            }
            obj3 = obj2;
            HashMap map = null;
            ParseContext context2 = null;
            while (true) {
                try {
                    String strScanSymbol = lexer.scanSymbol(defaultJSONParser.getSymbolTable());
                    if (strScanSymbol == null) {
                        if (lexer.token() == 13) {
                            lexer.nextToken(16);
                            break;
                        }
                        if (lexer.token() != 16 || !defaultJSONParser.isEnabled(Feature.AllowArbitraryCommas)) {
                        }
                    }
                    if ("$ref" == strScanSymbol) {
                        lexer.nextTokenWithColon(4);
                        if (lexer.token() != 4) {
                            throw new JSONException("illegal ref, " + JSONToken.name(lexer.token()));
                        }
                        String strStringVal = lexer.stringVal();
                        if ("@".equals(strStringVal)) {
                            obj3 = (T) parseContext2.getObject();
                        } else if ("..".equals(strStringVal)) {
                            ParseContext parentContext = parseContext2.getParentContext();
                            if (parentContext.getObject() != null) {
                                obj3 = (T) parentContext.getObject();
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parentContext, strStringVal));
                                defaultJSONParser.setResolveStatus(1);
                            }
                        } else if ("$".equals(strStringVal)) {
                            ParseContext parentContext2 = parseContext2;
                            while (parentContext2.getParentContext() != null) {
                                parentContext2 = parentContext2.getParentContext();
                            }
                            if (parentContext2.getObject() != null) {
                                obj3 = (T) parentContext2.getObject();
                            } else {
                                defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parentContext2, strStringVal));
                                defaultJSONParser.setResolveStatus(1);
                            }
                        } else {
                            defaultJSONParser.addResolveTask(new DefaultJSONParser.ResolveTask(parseContext2, strStringVal));
                            defaultJSONParser.setResolveStatus(1);
                        }
                        lexer.nextToken(13);
                        if (lexer.token() != 13) {
                            throw new JSONException("illegal ref");
                        }
                        lexer.nextToken(16);
                        defaultJSONParser.setContext(parseContext2, obj3, obj);
                        if (context2 != null) {
                            context2.setObject(obj3);
                        }
                        defaultJSONParser.setContext(parseContext2);
                        return (T) obj3;
                    }
                    if (JSON.DEFAULT_TYPE_KEY == strScanSymbol) {
                        lexer.nextTokenWithColon(4);
                        if (lexer.token() != 4) {
                            throw new JSONException("syntax error");
                        }
                        String strStringVal2 = lexer.stringVal();
                        lexer.nextToken(16);
                        if (!(type instanceof Class) || !strStringVal2.equals(((Class) type).getName())) {
                            Type typeLoadClass = TypeUtils.loadClass(strStringVal2);
                            T t3 = (T) defaultJSONParser.getConfig().getDeserializer(typeLoadClass).deserialze(defaultJSONParser, typeLoadClass, obj);
                            if (context2 != null) {
                                context2.setObject(obj3);
                            }
                            defaultJSONParser.setContext(parseContext2);
                            return t3;
                        }
                        if (lexer.token() == 13) {
                            lexer.nextToken();
                            break;
                        }
                    } else {
                        if (obj3 == null && map == null) {
                            obj3 = (T) createInstance(defaultJSONParser, type);
                            if (obj3 == null) {
                                map = new HashMap(this.fieldDeserializers.size());
                            }
                            context2 = defaultJSONParser.setContext(parseContext2, obj3, obj);
                        }
                        Object obj4 = obj3;
                        HashMap map2 = map;
                        ParseContext parseContext3 = context2;
                        try {
                            if (parseField(defaultJSONParser, strScanSymbol, obj4, type, map2)) {
                                if (lexer.token() != 16) {
                                    if (lexer.token() == 13) {
                                        lexer.nextToken(16);
                                        obj3 = (T) obj4;
                                        map = map2;
                                        context2 = parseContext3;
                                        break;
                                    }
                                    if (lexer.token() == 18 || lexer.token() == 1) {
                                        throw new JSONException("syntax error, unexpect token " + JSONToken.name(lexer.token()));
                                    }
                                }
                                obj3 = (T) obj4;
                                map = map2;
                                context2 = parseContext3;
                            } else {
                                if (lexer.token() == 13) {
                                    lexer.nextToken();
                                    obj3 = (T) obj4;
                                    map = map2;
                                    context2 = parseContext3;
                                    break;
                                }
                                obj3 = (T) obj4;
                                map = map2;
                                context2 = parseContext3;
                            }
                        } catch (Throwable th) {
                            th = th;
                            obj3 = obj4;
                            parseContext = parseContext3;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parseContext = context2;
                }
            }
            if (obj3 == null) {
                if (map == null) {
                    T t4 = (T) createInstance(defaultJSONParser, type);
                    if (context2 == null) {
                        context2 = defaultJSONParser.setContext(parseContext2, t4, obj);
                    }
                    if (context2 != null) {
                        context2.setObject(t4);
                    }
                    defaultJSONParser.setContext(parseContext2);
                    return t4;
                }
                List<FieldInfo> fieldList = this.beanInfo.getFieldList();
                int size = fieldList.size();
                Object[] objArr = new Object[size];
                for (int i = 0; i < size; i++) {
                    objArr[i] = map.get(fieldList.get(i).getName());
                }
                if (this.beanInfo.getCreatorConstructor() != null) {
                    try {
                        obj3 = (T) this.beanInfo.getCreatorConstructor().newInstance(objArr);
                    } catch (Exception e) {
                        throw new JSONException("create instance error, " + this.beanInfo.getCreatorConstructor().toGenericString(), e);
                    }
                } else if (this.beanInfo.getFactoryMethod() != null) {
                    try {
                        obj3 = (T) this.beanInfo.getFactoryMethod().invoke(null, objArr);
                    } catch (Exception e2) {
                        throw new JSONException("create factory method error, " + this.beanInfo.getFactoryMethod().toString(), e2);
                    }
                }
                if (parseContext != null) {
                    parseContext.setObject(obj3);
                }
                defaultJSONParser.setContext(parseContext2);
                throw th;
            }
            if (context2 != null) {
                context2.setObject(obj3);
            }
            defaultJSONParser.setContext(parseContext2);
            return (T) obj3;
        } catch (Throwable th3) {
            th = th3;
            obj3 = obj2;
        }
    }

    public boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer lexer = defaultJSONParser.getLexer();
        FieldDeserializer value = this.feildDeserializerMap.get(str);
        if (value == null) {
            for (Map.Entry<String, FieldDeserializer> entry : this.feildDeserializerMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(str)) {
                    value = entry.getValue();
                    break;
                }
            }
        }
        if (value == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        lexer.nextTokenWithColon(value.getFastMatchToken());
        value.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        Object object;
        JSONLexer lexer = defaultJSONParser.getLexer();
        if (!lexer.isEnabled(Feature.IgnoreNotMatch)) {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
        lexer.nextTokenWithColon();
        Type extratype = FilterUtils.getExtratype(defaultJSONParser, obj, str);
        if (extratype == null) {
            object = defaultJSONParser.parse();
        } else {
            object = defaultJSONParser.parseObject(extratype);
        }
        FilterUtils.processExtra(defaultJSONParser, obj, str, object);
    }

    public final boolean isSupportArrayToBean(JSONLexer jSONLexer) {
        return Feature.isEnabled(this.beanInfo.getParserFeatures(), Feature.SupportArrayToBean) || jSONLexer.isEnabled(Feature.SupportArrayToBean);
    }
}
