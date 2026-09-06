package com.byazt.qcl;

import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.x;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 578, 54})
public class ve {
    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ve(tt ttVar, ic icVar, com.byazt.ip.c cVar) {
        if (ttVar != null && cVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String strTt = ttVar.tt();
                String strC = ttVar.c();
                jSONObject.putOpt("lifecycle_id", cVar.c());
                jSONObject.putOpt("type", strTt + x.A + strC);
                jSONObject.putOpt("l_type", strTt);
                jSONObject.putOpt("state", strC);
                jSONObject.putOpt("state_num", uj.c(ttVar));
                if (ttVar.uj() != -1) {
                    jSONObject.putOpt(ba.at, Integer.valueOf(ttVar.uj()));
                }
                jSONObject.putOpt("ts", Long.valueOf(ttVar.ve()));
                if (icVar != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("aid", icVar.uj());
                    jSONObject2.putOpt(ba.D, icVar.gu());
                    jSONObject2.putOpt("req_id", icVar.qy());
                    if (cVar.sp > 0) {
                        jSONObject2.putOpt("ad_type", Integer.valueOf(cVar.sp));
                    }
                    jSONObject.putOpt("material", jSONObject2);
                }
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void c(final tt ttVar, final ic icVar, final com.byazt.ip.c cVar) {
        if (gt.tt().ge()) {
            com.byazt.jze.tt.c().post(new Runnable() { // from class: com.byazt.qcl.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObjectVe = ve.ve(ttVar, icVar, cVar);
                        if (jSONObjectVe != null) {
                            com.byazt.feb.c.c().c(jSONObjectVe);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
