package com.byazt.jv;

import com.byazt.bwm.i;
import com.byazt.dna.qp;
import com.byazt.omf.gt;
import com.byazt.omf.p;
import com.byazt.ut.uj;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1364, 20})
public class c {
    public static volatile boolean c;
    public static boolean tt;

    public static void c() {
        if (tt) {
            return;
        }
        tt = true;
        i iVar = i.tt;
        iVar.c(11);
        iVar.uj(p.c());
        iVar.ve(true);
        iVar.c(true);
        iVar.tt(true);
    }

    public static void tt() {
        JSONObject jSONObjectF = gt.tt().f();
        if (jSONObjectF == null) {
            return;
        }
        ((qp) uj.getService("thread_service")).updateSettings(jSONObjectF);
        c = jSONObjectF.optBoolean("can_set_crash", true);
    }
}
