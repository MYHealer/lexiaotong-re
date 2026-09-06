package com.byazt.qx;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 72})
public class da extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.ete.ic c;
    public com.byazt.omf.d tt;
    public String ve;

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        nuVar.c("getEstimatedInteractionAreaInfo", (com.byazt.pct.n<?, ?>) new da(icVar, dVar, "getEstimatedInteractionAreaInfo"));
        nuVar.c("interactionAreaInfo", (com.byazt.pct.n<?, ?>) new da(icVar, dVar, "interactionAreaInfo"));
    }

    public da(com.byazt.ete.ic icVar, com.byazt.omf.d dVar, String str) {
        this.c = icVar;
        this.tt = dVar;
        this.ve = str;
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.ete.m mVarC;
        com.byazt.ete.m mVarC2;
        JSONObject jSONObject2;
        com.byazt.sy.i iVarVe = this.tt.ve();
        String str = this.ve;
        str.hashCode();
        if (str.equals("interactionAreaInfo")) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("areas");
            if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0 || (jSONObject2 = jSONArrayOptJSONArray.getJSONObject(0)) == null) {
                mVarC = null;
                mVarC2 = null;
            } else {
                mVarC = com.byazt.ete.m.c(jSONObject2);
                if (iVarVe != null) {
                    iVarVe.setEasyPlayInteractionAreaInfo(mVarC);
                    mVarC2 = com.byazt.ete.m.c(iVarVe.getEstimatedInteractionAreaInfo());
                } else {
                    mVarC2 = null;
                }
            }
            if (mVarC2 == null) {
                if (iVarVe != null) {
                    iVarVe.c(com.byazt.ete.m.tt(null, mVarC), 1.0d);
                    this.tt.tt("canMakeVisiable", (JSONObject) null);
                }
            } else if (mVarC == null) {
                iVarVe.c(null, -1.0d);
                iVarVe.ve();
                this.tt.tt("expressWebviewRecycle", (JSONObject) null);
            } else {
                double dC = com.byazt.ete.m.c(mVarC2, mVarC);
                double d = mVarC.ve * mVarC.uj;
                double d2 = mVarC2.ve * mVarC2.uj;
                if (d2 == 0.0d) {
                    iVarVe.c(com.byazt.ete.m.tt(mVarC2, mVarC), 1.0d);
                    this.tt.tt("canMakeVisiable", (JSONObject) null);
                    return null;
                }
                if (d == 0.0d) {
                    iVarVe.c(null, -1.0d);
                    iVarVe.ve();
                    this.tt.tt("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                double d3 = dC / d;
                boolean z = d3 >= 0.8d;
                com.byazt.nr.m.c("xeasy", "A:" + d2 + " B:" + d + " o:" + dC + " R:" + d3);
                if (!z) {
                    iVarVe.c(null, -1.0d);
                    iVarVe.ve();
                    this.tt.tt("expressWebviewRecycle", (JSONObject) null);
                    return null;
                }
                iVarVe.c(com.byazt.ete.m.tt(mVarC2, mVarC), (dC - d2) / d2);
                this.tt.tt("canMakeVisiable", (JSONObject) null);
                return null;
            }
        } else if (str.equals("getEstimatedInteractionAreaInfo") && iVarVe != null) {
            return iVarVe.getEstimatedInteractionAreaInfo();
        }
        return null;
    }
}
