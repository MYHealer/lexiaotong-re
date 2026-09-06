package com.adprof.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class md {
    public static Activity a(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return a(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Window m681a(Context context) {
        Activity activityA = a(context);
        if (activityA != null) {
            return activityA.getWindow();
        }
        return null;
    }

    public static void a(Activity activity) {
        if (Build.VERSION.SDK_INT == 26 && m682a(activity)) {
            try {
                Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
                declaredField.setAccessible(true);
                ((ActivityInfo) declaredField.get(activity)).screenOrientation = -1;
            } catch (Throwable th) {
                pk.b("fixOrientation error", th);
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m682a(Activity activity) {
        try {
            Field declaredField = Class.forName("com.android.internal.R$styleable").getDeclaredField("Window");
            declaredField.setAccessible(true);
            TypedArray typedArrayObtainStyledAttributes = activity.obtainStyledAttributes((int[]) declaredField.get(null));
            Method declaredMethod = ActivityInfo.class.getDeclaredMethod("isTranslucentOrFloating", TypedArray.class);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
        } catch (Throwable th) {
            pk.b("isTranslucentOrFloating error", th);
            return false;
        }
    }
}
