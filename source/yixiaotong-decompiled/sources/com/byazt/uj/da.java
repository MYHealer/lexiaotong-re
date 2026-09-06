package com.byazt.uj;

import android.util.SparseArray;
import android.view.ViewGroup;
import com.byazt.nr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 72})
public class da extends ve {
    public da(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
    }

    @Override // com.byazt.yl.ve
    public void showSplashAd(ViewGroup viewGroup) {
        try {
            showAd(viewGroup);
        } catch (Exception e) {
            m.c(e);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        if (this.x != null) {
            this.x.mediationCallShow();
        }
        if (this.i != null) {
            this.i.apply(com.byazt.yxi.uj.c().c(6152).c(20060, viewGroup).c(Void.class).tt());
        }
    }
}
