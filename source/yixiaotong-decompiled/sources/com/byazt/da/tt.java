package com.byazt.da;

import com.byazt.cv.n;
import com.byazt.cv.yp;
import com.byazt.cv.z;
import com.byazt.hz.sp;
import com.byazt.ng.a;
import com.byazt.vx.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 72, 13})
public class tt implements yp {
    public com.byazt.yl.ve c;
    public com.byazt.ll.tt tt;
    public sp ve;

    @Override // com.byazt.cv.yp
    public void c(z zVar) {
    }

    public tt(sp spVar, com.byazt.yl.ve veVar, com.byazt.ll.tt ttVar) {
        this.c = veVar;
        this.tt = ttVar;
        this.ve = spVar;
    }

    @Override // com.byazt.oh.ve
    public boolean c() {
        if (this.c == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c);
        a.c(arrayList, (List<com.byazt.yl.ve>) null, (List<com.byazt.yl.ve>) null, this.tt, 0);
        com.byazt.ll.tt ttVar = this.tt;
        if (ttVar != null) {
            return this.c.isReady(ttVar.gt());
        }
        return false;
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.uj> tt() {
        List<com.byazt.pp.tt> listDa;
        ArrayList arrayList = new ArrayList();
        sp spVar = this.ve;
        if (spVar != null && (listDa = spVar.da()) != null) {
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
        sp spVar = this.ve;
        if (spVar != null && (listSl = spVar.sl()) != null) {
            for (com.byazt.pp.ve veVar : listSl) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt uj() {
        if (this.c == null || !com.byazt.bp.tt.tt().or()) {
            return new n();
        }
        return new com.byazt.cv.a(t.c(this.tt, this.c, false));
    }

    @Override // com.byazt.oh.ve
    public List<com.byazt.oh.tt> n() {
        List<com.byazt.pp.ve> listT;
        ArrayList arrayList = new ArrayList();
        sp spVar = this.ve;
        if (spVar != null && (listT = spVar.t()) != null) {
            for (com.byazt.pp.ve veVar : listT) {
                if (veVar != null) {
                    arrayList.add(new com.byazt.cv.a(veVar));
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.oh.ve
    public com.byazt.oh.tt a() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar == null || !veVar.isHasShowCallback() || com.byazt.vx.z.c()) {
            return new n();
        }
        return new com.byazt.cv.a(t.c(this.tt, this.c, true));
    }

    @Override // com.byazt.cv.yp
    public boolean sp() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.hasDislike();
        }
        return false;
    }

    @Override // com.byazt.cv.yp
    public void c(boolean z) {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.setUseCustomVideo(z);
        }
    }

    @Override // com.byazt.cv.yp
    public boolean x() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            return veVar.isExpressAd();
        }
        return false;
    }

    @Override // com.byazt.cv.yp
    public void i() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.onResume();
        }
    }

    @Override // com.byazt.cv.yp
    public void da() {
        com.byazt.yl.ve veVar = this.c;
        if (veVar != null) {
            veVar.onPause();
        }
    }
}
