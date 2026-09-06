package com.byazt.ouc;

import android.content.Context;
import android.view.ViewGroup;
import com.byazt.atv.n;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 162, 54})
public class ve extends n {
    @Override // com.byazt.atv.n, com.byazt.xl.uj
    public int ve() {
        return 8;
    }

    public ve(Context context, ic icVar, com.byazt.atv.tt ttVar, ViewGroup viewGroup) {
        super(context, icVar, ttVar, viewGroup);
    }

    @Override // com.byazt.atv.n
    public JSONObject c() {
        return rh();
    }

    private JSONObject rh() {
        try {
            return new JSONObject(c.c(this.f1982a, this.sp).c(this.f1982a));
        } catch (Throwable th) {
            m.c(th);
            return null;
        }
    }
}
