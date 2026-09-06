package com.alibaba.fastjson.util;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import client.android.yixiaotong.util.TimeUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.asm.ASMException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.ads.ez;
import com.umeng.analytics.pro.am;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class TypeUtils {
    public static boolean compatibleWithJavaBean = false;
    private static ConcurrentMap<String, Class<?>> mappings = null;
    private static boolean setAccessibleEnable = true;

    static {
        try {
            String property = System.getProperty("fastjson.compatibleWithJavaBean");
            if (ez.Code.equals(property)) {
                compatibleWithJavaBean = true;
            } else if (ez.V.equals(property)) {
                compatibleWithJavaBean = false;
            }
        } catch (Throwable unused) {
        }
        mappings = new ConcurrentHashMap();
        addBaseClassMappings();
    }

    public static final String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static final Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() != 1) {
                throw new JSONException("can not cast to byte, value : " + obj);
            }
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static final Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static final BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String string = obj.toString();
        if (string.length() == 0) {
            return null;
        }
        return new BigDecimal(string);
    }

    public static final BigInteger castToBigInteger(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String string = obj.toString();
        if (string.length() == 0) {
            return null;
        }
        return new BigInteger(string);
    }

    public static final Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(string));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static final Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String string = obj.toString();
            if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
                return null;
            }
            return Double.valueOf(Double.parseDouble(string));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static final Date castToDate(Object obj) {
        long j;
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (str2.indexOf(45) != -1) {
                if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                    str = JSON.DEFFAULT_DATE_FORMAT;
                } else if (str2.length() == 10) {
                    str = "yyyy-MM-dd";
                } else {
                    str = str2.length() == 19 ? TimeUtils.FORMATDATETIME : "yyyy-MM-dd HH:mm:ss.SSS";
                }
                try {
                    return new SimpleDateFormat(str).parse(str2);
                } catch (ParseException unused) {
                    throw new JSONException("can not cast to Date, value : " + str2);
                }
            }
            if (str2.length() == 0) {
                return null;
            }
            j = Long.parseLong(str2);
        } else {
            j = -1;
        }
        if (j < 0) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return new Date(j);
    }

    public static final java.sql.Date castToSqlDate(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            jLongValue = Long.parseLong(str);
        }
        if (jLongValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return new java.sql.Date(jLongValue);
    }

    public static final Timestamp castToTimestamp(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            jLongValue = Long.parseLong(str);
        }
        if (jLongValue <= 0) {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
        return new Timestamp(jLongValue);
    }

    public static final Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(str);
                Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static final Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(str));
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Base64.decodeFast((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static final Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (ez.Code.equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if (ez.V.equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            if ("1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static final <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.getGlobalInstance());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Object obj2;
        if (obj == 0) {
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls == obj.getClass()) {
            return obj;
        }
        if (obj instanceof Map) {
            if (cls == Map.class) {
                return obj;
            }
            Map map = (Map) obj;
            return (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) ? (T) castToJavaBean(map, cls, parserConfig) : obj;
        }
        if (cls.isArray()) {
            if (obj instanceof Collection) {
                Collection collection = (Collection) obj;
                T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                Iterator it = collection.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Array.set(t, i, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                    i++;
                }
                return t;
            }
            if (cls == byte[].class) {
                return (T) castToBytes(obj);
            }
        }
        if (cls.isAssignableFrom(obj.getClass())) {
            return obj;
        }
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            return (T) castToBoolean(obj);
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            return (T) castToByte(obj);
        }
        if (cls == Short.TYPE || cls == Short.class) {
            return (T) castToShort(obj);
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            return (T) castToInt(obj);
        }
        if (cls == Long.TYPE || cls == Long.class) {
            return (T) castToLong(obj);
        }
        if (cls == Float.TYPE || cls == Float.class) {
            return (T) castToFloat(obj);
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return (T) castToDouble(obj);
        }
        if (cls == String.class) {
            return (T) castToString(obj);
        }
        if (cls == BigDecimal.class) {
            return (T) castToBigDecimal(obj);
        }
        if (cls == BigInteger.class) {
            return (T) castToBigInteger(obj);
        }
        if (cls == Date.class) {
            return (T) castToDate(obj);
        }
        if (cls == java.sql.Date.class) {
            return (T) castToSqlDate(obj);
        }
        if (cls == Timestamp.class) {
            return (T) castToTimestamp(obj);
        }
        if (cls.isEnum()) {
            return (T) castToEnum(obj, cls, parserConfig);
        }
        if (Calendar.class.isAssignableFrom(cls)) {
            Date dateCastToDate = castToDate(obj);
            if (cls == Calendar.class) {
                obj2 = (T) Calendar.getInstance();
            } else {
                try {
                    obj2 = (T) ((Calendar) cls.newInstance());
                } catch (Exception e) {
                    throw new JSONException("can not cast to : " + cls.getName(), e);
                }
            }
            ((Calendar) obj2).setTime(dateCastToDate);
            return (T) obj2;
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        throw new JSONException("can not cast to : " + cls.getName());
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [T, java.lang.Enum] */
    public static final <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int iIntValue = ((Number) obj).intValue();
                for (Object obj2 : (Object[]) cls.getMethod("values", new Class[0]).invoke(null, new Object[0])) {
                    ?? r3 = (T) ((Enum) obj2);
                    if (r3.ordinal() == iIntValue) {
                        return r3;
                    }
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e) {
            throw new JSONException("can not cast to : " + cls.getName(), e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t = (T) new HashSet();
                } else if (rawType == TreeSet.class) {
                    t = (T) new TreeSet();
                } else {
                    t = (T) new ArrayList();
                }
                Iterator<T> it = ((Iterable) obj).iterator();
                while (it.hasNext()) {
                    ((Collection) t).add(cast(it.next(), type, parserConfig));
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r7 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r7.put(cast(entry.getKey(), type2, parserConfig), cast(entry.getValue(), type3, parserConfig));
                }
                return r7;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static final <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        JSONObject jSONObject;
        int iIntValue = 0;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get("className");
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number != null) {
                    iIntValue = number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValue);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                Class<?> clsLoadClass = loadClass(str4);
                if (clsLoadClass == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsLoadClass.equals(cls)) {
                    return (T) castToJavaBean(map, clsLoadClass, parserConfig);
                }
            }
            if (cls.isInterface()) {
                if (map instanceof JSONObject) {
                    jSONObject = (JSONObject) map;
                } else {
                    jSONObject = new JSONObject(map);
                }
                return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            Map<String, FieldDeserializer> fieldDeserializers = parserConfig.getFieldDeserializers(cls);
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            T tNewInstance = declaredConstructor.newInstance(new Object[0]);
            for (Map.Entry<String, FieldDeserializer> entry : fieldDeserializers.entrySet()) {
                String key = entry.getKey();
                FieldDeserializer value = entry.getValue();
                if (map.containsKey(key)) {
                    Object obj2 = map.get(key);
                    Method method = value.getMethod();
                    if (method != null) {
                        method.invoke(tNewInstance, cast(obj2, method.getGenericParameterTypes()[0], parserConfig));
                    } else {
                        Field field = value.getField();
                        field.set(tNewInstance, cast(obj2, field.getGenericType(), parserConfig));
                    }
                }
            }
            return tNewInstance;
        } catch (Exception e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public static void addClassMapping(String str, Class<?> cls) {
        if (str == null) {
            str = cls.getName();
        }
        mappings.put(str, cls);
    }

    public static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL, Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put(HashMap.class.getName(), HashMap.class);
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    public static Class<?> loadClass(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        Class<?> cls = mappings.get(str);
        if (cls != null) {
            return cls;
        }
        if (str.charAt(0) == '[') {
            return Array.newInstance(loadClass(str.substring(1)), 0).getClass();
        }
        if (str.startsWith("L") && str.endsWith(";")) {
            return loadClass(str.substring(1, str.length() - 1));
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                cls = contextClassLoader.loadClass(str);
                addClassMapping(str, cls);
                return cls;
            }
        } catch (Throwable unused) {
        }
        try {
            cls = Class.forName(str);
            addClassMapping(str, cls);
            return cls;
        } catch (Throwable unused2) {
            return cls;
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0241 A[PHI: r5
  0x0241: PHI (r5v16 java.lang.String) = (r5v15 java.lang.String), (r5v18 java.lang.String) binds: [B:118:0x0236, B:120:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:163:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:165:0x02f0 A[LOOP:3: B:164:0x02ee->B:165:0x02f0, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:166:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:169:0x030c A[LOOP:4: B:167:0x0306->B:169:0x030c, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:171:0x0318  */
    /* JADX WARN: Code duplicated, block: B:178:0x024c A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:77:0x0173 A[PHI: r7 r11 r12
  0x0173: PHI (r7v44 java.lang.String) = 
  (r7v43 java.lang.String)
  (r7v43 java.lang.String)
  (r7v43 java.lang.String)
  (r7v49 java.lang.String)
  (r7v51 java.lang.String)
 binds: [B:64:0x0139, B:66:0x0143, B:71:0x0161, B:73:0x0167, B:75:0x016f] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r11v12 int) = (r11v6 int), (r11v6 int), (r11v16 int), (r11v16 int), (r11v16 int) binds: [B:64:0x0139, B:66:0x0143, B:71:0x0161, B:73:0x0167, B:75:0x016f] A[DONT_GENERATE, DONT_INLINE]
  0x0173: PHI (r12v6 int) = (r12v2 int), (r12v2 int), (r12v10 int), (r12v10 int), (r12v10 int) binds: [B:64:0x0139, B:66:0x0143, B:71:0x0161, B:73:0x0167, B:75:0x016f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:79:0x0179  */
    /* JADX WARN: Code duplicated, block: B:85:0x019f  */
    /* JADX WARN: Instruction removed from duplicated block: B:163:0x02ec, please report this as an issue */
    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z) {
        String[] strArrOrders;
        boolean z2;
        Iterator it;
        int i;
        int i2;
        int i3;
        int iOrdinal;
        int iOf;
        String strSubstring;
        JSONField jSONField;
        String strDecapitalize;
        JSONField jSONField2;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (!Modifier.isStatic(method.getModifiers()) && !method.getReturnType().equals(Void.TYPE) && method.getParameterTypes().length == 0 && method.getReturnType() != ClassLoader.class && (!method.getName().equals("getMetaClass") || !method.getReturnType().getName().equals("groovy.lang.MetaClass"))) {
                JSONField supperMethodAnnotation = (JSONField) method.getAnnotation(JSONField.class);
                if (supperMethodAnnotation == null) {
                    supperMethodAnnotation = getSupperMethodAnnotation(cls, method);
                }
                if (supperMethodAnnotation == null) {
                    iOrdinal = 0;
                    iOf = 0;
                } else if (supperMethodAnnotation.serialize()) {
                    iOrdinal = supperMethodAnnotation.ordinal();
                    iOf = SerializerFeature.of(supperMethodAnnotation.serialzeFeatures());
                    if (supperMethodAnnotation.name().length() != 0) {
                        String strName = supperMethodAnnotation.name();
                        if (map == null || (strName = map.get(strName)) != null) {
                            String str = strName;
                            linkedHashMap.put(str, new FieldInfo(str, method, (Field) null, iOrdinal, iOf));
                        }
                    }
                }
                if (name.startsWith("get")) {
                    if (name.length() >= 4 && !name.equals("getClass")) {
                        char cCharAt = name.charAt(3);
                        if (Character.isUpperCase(cCharAt)) {
                            if (compatibleWithJavaBean) {
                                strDecapitalize = decapitalize(name.substring(3));
                            } else {
                                strDecapitalize = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                            }
                        } else if (cCharAt == '_') {
                            strDecapitalize = name.substring(4);
                        } else if (cCharAt == 'f') {
                            strDecapitalize = name.substring(3);
                        } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                            strDecapitalize = decapitalize(name.substring(3));
                        }
                        if (!isJSONTypeIgnore(cls, strDecapitalize)) {
                            Field field = ParserConfig.getField(cls, strDecapitalize);
                            if (field == null || (jSONField2 = (JSONField) field.getAnnotation(JSONField.class)) == null) {
                                int i4 = iOrdinal;
                                int i5 = iOf;
                                if (map != null || (strDecapitalize = map.get(strDecapitalize)) != null) {
                                    String str2 = strDecapitalize;
                                    iOrdinal = i4;
                                    iOf = i5;
                                    linkedHashMap.put(str2, new FieldInfo(str2, method, field, iOrdinal, iOf));
                                    if (!name.startsWith(am.ae)) {
                                    }
                                }
                            } else if (jSONField2.serialize()) {
                                iOrdinal = jSONField2.ordinal();
                                iOf = SerializerFeature.of(jSONField2.serialzeFeatures());
                                if (jSONField2.name().length() != 0) {
                                    strDecapitalize = jSONField2.name();
                                    if (map == null || (strDecapitalize = map.get(strDecapitalize)) != null) {
                                        int i6 = iOrdinal;
                                        int i7 = iOf;
                                        if (map != null) {
                                        }
                                        String str3 = strDecapitalize;
                                        iOrdinal = i6;
                                        iOf = i7;
                                        linkedHashMap.put(str3, new FieldInfo(str3, method, field, iOrdinal, iOf));
                                        if (!name.startsWith(am.ae)) {
                                        }
                                    }
                                } else {
                                    int i8 = iOrdinal;
                                    int i9 = iOf;
                                    if (map != null) {
                                    }
                                    String str4 = strDecapitalize;
                                    iOrdinal = i8;
                                    iOf = i9;
                                    linkedHashMap.put(str4, new FieldInfo(str4, method, field, iOrdinal, iOf));
                                    if (!name.startsWith(am.ae)) {
                                    }
                                }
                            }
                        }
                    }
                } else if (!name.startsWith(am.ae) && name.length() >= 3) {
                    char cCharAt2 = name.charAt(2);
                    if (Character.isUpperCase(cCharAt2)) {
                        if (compatibleWithJavaBean) {
                            strSubstring = decapitalize(name.substring(2));
                        } else {
                            strSubstring = Character.toLowerCase(name.charAt(2)) + name.substring(3);
                        }
                    } else if (cCharAt2 == '_') {
                        strSubstring = name.substring(3);
                    } else if (cCharAt2 == 'f') {
                        strSubstring = name.substring(2);
                    }
                    Field field2 = ParserConfig.getField(cls, strSubstring);
                    if (field2 == null) {
                        field2 = ParserConfig.getField(cls, name);
                    }
                    Field field3 = field2;
                    if (field3 == null || (jSONField = (JSONField) field3.getAnnotation(JSONField.class)) == null) {
                        if (map != null || (strSubstring = map.get(strSubstring)) != null) {
                            linkedHashMap.put(strSubstring, new FieldInfo(strSubstring, method, field3, iOrdinal, iOf));
                        }
                    } else if (jSONField.serialize()) {
                        int iOrdinal2 = jSONField.ordinal();
                        int iOf2 = SerializerFeature.of(jSONField.serialzeFeatures());
                        if (jSONField.name().length() != 0) {
                            strSubstring = jSONField.name();
                            if (map == null || (strSubstring = map.get(strSubstring)) != null) {
                            }
                        }
                        iOrdinal = iOrdinal2;
                        iOf = iOf2;
                        if (map != null) {
                            linkedHashMap.put(strSubstring, new FieldInfo(strSubstring, method, field3, iOrdinal, iOf));
                        } else {
                            linkedHashMap.put(strSubstring, new FieldInfo(strSubstring, method, field3, iOrdinal, iOf));
                        }
                    }
                }
            }
        }
        for (Field field4 : cls.getFields()) {
            if (!Modifier.isStatic(field4.getModifiers())) {
                JSONField jSONField3 = (JSONField) field4.getAnnotation(JSONField.class);
                String name2 = field4.getName();
                if (jSONField3 == null) {
                    i2 = 0;
                    i3 = 0;
                } else if (jSONField3.serialize()) {
                    int iOrdinal3 = jSONField3.ordinal();
                    int iOf3 = SerializerFeature.of(jSONField3.serialzeFeatures());
                    if (jSONField3.name().length() != 0) {
                        name2 = jSONField3.name();
                    }
                    i3 = iOf3;
                    i2 = iOrdinal3;
                }
                if (map == null || (name2 = map.get(name2)) != null) {
                    String str5 = name2;
                    if (!linkedHashMap.containsKey(str5)) {
                        linkedHashMap.put(str5, new FieldInfo(str5, (Method) null, field4, i2, i3));
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            strArrOrders = jSONType.orders();
            if (strArrOrders != null && strArrOrders.length == linkedHashMap.size()) {
                int length = strArrOrders.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        z2 = true;
                        break;
                    }
                    if (linkedHashMap.containsKey(strArrOrders[i10])) {
                        i10++;
                    }
                }
            }
            if (z2) {
                for (String str6 : strArrOrders) {
                    arrayList.add((FieldInfo) linkedHashMap.get(str6));
                }
            } else {
                it = linkedHashMap.values().iterator();
                while (it.hasNext()) {
                    arrayList.add((FieldInfo) it.next());
                }
                if (z) {
                    Collections.sort(arrayList);
                }
            }
            return arrayList;
        }
        strArrOrders = null;
        z2 = false;
        if (z2) {
            while (i < r3) {
                arrayList.add((FieldInfo) linkedHashMap.get(str6));
            }
        } else {
            it = linkedHashMap.values().iterator();
            while (it.hasNext()) {
                arrayList.add((FieldInfo) it.next());
            }
            if (z) {
                Collections.sort(arrayList);
            }
        }
        return arrayList;
    }

    public static JSONField getSupperMethodAnnotation(Class<?> cls, Method method) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Method method2 : cls2.getMethods()) {
                if (method2.getName().equals(method.getName()) && method2.getParameterTypes().length == method.getParameterTypes().length) {
                    int i = 0;
                    while (true) {
                        if (i < method2.getParameterTypes().length) {
                            if (!method2.getParameterTypes()[i].equals(method.getParameterTypes()[i])) {
                                break;
                            }
                            i++;
                        } else {
                            JSONField jSONField = (JSONField) method2.getAnnotation(JSONField.class);
                            if (jSONField == null) {
                                break;
                            }
                            return jSONField;
                        }
                    }
                }
            }
        }
        return null;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType != null) {
            String[] strArrIncludes = jSONType.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !isJSONTypeIgnore(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean isGenericParamType(Type type) {
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (type instanceof Class) {
            return isGenericParamType(((Class) type).getGenericSuperclass());
        }
        return false;
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static Type unwrap(Type type) {
        if (!(type instanceof GenericArrayType)) {
            return type;
        }
        Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
        if (genericComponentType == Byte.TYPE) {
            return byte[].class;
        }
        return genericComponentType == Character.TYPE ? char[].class : type;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        return Object.class;
    }

    public static Field getField(Class<?> cls, String str) {
        for (Field field : cls.getDeclaredFields()) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str);
    }

    public static JSONType getJSONType(Class<?> cls) {
        return (JSONType) cls.getAnnotation(JSONType.class);
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) cls.getAnnotation(JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                Class<?> cls = (Class) type2;
                if (Modifier.isPublic(cls.getModifiers())) {
                    return cls;
                }
                throw new ASMException("can not create ASMParser");
            }
            throw new ASMException("can not create ASMParser");
        }
        return Object.class;
    }
}
