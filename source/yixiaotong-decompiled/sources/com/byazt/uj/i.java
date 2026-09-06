package com.byazt.uj;

import android.app.Activity;
import android.util.SparseArray;
import com.byazt.nr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 42})
public class i extends ve {
    public i(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
    }

    @Override // com.byazt.yl.ve
    public void showAd(Activity activity, Object obj, String str) {
        try {
            showAd(activity);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void showAd(Activity activity) {
        if (this.x != null) {
            this.x.mediationCallShow();
        }
        if (this.i != null) {
            this.i.apply(com.byazt.yxi.uj.c().c(8113).c(20033, activity).c(Void.class).tt());
        }
    }
}
