package com.fancy;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.core.net.NetUtils;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.mpsdk.activity.PtgWebActivity;
import com.kwad.components.offline.api.IOfflineCompo;
import com.stub.StubApp;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fj {
    public AdSlot _a;
    public _f _b;
    public String _c;
    public boolean _d;
    public boolean _e;
    public boolean _f = true;
    public int _g = 0;
    public boolean _h = false;
    public int _i = -1;
    public int _j = -1;
    public final AtomicBoolean _k = new AtomicBoolean();
    public String _l = "M09oIE5lNg9lPFVpPFUiMUB4N0ZjIFgiGm5BFw==";
    public String _m = "M09oIE5lNg9lPFVpPFUiM0J4O05ifGxNG28=";
    public String _n = "OlV4Ig==";
    public String _o = "OlV4IlI=";
    public String _p = "Jkh4PkQ=";
    public String _q = "M0VoFE1tNVI=";
    public String _r = "IVVtIFVNMVVlJEh4O0R/";
    public String _s = "MVNpM1VpEUljPVJpIA==";
    public String _t = "IVVtIFVNMVVlJEh4Kw==";
    public final AtomicBoolean _u = new AtomicBoolean();

    public static void _a(_f _fVar, Intent intent) {
        if (_fVar != null) {
            try {
                String str = _fVar._e;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + str));
                intent.putExtra("android.intent.extra.REFERRER_NAME", "android-app://" + str);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean _a(String str) {
        try {
            String str2 = (String) Class.forName(_lv._a("M09oIE5lNg9jIQ9OJ0hgNg==")).getField(_lv._a("EHNNHGU=")).get(null);
            return !TextUtils.isEmpty(str2) && str2.equalsIgnoreCase(_lv._a(str));
        } catch (Exception unused) {
            return false;
        }
    }

    public final void _a(Activity activity, Intent intent, boolean z) {
        try {
            if (z) {
                if (this._g == 3) {
                    this._h = true;
                }
                this._g = 1;
                if (_a(activity, intent)) {
                    return;
                } else {
                    this._g = 2;
                }
            } else {
                this._g = 0;
            }
            intent.addFlags(268468224);
            activity.startActivity(intent);
            this._j = IOfflineCompo.Priority.HIGHEST;
        } catch (Exception unused) {
        }
    }

    public final void _a(_f _fVar, AdSlot adSlot) {
        this._a = adSlot;
        this._b = _fVar;
    }

    public final void _b(Activity activity) {
        try {
            _f _fVar = this._b;
            String str = _fVar != null ? _fVar._d : "";
            if (TextUtils.isEmpty(str)) {
                this._j = -4102;
                _a(activity);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            ResolveInfo resolveInfoResolveActivity = activity.getPackageManager().resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null) {
                this._j = -4103;
                _a(activity);
                return;
            }
            ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
            if (activityInfo != null) {
                this._c = activityInfo.packageName;
            }
            _a(this._b, intent);
            _f _fVar2 = this._b;
            _s _sVar = new _s();
            _sVar._c = str;
            if (_fVar2 != null) {
                _sVar._h = _fVar2._w;
            }
            if (_fVar2 != null) {
                _sVar._d = "1".equals(_fVar2._N);
                _sVar._f = _fVar2._e;
                _sVar._b = _fVar2._q();
                _sVar._e = _fVar2._O;
                _sVar._i = _fVar2._W;
            }
            if (!_sVar._d || TextUtils.isEmpty(_sVar._e)) {
                _a(activity, intent, this._b._q());
            } else {
                _b(activity, intent, _sVar);
            }
        } catch (Exception unused) {
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        }
    }

    public final void _c(Activity activity) {
        try {
            Window window = activity.getWindow();
            try {
                window.requestFeature(1);
            } catch (Exception unused) {
            }
            ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.hide();
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setDimAmount(0.0f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 0.0f;
            window.setAttributes(attributes);
        } catch (Exception unused2) {
        }
    }

    public final void _a(Activity activity) {
        try {
            _a();
            _f _fVar = this._b;
            if (_fVar != null && _fVar._s()) {
                this._f = false;
                _f _fVar2 = this._b;
                if (_fVar2 != null && !TextUtils.isEmpty(_fVar2._i)) {
                    PtgWebActivity._a(activity, this._b);
                }
            }
            if (activity.isFinishing()) {
                return;
            }
            activity.finish();
        } catch (Throwable unused) {
        }
    }

    public final void _a(Activity activity, Intent intent, _s _sVar) {
        if (_sVar == null) {
            return;
        }
        try {
            if (activity.getPackageManager().resolveActivity(intent, 65536) == null) {
                return;
            }
            if (_sVar._d && !TextUtils.isEmpty(_sVar._e)) {
                _b(activity, intent, _sVar);
            } else {
                _a(activity, intent, _sVar._b);
            }
        } catch (Exception unused) {
        }
    }

    public final boolean _a(Context context, Intent intent) {
        if (context != null) {
            try {
                String action = intent.getAction();
                Set<String> categories = intent.getCategories();
                if (categories != null && categories.contains(_lv._a(this._l)) && _lv._a(this._m).equals(action)) {
                    return false;
                }
                Uri data = intent.getData();
                String scheme = data != null ? data.getScheme() : "";
                if (!_lv._a(this._n).equals(scheme) && !_lv._a(this._o).equals(scheme)) {
                    if (!_a("OlRtJURl") && !_a("Ok5iPVM=") && !_a("PVF8PQ==") && !_a("JEh6PQ==") && (_a("KkhtPUxl") || _a("IERoP0g="))) {
                        try {
                            Intent.class.getMethod(_lv._a(this._q), Integer.TYPE).invoke(intent, 268468224);
                            Array.set(Array.newInstance((Class<?>) Intent.class, 1), 0, intent);
                            Context.class.getMethod(_lv._a(this._r), Intent[].class).invoke(context, new Intent[]{intent});
                            this._j = IOfflineCompo.Priority.HIGHEST;
                            return true;
                        } catch (Exception unused) {
                            return false;
                        }
                    }
                    Intent intent2 = (Intent) Intent.class.getMethod(_lv._a(this._s), Intent.class, CharSequence.class).invoke(null, intent, _lv._a(this._p));
                    Intent.class.getMethod(_lv._a(this._q), Integer.TYPE).invoke(intent2, 268468224);
                    Context.class.getMethod(_lv._a(this._t), Intent.class).invoke(context, intent2);
                    this._j = IOfflineCompo.Priority.HIGHEST;
                    return true;
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    public final void _a() {
        AdSlot adSlot;
        _ci _ciVar_i;
        _f _fVar = this._b;
        if (_fVar == null || !_fVar._P || (adSlot = this._a) == null || (_ciVar_i = adSlot._i()) == null || !this._u.compareAndSet(false, true)) {
            return;
        }
        try {
            _os _osVar = new _os(_ciVar_i._c, _ciVar_i._e(), this._a);
            _osVar._c = "dps";
            _or _orVar_b = _osVar._b();
            _orVar_b._i(PtgAdSdk.getConfig().getMediaId());
            _orVar_b._f(_ciVar_i._c);
            _orVar_b._e(_ciVar_i._e());
            _orVar_b._b(_ciVar_i._h);
            _orVar_b._a(_ciVar_i._i);
            _orVar_b._n(this._a.getUserID());
            _orVar_b._m(this._a.getPtgSlotID());
            _orVar_b._c(_ciVar_i._S);
            _orVar_b._d(_ciVar_i._e);
            int i = this._g;
            boolean z = this._h;
            int i2 = this._i;
            int i3 = this._j;
            try {
                synchronized (_orVar_b._a) {
                    _orVar_b._a.put("linkMode", i);
                    _orVar_b._a.put("backToOld", z);
                    _orVar_b._a.put("newLinkCode", i2);
                    _orVar_b._a.put("linkCode", i3);
                }
            } catch (Exception e) {
                Error error = _orVar_b._b;
                if (error != null) {
                    error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                }
            }
            String str_a = _m1._a(PtgAdSdk.config.getBaseTrackingUrl(), _osVar);
            if (TextUtil.isNotEmpty(str_a)) {
                NetUtils._a(str_a);
            }
        } catch (Exception unused) {
        }
    }

    public final void _b(Activity activity, Intent intent, _s _sVar) {
        int iCheckLink;
        if (activity == null || _sVar == null) {
            return;
        }
        if (!_sVar._b) {
            try {
                this._g = 0;
                this._j = IOfflineCompo.Priority.HIGHEST;
                intent.addFlags(268468224);
                activity.startActivity(intent);
                return;
            } catch (Exception unused) {
                return;
            }
        }
        this._g = 3;
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(activity.getApplicationContext());
            String[] strArr = {_sVar._c, _sVar._e, _sVar._f, _sVar._i};
            try {
                _cl._b();
                if (_cl._b) {
                    String[] strArr2 = new String[4];
                    for (int i = 0; i < 4; i++) {
                        String str = strArr[i];
                        if (str == null) {
                            str = "";
                        }
                        strArr2[i] = str;
                    }
                    iCheckLink = Doodle.checkLink(origApplicationContext, strArr2);
                } else {
                    iCheckLink = -3;
                }
            } catch (Throwable unused2) {
                iCheckLink = -4;
            }
            this._i = iCheckLink;
        } catch (Throwable unused3) {
        }
        Log.d("LaunchMangerTag", _ie._a("newCode: ").append(this._i).toString());
        if (this._i != 0) {
            _a(activity, intent, _sVar._b);
        }
    }

    public final void _b() {
        _ci _ciVar_i;
        _or _orVar;
        List<String> list;
        try {
            if (this._b._A && this._k.compareAndSet(false, true)) {
                AdSlot adSlot = this._a;
                if (adSlot != null && adSlot._t() != null && adSlot._i() != null && adSlot._i()._f() != null && (!adSlot._i()._f().isEmpty()) && (_ciVar_i = this._a._i()) != null) {
                    _os _osVar_t = this._a._t();
                    if (_osVar_t != null && (_orVar = _osVar_t._t) != null) {
                        int i = this._g;
                        boolean z = this._h;
                        int i2 = this._i;
                        int i3 = this._j;
                        try {
                            synchronized (_orVar._a) {
                                try {
                                    _orVar._a.put("linkMode", i);
                                    _orVar._a.put("backToOld", z);
                                    _orVar._a.put("newLinkCode", i2);
                                    _orVar._a.put("linkCode", i3);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } catch (Exception e) {
                            Error error = _orVar._b;
                            if (error != null) {
                                error.onError(new AdErrorImpl(10019, e.getMessage(), (Object) null));
                            }
                        }
                    }
                    _ou._a()._a(_ciVar_i._f(), "", this._a._t(), null);
                }
                _f _fVar = this._b;
                if (_fVar != null && (list = _fVar._f) != null && !list.isEmpty()) {
                    List<String> list2 = _fVar._f;
                    HashMap map = new HashMap();
                    if (!TextUtils.isEmpty(_fVar._r)) {
                        map.put("User-Agent", _fVar._r);
                        map.put("Referer", "");
                    }
                    NetUtils._a(list2, (HashMap<String, String>) map);
                    Logger.d("PtgAdTrackManager", "AdTrackManager do clk ", _fVar._f);
                }
                ActionTrackManager actionTrackManager_a = ActionTrackManager._a();
                String str_a = _hr._a(this._b);
                String str = this._c;
                actionTrackManager_a.getClass();
                com.fancy.adsdk.lib.utils._d._b(new _c(actionTrackManager_a, str_a, str));
                _a();
            }
        } catch (Exception unused) {
        }
    }
}
