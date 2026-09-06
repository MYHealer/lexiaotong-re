package com.hihonor.adsdk.common.e.e.a;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "HwWidgetCompat";
    private static HashMap<Integer, ArrayList<WeakReference<ContextThemeWrapper>>> hnadsf;
    private static final String hnadsc = "get";
    private static final String hnadsb = "com.hihonor.android.os.SystemPropertiesEx";
    private static final boolean hnadsd = "1".equals(hnadsa((Object) null, hnadsc, new Class[]{String.class, String.class}, new Object[]{"hn.uikit.debuggable", "0"}, hnadsb));
    private static final Object hnadse = new Object();

    private a() {
    }

    public static Context hnadsa(Context context, int i, int i2) {
        return hnadsa(context, i, i2, false);
    }

    public static Context hnadsa(Context context, int i, int i2, boolean z) {
        if (!hnadsa(context, i)) {
            if (hnadsd) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) " should not wrap context.");
            }
            return context;
        }
        if (!z) {
            return new ContextThemeWrapper(context, i2);
        }
        synchronized (hnadse) {
            if (hnadsf == null) {
                hnadsf = new HashMap<>();
            }
            if (hnadsd) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) (" before wrap. themeResId = " + i2 + " sContextCache = " + hnadsf));
            }
            ArrayList<WeakReference<ContextThemeWrapper>> arrayListComputeIfAbsent = hnadsf.computeIfAbsent(Integer.valueOf(i2), new Function() { // from class: com.hihonor.adsdk.common.e.e.a.a$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return a.hnadsa((Integer) obj);
                }
            });
            for (int size = arrayListComputeIfAbsent.size() - 1; size >= 0; size--) {
                WeakReference<ContextThemeWrapper> weakReference = arrayListComputeIfAbsent.get(size);
                if (weakReference == null || weakReference.get() == null) {
                    if (hnadsd) {
                        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) (" clean dead reference entries. contextThemeWrapperList size = " + arrayListComputeIfAbsent.size() + " i = " + size));
                    }
                    arrayListComputeIfAbsent.remove(size);
                }
            }
            for (int size2 = arrayListComputeIfAbsent.size() - 1; size2 >= 0; size2--) {
                WeakReference<ContextThemeWrapper> weakReference2 = arrayListComputeIfAbsent.get(size2);
                ContextThemeWrapper contextThemeWrapper = weakReference2 != null ? weakReference2.get() : null;
                if (contextThemeWrapper != null && contextThemeWrapper.getBaseContext() == context) {
                    if (hnadsd) {
                        com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) (" hit cache. contextThemeWrapperList size = " + arrayListComputeIfAbsent.size() + " i = " + size2 + " contextThemeWrapper = " + contextThemeWrapper));
                    }
                    return contextThemeWrapper;
                }
            }
            ContextThemeWrapper contextThemeWrapper2 = new ContextThemeWrapper(context, i2);
            arrayListComputeIfAbsent.add(new WeakReference<>(contextThemeWrapper2));
            if (hnadsd) {
                com.hihonor.adsdk.common.b.b.hnadsa(hnadsa, (Object) (" after wrap. themeResId = " + i2 + " sContextCache = " + hnadsf));
            }
            return contextThemeWrapper2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ArrayList hnadsa(Integer num) {
        return new ArrayList();
    }

    private static boolean hnadsa(Context context, int i) {
        return !context.getTheme().resolveAttribute(i, new TypedValue(), false);
    }

    private static Object hnadsa(Object obj, String str, Class[] clsArr, Object[] objArr, Class<?> cls) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalAccessException in reflect call " + str, new Object[0]);
            return null;
        } catch (IllegalArgumentException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "IllegalArgumentException in reflect call " + str, new Object[0]);
            return null;
        } catch (NoSuchMethodException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "there is no " + str + " method", new Object[0]);
            return null;
        } catch (InvocationTargetException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "InvocationTargetException in reflect call " + str, new Object[0]);
            return null;
        }
    }

    private static Object hnadsa(Object obj, String str, Class[] clsArr, Object[] objArr, String str2) {
        try {
            return hnadsa(obj, str, clsArr, objArr, Class.forName(str2));
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "callMethod: class not fount " + str2, new Object[0]);
            return null;
        }
    }
}
