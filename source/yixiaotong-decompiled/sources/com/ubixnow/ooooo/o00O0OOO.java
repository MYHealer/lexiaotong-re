package com.ubixnow.ooooo;

import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o00O0OOO {
    public static o00O OooO00o(Class<? extends o00O> cls) {
        if (cls == null) {
            try {
                Log.w(ooooO000.OooO0O0, "can not find adapter");
            } catch (Exception e) {
                ooooO000.OooO0O0("------createAdapter ", "Exception " + e.getMessage());
                return null;
            }
        }
        Constructor<? extends o00O> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static o00O OooO00o(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return OooO00o((Class<? extends o00O>) Class.forName(str).asSubclass(o00O.class));
            } catch (Throwable th) {
                ooooO000.OooO0O0("------createAdapter ", "Exception " + th.getMessage());
                th.printStackTrace();
            }
        }
        return null;
    }

    public static o00O0O0O OooO0O0(Class<? extends o00O0O0O> cls) throws Exception {
        if (cls == null) {
            Log.w(ooooO000.OooO0O0, "can not find adapter");
        }
        Constructor<? extends o00O0O0O> declaredConstructor = cls.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        return declaredConstructor.newInstance(new Object[0]);
    }

    public static o00O0O0O OooO0O0(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return OooO0O0((Class<? extends o00O0O0O>) Class.forName(str).asSubclass(o00O0O0O.class));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }
}
