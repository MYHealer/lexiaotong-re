package com.huawei.openalliance.ad.utils;

import android.text.TextUtils;
import com.huawei.hms.ads.fh;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class ad {
    private static final Map<Class, h> C;
    private static final char I = ',';
    private static final String Z = "__";
    private static final Class[] Code = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Character.class, Boolean.class};
    private static final Class[] V = {String.class, Object.class, Integer.class, Short.class, Long.class, Byte.class, Float.class, Double.class, Boolean.class};
    private static final String B = "ad";

    /* JADX INFO: renamed from: com.huawei.openalliance.ad.utils.ad$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class a implements h<Boolean, Object> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Boolean V(Object obj) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                return Boolean.valueOf(Boolean.parseBoolean((String) obj));
            }
            return null;
        }
    }

    private static class b implements h<Byte, Number> {
        private b() {
        }

        /* synthetic */ b(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Byte V(Number number) {
            return Byte.valueOf(number.byteValue());
        }
    }

    private static class c implements h<Double, Number> {
        private c() {
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Double V(Number number) {
            return Double.valueOf(number.doubleValue());
        }
    }

    private static class d implements h<Float, Number> {
        private d() {
        }

        /* synthetic */ d(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Float V(Number number) {
            return Float.valueOf(number.floatValue());
        }
    }

    private static class e implements h<Integer, Number> {
        private e() {
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Integer V(Number number) {
            return Integer.valueOf(number.intValue());
        }
    }

    private static class f implements h<Long, Number> {
        private f() {
        }

        /* synthetic */ f(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Long V(Number number) {
            return Long.valueOf(number.longValue());
        }
    }

    private static class g implements h<Short, Number> {
        private g() {
        }

        /* synthetic */ g(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.huawei.openalliance.ad.utils.ad.h
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public Short V(Number number) {
            return Short.valueOf(number.shortValue());
        }
    }

    interface h<D, S> {
        D V(S s);
    }

    static {
        HashMap map = new HashMap();
        C = map;
        AnonymousClass1 anonymousClass1 = null;
        e eVar = new e(anonymousClass1);
        map.put(Integer.TYPE, eVar);
        map.put(Integer.class, eVar);
        f fVar = new f(anonymousClass1);
        map.put(Long.TYPE, fVar);
        map.put(Long.class, fVar);
        d dVar = new d(anonymousClass1);
        map.put(Float.TYPE, dVar);
        map.put(Float.class, dVar);
        c cVar = new c(anonymousClass1);
        map.put(Double.TYPE, cVar);
        map.put(Double.class, cVar);
        g gVar = new g(anonymousClass1);
        map.put(Short.TYPE, gVar);
        map.put(Short.class, gVar);
        b bVar = new b(anonymousClass1);
        map.put(Byte.TYPE, bVar);
        map.put(Byte.class, bVar);
        a aVar = new a(anonymousClass1);
        map.put(Boolean.TYPE, aVar);
        map.put(Boolean.class, aVar);
    }

    private static Object Code(Class cls, Class cls2, Object obj) throws JSONException {
        if (V(cls)) {
            return Code(cls, obj);
        }
        if (List.class.isAssignableFrom(cls)) {
            return V(cls, cls2, obj);
        }
        if (Map.class.isAssignableFrom(cls)) {
            return Code(cls, cls2, null, obj);
        }
        if (obj instanceof JSONObject) {
            return Code((JSONObject) obj, cls, new Class[]{cls2});
        }
        if (obj instanceof JSONArray) {
            return Code((JSONArray) obj, cls, new Class[]{cls2});
        }
        throw Code("value from json error, field class: %s", cls);
    }

    private static Object Code(Class cls, Object obj) {
        h hVar;
        if (String.class == cls) {
            return bc.Code(obj);
        }
        if ((cls.isPrimitive() || Number.class.isAssignableFrom(cls)) && (obj instanceof Number)) {
            obj = (Number) obj;
            hVar = C.get(cls);
            if (hVar == null) {
                fh.I(B, "cannot find value reader for: %s", cls);
                return null;
            }
            return hVar.V(obj);
        }
        if (cls != Boolean.class) {
            return obj;
        }
        hVar = C.get(cls);
        if (hVar == null) {
            fh.I(B, "cannot find value reader for: %s", cls);
            return null;
        }
        return hVar.V(obj);
    }

    public static <T> T Code(String str, Class<T> cls, Class... clsArr) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            throw Code(false, "Input json string cannot be empty!", new Object[0]);
        }
        Code((Class) cls);
        return (T) I(str, cls, clsArr);
    }

    private static <T> T Code(JSONArray jSONArray, Class<T> cls, Class[] clsArr) throws JSONException {
        if (List.class.isAssignableFrom(cls)) {
            return (T) V(cls, (clsArr == null || clsArr.length <= 0) ? null : clsArr[0], jSONArray);
        }
        throw Code("Obj class (%s) is not List type", cls);
    }

    private static <T> T Code(JSONObject jSONObject, Class<T> cls, Class[] clsArr) throws JSONException {
        Class cls2;
        if (Collection.class.isAssignableFrom(cls)) {
            throw Code("Obj class %s is Collection type which mismatches with JsonObject", cls);
        }
        if (cls.isArray()) {
            throw Code("Obj class %s is array type which mismatches with JsonObject", cls);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            try {
                return (T) Code(jSONObject, cls.getConstructor(new Class[0]).newInstance(new Object[0]));
            } catch (Exception unused) {
                throw Code("New instance failed for %s", cls);
            }
        }
        Class cls3 = null;
        if (clsArr == null || clsArr.length <= 0) {
            cls2 = null;
        } else {
            Class cls4 = clsArr[0];
            cls2 = clsArr.length > 1 ? clsArr[1] : null;
            cls3 = cls4;
        }
        return (T) Code(cls, cls3, cls2, jSONObject);
    }

    private static <T> T Code(JSONObject jSONObject, T t) {
        Object objOpt;
        for (Field field : au.Code(t.getClass())) {
            Field fieldCode = au.Code(field, true);
            if (V(fieldCode) && (objOpt = jSONObject.opt(Code(fieldCode))) != null && JSONObject.NULL != objOpt) {
                Code(t, fieldCode, objOpt);
            }
        }
        return t;
    }

    public static <T> T Code(JSONObject jSONObject, String str) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            fh.Code(B, "%s is not exist or Json object is null", str);
            return null;
        }
        try {
            if (jSONObject.has(str)) {
                return (T) jSONObject.get(str);
            }
            return null;
        } catch (Throwable unused) {
            fh.I(B, "getFromJsonObject JSONException");
            return null;
        }
    }

    public static String Code(Object obj) throws JSONException {
        try {
            return Code(obj, false);
        } catch (IllegalAccessException unused) {
            throw Code("toJson error", new Object[0]);
        }
    }

    private static String Code(Object obj, boolean z) throws JSONException {
        if (obj == null) {
            return "";
        }
        Code((Class) obj.getClass());
        if (obj instanceof List) {
            return Code((List) obj, z);
        }
        return obj instanceof Map ? Code((Map) obj, z) : V(obj, z);
    }

    private static String Code(Field field) {
        com.huawei.openalliance.ad.annotations.c cVar = (com.huawei.openalliance.ad.annotations.c) field.getAnnotation(com.huawei.openalliance.ad.annotations.c.class);
        if (cVar != null && !TextUtils.isEmpty(cVar.Code())) {
            return cVar.Code();
        }
        String name = field.getName();
        return name.endsWith(Z) ? name.substring(0, name.length() - 2) : name;
    }

    private static String Code(List list, boolean z) {
        if (list.size() <= 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strI = I(list.get(i), z);
            if (strI != null) {
                sb.append(strI).append(I);
            }
        }
        Code(sb);
        sb.append(']');
        return sb.toString();
    }

    private static String Code(Map map, boolean z) {
        if (map.size() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        Set<Map.Entry> setEntrySet = map.entrySet();
        int size = setEntrySet.size();
        int i = 0;
        for (Map.Entry entry : setEntrySet) {
            i++;
            String str = (String) entry.getKey();
            String strI = I(entry.getValue(), z);
            if (strI != null) {
                sb.append(Typography.quote).append(str).append("\":");
                sb.append(strI);
            }
            if (i < size && strI != null) {
                sb.append(I);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private static Map Code(Class cls, Class cls2, Class cls3, Object obj) throws JSONException {
        Map linkedHashMap;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (cls3 == null) {
            cls3 = String.class;
        }
        if (!(obj instanceof JSONObject)) {
            throw Code("jsonVal not JSONObject", new Object[0]);
        }
        if (Map.class == cls) {
            linkedHashMap = new LinkedHashMap();
        } else {
            if (!Map.class.isAssignableFrom(cls)) {
                throw Code("%s is not Map type", cls);
            }
            try {
                linkedHashMap = (Map) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw Code("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw Code("Fail to initiate %s", cls);
            }
        }
        JSONObject jSONObject = (JSONObject) obj;
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objCode = Code(cls2, cls3, jSONObject.get(next));
            if (objCode != null) {
                if (cls2.isAssignableFrom(objCode.getClass())) {
                    linkedHashMap.put(next, objCode);
                } else {
                    fh.Z(B, "mapFromJson err, memberC:" + cls2 + ", valueC:" + objCode.getClass());
                }
            }
        }
        return linkedHashMap;
    }

    public static Map<String, String> Code(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(strTrim);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.get(next).toString().trim());
            }
            return map;
        } catch (JSONException unused) {
            return null;
        }
    }

    private static JSONException Code(String str, Object... objArr) {
        return Code(true, str, objArr);
    }

    private static JSONException Code(boolean z, String str, Object... objArr) {
        String str2 = String.format(Locale.ENGLISH, str, objArr);
        if (z) {
            fh.I(B, str2);
        }
        return new JSONException(str2);
    }

    private static void Code(Class cls) throws JSONException {
        if (cls.isPrimitive()) {
            throw Code("Root obj class (%s) cannot be primitive type!", cls);
        }
        int length = Code.length;
        for (int i = 0; i < length; i++) {
            if (cls == Code[i]) {
                throw Code("Root obj class (%s) is invalid", cls);
            }
        }
    }

    private static void Code(Object obj, Field field, Object obj2) {
        Object objCode = null;
        try {
            objCode = Code(field.getType(), au.Code(field), obj2);
            field.set(obj, objCode);
        } catch (RuntimeException unused) {
            fh.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
        } catch (Exception unused2) {
            fh.I(B, obj.getClass().getName() + ".fromJson error, fieldName: " + field.getName() + ", field:" + field);
            V(obj, field, objCode);
        }
    }

    private static void Code(StringBuilder sb) {
        int length = sb.length();
        if (length > 0) {
            int i = length - 1;
            if (sb.charAt(i) == ',') {
                sb.delete(i, length);
            }
        }
    }

    private static <T> T I(String str, Class<T> cls, Class[] clsArr) throws JSONException {
        try {
            try {
                return (T) Code(new JSONObject(str), cls, clsArr);
            } catch (JSONException unused) {
                throw Code("Input string is not valid json string!", new Object[0]);
            }
        } catch (JSONException unused2) {
            return (T) Code(new JSONArray(str), cls, clsArr);
        }
    }

    private static String I(Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof String) || (obj instanceof Character)) {
            return "\"" + bc.Z(obj.toString()) + "\"";
        }
        if (I(obj)) {
            return obj.toString();
        }
        if (obj instanceof List) {
            return Code((List) obj, z);
        }
        if (obj instanceof Map) {
            return Code((Map) obj, z);
        }
        return obj.getClass().isArray() ? Z(obj, z) : Code(obj, z);
    }

    private static boolean I(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Boolean) || (obj instanceof Float) || (obj instanceof Byte) || (obj instanceof Double) || (obj instanceof Short);
    }

    public static <T> T V(String str, Class<T> cls, Class... clsArr) {
        String str2;
        StringBuilder sb;
        try {
            if (bc.Code(str)) {
                return null;
            }
            return (T) Code(str, cls, clsArr);
        } catch (JSONException e2) {
            e = e2;
            str2 = B;
            sb = new StringBuilder("toObject ");
            fh.I(str2, sb.append(e.getClass().getSimpleName()).toString());
            return null;
        } catch (Exception e3) {
            e = e3;
            str2 = B;
            sb = new StringBuilder("toObject ");
            fh.I(str2, sb.append(e.getClass().getSimpleName()).toString());
            return null;
        }
    }

    public static String V(Object obj) {
        try {
            return Code(obj);
        } catch (JSONException unused) {
            fh.I(B, "toJson jsex");
            return "";
        }
    }

    private static String V(Object obj, boolean z) throws IllegalAccessException {
        Field[] fieldArrCode = au.Code(obj.getClass());
        if (fieldArrCode.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        int length = fieldArrCode.length;
        for (int i = 0; i < length; i++) {
            Field fieldCode = au.Code(fieldArrCode[i], true);
            fieldArrCode[i] = fieldCode;
            if (V(fieldCode)) {
                String strCode = Code(fieldArrCode[i]);
                Object obj2 = fieldArrCode[i].get(obj);
                String strI = (z && fieldArrCode[i].isAnnotationPresent(com.huawei.openalliance.ad.annotations.a.class)) ? obj2 != null ? "\"******\"" : null : I(obj2, z);
                if (strI != null) {
                    sb.append(Typography.quote).append(strCode).append("\":").append(strI);
                    if (i < length - 1) {
                        sb.append(I);
                    }
                }
            }
        }
        Code(sb);
        sb.append('}');
        return sb.toString();
    }

    private static List V(Class cls, Class cls2, Object obj) throws JSONException {
        List arrayList;
        if (cls2 == null) {
            cls2 = String.class;
        }
        if (!(obj instanceof JSONArray)) {
            throw Code("jsonobj is not JSONArray", new Object[0]);
        }
        if (cls == List.class) {
            arrayList = new ArrayList();
        } else {
            if (!List.class.isAssignableFrom(cls)) {
                throw Code("%s is not List type", cls);
            }
            try {
                arrayList = (List) cls.newInstance();
            } catch (IllegalAccessException unused) {
                throw Code("Fail to initiate %s", cls);
            } catch (InstantiationException unused2) {
                throw Code("Fail to initiate %s", cls);
            }
        }
        JSONArray jSONArray = (JSONArray) obj;
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            Object objCode = Code(cls2, (Class) null, jSONArray.get(i));
            if (objCode != null) {
                if (cls2.isAssignableFrom(objCode.getClass())) {
                    arrayList.add(objCode);
                } else {
                    fh.Z(B, "listFromJson error, memberC:" + cls2 + ", valueC:" + objCode.getClass());
                }
            }
        }
        return arrayList;
    }

    private static void V(Object obj, Field field, Object obj2) {
        Object objValueOf;
        if (obj2 == null || !(obj2 instanceof String)) {
            return;
        }
        try {
            Class<?> type = field.getType();
            if (type.isPrimitive()) {
                if (Integer.TYPE == type) {
                    objValueOf = Integer.valueOf(Integer.parseInt((String) obj2));
                } else if (Float.TYPE == type) {
                    objValueOf = Float.valueOf(Float.parseFloat((String) obj2));
                } else if (Long.TYPE == type) {
                    objValueOf = Long.valueOf(Long.parseLong((String) obj2));
                } else if (Boolean.TYPE == type) {
                    objValueOf = Boolean.valueOf(Boolean.parseBoolean((String) obj2));
                } else if (Double.TYPE == type) {
                    objValueOf = Double.valueOf(Double.parseDouble((String) obj2));
                } else if (Short.TYPE == type) {
                    objValueOf = Short.valueOf(Short.parseShort((String) obj2));
                } else if (Byte.TYPE == type) {
                    objValueOf = Byte.valueOf(Byte.parseByte((String) obj2));
                } else if (Character.TYPE != type) {
                    return;
                } else {
                    objValueOf = Character.valueOf(((String) obj2).charAt(0));
                }
                field.set(obj, objValueOf);
            }
        } catch (Throwable unused) {
            fh.Z(B, "processValueError");
        }
    }

    private static boolean V(Class cls) {
        if (cls.isPrimitive()) {
            return true;
        }
        int length = V.length;
        for (int i = 0; i < length; i++) {
            if (cls == V[i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean V(Field field) {
        if (field == null) {
            return false;
        }
        String name = field.getName();
        return (Modifier.isStatic(field.getModifiers()) || name == null || name.contains("$") || field.isAnnotationPresent(com.huawei.openalliance.ad.annotations.d.class)) ? false : true;
    }

    private static String Z(Object obj, boolean z) {
        int length = Array.getLength(obj);
        if (length <= 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < length; i++) {
            String strI = I(Array.get(obj, i), z);
            if (strI != null) {
                sb.append(strI).append(I);
            }
        }
        Code(sb);
        sb.append(']');
        return sb.toString();
    }
}
