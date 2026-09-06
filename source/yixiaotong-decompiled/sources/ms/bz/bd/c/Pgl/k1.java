package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class k1 {
    static String c;
    static String tt;

    public static synchronized String c(Context context) {
        String str = c;
        if (str != null) {
            return v1.c(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblr.c("6765744465766963654964")), new Class[0]);
            declaredMethod.setAccessible(true);
            c = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return v1.c(c);
        } catch (Throwable unused) {
        }
    }

    public static synchronized String tt(Context context) {
        String str = c;
        if (str != null) {
            return v1.c(str);
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                throw new NullPointerException("null TM");
            }
            Method declaredMethod = telephonyManager.getClass().getDeclaredMethod(new String(pblr.c("676574537562736372696265724964")), new Class[0]);
            declaredMethod.setAccessible(true);
            tt = (String) declaredMethod.invoke(telephonyManager, new Object[0]);
            return v1.c(tt);
        } catch (Throwable unused) {
        }
    }
}
