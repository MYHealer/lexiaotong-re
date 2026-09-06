package com.byazt.vd;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 15})
public class uj extends c {
    @Override // com.byazt.vd.c
    public void tt() {
    }

    public uj(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        Object obj;
        com.byazt.xj.ve veVarTt;
        com.byazt.xj.ve veVarA;
        com.byazt.rb.c cVarDa;
        if (this.f2812a == null || this.f2812a.size() <= 0 || (obj = this.f2812a.get("name")) == null) {
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf) || (veVarTt = this.ve.tt(this.ve)) == null || (veVarA = veVarTt.a(strValueOf)) == null || (cVarDa = veVarA.da(strValueOf)) == null) {
            return;
        }
        cVarDa.tt();
        cVarDa.c(new com.byazt.rb.tt() { // from class: com.byazt.vd.uj.1
            @Override // com.byazt.rb.tt
            public void c() {
            }

            @Override // com.byazt.rb.tt
            public void tt() {
                uj.this.ve();
            }
        });
    }
}
