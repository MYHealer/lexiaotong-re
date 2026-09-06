package com.byazt.lw;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 15})
public class uj extends nu {
    public uj() {
        super(com.byazt.zg.ve.EQ);
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC = this.c.c(map);
        Object objC2 = this.tt.c(map);
        if (objC == null && objC2 == null) {
            return Boolean.TRUE;
        }
        if (objC == null && objC2 != null) {
            return Boolean.FALSE;
        }
        if (objC != null && objC2 == null) {
            return Boolean.FALSE;
        }
        if ((objC instanceof Number) && (objC2 instanceof Number)) {
            return Boolean.valueOf(com.byazt.kq.tt.c((Number) objC, (Number) objC2));
        }
        return Boolean.valueOf(objC.equals(objC2));
    }
}
