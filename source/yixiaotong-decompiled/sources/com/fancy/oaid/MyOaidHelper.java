package com.fancy.oaid;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.fancy._a3;
import com.fancy._a4;
import com.fancy._bq;
import com.fancy._br;
import com.fancy._c3;
import com.fancy._ca;
import com.fancy._dv;
import com.fancy._e1;
import com.fancy._e3;
import com.fancy._eg;
import com.fancy._fk;
import com.fancy._g0;
import com.fancy._hj;
import com.fancy._hk;
import com.fancy._hm;
import com.fancy._ie;
import com.fancy._kr;
import com.fancy._n3;
import com.fancy._p7;
import com.fancy._pl;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class MyOaidHelper {
    private static final long TIMEOUT_MS = 100;
    private static final AtomicBoolean GETTING_STATUS = new AtomicBoolean(false);
    private static final AtomicReference<_a4> CURRENT_LISTENER = new AtomicReference<>();
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static long startTime = 0;

    public class _a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            if (MyOaidHelper.GETTING_STATUS.get()) {
                MyOaidHelper.printD("[MyOaidHelper] OAID获取超时（100ms）");
                MyOaidHelper.GETTING_STATUS.set(false);
                MyOaidHelper.deliverResultSafely("");
                MyOaidHelper.CURRENT_LISTENER.set(null);
            }
        }
    }

    public class _b implements _a4 {
        public final /* synthetic */ Runnable _a;
        public final /* synthetic */ Context _b;

        public _b(_a _aVar, Context context) {
            this._a = _aVar;
            this._b = context;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            String str2;
            MyOaidHelper.MAIN_HANDLER.removeCallbacks(this._a);
            if (MyOaidHelper.GETTING_STATUS.get()) {
                MyOaidHelper.GETTING_STATUS.set(false);
                MyOaidHelper.deliverResultSafely(str);
                MyOaidHelper.CURRENT_LISTENER.set(null);
                return;
            }
            MyOaidHelper.printD("[MyOaidHelper] OAID结果已处理过，忽略重复回调");
            long jCurrentTimeMillis = System.currentTimeMillis() - MyOaidHelper.startTime;
            MyOaidHelper.printD("[MyOaidHelper] OAID获取耗时: " + jCurrentTimeMillis + "ms");
            if (str == null || str.isEmpty()) {
                str2 = "[MyOaidHelper] 获取到的OAID为空";
            } else {
                MyOaidHelper.printD("[MyOaidHelper] 获取到OAID: " + str);
                if (jCurrentTimeMillis > 100) {
                    MyOaidHelper.printD("[MyOaidHelper] 获取耗时超过100ms，进行缓存操作");
                    MyOaidHelper.storeOaidToCache(this._b, str);
                    return;
                }
                str2 = "[MyOaidHelper] 获取耗时在100ms内，不进行缓存";
            }
            MyOaidHelper.printD(str2);
        }
    }

    public class _c implements Runnable {
        public final /* synthetic */ _eg _a;
        public final /* synthetic */ _a4 _b;
        public final /* synthetic */ Runnable _c;

        public _c(_eg _egVar, _b _bVar, _a _aVar) {
            this._a = _egVar;
            this._b = _bVar;
            this._c = _aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a._a(this._b);
            } catch (Throwable th) {
                MyOaidHelper.printD(_ie._a("[MyOaidHelper] 获取OAID异常: ").append(th.getMessage()).toString());
                MyOaidHelper.MAIN_HANDLER.removeCallbacks(this._c);
                if (MyOaidHelper.GETTING_STATUS.get()) {
                    MyOaidHelper.GETTING_STATUS.set(false);
                    MyOaidHelper.deliverResultSafely("");
                    MyOaidHelper.CURRENT_LISTENER.set(null);
                }
            }
        }
    }

    public class _d implements Runnable {
        public final /* synthetic */ _a4 _a;
        public final /* synthetic */ String _b;

        public _d(_a4 _a4Var, String str) {
            this._a = _a4Var;
            this._b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this._a._a(this._b);
            } catch (Throwable th) {
                MyOaidHelper.printD(_ie._a("[MyOaidHelper] 回调监听器异常: ").append(th.getMessage()).toString());
            }
        }
    }

    public class _e implements Runnable {
        public final /* synthetic */ Context _a;
        public final /* synthetic */ String _b;

        public _e(Context context, String str) {
            this._a = context;
            this._b = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                _a3 _a3Var_a = _a3._a();
                Context context = this._a;
                String str = this._b;
                _a3Var_a.getClass();
                _a3._b = str;
                try {
                    _kr._a(context, "ptg_ids_sp_oaid", str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                MyOaidHelper.printD("[MyOaidHelper] OAID已存储到SP: " + this._b);
                _ca._c()._a = this._b;
                MyOaidHelper.printD("[MyOaidHelper] OAID已设置到DeviceManager");
            } catch (Throwable th2) {
                MyOaidHelper.printD(_ie._a("[MyOaidHelper] 存储OAID到缓存异常: ").append(th2.getMessage()).toString());
            }
        }
    }

    public static _eg createOaidGetter(Context context) {
        try {
            if (Build.BRAND.equalsIgnoreCase("HONOR") && !(!TextUtils.isEmpty(_hk._a("ro.build.version.emui")))) {
                _e3 _e3Var = new _e3(context);
                if (_e3Var._a()) {
                    return _e3Var;
                }
            }
            if (!_hk._c() && !(!TextUtils.isEmpty(_hk._a("ro.build.version.emui")))) {
                if (_hk._k()) {
                    return new _p7(context);
                }
                if (!_hk._i() && !_hk._h()) {
                    if (!_hk._l() && !(!TextUtils.isEmpty(_hk._a("ro.miui.ui.version.name"))) && !_hk._b()) {
                        if (_hk._j()) {
                            return new _n3(context);
                        }
                        if (_hk._e()) {
                            return new _g0(context);
                        }
                        if (_hk._g()) {
                            return new _hj(context);
                        }
                        if (_hk._a()) {
                            return new com.fancy._a(context);
                        }
                        if (_hk._d() || _hk._f()) {
                            return new _fk(context);
                        }
                        try {
                            context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);
                            return new _bq(context);
                        } catch (Exception unused) {
                            if (_hk._a("ro.odm.manufacturer").equalsIgnoreCase("PRIZE")) {
                                return new _br(context);
                            }
                            if (!TextUtils.isEmpty(_hk._a("ro.build.freeme.label"))) {
                                return new _dv(context);
                            }
                            return new _c3();
                        }
                    }
                    return new _pl(context);
                }
                return new _hm(context);
            }
            return new _e1(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return new _c3();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void deliverResultSafely(String str) {
        _a4 _a4Var = CURRENT_LISTENER.get();
        if (_a4Var != null) {
            MAIN_HANDLER.post(new _d(_a4Var, str));
        }
    }

    private static String getManufacturer() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static void getOAid(Context context, _a4 _a4Var) {
        try {
            printD("[MyOaidHelper] manufacturer = " + getManufacturer().toUpperCase());
            createOaidGetter(context)._a(_a4Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printD(String str) {
    }

    public static void safeGetOAid(Context context, _a4 _a4Var) {
        AtomicBoolean atomicBoolean = GETTING_STATUS;
        if (atomicBoolean.get()) {
            printD("[MyOaidHelper] OAID正在获取中，忽略重复请求");
            return;
        }
        atomicBoolean.set(true);
        CURRENT_LISTENER.set(_a4Var);
        startTime = System.currentTimeMillis();
        _a _aVar = new _a();
        MAIN_HANDLER.postDelayed(_aVar, 100L);
        try {
            printD("[MyOaidHelper] manufacturer = " + getManufacturer().toUpperCase());
            com.fancy.adsdk.lib.utils._d._b(new _c(createOaidGetter(context), new _b(_aVar, context), _aVar));
        } catch (Throwable th) {
            printD(_ie._a("[MyOaidHelper] 初始化OAID获取器异常: ").append(th.getMessage()).toString());
            MAIN_HANDLER.removeCallbacks(_aVar);
            GETTING_STATUS.set(false);
            deliverResultSafely("");
            CURRENT_LISTENER.set(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void storeOaidToCache(Context context, String str) {
        if (context == null || str == null || str.isEmpty()) {
            return;
        }
        com.fancy.adsdk.lib.utils._d._b(new _e(context, str));
    }
}
