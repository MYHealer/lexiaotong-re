package com.fancy.adsdk.lib.provider.arb;

import android.text.TextUtils;
import com.fancy.adsdk.lib.interf.Error;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ArbitraryManger {
    public static String[][] _a = {new String[]{"Y29tLndpbmRtaWxsLnNkay5jdXN0b20uV01DdXN0b21BZGFwdGVyUHJveHk=", "1"}, new String[]{"Y29tLmFueXRoaW5rLmNvcmUuYXBpLkFUSW5pdE1lZGlhdGlvbg==", "2"}, new String[]{"Y29tLmJ5dGVkYW5jZS5zZGsub3BlbmFkc2RrLm1lZGlhdGlvbi5icmlkZ2UuY3VzdG9tLk1lZGlhdGlvbkN1c3RvbUluaXRMb2FkZXI=", "3"}};
    public static volatile String[] _b = new String[0];
    public static final _a _c = new _a();
    public static final Object _d = new Object();
    public static final HashMap _e = new HashMap();
    private static String currentPlatform = "";

    public class _a implements _b {
        public static Object _a(Object obj, String str) {
            Class<?> type;
            if (obj == null) {
                return null;
            }
            try {
                if (str.length() == 0) {
                    return null;
                }
                String str2 = "." + str;
                for (Class<?> superclass = obj.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                    try {
                        for (Field field : superclass.getDeclaredFields()) {
                            if (field != null && (type = field.getType()) != null && (str.equals(type.getSimpleName()) || type.getName().endsWith(str2))) {
                                field.setAccessible(true);
                                Object obj2 = field.get(obj);
                                if (obj2 != null) {
                                    return obj2;
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
            } catch (Throwable unused2) {
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0072  */
        /* JADX WARN: Code duplicated, block: B:76:0x0105  */
        public final String _a(Object obj) {
            String str;
            String str2;
            Field declaredField;
            if (obj == null) {
                return null;
            }
            String str_a = com.fancy.adsdk.lib.utils._a._a("V2luZE1pbGxBZFJlcXVlc3Q=");
            String str_a2 = com.fancy.adsdk.lib.utils._a._a("Z2V0TG9hZElk");
            String str_a3 = com.fancy.adsdk.lib.utils._a._a("dGhpcyQw");
            String str_a4 = com.fancy.adsdk.lib.utils._a._a("dGhpcyQ=");
            if (obj instanceof Error) {
                ArrayDeque arrayDeque = new ArrayDeque();
                IdentityHashMap identityHashMap = new IdentityHashMap();
                arrayDeque.add(obj);
                while (!arrayDeque.isEmpty() && identityHashMap.size() < 64) {
                    Object objPoll = arrayDeque.poll();
                    if (objPoll != null && identityHashMap.put(objPoll, Boolean.TRUE) == null) {
                        Object obj_a = _a(objPoll, str_a);
                        if (obj_a == null || str_a2.length() == 0) {
                            str2 = null;
                        } else {
                            try {
                                Object objInvoke = obj_a.getClass().getMethod(str_a2, new Class[0]).invoke(obj_a, new Object[0]);
                                if (objInvoke instanceof String) {
                                    str2 = (String) objInvoke;
                                } else {
                                    str2 = null;
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            return str2;
                        }
                        try {
                            for (Class<?> superclass = objPoll.getClass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                                try {
                                    declaredField = superclass.getDeclaredField(str_a3);
                                } catch (Throwable unused2) {
                                    declaredField = null;
                                }
                                if (declaredField != null) {
                                    try {
                                        declaredField.setAccessible(true);
                                        Object obj2 = declaredField.get(objPoll);
                                        if (obj2 != null && obj2 != objPoll) {
                                            arrayDeque.add(obj2);
                                        }
                                    } catch (Throwable unused3) {
                                    }
                                }
                                for (Field field : superclass.getDeclaredFields()) {
                                    if (field != null && !Modifier.isStatic(field.getModifiers()) && (field.isSynthetic() || (field.getName() != null && field.getName().startsWith(str_a4)))) {
                                        field.setAccessible(true);
                                        Object obj3 = field.get(objPoll);
                                        if (obj3 != null && obj3 != objPoll) {
                                            arrayDeque.add(obj3);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused4) {
                        }
                    }
                }
            } else {
                Object obj_a2 = _a(obj, str_a);
                if (obj_a2 == null || str_a2.length() == 0) {
                    str = null;
                } else {
                    try {
                        Object objInvoke2 = obj_a2.getClass().getMethod(str_a2, new Class[0]).invoke(obj_a2, new Object[0]);
                        if (objInvoke2 instanceof String) {
                            str = (String) objInvoke2;
                        } else {
                            str = null;
                        }
                    } catch (Throwable unused5) {
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
            return null;
        }
    }

    public interface _b {
    }

    private ArbitraryManger() {
    }

    public static void addValue(String str, long j) {
        if (str == null || str.length() == 0 || getStrategy() == null) {
            return;
        }
        addValueInternal("1", str, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void addValueInternal(String str, String str2, long j) {
        synchronized (_d) {
            Map<String, ArrayList<Long>> platformMapLocked = getPlatformMapLocked(str, true);
            ArrayList<Long> arrayList = platformMapLocked.get(str2);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                platformMapLocked.put(str2, arrayList);
            }
            arrayList.add(Long.valueOf(j));
        }
    }

    public static void clear() {
        if (getStrategy() == null) {
            return;
        }
        clearInternal();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clearInternal() {
        synchronized (_d) {
            _e.clear();
        }
    }

    public static void forceSetCurrentPlatform(String str) {
        currentPlatform = str;
    }

    public static String getId(Object obj) {
        _b strategy = getStrategy();
        if (strategy == null) {
            return null;
        }
        return ((_a) strategy)._a(obj);
    }

    public static Long getMaV(String str) {
        if (str == null || str.length() == 0 || getStrategy() == null) {
            return null;
        }
        return getMaVInternal("1", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Long getMaVInternal(String str, String str2) {
        synchronized (_d) {
            Map<String, ArrayList<Long>> platformMapLocked = getPlatformMapLocked(str, false);
            if (platformMapLocked == null) {
                return null;
            }
            ArrayList<Long> arrayList = platformMapLocked.get(str2);
            if (arrayList != null && !arrayList.isEmpty()) {
                long jLongValue = arrayList.get(0).longValue();
                for (int i = 1; i < arrayList.size(); i++) {
                    long jLongValue2 = arrayList.get(i).longValue();
                    if (jLongValue2 > jLongValue) {
                        jLongValue = jLongValue2;
                    }
                }
                return Long.valueOf(jLongValue);
            }
            return null;
        }
    }

    public static Long getMiV(String str) {
        if (str == null || str.length() == 0 || getStrategy() == null) {
            return null;
        }
        return getMiVInternal("1", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Long getMiVInternal(String str, String str2) {
        synchronized (_d) {
            Map<String, ArrayList<Long>> platformMapLocked = getPlatformMapLocked(str, false);
            if (platformMapLocked == null) {
                return null;
            }
            ArrayList<Long> arrayList = platformMapLocked.get(str2);
            if (arrayList != null && !arrayList.isEmpty()) {
                long jLongValue = arrayList.get(0).longValue();
                for (int i = 1; i < arrayList.size(); i++) {
                    long jLongValue2 = arrayList.get(i).longValue();
                    if (jLongValue2 < jLongValue) {
                        jLongValue = jLongValue2;
                    }
                }
                return Long.valueOf(jLongValue);
            }
            return null;
        }
    }

    public static String getPlatform() {
        return currentPlatform;
    }

    public static String getPlatformList() {
        if (_b == null || _b.length <= 0) {
            return "";
        }
        try {
            return new JSONArray(_b).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    private static Map<String, ArrayList<Long>> getPlatformMapLocked(String str, boolean z) {
        HashMap map = _e;
        Map<String, ArrayList<Long>> map2 = (Map) map.get(str);
        if (map2 != null || !z) {
            return map2;
        }
        HashMap map3 = new HashMap();
        map.put(str, map3);
        return map3;
    }

    public static List<Long> getPriceList(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList();
        }
        synchronized (_d) {
            if (getStrategy() == null) {
                return new ArrayList();
            }
            Map<String, ArrayList<Long>> platformMapLocked = getPlatformMapLocked("1", false);
            if (platformMapLocked == null) {
                return new ArrayList();
            }
            ArrayList<Long> arrayList = platformMapLocked.get(str);
            if (arrayList == null) {
                return new ArrayList();
            }
            return new ArrayList(arrayList);
        }
    }

    private static _b getStrategy() {
        String str = currentPlatform;
        if (str == null || str.length() == 0 || !"1".equals(currentPlatform)) {
            return null;
        }
        return _c;
    }

    public static void identifyPlatform() {
        if (TextUtils.isEmpty(currentPlatform)) {
            ArrayList arrayList = new ArrayList();
            String[][] strArr = _a;
            String str = "";
            for (int i = 0; i < 3; i++) {
                String[] strArr2 = strArr[i];
                if (isClassPresent(com.fancy.adsdk.lib.utils._a._a(strArr2[0]))) {
                    arrayList.add(strArr2[1]);
                    if (TextUtils.isEmpty(str)) {
                        str = strArr2[1];
                    }
                }
            }
            _b = (String[]) arrayList.toArray(new String[0]);
            if (TextUtils.isEmpty(currentPlatform)) {
                setCurrentPlatform(str);
            }
        }
    }

    private static boolean isClassPresent(String str) {
        try {
            Class.forName(str, false, ArbitraryManger.class.getClassLoader());
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void remove(String str) {
        if (str == null || str.length() == 0 || getStrategy() == null) {
            return;
        }
        removeInternal("1", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void removeInternal(String str, String str2) {
        synchronized (_d) {
            Map<String, ArrayList<Long>> platformMapLocked = getPlatformMapLocked(str, false);
            if (platformMapLocked == null) {
                return;
            }
            platformMapLocked.remove(str2);
        }
    }

    public static void setCurrentPlatform(String str) {
        if (TextUtils.isEmpty(currentPlatform)) {
            currentPlatform = str;
        }
    }
}
