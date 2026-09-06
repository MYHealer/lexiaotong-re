package com.byazt.ete;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, TypedValues.PositionType.TYPE_CURVE_FIT})
public class yf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2206a;
    public String c;
    public String n;
    public String tt;
    public String uj;
    public String ve;

    public String c() {
        return this.tt;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(String str, String str2, String str3, String str4) {
        this.c = str3;
        this.tt = str2;
        this.uj = str;
        this.ve = str4;
    }

    public String tt() {
        return this.c;
    }

    public void tt(String str) {
        this.f2206a = str;
    }

    public yf(String str, String str2, String str3, String str4) {
        this.c = str3;
        this.tt = str2;
        this.uj = str;
        this.ve = str4;
    }

    public String toString() {
        JSONObject jSONObjectVe = ve();
        return jSONObjectVe.length() > 0 ? jSONObjectVe.toString() : "";
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tk", this.c).put("vd", this.uj).put("cr", this.ve).put(NotificationCompat.CATEGORY_ERROR, this.tt);
            if (!TextUtils.isEmpty(this.ve) && this.ve.equals("2")) {
                if (!TextUtils.isEmpty(this.n)) {
                    jSONObject.put("i6", this.n);
                }
                if (!TextUtils.isEmpty(this.f2206a)) {
                    jSONObject.put("prov", this.f2206a);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
