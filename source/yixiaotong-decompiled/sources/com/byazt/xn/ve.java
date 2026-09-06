package com.byazt.xn;

import android.text.TextUtils;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 873, 54})
public final class ve extends t {
    public uj t;

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.uj c() {
        return this.t;
    }

    public ve(t.c cVar) {
        super(cVar);
        this.t = new uj();
    }

    @Override // com.byazt.gqp.t
    public com.byazt.gqp.tt c(yp ypVar) {
        ypVar.c(this);
        if (ypVar == null || ypVar.tt() == null || ypVar.tt().c() == null || TextUtils.isEmpty(ypVar.tt().c().toString())) {
            return null;
        }
        return new c(ypVar, this.t);
    }
}
