package com.ubix.ssp.ad.e.a0.b0;

import android.app.Activity;
import com.byazt.hv.TTDownloadField;
import com.ubix.ssp.ad.e.a0.u;
import com.yfanads.android.qapp.Val;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f8630a;
        Activity b;
        boolean c;
        boolean d;
        boolean e;

        public String toString() {
            return "name=" + this.f8630a + ";activity" + this.b + ";isPause=" + this.c + ";isStop=" + this.d + ";isFinish=" + this.e;
        }
    }

    public static int a() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> cls = Class.forName(Val.AT);
        Method declaredMethod = cls.getDeclaredMethod(Val.CAT, new Class[0]);
        declaredMethod.setAccessible(true);
        Object objInvoke = declaredMethod.invoke(null, new Object[0]);
        if (objInvoke == null) {
            return -1;
        }
        String[] strArr = {"mActivities", "activities", "mActivitys"};
        int i = 1;
        for (int i2 = 0; i2 < 3; i2++) {
            try {
                Field declaredField = cls.getDeclaredField(strArr[i2]);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(objInvoke);
                if (obj instanceof Map) {
                    Map map = (Map) obj;
                    Iterator it = map.keySet().iterator();
                    while (it.hasNext()) {
                        a aVarA = a(map.get(it.next()));
                        u.e("ActivityInfo2=" + aVarA.toString());
                        if (!aVarA.c) {
                            i = 0;
                            break;
                        }
                    }
                }
            } catch (NoSuchFieldException unused) {
            }
        }
        return i;
    }

    private static a a(Object obj) throws IllegalAccessException {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        Class<?> cls = obj.getClass();
        try {
            Field declaredField = cls.getDeclaredField(TTDownloadField.TT_ACTIVITY);
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            u.e("activity activity=" + obj2);
            if (obj2 instanceof Activity) {
                aVar.b = (Activity) obj2;
                aVar.f8630a = obj2.getClass().getName();
                break;
            }
        } catch (NoSuchFieldException unused) {
            String[] strArr = {TTDownloadField.TT_ACTIVITY, "mActivity", "activityRef"};
            for (int i = 0; i < 3; i++) {
                try {
                    Field declaredField2 = cls.getDeclaredField(strArr[i]);
                    declaredField2.setAccessible(true);
                    Object obj3 = declaredField2.get(obj);
                    if (obj3 instanceof Activity) {
                        aVar.b = (Activity) obj3;
                        aVar.f8630a = obj3.getClass().getName();
                        break;
                    }
                    continue;
                } catch (NoSuchFieldException unused2) {
                }
            }
        }
        try {
            Field declaredField3 = cls.getDeclaredField("paused");
            declaredField3.setAccessible(true);
            aVar.c = declaredField3.getBoolean(obj);
            u.e("activity activity paused=" + aVar.c);
            break;
        } catch (NoSuchFieldException unused3) {
            String[] strArr2 = {"paused", "mPaused", "isPaused"};
            for (int i2 = 0; i2 < 3; i2++) {
                try {
                    Field declaredField4 = cls.getDeclaredField(strArr2[i2]);
                    declaredField4.setAccessible(true);
                    aVar.c = declaredField4.getBoolean(obj);
                    u.e("activity activity paused exc=" + aVar.c);
                    break;
                } catch (NoSuchFieldException unused4) {
                }
            }
        }
        try {
            Field declaredField5 = cls.getDeclaredField("stopped");
            declaredField5.setAccessible(true);
            aVar.d = declaredField5.getBoolean(obj);
            break;
        } catch (NoSuchFieldException unused5) {
            String[] strArr3 = {"stopped", "mStopped", "isStopped"};
            for (int i3 = 0; i3 < 3; i3++) {
                try {
                    Field declaredField6 = cls.getDeclaredField(strArr3[i3]);
                    declaredField6.setAccessible(true);
                    aVar.d = declaredField6.getBoolean(obj);
                    break;
                } catch (NoSuchFieldException unused6) {
                }
            }
        }
        try {
            Field declaredField7 = cls.getDeclaredField("finishing");
            declaredField7.setAccessible(true);
            aVar.e = declaredField7.getBoolean(obj);
        } catch (NoSuchFieldException unused7) {
        }
        return aVar;
    }
}
