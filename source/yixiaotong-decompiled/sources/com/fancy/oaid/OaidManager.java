package com.fancy.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.fancy._a3;
import com.fancy._a4;
import com.fancy._c7;
import com.fancy._ca;
import com.fancy._dw;
import com.fancy._g6;
import com.fancy._kr;
import com.fancy._n4;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.utils._d;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class OaidManager {
    public static final String TAG = "OaidHelperTag";
    private static final AtomicBoolean isRequstedOaid = new AtomicBoolean(false);

    public class _a implements _a4 {
        public final /* synthetic */ long _a;

        public _a(long j) {
            this._a = j;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            OaidManager.printD("[GMSADIDHelper] gaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a));
            _a3 _a3Var_a = _a3._a();
            Context context = PtgAdSdk.getContext();
            _a3Var_a.getClass();
            _a3._c = str;
            try {
                _kr._a(context, "ptg_ids_sp_gaid", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            _ca._c()._b = str;
        }
    }

    public class _b implements Runnable {
        public final /* synthetic */ Context _a;

        public class _a implements _a4 {
            public final /* synthetic */ long _a;

            /* JADX INFO: renamed from: com.fancy.oaid.OaidManager$_b$_a$_a, reason: collision with other inner class name */
            public class C0378_a implements _a4 {
                public C0378_a() {
                }

                @Override // com.fancy._a4
                public final void _a(String str) {
                    OaidManager.printD("[MsaOaidHelper] oaid = " + str + "，cost = " + (System.currentTimeMillis() - _a.this._a));
                    if (TextUtils.isEmpty(str)) {
                        str = OaidManager.getMediaOaid();
                    }
                    OaidManager.oaidCallback(str);
                    _a3 _a3Var_a = _a3._a();
                    Context context = _b.this._a;
                    _a3Var_a.getClass();
                    _a3._b = str;
                    try {
                        _kr._a(context, "ptg_ids_sp_oaid", str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }

            public _a(long j) {
                this._a = j;
            }

            @Override // com.fancy._a4
            public final void _a(String str) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        OaidManager.printD("[OaidHelper] oaid为空, 尝试[MsaOaidHelper]方式获取oaid");
                        _g6._a(_b.this._a, new C0378_a());
                    } else {
                        OaidManager.printD("[OaidHelper] oaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a));
                        OaidManager.oaidCallback(str);
                        _a3 _a3Var_a = _a3._a();
                        Context context = _b.this._a;
                        _a3Var_a.getClass();
                        _a3._b = str;
                        try {
                            _kr._a(context, "ptg_ids_sp_oaid", str);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: renamed from: com.fancy.oaid.OaidManager$_b$_b, reason: collision with other inner class name */
        public class C0379_b implements _a4 {
            public final /* synthetic */ long _a;

            public C0379_b(long j) {
                this._a = j;
            }

            @Override // com.fancy._a4
            public final void _a(String str) {
                OaidManager.printD("[GMSADIDHelper] gaid = " + str + "，cost = " + (System.currentTimeMillis() - this._a));
                OaidManager.gaidCallback(str);
                _a3 _a3Var_a = _a3._a();
                Context context = _b.this._a;
                _a3Var_a.getClass();
                _a3._c = str;
                try {
                    _kr._a(context, "ptg_ids_sp_gaid", str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        public _b(Context context) {
            this._a = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str_d;
            String str;
            String str_d2 = "";
            if (OaidManager.canGetOaid()) {
                try {
                    _a3 _a3Var_a = _a3._a();
                    Context context = this._a;
                    _a3Var_a.getClass();
                    if (TextUtils.isEmpty(_a3._b)) {
                        try {
                            str_d = _kr._d(context, "ptg_ids_sp_oaid");
                        } catch (Throwable th) {
                            th.printStackTrace();
                            str_d = "";
                        }
                        _a3._b = str_d;
                    } else {
                        str_d = _a3._b;
                    }
                    if (!TextUtils.isEmpty(str_d)) {
                        OaidManager.oaidCallback(str_d);
                    }
                    if (TextUtils.isEmpty(str_d)) {
                        String mediaOaid = OaidManager.getMediaOaid();
                        if (!TextUtils.isEmpty(mediaOaid)) {
                            OaidManager.oaidCallback(mediaOaid);
                        }
                    }
                    OaidManager.printD("[OaidHelper] 获取oaid");
                    MyOaidHelper.getOAid(this._a, new _a(System.currentTimeMillis()));
                } catch (Exception unused) {
                }
            } else {
                OaidManager.oaidCallback("");
            }
            try {
                _a3 _a3Var_a2 = _a3._a();
                Context context2 = this._a;
                _a3Var_a2.getClass();
                if (TextUtils.isEmpty(_a3._c)) {
                    try {
                        str_d2 = _kr._d(context2, "ptg_ids_sp_gaid");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    _a3._c = str_d2;
                    str = str_d2;
                } else {
                    str = _a3._c;
                }
                if (!TextUtils.isEmpty(str)) {
                    OaidManager.gaidCallback(str);
                }
                new _dw(this._a)._a(new C0379_b(System.currentTimeMillis()));
            } catch (Exception unused2) {
            }
        }
    }

    public class _c implements _a4 {
        public final /* synthetic */ Context _a;
        public final /* synthetic */ _a4 _b;

        public class _a implements _a4 {
            public _a() {
            }

            @Override // com.fancy._a4
            public final void _a(String str) {
                _a3 _a3Var_a = _a3._a();
                Context context = _c.this._a;
                _a3Var_a.getClass();
                _a3._b = str;
                try {
                    _kr._a(context, "ptg_ids_sp_oaid", str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                _c.this._b._a(str);
            }
        }

        public _c(Context context, _a4 _a4Var) {
            this._a = context;
            this._b = _a4Var;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            if (TextUtils.isEmpty(str)) {
                _g6._a(this._a, new _a());
                return;
            }
            _a3 _a3Var_a = _a3._a();
            Context context = this._a;
            _a3Var_a.getClass();
            _a3._b = str;
            try {
                _kr._a(context, "ptg_ids_sp_oaid", str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            this._b._a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean canGetOaid() {
        return Build.VERSION.SDK_INT > 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void gaidCallback(String str) {
        _c7 _c7Var = _n4._a;
        if (_c7Var != null) {
            _c7Var._b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getMediaOaid() {
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
        return ptgCustomController != null ? ptgCustomController.getMediaDeviceOaId() : "";
    }

    public static void getOaidAsync(Context context, _a4 _a4Var) {
        String str_d;
        if (_a4Var == null) {
            return;
        }
        if (!canGetOaid()) {
            _a4Var._a("");
            return;
        }
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
        if (ptgCustomController != null && !ptgCustomController.isAllowSDKObtainOaId()) {
            _a4Var._a(ptgCustomController.getMediaDeviceOaId());
            return;
        }
        _a3._a().getClass();
        if (TextUtils.isEmpty(_a3._b)) {
            try {
                str_d = _kr._d(context, "ptg_ids_sp_oaid");
            } catch (Throwable th) {
                th.printStackTrace();
                str_d = "";
            }
            _a3._b = str_d;
        } else {
            str_d = _a3._b;
        }
        if (!TextUtils.isEmpty(str_d)) {
            _a4Var._a(str_d);
            return;
        }
        AtomicBoolean atomicBoolean = isRequstedOaid;
        if (!atomicBoolean.get()) {
            try {
                atomicBoolean.compareAndSet(false, true);
                MyOaidHelper.safeGetOAid(context, new _c(context, _a4Var));
                return;
            } catch (Exception unused) {
            }
        }
        _a4Var._a("");
    }

    public static synchronized void init(Context context) {
        _d._b(new _b(context));
    }

    public static void initGaid() {
        try {
            new _dw(PtgAdSdk.getContext())._a(new _a(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void oaidCallback(String str) {
        _c7 _c7Var = _n4._a;
        if (_c7Var != null) {
            _c7Var._a = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void printD(String str) {
    }
}
