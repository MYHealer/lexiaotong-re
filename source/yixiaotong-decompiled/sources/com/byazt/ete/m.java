package com.byazt.ete;

import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 130})
public class m {
    public double c;
    public double tt;
    public double uj;
    public double ve;

    public boolean c(double d, double d2) {
        double d3 = this.ve;
        if (d3 <= 0.0d) {
            return false;
        }
        double d4 = this.uj;
        if (d4 <= 0.0d) {
            return false;
        }
        double d5 = this.c;
        if (d <= d5 || d >= d5 + d3) {
            return false;
        }
        double d6 = this.tt;
        return d2 > d6 && d2 < d6 + d4;
    }

    public m(double d, double d2, double d3, double d4) {
        this.c = d;
        this.tt = d2;
        this.ve = d3;
        this.uj = d4;
    }

    public static m c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(OapsKey.KEY_POINT);
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray(OapsKey.KEY_SIZE);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() != 2 || jSONArrayOptJSONArray2 == null || jSONArrayOptJSONArray2.length() != 2) {
            return null;
        }
        return new m(jSONArrayOptJSONArray.optDouble(0), jSONArrayOptJSONArray.optDouble(1), jSONArrayOptJSONArray2.optInt(0), jSONArrayOptJSONArray2.optInt(1));
    }

    public static JSONObject c(m mVar) {
        if (mVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(0, mVar.c);
            jSONArray.put(1, mVar.tt);
            jSONObject.put(OapsKey.KEY_POINT, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(0, mVar.ve);
            jSONArray2.put(1, mVar.uj);
            jSONObject.put(OapsKey.KEY_SIZE, jSONArray2);
            return jSONObject;
        } catch (Exception e) {
            com.byazt.nr.m.c("xeasy", "json:" + e.getMessage());
            return null;
        }
    }

    public static double c(m mVar, m mVar2) {
        if (mVar == null || mVar2 == null) {
            return 0.0d;
        }
        double d = mVar.c;
        double d2 = mVar.tt;
        double d3 = mVar.ve + d;
        double d4 = mVar.uj + d2;
        double d5 = mVar2.c;
        double d6 = mVar2.tt;
        double d7 = mVar2.ve + d5;
        double d8 = mVar2.uj + d6;
        double dMax = Math.max(d, d5);
        double dMax2 = Math.max(d2, d6);
        double dMin = (Math.min(d3, d7) - dMax) * (Math.min(d4, d8) - dMax2);
        if (d2 >= d8 || d3 <= d5 || d4 <= d6 || d >= d7) {
            return 0.0d;
        }
        return dMin;
    }

    public static m tt(m mVar, m mVar2) {
        if (mVar == null) {
            return mVar2;
        }
        if (mVar2 == null) {
            return null;
        }
        double d = mVar.c;
        double d2 = mVar.tt;
        double d3 = mVar.ve + d;
        double d4 = mVar.uj + d2;
        double d5 = mVar2.c;
        double d6 = mVar2.tt;
        double d7 = mVar2.ve + d5;
        double d8 = mVar2.uj + d6;
        double dMin = Math.min(d, d5);
        double dMin2 = Math.min(d2, d6);
        return new m(dMin, dMin2, Math.abs(Math.max(d3, d7) - dMin), Math.abs(Math.max(d4, d8) - dMin2));
    }
}
