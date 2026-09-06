package com.byazt.lu;

import android.os.Bundle;
import com.byazt.ds.i;
import com.byazt.tv.x;
import com.byazt.yv.da;
import com.byazt.yv.u;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 34})
public class a extends tt {
    public static final long[] tt = {60000};
    public boolean uj;
    public long ve;

    public void c(boolean z) {
        this.uj = z;
    }

    @Override // com.byazt.lu.tt
    public long[] tt() {
        return tt;
    }

    @Override // com.byazt.lu.tt
    public String uj() {
        return "s";
    }

    public a(uj ujVar) {
        super(ujVar);
        this.uj = true;
    }

    @Override // com.byazt.lu.tt
    public long c() {
        long jGr = this.c.ve().gr();
        if (jGr > 60000 || jGr <= 0) {
            jGr = 60000;
        }
        tt[0] = jGr;
        return this.ve + jGr;
    }

    @Override // com.byazt.lu.tt
    public boolean ve() {
        Bundle bundleC;
        long jCurrentTimeMillis = System.currentTimeMillis();
        sp spVarA = this.c.a();
        if (spVarA != null && (bundleC = spVarA.c(jCurrentTimeMillis, 50000L)) != null) {
            com.byazt.gj.c.c("play_session", bundleC, 1);
            com.byazt.gj.c.tt();
        }
        com.byazt.tv.tt ttVarTt = this.c.tt();
        i iVarUj = this.c.uj();
        if (iVarUj.t() != 0) {
            JSONObject jSONObjectVe = u.ve(iVarUj.c());
            if (jSONObjectVe != null) {
                c(ttVarTt.c(jSONObjectVe));
                this.ve = System.currentTimeMillis();
                return true;
            }
            da.tt((Throwable) null);
        }
        return false;
    }

    private void c(ArrayList<x> arrayList) {
        com.byazt.tv.tt ttVarTt = this.c.tt();
        ArrayList<x> arrayList2 = new ArrayList<>();
        ArrayList<x> arrayList3 = new ArrayList<>();
        com.byazt.ds.x xVarVe = this.c.ve();
        ArrayList<x> arrayList4 = new ArrayList();
        if (!arrayList.isEmpty()) {
            arrayList4.addAll(arrayList);
        }
        ArrayList<x> arrayListC = ttVarTt.c();
        if (!arrayListC.isEmpty()) {
            arrayList4.addAll(arrayListC);
        }
        if (arrayList4.size() > 0) {
            for (x xVar : arrayList4) {
                if (xVar.t == null || xVar.t.length <= 0) {
                    arrayList2.add(xVar);
                } else {
                    int iC = this.uj ? com.byazt.mp.c.c(com.byazt.mp.tt.c(this.c, this.c.getContext(), this.c.uj().c()), xVar.t, xVarVe) : 200;
                    if (com.byazt.mp.c.c(iC)) {
                        if (!arrayList.contains(xVar)) {
                            break;
                        }
                        xVar.yp = iC;
                        arrayList3.add(xVar);
                        break;
                    }
                    if (iC == 200) {
                        arrayList2.add(xVar);
                    } else {
                        xVar.yp = iC;
                        arrayList3.add(xVar);
                    }
                }
            }
            if (arrayList2.size() > 0 || arrayList3.size() > 0) {
                ttVarTt.setResult(arrayList2, arrayList3, arrayList);
            }
            da.uj(uj() + PPSLabelView.Code + arrayList2.size() + PPSLabelView.Code + arrayList4.size(), null);
        }
    }
}
