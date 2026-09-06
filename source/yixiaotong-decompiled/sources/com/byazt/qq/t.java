package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 66})
public class t extends c {
    @Override // com.byazt.qq.tt
    public int sp() {
        return 1;
    }

    public t(Activity activity, ic icVar, g gVar) {
        super(activity, icVar, gVar);
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "距离领取奖励还剩");
            jSONObject.put("number", this.c);
            jSONObject.put("number_unit", "秒");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }
}
