package com.byazt.qq;

import android.app.Activity;
import com.byazt.ete.g;
import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 88, 34})
public class a extends c {
    public int nu;
    public int rh;

    @Override // com.byazt.qq.tt
    public void c(com.byazt.sgn.a aVar) {
    }

    @Override // com.byazt.qq.tt
    public int sp() {
        return 3;
    }

    public a(Activity activity, ic icVar, g gVar) {
        JSONObject jSONObjectTt;
        super(activity, icVar, gVar);
        if (this.i == null || (jSONObjectTt = this.i.tt()) == null) {
            return;
        }
        this.nu = jSONObjectTt.optInt("reduce_time");
        this.rh = jSONObjectTt.optInt("reduce_duration");
    }

    @Override // com.byazt.qq.tt
    public boolean a() {
        return (this.i == null || !this.i.a()) && this.nu > 0 && this.rh > 0 && this.tt < this.rh;
    }

    @Override // com.byazt.qq.c, com.byazt.qq.tt
    public tt.c tt(da daVar) {
        return ve(daVar);
    }

    @Override // com.byazt.qq.tt
    public void uj(da daVar) {
        if (daVar != null) {
            daVar.c(this.nu);
        }
        this.i.c(true);
        if (daVar != null) {
            daVar.c();
        }
    }

    @Override // com.byazt.qq.tt
    public String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("alert_title", "恭喜获得加速特权");
            jSONObject.put("reduce_time", this.nu + "s");
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }
}
