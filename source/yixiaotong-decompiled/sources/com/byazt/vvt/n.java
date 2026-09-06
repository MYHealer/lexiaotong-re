package com.byazt.vvt;

import android.text.TextUtils;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import com.byazt.omf.gr;
import com.byazt.omf.gt;
import com.byazt.ukr.yp;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 210, 46})
public class n {
    public static boolean c(com.byazt.dj.tt ttVar, ic icVar, boolean z) {
        if (!gt.tt().tt(ttVar.uj())) {
            return true;
        }
        if (icVar == null) {
            yp.c().tt(3);
            return false;
        }
        String strRl = ttVar.rl();
        long jB = icVar.b();
        String strY = icVar.y();
        try {
            if (TextUtils.isEmpty(strRl)) {
                yp.c().tt(1);
                return false;
            }
            JSONObject jSONObjectC = com.byazt.by.a.c(new JSONObject(strRl), false, true);
            if (jSONObjectC == null) {
                yp.c().tt(1);
                return false;
            }
            gr.c cVarC = gr.c.c(jSONObjectC, ttVar, null);
            if (cVarC.x == null) {
                yp.c().tt(1);
                return false;
            }
            cVarC.x.c(jSONObjectC);
            List<ic> listTt = cVarC.x.tt();
            if (listTt == null) {
                yp.c().tt(1);
                return false;
            }
            for (ic icVar2 : listTt) {
                if (TextUtils.isEmpty(icVar2.y())) {
                    yp.c().tt(2);
                    return false;
                }
                if (!icVar2.r()) {
                    yp.c().tt(5);
                    return false;
                }
                if (TextUtils.equals(icVar2.y(), strY)) {
                    icVar.eo(icVar2.em());
                    if (icVar.dz() + jB >= System.currentTimeMillis()) {
                        return true;
                    }
                    com.byazt.eti.n.c(z ? 7 : 8).c(ttVar.uj());
                    yp.c().tt(4);
                    return false;
                }
            }
            yp.c().tt(3);
            return false;
        } catch (Exception e) {
            yp.c().tt(1000);
            m.c(e);
            return false;
        }
    }
}
