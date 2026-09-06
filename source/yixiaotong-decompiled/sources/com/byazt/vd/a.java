package com.byazt.vd;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1582, 34})
public class a extends c {
    public a(com.byazt.xj.ve veVar, String str, com.byazt.pm.a.c cVar) {
        super(veVar, str, cVar);
    }

    @Override // com.byazt.vd.c
    public void c() {
        if (this.f2812a == null || this.f2812a.size() <= 0) {
            return;
        }
        Object obj = this.f2812a.get("id");
        if (obj == null) {
            c(this.ve);
            return;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            c(this.ve);
            return;
        }
        com.byazt.xj.ve veVarTt = this.ve.tt(this.ve);
        if (veVarTt == null) {
            return;
        }
        c(veVarTt.uj(strValueOf));
    }

    private void c(com.byazt.xj.ve veVar) {
        Object obj;
        if (veVar == null) {
            return;
        }
        for (String str : this.f2812a.keySet()) {
            if (!TextUtils.isEmpty(str) && !TextUtils.equals(str, "id") && (obj = this.f2812a.get(str)) != null) {
                veVar.c(str, String.valueOf(obj));
            }
        }
        veVar.c(this.f2812a.containsKey("width"), this.f2812a.containsKey("height"));
        veVar.tt();
    }
}
