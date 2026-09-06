package com.fancy;

import android.os.Handler;
import com.fancy.adsdk.lib.constants.PtgErrorCode;
import com.fancy.adsdk.lib.utils.Logger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ct implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ AtomicBoolean _b;
    public final /* synthetic */ Handler _c;
    public final /* synthetic */ Runnable _d;
    public final /* synthetic */ _cu._a _e;
    public final /* synthetic */ _cu _f;

    public _ct(_cu _cuVar, String str, AtomicBoolean atomicBoolean, Handler handler, _cs _csVar, _d2 _d2Var) {
        this._f = _cuVar;
        this._a = str;
        this._b = atomicBoolean;
        this._c = handler;
        this._d = _csVar;
        this._e = _d2Var;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        _cu._a _aVar;
        int i;
        _cu _cuVar;
        if (this._f._a.matcher(this._a).matches()) {
            Logger.d("PTG_QM_TAG cut-1");
            if (this._b.getAndSet(true)) {
                return;
            }
            this._c.removeCallbacks(this._d);
            _cu._a(this._f, this._e, 2, -1, "");
            return;
        }
        Logger.d("PTG_QM_TAG cut-2");
        HttpURLConnection httpURLConnection2 = null;
        try {
            try {
                httpURLConnection = (HttpURLConnection) new URL(this._a).openConnection();
                try {
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.setConnectTimeout(2500);
                    httpURLConnection.setReadTimeout(2500);
                    httpURLConnection.connect();
                    String contentType = httpURLConnection.getContentType();
                    String headerField = httpURLConnection.getHeaderField("Content-Disposition");
                    long j_a = _cu._a(httpURLConnection);
                    if (!this._b.get()) {
                        if (!_cu._a(contentType, headerField)) {
                            if (_cu._a(contentType, headerField, j_a)) {
                                Logger.d("PTG_QM_TAG cut-4");
                                this._c.removeCallbacks(this._d);
                                this._b.set(true);
                                _cu _cuVar2 = this._f;
                                _aVar = this._e;
                                i = 2;
                                _cuVar = _cuVar2;
                            }
                            httpURLConnection.disconnect();
                        }
                        Logger.d("PTG_QM_TAG cut-3");
                        this._c.removeCallbacks(this._d);
                        this._b.set(true);
                        _cuVar = this._f;
                        _aVar = this._e;
                        i = 1;
                        _cu._a(_cuVar, _aVar, i, -1, "");
                    }
                    Logger.d("PTG_QM_TAG cut-5");
                    if (!this._b.getAndSet(true)) {
                        this._c.removeCallbacks(this._d);
                        _cu._a(this._f, this._e, 0, PtgErrorCode.SDK_RESOURCE_ERROR, PtgErrorCode.SDK_RESOURCE_ERR_MSG2);
                    }
                } catch (Exception e) {
                    e = e;
                    httpURLConnection2 = httpURLConnection;
                    Logger.d("PTG_QM_TAG cut-6");
                    if (!this._b.getAndSet(true)) {
                        this._c.removeCallbacks(this._d);
                        _cu._a(this._f, this._e, 0, PtgErrorCode.SDK_RESOURCE_ERROR, e.getMessage());
                    }
                    if (httpURLConnection2 == null) {
                        return;
                    } else {
                        httpURLConnection = httpURLConnection2;
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e2) {
            e = e2;
        }
        httpURLConnection.disconnect();
    }
}
