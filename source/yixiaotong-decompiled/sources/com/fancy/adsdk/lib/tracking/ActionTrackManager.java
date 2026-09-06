package com.fancy.adsdk.lib.tracking;

import android.content.Context;
import android.text.TextUtils;
import com.fancy._a6;
import com.fancy._c7;
import com.fancy._ca;
import com.fancy._hr;
import com.fancy._if;
import com.fancy._m1;
import com.fancy._n4;
import com.fancy._og;
import com.fancy._oh;
import com.fancy._oi;
import com.fancy._os;
import com.fancy._ou;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils._d;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ActionTrackManager {
    public static volatile ActionTrackManager _a;

    public class _a implements Runnable {
        public final /* synthetic */ String _a;
        public final /* synthetic */ long _b;

        public _a(String str, long j) {
            this._a = str;
            this._b = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            String str = _if._f._a;
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String strReplace = str.replace("__ACTION__", "closeAd");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("reqId", this._a);
                jSONObject.putOpt(CrashHianalyticsData.TIME, Long.valueOf(this._b));
            } catch (Exception unused) {
            }
            String str_a = _hr._a(strReplace.replace("__DATA__", com.fancy.adsdk.lib.utils._a._b(jSONObject.toString())), ActionTrackManager._a(ActionTrackManager.this));
            _ou _ouVar_a = _ou._a();
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._a(str_a);
                return;
            }
            _m1 _m1Var2 = new _m1();
            _ouVar_a._b = _m1Var2;
            _m1Var2._a(str_a);
        }
    }

    public class _b extends _og {
        public _b() {
        }
    }

    public static ActionTrackManager _a() {
        if (_a == null) {
            synchronized (ActionTrackManager.class) {
                if (_a == null) {
                    _a = new ActionTrackManager();
                }
            }
        }
        return _a;
    }

    public static HashMap _a(ActionTrackManager actionTrackManager) {
        actionTrackManager.getClass();
        HashMap map = new HashMap();
        try {
            if (TextUtils.isEmpty(_a6._d)) {
                try {
                    Context context = PtgAdSdk.getContext();
                    if (context != null) {
                        _a6._d = context.getPackageName();
                    }
                } catch (Exception unused) {
                }
            }
            map.put("appPkgName", _a6._d);
            if (TextUtils.isEmpty(_a6._b)) {
                try {
                    Context context2 = PtgAdSdk.getContext();
                    if (context2 != null) {
                        _a6._b = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0).versionName;
                    }
                } catch (Exception unused2) {
                }
            }
            map.put("appVersionName", _a6._b);
            map.put("mpSdkVersionName", PtgAdSdk.getConfig().getSdkVersionName());
            map.put("env", String.valueOf(com.fancy.adsdk.lib.utils._a._b()));
            map.put("support", String.valueOf(PtgAdSdk.getConfig().isSupport()));
            map.put("channel", PtgAdSdk.getConfig().getChannel());
            map.put("abiArr", com.fancy.adsdk.lib.utils._a._a());
            map.put("procBit", String.valueOf(com.fancy.adsdk.lib.utils._a._d()));
            _c7 _c7Var_c = _ca._c();
            if (_c7Var_c != null) {
                map.put("brand", _c7Var_c._f);
                map.put("androidId", _c7Var_c._d);
                map.put("oaid", _c7Var_c._a);
                map.put(a.hnadsv, _c7Var_c._b);
            }
        } catch (Exception unused3) {
        }
        return map;
    }

    public static void simpleGet(String str) {
        try {
            _os _osVar = new _os(_n4._a);
            _osVar._c = str;
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils.simpleGet(str_a);
            }
        } catch (Throwable unused) {
        }
    }

    public static void simplePost(String str, String str2) {
        try {
            _os _osVar = new _os(_n4._a);
            _osVar._c = str;
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils.simplePost(str_a, com.fancy.adsdk.lib.utils._a._a(str2, _oi._a()));
            }
        } catch (Throwable unused) {
        }
    }

    public final void _a(String str, long j) {
        _d._b(new _a(str, j));
    }

    public final void _b() {
        com.fancy.adsdk.lib.tracking._a _aVar;
        if (TextUtils.isEmpty(_if._f._a)) {
            return;
        }
        _oh _ohVar = _oh._a._a;
        _b _bVar = new _b();
        synchronized (_ohVar) {
            if (_ohVar._a == null) {
                _ohVar._a = Collections.synchronizedMap(new HashMap());
            }
            if (TextUtils.isEmpty("sync_status")) {
                if (!TextUtils.isEmpty("sync_status")) {
                    _ohVar._a.put("sync_status", Long.valueOf(System.currentTimeMillis()));
                }
                _aVar = new com.fancy.adsdk.lib.tracking._a(_bVar);
            } else {
                Long l = _ohVar._a.get("sync_status");
                long jLongValue = l == null ? 0L : l.longValue();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jLongValue > 1800000) {
                    _ohVar._a.put("sync_status", Long.valueOf(jCurrentTimeMillis));
                    _aVar = new com.fancy.adsdk.lib.tracking._a(_bVar);
                }
            }
            _d._b(_aVar);
        }
    }
}
