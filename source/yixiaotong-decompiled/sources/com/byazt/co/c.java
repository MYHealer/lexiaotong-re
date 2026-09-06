package com.byazt.co;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2247, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2052a;
    public String c;
    public final JSONObject n = new JSONObject();
    public long tt;
    public String uj;
    public String ve;

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.f2052a = i;
    }

    public void c(long j) {
        this.tt = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public JSONObject tt() {
        return this.n;
    }

    public void tt(String str) {
        this.ve = str;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public void ve() {
        try {
            this.n.putOpt("duration", Long.valueOf(this.tt));
            if ("d_i0".equals(this.c) || "d_a0".equals(this.c)) {
                this.n.putOpt("data", new JSONObject(this.ve));
            } else {
                this.n.putOpt("data", this.ve);
            }
            this.n.putOpt(MediationConstant.KEY_ERROR_MSG, this.uj);
        } catch (JSONException e) {
            com.byazt.tf.c.c("__kite json error " + e.getMessage());
        }
    }

    public String toString() {
        return "FingerInfo{name='" + this.c + "', duration=" + this.tt + ", data='" + this.ve + "', error='" + this.uj + "'}";
    }
}
