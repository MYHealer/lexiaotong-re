package com.fancy;

import android.app.Activity;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ad {
    public static volatile boolean _c;
    public static Class<?> _d;
    public static Method _e;
    public static Method _f;
    public static Method _g;
    public static Integer _h;
    public Object _a;
    public Object _b;

    public class _a implements InvocationHandler {
        public final /* synthetic */ Runnable _a;

        public _a(Runnable runnable) {
            this._a = runnable;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2 = null;
            if (method.getDeclaringClass() == Object.class) {
                String name = method.getName();
                if ("hashCode".equals(name)) {
                    return Integer.valueOf(System.identityHashCode(obj));
                }
                if ("equals".equals(name)) {
                    if (objArr != null && objArr.length > 0) {
                        obj2 = objArr[0];
                    }
                    return Boolean.valueOf(obj == obj2);
                }
                if ("toString".equals(name)) {
                    return _ad._d.getName() + "@Proxy";
                }
            }
            if ("onBackInvoked".equals(method.getName())) {
                try {
                    this._a.run();
                } catch (Throwable unused) {
                }
            }
            return null;
        }
    }

    public static void _a() {
        if (_c) {
            return;
        }
        synchronized (_ad.class) {
            if (_c) {
                return;
            }
            _c = true;
            try {
                Class<?> cls = Class.forName("android.window.OnBackInvokedDispatcher");
                _d = Class.forName("android.window.OnBackInvokedCallback");
                _e = Activity.class.getMethod("getOnBackInvokedDispatcher", new Class[0]);
                _f = cls.getMethod("registerOnBackInvokedCallback", Integer.TYPE, _d);
                _g = cls.getMethod("unregisterOnBackInvokedCallback", _d);
                try {
                    _h = Integer.valueOf(cls.getField("PRIORITY_DEFAULT").getInt(null));
                } catch (Throwable unused) {
                    _h = null;
                }
            } catch (Throwable unused2) {
                _d = null;
                _e = null;
                _f = null;
                _g = null;
                _h = null;
            }
        }
    }

    public final void _a(Activity activity, Runnable runnable) {
        Method method;
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        _a();
        if (_d == null || (method = _e) == null || _f == null) {
            return;
        }
        try {
            Object objInvoke = method.invoke(activity, new Object[0]);
            this._a = objInvoke;
            if (objInvoke == null) {
                return;
            }
            this._b = Proxy.newProxyInstance(activity.getClass().getClassLoader(), new Class[]{_d}, new _a(runnable));
            Integer num = _h;
            _f.invoke(this._a, Integer.valueOf(num != null ? num.intValue() : 0), this._b);
        } catch (Throwable unused) {
            this._a = null;
            this._b = null;
        }
    }

    public final void _b() {
        if (Build.VERSION.SDK_INT < 33 || this._a == null || this._b == null) {
            return;
        }
        _a();
        Method method = _g;
        if (method == null) {
            this._a = null;
            this._b = null;
        } else {
            try {
                method.invoke(this._a, this._b);
            } catch (Throwable unused) {
            }
            this._a = null;
            this._b = null;
        }
    }
}
