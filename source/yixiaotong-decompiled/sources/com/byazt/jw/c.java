package com.byazt.jw;

import android.text.TextUtils;
import com.byazt.nr.m;
import com.byazt.pm.a;
import com.byazt.xj.ve;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1216, 20})
public class c extends com.byazt.vd.c {
    public c(ve veVar, String str, a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        ve veVarTt;
        int i;
        if (this.f2812a == null || this.f2812a.size() <= 0 || (obj = this.f2812a.get("id")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = this.ve.tt(this.ve)) == null) {
            return;
        }
        ve veVarUj = veVarTt.uj(strValueOf);
        if (veVarUj instanceof com.byazt.yn.c) {
            com.byazt.yn.c cVar = (com.byazt.yn.c) veVarUj;
            int i2 = 4;
            int i3 = 3;
            try {
                i2 = Integer.parseInt(String.valueOf(this.f2812a.get(Constant.KEY_COL)));
                i3 = Integer.parseInt(String.valueOf(this.f2812a.get(Constant.KEY_ROW)));
                i = Integer.parseInt(String.valueOf(this.f2812a.get("duration")));
            } catch (Exception e) {
                m.c(e);
                i = 600;
            }
            cVar.c(i2, i3, i);
        }
    }
}
