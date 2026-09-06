package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 145})
public class my implements com.byazt.dr.tt {
    public com.byazt.dr.c c;
    public com.byazt.dr.c tt;
    public com.byazt.dr.c ve;

    @Override // com.byazt.dr.tt
    public void c(com.byazt.dr.c cVar) {
        this.c = cVar;
    }

    @Override // com.byazt.dr.tt
    public void tt(com.byazt.dr.c cVar) {
        this.tt = cVar;
    }

    @Override // com.byazt.dr.tt
    public void ve(com.byazt.dr.c cVar) {
        this.ve = cVar;
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC = this.c.c(map);
        if (objC == null) {
            return null;
        }
        if (((Boolean) objC).booleanValue()) {
            return this.tt.c(map);
        }
        return this.ve.c(map);
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.OPERATOR_RESULT;
    }

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c.tt() + "?" + this.tt.tt() + com.huawei.openalliance.ad.constant.x.bQ + this.ve.tt();
    }

    public String toString() {
        return tt();
    }
}
