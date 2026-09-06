package com.miui.zeus.mimo.sdk;

import android.os.Build;
import com.google.common.base.Ascii;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class v6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5644a = ijiami_1011.s.s.s.d(new byte[]{Ascii.DC2, 82}, "ddfea7");

    public static Field a(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new NoSuchFieldException(ijiami_1011.s.s.s.d(new byte[]{32, 12, 87, 84, 5, Ascii.DC4}, "fe28a4") + str + ijiami_1011.s.s.s.d(new byte[]{70, 86, 91, 71, 65, 0, 14, 17, 8, 6, 17, 12, 8, Ascii.CAN}, "f843af") + obj.getClass());
    }

    public static Method a(Object obj, String str, Class<?>... clsArr) {
        Class<?> cls = obj.getClass();
        if (cls == null) {
            throw new NoSuchMethodException(ijiami_1011.s.s.s.d(new byte[]{121, 80, 65, 14, 11, 0, 65}, "455fdd") + str + ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, Ascii.DC2, 88, Ascii.SYN, 9, Ascii.DC4, 17, 5, Ascii.DC4, 3, 92, 0, 66, 0, 67, 17, 65}, "6e1ba4") + Arrays.asList(clsArr) + ijiami_1011.s.s.s.d(new byte[]{65, 88, 86, 71, Ascii.SYN, 95, 14, 17, 8, 6, 17, 12, 15, Ascii.SYN}, "a69369") + obj.getClass());
        }
        Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
        if (!declaredMethod.isAccessible()) {
            declaredMethod.setAccessible(true);
        }
        return declaredMethod;
    }

    public static synchronized void a(ClassLoader classLoader, File file) {
        if (file != null) {
            try {
                if (file.exists()) {
                    try {
                        b.a(classLoader, file);
                    } catch (Throwable th) {
                        m.e(f5644a, ijiami_1011.s.s.s.d(new byte[]{11, 87, 66, 76, 86, 13, 13, 55, 9, 50, 80, 17, 10, Ascii.NAK, 17, 78, 5, 84, 65, 2, 7, 11, 93, 73, 66, 74, 85, 83, 13, 65, 77}, "b9187a") + Build.VERSION.SDK_INT + ijiami_1011.s.s.s.d(new byte[]{67, 92, 16, 70, 89, 69, 91, 68}, "c9b467") + th.getMessage() + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 16, 69, Ascii.SYN, 76, 67, Ascii.NAK, 11, 70, 4, 80, 9, 93, 82, 80, 7, 94, 67, Ascii.NAK, 11, 70, 52, 3, 86}, "101d5c"));
                        b.b(classLoader, file);
                    }
                    return;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        m.d(f5644a, ijiami_1011.s.s.s.d(new byte[]{8, 93, 74, Ascii.ETB, 3, 85, 13, 55, 9, 50, 80, 17, 9, Ascii.US, Ascii.EM, 5, 13, 85, 5, 1, Ascii.DC4, 66}, "a39cb9") + file + ijiami_1011.s.s.s.d(new byte[]{Ascii.EM, 81, 16, 70, 95, 91, 13, 1, 1, 3, 93}, "98cf67"));
    }
}
