package com.fancy.adsdk.lib.tracking;

import android.text.TextUtils;
import com.fancy._c6;
import com.fancy._hr;
import com.fancy._if;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a implements Runnable {
    public final /* synthetic */ ActionTrackManager._b _a;

    public _a(ActionTrackManager._b _bVar) {
        this._a = _bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _if._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        new _c6(_hr._a(str.replace("__ACTION__", "syncStatus").replace("__DATA__", com.fancy.adsdk.lib.utils._a._b("{}")), ActionTrackManager._a(ActionTrackManager.this))).execute(new Void[0]);
    }
}
