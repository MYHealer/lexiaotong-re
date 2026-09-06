package com.fancy.adsdk.lib.provider.arb;

import android.os.Handler;
import com.fancy._aa;
import com.fancy._ef;
import com.fancy.adsdk.lib.utils.TextUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ArbitraryAdapter {
    private static IArbitraryCallback iArbitraryCallback;
    public String _a;
    public long _b;
    public long _c;
    public long _d;
    public long _e;
    public long _f;
    public String _g;

    public class _a implements Runnable {
        public final /* synthetic */ _ef _a;

        public _a(_ef _efVar) {
            this._a = _efVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ArbitraryAdapter.this.handleCallback(this._a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCallback(_ef _efVar) {
        long jCallback;
        String key = getKey();
        Long maV = ArbitraryManger.getMaV(key);
        long sdv = getSdv();
        long frv = getFrv();
        long cgv = getCgv();
        try {
            IArbitraryCallback iArbitraryCallback2 = iArbitraryCallback;
            jCallback = iArbitraryCallback2 != null ? iArbitraryCallback2.callback(maV, sdv, frv, cgv) : cgv;
        } catch (Throwable unused) {
        }
        _efVar._a(jCallback);
        try {
            _aa._a(key, getReqId(), maV, sdv, frv, cgv, jCallback);
        } catch (Throwable unused2) {
        }
        ArbitraryManger.remove(key);
    }

    public long getCgv() {
        return this._d;
    }

    public long getFrv() {
        return this._c;
    }

    public String getKey() {
        return this._a;
    }

    public String getReqId() {
        return this._g;
    }

    public long getRts() {
        return this._f;
    }

    public long getSdv() {
        return this._b;
    }

    public void setAdLoadCallback(_ef _efVar) {
        if (_efVar == null) {
            return;
        }
        if (TextUtil.isEmpty(getKey())) {
            _efVar._a(getSdv());
        } else if (getRts() <= 0) {
            handleCallback(_efVar);
        } else {
            new Handler().postDelayed(new _a(_efVar), this._f);
        }
    }

    public void setAdLoaded(long j, long j2, long j3, long j4) {
        this._f = j - (System.currentTimeMillis() - this._e);
        this._b = j2;
        this._c = j3;
        this._d = j4;
    }

    public void setKey(String str) {
        this._a = str;
    }

    public void setReqId(String str) {
        this._g = str;
    }

    public void setSts(long j) {
        this._e = j;
    }
}
