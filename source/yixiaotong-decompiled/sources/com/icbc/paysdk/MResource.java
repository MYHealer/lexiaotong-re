package com.icbc.paysdk;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class MResource {
    /* JADX WARN: Code duplicated, block: B:12:0x0042 A[Catch: NoSuchFieldException -> 0x004b, IllegalAccessException -> 0x0050, SecurityException -> 0x0055, IllegalArgumentException -> 0x005a, ClassNotFoundException -> 0x005f, TRY_LEAVE, TryCatch #2 {ClassNotFoundException -> 0x005f, IllegalAccessException -> 0x0050, IllegalArgumentException -> 0x005a, NoSuchFieldException -> 0x004b, SecurityException -> 0x0055, blocks: (B:3:0x0005, B:4:0x0021, B:6:0x0024, B:8:0x0039, B:12:0x0042, B:9:0x003c), top: B:25:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    public static int getIdByName(Context context, String str, String str2) {
        Class<?> cls;
        try {
            Class<?>[] classes = Class.forName(context.getPackageName() + ".R").getClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getName().split("\\$")[1].equals(str)) {
                    cls = classes[i];
                    if (cls != null) {
                        return cls.getField(str2).getInt(cls);
                    }
                    return 0;
                }
            }
            cls = null;
            if (cls != null) {
                return cls.getField(str2).getInt(cls);
            }
            return 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return 0;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return 0;
        } catch (IllegalArgumentException e3) {
            e3.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e4) {
            e4.printStackTrace();
            return 0;
        } catch (SecurityException e5) {
            e5.printStackTrace();
            return 0;
        }
    }
}
