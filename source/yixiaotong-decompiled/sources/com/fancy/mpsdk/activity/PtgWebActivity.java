package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.fancy._f;
import com.fancy._fn;
import com.fancy._hl;
import com.fancy._i;
import com.fancy._k;
import com.fancy._lq;
import com.fancy._pa;
import com.fancy._s;
import com.fancy.adsdk.lib.utils.TextUtil;
import com.fancy.adsdk.lib.utils._d;
import com.fancy.mpsdk.widget.titlebar.PtgTitleBarWeb;
import com.fancy.mpsdk.widget.web.AdvancedWebView;
import com.stub.StubApp;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgWebActivity extends Activity {
    public static final /* synthetic */ int _g = 0;
    public PtgTitleBarWeb _a;
    public AdvancedWebView _b;
    public ProgressBar _c;
    public String _d;
    public _lq _e;
    public _pa _f;

    static {
        StubApp.interface11(25509);
    }

    public static void _a(Context context, _f _fVar) {
        _i _iVar;
        _s _sVar = new _s();
        if (_fVar != null) {
            _sVar._a = _fVar._i;
            _sVar._d = "1".equals(_fVar._N);
            _sVar._f = _fVar._e;
            _sVar._b = _fVar._q();
            _sVar._e = _fVar._O;
            _i _iVar2 = _fVar._s;
            _sVar._g = _iVar2 != null ? _iVar2._x : null;
            _sVar._h = _fVar._w;
        }
        try {
            Intent intent = new Intent(context, (Class<?>) PtgWebActivity.class);
            intent.setFlags(268435456);
            intent.putExtra("playerInfo", _sVar);
            context.startActivity(intent);
        } catch (Exception unused) {
        }
        if (_fVar == null || (_iVar = _fVar._s) == null) {
            return;
        }
        _iVar._x = null;
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        _fn _fnVar = _fn._b;
        _k _kVar = new _k();
        _kVar._a = 3;
        CopyOnWriteArrayList<_hl<_k>> copyOnWriteArrayList = _fnVar._a.get("splashAdDismiss");
        if (TextUtil.isEmpty(copyOnWriteArrayList)) {
            return;
        }
        Iterator<_hl<_k>> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            it.next()._a(_kVar);
        }
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        com.fancy.adsdk.lib.helper.imp._a _aVar;
        AdvancedWebView advancedWebView;
        super.onActivityResult(i, i2, intent);
        _lq _lqVar = this._e;
        if (_lqVar == null || (_aVar = _lqVar._a) == null || (advancedWebView = _aVar._a) == null) {
            return;
        }
        advancedWebView._a(i, i2, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        if (this._e == null || this._b._b()) {
            _pa _paVar = this._f;
            if (_paVar == null || _paVar._a()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public final void onDestroy() {
        com.fancy.adsdk.lib.helper.imp._a _aVar;
        super.onDestroy();
        _lq _lqVar = this._e;
        if (_lqVar != null && (_aVar = _lqVar._a) != null) {
            try {
                AdvancedWebView advancedWebView = _aVar._a;
                if (advancedWebView != null) {
                    advancedWebView.clearCache(true);
                    _aVar._a.clearHistory();
                    _aVar._a.stopLoading();
                    if (_aVar._a.getSettings() != null) {
                        _aVar._a.getSettings().setJavaScriptEnabled(false);
                    }
                    _aVar._a.setWebViewClient(null);
                    AdvancedWebView advancedWebView2 = _aVar._a;
                    advancedWebView2.getClass();
                    try {
                        ((ViewGroup) advancedWebView2.getParent()).removeView(advancedWebView2);
                    } catch (Exception unused) {
                    }
                    try {
                        advancedWebView2.removeAllViews();
                    } catch (Exception unused2) {
                    }
                    advancedWebView2.destroy();
                    _aVar._a = null;
                }
                _d._a(_aVar._g);
                _aVar._b = null;
                _aVar._c = null;
            } catch (Throwable unused3) {
            }
            _lqVar._a = null;
        }
        this._f = null;
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onResume() {
        super.onResume();
    }
}
