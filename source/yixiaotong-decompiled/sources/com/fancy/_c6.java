package com.fancy;

import android.content.Context;
import android.net.LocalServerSocket;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.kuaishou.weapon.p0.an;
import com.umeng.analytics.pro.d;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c6 extends AsyncTask<Void, Void, String> {
    public String _a;

    public _c6(String str) {
        this._a = str;
    }

    public static HashMap _a(Context context) {
        boolean z;
        boolean z2;
        double d;
        double d2;
        _dz _dzVar;
        HashMap map = new HashMap();
        boolean z_b = _at._b(context);
        int i_a = _at._a(context);
        int i_a2 = _gx._a(context);
        _ca._f();
        boolean z3 = _ca._g;
        if (_p6._b == null) {
            synchronized (_p6.class) {
                if (_p6._b == null) {
                    _p6._b = new _p6();
                }
            }
        }
        _p6 _p6Var = _p6._b;
        if (TextUtils.isEmpty(_a6._d)) {
            try {
                Context context2 = PtgAdSdk.getContext();
                if (context2 != null) {
                    _a6._d = context2.getPackageName();
                }
            } catch (Exception unused) {
            }
        }
        String str = _a6._d;
        boolean z4 = true;
        if (_p6Var._a == null) {
            try {
                _p6Var._a = new LocalServerSocket(str);
            } catch (IOException unused2) {
                z = true;
            }
        }
        z = false;
        try {
            ClassLoader.getSystemClassLoader().loadClass(an.f4626a).newInstance();
            ClassLoader.getSystemClassLoader().loadClass(an.b).newInstance();
        } catch (ClassNotFoundException unused3) {
            z2 = false;
        } catch (IllegalAccessException | InstantiationException unused4) {
        }
        z2 = true;
        String str2 = Build.TAGS;
        if (str2 == null || !str2.contains("test-keys")) {
            try {
                String[] strArr = _my._a;
                int i = 0;
                while (true) {
                    if (i < 10) {
                        if (!new File(strArr[i]).exists()) {
                            i++;
                        }
                    } else if (!_my._a()) {
                        z4 = false;
                    }
                }
            } catch (Exception unused5) {
            }
        }
        _c7 _c7Var_c = _ca._c();
        if (_c7Var_c == null || (_dzVar = _c7Var_c._m) == null) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            d = _dzVar._a;
            d2 = _dzVar._b;
        }
        map.put("isChrg", String.valueOf(z_b));
        map.put("battPct", String.valueOf(i_a));
        map.put("netTyp", String.valueOf(i_a2));
        map.put("devMod", String.valueOf(z3));
        map.put("spnMod", String.valueOf(z));
        map.put("xpdMod", String.valueOf(z2));
        map.put("rttMod", String.valueOf(z4));
        map.put(d.C, String.valueOf(d));
        map.put("lon", String.valueOf(d2));
        return map;
    }

    @Override // android.os.AsyncTask
    public final String doInBackground(Void[] voidArr) {
        try {
            Context context = PtgAdSdk.getContext();
            if (context != null) {
                this._a = _hr._a(this._a, _a(context));
                _ou _ouVar_a = _ou._a();
                String str = this._a;
                _m1 _m1Var = _ouVar_a._b;
                if (_m1Var != null) {
                    _m1Var._a(str);
                } else {
                    _m1 _m1Var2 = new _m1();
                    _ouVar_a._b = _m1Var2;
                    _m1Var2._a(str);
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(String str) {
        super.onPostExecute(str);
    }
}
