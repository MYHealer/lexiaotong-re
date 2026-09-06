package com.fancy;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ob implements Runnable {
    public final /* synthetic */ Context _a;
    public final /* synthetic */ _ck _b;

    public _ob(Context context, _ck _ckVar) {
        this._a = context;
        this._b = _ckVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            ArrayList arrayList = _oc._a;
            if (arrayList == null) {
                return;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_ep) it.next())._a(this._a, this._b);
            }
            ArrayList arrayList2 = _oc._a;
        } catch (Exception unused) {
        }
    }
}
