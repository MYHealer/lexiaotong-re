package com.hihonor.adsdk.common.e.e.a;

import android.app.UiModeManager;
import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    public static final int hnadsa = 15;
    public static final int hnadsb = 1;
    public static final int hnadsc = 2;
    public static final int hnadsd = 4;
    public static final int hnadse = 8;
    private static final String hnadsf = "HwWidgetInstantiator";
    private static final String hnadsg = "com.hihonor.adsdk.common.uikit";
    private static final String hnadsh = "com.hihonor.adsdk.common.uikit.phone";
    private static final String hnadsi = "com.hihonor.adsdk.common.uikit.tv";
    private static final String hnadsj = "com.hihonor.adsdk.common.uikit.car";
    private static final String hnadsk = "com.hihonor.adsdk.common.uikit.watch";
    private static final Map<String, Class<?>> hnadsl = new ArrayMap();

    private b() {
    }

    public static String hnadsa(Context context, Class<?> cls) {
        return hnadsa(context, cls, hnadsb(context));
    }

    public static int hnadsb(Context context) {
        return hnadsa(context);
    }

    public static int hnadsc(Context context) {
        Object systemService = context.getSystemService("uimode");
        if (systemService instanceof UiModeManager) {
            return ((UiModeManager) systemService).getCurrentModeType();
        }
        return 0;
    }

    public static String hnadsa(Context context, Class<?> cls, int i) {
        String str;
        if (i == 2) {
            str = hnadsi;
        } else if (i != 4) {
            str = i != 8 ? hnadsh : hnadsk;
        } else {
            str = hnadsj;
        }
        return cls.getName().replace(hnadsg, str);
    }

    public static int hnadsa(Context context, int i, int i2) {
        int iHnadsa = hnadsa(context);
        return ((i & 15) & iHnadsa) == 0 ? i2 : iHnadsa;
    }

    public static int hnadsa(Context context) {
        int i = context.getResources().getConfiguration().uiMode & 15;
        int i2 = 4;
        if (i != 3) {
            i2 = i != 4 ? 1 : 2;
        }
        if (i == 6) {
            return 8;
        }
        return i2;
    }

    public static Object hnadsa(Context context, String str, Class<?> cls) {
        if (context != null && !TextUtils.isEmpty(str) && cls != null) {
            try {
                Map<String, Class<?>> map = hnadsl;
                Class<?> clsLoadClass = map.get(str);
                if (clsLoadClass == null) {
                    clsLoadClass = context.getClassLoader().loadClass(str);
                    if (!cls.isAssignableFrom(clsLoadClass)) {
                        com.hihonor.adsdk.common.b.b.hnadse(hnadsf, "Trying to instantiate the class that is not " + cls.getName(), new Object[0]);
                        return null;
                    }
                    map.put(str, clsLoadClass);
                }
                return clsLoadClass.getDeclaredConstructor(Context.class).newInstance(context);
            } catch (ClassNotFoundException unused) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, str + ": make sure class name exists, is public, and has an empty constructor that is public", new Object[0]);
            } catch (IllegalAccessException unused2) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, str + ": calling constructor caused an IllegalAccessException", new Object[0]);
            } catch (InstantiationException unused3) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, str + ": calling constructor caused an InstantiationException", new Object[0]);
            } catch (NoSuchMethodException unused4) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, str + ": could not find constructor", new Object[0]);
            } catch (InvocationTargetException unused5) {
                com.hihonor.adsdk.common.b.b.hnadse(hnadsf, str + ": calling constructor caused an InvocationTargetException", new Object[0]);
            }
        }
        return null;
    }
}
