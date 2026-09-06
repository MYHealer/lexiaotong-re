package com.byazt.lu;

import com.byazt.yv.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 54})
public class ve extends tt {
    @Override // com.byazt.lu.tt
    public String uj() {
        return "c";
    }

    public ve(uj ujVar) {
        super(ujVar);
    }

    @Override // com.byazt.lu.tt
    public long c() {
        return this.c.ve().x() + 21600000;
    }

    @Override // com.byazt.lu.tt
    public long[] tt() {
        return n.ve;
    }

    @Override // com.byazt.lu.tt
    public boolean ve() throws JSONException {
        JSONObject jSONObjectC = this.c.uj().c();
        if (this.c.uj().t() == 0 || jSONObjectC == null || this.c.ve().x() + 21600000 > System.currentTimeMillis()) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("header", jSONObjectC);
        jSONObject.put("_gen_time", System.currentTimeMillis());
        JSONObject jSONObjectTt = com.byazt.mp.c.tt(com.byazt.mp.c.c(com.byazt.mp.tt.c(this.c.getContext(), this.c.uj().c(), this.c.sp().ve(), true, com.byazt.gj.c.uj()), com.byazt.mp.c.ve), jSONObject);
        com.byazt.gj.c.t().c(!u.c(jSONObjectTt, this.c.ve().sp()), jSONObjectTt);
        if (jSONObjectTt == null) {
            return false;
        }
        this.c.ve().c(jSONObjectTt);
        return true;
    }
}
