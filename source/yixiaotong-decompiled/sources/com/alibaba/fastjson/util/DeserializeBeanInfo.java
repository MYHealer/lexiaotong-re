package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.annotation.JSONCreator;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.umeng.analytics.pro.am;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeserializeBeanInfo {
    private final Class<?> clazz;
    private Constructor<?> creatorConstructor;
    private Constructor<?> defaultConstructor;
    private Method factoryMethod;
    private int parserFeatures;
    private final List<FieldInfo> fieldList = new ArrayList();
    private final List<FieldInfo> sortedFieldList = new ArrayList();

    public Class<?> getClazz() {
        return this.clazz;
    }

    public Constructor<?> getCreatorConstructor() {
        return this.creatorConstructor;
    }

    public Constructor<?> getDefaultConstructor() {
        return this.defaultConstructor;
    }

    public Method getFactoryMethod() {
        return this.factoryMethod;
    }

    public List<FieldInfo> getFieldList() {
        return this.fieldList;
    }

    public int getParserFeatures() {
        return this.parserFeatures;
    }

    public List<FieldInfo> getSortedFieldList() {
        return this.sortedFieldList;
    }

    public void setCreatorConstructor(Constructor<?> constructor) {
        this.creatorConstructor = constructor;
    }

    public void setDefaultConstructor(Constructor<?> constructor) {
        this.defaultConstructor = constructor;
    }

    public void setFactoryMethod(Method method) {
        this.factoryMethod = method;
    }

    public DeserializeBeanInfo(Class<?> cls) {
        this.parserFeatures = 0;
        this.clazz = cls;
        this.parserFeatures = TypeUtils.getParserFeatures(cls);
    }

    public FieldInfo getField(String str) {
        for (FieldInfo fieldInfo : this.fieldList) {
            if (fieldInfo.getName().equals(str)) {
                return fieldInfo;
            }
        }
        return null;
    }

    public boolean add(FieldInfo fieldInfo) {
        for (FieldInfo fieldInfo2 : this.fieldList) {
            if (fieldInfo2.getName().equals(fieldInfo.getName()) && (!fieldInfo2.isGetOnly() || fieldInfo.isGetOnly())) {
                if (!fieldInfo2.getFieldClass().isAssignableFrom(fieldInfo.getFieldClass())) {
                    return false;
                }
                this.fieldList.remove(fieldInfo2);
                break;
            }
        }
        this.fieldList.add(fieldInfo);
        this.sortedFieldList.add(fieldInfo);
        Collections.sort(this.sortedFieldList);
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x02b7  */
    public static DeserializeBeanInfo computeSetters(Class<?> cls, Type type) {
        JSONField jSONField;
        JSONField jSONField2;
        int i;
        String strName;
        String str;
        int i2;
        int i3;
        int iOrdinal;
        int iOf;
        String strDecapitalize;
        int iOrdinal2;
        int iOf2;
        JSONField jSONField3;
        DeserializeBeanInfo deserializeBeanInfo = new DeserializeBeanInfo(cls);
        Constructor<?> defaultConstructor = getDefaultConstructor(cls);
        int i4 = 0;
        if (defaultConstructor != null) {
            TypeUtils.setAccessible(defaultConstructor);
            deserializeBeanInfo.setDefaultConstructor(defaultConstructor);
        } else if (defaultConstructor == null && !cls.isInterface() && !Modifier.isAbstract(cls.getModifiers())) {
            Constructor<?> creatorConstructor = getCreatorConstructor(cls);
            if (creatorConstructor != null) {
                TypeUtils.setAccessible(creatorConstructor);
                deserializeBeanInfo.setCreatorConstructor(creatorConstructor);
                for (int i5 = 0; i5 < creatorConstructor.getParameterTypes().length; i5++) {
                    Annotation[] annotationArr = creatorConstructor.getParameterAnnotations()[i5];
                    int length = annotationArr.length;
                    int i6 = 0;
                    while (true) {
                        if (i6 >= length) {
                            jSONField2 = null;
                            break;
                        }
                        Annotation annotation = annotationArr[i6];
                        if (annotation instanceof JSONField) {
                            jSONField2 = (JSONField) annotation;
                            break;
                        }
                        i6++;
                    }
                    if (jSONField2 == null) {
                        throw new JSONException("illegal json creator");
                    }
                    deserializeBeanInfo.add(new FieldInfo(jSONField2.name(), cls, creatorConstructor.getParameterTypes()[i5], creatorConstructor.getGenericParameterTypes()[i5], TypeUtils.getField(cls, jSONField2.name()), jSONField2.ordinal(), SerializerFeature.of(jSONField2.serialzeFeatures())));
                }
                return deserializeBeanInfo;
            }
            Method factoryMethod = getFactoryMethod(cls);
            if (factoryMethod != null) {
                TypeUtils.setAccessible(factoryMethod);
                deserializeBeanInfo.setFactoryMethod(factoryMethod);
                for (int i7 = 0; i7 < factoryMethod.getParameterTypes().length; i7++) {
                    Annotation[] annotationArr2 = factoryMethod.getParameterAnnotations()[i7];
                    int length2 = annotationArr2.length;
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            jSONField = null;
                            break;
                        }
                        Annotation annotation2 = annotationArr2[i8];
                        if (annotation2 instanceof JSONField) {
                            jSONField = (JSONField) annotation2;
                            break;
                        }
                        i8++;
                    }
                    if (jSONField == null) {
                        throw new JSONException("illegal json creator");
                    }
                    deserializeBeanInfo.add(new FieldInfo(jSONField.name(), cls, factoryMethod.getParameterTypes()[i7], factoryMethod.getGenericParameterTypes()[i7], TypeUtils.getField(cls, jSONField.name()), jSONField.ordinal(), SerializerFeature.of(jSONField.serialzeFeatures())));
                }
                return deserializeBeanInfo;
            }
            throw new JSONException("default constructor not found. " + cls);
        }
        Method[] methods = cls.getMethods();
        int length3 = methods.length;
        int i9 = 0;
        while (true) {
            i = 1;
            if (i9 >= length3) {
                break;
            }
            Method method = methods[i9];
            String name = method.getName();
            if (name.length() >= 4 && !Modifier.isStatic(method.getModifiers()) && ((method.getReturnType().equals(Void.TYPE) || method.getReturnType().equals(cls)) && method.getParameterTypes().length == 1)) {
                JSONField supperMethodAnnotation = (JSONField) method.getAnnotation(JSONField.class);
                if (supperMethodAnnotation == null) {
                    supperMethodAnnotation = TypeUtils.getSupperMethodAnnotation(cls, method);
                }
                if (supperMethodAnnotation == null) {
                    iOrdinal = 0;
                    iOf = 0;
                } else if (supperMethodAnnotation.deserialize()) {
                    iOrdinal = supperMethodAnnotation.ordinal();
                    iOf = SerializerFeature.of(supperMethodAnnotation.serialzeFeatures());
                    if (supperMethodAnnotation.name().length() != 0) {
                        deserializeBeanInfo.add(new FieldInfo(supperMethodAnnotation.name(), method, (Field) null, cls, type, iOrdinal, iOf));
                        TypeUtils.setAccessible(method);
                    }
                }
                if (name.startsWith("set")) {
                    char cCharAt = name.charAt(3);
                    if (Character.isUpperCase(cCharAt)) {
                        if (TypeUtils.compatibleWithJavaBean) {
                            strDecapitalize = TypeUtils.decapitalize(name.substring(3));
                        } else {
                            strDecapitalize = Character.toLowerCase(name.charAt(3)) + name.substring(4);
                        }
                    } else if (cCharAt == '_') {
                        strDecapitalize = name.substring(4);
                    } else if (cCharAt == 'f') {
                        strDecapitalize = name.substring(3);
                    } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                        strDecapitalize = TypeUtils.decapitalize(name.substring(3));
                    }
                    String str2 = strDecapitalize;
                    Field field = TypeUtils.getField(cls, str2);
                    if (field == null && method.getParameterTypes()[0] == Boolean.TYPE) {
                        field = TypeUtils.getField(cls, am.ae + Character.toUpperCase(str2.charAt(0)) + str2.substring(1));
                    }
                    Field field2 = field;
                    if (field2 == null || (jSONField3 = (JSONField) field2.getAnnotation(JSONField.class)) == null) {
                        iOrdinal2 = iOrdinal;
                        iOf2 = iOf;
                    } else {
                        iOrdinal2 = jSONField3.ordinal();
                        iOf2 = SerializerFeature.of(jSONField3.serialzeFeatures());
                        if (jSONField3.name().length() != 0) {
                            deserializeBeanInfo.add(new FieldInfo(jSONField3.name(), method, field2, cls, type, iOrdinal2, iOf2));
                        }
                    }
                    deserializeBeanInfo.add(new FieldInfo(str2, method, (Field) null, cls, type, iOrdinal2, iOf2));
                    TypeUtils.setAccessible(method);
                }
            }
            i9++;
        }
        Field[] fields = cls.getFields();
        int length4 = fields.length;
        int i10 = 0;
        while (i10 < length4) {
            Field field3 = fields[i10];
            if (!Modifier.isStatic(field3.getModifiers())) {
                Iterator<FieldInfo> it = deserializeBeanInfo.getFieldList().iterator();
                int i11 = i4;
                while (it.hasNext()) {
                    if (it.next().getName().equals(field3.getName())) {
                        i11 = i;
                    }
                }
                if (i11 == 0) {
                    String name2 = field3.getName();
                    JSONField jSONField4 = (JSONField) field3.getAnnotation(JSONField.class);
                    if (jSONField4 != null) {
                        int iOrdinal3 = jSONField4.ordinal();
                        int iOf3 = SerializerFeature.of(jSONField4.serialzeFeatures());
                        if (jSONField4.name().length() != 0) {
                            name2 = jSONField4.name();
                        }
                        str = name2;
                        i2 = iOrdinal3;
                        i3 = iOf3;
                    } else {
                        str = name2;
                        i2 = i4;
                        i3 = i2;
                    }
                    deserializeBeanInfo.add(new FieldInfo(str, (Method) null, field3, cls, type, i2, i3));
                }
            }
            i10++;
            i = i;
            i4 = 0;
        }
        for (Method method2 : cls.getMethods()) {
            String name3 = method2.getName();
            if (name3.length() >= 4 && !Modifier.isStatic(method2.getModifiers()) && name3.startsWith("get") && Character.isUpperCase(name3.charAt(3)) && method2.getParameterTypes().length == 0 && (Collection.class.isAssignableFrom(method2.getReturnType()) || Map.class.isAssignableFrom(method2.getReturnType()) || AtomicBoolean.class == method2.getReturnType() || AtomicInteger.class == method2.getReturnType() || AtomicLong.class == method2.getReturnType())) {
                JSONField jSONField5 = (JSONField) method2.getAnnotation(JSONField.class);
                if (jSONField5 != null && jSONField5.name().length() > 0) {
                    strName = jSONField5.name();
                } else {
                    strName = Character.toLowerCase(name3.charAt(3)) + name3.substring(4);
                }
                String str3 = strName;
                if (deserializeBeanInfo.getField(str3) == null) {
                    deserializeBeanInfo.add(new FieldInfo(str3, method2, (Field) null, cls, type));
                    TypeUtils.setAccessible(method2);
                }
            }
        }
        return deserializeBeanInfo;
    }

    public static Constructor<?> getDefaultConstructor(Class<?> cls) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        for (Constructor<?> constructor2 : cls.getDeclaredConstructors()) {
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : cls.getDeclaredConstructors()) {
            if (constructor3.getParameterTypes().length == 1 && constructor3.getParameterTypes()[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Constructor<?> getCreatorConstructor(Class<?> cls) {
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            if (((JSONCreator) constructor.getAnnotation(JSONCreator.class)) != null) {
                return constructor;
            }
        }
        return null;
    }

    public static Method getFactoryMethod(Class<?> cls) {
        for (Method method : cls.getDeclaredMethods()) {
            if (Modifier.isStatic(method.getModifiers()) && cls.isAssignableFrom(method.getReturnType()) && ((JSONCreator) method.getAnnotation(JSONCreator.class)) != null) {
                return method;
            }
        }
        return null;
    }
}
