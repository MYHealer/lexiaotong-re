package com.kwad.sdk.utils.c;

import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.utils.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a<T, P> {
    private String bsK;
    private boolean bsL = false;

    protected void b(T t, P p) {
    }

    protected abstract String dataToString(T t);

    protected abstract T iA(String str);

    protected abstract T x(P p);

    public a(String str) {
        this.bsK = str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0010  */
    public final T a(P p, boolean z) {
        T tV;
        if (z) {
            tV = XG();
            if (tV != null) {
                this.bsL = true;
                b(tV, p);
            }
            if (tV == null) {
                tV = v(p);
            }
        } else {
            tV = v(p);
        }
        com.kwad.sdk.core.d.c.d("AbstractFetcher", this.bsK + " fetchData: " + tV + ", isFetchFromCache: " + this.bsL);
        return tV;
    }

    private T v(P p) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        T tX = x(p);
        w(tX);
        com.kwad.sdk.core.d.c.d("AbstractFetcher", this.bsK + " fetchAndSave cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return tX;
    }

    private void w(T t) {
        if (t == null) {
            return;
        }
        ai.h("ksadsdk_long_cost_api_cache", this.bsK, dataToString(t));
    }

    private T XG() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        String strI = ai.i("ksadsdk_long_cost_api_cache", this.bsK, "");
        if (TextUtils.isEmpty(strI)) {
            return null;
        }
        T tIA = iA(strI);
        com.kwad.sdk.core.d.c.d("AbstractFetcher", this.bsK + " readFromLocal cost: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
        return tIA;
    }
}
