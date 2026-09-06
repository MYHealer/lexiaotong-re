package com.byazt.uj;

import android.util.SparseArray;
import android.view.View;
import com.byazt.nr.m;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 15, 13})
public class tt extends ve {
    public tt(com.byazt.wn.tt ttVar, Function<SparseArray<Object>, Object> function) {
        super(ttVar, function);
    }

    @Override // com.byazt.yl.ve
    public View getAdView() {
        return getView();
    }

    public View getView() {
        try {
            if (this.i != null) {
                Object objApply = this.i.apply(com.byazt.yxi.uj.c().c(8113).c(View.class).tt());
                if (objApply instanceof View) {
                    return (View) objApply;
                }
                return null;
            }
        } catch (Exception e) {
            m.c(e);
        }
        return null;
    }
}
