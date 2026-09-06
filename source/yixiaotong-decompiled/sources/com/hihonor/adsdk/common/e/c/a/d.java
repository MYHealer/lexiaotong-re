package com.hihonor.adsdk.common.e.c.a;

import android.graphics.Rect;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d {
    private static final String hnadsa = "HwDisplaySizeUtil";
    private static final String hnadsb = "getDisplaySafeInsets";
    private static String hnadsc = "com.hihonor.android.view.ExtDisplaySizeUtilEx";

    private d() {
    }

    public static Rect hnadsa() {
        try {
            Object objInvoke = Class.forName(hnadsc).getMethod(hnadsb, new Class[0]).invoke(null, new Object[0]);
            if (objInvoke instanceof Rect) {
                return (Rect) objInvoke;
            }
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDisplaySafeInsets: object is not Rect", new Object[0]);
            return new Rect();
        } catch (ClassNotFoundException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDisplaySafeInsets: ExtDisplaySizeUtilEx class not found : " + hnadsc, new Object[0]);
        } catch (IllegalAccessException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDisplaySafeInsets: illegal access exception : " + hnadsc, new Object[0]);
        } catch (NoSuchMethodException unused3) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDisplaySafeInsets: method not found : " + hnadsc, new Object[0]);
        } catch (InvocationTargetException unused4) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "getDisplaySafeInsets: invocation target exception : " + hnadsc, new Object[0]);
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 31) {
            Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "CLASS_NAME_EXTDISPLAYSIZEUTILEX", com.hihonor.adsdk.common.e.d.c.b.hnadsb);
            if (objHnadsa instanceof String) {
                hnadsc = (String) objHnadsa;
            }
        }
    }
}
