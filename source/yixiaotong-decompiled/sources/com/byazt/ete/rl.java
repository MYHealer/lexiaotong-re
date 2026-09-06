package com.byazt.ete;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, AppTypeIdUtil.Drink4GCostControl_1})
public class rl {
    public int c = 1;
    public int tt = 1;

    public void c(int i) {
        this.c = i;
    }

    public boolean c() {
        return this.c == 1;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public boolean tt() {
        return this.tt == 1;
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.c);
            jSONObject.put("am", this.tt);
        } catch (Exception e) {
            com.byazt.nr.m.ve(e.toString());
        }
        return jSONObject;
    }
}
