package ms.bz.bd.c.Pgl;

import android.app.Activity;
import android.content.Context;
import android.util.ArrayMap;
import com.google.common.base.Ascii;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class pble {
    private static volatile int c = -1;
    private static volatile String tt = "";

    public static int c(Context context) {
        if (c <= 0) {
            try {
                c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (Throwable unused) {
            }
        }
        return c;
    }

    public static Activity c() {
        try {
            Class<?> cls = Class.forName((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "9e94d1", new byte[]{41, 105, 78, 82, 84, 47, 62, 10, 105, 116, 56, 41, 107, 67, 79, 47, 44, 77, 124, 125, Ascii.FS, 111, 88, 69, 90, 34}));
            Object objInvoke = cls.getMethod((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "b89f4d", new byte[]{112, 47, 88, 0, 14, 125, 117, 56, 107, 34, 122, 44, 67, 6, Ascii.DC2, 71, 105, 11, 109, 55, 119}), new Class[0]).invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "e93bca", new byte[]{121, 26, 67, 2, 85, 96, 111, 12, 107, 55, 103}));
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(objInvoke);
            if (arrayMap.size() <= 0) {
                return null;
            }
            for (Object obj : arrayMap.values()) {
                Class<?> cls2 = obj.getClass();
                Field declaredField2 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "043ac4", new byte[]{49, 55, 85, 6, 89, 39}));
                declaredField2.setAccessible(true);
                if (!declaredField2.getBoolean(obj)) {
                    Field declaredField3 = cls2.getDeclaredField((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "752ad0", new byte[]{39, 52, 85, Ascii.FS, 77, 46, 32, 13}));
                    declaredField3.setAccessible(true);
                    return (Activity) declaredField3.get(obj);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "0329b6", new byte[]{32, 56, 126, 74});
        }
        return null;
    }

    public static String tt(Context context) {
        try {
            if (tt == "") {
                tt = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            }
        } catch (Throwable unused) {
        }
        return tt;
    }
}
