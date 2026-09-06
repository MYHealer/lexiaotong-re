package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.oaid.OaidManager;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g5 implements _eg {
    public Context _a;

    public class _a implements InvocationHandler {
        public final /* synthetic */ _a4 _a;

        public _a(_a4 _a4Var) {
            this._a = _a4Var;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            String str;
            StringBuilder sbAppend;
            try {
                if ("OnSupport".equals(method.getName())) {
                    Object objInvoke = objArr[1].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[1], new Object[0]);
                    str = objInvoke != null ? (String) objInvoke : "";
                    _a4 _a4Var = this._a;
                    if (_a4Var != null) {
                        _a4Var._a(str);
                    }
                    sbAppend = new StringBuilder().append("initOaid msa oaid 1: ");
                } else {
                    if (!"onSupport".equals(method.getName())) {
                        return null;
                    }
                    Object objInvoke2 = objArr[0].getClass().getMethod("getOAID", new Class[0]).invoke(objArr[0], new Object[0]);
                    str = objInvoke2 != null ? (String) objInvoke2 : "";
                    _a4 _a4Var2 = this._a;
                    if (_a4Var2 != null) {
                        _a4Var2._a(str);
                    }
                    sbAppend = new StringBuilder().append("initOaid msa oaid 2: ");
                }
                Logger.d(OaidManager.TAG, sbAppend.append(str).toString());
                return null;
            } catch (Exception e) {
                Logger.d(OaidManager.TAG, _ie._a("initOaid msa oaid getOAID() error： ").append(e.getMessage()).toString());
                return null;
            }
        }
    }

    public _g5(Context context) {
        this._a = context;
    }

    @Override // com.fancy._eg
    public final void _a(_a4 _a4Var) {
        try {
            Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
            try {
                Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
                Class<?> cls2 = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                cls.getMethod("InitSdk", Context.class, Boolean.TYPE, cls2).invoke(null, this._a, Boolean.TRUE, Proxy.newProxyInstance(cls2.getClassLoader(), new Class[]{cls2}, new _a(_a4Var)));
            } catch (Exception e) {
                Logger.d(OaidManager.TAG, _ie._a("initOaid msa oaid class error： ").append(e.getMessage()).toString());
            }
        } catch (Throwable unused) {
            if (_a4Var != null) {
                _a4Var._a("");
            }
        }
    }
}
