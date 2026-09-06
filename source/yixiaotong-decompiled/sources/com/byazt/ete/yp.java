package com.byazt.ete;

import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 215})
public class yp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2207a;
    public long c;
    public long da;
    public String i;
    public String m;
    public boolean n;
    public String nu;
    public String rh;
    public long sl;
    public int sp;
    public int t;
    public String tt;
    public long u;
    public long uj;
    public String ve;
    public long x;
    public String yp;
    public String z;

    public void c(int i) {
        this.f2207a = i;
    }

    public void c(long j) {
        this.sl = j;
    }

    public void c(String str) {
        this.rh = str;
    }

    public void c(boolean z) {
        this.n = z;
    }

    public int getType() {
        return this.sp;
    }

    public boolean tt(boolean z) {
        int i;
        boolean z2 = this.n && this.sl > 0;
        if (z) {
            if (z2 && ((i = this.f2207a) == 0 || i == 5)) {
                return true;
            }
        } else if (z2 && this.f2207a == 5) {
            return true;
        }
        return false;
    }

    public String uj() {
        return this.rh;
    }

    public int ve() {
        return this.f2207a;
    }

    public static yp c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        yp ypVar = new yp();
        ypVar.c = jSONObject.optLong(PtgRewardConstant.REWARD_PARAMS.USER_ID);
        ypVar.tt = jSONObject.optString("coupon_meta_id");
        ypVar.ve = jSONObject.optString("unique_id");
        ypVar.uj = jSONObject.optLong("device_id");
        ypVar.n = jSONObject.optBoolean("has_coupon");
        ypVar.f2207a = jSONObject.optInt("coupon_scene");
        ypVar.sp = jSONObject.optInt("type");
        ypVar.x = jSONObject.optLong("threshold");
        ypVar.i = jSONObject.optString("scene_key");
        ypVar.da = jSONObject.optLong(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID);
        ypVar.sl = jSONObject.optLong("amount");
        ypVar.t = jSONObject.optInt("action");
        ypVar.u = jSONObject.optLong("style");
        ypVar.yp = jSONObject.optString(com.umeng.analytics.pro.d.p);
        ypVar.z = jSONObject.optString("expire_time");
        ypVar.m = jSONObject.optString("button_text");
        ypVar.nu = jSONObject.optString("extra");
        ypVar.rh = jSONObject.optString("toast");
        return ypVar;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.c);
            jSONObject.put("coupon_meta_id", this.tt);
            jSONObject.put("unique_id", this.ve);
            jSONObject.put("device_id", this.uj);
            jSONObject.put("has_coupon", this.n);
            jSONObject.put("coupon_scene", this.f2207a);
            jSONObject.put("type", this.sp);
            jSONObject.put("threshold", this.x);
            jSONObject.put("scene_key", this.i);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.da);
            jSONObject.put("amount", this.sl);
            jSONObject.put("action", this.t);
            jSONObject.put("style", this.u);
            jSONObject.put(com.umeng.analytics.pro.d.p, this.yp);
            jSONObject.put("expire_time", this.z);
            jSONObject.put("button_text", this.m);
            jSONObject.put("extra", this.nu);
            jSONObject.put("toast", this.rh);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, this.c);
            jSONObject.put("coupon_meta_id", this.tt);
            jSONObject.put("unique_id", this.ve);
            jSONObject.put("device_id", this.uj);
            jSONObject.put("type", this.sp);
            jSONObject.put("scene_key", this.i);
            jSONObject.put(ConstantsAPI.WXWebPage.KEY_ACTIVITY_ID, this.da);
            jSONObject.put(oOOOoo00.OooOo0o, this.sl);
            jSONObject.put("threshold", this.x);
            jSONObject.put("extra", this.nu);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }
}
