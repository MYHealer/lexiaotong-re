package com.fancy;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ProgressBar;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.model.AppInfo;
import com.fancy.mpsdk.component.videoplayer.NiceVideoPlayer;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lo implements _pc {
    public final /* synthetic */ _lp _a;

    public _lo(_lp _lpVar) {
        this._a = _lpVar;
    }

    @Override // com.fancy._pc
    public final void _a() {
        _lp._c _cVar = this._a._f;
    }

    @Override // com.fancy._pc
    public final void _b() {
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            boolean z_a = _mt.this._b._c != null ? _c9._a(PtgAdSdk.getContext(), _mt.this._b._c.getPackage_name()) : false;
            _mt _mtVar = _mt.this;
            Object[][] objArr = {new Object[]{"isInstalled", Boolean.valueOf(z_a)}};
            _mtVar.getClass();
            _mtVar._a("onAppInstalledCallback", _mt._a(objArr));
        }
    }

    @Override // com.fancy._pc
    public final void _c() {
        String rewardName;
        int rewardAmount;
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt _mtVar = _mt.this;
            if (_mtVar._k || _mtVar._l) {
                return;
            }
            _f0 _f0Var = _mtVar._d;
            if (_f0Var._f != 1) {
                PtgRewardConstant.ServerErr serverErr = PtgRewardConstant.ServerErr.DEF;
                _mtVar._a(serverErr.getCode(), serverErr.getMsg(), true);
                return;
            }
            _mtVar._l = true;
            AdSlot adSlot = _mtVar._c;
            if (adSlot == null || TextUtils.isEmpty(adSlot.getRewardName())) {
                rewardName = !TextUtils.isEmpty(_f0Var._d) ? _f0Var._d : "";
            } else {
                rewardName = adSlot.getRewardName();
            }
            AdSlot adSlot2 = _mtVar._c;
            _f0 _f0Var2 = _mtVar._d;
            if (adSlot2 != null && adSlot2.getRewardAmount() > 0) {
                rewardAmount = adSlot2.getRewardAmount();
            } else if (_f0Var2 == null || (rewardAmount = _f0Var2._e) <= 0) {
                rewardAmount = 0;
            }
            _m7._a(_mtVar._d._g, _mtVar._c, rewardName, rewardAmount, new _mw(_mtVar));
        }
    }

    @Override // com.fancy._pc
    public final void _d() {
        _lp _lpVar;
        NiceVideoPlayer niceVideoPlayer;
        _lp._c _cVar = this._a._f;
        if (_cVar == null || (_lpVar = _mt.this._a) == null || _lpVar._h || (niceVideoPlayer = _lpVar._a) == null) {
            return;
        }
        if (niceVideoPlayer._l == 4) {
            NiceVideoPlayer._a(new _hf(niceVideoPlayer));
        } else {
            niceVideoPlayer._d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    @Override // com.fancy._pc
    public final void _e() {
        boolean z_a;
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            if (_mt.this._b != null) {
                Context context = PtgAdSdk.getContext();
                _f _fVar = _mt.this._b;
                if (context == null || _fVar == null) {
                    z_a = false;
                } else {
                    try {
                        AppInfo appInfo = _fVar._c;
                        z_a = _d6._a(_d6._a(context, _d6._a((appInfo == null || TextUtils.isEmpty(appInfo.getName())) ? "应用" : _fVar._c.getName(), ".apk")));
                    } catch (Exception unused) {
                        z_a = false;
                    }
                }
            } else {
                z_a = false;
            }
            _mt _mtVar = _mt.this;
            Object[][] objArr = {new Object[]{"isDownloaded", Boolean.valueOf(z_a)}};
            _mtVar.getClass();
            _mtVar._a("onAppDownloadCallback", _mt._a(objArr));
        }
    }

    @Override // com.fancy._pc
    public final void _g() {
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            _mt _mtVar = _mt.this;
            _mtVar._q = true;
            ProgressBar progressBar = _mtVar._o;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            _mt _mtVar2 = _mt.this;
            if (!_mtVar2._f || (_mtVar2._r && _mtVar2._q)) {
                _mtVar2._a("startTime", null);
            }
            _mt._b(_mt.this);
        }
    }

    @Override // com.fancy._pc
    public final void pauseVideo() {
        _lp _lpVar;
        NiceVideoPlayer niceVideoPlayer;
        int i;
        _lp._c _cVar = this._a._f;
        if (_cVar == null || (_lpVar = _mt.this._a) == null || _lpVar._h || (niceVideoPlayer = _lpVar._a) == null || (i = niceVideoPlayer._l) != 3 || i == 7) {
            return;
        }
        niceVideoPlayer.getClass();
        NiceVideoPlayer._a(new _he(niceVideoPlayer));
    }

    @Override // com.fancy._pc
    public final void _a(int i, JSONObject jSONObject) {
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._a(_mt.this, i, jSONObject);
        }
    }

    @Override // com.fancy._pc
    public final void _a(int i) {
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._d _dVar = (_mt._d) _cVar;
            _mt _mtVar = _mt.this;
            _mtVar._p = i;
            if (_mtVar._b == null) {
                return;
            }
            if (i >= 0) {
                _m8 _m8Var_a = _m8._a();
                _mt _mtVar2 = _mt.this;
                _m8Var_a._a(_mtVar2._b._e(), _mt.this._b._e() - i, _mtVar2._e);
            }
            _mt _mtVar3 = _mt.this;
            _l6 _l6Var = _mtVar3._x;
            if (_l6Var != null) {
                if (i != -1 && i != 0) {
                    if (_mtVar3._f) {
                        _f _fVar = _mtVar3._b;
                        _l6Var._a(_fVar, ((long) (_fVar._e() - i)) * 1000);
                        return;
                    } else {
                        _l6Var._a(_mtVar3._b, ((long) i) * 1000);
                        return;
                    }
                }
                _l6Var._a(_mtVar3._b, -1L);
            }
        }
    }

    @Override // com.fancy._pc
    public final void _b(String str) {
        _lp._c _cVar = this._a._f;
        if (_cVar != null) {
            _mt._a(_mt.this);
        }
    }

    @Override // com.fancy._pc
    public final void _a(boolean z) {
        _lp _lpVar;
        _lp._c _cVar = this._a._f;
        if (_cVar == null || (_lpVar = _mt.this._a) == null) {
            return;
        }
        _lpVar.setMute(z);
    }
}
