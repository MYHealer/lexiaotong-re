package com.byazt.yih;

import com.byazt.omf.gt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 730, 34})
public class a implements uj {
    public List<uj> c = new ArrayList();
    public ve tt = new ve(gt.tt().vp());

    public a() {
        this.c.add(new n(this.tt));
        this.c.add(new sp(this.tt));
    }

    @Override // com.byazt.yih.uj
    public boolean c(com.byazt.qt.c cVar) {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().c(cVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.yih.uj
    public boolean tt(com.byazt.qt.c cVar) {
        Iterator<uj> it = this.c.iterator();
        while (it.hasNext()) {
            if (it.next().tt(cVar)) {
                return true;
            }
        }
        return false;
    }
}
