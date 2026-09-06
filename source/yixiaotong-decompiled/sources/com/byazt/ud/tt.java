package com.byazt.ud;

import com.byazt.cv.a;
import com.byazt.cv.n;
import com.byazt.hz.u;
import com.byazt.oh.uj;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 429, 13})
public class tt implements com.byazt.bz.ve {
    public u c;

    public tt(u uVar) {
        this.c = uVar;
    }

    @Override // com.byazt.oh.ve
    public boolean c() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar.rl();
        }
        return false;
    }

    @Override // com.byazt.oh.ve
    public List<uj> tt() {
        List<com.byazt.pp.tt> listDa;
        ArrayList arrayList = new ArrayList();
        u uVar = this.c;
        if (uVar != null && (listDa = uVar.da()) != null) {
            for (com.byazt.pp.tt ttVar : listDa) {
                if (ttVar != null) {
                    arrayList.add(new com.byazt.cv.c(ttVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> ve() {
        List<com.byazt.pp.ve> listSl;
        ArrayList arrayList = new ArrayList();
        u uVar = this.c;
        if (uVar != null && (listSl = uVar.sl()) != null) {
            for (com.byazt.pp.ve veVar : listSl) {
                if (veVar != null) {
                    arrayList.add(new a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt uj() {
        if (this.c != null) {
            return new a(this.c.z());
        }
        return new n();
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> n() {
        List<com.byazt.pp.ve> listT;
        ArrayList arrayList = new ArrayList();
        u uVar = this.c;
        if (uVar != null && (listT = uVar.t()) != null) {
            for (com.byazt.pp.ve veVar : listT) {
                if (veVar != null) {
                    arrayList.add(new a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt a() {
        if (this.c != null) {
            return new a(this.c.f_());
        }
        return new n();
    }

    @Override // com.byazt.bz.ve
    public void sp() {
        u uVar = this.c;
        if (uVar != null) {
            uVar.ve();
        }
    }
}
