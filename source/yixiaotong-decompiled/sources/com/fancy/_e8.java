package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.utils.Logger;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e8 implements _e7 {
    public final /* synthetic */ _hx _a;
    public final /* synthetic */ String _b;
    public final /* synthetic */ _e9 _c;

    public _e8(_e9 _e9Var, _hx _hxVar, String str) {
        this._c = _e9Var;
        this._a = _hxVar;
        this._b = str;
    }

    @Override // com.fancy._e7
    public final void _a(com.fancy.adsdk.lib.core.net._a _aVar) {
        if (!TextUtils.isEmpty(_aVar._e)) {
            _aVar._a.put("Content-Length", String.valueOf(_aVar._e.getBytes(Charset.forName("UTF-8")).length));
        }
        _aVar._a.put("Content-Type", "application/json");
    }

    @Override // com.fancy._e7
    public final void _a(com.fancy.adsdk.lib.core.net._a _aVar, int i, String str) {
        String str_a;
        this._c._c.set(false);
        Logger.d("HttpConfigPolicyLoader:" + String.format("Load with code:%d, result:%s", Integer.valueOf(i), ""));
        if (i != 1) {
            this._a._c(String.format("HttpConfigPolicyLoader Load failed on url:%s", this._b));
            return;
        }
        try {
            str_a = com.fancy.adsdk.lib.utils._a._a(PtgAdSdk.getConfig().getMediaSecret(), _aVar._f);
        } catch (Exception unused) {
            str_a = null;
        }
        if (TextUtils.isEmpty(str_a)) {
            Error error = this._c._a;
            if (error != null) {
                error.onError(new AdErrorImpl(10019, "Policy 文件解析失败", (Object) null));
            }
            this._a._c(String.format("HttpConfigPolicyLoader parsing failed on url:%s", this._b));
            return;
        }
        _cg _cgVar = new _cg();
        _ck _ckVar = new _ck();
        if (!_ckVar._c(str_a)) {
            Error error2 = this._c._a;
            if (error2 != null) {
                error2.onError(new AdErrorImpl(10019, "Policy 数据解析失败", (Object) null));
            }
            this._a._c(String.format("HttpConfigPolicyLoader DispatchSdkConfig Unmarshal Json failed on url:%s, body:%s", this._b, str_a));
            return;
        }
        if (_cgVar._a(str_a, _ckVar)) {
            Logger.i(_ie._a("HttpConfigPolicyLoader policy fetched version: ").append(_ckVar._g).toString());
            this._a._a(_cgVar, _ckVar);
            this._a._b(str_a);
            this._a._a(str_a);
            return;
        }
        Error error3 = this._c._a;
        if (error3 != null) {
            error3.onError(new AdErrorImpl(10019, "Policy 数据解析失败", (Object) null));
        }
        this._a._c(String.format("HttpConfigPolicyLoader DispatchPolicy Unmarshal Json failed on url:%s, body:%s", this._b, str_a));
    }
}
