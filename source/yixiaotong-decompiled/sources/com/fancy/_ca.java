package com.fancy;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.cdo.oaps.ad.af;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.model.AdLocation;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import com.fancy.oaid.OaidManager;
import com.huawei.openalliance.ad.constant.x;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ca {
    public static _c7 _a;
    public static volatile String[] _b;
    public static volatile Integer _c;
    public static volatile _a7 _d;
    public static final AtomicBoolean _e = new AtomicBoolean(false);
    public static final AtomicLong _f = new AtomicLong(0);
    public static volatile boolean _g = false;
    public static volatile boolean _h = false;
    public static volatile boolean _i = false;

    public class _a implements _a4 {
        public final /* synthetic */ _c _a;

        public _a(_c _cVar) {
            this._a = _cVar;
        }

        @Override // com.fancy._a4
        public final void _a(String str) {
            _c7 _c7Var = _ca._a;
            if (_c7Var != null) {
                if (TextUtils.isEmpty(_c7Var._a)) {
                    _ca._a._a = str;
                }
                if (TextUtil.isEmpty(_ca._a._c) && Build.VERSION.SDK_INT <= 28) {
                    _c7 _c7Var2 = _ca._a;
                    PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
                    _c7Var2._c = ptgCustomController != null ? ptgCustomController.getMediaDeviceImei() : "";
                }
                if (TextUtil.isEmpty(_ca._a._d)) {
                    _c7 _c7Var3 = _ca._a;
                    PtgCustomController ptgCustomController2 = PtgAdSdk.getConfig().getPtgCustomController();
                    _c7Var3._d = (ptgCustomController2 == null || ptgCustomController2.isAllowSDKObtainAndroidId()) ? _c9._a(PtgAdSdk.getContext()) : ptgCustomController2.getMediaAndroidId();
                }
                if (TextUtil.isEmpty(_ca._a._e)) {
                    _c7 _c7Var4 = _ca._a;
                    PtgCustomController ptgCustomController3 = PtgAdSdk.getConfig().getPtgCustomController();
                    _c7Var4._e = ptgCustomController3 != null ? ptgCustomController3.getMediaMacAddress() : "";
                }
                if (TextUtil.isEmpty(_ca._a._b)) {
                    OaidManager.initGaid();
                }
            }
            _c _cVar = this._a;
            if (_cVar != null) {
                _cVar._a();
            }
        }
    }

    public class _b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            boolean z = true;
            try {
                if (PtgAdSdk.getContext() != null) {
                    _ca._g = Settings.Secure.getInt(PtgAdSdk.getContext().getContentResolver(), "development_settings_enabled", 0) > 0;
                }
            } catch (Exception unused) {
            }
            try {
                if (PtgAdSdk.getContext() != null) {
                    _ca._h = Settings.Secure.getInt(PtgAdSdk.getContext().getContentResolver(), "adb_enabled", 0) > 0;
                }
            } catch (Exception unused2) {
            }
            try {
                String property = System.getProperty("http.proxyHost");
                String property2 = System.getProperty("http.proxyPort");
                if (property2 == null) {
                    property2 = "-1";
                }
                int i = Integer.parseInt(property2);
                if (TextUtils.isEmpty(property) || i == -1) {
                    z = false;
                }
                _ca._i = z;
            } catch (Exception unused3) {
            }
            _ca._e.set(false);
        }
    }

    public interface _c {
        void _a();
    }

    public static JSONArray _a() {
        String[] strArr = _b;
        if (strArr == null) {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = Build.SUPPORTED_ABIS;
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
            _b = (String[]) arrayList.toArray(new String[0]);
            strArr = _b;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str2 : strArr) {
            jSONArray.put(str2);
        }
        return jSONArray;
    }

    public static synchronized void _a(_c _cVar) {
        OaidManager.getOaidAsync(PtgAdSdk.getContext(), new _a(_cVar));
    }

    public static _a7 _b() {
        if (_d == null) {
            _d = new _a7();
            _a7 _a7Var = _d;
            if (TextUtils.isEmpty(_a6._c)) {
                try {
                    Context context = PtgAdSdk.getContext();
                    if (context != null) {
                        _a6._c = String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
                    }
                } catch (Exception unused) {
                }
            }
            _a7Var._b = _a6._c;
            _a7 _a7Var2 = _d;
            if (TextUtils.isEmpty(_a6._b)) {
                try {
                    Context context2 = PtgAdSdk.getContext();
                    if (context2 != null) {
                        _a6._b = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                    }
                } catch (Exception unused2) {
                }
            }
            _a7Var2._a = _a6._b;
            _d._c = _a6._a();
            _a7 _a7Var3 = _d;
            if (TextUtils.isEmpty(_a6._d)) {
                try {
                    Context context3 = PtgAdSdk.getContext();
                    if (context3 != null) {
                        _a6._d = context3.getPackageName();
                    }
                } catch (Exception unused3) {
                }
            }
            _a7Var3._d = _a6._d;
        }
        return _d;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01b8 A[Catch: Exception -> 0x01cc, TRY_LEAVE, TryCatch #1 {Exception -> 0x01cc, blocks: (B:98:0x01b2, B:100:0x01b8), top: B:153:0x01b2 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01e5 A[Catch: Exception -> 0x01eb, TRY_LEAVE, TryCatch #3 {Exception -> 0x01eb, blocks: (B:104:0x01df, B:106:0x01e5), top: B:157:0x01df }] */
    /* JADX WARN: Code duplicated, block: B:111:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:119:0x0217  */
    /* JADX WARN: Code duplicated, block: B:127:0x0237  */
    /* JADX WARN: Code duplicated, block: B:153:0x01b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x01df A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:161:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x017f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0186  */
    /* JADX WARN: Code duplicated, block: B:94:0x0195 A[Catch: Exception -> 0x01a5, TRY_LEAVE, TryCatch #5 {Exception -> 0x01a5, blocks: (B:92:0x018f, B:94:0x0195), top: B:161:0x018f }] */
    public static _c7 _c() {
        int i_a;
        int i;
        String str_a;
        String str_a2;
        _c7 _c7Var;
        _c7 _c7Var2;
        _c7 _c7Var3;
        Context context;
        _ov _ovVar;
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        String str;
        if (_a == null) {
            _c7 _c7Var4 = new _c7();
            _a = _c7Var4;
            _c7Var4._f = Build.MANUFACTURER;
            _a._g = Build.MODEL;
            _a._i = Build.VERSION.RELEASE;
            _c7 _c7Var5 = _a;
            _c7Var5._h = 1;
            try {
                i_a = _bo._a(PtgAdSdk.getContext());
            } catch (Exception unused) {
                i_a = 0;
            }
            _c7Var5._j = i_a;
            _c7 _c7Var6 = _a;
            PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
            if (ptgCustomController == null || ptgCustomController.isCanUseCarrier()) {
                try {
                    String simOperator = ((TelephonyManager) PtgAdSdk.getContext().getSystemService("phone")).getSimOperator();
                    if (!TextUtils.isEmpty(simOperator)) {
                        if ("46000".equals(simOperator) || "46002".equals(simOperator) || "46004".equals(simOperator) || "46007".equals(simOperator)) {
                            i = 1;
                        } else if ("46001".equals(simOperator) || "46006".equals(simOperator) || "46009".equals(simOperator)) {
                            i = 2;
                        } else if ("46003".equals(simOperator) || "46005".equals(simOperator) || "46011".equals(simOperator)) {
                            i = 3;
                        } else if ("46020".equals(simOperator)) {
                            i = 4;
                        }
                    }
                } catch (Exception unused2) {
                }
                i = 0;
            } else {
                i = 0;
            }
            _c7Var6._k = i;
            _a._l = _d();
            _c7 _c7Var7 = _a;
            PtgCustomController ptgCustomController2 = PtgAdSdk.getConfig().getPtgCustomController();
            double longitude = 0.0d;
            if (ptgCustomController2 == null || ptgCustomController2.isAllowSDKObtainLocation()) {
                try {
                    _dz _dzVar = new _dz();
                    _dzVar._a = 0.0d;
                    _dzVar._b = 0.0d;
                    _dzVar._c = new Date().getTime() / 1000;
                    _a._m = _dzVar;
                } catch (Exception unused3) {
                }
            } else {
                _dz _dzVar2 = new _dz();
                AdLocation mediaLocation = ptgCustomController2.getMediaLocation();
                if (mediaLocation != null) {
                    _dzVar2._a = mediaLocation.getLatitude();
                    longitude = mediaLocation.getLongitude();
                } else {
                    _dzVar2._a = 0.0d;
                }
                _dzVar2._b = longitude;
                _dzVar2._c = new Date().getTime() / 1000;
                _a._m = _dzVar2;
            }
            _c7 _c7Var8 = _a;
            _c7Var7._m = _c7Var8._m;
            _c7Var8._t = _d();
            _c7 _c7Var9 = _a;
            if (!_mx._i() || (str_a = _ht._a("com.huawei.hwid")) == null) {
                str_a = "";
            }
            _c7Var9._w = str_a;
            _c7 _c7Var10 = _a;
            try {
                if (_mx._i()) {
                    str = x.af;
                } else if (_mx._k()) {
                    str = "com.bbk.appstore";
                } else if (_mx._l()) {
                    str = "com.xiaomi.market";
                } else {
                    if (_mx._j()) {
                        str = Build.VERSION.SDK_INT >= 28 ? af.e : "com.oppo.market";
                    } else {
                        str_a2 = "";
                    }
                    if (str_a2 == null) {
                        str_a2 = "";
                    }
                    _c7Var10._x = str_a2;
                    _c7Var = _a;
                    if (_c7Var != null) {
                        if (TextUtils.isEmpty(_a6._b)) {
                            try {
                                context3 = PtgAdSdk.getContext();
                                if (context3 != null) {
                                    _a6._b = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0).versionName;
                                }
                            } catch (Exception unused4) {
                            }
                        }
                        _c7Var._r = _a6._b;
                        if (TextUtils.isEmpty(_a6._c)) {
                            try {
                                context4 = PtgAdSdk.getContext();
                                if (context4 != null) {
                                    _a6._c = String.valueOf(context4.getPackageManager().getPackageInfo(context4.getPackageName(), 0).versionCode);
                                }
                            } catch (Exception unused5) {
                            }
                        }
                        _c7Var._s = _a6._c;
                        _c7Var._p = _a6._a();
                        if (TextUtils.isEmpty(_a6._d)) {
                            try {
                                context5 = PtgAdSdk.getContext();
                                if (context5 != null) {
                                    _a6._d = context5.getPackageName();
                                }
                            } catch (Exception unused6) {
                            }
                        }
                        _c7Var._q = _a6._d;
                    }
                    _c7Var2 = _a;
                    if (PtgAdSdk.getContext() != null) {
                        _ovVar = new _ov(_c7Var2);
                        AtomicBoolean atomicBoolean = _ox._a;
                        context2 = PtgAdSdk.getContext();
                        if (context2 == null && _ox._b.get() <= 3 && _ox._a.compareAndSet(false, true)) {
                            com.fancy.adsdk.lib.utils._d._b(new _ow(context2, _ovVar));
                        } else {
                            _ox._a(_ovVar, "");
                        }
                    }
                    _c7Var3 = _a;
                    context = PtgAdSdk.getContext();
                    if (context != null && _c7Var3 != null) {
                        try {
                            ScreenUtils.buildScreenInfo(context, _c7Var3);
                            _c7Var3._y = _cb._a(context) ? 2 : 1;
                        } catch (Exception unused7) {
                        }
                    }
                    com.fancy.adsdk.lib.utils._d._b(new _c8(_a));
                }
                str_a2 = _ht._a(str);
                if (str_a2 == null) {
                    str_a2 = "";
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            _c7Var10._x = str_a2;
            _c7Var = _a;
            if (_c7Var != null) {
                if (TextUtils.isEmpty(_a6._b)) {
                    context3 = PtgAdSdk.getContext();
                    if (context3 != null) {
                        _a6._b = context3.getPackageManager().getPackageInfo(context3.getPackageName(), 0).versionName;
                    }
                }
                _c7Var._r = _a6._b;
                if (TextUtils.isEmpty(_a6._c)) {
                    context4 = PtgAdSdk.getContext();
                    if (context4 != null) {
                        _a6._c = String.valueOf(context4.getPackageManager().getPackageInfo(context4.getPackageName(), 0).versionCode);
                    }
                }
                _c7Var._s = _a6._c;
                _c7Var._p = _a6._a();
                if (TextUtils.isEmpty(_a6._d)) {
                    context5 = PtgAdSdk.getContext();
                    if (context5 != null) {
                        _a6._d = context5.getPackageName();
                    }
                }
                _c7Var._q = _a6._d;
            }
            _c7Var2 = _a;
            if (PtgAdSdk.getContext() != null) {
                _ovVar = new _ov(_c7Var2);
                AtomicBoolean atomicBoolean2 = _ox._a;
                context2 = PtgAdSdk.getContext();
                if (context2 == null) {
                    _ox._a(_ovVar, "");
                } else {
                    com.fancy.adsdk.lib.utils._d._b(new _ow(context2, _ovVar));
                }
            }
            _c7Var3 = _a;
            context = PtgAdSdk.getContext();
            if (context != null) {
                ScreenUtils.buildScreenInfo(context, _c7Var3);
                _c7Var3._y = _cb._a(context) ? 2 : 1;
            }
            com.fancy.adsdk.lib.utils._d._b(new _c8(_a));
        }
        if (TextUtils.isEmpty(_a._u)) {
            _c7 _c7Var11 = _a;
            PtgCustomController ptgCustomController3 = PtgAdSdk.getConfig().getPtgCustomController();
            _c7Var11._u = ptgCustomController3 != null ? ptgCustomController3.getAliBoot() : "";
        }
        if (TextUtils.isEmpty(_a._v)) {
            _c7 _c7Var12 = _a;
            PtgCustomController ptgCustomController4 = PtgAdSdk.getConfig().getPtgCustomController();
            _c7Var12._v = ptgCustomController4 != null ? ptgCustomController4.getAliUpdate() : "";
        }
        return _a;
    }

    public static String _d() {
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
        if (ptgCustomController != null && !ptgCustomController.isCanUseCarrier()) {
            return "";
        }
        Context context = PtgAdSdk.getContext();
        if (TextUtils.isEmpty(_bo._a) && System.currentTimeMillis() - _bo._b >= 30000) {
            _bo._b = System.currentTimeMillis();
            try {
                _bo._a = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            } catch (Exception unused) {
            }
        }
        return _bo._a;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public static int _e() {
        int i;
        Integer num = _c;
        if (num != null) {
            return num.intValue();
        }
        try {
            if (Process.is64Bit()) {
                i = 64;
            } else {
                i = 32;
            }
        } catch (Throwable unused) {
            String property = System.getProperty("os.arch");
            if (property != null && property.contains("64")) {
                i = 64;
            }
        }
        _c = Integer.valueOf(i);
        return i;
    }

    public static void _f() {
        AtomicBoolean atomicBoolean = _e;
        if (atomicBoolean.get()) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong = _f;
        if (jCurrentTimeMillis - atomicLong.get() < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            return;
        }
        atomicBoolean.set(true);
        atomicLong.set(jCurrentTimeMillis);
        com.fancy.adsdk.lib.utils._d._b(new _b());
    }
}
