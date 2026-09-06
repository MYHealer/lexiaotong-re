package com.ubixnow.ooooo;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO0O0Oo0 {
    public static final String OooO00o = "101000001100001010100000110010011010000011000100101000001100010010100000110010011010000011001110101000001100011110100000111111111010000011010010101000001100100110100000110101001010000011111111101000001100001110100000110100001010000011001101";
    private static final int OooO0O0 = 7;
    public String OooO0OO;
    public String OooO0Oo;

    private double OooO00o() {
        try {
            if (TextUtils.isEmpty(this.OooO0OO)) {
                return 0.0d;
            }
            return new JSONObject(this.OooO0OO).optDouble(this.OooO0Oo);
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    private void OooO00o(Set<Object> set, Set<String> set2, Object obj, int i) {
        if (i > 7) {
            return;
        }
        try {
            if (obj.getClass().getName().contains("com.by")) {
                set.add(obj);
                Class<?> superclass = obj.getClass();
                do {
                    OooO00o(set, set2, obj, superclass.getDeclaredFields(), i);
                    superclass = superclass.getSuperclass();
                    if (superclass == null) {
                        return;
                    }
                } while (superclass.getName().contains("com.by"));
            }
        } catch (Throwable unused) {
        }
    }

    private void OooO00o(Set<Object> set, Set<String> set2, Object obj, Field[] fieldArr, int i) {
        if (i <= 7 && fieldArr != null) {
            try {
                if (this.OooO0OO == null) {
                    for (Field field : fieldArr) {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null && !set.contains(obj2)) {
                            if (obj2 instanceof String) {
                                set2.add((String) obj2);
                                if (((String) obj2).contains(this.OooO0Oo)) {
                                    this.OooO0OO = (String) obj2;
                                    return;
                                }
                            } else if (obj2.getClass().equals(CopyOnWriteArrayList.class)) {
                                CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) obj2;
                                int iMin = Math.min(copyOnWriteArrayList.size(), 20);
                                for (int i2 = 0; i2 < iMin; i2++) {
                                    OooO00o(set, set2, copyOnWriteArrayList.get(i2), i + 1);
                                }
                            } else {
                                OooO00o(set, set2, obj2, i + 1);
                            }
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public double OooO00o(Object obj) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        try {
            this.OooO0Oo = oOo0o0oO.OooO00o(OooO00o);
            hashSet.add(obj);
            OooO00o(hashSet, hashSet2, obj, obj.getClass().getDeclaredFields(), 0);
            hashSet.clear();
            hashSet2.clear();
            return OooO00o();
        } catch (Throwable unused) {
            return 0.0d;
        }
    }
}
