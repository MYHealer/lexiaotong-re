package com.qq.e.comm.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Boolean> f8514a = new HashMap();

    private static String a(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append("#").append(str);
        for (Class cls2 : clsArr) {
            sb.append("_").append(cls2.getName());
        }
        return sb.toString();
    }

    private static boolean b(Class cls, String str, Class... clsArr) {
        String strA = a(cls, str, clsArr);
        Map<String, Boolean> map = f8514a;
        Boolean bool = map.get(strA);
        if (bool != null) {
            return Boolean.TRUE.equals(bool);
        }
        try {
            cls.getDeclaredMethod(str, clsArr);
            map.put(strA, Boolean.TRUE);
            return true;
        } catch (NoSuchMethodException unused) {
            f8514a.put(strA, Boolean.FALSE);
            return false;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderFail", new Class[0]);
    }

    public static boolean b(Object obj) {
        if (obj == null) {
            return false;
        }
        return b(obj.getClass(), "onRenderSuccess", new Class[0]);
    }
}
