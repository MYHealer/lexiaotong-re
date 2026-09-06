package com.byazt.cv;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 597, 20})
public class c implements com.byazt.oh.uj {
    public com.byazt.pp.tt c;

    public c(com.byazt.pp.tt ttVar) {
        this.c = ttVar;
    }

    @Override // com.byazt.oh.uj
    public String c() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.tt();
        }
        return null;
    }

    @Override // com.byazt.oh.uj
    public String tt() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(ttVar.ve())) {
            return this.c.uj();
        }
        return this.c.ve();
    }

    @Override // com.byazt.oh.uj
    public String ve() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.c();
        }
        return null;
    }

    @Override // com.byazt.oh.uj
    public int uj() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.n();
        }
        return 0;
    }

    @Override // com.byazt.oh.uj
    public String n() {
        com.byazt.pp.tt ttVar = this.c;
        if (ttVar != null) {
            return ttVar.a();
        }
        return null;
    }
}
