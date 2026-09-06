package com.yfanads.android.libs.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ReflectUtils {

    public static class ReflectException extends Exception {
        private static final long serialVersionUID = -2504804697196582566L;

        public ReflectException() {
        }

        public ReflectException(String str) {
            super(str);
        }

        public ReflectException(String str, String str2) {
            super(str + "错误位置：" + str2);
        }

        public ReflectException(String str, String str2, Throwable th) {
            super(str + "错误位置：" + str2, th);
        }

        public ReflectException(String str, Throwable th) {
            super(str, th);
        }

        public ReflectException(Throwable th) {
            super(th);
        }
    }

    private static String getMethodName(String str) {
        return str.substring(0, str.indexOf(40));
    }

    private static boolean isMethod(String str) {
        return str.contains("(") && str.endsWith(")");
    }

    public static Object reflect(Object obj, String str) {
        return reflect(obj, str, (Object[]) null);
    }

    private static Object reflect(Object obj, String str, Object obj2) {
        str.substring(str.lastIndexOf(46));
        return str.contains("%") ? reflect(obj, str, new Object[]{obj2}) : reflect(obj, str, null, null, obj2);
    }

    private static Object reflect(Object obj, String str, Object[] objArr) {
        Class[] clsArr;
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr[i] = objArr[i].getClass();
            }
        } else {
            clsArr = null;
        }
        return reflect(obj, str, objArr, clsArr);
    }

    private static Object reflect(Object obj, String str, Object[] objArr, Object obj2) {
        Class[] clsArr;
        String strTrim = str.trim();
        if (objArr != null) {
            int length = objArr.length;
            Class[] clsArr2 = new Class[length];
            for (int i = 0; i < length; i++) {
                clsArr2[i] = objArr[i].getClass();
            }
            clsArr = clsArr2;
        } else {
            clsArr = null;
        }
        return reflect(obj, strTrim, objArr, clsArr, obj2, true);
    }

    private static Object reflect(Object obj, String str, Object[] objArr, Class[] clsArr) {
        return reflect(obj, str, objArr, clsArr, null, false);
    }

    private static Object reflect(Object obj, String str, Object[] objArr, Class[] clsArr, Object obj2) {
        return reflect(obj, str, objArr, clsArr, obj2, true);
    }

    private static Object reflect(Object obj, String str, Object[] objArr, Class[] clsArr, Object obj2, boolean z) throws ReflectException {
        int iIndexOf;
        Class<?> cls;
        Object[] objArr2;
        String str2;
        String str3;
        Class[] clsArr2;
        StringBuilder sb;
        StringBuilder sbAppend;
        String str4;
        String strSubstring = str;
        if (strSubstring.startsWith(".")) {
            strSubstring = strSubstring.substring(1, str.length());
        }
        if (obj == null) {
            int iIndexOf2 = strSubstring.indexOf(35);
            if (iIndexOf2 == -1) {
                iIndexOf2 = strSubstring.indexOf(46, strSubstring.lastIndexOf("$"));
            }
            if (iIndexOf2 == -1) {
                throw new ReflectException("处理静态类必须用#符号分割目标类，例如：android.app.ActivityThread#currentApplication()，或者使用$表示静态内部类，例如：com.abc$def.ghi。", strSubstring);
            }
            String strSubstring2 = strSubstring.substring(0, iIndexOf2);
            try {
                cls = Class.forName(strSubstring2);
                strSubstring = strSubstring.substring(iIndexOf2 + 1, strSubstring.length());
                iIndexOf = strSubstring.indexOf(46);
            } catch (ClassNotFoundException e) {
                throw new ReflectException("无法找到类：" + strSubstring2 + "。", strSubstring, e);
            }
        } else {
            iIndexOf = strSubstring.indexOf(46);
            cls = obj.getClass();
        }
        String str5 = strSubstring;
        String strSubstring3 = strSubstring.substring(iIndexOf + 1, strSubstring.length());
        String strSubstring4 = iIndexOf == -1 ? str5 : str5.substring(0, iIndexOf);
        String str6 = "无法在类：";
        if (!isMethod(strSubstring4)) {
            try {
                Field fieldReflectField = reflectField(cls, strSubstring4);
                if (!fieldReflectField.isAccessible()) {
                    fieldReflectField.setAccessible(true);
                }
                try {
                    Object obj3 = fieldReflectField.get(obj);
                    if (iIndexOf != -1) {
                        return reflect(obj3, strSubstring3, objArr, clsArr, obj2, z);
                    }
                    if (z) {
                        fieldReflectField.set(obj, obj2);
                    }
                    return obj3;
                } catch (IllegalAccessException e2) {
                    throw new ReflectException("类：" + cls + "的属性：" + strSubstring4 + "反射异常。", str5, e2);
                }
            } catch (NoSuchFieldException unused) {
                throw new ReflectException("无法在类：" + cls + "及其父类，找到属性：" + strSubstring4, str5);
            }
        }
        String methodName = getMethodName(strSubstring4);
        int iIndexOf3 = strSubstring4.indexOf(40) + 1;
        int iIndexOf4 = strSubstring4.indexOf(41);
        if (iIndexOf3 == iIndexOf4) {
            clsArr2 = null;
            str2 = strSubstring3;
            objArr2 = null;
            str3 = "无法在类：";
        } else {
            String[] strArrSplit = strSubstring4.substring(iIndexOf3, iIndexOf4).split(",");
            Class[] clsArr3 = new Class[strArrSplit.length];
            objArr2 = new Object[strArrSplit.length];
            if (objArr == null) {
                throw new ReflectException("检测到方法：" + methodName + "包含参数，但实际指定的参数为null。", str5);
            }
            if (objArr.length < strArrSplit.length) {
                throw new ReflectException("检测到方法：" + methodName + "包含" + strArrSplit.length + "个参数，但实际指定的参数长度不够：" + objArr.length + "。", str5);
            }
            if (clsArr == null) {
                throw new ReflectException("检测到方法：" + methodName + "包含参数，但实际指定的参数类型为null。", str5);
            }
            if (clsArr.length < strArrSplit.length) {
                throw new ReflectException("检测到方法：" + methodName + "包含" + strArrSplit.length + "个参数，但实际指定的参数类型长度不够：" + objArr.length + "。", str5);
            }
            int i = 0;
            while (i < strArrSplit.length) {
                int iIndexOf5 = strArrSplit[i].indexOf(37);
                String string = "(";
                String str7 = strSubstring3;
                String str8 = str6;
                for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                    if (i2 != 0) {
                        sb = new StringBuilder();
                        sbAppend = sb.append(string);
                        str4 = ",%";
                    } else {
                        sb = new StringBuilder();
                        sbAppend = sb.append(string);
                        str4 = "%";
                    }
                    string = sbAppend.append(str4).append(i2 + 1).toString();
                }
                String str9 = string + ")";
                if (iIndexOf5 == -1) {
                    throw new ReflectException("参数必须用%定义，参考写法：" + methodName + str9 + "。", str5);
                }
                String str10 = strArrSplit[i];
                String strSubstring5 = str10.substring(iIndexOf5 + 1, str10.length());
                try {
                    int i3 = Integer.parseInt(strSubstring5);
                    clsArr3[i] = clsArr[i3];
                    objArr2[i] = objArr[i3];
                    i++;
                    str6 = str8;
                    strSubstring3 = str7;
                } catch (NumberFormatException unused2) {
                    throw new ReflectException("参数解析错误，" + strSubstring5 + "无法转换为数字，参考写法：" + methodName + str9 + "。", str5);
                }
            }
            str2 = strSubstring3;
            str3 = str6;
            clsArr2 = clsArr3;
        }
        try {
            Method methodReflectMethod = reflectMethod(cls, methodName, clsArr2);
            if (!methodReflectMethod.isAccessible()) {
                methodReflectMethod.setAccessible(true);
            }
            Object objInvoke = methodReflectMethod.invoke(obj, objArr2);
            return iIndexOf == -1 ? objInvoke : reflect(objInvoke, str2, objArr, clsArr, obj2, z);
        } catch (IllegalAccessException e3) {
            throw new ReflectException("类：" + cls + "参数类型为" + Arrays.toString(clsArr2) + "的方法：" + methodName + "，调用异常的方法，", str5, e3);
        } catch (NoSuchMethodException unused3) {
            throw new ReflectException(str3 + cls + "及其父类，找到方法：" + methodName + "。", str5);
        } catch (InvocationTargetException unused4) {
            throw new ReflectException("在类：" + cls + "执行方法：" + methodName + "发生异常。", str5);
        }
    }

    private static Field reflectField(Class<?> cls, String str) throws NoSuchFieldException {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null) {
                return reflectField(superclass, str);
            }
            throw e;
        }
    }

    private static Method reflectMethod(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            Class<? super Object> superclass = cls.getSuperclass();
            if (superclass != null) {
                return reflectMethod(superclass, str, new Class[0]);
            }
            throw e;
        }
    }
}
