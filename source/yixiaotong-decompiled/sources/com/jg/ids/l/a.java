package com.jg.ids.l;

import android.content.Context;
import com.jg.ids.i;
import com.jg.ids.k;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Object f4614a;
    private static Class b;
    private static Method c;
    private static Method d;
    private static Method e;

    static {
        f4614a = null;
        b = null;
        c = null;
        d = null;
        e = null;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            f4614a = cls.newInstance();
        } catch (Throwable th) {
            f4614a = null;
        }
        try {
            b.getMethod("getDefaultUDID", Context.class);
        } catch (Throwable th2) {
        }
        try {
            c = b.getMethod("getOAID", Context.class);
        } catch (Throwable th3) {
            c = null;
        }
        try {
            d = b.getMethod("getVAID", Context.class);
        } catch (Throwable th4) {
            d = null;
        }
        try {
            e = b.getMethod("getAAID", Context.class);
        } catch (Throwable th5) {
            e = null;
        }
    }

    private static String a(Context context, Method method) {
        if (f4614a != null && method != null) {
            try {
                return (String) method.invoke(f4614a, context);
            } catch (Throwable th) {
            }
        }
        return "";
    }

    @Override // com.jg.ids.i
    public final String a(Context context) {
        String strA = a(context, d);
        k.a().b(strA);
        return strA;
    }

    @Override // com.jg.ids.i
    public final String b(Context context) {
        String strA = a(context, c);
        k.a().c(strA);
        return strA;
    }

    @Override // com.jg.ids.i
    public final String c(Context context) {
        String strA = a(context, e);
        k.a().a(strA);
        return strA;
    }

    @Override // com.jg.ids.i
    public final boolean d() {
        return f4614a != null;
    }
}
