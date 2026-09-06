package com.xiaomi.onetrack.util.oaid.helpers;

import android.content.Context;
import com.google.common.base.Ascii;
import com.xiaomi.onetrack.util.p;
import ijiami_1011.s.s.s;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class g {
    private static final String b = s.d(new byte[]{120, 70, 88, 96, 32, 42, 41, 1, 10, Ascii.DC2, 84, Ascii.ETB}, "5593da");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue<a> f9542a = new LinkedBlockingQueue<>(1);

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9543a;
        public Method b;
        public Object[] c;

        public a(Object obj, Method method, Object[] objArr) {
            this.f9543a = obj;
            this.b = method;
            this.c = objArr;
        }
    }

    public class b implements InvocationHandler {
        public b() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            try {
                g.this.f9542a.offer(g.this.new a(obj, method, objArr), 1L, TimeUnit.SECONDS);
                return null;
            } catch (Exception e) {
                try {
                    e.printStackTrace();
                    return null;
                } catch (Exception e2) {
                    p.a(s.d(new byte[]{125, 70, 89, 96, 119, 41, 41, 1, 10, Ascii.DC2, 84, Ascii.ETB}, "05833b"), e2.getMessage());
                    return null;
                }
            }
        }
    }

    public String a(Context context) {
        try {
            Class<?> cls = Class.forName(s.d(new byte[]{81, 13, 94, Ascii.FS, 91, 17, 15, 74, 11, 11, 88, 17, 95, 6, 90, 86, Ascii.ETB, 7, 14, Ascii.SYN, 3, 76, 124, 1, 91, 6, 96, 86, 82, 44, 4, 8, Ascii.SYN, 7, 67}, "2b329d"));
            Class<?> cls2 = Class.forName(s.d(new byte[]{81, 91, 92, 79, 81, 16, 15, 74, Ascii.NAK, Ascii.ETB, 65, Ascii.NAK, 94, 93, 84, 19, Ascii.GS, 44, 40, 0, 3, 12, 69, 12, 84, 93, 84, 19, 127, 12, Ascii.DC2, 16, 3, 12, 84, Ascii.ETB}, "241a3e"));
            Object objNewProxyInstance = Proxy.newProxyInstance(context.getClassLoader(), new Class[]{cls2}, new b());
            cls.getDeclaredMethod(s.d(new byte[]{121, 12, 11, 17, 103, 93, 10}, "0bbe49"), Context.class, Boolean.TYPE, cls2).invoke(cls, context, Boolean.TRUE, objNewProxyInstance);
            a aVarPoll = this.f9542a.poll(1L, TimeUnit.SECONDS);
            if (aVarPoll != null) {
                return aVarPoll.c[1].getClass().getMethod(s.d(new byte[]{85, 3, 67, 127, 36, 126, 37}, "2f70e7"), new Class[0]).invoke(aVarPoll.c[1], new Object[0]).toString();
            }
        } catch (Throwable th) {
            p.a(b, th.getMessage());
        }
        return "";
    }
}
