package com.yfanads.android.libs.utils;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class WindowUtils {
    public static View getAboveDecorView(Activity activity) {
        int i;
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Field declaredField = cls.getDeclaredField("mViews");
            declaredField.setAccessible(true);
            cls.getDeclaredField("mRoots").setAccessible(true);
            cls.getDeclaredField("mParams").setAccessible(true);
            Object obj = declaredField.get(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
            if (obj instanceof List) {
                int iIndexOf = ((List) obj).indexOf(activity.getWindow().getDecorView());
                if (iIndexOf > 0 && ((List) obj).size() > (i = iIndexOf + 1)) {
                    return (View) ((List) obj).get(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
