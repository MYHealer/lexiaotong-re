package com.byazt.pik;

import android.text.TextUtils;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 903, 20})
public class c {
    public String c;
    public String tt;
    public String uj;
    public uj ve;

    public String c() {
        return this.c;
    }

    public void c(uj ujVar) {
        this.ve = ujVar;
    }

    public void c(String str) {
        this.c = str;
    }

    public String tt() {
        return this.tt;
    }

    public void tt(String str) {
        this.tt = str;
    }

    public String uj() {
        return this.uj;
    }

    public uj ve() {
        return this.ve;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public boolean c(JSONObject jSONObject) {
        String strUj = uj();
        if (TextUtils.isEmpty(strUj)) {
            return true;
        }
        try {
            Object objC = com.byazt.kx.c.c(com.byazt.jze.tt.c(strUj)).c(jSONObject);
            return objC != null && Boolean.TRUE.equals(objC);
        } catch (Exception e) {
            m.ve("TTFeatureAggregate", "匹配filter失败: ".concat(String.valueOf(strUj)), e);
            return false;
        }
    }
}
