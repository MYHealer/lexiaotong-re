package com.byazt.ete;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.cdo.oaps.ad.OapsKey;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK})
public class sv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2195a;
    public String c;
    public c da;
    public tt i;
    public String n;
    public JSONArray sp;
    public boolean tt;
    public String uj;
    public boolean ve;
    public int x;

    public String a() {
        return this.n;
    }

    public tt da() {
        return this.i;
    }

    public boolean i() {
        return this.x == 2 && this.ve;
    }

    public String n() {
        return this.uj;
    }

    public c sl() {
        return this.da;
    }

    public String sp() {
        return this.f2195a;
    }

    public String tt() {
        return this.c;
    }

    public boolean uj() {
        return this.ve;
    }

    public boolean ve() {
        return this.tt;
    }

    public JSONArray x() {
        return this.sp;
    }

    public static sv c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        sv svVar = new sv();
        svVar.c = jSONObject.optString("promotion_id");
        svVar.tt = jSONObject.optBoolean("is_silent_auth", false);
        svVar.ve = jSONObject.optBoolean("enable_playable_auth", false);
        svVar.uj = jSONObject.optString("aweme_agreements");
        svVar.n = jSONObject.optString("aweme_privacy");
        svVar.f2195a = jSONObject.optString("live_csj_libra_param");
        svVar.sp = jSONObject.optJSONArray("tasks");
        svVar.x = jSONObject.optInt("live_playable");
        svVar.da = c.c(jSONObject.optJSONObject("product"));
        svVar.i = tt.c(jSONObject.optJSONObject("coupon"));
        return svVar;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("promotion_id", this.c);
            jSONObject.put("is_silent_auth", this.tt);
            jSONObject.put("enable_playable_auth", this.ve);
            jSONObject.put("aweme_agreements", this.uj);
            jSONObject.put("aweme_privacy", this.n);
            jSONObject.put("live_csj_libra_param", this.f2195a);
            jSONObject.put("tasks", this.sp);
            jSONObject.put("live_playable", this.x);
            c cVar = this.da;
            if (cVar != null) {
                jSONObject.put("product", cVar.n());
            }
            tt ttVar = this.i;
            if (ttVar != null) {
                jSONObject.put("coupon", ttVar.ve());
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 1626})
    public static class tt {
        public int c;
        public int tt;

        public int c() {
            return this.c;
        }

        public int tt() {
            return this.tt;
        }

        public static tt c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            tt ttVar = new tt();
            ttVar.c = jSONObject.optInt("amount");
            ttVar.tt = jSONObject.optInt("threshold");
            return ttVar;
        }

        public JSONObject ve() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("amount", this.c);
                jSONObject.put("threshold", this.tt);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 8, 1639})
    public static class c {
        public String c;
        public String tt;
        public double uj;
        public double ve;

        public String c() {
            return this.c;
        }

        public String tt() {
            return this.tt;
        }

        public double uj() {
            return this.uj;
        }

        public double ve() {
            return this.ve;
        }

        public static c c(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            c cVar = new c();
            cVar.c = jSONObject.optString("title");
            cVar.tt = jSONObject.optString("image");
            cVar.uj = jSONObject.optDouble(OapsKey.KEY_PRICE);
            cVar.ve = jSONObject.optDouble("origin_price");
            return cVar;
        }

        public JSONObject n() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.c);
                jSONObject.put("image", this.tt);
                jSONObject.put(OapsKey.KEY_PRICE, this.uj);
                jSONObject.put("origin_price", this.ve);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
    }
}
