package com.byazt.jd;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.hr.i;
import com.byazt.nr.m;
import com.stub.StubApp;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1500, 15})
public class uj implements ve<i> {
    public Context c;

    public uj(Context context) {
        if (context != null) {
            this.c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.byazt.jd.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public synchronized void tt(i iVar) {
        if (this.c != null && iVar != null) {
            com.byazt.it.ve veVarC = com.byazt.vif.uj.c(null, "gm_pacing_" + iVar.tt());
            String strUj = iVar.uj();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("unity_id", iVar.uj());
                if (!iVar.c()) {
                    jSONObject.put("waterfall_show_rules_version", iVar.n());
                    jSONObject.put("adn_rit_show_rules_version", iVar.a());
                }
                jSONObject.put("timing_mode", iVar.sp());
                jSONObject.put("show_pacing", new StringBuilder().append(iVar.i()).toString());
                jSONObject.put("show_pacing_rule_id", iVar.da());
                jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.U0, new StringBuilder().append(iVar.sl()).toString());
                veVarC.put(strUj, jSONObject.toString());
            } catch (JSONException e) {
                m.c(e);
            }
        }
    }

    @Override // com.byazt.jd.n
    public synchronized i query(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(com.byazt.vif.uj.c(null, "gm_pacing_".concat(String.valueOf(str))).getString(str, ""), false);
    }

    @Override // com.byazt.jd.n
    public synchronized i query(String str, String str2) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(com.byazt.vif.uj.c(null, "gm_pacing_".concat(String.valueOf(str))).getString(str + "_" + str2, ""), true);
    }

    private i c(String str, boolean z) {
        String str2;
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String[] strArrSplit = jSONObject.getString("unity_id").split("_");
            String str3 = strArrSplit.length > 0 ? strArrSplit[0] : "";
            String str4 = strArrSplit.length > 1 ? strArrSplit[1] : "";
            if (z) {
                str2 = "";
                string = str2;
            } else {
                String string2 = jSONObject.getString("waterfall_show_rules_version");
                string = jSONObject.getString("adn_rit_show_rules_version");
                str2 = string2;
            }
            return new i(str3, str4, str2, string, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString(com.hihonor.adsdk.base.g.j.e.a.U0));
        } catch (JSONException e) {
            m.c(e);
            return null;
        }
    }

    @Override // com.byazt.jd.n
    public synchronized void delete(String str) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.c != null && !TextUtils.isEmpty(str)) {
            com.byazt.vif.uj.c(null, "gm_pacing_".concat(String.valueOf(str))).remove(str);
        }
    }

    @Override // com.byazt.jd.n
    public synchronized void delete(String str, String str2) {
        if (str.contains("_")) {
            throw new RuntimeException(" has slotId");
        }
        if (this.c != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.byazt.vif.uj.c(null, "gm_pacing_".concat(String.valueOf(str))).remove(str + "_" + str2);
        }
    }

    @Override // com.byazt.jd.ve
    public synchronized void c(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        i iVarQuery = query(str);
        if (iVarQuery != null) {
            iVarQuery.c(j);
            tt(iVarQuery);
        }
    }

    @Override // com.byazt.jd.ve
    public synchronized void c(String str, String str2, long j) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            i iVarQuery = query(str, str2);
            if (iVarQuery != null) {
                iVarQuery.c(j);
                tt(iVarQuery);
            }
        }
    }
}
